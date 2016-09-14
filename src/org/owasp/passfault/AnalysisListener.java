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
