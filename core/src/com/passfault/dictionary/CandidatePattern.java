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

import com.passfault.*;

public class CandidatePattern {

  protected long start;
  protected long end;
  protected StringBuilder subString;
  protected int startOffset;
  private Class<?> decoratorClass;
  private StrategyContext decorator;
  private int upperCharCount = 0;

  public CandidatePattern(long fileStart, long fileLengthBytes, int startOffset) {
    start = fileStart;
    end = fileLengthBytes;
    subString = new StringBuilder();
    this.startOffset = startOffset;
  }

  public <T extends StrategyContext> void addDecorator(Class<T> klass, T thing) {
    this.decoratorClass = klass;
    this.decorator = thing;
  }

  public <T extends StrategyContext> T getDecorator(Class<T> klass) {
    if (klass == decoratorClass) {
      return (T) klass.cast(decorator);
    } else {
      return null;
    }
  }

  public int getStartOffset() {
    return startOffset;
  }

  public int getLength() {
    return subString.length();
  }

  public void add(char c) {
    subString.append(c);
    if (Character.isUpperCase(c)){
      upperCharCount ++;
    }
  }

  @Override
  public String toString() {
    return subString.toString();
  }

  protected CandidatePattern copy() {
    CandidatePattern clone = new CandidatePattern(this.start, this.end, this.startOffset);
    clone.subString = new StringBuilder();
    for (int i = 0, len = subString.length(); i < len; i++) {
      clone.subString.append(subString.charAt(i));
    }
    clone.upperCharCount = upperCharCount;
    if (decorator != null) {
      clone.decorator = (StrategyContext) decorator.copy();
      clone.decoratorClass = decoratorClass;
    }
    return clone;
  }

  public PasswordPattern getMatchingPattern(int dictionarySize, String strategyName, String classification, int currentPosition) {
    int crackSize = dictionarySize;
    String description = "Match";
    if (decorator != null) {
      description = decorator.getDescription();
      crackSize = crackSize * decorator.getCrackSizeFactor();
    }
    int length = currentPosition - getStartOffset() + 1;
    crackSize = crackSize * getUpperCaseFactor(length, upperCharCount);
    return new PasswordPattern(
        getStartOffset(), length, subString.toString(),
        crackSize, description, strategyName, classification);
  }

  /**
   * @param length length of a candidate dictionary word
   * @param upperLetters count of upper-case characters in password
   * @return number of different possible combinations of upper and lower-case
   * character given the length of the word and how many characters are upper case
   *
   * Note that if most letters are upper-case than it is actually easier to guess
   * since the we can assume the caps key is pressed.  Therefore, the most increase
   * comes in having half of the characters upper-case.
   */
  static int getUpperCaseFactor(int length, int upperLetters) {
    int upperCaseFactor = 1;
    //after half the length we assume all caps with a selective lower case
    int charsToGuess;
    if (upperLetters > length/2){
      charsToGuess = length - upperLetters;
    } else {
      charsToGuess = upperLetters;
    }
    for(int letterChoices=length; letterChoices>length - charsToGuess; letterChoices--){
      upperCaseFactor *= letterChoices;
    }
    return upperCaseFactor;
  }
}
