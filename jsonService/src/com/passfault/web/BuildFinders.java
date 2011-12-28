package com.passfault.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;

import com.passfault.DateFinder;
import com.passfault.ParallelFinder;
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
import com.passfault.keyboard.EnglishKeyBoard;
import com.passfault.keyboard.KeySequenceFinder;
import com.passfault.keyboard.RussianKeyBoard;

/**
 * Configuration Factory.  This should be replaced by some Dependency injection type
 * configuration, pico or guice.
 * @author cam
 */
public class BuildFinders {
  public static ParallelFinder build(ServletContext servletContext) throws IOException {
	  String baseResourcePath = "/WEB-INF/";
    InputStream engWords = servletContext.getResourceAsStream(baseResourcePath + "english" + TextAnalysis.WORD_LIST_EXTENSION);
    InputStream commonEngWords = servletContext.getResourceAsStream(baseResourcePath + "tiny-lower" + TextAnalysis.WORD_LIST_EXTENSION);
    InputStream uscities = servletContext.getResourceAsStream(baseResourcePath + "us_cities" + TextAnalysis.WORD_LIST_EXTENSION);
    InputStream latin = servletContext.getResourceAsStream(baseResourcePath + "latin" + TextAnalysis.WORD_LIST_EXTENSION);
    InputStream spanish = servletContext.getResourceAsStream(baseResourcePath + "spanish" + TextAnalysis.WORD_LIST_EXTENSION);

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
  public static Collection<PatternFinder> getFinders(String name, InputStream in) throws IOException {
    List<PatternFinder> finders = new LinkedList<PatternFinder>();
    if (in == null){
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