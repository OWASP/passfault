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

import org.junit.Test;
import org.owasp.passfault.api.AnalysisResult;
import org.owasp.passfault.api.PatternCollection;
import org.owasp.passfault.api.PatternsAnalyzer;
import org.owasp.passfault.finders.RepeatingPatternDecorator;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PatternsAnalyzerImplTest {

  PatternsAnalyzer pa = new RepeatingPatternDecorator(new PatternsAnalyzerImpl());

  @Test
  public void randomNumbers() {
    PatternCollection patts = new PatternCollectionImpl("1234");
    AnalysisResult patterns = pa.calculateHighestProbablePatterns(patts);

    List<PasswordPattern> list = patterns.getPath();
    assertEquals(1, list.size());
    double result = patterns.getTotalCost();
    System.out.println("cost=" + result);
    double expected = Math.pow(10, 4);
    assertEquals(expected, result, 0.5);
  }

  @Test
  public void onePattern_Middle() {
    PatternCollection patts = new PatternCollectionImpl("1234");
    patts.putPattern(new PasswordPattern(1, 2, "23", 4, "testPattern"));

    AnalysisResult patterns = pa.calculateHighestProbablePatterns(patts);

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
    PatternCollection patts = new PatternCollectionImpl("1234");
    patts.putPattern(new PasswordPattern(2, 2, "34", 4, "testPattern"));

    AnalysisResult patterns = pa.calculateHighestProbablePatterns(patts);

    List<PasswordPattern> list = patterns.getPath();
    assertEquals(2, list.size());
    double result = patterns.getTotalCost();
    System.out.println("cost=" + result);
    double expected = Math.pow(10, 2) * 4;
    assertEquals(expected, result, 0.5);
  }

  @Test
  public void onePattern_beginning() {
    PatternCollection patts = new PatternCollectionImpl("1234");
    patts.putPattern(new PasswordPattern(0, 2, "12", 4, "testPattern"));

    AnalysisResult patterns = pa.calculateHighestProbablePatterns(patts);

    List<PasswordPattern> list = patterns.getPath();
    assertEquals(2, list.size());
    double result = patterns.getTotalCost();
    System.out.println("cost=" + result);
    double expected = Math.pow(10, 2) * 4;
    assertEquals(expected, result, 0.5);
  }

  @Test
  public void twoPattern_middle() {
    PatternCollection patts = new PatternCollectionImpl("1234");
    patts.putPattern(new PasswordPattern(1, 1, "2", 2, "testPattern"));
    patts.putPattern(new PasswordPattern(3, 1, "4", 2, "testPattern"));

    AnalysisResult patterns = pa.calculateHighestProbablePatterns(patts);

    List<PasswordPattern> list = patterns.getPath();
    assertEquals(5, list.size());
    double result = patterns.getTotalCost();
    System.out.println("cost=" + result);

    double expected = Math.pow(10, 3) * 4;
    assertEquals(expected, result, 0.5);
  }

  @Test
  public void onePattern_overlap() {
    PatternCollection patts = new PatternCollectionImpl("1234");
    patts.putPattern(new PasswordPattern(1, 2, "23", 15, "worstPattern"));
    patts.putPattern(new PasswordPattern(1, 2, "23", 4, "bestPattern"));
    patts.putPattern(new PasswordPattern(1, 2, "23", 20, "worsePattern"));
    patts.putPattern(new PasswordPattern(1, 2, "23", 23, "worserPattern"));

    AnalysisResult patterns = pa.calculateHighestProbablePatterns(patts);

    List<PasswordPattern> list = patterns.getPath();
    assertEquals(3, list.size());
    double result = patterns.getTotalCost();
    System.out.println("cost=" + result);
    double expected = Math.pow(10, 3) * 4;
    assertEquals(expected, result, 0.5);
  }

  @Test
  public void twoPattern_overlap() {
    PatternCollection patts = new PatternCollectionImpl("1234");
    patts.putPattern(new PasswordPattern(1, 1, "2", 15, "badPattern"));
    patts.putPattern(new PasswordPattern(1, 1, "2", 4, "bestPattern"));
    patts.putPattern(new PasswordPattern(1, 1, "2", 20, "worserPattern"));
    patts.putPattern(new PasswordPattern(1, 1, "2", 23, "worstPattern"));

    patts.putPattern(new PasswordPattern(2, 2, "34", 15, "badPattern"));
    patts.putPattern(new PasswordPattern(2, 2, "34", 20, "worserPattern"));
    patts.putPattern(new PasswordPattern(2, 2, "34", 23, "worstPattern"));
    patts.putPattern(new PasswordPattern(2, 2, "34", 4, "bestPattern"));

    patts.putPattern(new PasswordPattern(4, 1, "5", 15, "badPattern"));
    patts.putPattern(new PasswordPattern(4, 1, "5", 20, "worserPattern"));
    patts.putPattern(new PasswordPattern(4, 1, "5", 4, "bestPattern"));
    patts.putPattern(new PasswordPattern(4, 1, "5", 23, "worstPattern"));

    AnalysisResult patterns = pa.calculateHighestProbablePatterns(patts);

    List<PasswordPattern> list = patterns.getPath();
    assertEquals(4, list.size());
    double result = patterns.getTotalCost();
    System.out.println("cost=" + result);
    double expected = Math.pow(10, 1) * 4 * 4 * 4;
    assertEquals(expected, result, 0.5);
  }

  @Test
  public void allPossibleRandom() {
    PatternCollection patts = new PatternCollectionImpl("37384756683");
    RandomAddAll.RandomAddAll(patts);
    AnalysisResult patterns = pa.calculateHighestProbablePatterns(patts);

    List<PasswordPattern> list = patterns.getPath();
    assertEquals(1, list.size());
    double result = patterns.getTotalCost();
    System.out.println("cost=" + result);
  }
}
