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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReversePatternDecoratorFinderTest {

//  @Test
//  public void getChars() {
//    System.out.println("getChars");
//
//    ReversePatternDecoratorFinder instance = new ReversePatternDecoratorFinder(
//        new PatternsAnalyzerImpl("backwards"));
//    CharSequence expResult = new StringBuilder("backwards").reverse().toString();
//    CharSequence result = instance.getPassword();
//    assertEquals(expResult, result);
//  }
//
//  @Test
//  public void adaptedBackwards() {
//    System.out.println("testAdaptedBackwards");
//
//    {
//      ReversePatternDecoratorFinder instance = new ReversePatternDecoratorFinder(new PatternsAnalyzerImpl(
//        "012drow78"));
//      //reversed would be= 87word210
//      //it would find 'word' at index 2
//
//      int reverseStartingIndex = 2;
//      int actualStartingIndex = 3;
//      assertAdaptedReverse(instance, reverseStartingIndex, actualStartingIndex);
//    }
//    {
//      ReversePatternDecoratorFinder instance = new ReversePatternDecoratorFinder(new PatternsAnalyzerImpl(
//        "012drow"));
//      //reversed would be= word210
//      //it would find 'word' at index 0
//
//      int reverseStartingIndex = 0;
//      int actualStartingIndex = 3;
//      assertAdaptedReverse(instance, reverseStartingIndex, actualStartingIndex);
//    }
//    {
//      ReversePatternDecoratorFinder instance = new ReversePatternDecoratorFinder(new PatternsAnalyzerImpl(
//        "drow78"));
//      //reversed would be= 87word
//      //it would find 'word' at index 2
//
//      int reverseStartingIndex = 2;
//      int actualStartingIndex = 0;
//      assertAdaptedReverse(instance, reverseStartingIndex, actualStartingIndex);
//    }
//  }
//
//  private void assertAdaptedReverse(ReversePatternDecoratorFinder instance, int reverseStartingIndex, int actualStartingIndex) {
//    instance.putPattern(new PasswordPattern(reverseStartingIndex, 4, "word", 4, "word", "word", "english"));
//    List<PasswordPattern> path = instance.calculateHighestProbablePatterns().getPath();
//    boolean putPattern = false;
//    for (PasswordPattern patt : path) {
//      if (ReversePatternDecoratorFinder.NAME.equalsIgnoreCase(patt.getName())) {
//        assertEquals(actualStartingIndex, patt.getStartIndex());
//        putPattern = true;
//      }
//    }
//    assertTrue(putPattern);
//  }
}
