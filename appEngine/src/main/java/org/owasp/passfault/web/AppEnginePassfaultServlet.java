package org.owasp.passfault.web;

import java.util.Collection;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.owasp.passfault.api.PasswordAnalysis;
import org.owasp.passfault.api.PasswordResults;
import org.owasp.passfault.api.PatternFinder;
import org.owasp.passfault.finders.ExecutorFinder;
import org.owasp.passfault.api.CompositeFinder;

/**
 * Servlet implementation class PassfaultServlet  This specialization of PassfaultServlet
 * exists to comply with the multi-threading rules of app-engine
 * @author cam
 */
public class AppEnginePassfaultServlet extends PassfaultServlet {
    public AppEnginePassfaultServlet() {
        super();
    }

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
    public void analyze(PasswordAnalysis pass)
      throws Exception
    {
      super.analyze(pass);
      super.shutdown();  
    }

    @Override
    public Future<PasswordAnalysis> analyzeFuture(PasswordAnalysis pass) 
    {
      Future<PasswordAnalysis> result = super.analyzeFuture(pass);
      super.shutdown();
      return result;
    }
  }
}

