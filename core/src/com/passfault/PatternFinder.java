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

/**
 * This interface represents an a password pattern finder.
 */
public interface PatternFinder {

  /**
   * A password is handed to the finder through this method and the results 
   * will be placed into the same object 
   * @param pass holds the password and any patterns that will be found as the 
   * result of analysis
   *
   * Most implementation of PatternFinder will complete the full analysis before
   * this method will return.  However ParallelFinder will multi-thread each finder
   * and provide additional methods for waiting for the results.
   * @throws Exception 
   */
  void analyze(PasswordResults pass) throws Exception;
  
  void blockingAnalyze(PasswordResults pass) throws Exception;

  void waitForAnalysis(PasswordResults pass) throws Exception;
}
