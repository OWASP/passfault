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
import java.io.RandomAccessFile;

/**
 * Word list dictionary that searches for words in a sorted list file.  The file
 * needs to have the list sorted and padded out to an equal length in order to
 * do a binary search.
 * Time results for looking up a list of word in this fileDictionary:
 * Word Count:27413
 * Time elapsed: 198.511 sec
 *  
 * @see WordListNormalizer for sorting and padding a word list.
 * Also see gradle wordlists tasks for normalizing
 * @author cam
 */
public class FileDictionary implements Dictionary {

  private long size;
  private RandomAccessFile file;
  private int wordCount;
  private long begin;
  private int lineSize;
  private final String name;

  public FileDictionary(RandomAccessFile file, int wordCount, int lineSize, String name) throws IOException {
    this.file = file;
    this.size = file.length();
    this.wordCount = wordCount;
    this.lineSize = lineSize;
    this.name = name;
    begin = 0;
  }

  public static FileDictionary newInstance(String wordList, String name) throws IOException {
	return newInstance(new File(wordList), name);  
  }
  
  public static FileDictionary newInstance(File wordList, String name) throws IOException {
    BufferedReader buffered = new BufferedReader(new FileReader(wordList));
    int wordCount = 0;
    int maxSize = 0;
    String word;

    while ((word = buffered.readLine()) != null) {
      if (word.length() > 0){
        if (word.charAt(0) != '#') {
          wordCount++;
        }
      }
      if (word.length() > maxSize) {
        maxSize = word.length();
      }
    }

    RandomAccessFile file = new RandomAccessFile(wordList, "r");
    System.out.println("Word Count:" + wordCount);
    return new FileDictionary(file, wordCount, maxSize + 1, name);
  }

  public String getName() {
    return name;
  }
  /* (non-Javadoc)
   * @see com.passfault.PatternModel#buildInitialCandidate(int)
   */

  public CandidatePattern buildInitialCandidate(int offset) {
    return new CandidatePattern(begin, size, offset);
  }

  public boolean isMatch(CandidatePattern candidate) throws IOException {
    boolean found = false;
    long middle = candidate.end;
    long end = candidate.end;
    long start = candidate.start;
    long oldMiddle = candidate.start;
    int comparison = 0;
    long middleRoundDown = 0;

    while (oldMiddle != middle) {
      oldMiddle = middle;
      middle = round((end + start) / 2);
      file.seek(middle);
      String middleString = file.readLine().trim();
      middleRoundDown = middle + lineSize;
      comparison = compare(candidate.subString, middleString);
      if (comparison == 0) {
        found = true;
        break;
      }

      if (comparison > 0) {
        start = middle;
      } else {
        end = middleRoundDown;
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
    long middleRoundDown = 0;
    while (oldMiddle != middle) {
      oldMiddle = middle;
      middle = round((candidate.end + candidate.start) / 2);
      file.seek(middle);
      //we might be in the middle of a word.  Regardless, go to next line (Round down)
      //String temp = file.readLine();
      middleRoundDown = middle + lineSize;
      String middleString = file.readLine().trim();
      comparison = comparePartial(candidate.subString, middleString);
      if (comparison == 0) {
        found = true;
        break;
      }

      if (comparison > 0) {
        candidate.start = middle;
      } else {
        candidate.end = middleRoundDown;
      }
    }
//		if (!found && candidate.end - candidate.start < SEQUENTIAL_SEARCH_BYTE_SIZE){
//            found = sequentialPartialSearch(candidate);
//		} 
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

//			if(i+1==string.length() && length!= i+1){
//				return -1; //subString precedes string
//			}
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
  @Override
  public int getWordCount() {
    return wordCount;
  }

  @Override
  public void setWordCount(int count){
    this.wordCount = count;
  }

  private long round(long middle) {
    long wordsToMiddle = middle / lineSize;
    return wordsToMiddle * lineSize;
  }

  @Override
  public int nToggleCaseLetters(CandidatePattern candidate){
    return 0;
  }

}
