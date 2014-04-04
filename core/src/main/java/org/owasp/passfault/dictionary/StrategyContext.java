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

package org.owasp.passfault.dictionary;

/**
 * StrategyContext is an interface defining the context or state that a strategy
 * will store on a candidate pattern.
 * @author cam
 */
public interface StrategyContext {

  StrategyContext copy();

  String getDescription();

  /**
   * Each dictionary word pattern size is the number of words in the dictionary.
   * Other dictionary based finders will multiply number of words by the
   * crackSizeFactor to calculate the overall pattern size.
   * @return factor is the size of the pattern
   */
  int getCrackSizeFactor();
}
