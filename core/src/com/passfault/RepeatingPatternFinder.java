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

import java.util.List;

/**
 * This Finder is a post processing finder.  It will analyze an already analyzed
 * password to find if any identified patterns are repeated.
 * @author cam
 */
public class RepeatingPatternFinder {

  public static final String DUPLICATE_PATTERN = "DUPLICATE";

  PathCost process(PathCost cost, PasswordResults password) {
    PathCost newPath = new PathCost(password);
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
}
