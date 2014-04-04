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
package org.owasp.passfault;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.owasp.passfault.TimeToCrack;

import static org.junit.Assert.*;

/**
 *
 * @author cam
 */
public class TimeToCrackTest {

  public TimeToCrackTest() {
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
   * Test of getTimeToCrackNanoSeconds method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrackNanoSeconds() {
    System.out.println("getTimeToCrackNanoSeconds");
    double crackability = 1;
    TimeToCrack instance = TimeToCrack.GPU1;
    instance.setTestTime(1000000000);
    double expResult = 1000000000;
    double result = instance.getTimeToCrackNanoSeconds(crackability);
    assertEquals(expResult, result, 0.0000000001);
  }

  /**
   * Test of getTimeToCrackString method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrack_lessThan1Day() {
    System.out.println("getTimeToCrackString");
    double crackability = 2;
    TimeToCrack instance = TimeToCrack.GPU1;
    String expResult = "less than 1 day";
    String result = instance.getTimeToCrackString(crackability);
    assertEquals(expResult, result);
  }

  /**
   * Test of getTimeToCrackString method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrack_days() {
    System.out.println("getTimeToCrackString");
    int days = 3;
    String expResult = "3 days";
    testTime(days, expResult);
  }

  /**
   * Test of getTimeToCrackString method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrack_months() {
    System.out.println("getTimeToCrackString");
    int days = 31;
    String expResult = "1 month, 1 day";
    testTime(days, expResult);
  }

  /**
   * Test of getTimeToCrackString method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrack_months2() {
    System.out.println("getTimeToCrackString");
    int days = 62;
    String expResult = "2 months, 2 days";
    testTime(days, expResult);
  }

  /**
   * Test of getTimeToCrackString method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrack_years() {
    System.out.println("getTimeToCrackString");
    int days = 366;
    String expResult = "1 year";
    testTime(days, expResult);
  }

  /**
   * Test of getTimeToCrackString method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrack_years2() {
    System.out.println("getTimeToCrackString");
    int days = 366 + 31;
    String expResult = "1 year, 1 month";
    testTime(days, expResult);
  }

  /**
   * Test of getTimeToCrackString method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrack_years3() {
    System.out.println("getTimeToCrackString");
    int days = 366 + 62;
    String expResult = "1 year, 2 months";
    testTime(days, expResult);
  }

  /**
   * Test of getTimeToCrackString method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrack_years4() {
    System.out.println("getTimeToCrackString");
    int days = 365 * 3 + 31;
    String expResult = "3 years, 1 month";
    testTime(days, expResult);
  }

  /**
   * Test of getTimeToCrackString method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrack_years5() {
    System.out.println("getTimeToCrackString");
    int days = 365 * 9 + 31;
    String expResult = "9 years, 2 months";
    testTime(days, expResult);
  }

  /**
   * Test of getTimeToCrackString method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrack_decade() {
    System.out.println("getTimeToCrackString");
    int days = 365 * 10 + 31;
    String expResult = "1 decade";
    testTime(days, expResult);
  }

  /**
   * Test of getTimeToCrackString method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrack_decade2() {
    System.out.println("getTimeToCrackString");
    int days = 365 * 11 + 31;
    String expResult = "1 decade, 1 year";
    testTime(days, expResult);
  }

  /**
   * Test of getTimeToCrackString method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrack_decades() {
    System.out.println("getTimeToCrackString");
    int days = 365 * 20 + 31;
    String expResult = "2 decades";
    testTime(days, expResult);
  }

  /**
   * Test of getTimeToCrackString method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrack_decades2() {
    System.out.println("getTimeToCrackString");
    int days = 365 * 22 + 31;
    String expResult = "2 decades, 2 years";
    testTime(days, expResult);
  }

  /**
   * Test of getTimeToCrackString method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrack_century() {
    System.out.println("getTimeToCrackString");
    int days = 365 * 100 + 31;
    String expResult = "1 century";
    testTime(days, expResult);
  }

  /**
   * Test of getTimeToCrackString method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrack_centurys() {
    System.out.println("getTimeToCrackString");
    int days = 365 * 200 + 31;
    String expResult = "2 centuries";
    testTime(days, expResult);
  }

  @Test
  public void testGetRoundedString() {
    System.out.println("getRoundedString");
    String result = TimeToCrack.getRoundedSizeString(100000000);
    String expResult = "100 million";
    assertEquals(expResult, result);
  }

  private void testTime(int days, String expResult) {
    double crackability = (double) (1 * (double) days * 24 * 60 * 60);
    TimeToCrack instance = TimeToCrack.GPU1;
    instance.setTestTime(1000000000);
    String result = instance.getTimeToCrackString(crackability);
    assertEquals(expResult, result);
  }

  @Test
  public void bcrypt() {

    // Hash a password for the first time
    String hashed = BCrypt.hashpw("something", BCrypt.gensalt());
  }

  @Test
  public void getRoundedSizeString() {
    double instance = Math.pow(10, 38);
    assertEquals("100,000 decillion", TimeToCrack.getRoundedSizeString(instance));
  }
}
