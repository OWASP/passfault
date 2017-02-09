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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

/**
 * Dictionary that holds all words in memory rather than searched
 * from a file.
 * Here are the timed test results to find words in a dictionary/word-list:
 * Time elapsed: 1.937 sec
 * Word Count:27413
 * @author cam
 */
public class InMemoryDictionary implements Dictionary {
  private static final Logger LOG = getLogger(DictionaryPatternsFinder.class.getName());

  final String[] words;
  final private String name;
  private int wordCount;

  InMemoryDictionary(String[] dictionary, String name) {
    this.words = dictionary;
    this.name = name.replace(".words", "");
    this.wordCount = words.length;
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
    ArrayList<String> wordList = new ArrayList<>();

    while ((word = buffered.readLine()) != null){
      if (word.length() > 0){
        if (word.charAt(0) != '#'){
        word = word.trim();
        wordList.add(word);
      }
      }
    }

    String[] wordArray = wordList.toArray(new String[wordList.size()]);
    if (sort) {
      Arrays.sort(wordArray);
    }
    LOG.fine(MessageFormat.format("Word Count for {0}: {1}\n", name, wordArray.length));
    return new InMemoryDictionary(wordArray, name);
  }

  /* (non-Javadoc)
   * @see com.passfault.PatternModel#buildInitialCandidate(int)
   */
  public CandidatePattern buildInitialCandidate(int offset) {
    return new CandidatePattern(0, this.words.length, offset);
  }

  @Override
  public boolean isMatch(CandidatePattern candidate) {
    boolean found = false;
    long middle = candidate.end;
    long end = candidate.end;
    long start = candidate.start;
    long oldMiddle = candidate.start;
    int comparison;

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
  public boolean partialMatch(CandidatePattern candidate) {
    boolean found = false;

    long middle = candidate.end;
    long oldMiddle = candidate.start;
    int comparison;
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
    return wordCount;
  }

  @Override
  public void setWordCount(int newWordCount) {
    this.wordCount = newWordCount;
  }


}
