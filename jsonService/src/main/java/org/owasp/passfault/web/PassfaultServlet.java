package org.owasp.passfault.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.owasp.passfault.CompositeFinder;
import org.owasp.passfault.PatternFinder;
import org.owasp.passfault.PasswordAnalysis;
import org.owasp.passfault.SecureString;
import org.owasp.passfault.finders.ExecutorFinder;
import org.owasp.passfault.io.JsonWriter;

/**
 * Servlet implementation class PassfaultServlet
 */
public class PassfaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String PROTECTION_TYPE = "PROTECTION_TYPE";
	public static final String ATTACK_PROFILE = "ATTACK_PROFILE";
	protected Collection<PatternFinder> finders;
	private volatile CompositeFinder compositeFinder = null; //lazy initialized
	private JsonWriter jsonWriter = new JsonWriter();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassfaultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	  finders = buildFinders(config.getServletContext());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getContentLength()<=0){
			printUsage(response);
		}
		//SecureString password = getPassword(request.getReader(), request.getContentLength());
		//the above works in tomcat but not jetty or google app engine
		//the below works in jetty and google app engine but not tomcat
		SecureString password = getPassword(request.getInputStream(), request.getContentLength());
		CompositeFinder finder = getCompositeFinder();
		try{
			PasswordAnalysis analysis = new PasswordAnalysis(password);
			try {
				finder.analyze(analysis);
				finder.waitForAnalysis(analysis);
			} catch (Exception e) {
				// TODO LOG exception
				throw new ServletException(e); 
			}
			writeJSON(analysis, response.getWriter());
		} finally{
			password.clear();
			response.getWriter().flush();
		}
	}

	private void printUsage(HttpServletResponse response) {
		//todo
	}

	/**
	 * @throws ServletException if a non-printable character is found
	 */
	protected SecureString getPassword(BufferedReader reader, int length) throws IOException, ServletException {
		char[] chars = new char[length];
		int i;
		for(i=0; i<length; i++){
			char ch = (char) reader.read();
			if (Character.isISOControl(ch)){
				throw new ServletException("A non-printable character found in the supplied password.");
			} else {
				chars[i]=ch;
			}
		}
		if(i==0){
			throw new ServletException("No password found");
		}	
		SecureString password = new SecureString(chars, 0, i);
		Arrays.fill(chars, '0');
		return password;
	}
	
	/**
	 * @throws ServletException if a non-printable character is found
	 */
	protected SecureString getPassword(InputStream reader, int length) throws IOException, ServletException {
		char[] chars = new char[length];
		int i=0;
		while(reader.available()>0){
			char ch = (char)reader.read();
			if (Character.isISOControl(ch)){
				throw new ServletException("A non-printable character found in the supplied password.");
			} else {
				chars[i++]=ch;
			}
		}
		if(i==0){
			throw new ServletException("No password found");
		}	
		SecureString password = new SecureString(chars, 0, i);
		Arrays.fill(chars, '0');
		return password;
	}
	
	protected Collection<PatternFinder> buildFinders(ServletContext servletContext) throws ServletException {
	  try {
	    BuildFinders builder = new BuildFinders();
	    return builder.build(servletContext);
    }
    catch (IOException e) {
      throw new ServletException("An error occured building the pattern finders", e);
    }
  }
	
	private void writeJSON(PasswordAnalysis analysis, PrintWriter writer) throws IOException {
    jsonWriter.write(writer, analysis.calculateHighestProbablePatterns());
  }
	
	/**
	 * Override this to change the finder, (such as to run in google app engine)
	 * @param finders All finders to be run to analyze the password 
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
