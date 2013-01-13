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

/**
 * This interface represents a collection of password patterns.  It is passed
 * to pattern finders and is used to store patterns and when analysis is complete.
 * Listeners can be notified of when analysis is complete or even when new patterns
 * are found.
 *
 * @author cam
 */
public interface PasswordResults {

  /**
   * Adds a listener that will be notified when a pattern is found and when
   * a password analysis is complete
   * @param listener callback object to be notified when a pattern is found and
   * when analysis is complete.
   */
  void addListener(AnalysisListener listener);

  /**
   * Calculates the highest probable combination of patterns.  In other words,
   * the weakest combination of found patterns.
   * @return List of patterns that make up the weakest combination of found passwords
   */
  PathCost calculateHighestProbablePatterns();

  /**
   * This method is called by pattern finders to store a newly discovered pattern
   * in a password.
   * @param patt pattern found in the password.
   */
  void foundPattern(PasswordPattern patt);

  /**
   * @return total number of patterns identified.
   */
  int getPossiblePatternCount();

  public CharSequence getCharSequence();

  public int getLength();
}
