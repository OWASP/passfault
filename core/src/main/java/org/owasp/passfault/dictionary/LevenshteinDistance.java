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

package org.owasp.passfault.dictionary;

import org.owasp.passfault.impl.RandomPattern;

/**
 * This class calculates the distance between one word and another.  This
 * algorithm is modified from the original algorithm.  The original algorithm
 * came from wikipedia: http://en.wikipedia.org/wiki/Levenshtein_distance
 * This modified algorithm adds one
 * character at a time and calculates a relative distance between the two words up
 * to a length of one word.  One limitation of this approach is one word need to
 * known entirely at start time, while the other word can be "streamed" or added
 * one character at a time.
 *
 * The original algorithm is included for reference and for testing.
 * @author cam
 */
public class LevenshteinDistance implements StrategyContext {

  CharSequence s;
  int sn = 1;
  int p[];//'previous' cost array, horizontally
  int d[];// cost array, horizontally
  int _d[]; //placeholder to assist in swapping p and d
  StringBuilder t;
  int tn = 1;

  @Override
  public StrategyContext copy() {
    LevenshteinDistance toReturn = new LevenshteinDistance(s);
    toReturn.s = s;
    toReturn.sn = sn;
    toReturn.tn = tn;
    toReturn.p = new int[p.length];
    toReturn.d = new int[d.length];
    toReturn._d = null;
    System.arraycopy(p, 0, toReturn.p, 0, p.length);
    System.arraycopy(d, 0, toReturn.d, 0, d.length);
    toReturn.t = new StringBuilder(t.toString());
    return toReturn;
  }

  public void appendToTarget(char c) {
    this.t.append(c);
  }

  public LevenshteinDistance(CharSequence s) {
    this.s = toLower(s);
    p = new int[s.length() + 1];
    d = new int[s.length() + 1];
    t = new StringBuilder(s.length() + 5);
    for (int i = 0, len = p.length; i < len; i++) {
      p[i] = i;
    }
  }

  public int updateDist() {
    if (s == null || t == null) {
      throw new IllegalArgumentException("Strings must not be null");
    }

    int n = s.length(); // length of s
    int m = t.length(); // length of t

    if (n == 0) {
      return m;
    } else if (m == 0) {
      return 0;
    }

    // indexes into strings s and t
    int i; // iterates through s
    int j; // iterates through t

    char t_j; // jth character of t

    int cost; // cost

    for (j = tn; j <= m; j++) {
      t_j = t.charAt(j - 1);
      d[0] = j;

      for (i = 1; i <= n; i++) {
        cost = s.charAt(i - 1) == t_j ? 0 : 1;
        // minimum of cell to the left+1, to the top+1, Diagonally left and up +cost
        d[i] = Math.min(Math.min(d[i - 1] + 1, p[i] + 1), p[i - 1] + cost);
      }

      // copy current distance counts to 'previous row' distance counts
      _d = p;
      p = d;
      d = _d;
    }
    sn = s.length() + 1;
    tn = t.length() + 1;
    // our last action in the above loop was to switch d and p, so p now
    // actually has the most recent cost counts
    return p[n];
  }

  public int partialDistance() {
    return p[Math.min(t.length(), s.length())];
  }

  public int distance() {
    return p[s.length()];
  }

  /**
   * Mr. Gilleland,

  As you may know, the Apache Jakarta Commons project had appropriated
  your sample implementation of the Levenshtein Distance algorithm for
  its commons-lang Java library.  While attempting to use it with two
  very large strings, I encountered an OutOfMemoryError, due to the fact
  that a matrix is created with the dimensions of the two strings'
  lengths.  I know you created the implementation to go with your
  (excellent) illustration of the algorithm, so this matrix approach
  translates that illustration and tutorial perfectly.

  However, as I said, the matrix approach doesn't lend itself to getting
  the edit distance of two large strings.  For this purpose, I modified
  your implementation to use two single-dimensional arrays; this is
  clearly more memory-friendly (although it probably results in some very
  slight performance degradation when comparing smaller strings).

  I've submitted the modification to the maintainers of the commons-lang
  project, and I've appended the relevant method below.

  Thanks!

  Chas Emerick
   * @param s source string
   * @param t target string
   * @return distance between the source and the target
   */
  public static int getLevenshteinDistance(String s, String t) {
    if (s == null || t == null) {
      throw new IllegalArgumentException("Strings must not be null");
    }

    /*
    The difference between this impl. and the previous is that, rather
    than creating and retaining a matrix of size s.length()+1 by t.length()+1,
    we maintain two single-dimensional arrays of length s.length()+1.  The first, d,
    is the 'current working' distance array that maintains the newest distance cost
    counts as we iterate through the characters of String s.  Each time we increment
    the index of String t we are comparing, d is copied to p, the second int[].  Doing so
    allows us to retain the previous cost counts as required by the algorithm (taking
    the minimum of the cost count to the left, up one, and Diagonally up and to the left
    of the current cost count being calculated).  (Note that the arrays aren't really
    copied anymore, just switched...this is clearly much better than cloning an array
    or doing a System.arraycopy() each time  through the outer loop.)

    Effectively, the difference between the two implementations is this one does not
    cause an out of memory condition when calculating the LD over two very large strings.
     */

    int n = s.length(); // length of s
    int m = t.length(); // length of t

    if (n == 0) {
      return m;
    } else if (m == 0) {
      return n;
    }

    int p[] = new int[n + 1]; //'previous' cost array, horizontally
    int d[] = new int[n + 1]; // cost array, horizontally
    int _d[]; //placeholder to assist in swapping p and d

    // indexes into strings s and t
    int i; // iterates through s
    int j; // iterates through t

    char t_j; // jth character of t

    int cost; // cost

    for (i = 0; i <= n; i++) {
      p[i] = i;
    }

    for (j = 1; j <= m; j++) {
      t_j = t.charAt(j - 1);
      d[0] = j;

      for (i = 1; i <= n; i++) {
        cost = s.charAt(i - 1) == t_j ? 0 : 1;
        // minimum of cell to the left+1, to the top+1, Diagonally left and up +cost
        d[i] = Math.min(Math.min(d[i - 1] + 1, p[i] + 1), p[i - 1] + cost);
      }

      // copy current distance counts to 'previous row' distance counts
      _d = p;
      p = d;
      d = _d;
    }

    // our last action in the above loop was to switch d and p, so p now
    // actually has the most recent cost counts
    return p[n];
  }

  @Override
  public String getDescription() {
    return "Misspelling";
  }

  @Override
  public int getCrackSizeFactor() {
    int distance = distance();
    if (distance <= 0) {
      return 1;
    } else {
      return distance * RandomPattern.RandomClasses.SpecialChars.getSize();
    }
  }

  private CharSequence toLower(CharSequence s) {
    StringBuilder sbuilder = new StringBuilder();
    for(int i=0; i<s.length(); i++){
      sbuilder.append(Character.toLowerCase(s.charAt(i)));
    }
    return sbuilder;
  }
}
