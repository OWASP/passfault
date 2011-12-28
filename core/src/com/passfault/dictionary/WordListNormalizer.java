/* ©Copyright 2011 Cameron Morris
 *
 * This file is part of Passfault.
 *
 * Passfault is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Passfault is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Passfault.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.passfault.dictionary;

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
