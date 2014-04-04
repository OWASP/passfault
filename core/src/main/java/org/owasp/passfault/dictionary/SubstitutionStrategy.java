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

import java.util.LinkedList;
import java.util.List;

import org.owasp.passfault.RandomPattern;

/**
 * SubstitutionStrategy defines a matching strategy where letters in a word
 * can be substituted by a special character or number.  
 * @author cam
 */
public class SubstitutionStrategy implements DictionaryStrategy {

  public final static String NAME = "SUBSTITUTE";

  @Override
  public String getName() {
    return NAME;
  }
  private int allowedSubstitutions;

  public SubstitutionStrategy(int allowedDifferences) {
    this.allowedSubstitutions = allowedDifferences;
  }

  @Override
  public List<CandidatePattern> buildNextSubStrings(CandidatePattern subs, char c) {
    LinkedList<CandidatePattern> list = new LinkedList<CandidatePattern>();
    if (!Character.isLetter(c)) {
      SubstitutionContex context = subs.getDecorator(SubstitutionContex.class);
      if (context == null) {
        context = new SubstitutionContex();
        context.count = 1;
        subs.addDecorator(SubstitutionContex.class, context);
      } else {
        context.count++;
      }
      for (int i = 0; i < 26; i++) {
        CandidatePattern newsubs = subs.copy();
        char ch = (char) ('a' + i);
        newsubs.add(ch);
        list.add(newsubs);
      }
    } else {
      CandidatePattern newsubs = subs.copy();
      newsubs.add(c);
      list.add(newsubs);
    }
    return list;
  }

  @Override
  public boolean isAdvanceable(CandidatePattern candidate) {
    SubstitutionContex context = candidate.getDecorator(SubstitutionContex.class);
    return context == null || (context.count <= this.allowedSubstitutions);
  }

  @Override
  public boolean isMatch(CandidatePattern candidate) {
    SubstitutionContex context = candidate.getDecorator(SubstitutionContex.class);
    return context != null && context.count > 0 && (context.count <= this.allowedSubstitutions);
  }

  @Override
  public void addContext(CandidatePattern cand, CharSequence password) {
    //we will wait until we find a non-character word, it'll save memory and run faster
  }

  private static class SubstitutionContex implements StrategyContext {

    int count = 0;

    @Override
    public String getDescription() {
      return "Substitution";
    }

    @Override
    public int getCrackSizeFactor() {
      if (count == 0) {
        return 1;
      } else {
        return count * RandomPattern.RandomClasses.SpecialChars.getSize(); //todo add 1/chars in pattern
      }
    }

    @Override
    public SubstitutionContex copy() {
      SubstitutionContex copy = new SubstitutionContex();
      copy.count = this.count;
      return copy;
    }
  }
}
