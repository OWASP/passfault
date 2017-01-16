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
package org.owasp.passfault.dictionary;

import org.junit.BeforeClass;
import org.junit.Test;
import org.owasp.passfault.impl.TestingPatternCollectionFactory;

import static org.junit.Assert.assertEquals;

/**
 * @author cam
 */
public class l337SubstitutionTest {

  private static DictionaryPatternsFinder finder;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    FileDictionary dictionary = FileDictionary.newInstance(TestWords.getTestFile(), "tiny-lower");
    finder = new DictionaryPatternsFinder(dictionary, new l337SubstitutionStrategy(), TestingPatternCollectionFactory.getInstance());
  }
  
  @Test
  public void findWord() throws Exception {
    assertEquals(finder.search("ca2").getCount(), 1);//car
  }

  @Test
  public void multiple_char() throws Exception {
    assertEquals(finder.search("ca|2").getCount(), 2);
  }

  @Test
  public void findNoSubstitution() throws Exception {
    assertEquals(finder.search("or.").getCount(), 0);
  }

  @Test
  public void multiple_char_run() throws Exception {
    assertEquals(finder.search("|2un").getCount(), 2);
  }

  @Test
  public void front() throws Exception {
    assertEquals(finder.search("2oot").getCount(), 2);
  }

  @Test
  public void front_zoo() throws Exception {
    assertEquals(finder.search("~/_oo").getCount(), 1);
  }

  @Test
  public void multipleLeet() throws Exception {
    assertEquals(finder.search("2()()+").getCount(), 2);
  }

  @Test
  public void front_multichar() throws Exception {
    assertEquals(finder.search("~/_oo").getCount(), 1);
  }

  @Test
  public void front_multichar_root() throws Exception {
    assertEquals(finder.search("2oot").getCount(), 2);
  }
}
