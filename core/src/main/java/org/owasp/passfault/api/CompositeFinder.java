/* ©Copyright 2011 Cameron Morris
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
package org.owasp.passfault.api;

import org.owasp.passfault.api.PasswordResults;
import org.owasp.passfault.api.PatternFinder;

import java.util.concurrent.Future;

/**
 * CompositeFinders combine multiple finders and treat them as one. It has methods declared for parallel processing.
 * the existing analyze method is blocking, the new analyzeFuture lets you block later.
 */
public interface CompositeFinder extends PatternFinder
{
  public Future<PasswordAnalysis> analyzeFuture(PasswordAnalysis pass);
}