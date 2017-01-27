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
 * Dictionary is an interface for implementing a word-list, or 'dictionary'.  It
 * facilitates searching through the word list.  An Implementation is used by the
 * DictionaryPatternsFinder and DictionaryStrategy.
 * @author cam
 */
public interface Dictionary {

  /**
   * The DictionaryPatternFinder needs to create an initial CandidatePattern to
   * store the state of a partial search in a dictionary.
   * @param offset offset into the password where the dictionary word starts
   * @return a CandidatePattern to maintain the state of searching for a dictionary
   * word that starts at the offset specified.
   */
  CandidatePattern buildInitialCandidate(int offset);

  /**
   * @param candidate pattern to test for a partial match
   * @return if the candidate pattern is a partial match
   */
  boolean partialMatch(CandidatePattern candidate)
      throws DictionaryException;

  int getWordCount();

  boolean isMatch(CandidatePattern candidate)
      throws DictionaryException;

  /**
   * @return name describing the type of word list, such as, english, russian, US Cities, US Names...
   */
  String getName();

  /**
   * @param newWordCount sets count for dictionaries that are part of a dictionary group
   */
  void setWordCount(int newWordCount);
}
