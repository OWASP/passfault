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

package org.owasp.passfault.impl;

import java.util.Arrays;

/**
 * This is not a string but a CharSequence that can be cleared of its memory. Important for handling passwords.
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
