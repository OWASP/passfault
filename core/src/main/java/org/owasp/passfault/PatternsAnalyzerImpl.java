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

import org.owasp.passfault.api.AnalysisResult;
import org.owasp.passfault.api.PatternCollection;
import org.owasp.passfault.api.PatternsAnalyzer;
import org.owasp.passfault.finders.RepeatingPatternDecorator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

/**
 * This class holds the results of the analysis of a password.  An instance
 * of this class begins with a password to search.  Then it is handed to
 * multiple PatternFinders.
 *
 * This class contains the logic for post-analysis of the finders found
 * (although this logic might be better if separated from this class)  This
 * logic includes finding the weakest combination of finders and locating
 * repeated finders.
 *
 * @author cam
 */
public class PatternsAnalyzerImpl implements PatternsAnalyzer {

  private static final Logger log = getLogger(PatternsAnalyzerImpl.class.getName());
  private RandomPattern randomPatternFinder = new RandomPattern();

  /**
   * Calculates the highest probable combination of finders.  In other words,
   * the weakest combination of found finders.
   * @return List of finders that make up the weakest combination of found passwords
   */
  @Override
  public AnalysisResult calculateHighestProbablePatterns(PatternCollection patterns) {
    IthSmallestCost ithSmallestCost = new IthSmallestCost();
    log.log(Level.FINE, "Calculating the highest probable combination of %s finders\n", patterns.getCount());
    return smallestCost(0, patterns, ithSmallestCost);
  }

  /**
   * This is a recursive call to compute the smallest Cost (or weakest combination)
   * of finders starting at the index specified by startChar
   * @return List of finders including cost
   */
  private AnalysisResult smallestCost(int startChar, PatternCollection foundPatterns, IthSmallestCost ithSmallestCost) {
    double smallestCost = Double.MAX_VALUE;
    AnalysisResult smallestCostPath = ithSmallestCost.getIthSmallestCost(startChar);
    if (smallestCostPath == null) {
      smallestCostPath = new AnalysisResult(foundPatterns.getPassword());
      for (int i = startChar; i < foundPatterns.getPassword().length(); i++) {
        List<PasswordPattern> ithPatterns = foundPatterns.getPatternsByIndex(i);
        if (ithPatterns != null) {

          AnalysisResult analysisResult = calculateIthSmallestCost(i, foundPatterns, ithSmallestCost);

          //random characters between startChar and the next found pattern
          PasswordPattern randomPattern = getRandomPattern(foundPatterns.getPassword(), startChar, i);
          if (randomPattern != null) {
            analysisResult.addPattern(randomPattern);
          }

          if (analysisResult.getRelativeCost() < smallestCost) {
            smallestCost = analysisResult.getRelativeCost();
            smallestCostPath = analysisResult;
          }
        }
      }
      if (smallestCostPath.getPath().isEmpty()) {
        PasswordPattern randomPattern = getRandomPattern(foundPatterns.getPassword(), startChar, foundPatterns.getPassword().length());
        if (randomPattern != null) {
          smallestCostPath.addPattern(randomPattern);
        }
      }
      ithSmallestCost.setIthSmallestCost(startChar, smallestCostPath);
    }
    return smallestCostPath;
  }

  /**
   * Recursive helper method for smallestCost,
   * @return result of the smallest result of calling smallestCost on all
   * finders in the list
   */
  private AnalysisResult calculateIthSmallestCost(int i, PatternCollection foundPatterns, IthSmallestCost ithSmallestCost) {
    List<PasswordPattern> ithPatterns = foundPatterns.getPatternsByIndex(i);
    double smallestCost = Double.MAX_VALUE;
    AnalysisResult smallestCostPath = new AnalysisResult(foundPatterns.getPassword()); //this is really just an empty starting point
    for (PasswordPattern pattern : ithPatterns) {
      int index = pattern.getStartIndex() + pattern.getLength();
      AnalysisResult costPath = smallestCost(index, foundPatterns, ithSmallestCost);
      costPath.addPattern(pattern);
      double cost = costPath.getRelativeCost();
      if (cost < smallestCost
          || (cost == smallestCost && //if the same, favor the one with fewer finders
          smallestCostPath.getPath().size() > costPath.getPath().size())) {
        smallestCost = cost;
        smallestCostPath = costPath;
      }
    }
    return smallestCostPath;
  }

  private PasswordPattern getRandomPattern(CharSequence password, int startChar, int endChar) {
    if (endChar <= startChar) {
      return null;
    }
    return randomPatternFinder.getRandomPattern(password, startChar, endChar - startChar);
  }


  private static class IthSmallestCost {
    Map<Integer, AnalysisResult> ithSmallestCost = new HashMap<>();

    private void setIthSmallestCost(int i, AnalysisResult analysisResult) {
      ithSmallestCost.put(i, new AnalysisResult(analysisResult)); //need a deep copy of the path cost in case it gets modified
    }

    private AnalysisResult getIthSmallestCost(int i) {
      if (ithSmallestCost.containsKey(i)) {
        return new AnalysisResult(ithSmallestCost.get(i)); //need a deep copy since it will be added to
      } else {
        return null;
      }
    }
  }
}
