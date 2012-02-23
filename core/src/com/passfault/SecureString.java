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

import java.util.Arrays;

/**
 *
 * @author cam
 */
public class SecureString implements CharSequence {
  private final char[] chars;

  public SecureString(char[] chars){
    this.chars = new char[chars.length];
    System.arraycopy(chars, 0, this.chars, 0, chars.length);
  }

  public SecureString(char[] chars, int start, int end){
    this.chars = new char[end - start];
    System.arraycopy(chars, start, this.chars, 0, this.chars.length);
  }

  @Override
  public int length() {
    return chars.length;
  }

  @Override
  public char charAt(int index) {
    return chars[index];
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    return new SecureString(this.chars, start, end);
  }

  /**
   * Manually clear the underlying array holding the characters
   */
  public void clear(){
    Arrays.fill(chars, '0');
  }

  @Override
  public void finalize() throws Throwable{
    clear();
    super.finalize();
  }
}
