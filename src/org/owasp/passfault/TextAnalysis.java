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

import org.apache.commons.cli.*;
import org.owasp.passfault.dictionary.DictionaryPatternsFinder;
import org.owasp.passfault.dictionary.ExactWordStrategy;
import org.owasp.passfault.dictionary.FileDictionary;
import org.owasp.passfault.finders.ParallelFinder;
import org.owasp.passfault.dictionary.Dictionary;

import java.io.*;
import java.util.Collection;
import java.util.List;

/**
 * Command line password evaluator.
 * @author cam
 */
public class TextAnalysis {

  public static TimeToCrack crack;
  private static Dictionary cDict;
  private static BufferedReader inputFile;
  private static int inputFileSize;
  private static PrintWriter outputFile;
  private static boolean time2crackGPU, time2crackSpeed, input, output, customDict, customDictOnly, verbose;
  private static String password;
  private static int machineNum, hashNum;
  private static float hashSpeed;

  private final CompositeFinder finder;

  public static void main(String[] args) throws Exception {
    if (args.length == 0){
      System.out.println("CLI error: you must provide some information. See help for more info.");
      System.exit(0);
    }

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

    Collection<PatternFinder> finders = new FinderByPropsBuilder().
        loadDefaultWordLists().
        isInMemory(true).
        build();
    if (customDict){
      if (customDictOnly)
        finders.clear();
      finders.add(new DictionaryPatternsFinder(cDict, new ExactWordStrategy()));
    }

    finder = new ParallelFinder(finders);
  }

  private void cli(String[] args){
    Options options = new Options();
    options.addOption("p", "password", true, "password to be analyzed");
    options.addOption("i", "input", true, "path to input file");
    options.addOption("o", "output", true, "path to output file");
    options.addOption("g", "gpu", true, "number of GPUs for Time to Crack analysis");
    options.addOption("c", "customDictionaryOnly", false, "ignore internal dictionaries and use custom dictionary only");
    options.addOption("d", "customDictionary", true, "path to custom dictionary");
    options.addOption("f", "hashFunction", true, "hash function for Time to Crack analysis");
    options.addOption("s", "hashSpeed", true, "hashes per second for Time to Crack analysis");
    options.addOption("v", "verbose", false, "verbose mode");
    options.addOption("h", "help", false, "help menu");

    try {
      CommandLineParser parser = new DefaultParser();
      CommandLine line = parser.parse(options, args);
      boolean exit = false;

      if (line.hasOption("help")){
        System.out.println("help instructions");

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

      if(line.hasOption("customDictionary")){
        String customDictPath = line.getOptionValue("customDictionary");

        try {
          cDict = FileDictionary.newInstance(customDictPath, "customDict");
        }catch (IOException e){
          System.out.println("CLI error: invalid path in -d option. See help for more info.");
          exit = true;
        }

        customDict = true;
      }

      if(line.hasOption("customDictionaryOnly")){
        customDictOnly = true;
        if (!line.hasOption("customDictionary")){
          System.out.println("CLI error: you need to give the path to a custom dictionary with option -d. See help for more info.");
          exit = true;
        }
      }

      if(line.hasOption("password")){
        if (line.hasOption("input")){
          System.out.println("CLI error: too many input options! Use either -p or -i, never both! See help for more info.");
          exit = true;
        }

        password = line.getOptionValue("password");
        if (password.length() < 4){
          System.out.println("CLI error: password too small!");
          exit = true;
        }
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

      if (exit){
        System.out.println("Leaving.");
        System.exit(0);
      }

    }catch(ParseException exp){
      System.out.println("CLI error: " + exp.getMessage());
      System.out.println("Leaving.");
      System.exit(0);
    }
  }

  public void printBanner(){
    if (output){
      outputFile.print(
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
    }else{
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
  }

  private void process() throws Exception {
    if (output)
      System.out.println("Please wait, results are being written to output file... ");

    if (input){
      int line = 0;
      while ((password = inputFile.readLine()) != null) {
        line++;
        double done = 100.0* ((double) line)/inputFileSize;
        System.out.format("Analysing '%s', %3.2f percent done.\n", password, done);
        passwordAnalysis(password);
      }
    }else{
      passwordAnalysis(password);
    }

    if (output){
      outputFile.close();
      System.out.println("Finished writing output file.");
    }

    System.exit(0);
  }

  private void passwordAnalysis(String password) throws Exception{
    PasswordAnalysis analysis = new PasswordAnalysis(password);
    long then = System.currentTimeMillis();
    finder.blockingAnalyze(analysis);
    PathCost worst = analysis.calculateHighestProbablePatterns();
    long now = System.currentTimeMillis();

    double analysisTime = (now - then) / 1000.0;

    if (output){
      writeOutput(worst, analysisTime);
    }else{
      printOutput(worst, analysisTime);
    }
  }

  private void writeOutput(PathCost worst, double analysisTime){
    List<PasswordPattern> path = worst.getPath();
    outputFile.format("\n\nRules found in password '%s': \n", worst.getPassword().getCharSequence());
    double costSum = 0;
    for (PasswordPattern subPattern : path) {
      //get the sum of pattern costs:
      costSum += subPattern.getCost();
    }

    for (PasswordPattern subPattern : path) {
      outputFile.format("'%s' matches the Rule: '%s' in '%s'\n", subPattern.getMatchString(), subPattern.getDescription(), subPattern.getClassification());
      outputFile.format("\taround %s passwords in this Rule\n", TimeToCrack.getRoundedSizeString(subPattern.getCost()));
      outputFile.format("\tcontains %3.2f percent of password strength\n", subPattern.getCost() / costSum * 100);
    }

    outputFile.print("Total complexity (size of smallest search space): ");
    outputFile.println(TimeToCrack.getRoundedSizeString(worst.getTotalCost()));

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

  private void printOutput(PathCost worst, double analysisTime){
    List<PasswordPattern> path = worst.getPath();
    System.out.format("\n\nRules found in password '%s': \n", worst.getPassword().getCharSequence());
    double costSum = 0;
    for (PasswordPattern subPattern : path) {
      //get the sum of pattern costs:
      costSum += subPattern.getCost();
    }

    for (PasswordPattern subPattern : path) {
      System.out.format("'%s' matches the Rule: '%s' in '%s'\n", subPattern.getMatchString(), subPattern.getDescription(), subPattern.getClassification());
      System.out.format("\taround %s passwords in this Rule\n", TimeToCrack.getRoundedSizeString(subPattern.getCost()));
      System.out.format("\tcontains %3.2f percent of password strength\n", subPattern.getCost() / costSum * 100);
    }

    System.out.print("Total complexity (size of smallest search space): ");
    System.out.println(TimeToCrack.getRoundedSizeString(worst.getTotalCost()));

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
}
