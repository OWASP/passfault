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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * The word list normalizer sorts a word list and writes the words back out with
 * padding at the end so that all lines have the same length.
 * @author cam
 */
public class WordListNormalizer {

  /**
   * For a binary search of words in a word list the words all need to be the
   * same length.  This conversion tool finds the longest word in the list,
   * then writes another word list with each word padded to the length of the
   * longest word
   * @param args
   * @throws java.io.FileNotFoundException
   * @throws java.io.IOException
   */
  public static void main(String args[]) throws FileNotFoundException, IOException {
    File file = new File(args[0]);
    String filename = file.getName();
    int dot = filename.lastIndexOf('.');
    if (dot != -1) {
      filename = filename.substring(0, dot);
    }

    BufferedReader in = new BufferedReader(new FileReader(file));
    int maxLength = 0;
    String word;
    SortedSet<String> list = new TreeSet<String>();
    SortedSet<String> backwards = new TreeSet<String>();
    //find max length
    do {
      word = in.readLine();
      if (word != null && word.charAt(0) != '#' && word.length() >= 3){
        if (word.length() > maxLength) {
          maxLength = word.length();
        }
        list.add(word);
        StringBuilder sb = new StringBuilder(word);
        sb.reverse();
        backwards.add(sb.toString());
      }
    } while (word != null);
    in.close();

    //rewrite word list with spaces as padding
    BufferedWriter out = new BufferedWriter(new FileWriter(filename + ".words"));
    Iterator<String> wordsItr = list.iterator();
    while (wordsItr.hasNext()) {
      word = wordsItr.next();
      out.write(word);
      for (int i = word.length(); i < maxLength; i++) {
        out.write(' ');
      }
      out.write('\n');
    }
    out.flush();
    out.close();

    //write out backwards words - sorted
    BufferedWriter outBack = new BufferedWriter(new FileWriter(filename + ".backwords"));
    Iterator<String> backWordsItr = backwards.iterator();
    while (backWordsItr.hasNext()) {
      word = backWordsItr.next();
      outBack.write(word);
      for (int i = word.length(); i < maxLength; i++) {
        outBack.write(' ');
      }
      outBack.write('\n');
    }
    outBack.flush();
    outBack.close();
  }
}
