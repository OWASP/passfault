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


import java.util.List;
import static junit.framework.Assert.*;
import junit.framework.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.owasp.passfault.*;
import org.owasp.passfault.dictionary.DictionaryPatternsFinder;
import org.owasp.passfault.dictionary.FileDictionary;
import org.owasp.passfault.dictionary.SubstitutionStrategy;

public class SubstitutionFinderTest {

  private static DictionaryPatternsFinder finder;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    FileDictionary dictionary = FileDictionary.newInstance(TestWords.getTestFile(), "tiny-lower");
    finder = new DictionaryPatternsFinder(dictionary, new SubstitutionStrategy(1));
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
  public void findWord_plain2() throws Exception {
    System.out.println("findWord");
    MockPasswordResults p = new MockPasswordResults("password");
    finder.analyze(p);
    assertEquals(0, p.getPossiblePatternCount());
  }

  @Test
  public void findWord_plain() throws Exception {
    System.out.println("findWord");
    MockPasswordResults p = new MockPasswordResults("wisp");
    finder.analyze(p);
    assertEquals(0, p.getPossiblePatternCount());
  }

  @Test
  public void findWord() throws Exception {
    System.out.println("findWord");
    MockPasswordResults p = new MockPasswordResults("w1sp");//wasp, asp, wisp, was
    finder.analyze(p);
    assertEquals(4, p.getPossiblePatternCount());
  }

  @Test
  public void findWord_garbageinfront() throws Exception {
    System.out.println("findWord_garbageinfront");
    MockPasswordResults p = new MockPasswordResults("xxxxw1sp");//wasp, asp, wisp, was
    finder.analyze(p);
    assertEquals(4, p.getPossiblePatternCount());
  }

  @Test
  public void findWord_garbageinback() throws Exception {

    System.out.println("findWord_garbageinback");
    MockPasswordResults p = new MockPasswordResults("w1spxxxx");//wasp, asp, wisp, was
    finder.analyze(p);
    assertEquals(4, p.getPossiblePatternCount());
  }

  @Test
  public void findNonWord() throws Exception {
    System.out.println("findNonWord");

    MockPasswordResults p = new MockPasswordResults("qqq123");
    finder.analyze(p);
    assertEquals(0, p.getPossiblePatternCount());
  }

  @Test
  public void findMultiWords() throws Exception {
    System.out.println("findMultiWords");
    MockPasswordResults p = new MockPasswordResults("w1spw1sp");//wasp, asp, wisp, was *2
    finder.analyze(p);
    assertEquals(8, p.getPossiblePatternCount());
  }

  @Test
  public void testLength() throws Exception {
    System.out.println("findMultiWords");
    MockPasswordResults p = new MockPasswordResults("runr&n");//run, ran,
    finder.analyze(p);
    List<PasswordPattern> patterns = p.getFoundPatterns();
    for (PasswordPattern pattern : patterns) {
      assertEquals(3, pattern.getLength());
      System.out.println(pattern.getMatchString());
    }
    assertEquals(4, p.getPossiblePatternCount());
  }
}
