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
