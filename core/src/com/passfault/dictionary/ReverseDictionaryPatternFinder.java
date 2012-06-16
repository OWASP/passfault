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

import com.passfault.PasswordResults;

/**
 * ReverseDictionaryPatternFinder uses the BackwardsAnalysisAdapter to reverse
 * a password to find reverse passwords in a dictionary according to a strategy.
 * @author cam
 */
public class ReverseDictionaryPatternFinder extends DictionaryPatternsFinder {

  public ReverseDictionaryPatternFinder(Dictionary diction, DictionaryStrategy strategy) {
    super(diction, strategy);
  }

  @Override
  public void analyze(PasswordResults pass) throws Exception {
    super.analyze(new BackwardsAnalysisAdapter(pass));
  }
}
