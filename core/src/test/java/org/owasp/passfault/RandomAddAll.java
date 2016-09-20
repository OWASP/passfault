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

import org.owasp.passfault.api.PasswordResults;

public class RandomAddAll {

  public static void RandomAddAll(PasswordResults toBeWrapped) {
    CharSequence chars = toBeWrapped.getPassword();
    RandomPattern randomPatternFinder = new RandomPattern();
    for (int i = 0, length = chars.length(); i < length; i++) {
      for (int j = i + 1; j <= length; j++) {
        PasswordPattern random = randomPatternFinder.getRandomPattern(chars, i, j - i);
        toBeWrapped.foundPattern(random);
      }
    }
  }
}
