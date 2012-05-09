/* ©Copyright 2011 Cameron Morris
 *
 * This file is part of Passfault.
 *
 * Passfault is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Passfault is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Passfault.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.passfault;

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
