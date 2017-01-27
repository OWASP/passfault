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
package org.owasp.passfault.keyboard;

import java.util.HashMap;
import java.util.Map;

/**
 * This keyboard represents a US-english standard keyboard.
 * @author cam
 */
public class EnglishKeyBoard implements KeyboardLayout {

  static char[][] lower_horiz = new char[][]{
    {'`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '='},
    {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', '[', ']', '\\'},
    {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';', '\''},
    {'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/'}
  };
  static char[][] upper_horiz = new char[][]{
    {'~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+'},
    {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '{', '}', '|'},
    {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ':', '"'},
    {'Z', 'X', 'C', 'V', 'B', 'N', 'M', '<', '>', '?'}
  };
  static char[][] lower_diag_TopLeft_BottomRight = new char[][]{
    {'1', 'q', 'a', 'z'},
    {'2', 'w', 's', 'x'},
    {'3', 'e', 'd', 'c'},
    {'4', 'r', 'f', 'v'},
    {'5', 't', 'g', 'b'},
    {'6', 'y', 'h', 'n'},
    {'7', 'u', 'j', 'm'},
    {'8', 'i', 'k', ','},
    {'9', 'o', 'l', '.'},
    {'0', 'p', ';', '/'},
    {'-', '[', '\''},
    {'=', ']'},};
  static char[][] upper_diag_TopLeft_BottomRight = new char[][]{
    {'!', 'Q', 'A', 'Z'},
    {'@', 'W', 'S', 'X'},
    {'#', 'E', 'D', 'C'},
    {'$', 'R', 'F', 'V'},
    {'%', 'T', 'G', 'B'},
    {'^', 'Y', 'H', 'N'},
    {'&', 'U', 'J', 'M'},
    {'*', 'I', 'K', '<'},
    {'(', 'O', 'L', '>'},
    {')', 'P', ':', '?'},
    {'_', '{', '"'},
    {'+', '}'}
  };
  static char[][] lower_diag_TopRight_BottomLeft = new char[][]{
    {'}', '\'', '/'},
    {'=', '[', ';', '.'},
    {'-', 'p', 'l', ','},
    {'0', 'o', 'k', 'm'},
    {'9', 'i', 'j', 'n'},
    {'8', 'u', 'h', 'b'},
    {'7', 'y', 'g', 'v'},
    {'6', 't', 'f', 'c'},
    {'5', 'r', 'd', 'x'},
    {'4', 'e', 's', 'z'},
    {'3', 'w', 'a'},
    {'2', 'q'}
  };
  static char[][] upper_diag_TopRight_BottomLeft = new char[][]{
    {'}', '"', '?'},
    {'+', '{', ':', '>'},
    {'_', 'P', 'L', '<'},
    {')', 'O', 'K', 'M'},
    {'(', 'I', 'J', 'N'},
    {'*', 'U', 'H', 'B'},
    {'&', 'Y', 'G', 'V'},
    {'^', 'T', 'F', 'C'},
    {'%', 'R', 'D', 'X'},
    {'$', 'E', 'S', 'Z'},
    {'#', 'W', 'A'},
    {'@', 'Q'}
  };
  public final static String NAME = "English";

  @Override
  public Map<Character, Key> generateKeyboard() {
    Map<Character, Key> keyboard = new HashMap<>();

    for (int rowIndex = 0; rowIndex < lower_horiz.length; rowIndex++) {
      char[] lowerRow = lower_horiz[rowIndex];
      char[] upperRow = upper_horiz[rowIndex];

      for (int charIndex = 0; charIndex < lowerRow.length; charIndex++) {
        char lower = lowerRow[charIndex];
        char upper = upperRow[charIndex];

        Key key = new Key();
        key.lower = lower;
        key.upper = upper;
        keyboard.put(lower, key);
        keyboard.put(upper, key);
      }
    }

    //Fill in left and right
    for (char[] lowerRow : lower_horiz) {
      for (int charIndex = 0; charIndex < lowerRow.length; charIndex++) {
        char lower = lowerRow[charIndex];

        Key key = keyboard.get(lower);
        if (charIndex > 0) {
          char left = lowerRow[charIndex - 1];
          Key leftKey = keyboard.get(left);
          leftKey.right = key;
          key.left = leftKey;
        }
      }
    }


    //Fill in diag topleft to bottom right
    for (char[] lowerRow : lower_diag_TopLeft_BottomRight) {
      for (int charIndex = 0; charIndex < lowerRow.length; charIndex++) {
        char lower = lowerRow[charIndex];

        Key key = keyboard.get(lower);
        if (charIndex > 0) {
          char left = lowerRow[charIndex - 1];
          Key leftKey = keyboard.get(left);
          leftKey.lowerRight = key;
          key.upperLeft = leftKey;
        }
      }
    }

    //Fill in diag topRight to bottom left
    for (int rowIndex = 0; rowIndex < lower_diag_TopLeft_BottomRight.length; rowIndex++) {
      char[] lowerRow = lower_diag_TopRight_BottomLeft[rowIndex];

      for (int charIndex = 0; charIndex < lowerRow.length; charIndex++) {
        char lower = lowerRow[charIndex];

        Key key = keyboard.get(lower);
        if (charIndex > 0) {
          char right = lowerRow[charIndex - 1];
          Key rightKey = keyboard.get(right);
          rightKey.lowerLeft = key;
          key.upperRight = rightKey;
        }
      }
    }
    return keyboard;
  }

  @Override
  public int getCharacterKeysCount() {
    return 47;
  }

  @Override
  public int getHorizontalComboSize(int sequenceSize) {
    int size = 0;
    for (char[] currHoriz : lower_horiz) {
      size += currHoriz.length + 1 - sequenceSize;
    }
    return size * 2;  //times two for both directions of sequences
  }

  @Override
  public int getHorizontalComboTotal() {
    int size = 0;
    for (char[] currHoriz : lower_horiz) {
      int n = currHoriz.length + 1 - 3;
      //we need a sum of series here from 1 to n
      //   = (n+1)*n/2 = (n^2 + n)/2
      size += (n * n + n) / 2;
    }
    return size * 2;  //timew two for both directions of sequences
  }

  @Override
  public int getDiagonalComboSize(int sequenceSize) {
    int size = 0;
    for (char[] currDiag : lower_diag_TopLeft_BottomRight) {
      size += currDiag.length + 1 - sequenceSize;
    }
    return size * 2;  //times two for both directions of sequences
  }

  @Override
  public int getDiagonalComboTotal() {
    int size = 0;
    for (char[] currDiag : lower_diag_TopLeft_BottomRight) {
      int n = currDiag.length + 1 - 3;
      //we need a sum of series here from 1 to n
      //   = (n+1)*n/2 = (n^2 + n)/2
      size += (n * n + n) / 2;
    }
    return size * 2 * 2;  //times two for both directions of sequences
    //times two for both directions of Diagonal
  }

  @Override
  public String getName() {
    return NAME;
  }
}
