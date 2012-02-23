/* ©Copyright 2011 Cameron Morris
 *
 * This file is part of Passfault.
 *
 * Passfault is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Passfault is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Passfault.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.passfault;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author cam
 */
public class RandomPatternTest {

  /**
   * Test of getRandomPattern method, of class RandomPattern.
   */
  @Test
  public void testGetRandomPattern() {
    System.out.println("getRandomPattern");
    CharSequence chars = "afaf";
    int start = 0;
    int length = 4;
    RandomPattern instance = new RandomPattern();
    PasswordPattern result = instance.getRandomPattern(chars, start, length);
    assertEquals(Math.pow(RandomPattern.RandomClasses.Latin.getSize(), 4), result.getCost(), .1);

  }
}
