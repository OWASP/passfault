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

import java.util.Map;

/**
 * This interface represents a keyboard layout, implementation help identify
 * key sequences for a locale-specific keyboard.
 * @author cam
 */
public interface KeyboardLayout {

  /**
   * @return map of Keys on a keyboard, indexed by the characters on a key
   */
  Map<Character, Key> generateKeyboard();

  /**
   * @return Display name for the keyboard layout
   */
  String getName();

  /**
   * @return the number of keys on the keyboard
   */
  int getCharacterKeysCount();

  /**
   * @param sequenceSize length of a sequence of horizontal keys
   * @return number of possible combinations of that length of the keyboard
   */
  int getHorizontalComboSize(int sequenceSize);

  /**
   * @return total number of possible horizontal combinations of keys
   */
  int getHorizontalComboTotal();

  /**
   * @param sequenceSize length of a sequence of horizontal keys
   * @return number of possible combinations of that length of the keyboard
   */
  int getDiagonalComboSize(int sequenceSize);

  /**
   * @return total number of possible diagonal combinations of keys
   */
  int getDiagonalComboTotal();
}
