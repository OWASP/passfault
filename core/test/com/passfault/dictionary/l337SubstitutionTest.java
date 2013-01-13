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
package com.passfault.dictionary;

import com.passfault.MockPasswordResults;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cam
 */
public class l337SubstitutionTest {

  private static DictionaryPatternsFinder finder;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    FileDictionary dictionary = FileDictionary.newInstance("./test/tiny-lower.words", "tiny-lower");
    finder = new DictionaryPatternsFinder(dictionary, new l337SubstitutionStrategy());
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

  @Test
  public void findWord() throws Exception {
    System.out.println("findWord");
    MockPasswordResults p = new MockPasswordResults("ca2");//car
    finder.analyze(p);
    assertEquals(1, p.getPossiblePatternCount());
  }

  @Test
  public void findWord_multiple_char() throws Exception {
    System.out.println("findWord");
    MockPasswordResults p = new MockPasswordResults("ca|2");  //car, air
    finder.analyze(p);
    assertEquals(2, p.getPossiblePatternCount());
  }

  @Test
  public void findNoSubstitution() throws Exception {
    System.out.println("findWord");
    MockPasswordResults p = new MockPasswordResults("or.");  //
    finder.analyze(p);
    assertEquals(0, p.getPossiblePatternCount());
  }

  @Test
  public void findWord_multiple_char_run() throws Exception {
    System.out.println("findWord");
    MockPasswordResults p = new MockPasswordResults("|2un");  //run and |run
    finder.analyze(p);
    assertEquals(2, p.getPossiblePatternCount());
  }

  @Test
  public void findWord_front() throws Exception {
    System.out.println("findWord");
    MockPasswordResults p = new MockPasswordResults("2oot");  //root zoo
    finder.analyze(p);
    assertEquals(2, p.getPossiblePatternCount());
  }

  @Test
  public void findWord_front_zoo() throws Exception {
    System.out.println("findWord");
    MockPasswordResults p = new MockPasswordResults("~/_oo"); //zoo
    finder.analyze(p);
    assertEquals(1, p.getPossiblePatternCount());
  }

  @Test
  public void findWord_multipleLeet() throws Exception {
    System.out.println("findWord");
    MockPasswordResults p = new MockPasswordResults("2()()+");//zoo, root
    finder.analyze(p);
    assertEquals(2, p.getPossiblePatternCount());
  }

  @Test
  public void findWord_front_multichar() throws Exception {
    System.out.println("findWord");
    MockPasswordResults p = new MockPasswordResults("~/_oo");//zoo
    finder.analyze(p);
    assertEquals(1, p.getPossiblePatternCount());
  }

  @Test
  public void findWord_front_multichar_root() throws Exception {
    System.out.println("findWord");
    MockPasswordResults p = new MockPasswordResults("2oot");//root zoo
    finder.analyze(p);
    assertEquals(2, p.getPossiblePatternCount());
  }
}
