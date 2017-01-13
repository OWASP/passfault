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

import java.util.List;

import org.owasp.passfault.PasswordPattern;
import org.owasp.passfault.api.PatternCollection;
import org.owasp.passfault.api.PatternsAnalyzer;
import org.owasp.passfault.api.AnalysisResult;
import org.owasp.passfault.RandomPattern;

/**
 * This Finder is a post processing finder.  It will search an already analyzed
 * password to find if any identified finders are repeated.
 * @author cam
 */
public class RepeatingPatternDecorator implements PatternsAnalyzer {

  private final PatternsAnalyzer wrappedAnalyzer;

  public RepeatingPatternDecorator(PatternsAnalyzer wrappedAnalyzer) {
    this.wrappedAnalyzer = wrappedAnalyzer;
  }

  public static final String DUPLICATE_PATTERN = "DUPLICATE";

  public AnalysisResult process(AnalysisResult cost, CharSequence password) {
    AnalysisResult newPath = new AnalysisResult(password);
    List<PasswordPattern> path = cost.getPath();
    for (int len = path.size() - 1, i = len; i >= 0; i--) {
      PasswordPattern pass = path.get(i);
      boolean foundDuplicate = false;
      for (int j = i - 1; j >= 0; j--) {
        PasswordPattern toCompare = path.get(j);
        if (!toCompare.getName().equals(RandomPattern.RANDOM_PATTERN)
            && toCompare.getName().equals(pass.getName())
            && toCompare.getMatchString().equals(pass.getMatchString())) {
          //repeated-duplicate pattern instance
          foundDuplicate = true;
          break;
        }
      }
      if (foundDuplicate) {
        PasswordPattern dupp = new PasswordPattern(pass.getStartIndex(), pass.getLength(), pass.getMatchString(), 1,
            "Duplication of an earlier pattern: " + pass.getName(), DUPLICATE_PATTERN, null);
        newPath.addPattern(dupp);
      } else {
        newPath.addPattern(pass);
      }
    }
    return newPath;
  }

  @Override
  public AnalysisResult calculateHighestProbablePatterns(PatternCollection patterns) {
    return process(wrappedAnalyzer.calculateHighestProbablePatterns(patterns), patterns.getPassword());
  }
}
