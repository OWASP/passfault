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

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PasswordResultsImplTest {

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
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
  public void randomNumbers() {
    PasswordResultsImpl pa = new PasswordResultsImpl("1234");
    PathCost patterns = pa.calculateHighestProbablePatterns();

    List<PasswordPattern> list = patterns.getPath();
    assertEquals(1, list.size());
    double result = patterns.getTotalCost();
    System.out.println("cost=" + result);
    double expected = Math.pow(10, 4);
    assertEquals(expected, result, 0.5);
  }

  @Test
  public void onePattern_Middle() {
    PasswordResultsImpl pa = new PasswordResultsImpl("1234");
    pa.foundPattern(new PasswordPattern(1, 2, "23", 4, "testPattern"));

    PathCost patterns = pa.calculateHighestProbablePatterns();

    List<PasswordPattern> list = patterns.getPath();
    assertEquals(3, list.size());
    double result = patterns.getTotalCost();
    System.out.println("cost=" + result);
    patterns.getTotalCost();
    double expected = Math.pow(10, 2) * 4;
    assertEquals(expected, result, 0.5);
  }

  @Test
  public void onePattern_End() {
    PasswordResultsImpl pa = new PasswordResultsImpl("1234");
    pa.foundPattern(new PasswordPattern(2, 2, "34", 4, "testPattern"));

    PathCost patterns = pa.calculateHighestProbablePatterns();

    List<PasswordPattern> list = patterns.getPath();
    assertEquals(2, list.size());
    double result = patterns.getTotalCost();
    System.out.println("cost=" + result);
    double expected = Math.pow(10, 2) * 4;
    assertEquals(expected, result, 0.5);
  }

  @Test
  public void onePattern_beginning() {
    PasswordResultsImpl pa = new PasswordResultsImpl("1234");
    pa.foundPattern(new PasswordPattern(0, 2, "12", 4, "testPattern"));

    PathCost patterns = pa.calculateHighestProbablePatterns();

    List<PasswordPattern> list = patterns.getPath();
    assertEquals(2, list.size());
    double result = patterns.getTotalCost();
    System.out.println("cost=" + result);
    double expected = Math.pow(10, 2) * 4;
    assertEquals(expected, result, 0.5);
  }

  @Test
  public void twoPattern_middle() {
    PasswordResultsImpl pa = new PasswordResultsImpl("12345");
    pa.foundPattern(new PasswordPattern(1, 1, "2", 2, "testPattern"));
    pa.foundPattern(new PasswordPattern(3, 1, "4", 2, "testPattern"));

    PathCost patterns = pa.calculateHighestProbablePatterns();

    List<PasswordPattern> list = patterns.getPath();
    assertEquals(5, list.size());
    double result = patterns.getTotalCost();
    System.out.println("cost=" + result);

    double expected = Math.pow(10, 3) * 4;
    assertEquals(expected, result, 0.5);
  }

  @Test
  public void onePattern_overlap() {
    PasswordResultsImpl pa = new PasswordResultsImpl("12345");
    pa.foundPattern(new PasswordPattern(1, 2, "23", 15, "worstPattern"));
    pa.foundPattern(new PasswordPattern(1, 2, "23", 4, "bestPattern"));
    pa.foundPattern(new PasswordPattern(1, 2, "23", 20, "worsePattern"));
    pa.foundPattern(new PasswordPattern(1, 2, "23", 23, "worserPattern"));

    PathCost patterns = pa.calculateHighestProbablePatterns();

    List<PasswordPattern> list = patterns.getPath();
    assertEquals(3, list.size());
    double result = patterns.getTotalCost();
    System.out.println("cost=" + result);
    double expected = Math.pow(10, 3) * 4;
    assertEquals(expected, result, 0.5);
  }

  @Test
  public void twoPattern_overlap() {
    PasswordResultsImpl pa = new PasswordResultsImpl("12345");
    pa.foundPattern(new PasswordPattern(1, 1, "2", 15, "badPattern"));
    pa.foundPattern(new PasswordPattern(1, 1, "2", 4, "bestPattern"));
    pa.foundPattern(new PasswordPattern(1, 1, "2", 20, "worserPattern"));
    pa.foundPattern(new PasswordPattern(1, 1, "2", 23, "worstPattern"));

    pa.foundPattern(new PasswordPattern(2, 2, "34", 15, "badPattern"));
    pa.foundPattern(new PasswordPattern(2, 2, "34", 20, "worserPattern"));
    pa.foundPattern(new PasswordPattern(2, 2, "34", 23, "worstPattern"));
    pa.foundPattern(new PasswordPattern(2, 2, "34", 4, "bestPattern"));

    pa.foundPattern(new PasswordPattern(4, 1, "5", 15, "badPattern"));
    pa.foundPattern(new PasswordPattern(4, 1, "5", 20, "worserPattern"));
    pa.foundPattern(new PasswordPattern(4, 1, "5", 4, "bestPattern"));
    pa.foundPattern(new PasswordPattern(4, 1, "5", 23, "worstPattern"));

    PathCost patterns = pa.calculateHighestProbablePatterns();

    List<PasswordPattern> list = patterns.getPath();
    assertEquals(4, list.size());
    double result = patterns.getTotalCost();
    System.out.println("cost=" + result);
    double expected = Math.pow(10, 1) * 4 * 4 * 4;
    assertEquals(expected, result, 0.5);
  }

  @Test
  public void allPossibleRandom() {
    PasswordResultsImpl pa = new PasswordResultsImpl("37384756683");
    RandomAddAll.RandomAddAll(pa);
    PathCost patterns = pa.calculateHighestProbablePatterns();

    List<PasswordPattern> list = patterns.getPath();
    assertEquals(1, list.size());
    double result = patterns.getTotalCost();
    System.out.println("cost=" + result);
  }
}
