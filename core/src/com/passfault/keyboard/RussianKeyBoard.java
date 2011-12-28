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
package com.passfault.keyboard;

import java.util.HashMap;
import java.util.Map;

/**
 * This keyboard represents a microsoft-Russian keyboard
 * @author cam
 */
public class RussianKeyBoard implements KeyboardLayout {

  public static final String NAME = "Russian";
  static char[][] lower_horiz = new char[][]{
    {'ё', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '='},
    {'й', 'ц', 'у', 'к', 'е', 'н', 'г', 'ш', 'щ', 'з', 'х', 'ъ', '\\'},
    {'ф', 'ы', 'в', 'а', 'п', 'р', 'о', 'л', 'д', 'ж', 'э'},
    {'я', 'ч', 'с', 'м', 'и', 'т', 'ь', 'б', 'ю', '.'}
  };
  static char[][] upper_horiz = new char[][]{
    {'Ё', '!', '"', '№', ';', '%', ':', '?', '*', '(', ')', '_', '+'},
    {'Й', 'Ц', 'У', 'К', 'Е', 'Н', 'Г', 'Ш', 'Щ', 'З', 'Х', 'Ъ', '/'},
    {'Ф', 'Ы', 'В', 'А', 'П', 'Р', 'О', 'Л', 'Д', 'Ж', 'Э'},
    {'Я', 'Ч', 'С', 'М', 'И', 'Т', 'Ь', 'Б', 'Ю', ','}
  };
  static char[][] alt_horiz = new char[][]{
    {'Ё', '!', '"', '№', ';', '%', ':', '?', '*', '(', ')', '_', '+'},
    {'Й', 'Ц', 'У', 'К', 'Е', 'Н', 'Г', 'Ш', 'Щ', 'З', 'Х', 'Ъ', '/'},
    {'Ф', 'Ы', 'В', 'А', 'П', 'Р', 'О', 'Л', 'Д', 'Ж', 'Э'},
    {'Я', 'Ч', 'С', 'М', 'И', 'Т', 'Ь', 'Б', 'Ю', ','}
  };
  static char[][] lower_diag_TopLeft_BottomRight = new char[][]{
    {'1', 'й', 'ф', 'я'},
    {'2', 'ц', 'ы', 'ч'},
    {'3', 'у', 'в', 'с'},
    {'4', 'к', 'а', 'м'},
    {'5', 'е', 'п', 'и'},
    {'6', 'н', 'р', 'т'},
    {'7', 'г', 'о', 'ь'},
    {'8', 'ш', 'л', 'б'},
    {'9', 'щ', 'д', 'ю'},
    {'0', 'з', 'ж', '.'},
    {'-', 'х', 'э'},
    {'=', 'ъ'},};
  static char[][] upper_diag_TopLeft_BottomRight = new char[][]{
    {'!', 'Й', 'Ф', 'Я'},
    {'"', 'Ц', 'Ы', 'Ч'},
    {'№', 'У', 'В', 'С'},
    {';', 'К', 'А', 'М'},
    {'%', 'Е', 'П', 'И'},
    {':', 'Н', 'Р', 'Т'},
    {'?', 'Г', 'О', 'Ь'},
    {'*', 'Ш', 'Л', 'Б'},
    {'(', 'Щ', 'Д', 'Ю'},
    {')', 'З', 'Ж', '?'},
    {'_', 'Х', 'Э'},
    {'+', 'Ъ'}
  };
  static char[][] lower_diag_TopRight_BottomLeft = new char[][]{
    {'ъ', 'э', '.'},
    {'=', 'х', 'ж', 'ю'},
    {'-', 'з', 'д', 'б'},
    {'0', 'щ', 'л', 'ь'},
    {'9', 'ш', 'о', 'т'},
    {'8', 'г', 'р', 'и'},
    {'7', 'н', 'п', 'м'},
    {'6', 'е', 'а', 'с'},
    {'5', 'к', 'в', 'ч'},
    {'4', 'у', 'ы', 'я'},
    {'3', 'ц', 'ф'},
    {'2', 'й'}
  };
  static char[][] upper_diag_TopRight_BottomLeft = new char[][]{
    {'Ъ', 'Э', '.'},
    {'+', 'Х', 'Ж', 'Ю'},
    {'_', 'З', 'Д', 'Б'},
    {')', 'Щ', 'Л', 'Ь'},
    {'(', 'Ш', 'О', 'Т'},
    {'*', 'Г', 'Р', 'И'},
    {'?', 'Н', 'П', 'М'},
    {':', 'Е', 'А', 'С'},
    {'%', 'К', 'В', 'Ч'},
    {';', 'У', 'Ы', 'Я'},
    {'№', 'Ц', 'Ф'},
    {'"', 'Й'}
  };

  public Map<Character, Key> generateKeyboard() {
    Map<Character, Key> keyboard = new HashMap<Character, Key>();

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
    for (int rowIndex = 0; rowIndex < lower_horiz.length; rowIndex++) {
      char[] lowerRow = lower_horiz[rowIndex];

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
    for (int rowIndex = 0; rowIndex < lower_diag_TopLeft_BottomRight.length; rowIndex++) {
      char[] lowerRow = lower_diag_TopLeft_BottomRight[rowIndex];

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

  ;

  public int getCharacterKeysCount() {
    return 47;
  }

  public int getHorizontalComboSize(int sequenceSize) {
    int size = 0;
    for (int i = 0; i < lower_horiz.length; i++) {
      char[] currHoriz = lower_horiz[i];
      size += currHoriz.length + 1 - sequenceSize;
    }
    return size * 2;  //times two for both directions of sequences
  }

  public int getHorizontalComboTotal() {
    int size = 0;
    for (int i = 0; i < lower_horiz.length; i++) {
      char[] currHoriz = lower_horiz[i];
      int n = currHoriz.length + 1 - 3;
      //we need a sum of series here from 1 to n
      //   = (n+1)*n/2 = (n^2 + n)/2
      size += (n * n + n) / 2;
    }
    return size * 2;  //timew two for both directions of sequences
  }

  public int getDiagonalComboSize(int sequenceSize) {
    int size = 0;
    for (int i = 0; i < lower_diag_TopLeft_BottomRight.length; i++) {
      char[] currDiag = lower_diag_TopLeft_BottomRight[i];
      size += currDiag.length + 1 - sequenceSize;
    }
    return size * 2;  //times two for both directions of sequences
  }

  public int getDiagonalComboTotal() {
    int size = 0;
    for (int i = 0; i < lower_diag_TopLeft_BottomRight.length; i++) {
      char[] currDiag = lower_diag_TopLeft_BottomRight[i];
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
