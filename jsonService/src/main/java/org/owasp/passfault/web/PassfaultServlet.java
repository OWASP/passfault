package org.owasp.passfault.web;

import org.owasp.passfault.api.*;
import org.owasp.passfault.finders.RepeatingPatternDecorator;
import org.owasp.passfault.finders.SequentialFinder;
import org.owasp.passfault.impl.FilteringPatternCollectionFactory;
import org.owasp.passfault.impl.PatternsAnalyzerImpl;
import org.owasp.passfault.impl.SecureString;
import org.owasp.passfault.finders.ResponseOptimizedFinders;
import org.owasp.passfault.io.JsonWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Collection;

/**
 * Servlet implementation class PassfaultServlet
 */
public class PassfaultServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final int MAX_PASSWORD_SIZE = 50;
  protected Collection<PatternFinder> finders;
  private volatile CompositeFinder compositeFinder = null; //lazy initialized
  private JsonWriter jsonWriter = new JsonWriter();
  private PatternsAnalyzer analyzer = new RepeatingPatternDecorator(new PatternsAnalyzerImpl());
  private PatternCollectionFactory patternCollectionFactory = new FilteringPatternCollectionFactory();


  public void init(ServletConfig config) throws ServletException {
    finders = buildFinders(config.getServletContext());
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (request.getContentLength() <= 0) {
      response.sendError(HttpServletResponse.SC_NO_CONTENT, "No password was supplied");
      return;
    }

    if (request.getContentLength() > MAX_PASSWORD_SIZE) {
      response.sendError(HttpServletResponse.SC_REQUEST_URI_TOO_LONG, "Password length limited to " + MAX_PASSWORD_SIZE);
      return;
    }

    //SecureString password = getPassword(request.getReader(), request.getContentLength());
    //the above works in tomcat but not jetty or google app engine
    //the below works in jetty and google app engine but not tomcat
    SecureString password = getPassword(request.getInputStream(), request.getContentLength());

    CompositeFinder finder = getCompositeFinder();
    try {
      PatternCollection patterns = finder.search(password);
      AnalysisResult analysis = analyzer.calculateHighestProbablePatterns(patterns);
      writeJSON(analysis, response.getWriter());
    } catch (Exception e) {
      response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      throw new ServletException(e);
    } finally {
      password.clear();
    }
  }

  protected SecureString getPassword(BufferedReader reader, int length) throws IOException, ServletException {
    //multibyte characters will result in fewer characters than length, so length is the max
    char[] charArray = new char[length];
    CharBuffer chars = CharBuffer.wrap(charArray);
    int charsRead = reader.read(chars);
    SecureString password = new SecureString(charArray, 0, charsRead);
    Arrays.fill(charArray, '0');
    return password;
  }

  protected SecureString getPassword(InputStream in, int length) throws IOException, ServletException {
    return getPassword(new BufferedReader(new InputStreamReader(in, "UTF-8")), length);
  }

  protected Collection<PatternFinder> buildFinders(ServletContext servletContext) throws ServletException {
    try {
      BuildFinders builder = new BuildFinders();
      return builder.build(servletContext);
    } catch (IOException e) {
      throw new ServletException("An error occurred building the pattern finders", e);
    }
  }

  private void writeJSON(AnalysisResult analysis, PrintWriter writer) throws IOException {
    jsonWriter.write(writer, analysis);
  }

  /**
   * Override this to change the finder, (such as to run in google app engine)
   *
   * @return a composite finder that can run finders
   */
  protected CompositeFinder getCompositeFinder() throws ServletException {
    //subclasses may need to create this with each request - like for google app engine.
    //so we lazily initialize this
    //http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
    if (this.compositeFinder == null) {
      synchronized (this) {
        if (this.compositeFinder == null) {
          this.compositeFinder = new ResponseOptimizedFinders(finders, patternCollectionFactory);
        }
      }
    }

    return this.compositeFinder;
  }
}
