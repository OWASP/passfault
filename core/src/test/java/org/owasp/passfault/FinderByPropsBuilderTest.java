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

import java.io.*;
import java.util.Collection;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * @author cam
 */
public class FinderByPropsBuilderTest {
  public FinderByPropsBuilderTest() {

  }
  @Test
  public void testBuildDictionaryFinders_file() throws Exception {
    System.out.println("current directory:"+new File(".").getCanonicalFile());
    File file = new File("src/test/resources/words");
    assertTrue(file.exists());
    Collection<PatternFinder> finders = new FinderByPropsBuilder().
        isInMemory(false).
        setFileLoader(file).
        build();
    System.out.println("Finders found "+ finders);
    assertTrue(finders.size() > 4);
  }

  @Test
  public void testBuildDictionaryFinders_resource() throws Exception {
    Collection <PatternFinder> finders = new FinderByPropsBuilder().
        isInMemory(true).
        setClassPathLoader("/org/owasp/passfault/wordlists").
        build();
    System.out.println("Finders found "+ finders);
    assertTrue (finders.size() > 4);
  }
}
