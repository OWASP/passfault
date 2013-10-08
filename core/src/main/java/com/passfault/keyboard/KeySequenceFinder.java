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
package com.passfault.keyboard;

import com.passfault.PasswordPattern;
import com.passfault.PasswordResults;
import com.passfault.PatternFinder;
import com.passfault.keyboard.Key.Direction;
import java.util.Map;

/**
 * Identifies four types of keyboard patterns:
 * Diagonal sequence, repeated characters, one-hand horizontal sequence 
 * (3 and 4 character sequences), 5 and mor character horizontal sequence.
 * 
 * @author cam
 */
public class KeySequenceFinder implements PatternFinder {

  public final static String DIAGONAL = "DIAGONAL";
  public final static String HORIZONTAL = "HORIZONTAL";
  public final static String REPEATED = "REPEATED";
  private Map<Character, Key> keyboard;
  private int keyCount;
  private int diagCount;
  // 3 and 4 chars in a horizontal sequence are considered a different pattern
  // than 5 or more since 5 or more is difficult with one hand
  private int horiz3n4Count;
  private int horiz5plusCount;
  private final KeyboardLayout keys;

  public KeySequenceFinder(KeyboardLayout keys) {
    this.keys = keys;
    keyboard = keys.generateKeyboard();
    keyCount = keys.getCharacterKeysCount();
    diagCount = keys.getDiagonalComboTotal();
    horiz3n4Count = keys.getHorizontalComboSize(3) + keys.getHorizontalComboSize(4);
    horiz5plusCount = keys.getHorizontalComboTotal() - horiz3n4Count;
  }

  @Override
  public void blockingAnalyze(PasswordResults pass) throws Exception {
    analyze(pass);
  }

  @Override
  public void analyze(PasswordResults pass) throws Exception {
    CharSequence password = pass.getCharSequence();
    Key previous = keyboard.get(password.charAt(0));
    Direction currentDirection = null;
    int startOfSequence = 0;

    //Upper is more than just an upper case,  It is a character that results
    //from pressing the shift key and another key

    boolean isUpper[] = new boolean[password.length()];
    if (previous == null) {
      isUpper[0] = false;
    } else {
      isUpper[0] = previous.upper == password.charAt(0);
    }
    for (int i = 1; i < password.length(); i++) {
      char c = password.charAt(i);
      Key current = keyboard.get(c);
      if (current == null) {
        previous = null;
        continue;
      }
      if (previous == null) {
        previous = current;
        continue;
      }
      if (current.upper == c) {
        isUpper[i] = true;
      } else if (current.lower == c) {
        isUpper[i] = false;
      } else {
        assert false : "An Incorrect key (" + c + ") was registered as " + current.lower;
      }

      if (currentDirection != null) {
        if (!previous.match(currentDirection, c)) {
          currentDirection = null;
        } else {
          //the sequence continues...
          //if the sequence is big enought report it for analysis
          if (i - startOfSequence >= 2) {
            for (int start = startOfSequence; start <= i - 2; start++) {
              reportPattern(pass, start, i - start + 1, currentDirection, isUpper);
            }
          }
        }
      }

      if (currentDirection == null) {
        //no current direction? then check if we are starting a new sequence
        currentDirection = previous.isSequence(c);
        if (currentDirection != null) {
          startOfSequence = i - 1;
        }
      }
      previous = current;
    }
  }

  private void reportPattern(PasswordResults pass, int start, int length, Direction currentDirection, boolean[] isUpper) {
    long patternSize = 1;
    String patternName = null;
    StringBuilder pattern = new StringBuilder();
    switch (currentDirection) {
      case LEFT:
      case RIGHT:
        if (length > 4) {
          patternSize *= this.horiz5plusCount;
        } else {
          patternSize *= this.horiz3n4Count;
        }
        pattern.append("Keyboard horizontal sequence");
        patternName = HORIZONTAL;
        break;
      case LOWER_LEFT:
      case LOWER_RIGHT:
      case UPPER_LEFT:
      case UPPER_RIGHT:
        patternSize *= this.diagCount;
        pattern.append("Keyboard Diagonal sequence (");
        pattern.append(currentDirection);
        pattern.append(')');
        patternName = DIAGONAL;
        break;
      case SELF:
        patternSize *= this.keyCount * (pass.getCharSequence().length() - 2);
        pattern.append("Keyboard repeated character");
        patternName = REPEATED;
        //how many possible passwords fit this pattern?
        //keyCount times the possible count of repeated characters
        //minus one and two repeated chars because that isn't useful
        break;
    }

    //add calculation for SHIFT key
    boolean hasUpper = false;
    boolean hasLower = false;
    for (int i = start; i < start + length; i++) {
      if (isUpper[i]) {
        hasUpper = true;
      } else {
        hasLower = true;
      }

      if (hasUpper && hasLower) {
        break;
      }
    }

    if (hasUpper && hasLower) {
      patternSize *= 2 * length;  //for each key there are two possibilities
      pattern.append(", random SHIFT");
    } else {
      patternSize *= 2;  //two possibilities, all upper, or all lower
    }
    CharSequence passString;
    passString = pass.getCharSequence().subSequence(start, length + start);
    pass.foundPattern(
        new PasswordPattern(start, length, passString,
        patternSize, pattern.toString(), patternName, keys.getName()));
  }

  @Override
  public void waitForAnalysis(PasswordResults pass) throws Exception {
    return; //already done
  }
}
