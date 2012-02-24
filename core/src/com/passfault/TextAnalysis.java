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

import com.passfault.keyboard.EnglishKeyBoard;
import com.passfault.keyboard.KeySequenceFinder;
import com.passfault.keyboard.RussianKeyBoard;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;

/**
 * Command line password evaluator.
 * @author cam
 */
public class TextAnalysis {

  public static final String WORD_LIST_EXTENSION = ".words";
  public static TimeToCrack crack = TimeToCrack.largeCluster1024;

  public static void main(String[] args) throws IOException, Exception {
    TextAnalysis analyzer = new TextAnalysis();
    analyzer.printBanner();
    analyzer.run();
  }
  private final PatternFinder finder;

  public TextAnalysis() throws IOException {
    String internalDictionary = "/com/passfault/dictionary/english" + WORD_LIST_EXTENSION;
    InputStream englishListStream = this.getClass().getResourceAsStream(internalDictionary);
    if (englishListStream == null) {
      throw new RuntimeException("Could not load the internal dictionary");
    }
    Collection<PatternFinder> finders = BuildFinders.buildDictionaryFinders("English", englishListStream);
    finders.add(new KeySequenceFinder(new EnglishKeyBoard()));
    finders.add(new KeySequenceFinder(new RussianKeyBoard()));
    finders.add(new DateFinder());
    finder = new SequentialFinder(finders);
  }

  public void printBanner(){
    System.out.print(
"                                         /******                    /**   /**                \n"+
"                                        /**__  **                  | **  | **                \n"+
"  /******   /******   /******* /*******| **  \\__//******  /**   /**| ** /******              \n"+
" /**__  ** |____  ** /**_____//**_____/| ****   |____  **| **  | **| **|_  **_/              \n"+
"| **  \\ **  /*******|  ******|  ****** | **_/    /*******| **  | **| **  | **                \n"+
"| **  | ** /**__  ** \\____  **\\____  **| **     /**__  **| **  | **| **  | ** /**            \n"+
"| *******/|  ******* /*******//*******/| **    |  *******|  ******/| **  |  ****/            \n"+
"| **____/  \\_______/|_______/|_______/ |__/     \\_______/ \\______/ |__/   \\___/              \n"+
"| **                                                                                         \n"+
"| **                                                                                         \n"+
"|__/                                                                                         \n"+
"\n");

  }

  public void run() {
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader buf_in = new BufferedReader(reader);

    String str = "q";
    try {
      // Read a whole line a time. Check the string for
      // the "quit" input to jump from the loop.

      do {
        // Read text from keyboard
        System.out.println("\nEnter a password: ");
        str = buf_in.readLine();
        if (!str.toLowerCase().equals("q")) {
          process(str);
        } else {

          break;
        }
      } while (true);
    } catch (Exception e) {
      System.out.println("IO exception = " + e);
    }
  } // main

  private void process(final String password)
      throws IOException, Exception {
    PasswordAnalysis analysis = new PasswordAnalysis(password);

    long then = System.currentTimeMillis();
    finder.blockingAnalyze(analysis);
    PathCost worst = analysis.calculateHighestProbablePatterns();
    long now = System.currentTimeMillis();
    List<PasswordPattern> path = worst.getPath();
    System.out.println("\n\nMost crackable combination of patterns:");
    double costSum = 0;
    for (PasswordPattern subPattern : path) {
      //get the sum of pattern costs:
      costSum += subPattern.getCost();
    }
    for (PasswordPattern subPattern : path) {
      System.out.format("'%s' matches the pattern '%s'\n", subPattern.getMatchString(), subPattern.getDescription());
      System.out.format("\t%s passwords in the pattern\n", crack.getRoundedSizeString(subPattern.getCost()));
      System.out.format("\t%3.2f percent of password strength\n", subPattern.getCost() / costSum * 100);
    }

    System.out.print("Total passwords in all patterns: ");
    System.out.println(crack.getRoundedSizeString(worst.getTotalCost()));
    System.out.format("Estimated time to crack with %s processors: %s\n",
        crack.getNumberOfProcessors(), crack.getTimeToCrackString(worst.getTotalCost()));
    System.out.format("Analysis Time: %f seconds\n", (now - then) / (double) 1000);
  }
}
