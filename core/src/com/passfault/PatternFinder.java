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
