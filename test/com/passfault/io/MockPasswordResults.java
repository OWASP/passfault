/* ©Copyright 2011 Cameron Morris
 *
 * This file is part of Passfault.
 *
 * Passfault is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Passfault is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Passfault.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.passfault.io;

import java.util.LinkedList;
import java.util.List;

import com.passfault.AnalysisListener;
import com.passfault.PasswordPattern;
import com.passfault.PasswordResults;
import com.passfault.PathCost;

/**
 *
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
