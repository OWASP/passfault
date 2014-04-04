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
import java.util.Properties;
import static org.junit.Assert.*;
import org.junit.*;
import org.owasp.passfault.*;
import org.owasp.passfault.dictionary.DictionaryPatternsFinder;
import org.owasp.passfault.dictionary.InMemoryDictionary;

/**
 *
 * @author cam
 */
public class PropertiesFindersBuilderTest {
  
  public static final String TEST_WORD_LIST_DIRECTORY = "test_words";
  private int FINDERS_PER_DICTIONARY = 6;
  
  public PropertiesFindersBuilderTest() {
  }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
    File dir = new File(TEST_WORD_LIST_DIRECTORY);
    if (dir.exists()){
      for(File file: dir.listFiles()){
        file.delete();
      }
      dir.delete();
    }
    
  }

  @Test
  public void testBuildDictionaryFinders_Properties_String() throws Exception {
    System.out.println("buildDictionaryFinders");
    Properties props = new Properties();
    props.put(PropertiesFindersBuilder.WORDLIST_DIRECTORY, TEST_WORD_LIST_DIRECTORY);
    String prefix = "";
    buildTestWordFile("wordlist1");
    buildTestWordFile("wordlist2");
    PropertiesFindersBuilder instance = new PropertiesFindersBuilder();
    
    Collection<PatternFinder> result = instance.buildDictionaryFinders(props, prefix);
    int count = 0;
    for(PatternFinder finder: result){
      if(finder instanceof DictionaryPatternsFinder){
        count ++;
      }
    }
    assertEquals(count, 3 * FINDERS_PER_DICTIONARY);
  }

  @Test
  public void testBuildDictionaryFinders_Dictionary() throws Exception {
    System.out.println("buildDictionaryFinders");
    InputStream englishListStream = this.getClass().getResourceAsStream(PropertiesFindersBuilder.internalDictionary);
    InMemoryDictionary builtInEnglish = InMemoryDictionary.newInstance(
        new InputStreamReader(englishListStream), false, "Common English");
    PropertiesFindersBuilder instance = new PropertiesFindersBuilder();
    Collection<PatternFinder> result = instance.buildDictionaryFinders(builtInEnglish);
    Assert.assertTrue(result.size()>1);
    
  }

  @Test
  public void testGetFileNameWithputExtension() {
    System.out.println("getFileNameWithputExtension");
    {
      File wordlist = new File("somefile.someextension");
      PropertiesFindersBuilder instance = new PropertiesFindersBuilder();
      String expResult = "somefile";
      String result = instance.getFileNameWithoutExtension(wordlist);
      assertEquals(expResult, result);
    }
    {
      File wordlist = new File("somefile");
      PropertiesFindersBuilder instance = new PropertiesFindersBuilder();
      String expResult = "somefile";
      String result = instance.getFileNameWithoutExtension(wordlist);
      assertEquals(expResult, result);
    }
    {
      File wordlist = new File("somefile.something.");
      PropertiesFindersBuilder instance = new PropertiesFindersBuilder();
      String expResult = "somefile";
      String result = instance.getFileNameWithoutExtension(wordlist);
      assertEquals(expResult, result);
    }
    {
      File wordlist = new File("somefile..something..");
      PropertiesFindersBuilder instance = new PropertiesFindersBuilder();
      String expResult = "somefile";
      String result = instance.getFileNameWithoutExtension(wordlist);
      assertEquals(expResult, result);
    }
  }

  private File buildTestDir() {
    File dir = new File(TEST_WORD_LIST_DIRECTORY);
    if(!dir.exists()){
      dir.mkdir();
    }
    return dir;
  }

  private void buildTestWordFile(String wordlistName) throws IOException {
    File file = buildTestDir();
    File wordlist = new File(file, wordlistName);
    FileWriter out = new FileWriter(wordlist);
    for(String word: new String[]{"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg"}){
      out.write(word);
      out.write("\n");
    }
    out.close();
  }
}
