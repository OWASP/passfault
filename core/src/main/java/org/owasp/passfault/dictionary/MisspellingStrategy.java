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
    LinkedList<CandidatePattern> list = new LinkedList<>();
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
