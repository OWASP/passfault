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

package org.owasp.passfault.finders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.owasp.passfault.api.PatternCollection;
import org.owasp.passfault.api.PatternCollectionFactory;
import org.owasp.passfault.api.PatternFinder;

/**
 * This file simply iterates through each finder calling search.  Before
 * One thread, no optimizations.  This is used for services that don't allow
 * multithreading (Google App Engine).
 * @author cam
 */
public class SequentialFinder implements PatternFinder{

  private List<PatternFinder> finders = new ArrayList<>();

  PatternCollectionFactory factory;

  public SequentialFinder(Collection<PatternFinder> finders, PatternCollectionFactory factory) {
    this.finders.addAll(finders);
    this.factory = factory;
  }

  @Override
  public PatternCollection search(CharSequence pass) {
    PatternCollection allPatterns = factory.build(pass);
    for(PatternFinder finder: finders){
      allPatterns.addAll(finder.search(pass));
    }
    return allPatterns;
  }
}
