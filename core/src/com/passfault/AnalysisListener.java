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
 *
 * @author cam
 */
public interface AnalysisListener {

  /**
   * The highest probably Patterns was found.  This pathCost list is the highest
   * probable combination of Patterns.  Highest Probable means the most likely to
   * be cracked.
   * @param cost Object that combines a subset of all found pattens with their
   * associated cost (probability of being cracked)
   */
  public void foundHighestProbablePatterns(PathCost cost);

  /**
   * A pattern was found in a password.
   * @param patt Pattern that was found in the password, including it's name and the part of
   * the password that matches the pattern
   */
  public void foundPattern(PasswordPattern patt);
}
