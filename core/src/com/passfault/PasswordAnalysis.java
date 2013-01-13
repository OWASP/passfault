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

package com.passfault;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class holds the results of the analysis of a password.  An instance
 * of this class begins with a password to analyze.  Then it is handed to
 * multiple <code>PatternFinder<code>s.
 *
 * This class contains the logic for post-analysis of the patterns found
 * (althought this logic might be better if separated from this class)  This
 * logic includes finding the weakest combination of patterns and locating
 * repeated patterns.
 *
 * @author cam
 */
public class PasswordAnalysis implements PasswordResults {

  private CharSequence password;
  private Map<Integer, List<PasswordPattern>> foundPatterns = new HashMap<Integer, List<PasswordPattern>>();
  private Map<Integer, PathCost> ithSmallestCost = new HashMap<Integer, PathCost>();
  private int patternCount = 0;
  private List<AnalysisListener> analysisListeners = new LinkedList<AnalysisListener>();
  private RepeatingPatternFinder repeatingPatternFinder = new RepeatingPatternFinder();
  private PathCost finalResults = null;
  private RandomPattern randomPatternFinder = new RandomPattern();
  private static final Logger log = java.util.logging.Logger.getLogger(PasswordAnalysis.class.getName());
  //todo remove counter, this is just for debugging to measure the optmization effectiveness
  private int counter = 0;

  public PasswordAnalysis(CharSequence password) {
    this.password = password;
  }

  @Override
  public CharSequence getCharSequence() {
    return password;
  }

  @Override
  public int getLength() {
    return password.length();
  }

  /**
   * Adds a listener that will be notified when a pattern is found and when
   * a password analysis is complete
   * @param listener callback object to be notified when a pattern is found and
   * when analysis is complete.
   */
  @Override
  public void addListener(AnalysisListener listener) {
    this.analysisListeners.add(listener);
  }

  /**
   * This method is called by pattern finders to store a newly discovered pattern
   * in a password.
   * @param patt pattern found in the password.
   */
  /*
   * Interesting things happen with random patterns.  Some short patterns can be
   * more complex than random patterns.  Looking and testing all possible
   * combinations of random patterns within a pattern is possible and was
   * experimented with.  However, having different classes of random (upper, lower,
   * numbers...) made it hard to determine if it was worthwhile.  The best solution
   * tried was to compare a newly found pattern to the random pattern of the same
   * sequence, and discard the pattern if random was better(smaller).
   */
  @Override
  synchronized public void foundPattern(PasswordPattern patt) {
//    System.out.format("Found a pattern: matches '%s' as a '%s' pattern, size=%f\n",
//        patt.getMatchString(), patt.getDescription(), patt.getCost());
    PasswordPattern randomPattern = randomPatternFinder.getRandomPattern(password, patt.getStartIndex(), patt.getLength());
    if (patt.getCost() > randomPattern.getCost()) {
      //random is less expensive so throw away the pattern
      log.log(Level.FINER, "Pattern discarded because random is smaller: {0}", patt.getName());
      //patt = randomPattern;
      return;
    }
    List<PasswordPattern> patterns = getIndexSet(patt.getStartIndex());
    boolean worsePatternAlreadyFound = false;
    for (PasswordPattern passwordPattern : patterns) {
      if (patt.getLength() == passwordPattern.getLength()
          && patt.getCost() > passwordPattern.getCost()) {
        worsePatternAlreadyFound = true;
        log.log(Level.FINER, "discarding found pattern since a smaller pattern already exists: {0}", patt.getName());
      }
    }
    if (!worsePatternAlreadyFound) {
      patterns.add(patt);
      patternCount++;
      for (AnalysisListener observer : analysisListeners) {
        observer.foundPattern(patt);
      }
    }
  }

  /**
   * This is a lazy loading getter for a list of patterns that begin on the
   * index of the password.
   * @param startIndex index of the a character in a the password where the list
   * of patterns begin.
   *
   * @return a List of patterns found for the starting index of where a pattern
   * starts.
   */
  private List<PasswordPattern> getIndexSet(int startIndex) {
    if (!foundPatterns.containsKey(startIndex)) {
      foundPatterns.put(startIndex, new LinkedList<PasswordPattern>());
    }
    return foundPatterns.get(startIndex);
  }

  /**
   * @return total number of patterns identified.
   */
  @Override
  public int getPossiblePatternCount() {
    return patternCount;
  }

  /**
   * Calculates the highest probable combination of patterns.  In other words,
   * the weakest combination of found patterns.
   * @return List of patterns that make up the weakest combination of found passwords
   */
  @Override
  public PathCost calculateHighestProbablePatterns() {
    if (finalResults == null) {
      log.log(Level.FINE, "Calculating the highest probable combination of %s patterns\n", getPossiblePatternCount());
      PathCost cost = smallestCost(0);
      cost = postAnalysis(cost);
      log.log(Level.FINER, "smallestCost took %d iterations", counter);

      for (AnalysisListener observer : analysisListeners) {
        observer.foundHighestProbablePatterns(cost);
      }
      finalResults = cost;
      cleanup();
    }
    return finalResults;
  }

  /**
   * This is a recursive call to compute the smallest Cost (or weakest combination)
   * of patterns starting at the index specified by startChar
   * @param startChar
   * @return List of patterns including cost
   */
  private PathCost smallestCost(int startChar) {
    double smallestCost = Double.MAX_VALUE;
    PathCost smallestCostPath = getIthSmallestCost(startChar);
    if (smallestCostPath == null) {
      smallestCostPath = new PathCost(this);
      for (int i = startChar; i < password.length(); i++) {
        List<PasswordPattern> ithPatterns = foundPatterns.get(i);
        if (ithPatterns != null) {
          counter++;

          PathCost pathCost = calculateIthSmallestCost(ithPatterns);

          //random characters between startChar and the next found pattern
          PasswordPattern randomPattern = getRandomPattern(startChar, i);
          if (randomPattern != null) {
            pathCost.addPattern(randomPattern);
          }

          if (pathCost.getRelativeCost() < smallestCost) {
            smallestCost = pathCost.getRelativeCost();
            smallestCostPath = pathCost;
          }
        }
      }
      if (smallestCostPath.getPath().isEmpty()) {
        PasswordPattern randomPattern = getRandomPattern(startChar, password.length());
        if (randomPattern != null) {
          smallestCostPath.addPattern(randomPattern);
        }
      }
      setIthSmallestCost(startChar, smallestCostPath);
    }
    return smallestCostPath;
  }

  /**
   * Helper method for smallestCost,
   * @param ithPatterns list of patterns starting with a specific index
   * @return result of the smallest result of calling smallestCost on all
   * patterns in the list
   */
  private PathCost calculateIthSmallestCost(List<PasswordPattern> ithPatterns) {
    double smallestCost = Double.MAX_VALUE;
    PathCost smallestCostPath = null;
    for (PasswordPattern pattern : ithPatterns) {
      int index = pattern.getStartIndex() + pattern.getLength();
      PathCost costPath = smallestCost(index);
      costPath.addPattern(pattern);
      double cost = costPath.getRelativeCost();
      if (cost < smallestCost
          || (cost == smallestCost && //if the same, favor the one with fewer patterns
          smallestCostPath.getPath().size() > costPath.getPath().size())) {
        smallestCost = cost;
        smallestCostPath = costPath;
      }
    }
    return smallestCostPath;
  }

  private PathCost postAnalysis(PathCost cost) {
    return repeatingPatternFinder.process(cost, this);
  }

  private PasswordPattern getRandomPattern(int startChar, int endChar) {
    if (endChar <= startChar) {
      return null;
    }
    return randomPatternFinder.getRandomPattern(this.password, startChar, endChar - startChar);
  }

  private void setIthSmallestCost(int i, PathCost pathCost) {
    ithSmallestCost.put(i, new PathCost(pathCost)); //need a deep copy of the path cost in case it gets modified
  }

  private PathCost getIthSmallestCost(int i) {
    if (ithSmallestCost.containsKey(i)) {
      return new PathCost(ithSmallestCost.get(i)); //need a deep copy since it will be added to
    } else {
      return null;
    }
  }

  private void cleanup() {
    //attempt to clean up any circular references for Garbage cleanup.  only run this after the smallest path is calculated.
    ithSmallestCost.clear();
    this.foundPatterns.clear();
  }
}
