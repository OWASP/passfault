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

package org.owasp.passfault;

import java.util.EnumSet;

/**
 * This class helps detect different random patterns and their strength.
 *
 * Interesting things happen with random patterns.  Some short patterns can be
 * more complex than random patterns.  Looking and testing all possible
 * combinations of random patterns within a pattern is possible and was
 * experimented with.  However, having different classes of random (upper, lower,
 * numbers...) made it hard to determine if it was worthwhile.  The best solution
 * tried was to compare a newly found pattern to the random pattern of the same
 * sequence, and discard the pattern if random was better(smaller).
 *
 * @author cam
 */
public class RandomPattern {

  public final static String RANDOM_PATTERN = "RANDOM_CHARACTERS";

  static double randomCost(int chars) {
    return java.lang.Math.pow((double) RandomClasses.Latin.getSize() * 2
        + RandomClasses.SpecialChars.getSize()
        + RandomClasses.Numbers.getSize(), (double) chars);
  }

  static double randomCostLowerCase(int chars) {
    return java.lang.Math.pow((double) RandomClasses.Latin.getSize(), (double) chars);
  }

  static double randomCostLowerUpperCase(int chars) {
    return java.lang.Math.pow((double) RandomClasses.Latin.size * 2, (double) chars);
  }

  /**
   * Given a character sequence, this method will calculate the random strength of the
   * sequence.  It considers what type of characters are used, digits, lower-case, upper-case,
   * and special characters.
   * @param chars
   * @param start
   * @param length
   * @return
   */
  public PasswordPattern getRandomPattern(CharSequence chars, int start, int length) {
    EnumSet<RandomClasses> set = EnumSet.noneOf(RandomClasses.class);
    boolean hasUpper = false;
    boolean hasLower = false;
    for (int i = start; i < start + length; i++) {
      char ch = chars.charAt(i);
      for (RandomClasses charType : RandomClasses.values()) {
        if (charType.isInCharSet(ch)) {
          set.add(charType);
        }
      }
      if (Character.isLowerCase(ch)) {
        hasLower = true;
      }
      if (Character.isUpperCase(ch)) {
        hasUpper = true;
      }
    }
    double charsPerChar = 0;
    for (RandomClasses randomType : RandomClasses.values()) {
      if (set.contains(randomType)) {
        charsPerChar += randomType.getSize();
      }
    }
    if (charsPerChar == 0) {
      charsPerChar = 1; //zero based numbers will mess up all the multiplications later on
    }
    PasswordPattern toReturn = new PasswordPattern(
        start, length, chars.subSequence(start, length + start), Math.pow(charsPerChar, length),
        "Random Characters with:" + set.toString(), this.RANDOM_PATTERN, set.toString());
    return toReturn;
  }

  static public enum RandomClasses {

    Latin(26) {

      public boolean isInCharSet(char ch) {
        return Character.isLetter(ch);
      }
    },
    Cyrillic(30) {

      public boolean isInCharSet(char ch) {
        return (ch >= '\u0400' && ch <= '\u04FF');
      }
    },
    SpecialChars(42) {

      public boolean isInCharSet(char ch) {
        return !Character.isLetterOrDigit(ch);
      }
    },
    Numbers(10) {

      public boolean isInCharSet(char ch) {
        return Character.isDigit(ch);
      }
    };
    final int size;

    RandomClasses(int size) {
      this.size = size;
    }

    ;

    public int getSize() {
      return size;
    }

    ;

    abstract boolean isInCharSet(char ch);
  }
}
