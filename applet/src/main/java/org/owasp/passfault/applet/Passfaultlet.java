/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.owasp.passfault.applet;

import org.owasp.passfault.DateFinder;
import org.owasp.passfault.ParallelFinder;
import org.owasp.passfault.PasswordAnalysis;
import org.owasp.passfault.PatternFinder;
import org.owasp.passfault.TextAnalysis;
import org.owasp.passfault.dictionary.AugmentationStrategy;
import org.owasp.passfault.dictionary.DictionaryPatternsFinder;
import org.owasp.passfault.dictionary.ExactWordStrategy;
import org.owasp.passfault.dictionary.InMemoryDictionary;
import org.owasp.passfault.dictionary.MisspellingStrategy;
import org.owasp.passfault.dictionary.ReverseDictionaryPatternFinder;
import org.owasp.passfault.dictionary.SubstitutionStrategy;
import org.owasp.passfault.dictionary.l337SubstitutionStrategy;
import org.owasp.passfault.io.JsonWriter;
import org.owasp.passfault.keyboard.EnglishKeyBoard;
import org.owasp.passfault.keyboard.KeySequenceFinder;
import org.owasp.passfault.keyboard.RussianKeyBoard;
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
