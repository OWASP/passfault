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

import org.owasp.passfault.api.*;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * This class runs each analysis as a single thread, but multiple passwords are analyzed concurrently
 * This won't improve performance for each request, but it will improve throughput.
 * @author cam
 */
public class ResponseOptimizedFinders implements CompositeFinder {

  private final ExecutorService exec;
  private final Collection<PatternFinder> finders;
  private final PatternCollectionFactory factory;

  public ResponseOptimizedFinders(Collection<PatternFinder> finders, PatternCollectionFactory factory) {
    this.factory = factory;
    this.finders = finders;
    this.exec = Executors.newFixedThreadPool(10);
  }
  
  public ResponseOptimizedFinders(Collection<PatternFinder> finders, ThreadFactory threadFactory, PatternCollectionFactory factory){
    this.factory = factory;
    this.finders = finders;
    this.exec = Executors.newCachedThreadPool(threadFactory);
  }

  /**
   * The method returns as soon as all threads have started, not completed.
   * To wait until completion call {#waitForAnalysis} or register an
   * AnalysisListener and implement foundHighestProbablePatterns.
   */
  @Override
  public PatternCollection search(CharSequence pass) {
    try {
      return searchFuture(pass).get();
    }
    catch (InterruptedException e) {
      throw new PassfaultException("analysis was interrupted", e);
    }
    catch (ExecutionException e) {
      throw new PassfaultException("An error occurred with analysis execution", e);
    }
  }

  /**
   * Blocks until all analysis is complete.
   * @param pass password being analyzed to test for completion
   */
  @Override
  public CompletableFuture<PatternCollection> searchFuture(CharSequence pass) {
    List<CompletableFuture<PatternCollection>> futures = finders.stream()
        .map((PatternFinder finder) -> CompletableFuture.supplyAsync(() -> finder.search(pass), exec))
        .collect(Collectors.toList());

    //using patterns found here: http://www.nurkiewicz.com/2013/05/java-8-completablefuture-in-action.html
    CompletableFuture<Void> allDoneFuture =
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));

    return allDoneFuture.thenApply(v -> {
          //I should really write a collector for the PatternCollection, but until I do...
          PatternCollection collected = factory.build(pass);
          futures.stream()
              .map(CompletableFuture::join)
              .forEach(collected::addAll);
          return collected;
        }
    );
  }
  
  /**
   * invokes shutdown on the underlying executor service
   */
  public void shutdown(){
    this.exec.shutdown();
  }

}
