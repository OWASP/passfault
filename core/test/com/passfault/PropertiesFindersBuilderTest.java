/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.passfault;

import com.passfault.dictionary.Dictionary;
import com.passfault.dictionary.DictionaryPatternsFinder;
import com.passfault.dictionary.InMemoryDictionary;
import java.io.*;
import java.util.Collection;
import java.util.Properties;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

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
