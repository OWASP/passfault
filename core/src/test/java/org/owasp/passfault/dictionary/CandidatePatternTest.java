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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.owasp.passfault.dictionary.CandidatePattern;

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
