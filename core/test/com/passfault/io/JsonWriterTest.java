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
package com.passfault.io;

import com.passfault.MockPasswordResults;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

import com.passfault.PasswordPattern;
import com.passfault.PathCost;

public class JsonWriterTest {

  @Test
  public void testPatternToJSON() throws IOException {
    MockPasswordResults results = new MockPasswordResults("test");
    results.foundPattern(new PasswordPattern(1, 2, "te", 300, "This is a test pattern", "testPattern", "test"));
    results.foundPattern(new PasswordPattern(3, 2, "st", 350, "This is another test pattern", "testPattern2", "test"));
    PathCost pathCost = results.calculateHighestProbablePatterns();
    JsonWriter writer = new JsonWriter();
    writer.write(new PrintWriter(System.out, true), pathCost);
  }
}
