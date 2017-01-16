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
package org.owasp.passfault.keyboard;

import org.junit.Test;
import org.owasp.passfault.api.PatternCollection;
import org.owasp.passfault.impl.TestingPatternCollectionFactory;

import static org.junit.Assert.assertEquals;

public class KeySequenceFinderTest {
  KeySequenceFinder finder = new KeySequenceFinder(new EnglishKeyBoard(), TestingPatternCollectionFactory.getInstance());


  @Test
  public void analyze_right() throws Exception {
    System.out.println("search");
    String pass = "asdfg";
    PatternCollection patterns = finder.search(pass);
    int count = patterns.getCount();
    assertEquals(6, count);
  }

  @Test
  public void analyze_rightMixed() throws Exception {
    System.out.println("search");
    String pass = "aSdFg";
    PatternCollection patterns = finder.search(pass);
    int count = patterns.getCount();
    assertEquals(6, count);
  }

  @Test
  public void analyze_left() throws Exception {
    System.out.println("search");
    String pass = "[poi";
    PatternCollection patterns = finder.search(pass);
    int count = patterns.getCount();
    assertEquals(3, count);
  }

  @Test
  public void analyze_upperleft() throws Exception {
    System.out.println("search");
    String pass = "zaq1";
    PatternCollection patterns = finder.search(pass);
    int count = patterns.getCount();
    assertEquals(3, count);
  }

  @Test
  public void analyze_upperright() throws Exception {
    System.out.println("search");
    String pass = "zse4";
    PatternCollection patterns = finder.search(pass);
    int count = patterns.getCount();
    assertEquals(3, count);
  }

  @Test
  public void analyze_lowerleft() throws Exception {
    System.out.println("search");
    String pass = "4esz";
    PatternCollection patterns = finder.search(pass);
    int count = patterns.getCount();
    assertEquals(3, count);
  }

  @Test
  public void analyze_lowerright() throws Exception {
    System.out.println("search");
    String pass = "1qaz";
    PatternCollection patterns = finder.search(pass);
    int count = patterns.getCount();
    assertEquals(3, count);
  }

  @Test
  public void analyze_repeating() throws Exception {
    System.out.println("search");
    String pass = "eeee";
    PatternCollection patterns = finder.search(pass);
    int count = patterns.getCount();
    assertEquals(3, count);
  }

  @Test
  public void analyze_extraBeforeAndAfter() throws Exception {
    System.out.println("search");
    String pass = "fredasdfcougar";
    PatternCollection patterns = finder.search(pass);
    int count = patterns.getCount();
    assertEquals(3, count);
  }

  @Test
  public void testAnalyze_extraBeforeAndAfter_MixedCase() throws Exception {
    System.out.println("search");
    String pass = "freSdFcougar2WsX";
    PatternCollection patterns = finder.search(pass);
    int count = patterns.getCount();
    assertEquals(4, count);
  }

  @Test
  public void testAnalyze_random() throws Exception {
    System.out.println("search");
    String pass = "&7U8(b^j(*(l:';";
    PatternCollection patterns = finder.search(pass);
    int count = patterns.getCount();
    assertEquals(1, count);
  }

  @Test
  public void testAnalyze_colon() throws Exception {
    System.out.println("search");
    String pass = ":";
    PatternCollection patterns = finder.search(pass);
    int count = patterns.getCount();
    assertEquals(0, count);
  }
}