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

package com.passfault.dictionary;

import java.util.List;

/**
 * A dictionary strategy determines how a password matches a dictionary word
 * @author cam
 */
public interface DictionaryStrategy {

    /**
     * based on the passed in substring candidate pattern and the next character,
     * buildNextSubStrings will generate all possible CandidatePatterns that might
     * match a dictionary word.
     * @param subs a substring that will be extended by on character
     * @param c the character that is to be added to the substring candidate pattern
     * @return all possible candidate patterns that might match a dictionary word according
     * to the strategy.
     */
	List<CandidatePattern> buildNextSubStrings(CandidatePattern subs, char c);

    /**
     * @param candidate a candidate pattern that is being considered as a possible
     * match with a dictionary word according to the strategy
     * @return true if the candidate might match a dictionary word according to
     * the strategy
     */
	boolean isAdvanceable(CandidatePattern candidate);

    /**
     * The state of information used to attach to the candidate pattern.
     * @param cand partially matching pattern candidate
     * @param password full password being evaluated.
     */
	void addContext(CandidatePattern cand, CharSequence password);

    /**
     * @param candidate a partially matching pattern candidate
     * @return true if the candidate pattern is fully matching a dictionary word
     * according to the strategy, false if the pattern is not fully matching.
     */
    public boolean isMatch(CandidatePattern candidate);

    /**
     * @return Display name of the dictionary strategy
     */
    public String getName();
}
