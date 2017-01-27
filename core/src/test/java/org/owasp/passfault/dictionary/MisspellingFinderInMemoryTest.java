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


import org.junit.BeforeClass;
import org.junit.Test;
import org.owasp.passfault.api.AnalysisResult;
import org.owasp.passfault.api.PatternsAnalyzer;
import org.owasp.passfault.impl.PasswordPattern;
import org.owasp.passfault.api.PatternCollection;
import org.owasp.passfault.impl.PatternsAnalyzerImpl;
import org.owasp.passfault.impl.TestingPatternCollectionFactory;

import java.util.Collection;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class MisspellingFinderInMemoryTest {

  private static DictionaryPatternsFinder finder;
  private static PatternsAnalyzer analyzer = new PatternsAnalyzerImpl();

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    InMemoryDictionary dictionary = InMemoryDictionary.newInstance(TestWords.getTestReader(), false, "tiny-lower");
    //finder = new DictionaryPatternsFinder(dictionary, new MisspellingStrategy(1), new FilteringPatternCollectionFactory());
    finder = new DictionaryPatternsFinder(dictionary, new MisspellingStrategy(1), new TestingPatternCollectionFactory());

  }

  @Test
  public void findWord() throws Exception {
    assertEquals(
        analyzer.analyze(
            finder.search("passwerd")).getPath().size(), 1);

  }

  @Test
  public void garbageInFront() throws Exception {
    assertEquals(analyzer.analyze(
        finder.search("1234passwerd")).getPath().size(), 2);
  }

  @Test
  public void garbageInBack() throws Exception {
    assertEquals(analyzer.analyze(
        finder.search("garbageinback")).getPath().size(), 3);
    assertEquals(analyzer.analyze(
        finder.search("wisp1")).getPath().size(), 2);
    assertEquals(analyzer.analyze(
        finder.search("wisp12")).getPath().size(), 2);
    assertEquals(analyzer.analyze(
        finder.search("wisp123")).getPath().size(), 2);
  }

  @Test
  public void findNonWord() throws Exception {
    AnalysisResult result = analyzer.analyze(
        finder.search("qqq"));
    System.out.println(result.toString());
    assertEquals(analyzer.analyze(
        finder.search("qqq")).getPath().size(), 1);
  }

  @Test
  public void findMultiWords() throws Exception {
    assertEquals(analyzer.analyze(
        finder.search("passwerdpasswerd")).getPath().size(), 2);
  }

  @Test
  public void testLength() throws Exception {
    System.out.println("findMultiWords");
    PatternCollection patterns = finder.search("passwerd");
    Collection<PasswordPattern> oneLength = getPatternsOfALength(patterns.getAllPatterns(), 8);
    assertEquals(1, oneLength.size());
  }

  public Collection<PasswordPattern> getPatternsOfALength(Collection<PasswordPattern> patterns, int length) {
    LinkedList<PasswordPattern> toReturn = new LinkedList<>();

    for (PasswordPattern pattern : patterns) {
      if (pattern.getLength() == length) {
        toReturn.add(pattern);
      }
    }
    return toReturn;
  }
}
