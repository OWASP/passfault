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
import org.owasp.passfault.PasswordPattern;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SubstitutionFinderTest {

  private static DictionaryPatternsFinder finder;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    FileDictionary dictionary = FileDictionary.newInstance(TestWords.getTestFile(), "tiny-lower");
    finder = new DictionaryPatternsFinder(dictionary, new SubstitutionStrategy(1));
  }

  @Test
  public void plain2() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("password");
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
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("w1sp");//wasp, asp, wisp, was
    finder.analyze(p);
    assertEquals(4, p.getPossiblePatternCount());
  }

  @Test
  public void garbageInFront() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("xxxxw1sp");//wasp, asp, wisp, was
    finder.analyze(p);
    assertEquals(4, p.getPossiblePatternCount());
  }

  @Test
  public void garbageInBack() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("w1spxxxx");//wasp, asp, wisp, was
    finder.analyze(p);
    assertEquals(4, p.getPossiblePatternCount());
  }

  @Test
  public void findNonWord() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("qqq123");
    finder.analyze(p);
    assertEquals(0, p.getPossiblePatternCount());
  }

  @Test
  public void findMultiWords() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("w1spw1sp");//wasp, asp, wisp, was *2
    finder.analyze(p);
    assertEquals(8, p.getPossiblePatternCount());
  }

  @Test
  public void testLength() throws Exception {
    MockPatternsAnalyzer p = new MockPatternsAnalyzer("runr&n");//run, ran,
    finder.analyze(p);
    List<PasswordPattern> patterns = p.getFoundPatterns();
    for (PasswordPattern pattern : patterns) {
      assertEquals(3, pattern.getLength());
      System.out.println(pattern.getMatchString());
    }
    assertEquals(4, p.getPossiblePatternCount());
  }
}
