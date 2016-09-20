/* ©Copyright 2015 Cameron Morris
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

import org.owasp.passfault.PasswordPattern;

/**
 * PasswordAnalysis stores the analysis of password pattern finders.
 * @author cam, ray
 */
public interface PasswordAnalysis {

  /**
   * This method is called by pattern finders to store a newly discovered pattern
   * in a password.
   * @param patt pattern found in the password.
   */
  void foundPattern(PasswordPattern patt);

  /**
   * @return the password to be analyzed
   */
  CharSequence getPassword();
}
