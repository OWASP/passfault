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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InMemoryDictionaryTest {

  private static InMemoryDictionary dictionary;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    dictionary = InMemoryDictionary.newInstance(TestWords.getTestReader(), false, "tiny-lower");
  }

  @Test
  public void partialSearch() throws IOException {
    CandidatePattern subString = dictionary.buildInitialCandidate(0);
    subString.add('w');
    subString.add('i');
    boolean isPossible = dictionary.partialMatch(subString);
    assertTrue(isPossible);
    boolean isWord = dictionary.isMatch(subString);
    assertFalse(isWord);

    subString.add('s');
    isPossible = dictionary.partialMatch(subString);
    assertTrue(isPossible);
    isWord = dictionary.isMatch(subString);
    assertFalse(isWord);

    subString.add('t');
    isPossible = dictionary.partialMatch(subString);
    assertTrue(isPossible);
    isWord = dictionary.isMatch(subString);
    assertTrue(isWord);

    subString.add('z');
    isPossible = dictionary.partialMatch(subString);
    assertFalse(isPossible);
    isWord = dictionary.isMatch(subString);
    assertFalse(isWord);
  }

  @Test
  public void partialSearch_negative() throws IOException {
    CandidatePattern subString = dictionary.buildInitialCandidate(0);
    subString.add('w');
    subString.add('i');
    boolean isPossible = dictionary.partialMatch(subString);
    assertTrue(isPossible);
    boolean isWord = dictionary.isMatch(subString);
    assertFalse(isWord);

    subString.add('q');
    isPossible = dictionary.partialMatch(subString);
    assertFalse(isPossible);
    isWord = dictionary.isMatch(subString);
    assertFalse(isWord);
  }

  @Test
  public void partialSearch2() throws IOException {
    CandidatePattern subString = dictionary.buildInitialCandidate(0);
    String word = "circumvent";
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      subString.add(c);
      boolean isPossible = dictionary.partialMatch(subString);
      assertTrue(isPossible);
      boolean isWord = dictionary.isMatch(subString);
      if (i + 1 == word.length()) {
        assertTrue(isWord);
      }
      //else
      //assertFalse(isWord);

    }
  }

  @Test
  public void testStress() throws IOException, URISyntaxException {
    File sortedWordsFile = TestWords.getTestFile();
    BufferedReader buffered = new BufferedReader(new FileReader(sortedWordsFile));
    String word = buffered.readLine().trim();
    while (word != null) {
      word = buffered.readLine();
      if (word == null || word.charAt(0) == '#') {
        continue;
      }
      word = word.trim();
      CandidatePattern subString = dictionary.buildInitialCandidate(0);
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        subString.add(c);
        boolean isPossible = dictionary.partialMatch(subString);
        if (!isPossible) {
          System.out.println("partialMatch Failed for: " + word);
        }
        //assertTrue(isPossible);
        boolean isWord = dictionary.isMatch(subString);
        if (i + 1 == word.length()) {
          if (!isWord) {
            System.out.println("isWord Failed for: " + word);
          }
          //assertTrue(isWord);
        }
//                else
//                    assertFalse(isWord);
        System.out.print('.');
      }
      System.out.print('.');
    }
  }

  @Test
  public void comparePartial() {
    StringBuilder after = new StringBuilder("alaskan");
    String before = "alaska";
    int comparison = dictionary.comparePartial(after, before);
    assertTrue(comparison > 0);

    after = new StringBuilder("alaska");
    before = "alaskan";
    comparison = dictionary.comparePartial(after, before);
    assertTrue(comparison == 0);
  }

  @Test
  public void compare() {
    StringBuilder buffer = new StringBuilder("alaskan");
    String string = "alaska";
    int comparison = dictionary.compare(buffer, string);
    assertTrue(comparison > 0);

    buffer = new StringBuilder("alaska");
    string = "alaskan";
    comparison = dictionary.compare(buffer, string);
    assertTrue(comparison < 0);
  }
}
