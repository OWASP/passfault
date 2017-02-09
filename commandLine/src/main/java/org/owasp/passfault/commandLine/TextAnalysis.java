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

package org.owasp.passfault.commandLine;

import java.io.*;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.cli.*;
import org.owasp.passfault.api.*;
import org.owasp.passfault.finders.ResponseOptimizedFinders;
import org.owasp.passfault.impl.*;

/**
 * Command line password evaluator.
 * @author Cam, Bernardo
 */
public class TextAnalysis {

  public static final String BANNER = "                                         /******                    /**   /**                \n" +
      "                                        /**__  **                  | **  | **                \n" +
      "  /******   /******   /******* /*******| **  \\__//******  /**   /**| ** /******              \n" +
      " /**__  ** |____  ** /**_____//**_____/| ****   |____  **| **  | **| **|_  **_/              \n" +
      "| **  \\ **  /*******|  ******|  ****** | **_/    /*******| **  | **| **  | **                \n" +
      "| **  | ** /**__  ** \\____  **\\____  **| **     /**__  **| **  | **| **  | ** /**            \n" +
      "| *******/|  ******* /*******//*******/| **    |  *******|  ******/| **  |  ****/            \n" +
      "| **____/  \\_______/|_______/|_______/ |__/     \\_______/ \\______/ |__/   \\___/              \n" +
      "| **                                                                                         \n" +
      "| **                                                                                         \n" +
      "|__/                                                                                         \n" +
      "\n";
  public static TimeToCrack crack;
  private static BufferedReader inputFile;
  private static int inputFileSize;
  private static PrintWriter outputFile;
  private static ArrayList matlabList;
  private static String matlabPath;
  private static boolean time2crackGPU, time2crackSpeed, input, output, matlab, count;
  private static String password;
  private static int machineNum, hashNum;
  private static float hashSpeed;
  //temporary
  private static int freq;

  private CompositeFinder finder;
  private PatternsAnalyzer analyzer = new PatternsAnalyzerImpl();
  private File wordlistOverrideDir;
  private boolean inMemory = true;

  public static void main(String[] args) throws Exception {

    TextAnalysis analyzer = new TextAnalysis(args);
    analyzer.printBanner();
    analyzer.process();
  }

  public TextAnalysis(String[] args) throws IOException {
    cli(args);

    if (time2crackGPU){
      crack = new TimeToCrack(machineNum, hashNum);
    }else if(time2crackSpeed){
      crack = new TimeToCrack(hashSpeed);
    }


    Collection<PatternFinder> finders;
    if (wordlistOverrideDir == null) {
      finders = new FinderByPropsBuilder()
          .loadDefaultWordLists()
          .isInMemory(true)
          .build();
    } else {
      finders = new FinderByPropsBuilder()
          .setFileLoader(wordlistOverrideDir)
          .isInMemory(true)
          .build();
    }

    finder = new ResponseOptimizedFinders(finders, new FilteringPatternCollectionFactory());
  }

  private void cli(String[] args){
    Options options = new Options();
    options.addOption("p", "password", true, "password to be analyzed");
    options.addOption("i", "input", true, "path to input file");
    options.addOption("c", "inputWithCount", false, "input file with count");
    options.addOption("o", "output", true, "path to output file");
    options.addOption("g", "gpu", true, "number of GPUs for Time to Crack analysis");
    options.addOption("f", "hashFunction", true, "hash function for Time to Crack analysis");
    options.addOption("s", "hashSpeed", true, "hashes per second for Time to Crack analysis");
    options.addOption("m", "matlab", true, "formatted output");
    options.addOption("v", "verbose", false, "verbose mode");
    options.addOption("h", "help", false, "help menu");
    options.addOption("W", "wordlists", true, "Directory for wordlists to override default wordlists");
    options.addOption("w", "wordlists", true, "Directory for wordlists to add to default wordlists");

    try {
      CommandLineParser parser = new BasicParser();
      CommandLine line = parser.parse(options, args);
      boolean exit = false;

      if (line.hasOption("help")){
        System.out.println("help instructions");
        new HelpFormatter().printHelp("passfault", options );
        System.exit(0);
      }

      if(line.hasOption("input")){
        String inputPath = line.getOptionValue("input");

        try{
          //count lines
          inputFile = new BufferedReader(new FileReader(inputPath));
          inputFileSize = 0;
          while (inputFile.readLine() != null) inputFileSize++;
          inputFile.close();

          inputFile = new BufferedReader(new FileReader(inputPath));

        }catch (FileNotFoundException e){
          System.out.println("CLI error: invalid path in -i option. See help for more info.");
          System.exit(0);
        }catch (IOException e){
          System.out.println(e);
          System.exit(0);
        }

        input = true;
      }

      if (line.hasOption("output")){
        String outputPath = line.getOptionValue("output");
        try{
          outputFile = new PrintWriter(outputPath, "UTF-8");
        }catch (FileNotFoundException e){
          System.out.println("?");
          System.exit(0);
        }catch (UnsupportedEncodingException e){
          System.out.println(e);
          System.exit(0);
        }

        output = true;
      }

      if (line.hasOption("inputWithCount")){
        if (!line.hasOption("input")){
          System.out.println("CLI error: no input file! See help for more info.");
          exit = true;
        }

        count = true;
      }

      if(line.hasOption("password")){
        if (line.hasOption("input")){
          System.out.println("CLI error: too many input options! Use either -p or -i, never both! See help for more info.");
          exit = true;
        }
        inMemory = false;
        password = line.getOptionValue("password");
      }

      if (line.hasOption("hashSpeed") || line.hasOption("gpu") || line.hasOption("hashFunction")){
        if ((line.hasOption("gpu") && !line.hasOption("hashFunction")) || (!line.hasOption("gpu") && line.hasOption("hashFunction"))) {
          System.out.println("CLI error: in order to get Time to Crack analysis, you need to provide either only -s, or both -g and -f options. See help for more info.");
          exit = true;

        }else if(line.hasOption("hashSpeed") && line.hasOption("gpu") && line.hasOption("hashFunction")) {
          System.out.println("CLI error: in order to get Time to Crack analysis, you need to provide either only -s, or both -g and -f options. See help for more info.");
          exit = true;

        }else if(line.hasOption("hashSpeed")){
          time2crackSpeed = true;

          String hps = line.getOptionValue("hashSpeed");
          hashSpeed = new Float(hps);

          if (hashSpeed <= 0){
            System.out.println("CLI error: you must provide a number in the right format for -s option. See help for more info.");
            exit = true;
          }

        }else if (line.hasOption("gpu") && line.hasOption("hashFunction")){
          time2crackGPU = true;

          String gpu = line.getOptionValue("gpu");
          machineNum = new Integer(gpu);

          String hashFunction = line.getOptionValue("hashFunction");
          hashNum = new Integer(hashFunction);

          if (machineNum < 1){
            System.out.println("CLI error: you must use at least one GPU for the simulation. See help for more info.");
            exit = true;
          }

          if (hashNum < 0 || hashNum > 101){
            System.out.println("CLI error: invalid argument for -f. See help for more info.");
            exit = true;
          }
        }
      }

      if (line.hasOption("matlab")){
        String outputPath = line.getOptionValue("matlab");
        try{
          outputFile = new PrintWriter(outputPath, "UTF-8");
        }catch (FileNotFoundException e){
          System.out.println("?");
          System.exit(1);
        }catch (UnsupportedEncodingException e){
          System.out.println(e);
          System.exit(1);
        }

        matlab = true;
      }

      if (line.hasOption('W')) {
        String wordlistOverrideDirPath = line.getOptionValue('W');
        wordlistOverrideDir = new File(wordlistOverrideDirPath);
        if (!wordlistOverrideDir.exists()) {
          System.err.println("Cannot find wordlist directory " + wordlistOverrideDir);
          System.exit(1);
        }
        File wordlistProperties = new File(wordlistOverrideDir, "words.properties");

        if (!wordlistProperties.exists()) {
          System.err.println("words.properties file not found in wordlist directory " + wordlistOverrideDir);
        }
      }
      if (exit){
        System.out.println("Leaving.");
        System.exit(0);
      }

    } catch(ParseException exp){
      System.out.println("error: " + exp.getMessage());
      new HelpFormatter().printHelp( "passfault", options );
      System.out.println();
      System.exit(1);
    }
  }

  public void printBanner(){
    if (output){
      outputFile.print(BANNER);
    }else{
      System.out.print(BANNER);
    }
  }

  private void process() throws Exception {
    if (output || matlab)
      System.out.println("Please wait, results are being written to output file... ");

    if (input){
      handleInputFile();
    } else if (password == null) {
      System.out.println("Enter a password to analyze: ");
      if (System.console() != null) {
        password = new String(System.console().readPassword());
      } else {
        //if you don't have access to a console than your'll have the less secure scanner
        password = new Scanner(System.in).nextLine();
      }
      passwordAnalysis(password);
    } else {
      passwordAnalysis(password);
    }

    if (output || matlab){
      outputFile.close();
      System.out.println("Finished writing output file.");
    }

    System.exit(0);
  }

  private void handleInputFile() throws Exception {
    int line = 0;
    double sumAnalysisTime = 0, analysisTime, remainingTime, avgAnalysisTime, done;

    //temporary
    String l;
    while ((l = inputFile.readLine()) != null) {
      if (count){
        password = l.substring(8);
        freq = Integer.parseInt(l.substring(0, 7).replace(" ", ""));
      }else{
        password = l;
      }


      done = 100.0* ((double) line)/inputFileSize;
      line++;

      if (output || matlab)
        System.out.format("Analyzing '%s', %3.2f percent done, ", password, done);

      analysisTime = 0;
      if (password.length() != 0)
        analysisTime = passwordAnalysis(password);
      sumAnalysisTime += analysisTime;
      avgAnalysisTime = sumAnalysisTime/line;
      remainingTime = (inputFileSize - line) * avgAnalysisTime;

      if (output || matlab)
        System.out.format("around %3.2f remaining.\n", remainingTime);
    }
  }

  private double passwordAnalysis(String password) throws Exception{
    long then = System.currentTimeMillis();
    PatternCollection patterns = finder.search(password);
    AnalysisResult worst = analyzer.analyze(patterns);
    long now = System.currentTimeMillis();

    double analysisTime = (now - then) / 1000.0;

    if (output){
      writeOutput(worst, password);
    }else if(matlab){
      writeMatlab(worst, password);
    }else{
      printOutput(worst, password);
    }

    return analysisTime;
  }

  private void writeOutput(AnalysisResult worst, String password){
    List<PasswordPattern> path = worst.getPath();
    outputFile.format("\n\nRules found in password '%s': \n", password);
    double costSum = 0;
    for (PasswordPattern subPattern : path) {
      //get the sum of pattern costs:
      costSum += subPattern.getCost();
    }

    for (PasswordPattern subPattern : path) {
      outputFile.format("'%s' matches the Rule: '%s' in '%s'\n", subPattern.getMatchString(), subPattern.getDescription(), subPattern.getClassification());
      outputFile.format("\taround %d passwords in this Rule\n", (long) subPattern.getCost());
      outputFile.format("\tcontains %3.2f percent of password strength\n", subPattern.getCost() / costSum * 100);
    }

    outputFile.format("Total complexity (size of smallest search space): %d\n", (long) worst.getTotalCost());

    if (time2crackGPU) {
      outputFile.format("Hashing Algorithm: '%s'\n", crack.getHashType());
      outputFile.format("Estimated cracking speed with %s GPU(s): %s H/s\n",
              crack.getNumberOfGPUs(), crack.getRoundedSizeString(crack.getCrackSpeed()));
      outputFile.format("Estimated time to crack password with %s GPU(s): %s\n",
              crack.getNumberOfGPUs(), crack.getTimeToCrackString(worst.getTotalCost()));
    } else if (time2crackSpeed) {
      outputFile.format("Estimated time to crack at %s H/s: %s\n",
              hashSpeed, crack.getTimeToCrackString(worst.getTotalCost()));
    }

    //verbose only
    //outputFile.format("Analysis Time: %f seconds\n", analysisTime);
  }

  private void printOutput(AnalysisResult worst, String password){
    List<PasswordPattern> path = worst.getPath();
    System.out.println("Rules found in password");
    double costSum = 0;
    for (PasswordPattern subPattern : path) {
      //get the sum of pattern costs:
      costSum += subPattern.getCost();
    }

    for (PasswordPattern subPattern : path) {
      String a = subPattern.getClassification();
      System.out.format("'%s' matches the Rule: '%s' in '%s'\n", subPattern.getMatchString(), subPattern.getDescription(), subPattern.getClassification());
      System.out.format("\taround %d passwords in this Rule\n", (long) subPattern.getCost());
      System.out.format("\tcontains %3.2f percent of password strength\n", subPattern.getCost() / costSum * 100);
    }

    System.out.format("Total complexity (size of smallest search space): %d\n", (long) worst.getTotalCost());

    if (time2crackGPU) {
      System.out.format("Hashing Algorithm: '%s'\n", crack.getHashType());
      System.out.format("Estimated cracking speed with %s GPU(s): %s H/s\n",
              crack.getNumberOfGPUs(), crack.getRoundedSizeString(crack.getCrackSpeed()));
      System.out.format("Estimated time to crack password with %s GPU(s): %s\n",
              crack.getNumberOfGPUs(), crack.getTimeToCrackString(worst.getTotalCost()));
    } else if (time2crackSpeed) {
      System.out.format("Estimated time to crack at %s H/s: %s\n",
              hashSpeed, crack.getTimeToCrackString(worst.getTotalCost()));
    }

    //verbose only
    //System.out.format("Analysis Time: %f seconds\n", analysisTime);
  }

  private void writeMatlab(AnalysisResult worst, String password){
    List<PasswordPattern> path = worst.getPath();
    CharSequence p = password;
    outputFile.format("\npassword:\t%s\n", p);
    double costSum = 0;
    for (PasswordPattern subPattern : path) {
      //get the sum of pattern costs:
      costSum += subPattern.getCost();
    }

    int i = 0;
    for (PasswordPattern subPattern : path) {
      outputFile.format("rule.%d.substring:\t%s\n", i, subPattern.getMatchString());
      outputFile.format("rule.%d.rule:\t%s\n", i, subPattern.getDescription());
      outputFile.format("rule.%d.search space:\t%s\n", i, subPattern.getClassification());
      outputFile.format("rule.%d.complexity:\t%s\n", i, (long) subPattern.getCost());
      outputFile.format("rule.%d.percent:\t%3.2f\n", i, subPattern.getCost() / costSum * 100);
      i++;
    }

    outputFile.format("totalComplexity:\t%d\n", (long) worst.getTotalCost());

    if (time2crackSpeed) {
      outputFile.format("crackingSpeed:\t%s\n", hashSpeed);
      outputFile.format("timeToCrack:\t%s\n", crack.getTimeToCrackString(worst.getTotalCost()));
    }

    //temporary
    if(count)
      outputFile.format("frequency:\t%d\n", freq);
  }
}
