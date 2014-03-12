package org.owasp.passfault.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.owasp.passfault.DateFinder;
import org.owasp.passfault.PatternFinder;
import org.owasp.passfault.PropertiesFindersBuilder;
import org.owasp.passfault.TextAnalysis;
import org.owasp.passfault.dictionary.AugmentationStrategy;
import org.owasp.passfault.dictionary.DictionaryPatternsFinder;
import org.owasp.passfault.dictionary.ExactWordStrategy;
import org.owasp.passfault.dictionary.InMemoryDictionary;
import org.owasp.passfault.dictionary.MisspellingStrategy;
import org.owasp.passfault.dictionary.ReverseDictionaryPatternFinder;
import org.owasp.passfault.dictionary.SubstitutionStrategy;
import org.owasp.passfault.dictionary.l337SubstitutionStrategy;
import org.owasp.passfault.keyboard.EnglishKeyBoard;
import org.owasp.passfault.keyboard.KeySequenceFinder;
import org.owasp.passfault.keyboard.RussianKeyBoard;

/**
 * Configuration Factory.  This could be replaced by some Dependency injection type
 * configuration, pico or guice.
 * @author cam
 */
public class BuildFinders {
  public Collection<PatternFinder> build(ServletContext servletContext) throws IOException {
    PropertiesFindersBuilder standardBuilder = new PropertiesFindersBuilder();
	  String dictionariesPath = "/WEB-INF/dictionaries";
	  Set<String> dictionaries = servletContext.getResourcePaths(dictionariesPath);
	  Collection<PatternFinder> finders = new LinkedList<PatternFinder>();
    for(String wordlist: dictionaries){
      if (wordlist.endsWith(PropertiesFindersBuilder.WORD_LIST_EXTENSION)){
        String name = getDictionaryName(wordlist);
        Reader in = new InputStreamReader(servletContext.getResourceAsStream(wordlist));
        InMemoryDictionary diction = InMemoryDictionary.newInstance(in, false, name);
        finders.addAll(standardBuilder.buildDictionaryFinders(diction));
      }
    }
    finders.addAll(standardBuilder.buildStandardFinders());
    return finders;
  }

  private String getDictionaryName(String wordlist)
  {
    int slash = wordlist.lastIndexOf('/');
    int dot = wordlist.lastIndexOf('.');
    return wordlist.substring(slash+1, dot);
  }
}
