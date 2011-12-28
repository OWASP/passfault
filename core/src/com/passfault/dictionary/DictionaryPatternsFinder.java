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

import com.passfault.*;
import java.util.LinkedList;
import java.util.List;

/**
 * DictionaryPatternsFinder incrementally searches through dictionaries one
 * character at a time.  The strategies determine how the password matches a pattern
 * such as substitutions, misspellings.  The strategies will store the state of
 * the search in a candidatePattern object.
 */
public class DictionaryPatternsFinder implements PatternFinder {

  private DictionaryStrategy patternStrategy;
  private Dictionary dictionary;

  public DictionaryPatternsFinder(Dictionary wordlist, DictionaryStrategy strategy) {
    this.dictionary = wordlist;
    this.patternStrategy = strategy;
  }

  @Override
  public void blockingAnalyze(PasswordResults pass) throws Exception {
    analyze(pass);
  }

  @Override
  public void analyze(PasswordResults pass) throws Exception {
    CharSequence password = pass.getCharSequence();
    List<CandidatePattern> currGen = new LinkedList<CandidatePattern>();
    List<CandidatePattern> nextGen = new LinkedList<CandidatePattern>();
    List<CandidatePattern> swap;

    for (int i = 0; i < password.length(); i++) {
      //todo log instead of sys.out
      //System.out.format("%d possible passwords in the %dth generation, %s strategy\n", nextGen.size(), i, patternStrategy.getName() );
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
