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

import com.passfault.PasswordAnalysis;
import com.passfault.PasswordPattern;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cam
 */
public class BackwardsAnalysisAdapterTest {

  public BackwardsAnalysisAdapterTest() {
  }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of getChars method, of class BackWardsAnalysisAdapter.
   */
  @Test
  public void testGetChars() {
    System.out.println("getChars");

    BackwardsAnalysisAdapter instance = new BackwardsAnalysisAdapter(new PasswordAnalysis("backwards"));
    CharSequence expResult = new StringBuilder("backwards").reverse().toString();
    CharSequence result = instance.getCharSequence();
    assertEquals(expResult, result);
  }

  /**
   * Test of getChars method, of class BackWardsAnalysisAdapter.
   */
  @Test
  public void testAdaptedBackwards() {
    System.out.println("testAdaptedBackwards");

    {
      BackwardsAnalysisAdapter instance = new BackwardsAnalysisAdapter(new PasswordAnalysis(
          "012drow78"));
      //reversed would be= 87word210
      //it would find 'word' at index 2

      int reverseStartingIndex = 2;
      int actualStartingIndex = 3;
      assertAdaptedReverse(instance, reverseStartingIndex, actualStartingIndex);
    }
    {
      BackwardsAnalysisAdapter instance = new BackwardsAnalysisAdapter(new PasswordAnalysis(
          "012drow"));
      //reversed would be= word210
      //it would find 'word' at index 0

      int reverseStartingIndex = 0;
      int actualStartingIndex = 3;
      assertAdaptedReverse(instance, reverseStartingIndex, actualStartingIndex);
    }
    {
      BackwardsAnalysisAdapter instance = new BackwardsAnalysisAdapter(new PasswordAnalysis(
          "drow78"));
      //reversed would be= 87word
      //it would find 'word' at index 2

      int reverseStartingIndex = 2;
      int actualStartingIndex = 0;
      assertAdaptedReverse(instance, reverseStartingIndex, actualStartingIndex);
    }
  }

  private void assertAdaptedReverse(BackwardsAnalysisAdapter instance, int reverseStartingIndex, int actualStartingIndex) {
    instance.foundPattern(new PasswordPattern(reverseStartingIndex, 4, "word", 4, "word", "word", "english"));
    List<PasswordPattern> path = instance.calculateHighestProbablePatterns().getPath();
    boolean foundPattern = false;
    for (PasswordPattern patt : path) {
      if (BackwardsAnalysisAdapter.NAME.equalsIgnoreCase(patt.getName())) {
        assertEquals(actualStartingIndex, patt.getStartIndex());
        foundPattern = true;
      }
    }
    assertTrue(foundPattern);
  }
}
