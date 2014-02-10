/* ©Copyright 2014 Cameron Morris */
package org.owasp.passfault;

import org.owasp.passfault.RandomPattern.RandomClasses;
/**
 * This class seems to contradict the RandomPattern class.  RandomPattern takes any characters 
 * between found patterns and calculates the random value.  It doesn't look for patterns, instead it calculates 
 * the size of the characters-sets used.  So, for example, 1234#$%^ will be evaluated as 8 random characters 
 * from the numbers and letters.  Instead it should be 4 digits and four letters, since this is easier to crack.
 * So this pattern finder will look for sequences of numbers and special chars that are greater than the threshold
 * (with a default of three).
 * 
 * One down-side of this pattern finder is it reports lots of patterns.  Each subset as large as the threshold will be
 * reported.
 * 
 * See the RandomClassesFinderTest for examples.
 * 
 * @author cam
 */
public class RandomClassesFinder
  implements PatternFinder
{
  boolean isPreviousUpper = false;
  RandomPattern.RandomClasses previous = null;
  private final int threshold;
  
  public RandomClassesFinder(int threshold){
    this.threshold = threshold;
  }
  public RandomClassesFinder(){
    this(3);
  }
  
  @Override
  public void analyze(PasswordResults pass)
    throws Exception
  {
    CharSequence chars = pass.getCharSequence();
    RandomClasses previousType = null;
    int typeCount = 0;
    for(int i=0, len = chars.length(); i<len; i++){
      char ch = chars.charAt(i);
      RandomClasses type = RandomClasses.getRandomClass(ch);
      if (type == previousType){
        typeCount++;
        reportPattern(pass, i, typeCount, type);
      } else {
        typeCount = 1;
        previousType = type;
      }
    }
  }

  private void reportPattern(PasswordResults pass, int currentIndex, int countOfType, RandomClasses type)
  {
    if (countOfType >= threshold && (type == RandomClasses.Numbers || type == RandomClasses.SpecialChars) ){
      int start = (currentIndex+1)-countOfType;
      //report every sequence from the first type to the current index
      for(int i=start; i <= start + countOfType - threshold; i++){
        CharSequence chars = pass.getCharSequence().subSequence(i, currentIndex+1);
        double size = Math.pow(type.getSize(),  countOfType);
        
        PasswordPattern pattern = new PasswordPattern(
            i, countOfType, chars, size, 
            "Random Characters with:" + type.name(), RandomPattern.RANDOM_PATTERN, type.name());
        pass.foundPattern(pattern);
      }
    } 
  }
  
  @Override
  public void blockingAnalyze(PasswordResults pass)
    throws Exception
  {
    analyze(pass);
  }
  @Override
  public void waitForAnalysis(PasswordResults pass)
    throws Exception
  { 
    //no-op, it's already done since this finder always blocks
  }
}
