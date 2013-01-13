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
 * TimeToCrack enumerates different classes of hardware and can estimate the
 * time required to find one password in a password pattern.  The time to crack
 * is the average time to find the password, which on average is the time to
 * enumerate half of the passwords.
 *
 * Note that currently this processing power is based on the crack time for
 * bcrypt on a 1.8 ghz processor
 * @author cam
 */
public enum TimeToCrack {

  dualCore(2, "Every day computer"),
  i7(7, "High end computer"),
  smallCluster128(128, "Small super computer"),
  largeCluster1024(1024, "Large super computer"),
  giganticCluster1024(10000, "Enormous super computer");
  int numberOfProcessors;
  String displayName;
  long crackTimeMillis = 362;//time for bcrypt on 1.8 ghz

  TimeToCrack(int numberOfProcessors, String description) {
    this.numberOfProcessors = numberOfProcessors;
    this.displayName = description;
  }

  public int getNumberOfProcessors() {
    return numberOfProcessors;
  }

  /**
   * @return a display name suitable for a user interface
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * @param patternSize represents the number of passwords in a pattern
   * @return the milliseconds needed to crack the pattern
   */
  public double getTimeToCrackMilliSeconds(double patternSize) {
    return (crackTimeMillis * (patternSize)) / numberOfProcessors;
  }

  /**
   * @param patternSize represents the number of passwords in a pattern
   * @return a display suitable string displaying the time to crack
   */
  public String getTimeToCrackString(double patternSize) {
    double milliseconds = getTimeToCrackMilliSeconds(patternSize);
    double seconds = milliseconds / 1000;
    int days = (int) (milliseconds / 1000 / 60 / 60 / 24);
    int months = (int) (milliseconds / 1000 / 60 / 60 / 24 / 30);
    int years = (int) (milliseconds / 1000 / 60 / 60 / 24 / 365);
    int decades = years / 10;
    int centuries = years / 100;
    int remainderMonths = months % 12;
    int remainderDays = days % 30;
    int remainderYears = years % 10;
    int remainderDecades = decades % 10;

    StringBuilder buf = new StringBuilder();

    if (centuries > 0) {
      remainderYears = 0;  //don't show years if centuries are shown
      buf.append(centuries);
      if (centuries == 1) {
        buf.append(" century");
      } else {
        buf.append(" centuries");
      }
      if (remainderDecades > 0 && centuries < 10) {
        buf.append(", ");
      }
    }
    if (remainderDecades > 0 && centuries < 10) {
      remainderMonths = 0; //don't show months if decades are shown
      buf.append(remainderDecades);
      buf.append(" decade");
      if (remainderDecades > 1) {
        buf.append('s');
      }
      if (remainderYears > 0 && decades < 10) {
        buf.append(", ");
      }
    }
    if (remainderYears > 0 && decades < 10) {
      remainderDays = 0; //don't show days if years are shown
      buf.append(remainderYears);
      buf.append(" year");
      if (remainderYears > 1) {
        buf.append('s');
      }
      if (remainderMonths > 0 && years < 10) {
        buf.append(", ");
      }
    }
    if (remainderMonths > 0 && years < 10) {
      buf.append(remainderMonths);
      buf.append(" month");
      if (remainderMonths > 1) {
        buf.append('s');
      }
      if (remainderDays > 0 && years == 0) {
        buf.append(", ");
      }
    }
    if (remainderDays > 0 && years < 1) {
      buf.append(remainderDays);
      buf.append(" day");
      if (remainderDays > 1) {
        buf.append('s');
      }
    }
    if (remainderDays == 0 && remainderMonths == 0 && years == 0) {
      buf.append("less than 1 day");
    }
    return buf.toString();
  }

  void setTestTime(long crackTimeMillis) {
    this.crackTimeMillis = crackTimeMillis;
  }

  /** 
   * @param size
   * @return a display suitable string describing the size of a number, such as
   * "1 million 234 thousand"
   */
  static public String getRoundedSizeString(double size) {
    double rounded = size;
    int rounds = 0;
    for (rounds = 0; rounded >= 1000; rounds++) {
      rounded = rounded / 1000;
    }
    StringBuilder builder = new StringBuilder();
    builder.append((int) rounded);
    String types[] = new String[]{
      "hundred",
      "thousand",
      "million",
      "billion",
      "trillion",
      "quadrillion",
      "quintillion",
      "sextillion",
      "septillion",
      "octillion",
      "nonillion",
      "decillion",};
    if (rounds + 1 > types.length) {
      for (int i = types.length; i <= rounds; i++) {
        builder.append(",000");
      }
      builder.append(' ');
      builder.append(types[types.length - 1]);
    } else {
      builder.append(' ');
      builder.append(types[rounds]);
    }
    return builder.toString();
  }
}
