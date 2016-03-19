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
import org.owasp.passfault.PasswordAnalysis;
import org.owasp.passfault.PasswordResults;
import org.owasp.passfault.PathCost;

import static org.junit.Assert.assertEquals;

public class EnglishKeyBoardTest {

  @Test
  public void generateKeyboard_horizontal() throws Exception {
    System.out.println("generateKeyboard");
    KeySequenceFinder finder = new KeySequenceFinder(new EnglishKeyBoard());
    String expectedPatternName = KeySequenceFinder.HORIZONTAL;
    assertPattern(finder, new PasswordAnalysis("1234567890-="), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("!@#$%^&*()_+"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("qwertyuiop[]\\"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("QWERTYUIOP{}|"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("asdfghjkl;'"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("ASDFGHJKL:"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("zxcvbnm,./"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("ZXCVBNM<>?"), expectedPatternName);
  }

  @Test
  public void generateKeyboard_horizontalMixed() throws Exception {
    System.out.println("generateKeyboard");
    KeySequenceFinder finder = new KeySequenceFinder(new EnglishKeyBoard());
    String expectedPatternName = KeySequenceFinder.HORIZONTAL;
    assertPattern(finder, new PasswordAnalysis("12#456&890-="), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("!2#$5^&8()_+"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("qweRTyuiop[]\\"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("QweRTYuIoP{}|"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("asDFghjkl;'"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("ASDFghJKL:"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("zxCVbnm,./"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("ZXCvbNM<>?"), expectedPatternName);
  }

  @Test
  public void generateKeyboard_diagnol() throws Exception {
    System.out.println("diags");
    KeySequenceFinder finder = new KeySequenceFinder(new EnglishKeyBoard());
    String expectedPatternName = KeySequenceFinder.DIAGONAL;
    assertPattern(finder, new PasswordAnalysis("1qaz"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("2wsx"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("3edc"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("4rfv"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("5tgb"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("6yhn"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("7ujm"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("8ik,"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("9ol."), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("0p;/"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("-['"), expectedPatternName);

    assertPattern(finder, new PasswordAnalysis("]'/"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("=[;."), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("-pl,"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("0okm"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("9ijn"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("8uhb"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("7ygv"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("6tfc"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("5rdx"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("4esz"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("3wa"), expectedPatternName);

    assertPattern(finder, new PasswordAnalysis("!QAZ"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("@WSX"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("#EDC"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("$RFV"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("%TGB"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("^YHN"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("&UJM"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("*IK<"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("(OL>"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis(")P:?"), expectedPatternName);
    assertPattern(finder, new PasswordAnalysis("_{\""), expectedPatternName);
  }

  private void assertPattern(KeySequenceFinder finder, PasswordResults pass, String expectedPatternName) throws Exception {
    finder.analyze(pass);
    PathCost cost = pass.calculateHighestProbablePatterns();
    assertEquals(1, cost.getPath().size());
    assertEquals(expectedPatternName, cost.getPath().get(0).getName());
  }

}