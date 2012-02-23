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

import com.passfault.RandomPattern;
import java.util.LinkedList;
import java.util.List;

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
        CandidatePattern newsubs = (CandidatePattern) subs.copy();
        char ch = (char) ('a' + i);
        newsubs.add(ch);
        list.add(newsubs);
      }
    } else {
      CandidatePattern newsubs = (CandidatePattern) subs.copy();
      newsubs.add(c);
      list.add(newsubs);
    }
    return list;
  }

  @Override
  public boolean isAdvanceable(CandidatePattern candidate) {
    SubstitutionContex context = candidate.getDecorator(SubstitutionContex.class);
    if (context == null) {
      return true;
    } else {
      return (context.count <= this.allowedSubstitutions);
    }
  }

  @Override
  public boolean isMatch(CandidatePattern candidate) {
    SubstitutionContex context = candidate.getDecorator(SubstitutionContex.class);
    if (context == null) {
      return false; //no substitution? we'll let the exact match finder catch it
    } else {
      return context.count > 0 && (context.count <= this.allowedSubstitutions);
    }
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
