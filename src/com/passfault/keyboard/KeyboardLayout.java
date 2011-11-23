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
  public Map<Character, Key> generateKeyboard();

  /**
   * @return Display name for the keyboard layout
   */
  public String getName();

  /**
   * @return the number of keys on the keyboard
   */
  public int getCharacterKeysCount();

  /**
   * @param sequenceSize length of a sequence of horizontal keys
   * @return number of possible combinations of that length of the keyboard
   */
  public int getHorizontalComboSize(int sequenceSize);

  /**
   * @return total number of possible horizontal combinations of keys
   */
  public int getHorizontalComboTotal();

  /**
   * @param sequenceSize length of a sequence of horizontal keys
   * @return number of possible combinations of that length of the keyboard
   */
  public int getDiagonalComboSize(int sequenceSize);

  /**
   * @return total number of possible diagonal combinations of keys
   */
  public int getDiagonalComboTotal();
}
