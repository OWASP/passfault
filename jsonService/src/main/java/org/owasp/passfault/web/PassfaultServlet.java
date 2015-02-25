package org.owasp.passfault.web;

import org.owasp.passfault.CompositeFinder;
import org.owasp.passfault.PasswordAnalysis;
import org.owasp.passfault.PatternFinder;
import org.owasp.passfault.SecureString;
import org.owasp.passfault.finders.ExecutorFinder;
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
	protected Collection<PatternFinder> finders;
	private volatile CompositeFinder compositeFinder = null; //lazy initialized
	private JsonWriter jsonWriter = new JsonWriter();

	public void init(ServletConfig config) throws ServletException {
	  finders = buildFinders(config.getServletContext());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getContentLength()<=0){
			response.sendError(HttpServletResponse.SC_NO_CONTENT, "No password was supplied");
		}

		//SecureString password = getPassword(request.getReader(), request.getContentLength());
		//the above works in tomcat but not jetty or google app engine
		//the below works in jetty and google app engine but not tomcat
		SecureString password = getPassword(request.getInputStream(), request.getContentLength());

    CompositeFinder finder = getCompositeFinder();
		try{
			PasswordAnalysis analysis = new PasswordAnalysis(password);
			try {
        finder.blockingAnalyze(analysis);
			} catch (Exception e) {
				throw new ServletException(e);
			}
			writeJSON(analysis, response.getWriter());
		} finally{
			password.clear();
			response.getWriter().flush();
		}
	}

	/**
	 * @throws ServletException if a non-printable character is found
	 */
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
    InputStreamReader reader = new InputStreamReader(in, "UTF-8");
    return getPassword(new BufferedReader(reader), length);
	}
	
	protected Collection<PatternFinder> buildFinders(ServletContext servletContext) throws ServletException {
	  try {
	    BuildFinders builder = new BuildFinders();
	    return builder.build(servletContext);
    }
    catch (IOException e) {
      throw new ServletException("An error occurred building the pattern finders", e);
    }
  }
	
	private void writeJSON(PasswordAnalysis analysis, PrintWriter writer) throws IOException {
    jsonWriter.write(writer, analysis.calculateHighestProbablePatterns());
  }
	
	/**
	 * Override this to change the finder, (such as to run in google app engine)
	 * @return a composite finder that can run finders
	 * @throws ServletException
	 */
	protected CompositeFinder getCompositeFinder() throws ServletException {
	  //subclasses may need to create this with each request - like for google app engine.  
	  //so we lazy initialize this
	  //http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
	  if (this.compositeFinder == null) {
	    synchronized(this) {
	      if (this.compositeFinder == null){
	        this.compositeFinder = new ExecutorFinder(finders);
	      }
	    }
	  }
	  
	  return this.compositeFinder;
	}
}
