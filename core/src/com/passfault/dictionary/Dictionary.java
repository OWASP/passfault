/* ©Copyright 2011 Cameron Morris
 *
 * This file is part of Passfault.
 *
 * Passfault is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Passfault is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Passfault.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.passfault.dictionary;

import java.io.IOException;

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
   * @return a CandidatePAttern to maintain the state of seaching for a dictionary
   * word that starts at the offset specified.
   */
  public abstract CandidatePattern buildInitialCandidate(int offset);

  /**
   * @param candidate
   * @return if the candidate pattern
   */
  public abstract boolean partialMatch(CandidatePattern candidate)
      throws IOException;

  public abstract int getWordCount();

  public abstract boolean isMatch(CandidatePattern candidate) throws IOException;

  /**
   * name describing the type of word list, such as, english, russian, US Cities, US Names...
   */
  public String getName();
}
