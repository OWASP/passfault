/* ©Copyright 2014 Cameron Morris */
package org.owasp.passfault.finders;

import org.owasp.passfault.PasswordPattern;
import org.owasp.passfault.api.PatternCollection;
import org.owasp.passfault.api.PatternFinder;
import org.owasp.passfault.RandomPattern;
import org.owasp.passfault.RandomPattern.RandomClasses;
/**
 * This class seems to contradict the RandomPattern class.  RandomPattern takes any characters 
 * between found finders and calculates the random value.  It doesn't look for finders, instead it calculates
 * the size of the characters-sets used.  So, for example, 1234#$%^ will be evaluated as 8 random characters 
 * from the numbers and letters.  Instead it should be 4 digits and four letters, since this is easier to crack.
 * So this pattern finder will look for sequences of numbers and special chars that are greater than the threshold
 * (with a default of three).
 * 
 * One down-side of this pattern finder is it reports lots of finders.  Each subset as large as the threshold will be
 * reported.
 * 
 * See the RandomClassesFinderTest for examples.
 * 
 * @author cam
 */
public class RandomClassesFinder implements PatternFinder
{
  private final int threshold;
  
  public RandomClassesFinder(int threshold){
    this.threshold = threshold;
  }
  public RandomClassesFinder(){
    this(3);
  }
  
  @Override
  public PatternCollection search(CharSequence pass)
  {
    PatternCollection patterns = PatternCollection.getInstance(pass);
    CharSequence chars = pass;
    RandomClasses previousType = null;
    int typeCount = 0;
    for(int i=0, len = chars.length(); i<len; i++){
      char ch = chars.charAt(i);
      RandomClasses type = RandomClasses.getRandomClass(ch);
      if (type == previousType){
        typeCount++;
        reportPattern(patterns, i, typeCount, type);
      } else {
        typeCount = 1;
        previousType = type;
      }
    }
    return patterns;
  }

  private void reportPattern(PatternCollection patterns, int currentIndex, int countOfType, RandomClasses type)
  {
    if (countOfType >= threshold && (type == RandomClasses.Numbers || type == RandomClasses.SpecialChars) ){
      int start = (currentIndex+1)-countOfType;
      //report every sequence from the first type to the current index
      for(int i=start; i <= start + countOfType - threshold; i++){
        CharSequence chars = patterns.getPassword().subSequence(i, currentIndex+1);
        double size = Math.pow(type.getSize(),  countOfType);
        
        PasswordPattern pattern = new PasswordPattern(
            i, chars.length(), chars, size, 
            "Random Characters with:" + type.name(), RandomPattern.RANDOM_PATTERN, type.name());
        patterns.putPattern(pattern);
      }
    } 
  }
}
