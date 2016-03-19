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

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LevenshteinDistanceTest {

  @Test
  public void partialDistance() {
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
  public void smaller_target() {
    String s = "country";
    String t = "cougar";
    int expectedValue = LevenshteinDistance.getLevenshteinDistance(s, t);

    int actualValue;
    actualValue = getIncrementalDistance(s, t);
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void smaller_target2() {
    String s = "country";
    String t = "(ougar";
    int expectedValue = LevenshteinDistance.getLevenshteinDistance(s, t);

    int actualValue;
    actualValue = getIncrementalDistance(s, t);
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void same_size_target() {
    String s = "country";
    String t = "cougary";
    int expectedValue = LevenshteinDistance.getLevenshteinDistance(s, t);

    int actualValue;
    actualValue = getIncrementalDistance(s, t);
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void larger_target() {
    String s = "something";
    String t = "somethingelse";
    int expectedValue = LevenshteinDistance.getLevenshteinDistance(s, t);

    int actualValue;
    actualValue = getIncrementalDistance(s, t);
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void larger_target2() {
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
  public void partial_distance() {
    String s = "country";

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
