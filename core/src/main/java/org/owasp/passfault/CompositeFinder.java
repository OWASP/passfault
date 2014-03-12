package org.owasp.passfault;


public interface CompositeFinder extends PatternFinder
{

  public abstract void blockingAnalyze(PasswordResults pass)
    throws Exception;

  public abstract void waitForAnalysis(PasswordResults pass)
    throws Exception;

}