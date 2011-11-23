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
package com.passfault.dictionary;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author cam
 *
 */
public class LevenshteinDistanceTest {

  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test_partialDistance() {
    String s = "wisp";
    int expectedValue = 1;
    LevenshteinDistance ld = new LevenshteinDistance(s);
    ld.appendToTarget('a');
    ld.appendToTarget('i');
    ld.updateDist();
    int actualValue = ld.partialDistance();
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void test_smaller_target() {
    String s = "country";
    String t = "cougar";
    int expectedValue = LevenshteinDistance.getLevenshteinDistance(s, t);

    int actualValue;
    actualValue = getIncrementalDistance(s, t);
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void test_smaller_target2() {
    String s = "country";
    String t = "(ougar";
    int expectedValue = LevenshteinDistance.getLevenshteinDistance(s, t);

    int actualValue;
    actualValue = getIncrementalDistance(s, t);
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void test_same_size_target() {
    String s = "country";
    String t = "cougary";
    int expectedValue = LevenshteinDistance.getLevenshteinDistance(s, t);

    int actualValue;
    actualValue = getIncrementalDistance(s, t);
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void test_larger_target() {
    String s = "something";
    String t = "somethingelse";
    int expectedValue = LevenshteinDistance.getLevenshteinDistance(s, t);

    int actualValue;
    actualValue = getIncrementalDistance(s, t);
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void test_larger_target2() {
    String s = "something";
    String t = "som31hingelse";
    int expectedValue = LevenshteinDistance.getLevenshteinDistance(s, t);

    int actualValue;
    actualValue = getIncrementalDistance(s, t);
    assertEquals(expectedValue, actualValue);
  }

  private int getIncrementalDistance(String s, String t) {
    int actualValue;
    LevenshteinDistance ld = new LevenshteinDistance(s);

    for (int i = 0, len = t.length(); i < len; i++) {
      ld.appendToTarget(t.charAt(i));
      actualValue = ld.updateDist();
      System.out.println("add char: " + t.charAt(i) + " dist = " + actualValue + "(" + ld.distance()
          + "), relativeDistance = " + ld.partialDistance());
    }
    actualValue = ld.distance();
    return actualValue;
  }

  @Test
  public void test_partial_distance() {
    String s = "country";
    String t = "cougary";

    LevenshteinDistance ld = new LevenshteinDistance(s);
    ld.appendToTarget('c');
    ld.updateDist();
    assertEquals(0, ld.partialDistance());
    assertEquals(6, ld.distance());

    ld.appendToTarget('o');
    ld.updateDist();
    assertEquals(0, ld.partialDistance());
    assertEquals(5, ld.distance());

    ld.appendToTarget('u');
    ld.updateDist();
    assertEquals(0, ld.partialDistance());
    assertEquals(4, ld.distance());

    ld.appendToTarget('g');
    ld.updateDist();
    assertEquals(1, ld.partialDistance());
    assertEquals(4, ld.distance());

    ld.appendToTarget('a');
    ld.updateDist();
    assertEquals(2, ld.partialDistance());
    assertEquals(4, ld.distance());

    ld.appendToTarget('r');
    ld.updateDist();
    assertEquals(2, ld.partialDistance());
    assertEquals(3, ld.distance());

    ld.appendToTarget('y');
    ld.updateDist();
    assertEquals(2, ld.partialDistance());
    assertEquals(2, ld.distance());

  }
}
