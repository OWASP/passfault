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

import com.passfault.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static junit.framework.Assert.*;

public class AugmentationFinderText {

  private static DictionaryPatternsFinder finder;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    FileDictionary dictionary = FileDictionary.newInstance("./test/tiny-lower.words", "tiny-lower");
    finder = new DictionaryPatternsFinder(dictionary, new AugmentationStrategy(1));
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
  public void findWord_plain() throws Exception {
    System.out.println("findWord");
    MockPasswordResults p = new MockPasswordResults("wisp");
    finder.analyze(p);
    assertEquals(0, p.getPossiblePatternCount());
  }

  @Test
  public void findWord_numbersInFront() throws Exception {
    System.out.println("findWord");
    MockPasswordResults p = new MockPasswordResults("1wisp");
    finder.analyze(p);
    assertEquals(0, p.getPossiblePatternCount());
  }

  @Test
  public void findWord_numbersInBack() throws Exception {
    System.out.println("findWord");
    MockPasswordResults p = new MockPasswordResults("wisp1");
    finder.analyze(p);
    assertEquals(0, p.getPossiblePatternCount());
  }

  @Test
  public void findWord() throws Exception {
    System.out.println("findWord");
    MockPasswordResults p = new MockPasswordResults("wi3sp");
    finder.analyze(p);
    assertEquals(1, p.getPossiblePatternCount());
  }

  @Test
  public void findWord_garbageinfront() throws Exception {
    System.out.println("findWord_garbageinfront");
    MockPasswordResults p = new MockPasswordResults("xxxxwi6sp");
    finder.analyze(p);
    assertEquals(1, p.getPossiblePatternCount());
  }

  @Test
  public void findWord_garbageinback() throws Exception {

    System.out.println("findWord_garbageinback");
    MockPasswordResults p = new MockPasswordResults("wi1spxxxx");
    finder.analyze(p);
    assertEquals(1, p.getPossiblePatternCount());
  }

  @Test
  public void findNonWord() throws Exception {
    System.out.println("findNonWord");

    MockPasswordResults p = new MockPasswordResults("qqq");
    finder.analyze(p);
    assertEquals(0, p.getPossiblePatternCount());
  }

  @Test
  public void findMultiWords() throws Exception {
    System.out.println("findMultiWords");
    MockPasswordResults p = new MockPasswordResults("wi3spwi3sp");
    finder.analyze(p);
    assertEquals(2, p.getPossiblePatternCount());
  }
}
