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
import org.owasp.passfault.impl.PatternsAnalyzerImpl;
import org.owasp.passfault.api.PatternCollection;
import org.owasp.passfault.api.PatternsAnalyzer;
import org.owasp.passfault.api.AnalysisResult;
import org.owasp.passfault.impl.TestingPatternCollectionFactory;

import static org.junit.Assert.assertEquals;

public class EnglishKeyBoardTest {
  PatternsAnalyzer analyzer = new PatternsAnalyzerImpl();
  KeySequenceFinder finder = new KeySequenceFinder(new EnglishKeyBoard(), TestingPatternCollectionFactory.getInstance());

  @Test
  public void generateKeyboard_horizontal() throws Exception {
    System.out.println("generateKeyboard");
    String expectedPatternName = KeySequenceFinder.HORIZONTAL;
    assertPattern(finder.search("1234567890-="), expectedPatternName);
    assertPattern(finder.search("!@#$%^&*()_+"), expectedPatternName);
    assertPattern(finder.search("qwertyuiop[]\\"), expectedPatternName);
    assertPattern(finder.search("QWERTYUIOP{}|"), expectedPatternName);
    assertPattern(finder.search("asdfghjkl;'"), expectedPatternName);
    assertPattern(finder.search("ASDFGHJKL:"), expectedPatternName);
    assertPattern(finder.search("zxcvbnm,./"), expectedPatternName);
    assertPattern(finder.search("ZXCVBNM<>?"), expectedPatternName);
  }

  @Test
  public void generateKeyboard_horizontalMixed() throws Exception {
    System.out.println("generateKeyboard");
    String expectedPatternName = KeySequenceFinder.HORIZONTAL;
    assertPattern(finder.search("12#456&890-="), expectedPatternName);
    assertPattern(finder.search("!2#$5^&8()_+"), expectedPatternName);
    assertPattern(finder.search("qweRTyuiop[]\\"), expectedPatternName);
    assertPattern(finder.search("QweRTYuIoP{}|"), expectedPatternName);
    assertPattern(finder.search("asDFghjkl;'"), expectedPatternName);
    assertPattern(finder.search("ASDFghJKL:"), expectedPatternName);
    assertPattern(finder.search("zxCVbnm,./"), expectedPatternName);
    assertPattern(finder.search("ZXCvbNM<>?"), expectedPatternName);
  }

  @Test
  public void generateKeyboard_diagnol() throws Exception {
    System.out.println("diags");
    String expectedPatternName = KeySequenceFinder.DIAGONAL;
    assertPattern(finder.search("1qaz"), expectedPatternName);
    assertPattern(finder.search("2wsx"), expectedPatternName);
    assertPattern(finder.search("3edc"), expectedPatternName);
    assertPattern(finder.search("4rfv"), expectedPatternName);
    assertPattern(finder.search("5tgb"), expectedPatternName);
    assertPattern(finder.search("6yhn"), expectedPatternName);
    assertPattern(finder.search("7ujm"), expectedPatternName);
    assertPattern(finder.search("8ik,"), expectedPatternName);
    assertPattern(finder.search("9ol."), expectedPatternName);
    assertPattern(finder.search("0p;/"), expectedPatternName);
    assertPattern(finder.search("-['"), expectedPatternName);

    assertPattern(finder.search("]'/"), expectedPatternName);
    assertPattern(finder.search("=[;."), expectedPatternName);
    assertPattern(finder.search("-pl,"), expectedPatternName);
    assertPattern(finder.search("0okm"), expectedPatternName);
    assertPattern(finder.search("9ijn"), expectedPatternName);
    assertPattern(finder.search("8uhb"), expectedPatternName);
    assertPattern(finder.search("7ygv"), expectedPatternName);
    assertPattern(finder.search("6tfc"), expectedPatternName);
    assertPattern(finder.search("5rdx"), expectedPatternName);
    assertPattern(finder.search("4esz"), expectedPatternName);
    assertPattern(finder.search("3wa"), expectedPatternName);

    assertPattern(finder.search("!QAZ"), expectedPatternName);
    assertPattern(finder.search("@WSX"), expectedPatternName);
    assertPattern(finder.search("#EDC"), expectedPatternName);
    assertPattern(finder.search("$RFV"), expectedPatternName);
    assertPattern(finder.search("%TGB"), expectedPatternName);
    assertPattern(finder.search("^YHN"), expectedPatternName);
    assertPattern(finder.search("&UJM"), expectedPatternName);
    assertPattern(finder.search("*IK<"), expectedPatternName);
    assertPattern(finder.search("(OL>"), expectedPatternName);
    assertPattern(finder.search(")P:?"), expectedPatternName);
    assertPattern(finder.search("_{\""), expectedPatternName);
  }

  private void assertPattern(PatternCollection patterns, String expectedPatternName) throws Exception {
    AnalysisResult cost = analyzer.calculateHighestProbablePatterns(patterns);
    assertEquals(1, cost.getPath().size());
    assertEquals(expectedPatternName, cost.getPath().get(0).getName());
  }

}