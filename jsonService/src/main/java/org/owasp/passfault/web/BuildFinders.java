package org.owasp.passfault.web;

import java.io.*;
import java.util.Collection;
import java.util.Set;

import javax.servlet.ServletContext;

import org.owasp.passfault.FinderByPropsBuilder;
import org.owasp.passfault.PatternFinder;

/**
 * This builds finders for analyzing passwords.  It could be extended to add additional custom word lists
 * @author cam
 */
public class BuildFinders {
  public Collection<PatternFinder> build(ServletContext servletContext) throws IOException {

	  //ServletResourceResolver resolver = new ServletResourceResolver(servletContext, dictionariesPath);
    //Collection<PatternFinder> finders = new FinderByPropsBuilder().setLoader(resolver).isInMemory(true).build();
    Collection<PatternFinder> finders = new FinderByPropsBuilder().
        loadDefaultWordLists().
        isInMemory(true).
        build();
	  return finders;
  }

  /**
   * The wordlists got moved into the core library.  This class class can be used to help load word lists
   * inside of the WEB-INF directory for custom wordlists
   */
  private static class ServletResourceResolver implements FinderByPropsBuilder.ResourceLoaderStrategy{
    private final ServletContext context;
    private final String rootDir;

    public ServletResourceResolver(ServletContext context, String rootDir){
      this.context = context;
      this.rootDir = rootDir;
    }

    @Override
    public Reader loadResource(String resource) throws IOException {
      Set<String> paths = context.getResourcePaths(rootDir);

      InputStream is = context.getResourceAsStream(rootDir + "/" + resource);
      if (is == null) throw new IOException("Could not find resource: " + resource+ "; from these"+paths);
      return new InputStreamReader(is);
    }

    @Override
    public File loadFile(String resource) throws IOException {
      String realPath = context.getRealPath(rootDir + "/" + resource);
      if (realPath == null) throw new IOException("Could not find resource: " + resource);
      return new File(realPath);
    }
  }
}
