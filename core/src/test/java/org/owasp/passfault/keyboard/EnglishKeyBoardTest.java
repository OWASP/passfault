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
package org.owasp.passfault.keyboard;

import org.junit.Test;
import org.owasp.passfault.PasswordResultsImpl;
import org.owasp.passfault.api.PasswordResults;
import org.owasp.passfault.PathCost;

import static org.junit.Assert.assertEquals;

public class EnglishKeyBoardTest {

  @Test
  public void generateKeyboard_horizontal() throws Exception {
    System.out.println("generateKeyboard");
    KeySequenceFinder finder = new KeySequenceFinder(new EnglishKeyBoard());
    String expectedPatternName = KeySequenceFinder.HORIZONTAL;
    assertPattern(finder, new PasswordResultsImpl("1234567890-="), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("!@#$%^&*()_+"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("qwertyuiop[]\\"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("QWERTYUIOP{}|"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("asdfghjkl;'"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("ASDFGHJKL:"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("zxcvbnm,./"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("ZXCVBNM<>?"), expectedPatternName);
  }

  @Test
  public void generateKeyboard_horizontalMixed() throws Exception {
    System.out.println("generateKeyboard");
    KeySequenceFinder finder = new KeySequenceFinder(new EnglishKeyBoard());
    String expectedPatternName = KeySequenceFinder.HORIZONTAL;
    assertPattern(finder, new PasswordResultsImpl("12#456&890-="), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("!2#$5^&8()_+"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("qweRTyuiop[]\\"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("QweRTYuIoP{}|"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("asDFghjkl;'"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("ASDFghJKL:"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("zxCVbnm,./"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("ZXCvbNM<>?"), expectedPatternName);
  }

  @Test
  public void generateKeyboard_diagnol() throws Exception {
    System.out.println("diags");
    KeySequenceFinder finder = new KeySequenceFinder(new EnglishKeyBoard());
    String expectedPatternName = KeySequenceFinder.DIAGONAL;
    assertPattern(finder, new PasswordResultsImpl("1qaz"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("2wsx"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("3edc"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("4rfv"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("5tgb"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("6yhn"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("7ujm"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("8ik,"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("9ol."), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("0p;/"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("-['"), expectedPatternName);

    assertPattern(finder, new PasswordResultsImpl("]'/"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("=[;."), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("-pl,"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("0okm"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("9ijn"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("8uhb"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("7ygv"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("6tfc"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("5rdx"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("4esz"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("3wa"), expectedPatternName);

    assertPattern(finder, new PasswordResultsImpl("!QAZ"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("@WSX"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("#EDC"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("$RFV"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("%TGB"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("^YHN"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("&UJM"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("*IK<"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("(OL>"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl(")P:?"), expectedPatternName);
    assertPattern(finder, new PasswordResultsImpl("_{\""), expectedPatternName);
  }

  private void assertPattern(KeySequenceFinder finder, PasswordResults pass, String expectedPatternName) throws Exception {
    finder.analyze(pass);
    PathCost cost = pass.calculateHighestProbablePatterns();
    assertEquals(1, cost.getPath().size());
    assertEquals(expectedPatternName, cost.getPath().get(0).getName());
  }

}