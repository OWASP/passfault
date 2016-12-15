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

public class InsertionFinderTest {

  private static DictionaryPatternsFinder finder;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    FileDictionary dictionary = FileDictionary.newInstance(TestWords.getTestFile(), "tiny-lower");
    finder = new DictionaryPatternsFinder(dictionary, new InsertionStrategy(5));
  }

  @Test
  public void plain2() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("trouble");
    finder.analyze(p);
    assertEquals(0, p.getPossiblePatternCount());
  }

  @Test
  public void plain() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("wisp");
    finder.analyze(p);
    assertEquals(0, p.getPossiblePatternCount());
  }

  @Test
  public void findWord() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("trou$ble");
    finder.analyze(p);
    assertEquals(2, p.getPossiblePatternCount());
  }

  @Test
  public void tooMany() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("t$r$o$u$b$l$e");
    finder.analyze(p);
    assertEquals(0, p.getPossiblePatternCount());
  }

  @Test
  public void garbageInFront() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("xxxxtrou-ble");//wasp, asp, wisp, was
    finder.analyze(p);
    assertEquals(2, p.getPossiblePatternCount());
  }

  @Test
  public void garbageInBack() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("troub!lexxxx");//wasp, asp, wisp, was
    finder.analyze(p);
    assertEquals(2, p.getPossiblePatternCount());
  }

  @Test
  public void findNonWord() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("qqq123");
    finder.analyze(p);
    assertEquals(0, p.getPossiblePatternCount());
  }

  @Test
  public void findMultiWords() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("tr-oubletro+uble");//wasp, asp, wisp, was *2
    finder.analyze(p);
    assertEquals(4, p.getPossiblePatternCount());
  }
}
