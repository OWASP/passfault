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

import com.passfault.AnalysisListener;
import com.passfault.PasswordPattern;
import com.passfault.PasswordResults;
import com.passfault.PathCost;

/**
 * BackwardsAnalysisAdapter is a PasswordResults adapter/wrapper that
 * reverses the password and can be used by the normal dictionary finders and
 * dictionary strategies.
 * @author cam
 */
public class BackwardsAnalysisAdapter implements PasswordResults {

  public final static String NAME = "BACKWORDS";
  private final PasswordResults wrappedPasswordAnalysis;
  private final char[] backwardsChars;

  public BackwardsAnalysisAdapter(PasswordResults pass) {
    this.wrappedPasswordAnalysis = pass;
    CharSequence chars = wrappedPasswordAnalysis.getCharSequence();
    char[] backwards = new char[chars.length()];
    for (int i = 0; i < chars.length(); i++) {
      backwards[i] = chars.charAt(chars.length() - 1 - i);
    }
    backwardsChars = backwards;
  }

  @Override
  public void addListener(AnalysisListener listener) {
    this.wrappedPasswordAnalysis.addListener(listener);
  }

  @Override
  public PathCost calculateHighestProbablePatterns() {
    return this.wrappedPasswordAnalysis.calculateHighestProbablePatterns();
  }

  @Override
  public void foundPattern(PasswordPattern patt) {
    PasswordPattern adaptedPattern = reversePattern(patt);
    this.wrappedPasswordAnalysis.foundPattern(adaptedPattern);
  }

  @Override
  public int getPossiblePatternCount() {
    return this.wrappedPasswordAnalysis.getPossiblePatternCount();
  }

  private PasswordPattern reversePattern(PasswordPattern patt) {
    int nonReverseStartIndex = backwardsChars.length - patt.getStartIndex() - patt.getLength();
    PasswordPattern adaptedPattern = new PasswordPattern(nonReverseStartIndex, patt.getLength(), patt.getMatchString(), patt.getCost(), BackwardsAnalysisAdapter.NAME + ": " + patt.getDescription(), BackwardsAnalysisAdapter.NAME, patt.getClassification());
    return adaptedPattern;
  }

  public CharSequence getCharSequence() {
    return new String(this.backwardsChars);
  }

  @Override
  public int getLength() {
    return this.backwardsChars.length;
  }
}
