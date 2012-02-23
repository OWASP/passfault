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
 * This dictionary strategy simply matches exactly a string in a password and a
 * word in a dictionary.
 * @author cam
 */
public class ExactWordStrategy implements DictionaryStrategy {

  public final static String NAME = "WORD";

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
