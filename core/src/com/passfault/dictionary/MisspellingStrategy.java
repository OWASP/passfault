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

import java.util.LinkedList;
import java.util.List;

/**
 * This strategy looks for words that are only a few characters different from
 * a real dictionary word.  This class uses the LevenshteinDistance to calculate
 * closeness
 * @author cam
 */
public class MisspellingStrategy implements DictionaryStrategy {

  public final static String NAME = "MISSPELL";

  @Override
  public String getName() {
    return NAME;
  }
  private int allowedDistance;

  public MisspellingStrategy(int allowedDifferences) {
    this.allowedDistance = allowedDifferences;
  }

  @Override
  public List<CandidatePattern> buildNextSubStrings(CandidatePattern subs, char c) {
    LinkedList<CandidatePattern> list = new LinkedList<CandidatePattern>();
    for (int i = 0; i < 26; i++) {
      CandidatePattern newsubs = subs.copy();
      char ch = (char) ('a' + i);
      newsubs.add(ch);
      LevenshteinDistance levs = newsubs.getDecorator(LevenshteinDistance.class);
      levs.appendToTarget(ch);
      levs.updateDist();
      list.add(newsubs);
    }
    return list;
  }

  @Override
  public boolean isAdvanceable(CandidatePattern candidate) {
    LevenshteinDistance leven = candidate.getDecorator(LevenshteinDistance.class);
    if (leven == null) {
      return false;
    }
    int dist = leven.partialDistance();
    return (dist <= this.allowedDistance);
  }

  @Override
  public void addContext(CandidatePattern cand, CharSequence password) {
    CharSequence baseString = password.subSequence(cand.startOffset, password.length());
    LevenshteinDistance dist = new LevenshteinDistance(baseString);
    cand.addDecorator(LevenshteinDistance.class, dist);
  }

  @Override
  public boolean isMatch(CandidatePattern candidate) {
    LevenshteinDistance leven = candidate.getDecorator(LevenshteinDistance.class);
    if (leven == null) {
      return false;
    }
    int dist = leven.partialDistance();
    return dist > 0 && (dist <= this.allowedDistance);
  }
}
