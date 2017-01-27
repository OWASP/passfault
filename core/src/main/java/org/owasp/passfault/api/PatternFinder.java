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

package org.owasp.passfault.api;

/**
 * This represents a password pattern finder.
 */
public interface PatternFinder {

  /**
   * @param password the password to examine, can be a String or SecureString, or any CharSequence
   * @return all many patterns discovered in the password
   */
  PatternCollection search(CharSequence password);
}
