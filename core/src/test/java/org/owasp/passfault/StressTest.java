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

package org.owasp.passfault;

import org.owasp.passfault.api.CompositeFinder;
import org.owasp.passfault.api.AnalysisResult;
import org.owasp.passfault.api.PatternsAnalyzer;
import org.owasp.passfault.api.PatternCollection;
import org.owasp.passfault.finders.RepeatingPatternDecorator;
import org.owasp.passfault.impl.PasswordPattern;
import org.owasp.passfault.impl.PatternsAnalyzerImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

public class StressTest {
  int recordStart = 0;
  int batchSize = 100;
  PrintStream out = System.out;

  public static void main(String args[]) throws Exception {
    StressTest stress = new StressTest();
    stress.recordStart = Integer.parseInt(args[0]);
    stress.batchSize = Integer.parseInt(args[1]);
    File outFile = new File("analysis-" + stress.recordStart + ".csv");
    stress.out = new PrintStream(outFile);
    stress.testRun_concurrent();
  }

  public void testRun_concurrent() throws Exception {
    System.out.println("run");
    PatternsAnalyzer analyzer = new RepeatingPatternDecorator(new PatternsAnalyzerImpl());

    File sortedWordsFile = new File("..\\wordlists\\unsorted\\rockyou.txt");
    BufferedReader buffered = new BufferedReader(new FileReader(sortedWordsFile));
    String word = buffered.readLine().trim();
    CompositeFinder finder = BuildFinders.build("..\\wordlists\\sorted");
    double currStrengthAverage = 0;
    double currTimeAverage = 0;
    int count = 1;
    int batchCount = 0;
    for (int i = 0; i < recordStart; i++) {
      buffered.readLine();
      count++;
    }
    LinkedList<Future<PatternCollection>> backlog = new LinkedList<>();
    long start = System.currentTimeMillis();
    while (word != null) {
      word = buffered.readLine();
      if (word == null || word.length() == 0 || word.charAt(0) == '#') {
        continue;
      }
      word = word.trim();

      backlog.add(finder.searchFuture(word));
      if (batchCount == batchSize - 1) {
        for (Future<PatternCollection> future : backlog) {
          PatternCollection patterns = future.get();
          AnalysisResult normCost = analyzer.analyze(patterns);
          // password# cost patternsCount
          out.printf("%s\t%s\t%s\t",
            word, normCost.getTotalCost(), normCost.getPath().size());
          List<PasswordPattern> path = normCost.getPath();
          for (PasswordPattern pattern : path) {
            out.print(pattern.getName());
            out.print('-');
            out.print(pattern.getClassification());
            out.print(',');
          }
          out.println();
          if (currStrengthAverage == 0)
            currStrengthAverage = normCost.getTotalCost();
          currStrengthAverage += (normCost.getTotalCost() - currStrengthAverage) / count;
        }
        batchCount = 0;
        long end = System.currentTimeMillis();

        if (currTimeAverage == 0) {
          currTimeAverage = end - start;
        }
        currTimeAverage += (end - start - currTimeAverage) / count;
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
