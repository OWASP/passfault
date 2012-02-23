/* ©Copyright 2011 Cameron Morris
 *
 * This file is part of Passfault.
 *
 * Passfault is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Passfault is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Passfault.  If not, see <http://www.gnu.org/licenses/>.
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
