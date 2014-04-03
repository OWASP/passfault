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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;

import org.owasp.passfault.finders.DateFinder;
import org.owasp.passfault.finders.RandomClassesFinder;
import org.owasp.passfault.finders.SequentialFinder;
import org.owasp.passfault.keyboard.EnglishKeyBoard;
import org.owasp.passfault.keyboard.KeySequenceFinder;
import org.owasp.passfault.keyboard.RussianKeyBoard;

/**
 * Command line password evaluator.
 * @author cam
 */
public class TextAnalysis {

  public static final String WORD_LIST_EXTENSION = ".words";
  public static TimeToCrack crack = TimeToCrack.GPU1;
  

  public static void main(String[] args) throws IOException, Exception {
    TextAnalysis analyzer = new TextAnalysis();
    analyzer.printBanner();
    analyzer.run();
  }
  private final CompositeFinder finder;

  public TextAnalysis() throws IOException {
    String internalDictionary = "/org/owasp/passfault/dictionary/english" + WORD_LIST_EXTENSION;
    InputStream englishListStream = this.getClass().getResourceAsStream(internalDictionary);
    if (englishListStream == null) {
      throw new RuntimeException("Could not load the internal dictionary");
    }
    Collection<PatternFinder> finders = BuildFinders.buildDictionaryFinders("English", englishListStream);
    finders.add(new KeySequenceFinder(new EnglishKeyBoard()));
    finders.add(new KeySequenceFinder(new RussianKeyBoard()));
    finders.add(new DateFinder());
    finders.add(new RandomClassesFinder());
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
    String machineChoice = "1";
    String hashChoice = "1";
    try {
      // Read a whole line a time. Check the string for
      // the "quit" input to jump from the loop.

      do {
        // Read text from keyboard
        System.out.println("\nPlease enter a password: (Enter 'q' to exit)");
        str = buf_in.readLine();
        if (!str.toLowerCase().equals("q")) {
          // Read the choice of cracking machine
          System.out.println("\nChoose a machine from the following list to crack the password:");
          System.out.println("[1] 1 high-end GPU(Every day hacker, $500)");
          System.out.println("[2] 10 high-end GPUs(Dedicated hacker, $5,000)");
          System.out.println("[3] 100 high-end GPUs(Organized crime hacker, $50,000)");
          System.out.println("[4] 1000 high-end GPUs(Government, $500,000)");
          machineChoice = buf_in.readLine();
          int machineNum = Integer.parseInt(machineChoice);
          
          // Read choice of hashing algorithm
          System.out.println("\nSelect the password protection technique (to estimate crack time):");
          System.out.println("[1] bcrypt");
          System.out.println("[2] md5crypt");
    System.out.println("[3] sha512crypt");
          System.out.println("[4] Password Safe"); 
          hashChoice = buf_in.readLine();
          int hashNum = Integer.parseInt(hashChoice);
          
          process(str, machineNum, hashNum);
        } else {

          break;
        }
      } while (true);
    } catch (Exception e) {
      System.out.println("IO exception = " + e);
    }
  } // main

  private void process(final String password, int machineNum, int hashNum)
      throws IOException, Exception {
    PasswordAnalysis analysis = new PasswordAnalysis(password);
    
    switch (machineNum) {
      case 1: crack = TimeToCrack.GPU1;
              break;
      case 2: crack = TimeToCrack.GPU10;
              break;
      case 3: crack = TimeToCrack.GPU100;
              break;
      case 4: crack = TimeToCrack.GPU1000;
              break;
      default: crack = TimeToCrack.GPU1;
               break;
    }
    
    switch (hashNum) {
      case 1: crack.setHashType("bcrypt", hashNum);
              break;        
      case 2: crack.setHashType("md5crypt", hashNum);
              break;
      case 3: crack.setHashType("sha512crypt", hashNum);
              break;
      case 4: crack.setHashType("Password Safe", hashNum);
        break;
      default: crack.setHashType("bcrypt", hashNum);
               break;
    }

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
    System.out.format("Estimated time to crack with %s GPU(s): %s\n",
        crack.getNumberOfGPUs(), crack.getTimeToCrackString(worst.getTotalCost()));
    System.out.format("Analysis Time: %f seconds\n", (now - then) / (double) 1000);
  }
}
