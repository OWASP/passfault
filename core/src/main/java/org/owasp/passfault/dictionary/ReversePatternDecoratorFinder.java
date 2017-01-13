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

import org.owasp.passfault.api.PatternCollection;
import org.owasp.passfault.api.PatternFinder;

/**
 * ReversePatternDecoratorFinder is a PatternsAnalyzer adapter/wrapper that
 * reverses the password and can be used by the normal dictionary finders and
 * dictionary strategies.
 * @author cam, ray
 */
public class ReversePatternDecoratorFinder implements PatternFinder {

  private final PatternFinder decoratedFinder;

  public ReversePatternDecoratorFinder(PatternFinder decoratedFinder) {
    this.decoratedFinder = decoratedFinder;
  }

  @Override
  public PatternCollection search(CharSequence pass) {
    //ReversePatternDecoratorAnalyze newAnalyze = new ReversePatternDecoratorAnalyze(pass);
    //this.decoratedFinder.search(newAnalyze);
    //this got to figure this out
    return null;
  }

//  private class ReversePatternDecoratorAnalyze implements PatternCollection {
//
//    public final static String NAME = "BACKWARDS";
//    private final PatternCollection wrappedPasswordPatternCollection;
//    private final char[] backwardsChars;
//
//    public ReversePatternDecoratorAnalyze(PatternCollection pass) {
//      this.wrappedPasswordPatternCollection = pass;
//      CharSequence chars = wrappedPasswordPatternCollection.getPassword();
//      char[] backwards = new char[chars.length()];
//      for (int i = 0; i < chars.length(); i++) {
//        backwards[i] = chars.charAt(chars.length() - 1 - i);
//      }
//      backwardsChars = backwards;
//    }
//
//    @Override
//    public void putPattern(PasswordPattern patt) {
//      PasswordPattern adaptedPattern = reversePattern(patt);
//      this.wrappedPasswordPatternCollection.putPattern(adaptedPattern);
//    }
//
//    private PasswordPattern reversePattern(PasswordPattern patt) {
//      int nonReverseStartIndex = backwardsChars.length - patt.getStartIndex() - patt.getLength();
//      return new PasswordPattern(
//          nonReverseStartIndex, patt.getLength(), patt.getMatchString(), patt.getCost(),
//          ReversePatternDecoratorAnalyze.NAME + ": " + patt.getDescription(),
//          ReversePatternDecoratorAnalyze.NAME, patt.getClassification());
//    }
//
//    public CharSequence getPassword() {
//      return new String(this.backwardsChars);
//    }
//
//    @Override
//    public List<PasswordPattern> getPatternsByIndex(int i) {
//      return null;
//    }
//
//    @Override
//    public List<PasswordPattern> getAllPatterns() {
//      return null;
//    }
//
//  }
}
