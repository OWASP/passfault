package org.owasp.passfault.finders;

import org.junit.Test;
import org.owasp.passfault.PasswordPattern;
import org.owasp.passfault.api.PatternCollection;

import static org.junit.Assert.assertEquals;

public class RandomClassesFinderTest {
  RandomClassesFinder finder = new RandomClassesFinder(3);
  
  @Test
  public void test() throws Exception {
    PatternCollection patterns = finder.search("12345");
    assertEquals(6, patterns.getCount());
    for (PasswordPattern patt : patterns.getAllPatterns()) {
      System.out.println(patt.getMatchString());
    }
  }

  @Test
  public void troysPassword() throws Exception {
    PatternCollection patterns = finder.search("00455455mb17");
    assertEquals(21, patterns.getCount());
    for (PasswordPattern patt : patterns.getAllPatterns()) {
      System.out.println(patt.getMatchString());
    }
  }

  @Test
  public void large() throws Exception {
    PatternCollection patterns = finder.search("!@#234#$%1234");

    for (PasswordPattern patt : patterns.getAllPatterns()) {
      System.out.println(patt.getMatchString());
    }
    assertEquals(6, patterns.getCount());
  }

  @Test
  public void chars() throws Exception {
    PatternCollection patterns = finder.search("abcdef");

    for (PasswordPattern patt : patterns.getAllPatterns()) {
      System.out.println(patt.getMatchString());
    }
    assertEquals(0, patterns.getCount());
  }
}
