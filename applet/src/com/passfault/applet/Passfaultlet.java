/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.passfault.applet;

import com.passfault.DateFinder;
import com.passfault.ParallelFinder;
import com.passfault.PasswordAnalysis;
import com.passfault.PatternFinder;
import com.passfault.TextAnalysis;
import com.passfault.dictionary.AugmentationStrategy;
import com.passfault.dictionary.DictionaryPatternsFinder;
import com.passfault.dictionary.ExactWordStrategy;
import com.passfault.dictionary.InMemoryDictionary;
import com.passfault.dictionary.MisspellingStrategy;
import com.passfault.dictionary.ReverseDictionaryPatternFinder;
import com.passfault.dictionary.SubstitutionStrategy;
import com.passfault.dictionary.l337SubstitutionStrategy;
import com.passfault.io.JsonWriter;
import com.passfault.keyboard.EnglishKeyBoard;
import com.passfault.keyboard.KeySequenceFinder;
import com.passfault.keyboard.RussianKeyBoard;
import java.applet.Applet;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Passfaultlet extends Applet {
  private ParallelFinder analyzer;
  private JsonWriter jsonWriter;

  /**
   * Initialization method that will be called after the applet is loaded
   * into the browser.
   */
  public void init() {
    try {
      analyzer = build();
      jsonWriter = new JsonWriter();
    } catch (IOException ex) {
      Logger.getLogger(Passfaultlet.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public String analyze(String password) throws Exception{
      System.out.println("analyze");
      PasswordAnalysis analysis = new PasswordAnalysis(password);
      analyzer.analyze(analysis);
      analyzer.waitForAnalysis(analysis);

      System.out.println("analyze done");
      StringWriter out = new StringWriter();
      jsonWriter.write(out, analysis.calculateHighestProbablePatterns());
      System.out.println("analyze really done");
      return out.getBuffer().toString();
  }

  public ParallelFinder build() throws IOException {
    String baseResourcePath = "/dictionaries/";
    InputStream engWords = this.getClass().getResourceAsStream(baseResourcePath + "english" + TextAnalysis.WORD_LIST_EXTENSION);
    InputStream commonEngWords = this.getClass().getResourceAsStream(baseResourcePath + "tiny-lower" + TextAnalysis.WORD_LIST_EXTENSION);
    InputStream uscities = this.getClass().getResourceAsStream(baseResourcePath + "us_cities" + TextAnalysis.WORD_LIST_EXTENSION);
    InputStream latin = this.getClass().getResourceAsStream(baseResourcePath + "latin" + TextAnalysis.WORD_LIST_EXTENSION);
    InputStream spanish = this.getClass().getResourceAsStream(baseResourcePath + "spanish" + TextAnalysis.WORD_LIST_EXTENSION);

    Collection<PatternFinder> finders = getFinders("English", engWords);
    finders.addAll(getFinders("Common", commonEngWords));
    finders.addAll(getFinders("US Cities", uscities));
    finders.addAll(getFinders("Latin", latin));
    finders.addAll(getFinders("Spanish", spanish));
    finders.add(new KeySequenceFinder(new EnglishKeyBoard()));
    finders.add(new KeySequenceFinder(new RussianKeyBoard()));
    finders.add(new DateFinder());
    return new ParallelFinder(finders);
  }

  /**
   * This is a good place to replace with some dependency injection
   * @param inputStreams
   * @return
   * @throws IOException
   */
  public Collection<PatternFinder> getFinders(String name, InputStream in) throws IOException {
    List<PatternFinder> finders = new LinkedList<PatternFinder>();
    if (in == null) {
      return finders;
    }
    try {
      Reader dbWords = new InputStreamReader(in);
      //TODO find a better way to name the dictionaries
      InMemoryDictionary diction = InMemoryDictionary.newInstance(dbWords, false, name);
      finders.add(new DictionaryPatternsFinder(diction, new ExactWordStrategy()));
      finders.add(new DictionaryPatternsFinder(diction, new MisspellingStrategy(1)));
      finders.add(new DictionaryPatternsFinder(diction, new AugmentationStrategy(2)));
      finders.add(new DictionaryPatternsFinder(diction, new SubstitutionStrategy(1)));
      finders.add(new DictionaryPatternsFinder(diction, new l337SubstitutionStrategy()));
      finders.add(new ReverseDictionaryPatternFinder(diction, new ExactWordStrategy()));
    } catch (IOException ioe) {
      ioe.printStackTrace();
    } finally {
      if (in != null) {
        in.close();
      }
    }

    return finders;
  }
}
