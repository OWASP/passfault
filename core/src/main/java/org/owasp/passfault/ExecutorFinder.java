/* ©Copyright 2011 Cameron Morris
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.owasp.passfault;

import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is runs all finders in separate threads, in addition it runs one
 * thread to monitor when all finder threads are complete (called the DoneThread)
 *
 * @author cam
 */
public class ExecutorFinder implements PatternFinder {

  private final PatternFinder finder;
  private final ExecutorService exec;
  Map<PasswordResults, Future> jobsMap = new ConcurrentHashMap<PasswordResults, Future>();
  
  public ExecutorFinder(Collection<PatternFinder> finders) {
    this.finder = new SequentialFinder(finders);
    this.exec = Executors.newFixedThreadPool(10);
  }

  @Override
  public void blockingAnalyze(PasswordResults pass) throws Exception {
    Analyze toRun = new Analyze(pass, finder);
    Future result = exec.submit(toRun);
    result.get();
  }

  /**
   * The method returns as soon as all threads have started, not completed.
   * To wait until completion call {#waitForAnalysis} or register an
   * AnalysisListener and implement foundHighestProbablePatterns.
   * @param pass
   * @throws Exception
   */
  @Override
  public void analyze(PasswordResults pass) throws Exception {
    Analyze toRun = new Analyze(pass, finder);
    Future future = exec.submit(toRun);
    jobsMap.put(pass, future);
  }

  /**
   * Blocks until all analysis is complete.
   * @param pass password being analyzed to test for completion
   * @throws InterruptedException
   */
  @Override
  public void waitForAnalysis(PasswordResults pass) throws InterruptedException {
    try {
      Future job = jobsMap.get(pass);
      Object call = job.get();
    } catch (Exception ex) {
      Logger.getLogger(ExecutorFinder.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  static class Analyze implements Callable{
    private final PasswordResults pw;
    private final PatternFinder finder;

    public Analyze(PasswordResults pw, PatternFinder finders){
      this.pw = pw;
      this.finder = finders;
    }

    @Override
    public Object call() throws Exception {
      finder.analyze(pw);
      finder.waitForAnalysis(pw);
      return pw;  
    }
  }
}
