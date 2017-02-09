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

package org.owasp.passfault.api;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * TimeToCrack estimates the time required to find one password in a password pattern.
 * The time to crack is the average time to find the password, which on average is the time to
 * enumerate half of the passwords.
 *
 * The cracking speeds are based on a Hashcat benchmark with a GeForce GTX TITAN X, 12287MB, 1215Mhz, 24MCU.
 *
 * @author cam, bernardo
 */
public class TimeToCrack {
  private int numberOfGPUs, hashOption;
  private double crackTimeNanosecs, crackSpeed;
  private String hashType;
  private Map<Integer, Float> speedMap;
  private Map<Integer, String> algMap;

  public static final String BENCHMARK_INFO = "hashcat/hashcat.txt";

  public TimeToCrack(int numberOfGPUs, int algOption) {
    setMaps();
    this.numberOfGPUs = numberOfGPUs;
    this.hashOption = algOption;
    this.hashType = algMap.get(algOption);

    this.crackSpeed = speedMap.get(algOption);
    this.crackTimeNanosecs = (double) (1000000000/crackSpeed);
  }

  public TimeToCrack(float hashSpeed) {
    this.crackTimeNanosecs = (double) (1000000000/hashSpeed);
  }

  public double getCrackSpeed(){
    return this.crackSpeed * this.numberOfGPUs;
  }

  public void setHashSpeed(float hashSpeed){
    crackTimeNanosecs = (long) (1000000000/hashSpeed);
  }

  public String getHashType(){
    return hashType;
  }

  public int getNumberOfGPUs() {
    return numberOfGPUs;
  }

  /**
   * @param patternSize represents the number of passwords in a pattern
   * @return the milliseconds needed to crack the pattern
   */
  public double getTimeToCrackNanoSeconds(double patternSize) {
    if (numberOfGPUs == 0)
      return (crackTimeNanosecs * (patternSize));
    else
      return (crackTimeNanosecs * (patternSize)) / numberOfGPUs;
  }

  /**
   * @param patternSize represents the number of passwords in a pattern
   * @return a display suitable string displaying the time to crack
   */
  public String getTimeToCrackString(double patternSize) {
    double nanoseconds = getTimeToCrackNanoSeconds(patternSize);
    double seconds = nanoseconds / 1000000000;
    int days = (int) (nanoseconds / 1000000000 / 60 / 60 / 24);
    int months = (int) (nanoseconds / 1000000000 / 60 / 60 / 24 / 30);
    int years = (int) (nanoseconds / 1000000000 / 60 / 60 / 24 / 365);
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
      //buf.append("less than 1 day");
      int hours = (int) seconds / 60;
      int minutes = (int) seconds % 60;
      if (hours > 0){
        buf.append(hours);
        buf.append(" hours, ");
      }

      if (minutes > 0){
        buf.append(minutes);
        buf.append("minutes");
      }else{
        String ns = String.format("%12.2f", nanoseconds);
        buf.append(ns.replace(" ", ""));
        buf.append(" nanoseconds");
      }
    }
    return buf.toString();
  }

  public static String formatSeconds(double seconds) {
    double nanoseconds = seconds*1000000000;
    int days = (int) (nanoseconds / 1000000000 / 60 / 60 / 24);
    int months = (int) (nanoseconds / 1000000000 / 60 / 60 / 24 / 30);
    int years = (int) (nanoseconds / 1000000000 / 60 / 60 / 24 / 365);
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
      //buf.append("less than 1 day");
      int hours = (int) seconds / 60;
      int minutes = (int) seconds % 60;
      if (hours > 0){
        buf.append(hours);
        buf.append(" hours, ");
      }

      if (minutes > 0){
        buf.append(minutes);
        buf.append("minutes");
      }else{
        String ns = String.format("%12.2f", nanoseconds);
        buf.append(ns.replace(" ", ""));
        buf.append(" nanoseconds");
      }
    }
    return buf.toString();
  }

  /** 
   * @param size number to convert into readable text
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
      if (size > 1000){
        builder.append(' ');
        builder.append(types[rounds]);
      }
    }
    return builder.toString();
  }

  private void setMaps(){
    speedMap = new HashMap<>();
    algMap = new HashMap<>();
    try{
      BufferedReader buffered = new BufferedReader(new FileReader(BENCHMARK_INFO));
      String line;

      int i = 0;
      while ((line = buffered.readLine()) != null){
        String[] tokens = line.split(";");
        speedMap.put(Integer.parseInt(tokens[0]), Float.parseFloat(tokens[2]));
        algMap.put(Integer.parseInt(tokens[0]), tokens[1]);
      }
      buffered.close();
    }catch (FileNotFoundException e){
      System.out.println(e);
      System.exit(0);
    }catch (IOException e){
      System.out.println("IOException");
      System.exit(0);
    }
  }
}
