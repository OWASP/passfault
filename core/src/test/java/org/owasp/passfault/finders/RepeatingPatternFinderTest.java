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
package org.owasp.passfault.finders;

import org.junit.Test;
import org.owasp.passfault.PasswordResultsImpl;
import org.owasp.passfault.PasswordPattern;
import org.owasp.passfault.PathCost;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class RepeatingPatternFinderTest {

  @Test
  public void dup() {
    System.out.println("process");

    PasswordResultsImpl password = new PasswordResultsImpl("abcabc");
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
  public void nonDup() {
    System.out.println("process");

    PasswordResultsImpl password = new PasswordResultsImpl("abcabc");
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
  public void twoDup() {
    System.out.println("process");

    PasswordResultsImpl password = new PasswordResultsImpl("abcabcabc");
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
  public void dupExtra() {
    System.out.println("process");

    PasswordResultsImpl password = new PasswordResultsImpl("123abc456abc789");
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
