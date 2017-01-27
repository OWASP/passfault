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

import org.owasp.passfault.impl.PasswordPattern;
import org.owasp.passfault.api.PatternCollection;
import org.owasp.passfault.api.PatternsAnalyzer;
import org.owasp.passfault.api.AnalysisResult;

import java.util.LinkedList;
import java.util.List;

public class MockPatternsAnalyzer implements PatternsAnalyzer {

  private List<PasswordPattern> foundPatterns = new LinkedList<>();

  public List<PasswordPattern> getFoundPatterns() {
    return foundPatterns;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (PasswordPattern patt : foundPatterns) {
      sb.append(patt);
      sb.append('\n');
    }
    return sb.toString();
  }

  @Override
  public AnalysisResult analyze(PatternCollection patterns) {
    AnalysisResult analysisResult = new AnalysisResult(patterns.getPassword());
    for (PasswordPattern patt : this.foundPatterns) {
      analysisResult.addPattern(patt);
    }
    return analysisResult;
  }
}
