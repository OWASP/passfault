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

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author cam
 */
public class RepeatingPatternFinderTest {

  public RepeatingPatternFinderTest() {
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
   * Test of process method, of class RepeatingPatternFinder.
   */
  @Test
  public void testDup() {
    System.out.println("process");

    PasswordAnalysis password = new PasswordAnalysis("abcabc");
    PathCost cost = new PathCost(password);
    cost.addPattern(new PasswordPattern(3, 3, "abc", 100, "test pattern"));
    cost.addPattern(new PasswordPattern(0, 3, "abc", 100, "test pattern"));

    RepeatingPatternFinder instance = new RepeatingPatternFinder();
    PathCost result = instance.process(cost, password);
    assertEquals(100, (int) result.getTotalCost());
    List<PasswordPattern> pattList = result.getPath();
    assertEquals(2, pattList.size());
    assertEquals(RepeatingPatternFinder.DUPLICATE_PATTERN, pattList.get(1).getName());
  }

  @Test
  public void testNonDup() {
    System.out.println("process");

    PasswordAnalysis password = new PasswordAnalysis("abcabc");
    PathCost cost = new PathCost(password);
    cost.addPattern(new PasswordPattern(3, 3, "abc", 100, "test pattern"));
    cost.addPattern(new PasswordPattern(0, 3, "xyz", 100, "test pattern"));

    RepeatingPatternFinder instance = new RepeatingPatternFinder();
    PathCost result = instance.process(cost, password);
    assertEquals(100 * 100, (int) result.getTotalCost());
    List<PasswordPattern> pattList = result.getPath();
    assertEquals(2, pattList.size());
    assertNotSame(RepeatingPatternFinder.DUPLICATE_PATTERN, pattList.get(1).getName());
  }

  @Test
  public void test2dup() {
    System.out.println("process");

    PasswordAnalysis password = new PasswordAnalysis("abcabcabc");
    PathCost cost = new PathCost(password);
    cost.addPattern(new PasswordPattern(6, 3, "abc", 100, "test pattern"));
    cost.addPattern(new PasswordPattern(3, 3, "abc", 100, "test pattern"));
    cost.addPattern(new PasswordPattern(0, 3, "abc", 100, "test pattern"));

    RepeatingPatternFinder instance = new RepeatingPatternFinder();
    PathCost result = instance.process(cost, password);
    assertEquals(100, (int) result.getTotalCost());
    List<PasswordPattern> pattList = result.getPath();
    assertEquals(3, pattList.size());
    assertEquals(RepeatingPatternFinder.DUPLICATE_PATTERN, pattList.get(1).getName());
    assertEquals(RepeatingPatternFinder.DUPLICATE_PATTERN, pattList.get(2).getName());
  }

  @Test
  public void testDupExtra() {
    System.out.println("process");

    PasswordAnalysis password = new PasswordAnalysis("123abc456abc789");
    PathCost cost = new PathCost(password);
    cost.addPattern(new PasswordPattern(9, 3, "abc", 100, "test pattern"));
    cost.addPattern(new PasswordPattern(3, 3, "abc", 100, "test pattern"));

    RepeatingPatternFinder instance = new RepeatingPatternFinder();
    PathCost result = instance.process(cost, password);
    List<PasswordPattern> pattList = result.getPath();
    assertEquals(2, pattList.size());
    assertEquals(RepeatingPatternFinder.DUPLICATE_PATTERN, pattList.get(1).getName());
  }
}
