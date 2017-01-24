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
import org.owasp.passfault.api.PatternCollection;
import org.owasp.passfault.api.PatternCollectionFactory;
import org.owasp.passfault.api.PatternsAnalyzer;
import org.owasp.passfault.impl.PasswordPattern;
import org.owasp.passfault.impl.PatternsAnalyzerImpl;
import org.owasp.passfault.impl.TestingPatternCollectionFactory;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReversePatternDecoratorFinderTest {

  PatternsAnalyzer analyzer;
  PatternCollectionFactory collectionFactory = TestingPatternCollectionFactory.getInstance();
  
  @Test
  public void getChars() {
    System.out.println("getChars");

    InMemoryDictionary inMemoryDictionary = new InMemoryDictionary(new String[] { "backwards" }, "test");
    ReversePatternDecoratorFinder reverseFinder = new ReversePatternDecoratorFinder(
        new DictionaryPatternsFinder(inMemoryDictionary, new ExactWordStrategy(), collectionFactory ),
        collectionFactory);

    CharSequence expResult = "backwards";
    PatternCollection result = reverseFinder.search("sdrawkcab");
    assertEquals(expResult, result.getAllPatterns().get(0).getMatchString());
  }

  @Test
  public void adaptedBackwards() {
    System.out.println("testAdaptedBackwards");
    InMemoryDictionary inMemoryDictionary = new InMemoryDictionary(new String[] { "word" }, "test");

    ReversePatternDecoratorFinder reverseFinder = new ReversePatternDecoratorFinder(
        new DictionaryPatternsFinder(inMemoryDictionary, new ExactWordStrategy(), collectionFactory ),
        collectionFactory);

    {
      PatternCollection result = reverseFinder.search("012drow78");
      //reversed would be= 87word210
      //it would find 'word' at index 2

      int reverseStartingIndex = 2;
      int actualStartingIndex = 3;
      assertAdaptedReverse(result, reverseStartingIndex, actualStartingIndex);
    }
    {
      PatternCollection result = reverseFinder.search("012drow");
      //reversed would be= word210
      //it would find 'word' at index 0

      int reverseStartingIndex = 0;
      int actualStartingIndex = 3;
      assertAdaptedReverse(result, reverseStartingIndex, actualStartingIndex);
    }
    {
      PatternCollection result = reverseFinder.search("drow78");
      //reversed would be= 87word
      //it would find 'word' at index 2

      int reverseStartingIndex = 2;
      int actualStartingIndex = 0;
      assertAdaptedReverse(result, reverseStartingIndex, actualStartingIndex);
    }
  }

  private void assertAdaptedReverse(PatternCollection foundPatterns, int reverseStartingIndex, int actualStartingIndex) {

    System.out.println(foundPatterns);
    boolean putPattern = false;
    for (PasswordPattern patt : foundPatterns.getAllPatterns()) {
      if (ReversePatternDecoratorFinder.NAME.equalsIgnoreCase(patt.getName())) {
        assertEquals(actualStartingIndex, patt.getStartIndex());
        putPattern = true;
      }
    }
    assertTrue(putPattern);
  }
}
