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

import java.io.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.owasp.passfault.dictionary.*;
import org.owasp.passfault.keyboard.EnglishKeyBoard;
import org.owasp.passfault.keyboard.KeySequenceFinder;
import org.owasp.passfault.keyboard.RussianKeyBoard;

/**
 * This class builds a set of pattern finders based on properties
 * @author cam
 */
public class PropertiesFindersBuilder {
  public static final String WORDLIST_DIRECTORY = "wordlist.rootDirectory";
  public static final String WORDLIST_IN_MEMORY = "wordlist.inMemory";
  public static final Boolean WORDLIST_IN_MEMORY_DEFAULT = true;
  public static final String WORD_LIST_EXTENSION = ".words";
  public static final String internalDictionary = "/com/passfault/dictionary/english" + WORD_LIST_EXTENSION;
   
  public Collection<PatternFinder> buildDictionaryFinders(Properties props) throws IOException{
    return buildDictionaryFinders(props, "");
  }
  
  public Collection<PatternFinder> buildDictionaryFinders(Properties props, String prefix) throws IOException{
    List<PatternFinder> finders = new LinkedList<PatternFinder>();
    if (!prefix.endsWith(".")){
      prefix = prefix+'.';
    }
    
    InputStream englishListStream = this.getClass().getResourceAsStream(internalDictionary);
    InMemoryDictionary builtInEnglish = InMemoryDictionary.newInstance(
        new InputStreamReader(englishListStream), false, "Common English");
    finders.addAll(buildDictionaryFinders(builtInEnglish));
    
    String dirName = props.getProperty(WORDLIST_DIRECTORY);
    if(dirName!= null){
      File dir = new File(dirName);
      if (dir.exists() && dir.isDirectory()){
        for(File wordlist: dir.listFiles()){
          //add all wordlists in this directory
          Dictionary diction = buildDictionary(wordlist);
          finders.addAll(buildDictionaryFinders(diction));
        }
      }
    }
    
    finders.add(new KeySequenceFinder(new EnglishKeyBoard()));
    finders.add(new KeySequenceFinder(new RussianKeyBoard()));
    finders.add(new DateFinder());
    return finders;
  }
  
  public Collection<PatternFinder> buildDictionaryFinders(Dictionary diction) throws IOException {
    List<PatternFinder> finders = new LinkedList<PatternFinder>();

    finders.add(new DictionaryPatternsFinder(diction, new ExactWordStrategy()));
    finders.add(new DictionaryPatternsFinder(diction, new MisspellingStrategy(1)));
    finders.add(new DictionaryPatternsFinder(diction, new AugmentationStrategy(2)));
    finders.add(new DictionaryPatternsFinder(diction, new SubstitutionStrategy(2)));
    finders.add(new DictionaryPatternsFinder(diction, new l337SubstitutionStrategy()));
    finders.add(new ReverseDictionaryPatternFinder(diction, new ExactWordStrategy()));
    
    return finders;
  }

  String getFileNameWithoutExtension(File wordlist) {
    String name = wordlist.getName();
    if(name.indexOf(".") != -1){
      name = name.split("\\.")[0];
    }
    return name;
  }

  private Dictionary buildDictionary(File file) {
    Reader dbWords = null;
    try {
      String name = getFileNameWithoutExtension(file);
      dbWords = new InputStreamReader(new FileInputStream(file));
      InMemoryDictionary diction = InMemoryDictionary.newInstance(dbWords, false, name);
      return diction;
    } catch (IOException ex) {
      Logger.getLogger(PropertiesFindersBuilder.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    } finally {
      try {
        dbWords.close();
      } catch (IOException ex) {
        Logger.getLogger(PropertiesFindersBuilder.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
