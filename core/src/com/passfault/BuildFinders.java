/* ©Copyright 2011 Cameron Morris
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
 * 
 * @author cam
 * @see PropertiesFindersBuilder
 */
public class BuildFinders {
  
  /**
   * @deprecated 
   */
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
   * @deprecated 
   * This is a good place to replace with some dependency injection
   * @param inputStreams
   * @return Collection of finders suitable to be wrapped up in a composite finder like ParallelFinder or ExecutorFinder
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
