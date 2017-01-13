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

package org.owasp.passfault.finders;

import org.owasp.passfault.api.CompositeFinder;
import org.owasp.passfault.api.PassfaultException;
import org.owasp.passfault.api.PatternCollection;
import org.owasp.passfault.api.PatternFinder;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.*;

/**
 * This class runs each analysis as a single thread, but multiple passwords are analyzed concurrently
 * This won't improve performance for each request, but it will improve throughput.
 * @author cam
 */
public class ThroughputOptimizedFinder implements CompositeFinder {

  private final PatternFinder finder;
  private final ExecutorService exec;

  public ThroughputOptimizedFinder(Collection<PatternFinder> finders) {
    this.finder = new SequentialFinder(finders);
    this.exec = Executors.newFixedThreadPool(10); 
  }
  
  public ThroughputOptimizedFinder(Collection<PatternFinder> finders, ThreadFactory factory){
    this.finder = new SequentialFinder(finders); 
    this.exec = Executors.newCachedThreadPool(factory);
  }

  /**
   * The method returns as soon as all threads have started, not completed.
   * To wait until completion call {#waitForAnalysis} or register an
   * AnalysisListener and implement foundHighestProbablePatterns.
   * @throws Exception
   */
  @Override
  public PatternCollection search(CharSequence pass) {
    try {
      return analyzeFuture(pass).get();
    }
    catch (InterruptedException e) {
      throw new PassfaultException("analysis was interupted", e);
    }
    catch (ExecutionException e) {
      throw new PassfaultException("An error occured with analysis execution", e);
    }
  }

  /**
   * Blocks until all analysis is complete.
   * @param pass password being analyzed to test for completion
   * @throws InterruptedException
   */
  @Override
  public Future<PatternCollection> analyzeFuture(CharSequence pass) {
    return exec.submit( () -> finder.search(pass));
  }
  
  /**
   * invokes shutdown on the underlying executor service
   */
  public void shutdown(){
    this.exec.shutdown();
  }

}
