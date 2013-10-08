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

package com.passfault.dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Dictionary that holds all words in memory rather than searched
 * from a file.
 * Here are the timed test results to find words in a dictionary/word-list:
 * Time elapsed: 1.937 sec
 * Word Count:27413
 * @author cam
 */
public class InMemoryDictionary implements Dictionary {

  String[] words;
  private final String name;

  public InMemoryDictionary(String[] dictionary, String name) {
    words = dictionary;
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  public static InMemoryDictionary newInstance(String wordFile, boolean sort, String name) throws IOException {
    File wordsFile = new File(wordFile);
    return newInstance(new FileReader(wordsFile), sort, name);
  }

  public static InMemoryDictionary newInstance(Reader wordReader, boolean sort, String name) throws IOException {
    BufferedReader buffered = new BufferedReader(wordReader);
    String word;
    ArrayList<String> wordList = new ArrayList<String>();

    do {
      word = buffered.readLine();
      if (word != null) {
        word = word.trim();
        wordList.add(word);
      }
    } while (word != null);

    String[] wordArray = wordList.toArray(new String[wordList.size()]);
    if (sort) {
      Arrays.sort(wordArray);
    }
    System.out.println("Word Count:" + wordArray.length);
    return new InMemoryDictionary(wordArray, name);
  }

  /* (non-Javadoc)
   * @see com.passfault.PatternModel#buildInitialCandidate(int)
   */
  public CandidatePattern buildInitialCandidate(int offset) {
    return new CandidatePattern(0, this.words.length, offset);
  }

  @Override
  public boolean isMatch(CandidatePattern candidate) throws IOException {
    boolean found = false;
    long middle = candidate.end;
    long end = candidate.end;
    long start = candidate.start;
    long oldMiddle = candidate.start;
    int comparison = 0;

    while (oldMiddle != middle) {
      oldMiddle = middle;
      middle = (end + start) / 2;
      String middleString = words[(int) middle];
      comparison = compare(candidate.subString, middleString);
      if (comparison == 0) {
        found = true;
        break;
      }

      if (comparison > 0) {
        start = middle;
      } else {
        end = middle;
      }
    }

    return found;
  }

  /* (non-Javadoc)
   * @see com.passfault.PatternModel#partialSearch(com.passfault.CandidatePattern)
   */
  public boolean partialMatch(CandidatePattern candidate) throws IOException {
    boolean found = false;

    long middle = candidate.end;
    long oldMiddle = candidate.start;
    int comparison = 0;
    while (oldMiddle != middle) {
      oldMiddle = middle;
      middle = (candidate.end + candidate.start) / 2;

      String middleString = words[(int) middle];

      comparison = comparePartial(candidate.subString, middleString);
      if (comparison == 0) {
        found = true;
        break;
      }

      if (comparison > 0) {
        candidate.start = middle;
      } else {
        candidate.end = middle;
      }
    }
    return found;
  }

  public int compare(StringBuilder subString, String string) {
    if (string == null) {
      return -1;
    }

    for (int i = 0, length = Math.max(subString.length(), string.length()); i < length; i++) {
      if (i >= subString.length()) {
        return -1;
      }
      if (i >= string.length()) {
        return +1;
      }

      int diff = Character.toLowerCase(subString.charAt(i)) - Character.toLowerCase(string.charAt(i));
      if (diff != 0) {
        return diff;
      }

    }
    return 0;

  }

  public int comparePartial(StringBuilder subString, String string) {
    // this.charAt(k)-anotherString.charAt(k)
    if (string == null || string.length() == 0) {
      return -1;
    }
    for (int i = 0, length = subString.length(); i < length; i++) {
      int diff = Character.toLowerCase(subString.charAt(i)) - Character.toLowerCase(string.charAt(i));
      if (diff != 0) {
        return diff;
      }

      if (i + 1 == string.length() && length != i + 1) {
        return 1; //superString follows string
      }
    }
    return 0;
  }

  /* (non-Javadoc)
   * @see com.passfault.PatternModel#getWordCount()
   */
  public int getWordCount() {
    return words.length;
  }

  private boolean sequentialPartialSearch(CandidatePattern candidate) throws IOException {
    String word;
    boolean found;
    do {
      word = words[(int) candidate.start];
      if (word != null) {
        word = word.trim();
      }
      found = 0 == comparePartial(candidate.subString, word);
    } while (word != null && !found);
    return found;
  }

  private boolean sequentialSearch(CandidatePattern candidate) throws IOException {
    String word;
    boolean found;
    do {
      word = words[(int) candidate.start];
      if (word != null) {
        word = word.trim();
      }
      found = 0 == compare(candidate.subString, word);
    } while (word != null && !found);
    return found;

  }
}
