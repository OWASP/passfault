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

package org.owasp.passfault;

import org.owasp.passfault.api.CompositeFinder;
import org.owasp.passfault.api.PatternCollectionFactory;
import org.owasp.passfault.api.PatternFinder;
import org.owasp.passfault.dictionary.*;
import org.owasp.passfault.finders.DateFinder;
import org.owasp.passfault.finders.ThroughputOptimizedFinder;
import org.owasp.passfault.impl.TestingPatternCollectionFactory;
import org.owasp.passfault.keyboard.EnglishKeyBoard;
import org.owasp.passfault.keyboard.KeySequenceFinder;
import org.owasp.passfault.keyboard.RussianKeyBoard;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class BuildFinders {

  /**
   * @deprecated
   */
  public static CompositeFinder build(String baseResourcePath) throws IOException {
    URL engWords = new URL(baseResourcePath + "english" + FileDictionary.WORD_LIST_EXTENSION);
    URL commonEngWords = new URL(baseResourcePath + "tiny-lower" + FileDictionary.WORD_LIST_EXTENSION);
    URL uscities = new URL(baseResourcePath + "us_cities" + FileDictionary.WORD_LIST_EXTENSION);
    URL latin = new URL(baseResourcePath + "latin" + FileDictionary.WORD_LIST_EXTENSION);
    URL spanish = new URL(baseResourcePath + "spanish" + FileDictionary.WORD_LIST_EXTENSION);

    Collection<PatternFinder> finders = buildDictionaryFinders("English", engWords.openStream());
    finders.addAll(buildDictionaryFinders("Common", commonEngWords.openStream()));
    finders.addAll(buildDictionaryFinders("US Cities", uscities.openStream()));
    finders.addAll(buildDictionaryFinders("Latin", latin.openStream()));
    finders.addAll(buildDictionaryFinders("Spanish", spanish.openStream()));
    finders.add(new KeySequenceFinder(new EnglishKeyBoard(), TestingPatternCollectionFactory.getInstance()));
    finders.add(new KeySequenceFinder(new RussianKeyBoard(), TestingPatternCollectionFactory.getInstance()));
    finders.add(new DateFinder(TestingPatternCollectionFactory.getInstance()));
    return new ThroughputOptimizedFinder(finders);
  }

  /**
   * @param in input stream
   * @return Collection of finders suitable to be wrapped up in a composite finder like ParallelFinder or ExecutorFinder
   * @throws IOException
   * @deprecated This is a good place to replace with some dependency injection
   */
  public static Collection<PatternFinder> buildDictionaryFinders(String name, InputStream in) throws IOException {
    List<PatternFinder> finders = new LinkedList<>();

    try {
      Reader dbWords = new InputStreamReader(in);
      PatternCollectionFactory factory = TestingPatternCollectionFactory.getInstance();
      //TODO find a better way to name the dictionaries
      InMemoryDictionary diction = InMemoryDictionary.newInstance(dbWords, false, name);
      finders.add(new DictionaryPatternsFinder(diction, new ExactWordStrategy(), factory));
      finders.add(new DictionaryPatternsFinder(diction, new MisspellingStrategy(1), factory));
      finders.add(new DictionaryPatternsFinder(diction, new InsertionStrategy(2), factory));
      finders.add(new DictionaryPatternsFinder(diction, new l337SubstitutionStrategy(), factory));
      finders.add(new ReversePatternDecoratorFinder(
          new DictionaryPatternsFinder(diction, new ExactWordStrategy(), factory)));

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
