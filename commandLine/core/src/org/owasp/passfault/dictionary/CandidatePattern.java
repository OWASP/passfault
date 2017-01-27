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

import org.owasp.passfault.*;

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
    return (klass == decoratorClass) ? klass.cast(decorator) : null;
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
      clone.decorator = decorator.copy();
      clone.decoratorClass = decoratorClass;
    }

    return clone;
  }

  public PasswordPattern getMatchingPattern(double dictionarySize, String strategyName, String classification, int currentPosition, int nToggleCaseLetters) {
    String description;
    int nLetters = 0;

    for (int i = 0; i < subString.length(); i++){
      if (Character.isLetter(subString.charAt(i)))
        nLetters++;
    }

    if (nToggleCaseLetters == 0){
      description = "Exact Match";
    }else if (nToggleCaseLetters == nLetters){
      description = "Match with all letters Case Toggled";
    }else{
      description = "Match with " + Integer.toString(nToggleCaseLetters) + " Toggled Case letter(s)";
    }

    double crackSize = dictionarySize;
    if (decorator != null) {
      description = decorator.getDescription();
      if (nToggleCaseLetters == nLetters){
        description += " + Toggle Case";
      }else if (nToggleCaseLetters > 0){
        description += " + " + Integer.toString(nToggleCaseLetters) + " Toggled Case letter(s)";;
      }

      crackSize = crackSize * decorator.getCrackSizeFactor();
    }

    int length = currentPosition - getStartOffset() + 1;
    crackSize = crackSize * getUpperCaseFactor(nLetters, nToggleCaseLetters);
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
