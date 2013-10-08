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

import java.util.LinkedList;
import java.util.List;

import org.owasp.passfault.AnalysisListener;
import org.owasp.passfault.PasswordPattern;
import org.owasp.passfault.PasswordResults;
import org.owasp.passfault.PathCost;

/**
 * @author cam
 */
public class MockPasswordResults implements PasswordResults {

  private final String password;
  private List<PasswordPattern> foundPatterns = new LinkedList<PasswordPattern>();

  public MockPasswordResults(String password) {
    this.password = password;
  }

  public List<PasswordPattern> getFoundPatterns() {
    return foundPatterns;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (PasswordPattern patt : foundPatterns) {
      sb.append('{');
      sb.append(patt.getMatchString());
      sb.append(", start=");
      sb.append(patt.getStartIndex());
      sb.append(", cost=");
      sb.append(patt.getCost());
      sb.append(", patternSize=");
      sb.append(patt.getPatternSize());
      sb.append(", description=");
      sb.append(patt.getDescription());
      sb.append(", classification=");
      sb.append(patt.getClassification());
      sb.append(", name=");
      sb.append(patt.getName());
      sb.append('}');
    }
    return sb.toString();
  }

  @Override
  public void addListener(AnalysisListener listener) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public PathCost calculateHighestProbablePatterns() {
    PathCost pathCost = new PathCost(this);
    for (PasswordPattern patt : this.foundPatterns) {
      pathCost.addPattern(patt);
    }
    return pathCost;
  }

  @Override
  public void foundPattern(PasswordPattern patt) {
    foundPatterns.add(patt);
  }

  @Override
  public int getPossiblePatternCount() {
    return foundPatterns.size();
  }

  @Override
  public CharSequence getCharSequence() {
    return password;
  }

  @Override
  public int getLength() {
    return password.length();
  }
}
