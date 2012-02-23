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
public class PasswordAnalysis_Unoptimized implements PasswordResults {

  private String password;
  private Map<Integer, List<PasswordPattern>> foundPatterns = new HashMap<Integer, List<PasswordPattern>>();
  private int patternCount = 0;
  private List<AnalysisListener> analysisListeners = new LinkedList<AnalysisListener>();
  private RepeatingPatternFinder repeatingPatternFinder = new RepeatingPatternFinder();
  private PathCost finalResults = null;
  private RandomPattern randomPatternFinder = new RandomPattern();
  private static final Logger log = java.util.logging.Logger.getLogger(PasswordAnalysis_Unoptimized.class.getName());
  //todo remove counter, this is just for debugging to measure the optmization effectiveness
  private int counter = 0;

  public PasswordAnalysis_Unoptimized(String password) {
    this.password = password;
  }

  public CharSequence getCharSequence() {
    return password;
  }

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
  @Override
  synchronized public void foundPattern(PasswordPattern patt) {
//    PasswordPattern randomPattern = randomPatternFinder.getRandomPattern(password, patt.startIndex, patt.length);
//    if (patt.cost > randomPattern.cost){
//      //random is less expensive so throw away the pattern
//      log.log(Level.INFO, "Pattern discarded because random is smaller: {0}", patt.name);
//      patt = randomPattern;
//    }
    List<PasswordPattern> patterns = getIndexSet(patt.getStartIndex());
    boolean worsePatternAlreadyFound = false;
    for (PasswordPattern passwordPattern : patterns) {
      if (patt.getLength() == passwordPattern.getLength()
          && patt.getCost() > passwordPattern.getCost()) {
        worsePatternAlreadyFound = true;
        log.log(Level.INFO, "discarding found pattern since a worse pattern already exists: {0}", patt.getName());
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
      log.log(Level.INFO, "Calculating the highest probable combination of {0} patterns\n", getPossiblePatternCount());
      PathCost cost = smallestCost(0);
      cost = postAnalysis(cost);
      log.log(Level.FINE, "smallestCost took {0} iterations", counter);

      for (AnalysisListener observer : analysisListeners) {
        observer.foundHighestProbablePatterns(cost);
      }
      finalResults = cost;
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
    PathCost smallestCostPath = new PathCost(this);
    for (int i = startChar; i < password.length(); i++) {
      List<PasswordPattern> ithPatterns = foundPatterns.get(i);
      if (ithPatterns != null) {
        PathCost pathCost = ithSmallestCost(ithPatterns);
        counter++;

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
    if (smallestCostPath.getPath().size() == 0) {
      PasswordPattern randomPattern = getRandomPattern(startChar, password.length());
      if (randomPattern != null) {
        smallestCostPath.addPattern(randomPattern);
      }
    }
    return smallestCostPath;
  }

  /**
   * Helper method for smallestCost,
   * @param ithPatterns list of patterns starting with a specific index
   * @return result of the smallest result of calling smallestCost on all
   * patterns in the list
   */
  private PathCost ithSmallestCost(List<PasswordPattern> ithPatterns) {
    double smallestCost = Double.MAX_VALUE;
    PathCost smallestCostPath = null;
    for (PasswordPattern pattern : ithPatterns) {
      PathCost costPath = smallestCost(pattern.getStartIndex() + pattern.getLength());
      costPath.addPattern(pattern);
      double cost = costPath.getRelativeCost();
      if (cost < smallestCost) {
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

    PasswordPattern random = randomPatternFinder.getRandomPattern(this.password, startChar, endChar - startChar);
    return random;
  }
}
