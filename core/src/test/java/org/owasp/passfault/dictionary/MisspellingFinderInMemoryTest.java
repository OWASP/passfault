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
import org.owasp.passfault.PasswordPattern;
import org.owasp.passfault.api.PatternCollection;

import java.util.Collection;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class MisspellingFinderInMemoryTest {

  private static DictionaryPatternsFinder finder;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    InMemoryDictionary dictionary = InMemoryDictionary.newInstance(TestWords.getTestReader(), false, "tiny-lower");
    finder = new DictionaryPatternsFinder(dictionary, new MisspellingStrategy(1));
  }

  @Test
  public void findWord() throws Exception {
    assertEquals(finder.search("passwerd").getCount(), 1);
  }

  @Test
  public void garbageInFront() throws Exception {
    assertEquals(finder.search("1234passwerd").getCount(), 1);
  }

  @Test
  public void garbageInBack() throws Exception {
    assertEquals(finder.search("garbageinback").getCount(), 1);
    assertEquals(finder.search("wisp1").getCount(), 1);
    assertEquals(finder.search("wisp12").getCount(), 1);
    assertEquals(finder.search("wisp123").getCount(), 1);
  }

  @Test
  public void findNonWord() throws Exception {
    assertEquals(finder.search("qqq").getCount(), 0);
  }

  @Test
  public void findMultiWords() throws Exception {
    assertEquals(finder.search("passwerdpasswerd").getCount(), 2);
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
