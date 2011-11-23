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
package com.passfault;

/**
 * @author cam
 */
public class RandomAddAll {

  public static void RandomAddAll(PasswordResults toBeWrapped) {
    CharSequence chars = toBeWrapped.getCharSequence();
    RandomPattern randomPatternFinder = new RandomPattern();
    for (int i = 0, length = chars.length(); i < length; i++) {
      for (int j = i + 1; j <= length; j++) {
        PasswordPattern random = randomPatternFinder.getRandomPattern(chars, i, j - i);
        toBeWrapped.foundPattern(random);
      }
    }
  }
}
