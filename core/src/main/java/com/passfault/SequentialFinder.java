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

package com.passfault;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This file simply iterates through each finder calling analyze.  Before
 * One thread, no optimizations.  This is used for services that don't allow
 * multithreading (Google App Engine).
 * @author cam
 */
public class SequentialFinder implements PatternFinder{

  private List<PatternFinder> finders = new ArrayList<PatternFinder>();

  public SequentialFinder(Collection<PatternFinder> finders) {
    this.finders.addAll(finders);
  }
  @Override
  public void analyze(PasswordResults pass) throws Exception {
    for(PatternFinder finder: finders){
      finder.analyze(pass);
    }
  }

  @Override
  public void blockingAnalyze(PasswordResults pass) throws Exception {
    analyze(pass);
  }

  @Override
  public void waitForAnalysis(PasswordResults pass) throws Exception {
    return; //already done
  }
}
