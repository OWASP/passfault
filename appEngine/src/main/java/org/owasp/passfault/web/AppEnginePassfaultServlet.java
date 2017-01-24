package org.owasp.passfault.web;

import org.owasp.passfault.api.CompositeFinder;
import org.owasp.passfault.api.PatternCollection;
import org.owasp.passfault.api.PatternFinder;
import org.owasp.passfault.finders.ResponseOptimizedFinders;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadFactory;

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
  public class AppEngineFinder extends ResponseOptimizedFinders {

    public AppEngineFinder(Collection<PatternFinder> finders, ThreadFactory factory)
    {
      super(finders, factory);
    }

    @Override
    public PatternCollection search(CharSequence pass)
    {
      PatternCollection result = super.search(pass);
      super.shutdown();
      return result;
    }

    @Override
    public CompletableFuture<PatternCollection> searchFuture(CharSequence pass)
    {
      CompletableFuture<PatternCollection> result = super.searchFuture(pass);
      super.shutdown();
      return result;
    }
  }
}

