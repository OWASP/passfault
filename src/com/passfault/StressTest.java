/* ©Copyright 2011 Cameron Morris
 *
 * This file is part of Passfault.
 *
 * Passfault is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Passfault is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Passfault.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.passfault;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintStream;
import java.util.List;

/**
 *
 * @author cam
 */
public class StressTest {
  int recordStart = 0;
  int batchSize = 100;
  PrintStream out = System.out;

  public static void main(String args[]) throws Exception{
    StressTest stress = new StressTest();
    stress.recordStart = Integer.parseInt(args[0]);
    stress.batchSize = Integer.parseInt(args[1]);
    File outFile = new File("analysis-"+stress.recordStart+".csv");
    stress.out = new PrintStream(outFile);
    stress.testRun_concurrent();
  }

  public void testRun_concurrent() throws Exception {
    System.out.println("run");
    
    File sortedWordsFile = new File("..\\wordlists\\unsorted\\rockyou.txt");
    BufferedReader buffered = new BufferedReader(new FileReader(sortedWordsFile));
    String word = buffered.readLine().trim();
    ParallelFinder finder = BuildFinders.build("..\\wordlists\\sorted");
    double currStrengthAverage = 0;
    double currTimeAverage = 0;
    int count = 1;
    int batchCount = 0;
    PasswordResults passwords[] = new PasswordResults[batchSize];
    for(int i=0; i<recordStart;i++){
      buffered.readLine();
      count++;
    }
    long start = System.currentTimeMillis();
    while (word != null) {
      word = buffered.readLine();
      if (word == null || word.length() == 0 || word.charAt(0) == '#') {
        continue;
      }
      word = word.trim();

      PasswordResults normal = new PasswordAnalysis(word);
      finder.analyze(normal);
      passwords[batchCount] = normal;
      if (batchCount == batchSize - 1) {
        for (PasswordResults password : passwords) {
          finder.waitForAnalysis(password);
          PathCost normCost = password.calculateHighestProbablePatterns();
                            // password# cost patternsCount
          out.printf("%s\t%s\t%s\t",
              password.getCharSequence(), normCost.cost, normCost.getPath().size() );
          List<PasswordPattern> path = normCost.getPath();
          for(PasswordPattern pattern: path){
            out.print(pattern.getName());
            out.print('-');
            out.print(pattern.getClassification());
            out.print(',');
          }
          out.println();
          if (currStrengthAverage == 0)
            currStrengthAverage = normCost.cost;
          currStrengthAverage += (normCost.cost - currStrengthAverage)/count;
        }
        batchCount = 0;
        long end = System.currentTimeMillis();

        if (currTimeAverage == 0){
          currTimeAverage = end-start;
        }
        currTimeAverage += (end-start - currTimeAverage)/count;
        out.flush();
        System.out.printf("Count: %d, stength average: %f, Batch Size:%d "
            + "Elapsed time: %d miliseconds, %f milisecond average, %d memory\n",
            count, currStrengthAverage, batchSize, end - start, currTimeAverage, Runtime.getRuntime().totalMemory());
        start = System.currentTimeMillis();
      } else {
        batchCount++;
      }
      count++;
    }

  }
}
