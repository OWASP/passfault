/* ©Copyright 2011 Cameron Morris
 *
 * This file is part of Passfault.
 *
 * Passfault is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Passfault is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Passfault.  If not, see <http://www.gnu.org/licenses/>.
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
