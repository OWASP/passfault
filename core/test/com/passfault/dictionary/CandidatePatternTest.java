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
public class CandidatePatternTest {

  public CandidatePatternTest() {
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
   * Test of clone method, of class CandidatePattern.
   */
  @Test
  public void testGetUpperCaseFactor() throws Exception {
    System.out.println("getUpperCaseFactor");
    assertEquals(1, CandidatePattern.getUpperCaseFactor(6, 0));
    assertEquals(6, CandidatePattern.getUpperCaseFactor(6, 1));
    assertEquals(6 * 5, CandidatePattern.getUpperCaseFactor(6, 2));
    assertEquals(6 * 5 * 4, CandidatePattern.getUpperCaseFactor(6, 3));
    assertEquals(6 * 5, CandidatePattern.getUpperCaseFactor(6, 4));
    assertEquals(6, CandidatePattern.getUpperCaseFactor(6, 5));
    assertEquals(1, CandidatePattern.getUpperCaseFactor(6, 6));
  }

  @Test
  public void testGetUpperCaseFactor_odd() throws Exception {
    System.out.println("getUpperCaseFactor");
    assertEquals(1, CandidatePattern.getUpperCaseFactor(7, 0));
    assertEquals(7, CandidatePattern.getUpperCaseFactor(7, 1));
    assertEquals(7 * 6, CandidatePattern.getUpperCaseFactor(7, 2));
    assertEquals(7 * 6 * 5, CandidatePattern.getUpperCaseFactor(7, 3));
    assertEquals(7 * 6 * 5, CandidatePattern.getUpperCaseFactor(7, 4));
    assertEquals(7 * 6, CandidatePattern.getUpperCaseFactor(7, 5));
    assertEquals(7, CandidatePattern.getUpperCaseFactor(7, 6));
    assertEquals(1, CandidatePattern.getUpperCaseFactor(7, 7));

  }
}
