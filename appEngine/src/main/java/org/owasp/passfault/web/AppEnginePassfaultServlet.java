package org.owasp.passfault.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ThreadFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.owasp.passfault.PasswordResults;
import org.owasp.passfault.PatternFinder;
import org.owasp.passfault.PasswordAnalysis;
import org.owasp.passfault.PathCost;
import org.owasp.passfault.SecureString;
import org.owasp.passfault.finders.ExecutorFinder;
import org.owasp.passfault.finders.SequentialFinder;
import org.owasp.passfault.io.JsonWriter;
import org.owasp.passfault.CompositeFinder;

/**
 * Servlet implementation class PassfaultServlet  This specialization of PassfaultServlet
 * exists to comply with the multi-threading rules of app-engine
 * @author cam
 */
public class AppEnginePassfaultServlet extends PassfaultServlet {
    public AppEnginePassfaultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
    super.init(config);
	}

  /**
   * This specialized method lets us specify how to handle multithreading
   */
  protected CompositeFinder getCompositeFinder() throws ServletException {
    return new AppEngineFinder(finders, com.google.appengine.api.ThreadManager.currentRequestThreadFactory());
  }
  
  /**
   * The finder must be request scoped - because of it's dependence on the "currentRequestThreadFactory"
   * so when analysis is done the executor needs to be shut down.  This class exists to call shutdown after
   * either blockingAnalyze or waitForAnalysis is completed. 
   */
  public class AppEngineFinder extends ExecutorFinder {

    public AppEngineFinder(Collection<PatternFinder> finders, ThreadFactory factory)
    {
      super(finders, factory);
    }

    @Override
    public void blockingAnalyze(PasswordResults pass)
      throws Exception
    {
      super.blockingAnalyze(pass);
      super.shutdown();  
    }

    @Override
    public void waitForAnalysis(PasswordResults pass)
      throws InterruptedException
    {
      // TODO Auto-generated method stub
      super.waitForAnalysis(pass);
      super.shutdown();
    }
    
    
    
  }
}

