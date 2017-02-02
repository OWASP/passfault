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
 * This dictionary strategy simply matches exactly a string in a password and a
 * word in a dictionary.
 * @author cam
 */
public class ExactWordStrategy implements DictionaryStrategy {

  public final static String NAME = "Exact Match";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public boolean isAdvanceable(CandidatePattern candidate) {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public List<CandidatePattern> buildNextSubStrings(CandidatePattern subs, char c) {
    LinkedList<CandidatePattern> list = new LinkedList<CandidatePattern>();
    CandidatePattern newsubs = subs.copy();
    newsubs.add(c);
    list.add(newsubs);
    return list;
  }

  @Override
  public void addContext(CandidatePattern cand, CharSequence password) {
    // No context needed
  }

  @Override
  public boolean isMatch(CandidatePattern candidate) {
    return true;
  }
}
