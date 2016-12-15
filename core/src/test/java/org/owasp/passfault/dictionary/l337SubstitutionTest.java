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

import org.junit.BeforeClass;
import org.junit.Test;
import org.owasp.passfault.MockPatternsAnalyzer;

import static org.junit.Assert.assertEquals;

/**
 * @author cam
 */
public class l337SubstitutionTest {

  private static DictionaryPatternsFinder finder;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    FileDictionary dictionary = FileDictionary.newInstance(TestWords.getTestFile(), "tiny-lower");
    finder = new DictionaryPatternsFinder(dictionary, new l337SubstitutionStrategy());
  }


  @Test
  public void findWord() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("ca2");//car
    finder.analyze(p);
    assertEquals(1, p.getPossiblePatternCount());
  }

  @Test
  public void multiple_char() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("ca|2");  //car, air
    finder.analyze(p);
    assertEquals(2, p.getPossiblePatternCount());
  }

  @Test
  public void findNoSubstitution() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("or.");  //
    finder.analyze(p);
    assertEquals(0, p.getPossiblePatternCount());
  }

  @Test
  public void multiple_char_run() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("|2un");  //run and |run
    finder.analyze(p);
    assertEquals(2, p.getPossiblePatternCount());
  }

  @Test
  public void front() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("2oot");  //root zoo
    finder.analyze(p);
    assertEquals(2, p.getPossiblePatternCount());
  }

  @Test
  public void front_zoo() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("~/_oo"); //zoo
    finder.analyze(p);
    assertEquals(1, p.getPossiblePatternCount());
  }

  @Test
  public void multipleLeet() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("2()()+");//zoo, root
    finder.analyze(p);
    assertEquals(2, p.getPossiblePatternCount());
  }

  @Test
  public void front_multichar() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("~/_oo");//zoo
    finder.analyze(p);
    assertEquals(1, p.getPossiblePatternCount());
  }

  @Test
  public void front_multichar_root() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("2oot");//root zoo
    finder.analyze(p);
    assertEquals(2, p.getPossiblePatternCount());
  }
}
