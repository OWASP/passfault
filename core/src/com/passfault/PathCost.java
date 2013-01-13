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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a list (path) of patterns in a password and calculates
 * the cost of the patterns.  It is considered a path because of all patterns
 * that could be found in a password, those patterns could be ordered in a graph
 * A path in the graph are patterns that do not overlap.  The cost of the path is
 * the combination of all patterns in the graph plus the additional cost of any
 * part of the password that does not have a cost.
 * @author cam
 */
public class PathCost implements Cloneable {

  private PasswordResults password;

  public PathCost(PasswordResults password) {
    this.password = password;
  }

  public PathCost(PathCost toCopy) {
    this(toCopy.password);
    this.path = new LinkedList<PasswordPattern>(toCopy.path);
    this.cost = toCopy.cost;
  }
  List<PasswordPattern> path = new LinkedList<PasswordPattern>();
  double cost = 1;

  /**
   * Adds a pattern to the current path and updates the
   * current cost of the path
   * @param patt
   * @throws IllegalArgumentException when the pattern added overlaps a pattern
   * already in the path
   */
  public void addPattern(PasswordPattern patt) {
    if (patt == null) {
      return;
    }
    cost *= patt.getPatternSize();
    path.add(0, patt);
    return;
  }

  /**
   * @return calculates the cost of the current patterns to the end of the pattern list.  It only
   * includes the cost of the patterns and any random unidentified characters from the first
   * pattern to the end of the password.  Any random characters before the first pattern are not
   * included.  See. GetTotalCost
   *
   */
  double getRelativeCost() {
    if (path.isEmpty()) {
      return RandomPattern.randomCost(password.getLength());
    }
    return cost;
  }

  /**
   * @return the size of passwords that fit in the patterns in this path plus
   * the additional cost of random characters not covered by patterns.
   */
  public double getTotalCost() {
    if (path.isEmpty()) {
      return RandomPattern.randomCost(password.getLength());
    }
    PasswordPattern pattern = path.get(0);
    return RandomPattern.randomCost(pattern.getStartIndex()) * getRelativeCost();
  }

  /**
   * @return List of patterns that make up the path
   */
  public List<PasswordPattern> getPath() {
    return Collections.unmodifiableList(path);
  }
}
