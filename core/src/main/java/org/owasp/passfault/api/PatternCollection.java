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

import org.owasp.passfault.impl.PasswordPattern;
import org.owasp.passfault.impl.PatternCollectionImpl;

import java.util.List;
import java.util.stream.Stream;

/**
 * PasswordPatternCollection stores the analysis of password pattern finders.
 * @author cam, ray
 */
public interface PatternCollection {

  void putPattern(PasswordPattern patt);

  List<PasswordPattern> getPatternsByIndex(int i);

  List<PasswordPattern> getAllPatterns();

  Stream<PasswordPattern> stream();

  CharSequence getPassword();

  int getCount();

  void addAll(PatternCollection toAdd);
}
