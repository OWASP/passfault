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

import org.junit.*;
import org.owasp.passfault.*;
import org.owasp.passfault.io.MockPasswordResults;

import static org.junit.Assert.*;

public class DictionaryPatternsFinderTest {

  private static DictionaryPatternsFinder finder;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    FileDictionary dictionary = FileDictionary.newInstance(TestWords.getTestFile(), "tiny-lower");
    finder = new DictionaryPatternsFinder(dictionary, new ExactWordStrategy());
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void findWord() throws Exception {
    System.out.println("findWord");
    PasswordAnalysis p = new PasswordAnalysis("wisp");
    finder.analyze(p);
    assertEquals(1, p.getPossiblePatternCount());

  }

  @Test
  public void findWord_garbageinfront() throws Exception {
    System.out.println("findWord_garbageinfront");
    PasswordAnalysis p = new PasswordAnalysis("1234wisp");
    finder.analyze(p);
    assertEquals(1, p.getPossiblePatternCount());
  }

  @Test
  public void findWord_garbageinback() throws Exception {

    System.out.println("findWord_garbageinback");
    PasswordAnalysis p = new PasswordAnalysis("wisp1234");
    finder.analyze(p);
    assertEquals(1, p.getPossiblePatternCount());
  }

  @Test
  public void findNonWord() throws Exception {
    System.out.println("findNonWord");

    PasswordAnalysis p = new PasswordAnalysis("qqq");
    finder.analyze(p);
    assertEquals(0, p.getPossiblePatternCount());
  }

  @Test
  public void findMultiWords() throws Exception {
    System.out.println("findMultiWords");
    PasswordAnalysis p = new PasswordAnalysis("wispwisp");
    finder.analyze(p);
    assertEquals(2, p.getPossiblePatternCount());
  }

  @Test
  public void findWordWithMulti() throws Exception {
    System.out.println("findMultiWords");
    PasswordAnalysis p = new PasswordAnalysis("password");
    finder.analyze(p);
    assertEquals(4, p.getPossiblePatternCount());
    assertEquals("password", p.calculateHighestProbablePatterns().getPath().get(0).getMatchString());
  }

  @Test
  public void findWordWithMultiUpper() throws Exception {
    System.out.println("findMultiWords");
    MockPasswordResults p = new MockPasswordResults("Password");
    finder.analyze(p);
    assertEquals(6, p.getPossiblePatternCount());
  }
}
