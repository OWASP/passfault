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
package org.owasp.passfault.impl;

import org.owasp.passfault.api.PatternFinder;
import org.owasp.passfault.dictionary.Dictionary;
import org.owasp.passfault.dictionary.*;
import org.owasp.passfault.finders.DateFinder;
import org.owasp.passfault.finders.RandomClassesFinder;
import org.owasp.passfault.keyboard.EnglishKeyBoard;
import org.owasp.passfault.keyboard.KeySequenceFinder;
import org.owasp.passfault.keyboard.RussianKeyBoard;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

/**
 * This class builds a set of pattern finders based on properties.  It follows the convention of wordlists located
 * in the same location as a words.properties file
 *
 * The words.properties file can declare wordlist groups.  The most popular words start with 1:
 * words.english.1 = mostPopularEnglishWords.words
 * words.english.2 = lessPopularEnglishWords.words
 *
 * a dictionary from the second will have the size of the first and second.
 * @author cam
 */
public class FinderByPropsBuilder {
  private static final Logger LOG = java.util.logging.Logger.getLogger(FinderByPropsBuilder.class.getName());

  public static final String WORDLIST_CONFIG_PROPERTIES = "words.properties";
  public static final String WORDLIST_GROUP_PREFIX = "words.";
  public static final String WORDLIST_NAME = ".name";
  public static final String WORDLIST_FILENAME = ".file";
  public static final String DEFAULT_WORDLISTS_LOCATION = "/org/owasp/passfault/wordlists";

  private ResourceLoaderStrategy resourceLoader;
  private boolean isInMemory;

  public FinderByPropsBuilder(){
    this.isInMemory = false;
  }

  public FinderByPropsBuilder loadDefaultWordLists(){
    return setClassPathLoader(DEFAULT_WORDLISTS_LOCATION);
  }
  /**
   * @param loader custom loader for locating resources, useful for servlet contexts
   * @return builder for chaining method calls
   */
  public FinderByPropsBuilder setLoader(ResourceLoaderStrategy loader) {
    resourceLoader = loader;
    return this;
  }

  /**
   * @param rootDir parent directory for the words.properties and wordlists
   * @return builder for chaining method calls
   */
  public FinderByPropsBuilder setFileLoader(File rootDir){
    resourceLoader = new FileReaderStrategy(rootDir);
    return this;
  }

  /**
   * @param resourcePath path in the classpath to the properties file
   * @return builder of pattern finders
   */
  public FinderByPropsBuilder setClassPathLoader(String resourcePath) {
    resourceLoader = new SystemResourceReader(resourcePath);
    return this;
  }

  /**
   * @param isInMemory true of false for if the inMemory dictionaries are to be the default
   * @return builder for chaining method calls
   */
  public FinderByPropsBuilder isInMemory(boolean isInMemory){
    this.isInMemory = isInMemory;
    return this;
  }

  /**
   * This method assumes the resource location contains a words.properties describing other wordlists
   * defined at the same location
   * @return wordlist finders.
   * @throws IOException when the resources cannot be loaded
   */
  public Collection<PatternFinder> build() throws IOException {
    //looks for a words.properties in the parentDirectory.
    Reader in = resourceLoader.loadResource(WORDLIST_CONFIG_PROPERTIES);
    if (in == null) {
      throw new IllegalArgumentException("words.properties could not be identifies in the resource path");
    }

    Properties wordsConfig = new Properties();
    try {
      wordsConfig.load(in);
    } finally {
      in.close();
    }

    List<PatternFinder> finders = new LinkedList<PatternFinder>();
    Set<String> wordListGroups = getWordListGroups(wordsConfig);
    for(String group: wordListGroups){
      String groupName = wordsConfig.getProperty(group + WORDLIST_NAME, group);
      int runningTotal = 0, i=1;
      while (wordsConfig.containsKey(buildFileName(group, i))){
        String wordListName = wordsConfig.getProperty(buildFileName(group, i)); //for example: wordlist.english.1=english.words
        Dictionary dictionary = buildDictionary(groupName, wordListName);
        runningTotal += dictionary.getWordCount();
        dictionary.setWordCount(runningTotal);
        finders.addAll(buildDictionaryFinders(dictionary));
        i++;
      }
    }
    finders.addAll(buildStandardFinders());
    return finders;
  }

  private String buildFileName(String group, int i) {
    return WORDLIST_GROUP_PREFIX + group + "." + i + WORDLIST_FILENAME;
  }

  private Dictionary buildDictionary(String groupName, String wordListName) throws IOException {
    LOG.fine("building dictionaries from " + wordListName);
    Dictionary dictionary;
    if (isInMemory) {
      Reader reader = resourceLoader.loadResource(wordListName);
      if (reader == null){
        throw new IOException ("Could not resource: "+wordListName);
      }
      try {
        dictionary = InMemoryDictionary.newInstance(reader, false, groupName);
      } finally {
        reader.close();
      }
    } else {
      dictionary = FileDictionary.newInstance(resourceLoader.loadFile(wordListName), groupName);
    }
    return dictionary;
  }

  private Set<String> getWordListGroups(Properties wordsConfig) {
    Set<String> groups = new HashSet<String>();
    Enumeration<Object> keys = wordsConfig.keys();
    while (keys.hasMoreElements()){
      String key = (String) keys.nextElement();
      if (key.startsWith(WORDLIST_GROUP_PREFIX)){
        String withoutPrefix = key.substring(key.indexOf('.')+1);
        if (withoutPrefix.contains(".")) {
          String groupKey = withoutPrefix.substring(0, withoutPrefix.indexOf('.'));
          groups.add(groupKey);
        }
      }
    }
    return groups;
  }

  protected Collection<PatternFinder> buildStandardFinders(){
    Collection<PatternFinder> toReturn = new LinkedList<>();
    FilteringPatternCollectionFactory collectionFactory = new FilteringPatternCollectionFactory();
    toReturn.add(new KeySequenceFinder(new EnglishKeyBoard(), collectionFactory));
    toReturn.add(new KeySequenceFinder(new RussianKeyBoard(), collectionFactory));
    toReturn.add(new DateFinder(collectionFactory));
    toReturn.add(new RandomClassesFinder(3, collectionFactory));
    return toReturn;
  }
  
  protected Collection<PatternFinder> buildDictionaryFinders(Dictionary diction) throws IOException {
    List<PatternFinder> finders = new LinkedList<>();
    FilteringPatternCollectionFactory collectionFactory = new FilteringPatternCollectionFactory();

    DictionaryPatternsFinder exactFinder = new DictionaryPatternsFinder(diction, new ExactWordStrategy(), collectionFactory);
    finders.add(exactFinder);
    finders.add(new ReversePatternDecoratorFinder(exactFinder, collectionFactory));
    finders.add(new DictionaryPatternsFinder(diction, new MisspellingStrategy(1), collectionFactory));
    finders.add(new DictionaryPatternsFinder(diction, new InsertionStrategy(2), collectionFactory));
    finders.add(new DictionaryPatternsFinder(diction, new SubstitutionStrategy(2), collectionFactory));
    finders.add(new DictionaryPatternsFinder(diction, new l337SubstitutionStrategy(), collectionFactory));

    return finders;
  }

  String getFileNameWithoutExtension(File wordlist) {
    String name = wordlist.getName();
    if(name.contains(".")){
      name = name.split("\\.")[0];
    }
    return name;
  }

  //Strategy Classes
  public interface ResourceLoaderStrategy {
    Reader loadResource(String resource) throws IOException;
    File loadFile(String resource) throws IOException;
  }

  public static class FileReaderStrategy implements ResourceLoaderStrategy {
    private final File parentDir;

    public FileReaderStrategy (File parentDir){
      this.parentDir = parentDir;
    }
    @Override
    public Reader loadResource(String resource) throws IOException {
      return new FileReader(new File(parentDir, resource));
    }

    @Override
    public File loadFile(String resource) throws IOException {
      return new File(parentDir,resource);
    }
  }

  public static class SystemResourceReader implements ResourceLoaderStrategy {
    private final String parentPath;

    public SystemResourceReader(String parentPath) {
      this.parentPath = parentPath;
    }

    @Override
    public Reader loadResource(String resource) throws IOException {
      InputStream stream = getClass().getResourceAsStream(parentPath + "/" + resource);
      LOG.fine("attempt to load resource:" + parentPath + "/" + resource);
      if (stream == null) throw new IOException("could not load resource "+parentPath +"/"+resource);
      return new InputStreamReader(stream);
    }

    @Override
    public File loadFile(String resource) throws IOException {
      throw new IOException("Cannot open resources that are in a jar zip, these must be loaded in as InMemory dictionaries");
    }
  }
}
