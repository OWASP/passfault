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

import org.owasp.passfault.AnalysisListener;
import org.owasp.passfault.PasswordPattern;
import org.owasp.passfault.PasswordResults;
import org.owasp.passfault.PathCost;

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
    return new PasswordPattern(nonReverseStartIndex, patt.getLength(), patt.getMatchString(), patt.getCost(), BackwardsAnalysisAdapter.NAME + ": " + patt.getDescription(), BackwardsAnalysisAdapter.NAME, patt.getClassification());
  }

  public CharSequence getCharSequence() {
    return new String(this.backwardsChars);
  }

  @Override
  public int getLength() {
    return this.backwardsChars.length;
  }
}
