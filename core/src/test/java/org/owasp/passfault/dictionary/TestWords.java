package org.owasp.passfault.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;

public class TestWords {
  public static File getTestFile() throws URISyntaxException {
    URL url = TestWords.class.getResource("/tiny-lower.words");
    java.util.logging.Logger.getGlobal().info("Test URL " + url.toString());
    return new File(url.toURI());
  }

  public static Reader getTestReader() throws FileNotFoundException, URISyntaxException {
    URL url = TestWords.class.getResource("/tiny-lower.words");
    java.util.logging.Logger.getGlobal().info("Test URL " + url.toString());
    return new FileReader(new File(url.toURI()));
  }
}
