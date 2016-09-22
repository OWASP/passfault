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

import org.owasp.passfault.PasswordResults;
import org.owasp.passfault.PatternFinder;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

/**
 * DictionaryPatternsFinder incrementally searches through dictionaries one
 * character at a time.  The strategies determine how the password matches a pattern
 * such as substitutions, misspellings.  The strategies will store the state of
 * the search in a candidatePattern object.
 */
public class DictionaryPatternsFinder implements PatternFinder {
  private static final Logger log = getLogger(DictionaryPatternsFinder.class.getName());

  private final DictionaryStrategy patternStrategy;
  private final Dictionary dictionary;

  public DictionaryPatternsFinder(Dictionary wordlist, DictionaryStrategy strategy) {
    this.dictionary = wordlist;
    this.patternStrategy = strategy;
  }

  @Override
  public void analyze(PasswordResults pass) throws Exception {
    CharSequence password = pass.getCharSequence();
    List<CandidatePattern> currGen = new LinkedList<CandidatePattern>();
    List<CandidatePattern> nextGen = new LinkedList<CandidatePattern>();
    List<CandidatePattern> swap;

    for (int i = 0; i < password.length(); i++) {
      log.finest(MessageFormat.format("{0} possible passwords in the {1}th generation, {2} strategy", nextGen.size(), i, patternStrategy.getName()));

      CandidatePattern newCandidate = dictionary.buildInitialCandidate(i);
      patternStrategy.addContext(newCandidate, password);
      nextGen.add(newCandidate);
      char c = password.charAt(i);
      swap = currGen;
      currGen = nextGen;
      nextGen = swap;
      nextGen.clear();

      for (CandidatePattern subs : currGen) {
        List<CandidatePattern> nextCandidates = patternStrategy.buildNextSubStrings(subs, c);
        //go through candidates
        for (CandidatePattern candidate : nextCandidates) {
          boolean isPossible = dictionary.partialMatch(candidate);
          if (isPossible) {
            if (patternStrategy.isAdvanceable(candidate)) {
              nextGen.add(candidate);

              //if the dictionary says it is a match and the strategy says it is a match
              if (candidate.getLength() > 2 && dictionary.isMatch(candidate) && patternStrategy.isMatch(candidate)) {

                //report found pattern
                pass.foundPattern(
                    candidate.getMatchingPattern(dictionary.getWordCount(),
                    patternStrategy.getName(), dictionary.getName(), i));
              }
            }
          }
        }
      }
    }
    return;
  }
}
