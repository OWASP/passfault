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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Configuration Factory.  This should be replaced by some Dependency injection type
 * configuration, pico or guice.
 * @author cam
 */
public class BuildFinders {
  public static ParallelFinder build(String baseResourcePath) throws IOException {
    URL engWords = new URL(baseResourcePath + "english" + TextAnalysis.WORD_LIST_EXTENSION);
    URL commonEngWords = new URL(baseResourcePath + "tiny-lower" + TextAnalysis.WORD_LIST_EXTENSION);
    URL uscities = new URL(baseResourcePath + "us_cities" + TextAnalysis.WORD_LIST_EXTENSION);
    URL latin = new URL(baseResourcePath + "latin" + TextAnalysis.WORD_LIST_EXTENSION);
    URL spanish = new URL(baseResourcePath + "spanish" + TextAnalysis.WORD_LIST_EXTENSION);

    Collection<PatternFinder> finders = buildDictionaryFinders("English", engWords.openStream());
    finders.addAll(buildDictionaryFinders("Common", commonEngWords.openStream()));
    finders.addAll(buildDictionaryFinders("US Cities", uscities.openStream()));
    finders.addAll(buildDictionaryFinders("Latin", latin.openStream()));
    finders.addAll(buildDictionaryFinders("Spanish", spanish.openStream()));
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
  public static Collection<PatternFinder> buildDictionaryFinders(String name, InputStream in) throws IOException {
    List<PatternFinder> finders = new LinkedList<PatternFinder>();

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
