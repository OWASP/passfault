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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.owasp.passfault.CompositeFinder;
import org.owasp.passfault.PasswordResults;
import org.owasp.passfault.PatternFinder;

/**
 * This class is runs all finders in separate threads, in addition it runs one
 * thread to monitor when all finder threads are complete (called the DoneThread)
 *
 * @author cam
 */
public class ParallelFinder implements CompositeFinder {

  private List<FinderThread> finderThreads;

  public ParallelFinder(Collection<PatternFinder> finders) {
    finderThreads = new LinkedList<FinderThread>();
    FinderThread finderThread;
    for (PatternFinder finder : finders) {
      finderThread = new FinderThread(finder);
      finderThreads.add(finderThread);
    }
  }

  @Override
  public void blockingAnalyze(PasswordResults pass) throws Exception {
    analyze(pass);
    waitForAnalysis(pass);
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
    for (FinderThread finderThread : finderThreads) {
      finderThread.addPassword(pass);
      if (!finderThread.isAlive()) {
        finderThread.start();
      }
    }
    Thread doneThread = new DoneThread(pass);
    doneThread.start();
  }

  /**
   * Blocks until all analysis is complete.
   * @param pass password being analyzed to test for completion
   * @throws InterruptedException
   */
  public void waitForAnalysis(PasswordResults pass) throws InterruptedException {
    boolean done = false;
    while (!done) {
      done = true;
      for (FinderThread finderThread : finderThreads) {
        if (!finderThread.isDone(pass)) {
          done = false;
          break;
        }
      }
      if (!done) {
        Thread.sleep(200);
      }
    }
  }

  public void end() {
    for (FinderThread finderThread : finderThreads) {
      finderThread.end();
    }
  }

  /**
   * This class is a Thread dedicated to finding one password pattern.  It will only
   * process one password at a time.
   */
  static public class FinderThread extends Thread {

    public static final int SLEEP_TIME = 1000;
    private PatternFinder finder;
    private Queue<PasswordResults> workList;
    private Queue<PasswordResults> doneList;
    volatile boolean run = true;

    FinderThread(PatternFinder finder) {
      this.finder = finder;
      workList = new ConcurrentLinkedQueue<PasswordResults>();
      doneList = new ConcurrentLinkedQueue<PasswordResults>();
    }

    @Override
    public void run() {
      while (run) {
        try {
          if (workList.isEmpty()) {
            Thread.sleep(SLEEP_TIME);
          } else {
            PasswordResults password = workList.remove();
            finder.analyze(password);
            doneList.add(password);
          }
        } catch (Exception ex) {
          Logger.getLogger(FinderThread.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }

    public boolean isDone(PasswordResults password) {
      return doneList.contains(password);
    }

    public void addPassword(PasswordResults password) {
      workList.add(password);
    }

    public void removePassword(PasswordResults password) {
      doneList.remove(password);
    }

    public void end() {
      run = false;
    }
  }

  /**
   * This class monitors the FinderThreads launched by ParallelFinder for the results
   * of analysis for a specific password.  When analysis is complete it calls the method
   * {PaswordResults#calculateHighestProbablePatterns()|
   */
  class DoneThread extends Thread {

    private final PasswordResults passAnalysis;

    public DoneThread(PasswordResults pass) {
      this.passAnalysis = pass;
    }

    @Override
    public void run() {
      try {
        waitForAnalysis(passAnalysis);
        passAnalysis.calculateHighestProbablePatterns();
      } catch (InterruptedException ex) {
        Logger.getLogger(DoneThread.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
