/* ©Copyright 2011 Cameron Morris
 *
 * This file is part of Passfault.
 *
 * Passfault is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Passfault is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Passfault.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.passfault;

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
   * Test of getTimeToCrackMilliSeconds method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrackMilliSeconds() {
    System.out.println("getTimeToCrackMilliSeconds");
    double crackability = 2;
    TimeToCrack instance = TimeToCrack.dualCore;
    instance.setTestTime(1000);
    double expResult = 1000;
    double result = instance.getTimeToCrackMilliSeconds(crackability);
    assertEquals(expResult, result, 0.0001);
  }

  /**
   * Test of getTimeToCrackString method, of class TimeToCrack.
   */
  @Test
  public void testGetTimeToCrack_lessThan1Day() {
    System.out.println("getTimeToCrackString");
    double crackability = 2;
    TimeToCrack instance = TimeToCrack.dualCore;
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
    String result = TimeToCrack.dualCore.getRoundedSizeString(100000000);
    String expResult = "100 million";
    assertEquals(expResult, result);
  }

  private void testTime(int days, String expResult) {
    double crackability = (double) (2 * (double) days * 24 * 60 * 60);
    TimeToCrack instance = TimeToCrack.dualCore;
    instance.setTestTime(1000);
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
    assertEquals("100,000 decillion", TimeToCrack.dualCore.getRoundedSizeString(instance));
  }
}
