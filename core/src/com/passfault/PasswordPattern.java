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
 * This class stores information about a password pattern that was identified.
 * In addition it contains specific how the size of the pattern and the part of
 * the password that matched the pattern.
 *
 * Note that some patterns have the same cost regardless of the specific pattern
 * finding, but other do not.  For example, a dictionary word will have the same
 * cost for all words in the dictionary, but a keyboard sequence will have a higher cost
 * for longer sequences.
 *
 * @author cam
 */
public class PasswordPattern {

  private final int startIndex;
  private final int length;
  private final double cost;
  private final CharSequence matchString;
  private final String description;
  private final String name;
  private final String classification;

  /**
   * @param startIndex index into the password of where the pattern begins
   * @param length number of characters of the pattern in the password
   * @param matchString the substring of the password that matches the pattern
   * @param patternSize number of possible combinations in the pattern (with length considered)
   * @param description
   * @param name Canonical name of the pattern, identified by the constant NAME on a pattern finder strategies
   * @param classification usually the language of the pattern, or another way to classify the pattern
   */
  public PasswordPattern(int startIndex, int length, CharSequence matchString,
      double patternSize, String description, String name, String classification) {
    this.startIndex = startIndex;
    this.length = length;
    this.matchString = matchString;
    this.cost = patternSize;
    this.description = description;
    this.name = name;
    this.classification = classification;
  }

  /**
   * Constructor omitting the description and classification
   */
  public PasswordPattern(int startIndex, int length, String matchString,
      double crackProbability, String description) {
    this.startIndex = startIndex;
    this.length = length;
    this.matchString = matchString;
    this.cost = crackProbability;
    this.description = description;
    this.name = "unknown";
    this.classification = "";
  }

  /**
   * Returns the number of combinations that fit within this pattern.  Note
   * that this includes the length of the specific password found.
   */
  public double getPatternSize() {
    return getCost();
  }

  /**
   * @return the startIndex
   */
  public int getStartIndex() {
    return startIndex;
  }

  public int getLength(){
    return length;
  }
  /**
   * @return the cost
   */
  public double getCost() {
    return cost;
  }

  /**
   * @return the matchString
   */
  public CharSequence getMatchString() {
    return matchString;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the classification
   */
  public String getClassification() {
    return classification;
  }
}
