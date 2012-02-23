/* ©Copyright 2011 Cameron Morris
 *
 * This file is part of Passfault.
 *
 * Passfault is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Passfault is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Passfault.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.passfault.dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileDictionaryTest {

  public static final String wordlist = "./test/tiny-lower.words";
  private static FileDictionary dictionary;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    dictionary = FileDictionary.newInstance(wordlist, "tiny-lower");
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
  public void testPartialSearch() throws IOException {
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
  public void testPartialSearch_negative() throws IOException {
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
  public void testPartialSearch2() throws IOException {
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

  //@Test
  public void testStress() throws IOException {
    File sortedWordsFile = new File(wordlist);
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
  public void testComparePartial() {
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
  public void testCompare() {
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
