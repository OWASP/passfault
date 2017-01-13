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

import org.junit.BeforeClass;
import org.junit.Test;
import org.owasp.passfault.*;
import org.owasp.passfault.api.CompositeFinder;
import org.owasp.passfault.api.PatternCollection;
import org.owasp.passfault.api.PatternFinder;
import org.owasp.passfault.dictionary.DictionaryPatternsFinder;
import org.owasp.passfault.dictionary.ExactWordStrategy;
import org.owasp.passfault.dictionary.FileDictionary;
import org.owasp.passfault.dictionary.TestWords;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class ExecutorFinderTest {

  private static CompositeFinder finder;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    FileDictionary dictionary = FileDictionary.newInstance(TestWords.getTestFile(), "tiny-lower");
    DictionaryPatternsFinder dictionaryFinder = new DictionaryPatternsFinder(dictionary, new ExactWordStrategy());
    LinkedList<PatternFinder> l = new LinkedList<>();
    l.add(dictionaryFinder);
    finder = new ThroughputOptimizedFinder(l);
  }
  
  @Test
  public void findWord() throws Exception {
    assertEquals(finder.search("wisp").getCount(), 1);
  }

  @Test
  public void garbageInFront() throws Exception {
    assertEquals(finder.search("1234wisp").getCount(), 1);
  }

  @Test
  public void garbageInBack() throws Exception {
    assertEquals(finder.search("wisp1234").getCount(), 1);
  }

  @Test
  public void findNonWord() throws Exception {
    assertEquals(finder.search("qqq").getCount(), 0);
  }

  @Test
  public void findMultiWords() throws Exception {
    assertEquals(finder.search("wispwisp").getCount(), 2);
  }

//  @Test
//  public void findWordWithMulti() throws Exception {
//    MockPatternsAnalyzer p = new MockPatternsAnalyzer("password");
//    finder.search(p);
//    assertEquals(finder.search(6, p.getPossiblePatternCount());
//    for (PasswordPattern pattern : p.getFoundPatterns()) {
//      System.out.println(pattern.getMatchString());
//    }
//  }
//
//  @Test
//  public void findWordWithMultiUpper() throws Exception {
//    MockPatternsAnalyzer p = new MockPatternsAnalyzer("Password");
//    finder.search(p);
//    assertEquals(finder.search(6, p.getPossiblePatternCount());
//  }

//  @Test
//  public void findWithMultiplePasswords() throws Exception {
//    String passwords[] = {
//      "password", "drowssap", "2pass$word", "3drowsap",
//      "1234e34t%46", "what3ver", "djhfjgnt", "3e35cdF3f",
//      "password", "drowssap", "2pass$word", "3drowsap",
//      "1234e34t%46", "what3ver", "djhfjgnt", "3e35cdF3f",
//      "password", "drowssap", "2pass$word", "3drowsap",
//      "1234e34t%46", "what3ver", "djhfjgnt", "3e35cdF3f",
//      "password", "drowssap", "2pass$word", "3drowsap",
//      "1234e34t%46", "what3ver", "djhfjgnt", "3e35cdF3f",
//      "password", "drowssap", "2pass$word", "3drowsap",
//      "1234e34t%46", "what3ver", "djhfjgnt", "3e35cdF3f",};
//    PatternsAnalyzerImpl analysis[] = new PatternsAnalyzerImpl[passwords.length];
//    for (int i = 0; i < passwords.length; i++) {
//      analysis[i] = new PatternsAnalyzerImpl(passwords[i]);
//    }
//
//    for (int i = 0; i < passwords.length; i++) {
//      finder.search(analysis[i]);
//    }
//  }
}
