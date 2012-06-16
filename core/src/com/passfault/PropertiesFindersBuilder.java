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

import com.passfault.dictionary.*;
import com.passfault.keyboard.EnglishKeyBoard;
import com.passfault.keyboard.KeySequenceFinder;
import com.passfault.keyboard.RussianKeyBoard;
import java.io.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

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
