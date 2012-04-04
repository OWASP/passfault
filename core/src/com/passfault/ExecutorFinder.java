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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is runs all finders in separate threads, in addition it runs one
 * thread to monitor when all finder threads are complete (called the DoneThread)
 *
 * @author cam
 */
public class ParallelFinder implements PatternFinder {

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
