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
import org.owasp.passfault.api.PatternCollectionFactory;
import org.owasp.passfault.api.PatternFinder;
import org.owasp.passfault.impl.PasswordPattern;

import java.nio.CharBuffer;

/**
 * ReversePatternDecoratorFinder is a PatternsAnalyzer adapter/wrapper that
 * reverses the password and can be used by the normal dictionary finders and
 * dictionary strategies.
 * @author cam, ray
 */
public class ReversePatternDecoratorFinder implements PatternFinder {
  public final static String NAME = "BACKWARDS";

  private final PatternFinder decoratedFinder;
  private PatternCollectionFactory patternCollectionFactory;

  public ReversePatternDecoratorFinder(PatternFinder decoratedFinder, PatternCollectionFactory patternCollectionFactory) {
    this.decoratedFinder = decoratedFinder;
    this.patternCollectionFactory = patternCollectionFactory;
  }

  @Override
  public PatternCollection search(CharSequence pass) {
    char[] backwards = new char[pass.length()];
    for (int i = 0; i < pass.length(); i++) {
      backwards[i] = pass.charAt(pass.length() - 1 - i);
    }

    CharBuffer chars = CharBuffer.wrap(backwards);
    PatternCollection reversed = patternCollectionFactory.build(pass);
    decoratedFinder.search(chars).stream()
        .map( (PasswordPattern patt) -> reversePattern(pass, patt))
        .forEach(patt -> reversed.putPattern(patt));

    return reversed;
  }

  private PasswordPattern reversePattern(CharSequence pass, PasswordPattern patt) {
    int nonReverseStartIndex = pass.length() - patt.getStartIndex() - patt.getLength();
    return new PasswordPattern(
        nonReverseStartIndex, patt.getLength(), patt.getMatchString(), patt.getCost(),
        NAME + ": " + patt.getDescription(),
        NAME, patt.getClassification());
  }
}
