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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cam
 */
public class DateFinderTest {

  public DateFinderTest() {
  }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of analyze method, of class DateFinder.
   */
  @Test
  public void testAnalyze() throws Exception {
    System.out.println("analyze");
    {
      MockPasswordResults pass = new MockPasswordResults("12-25-1999");
      new DateFinder().analyze(pass);
      assertEquals(1, pass.getFoundPatterns().size());
    }
    {
      MockPasswordResults pass = new MockPasswordResults("12-25-99");
      new DateFinder().analyze(pass);
      assertEquals(1, pass.getFoundPatterns().size());
    }
    {
      MockPasswordResults pass = new MockPasswordResults("04-06-1976");
      new DateFinder().analyze(pass);
      assertEquals(1, pass.getFoundPatterns().size());
    }
    {
      MockPasswordResults pass = new MockPasswordResults("122599");
      new DateFinder().analyze(pass);
      assertEquals(1, pass.getFoundPatterns().size());
    }
    {
      MockPasswordResults pass = new MockPasswordResults("2001-12-25");
      new DateFinder().analyze(pass);
      assertEquals(1, pass.getFoundPatterns().size());
    }
    {
      MockPasswordResults pass = new MockPasswordResults("1776-06-04");
      new DateFinder().analyze(pass);
      assertEquals(1, pass.getFoundPatterns().size());
    }
  }

  @Test
  public void testStress() throws Exception {
    //this runs in 0.212 seconds, it isn't a problem with performance
    DateFinder dateFinder = new DateFinder();
    for (int i = 0; i < 100000; i++) {
      MockPasswordResults pass = new MockPasswordResults("1776-06-04");
      dateFinder.analyze(pass);
      //assertEquals(1, pass.getFoundPatterns().size());
    }
  }
}
