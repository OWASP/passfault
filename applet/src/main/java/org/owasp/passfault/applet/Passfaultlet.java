/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.owasp.passfault.applet;

import org.owasp.passfault.FinderByPropsBuilder;
import org.owasp.passfault.finders.DateFinder;
import org.owasp.passfault.finders.ParallelFinder;
import org.owasp.passfault.PasswordAnalysis;
import org.owasp.passfault.PatternFinder;
import org.owasp.passfault.TextAnalysis;
import org.owasp.passfault.io.JsonWriter;
import org.owasp.passfault.keyboard.EnglishKeyBoard;
import org.owasp.passfault.keyboard.KeySequenceFinder;
import org.owasp.passfault.keyboard.RussianKeyBoard;
import java.applet.Applet;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Collection;
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
   * This builds any finders needed for this applet
   * @return
   * @throws IOException
   */
  public Collection<PatternFinder> getFinders(String name, InputStream in) throws IOException {
    return new FinderByPropsBuilder().
        loadDefaultWordLists().
        isInMemory(true).
        build();
  }
}
