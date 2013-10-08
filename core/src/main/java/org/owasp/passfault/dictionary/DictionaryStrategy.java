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
