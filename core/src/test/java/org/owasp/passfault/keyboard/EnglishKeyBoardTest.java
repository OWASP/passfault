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
import org.owasp.passfault.PatternsAnalyzerImpl;
import org.owasp.passfault.api.PatternsAnalyzer;
import org.owasp.passfault.PathCost;

import static org.junit.Assert.assertEquals;

public class EnglishKeyBoardTest {

  @Test
  public void generateKeyboard_horizontal() throws Exception {
    System.out.println("generateKeyboard");
    KeySequenceFinder finder = new KeySequenceFinder(new EnglishKeyBoard());
    String expectedPatternName = KeySequenceFinder.HORIZONTAL;
    assertPattern(finder, new PatternsAnalyzerImpl("1234567890-="), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("!@#$%^&*()_+"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("qwertyuiop[]\\"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("QWERTYUIOP{}|"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("asdfghjkl;'"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("ASDFGHJKL:"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("zxcvbnm,./"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("ZXCVBNM<>?"), expectedPatternName);
  }

  @Test
  public void generateKeyboard_horizontalMixed() throws Exception {
    System.out.println("generateKeyboard");
    KeySequenceFinder finder = new KeySequenceFinder(new EnglishKeyBoard());
    String expectedPatternName = KeySequenceFinder.HORIZONTAL;
    assertPattern(finder, new PatternsAnalyzerImpl("12#456&890-="), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("!2#$5^&8()_+"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("qweRTyuiop[]\\"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("QweRTYuIoP{}|"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("asDFghjkl;'"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("ASDFghJKL:"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("zxCVbnm,./"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("ZXCvbNM<>?"), expectedPatternName);
  }

  @Test
  public void generateKeyboard_diagnol() throws Exception {
    System.out.println("diags");
    KeySequenceFinder finder = new KeySequenceFinder(new EnglishKeyBoard());
    String expectedPatternName = KeySequenceFinder.DIAGONAL;
    assertPattern(finder, new PatternsAnalyzerImpl("1qaz"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("2wsx"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("3edc"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("4rfv"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("5tgb"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("6yhn"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("7ujm"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("8ik,"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("9ol."), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("0p;/"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("-['"), expectedPatternName);

    assertPattern(finder, new PatternsAnalyzerImpl("]'/"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("=[;."), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("-pl,"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("0okm"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("9ijn"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("8uhb"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("7ygv"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("6tfc"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("5rdx"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("4esz"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("3wa"), expectedPatternName);

    assertPattern(finder, new PatternsAnalyzerImpl("!QAZ"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("@WSX"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("#EDC"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("$RFV"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("%TGB"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("^YHN"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("&UJM"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("*IK<"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("(OL>"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl(")P:?"), expectedPatternName);
    assertPattern(finder, new PatternsAnalyzerImpl("_{\""), expectedPatternName);
  }

  private void assertPattern(KeySequenceFinder finder, PatternsAnalyzer pass, String expectedPatternName) throws Exception {
    finder.analyze(pass);
    PathCost cost = pass.calculateHighestProbablePatterns();
    assertEquals(1, cost.getPath().size());
    assertEquals(expectedPatternName, cost.getPath().get(0).getName());
  }

}