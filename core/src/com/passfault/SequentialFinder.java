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
}
