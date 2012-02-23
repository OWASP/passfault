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
