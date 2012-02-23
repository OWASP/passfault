/* ©Copyright 2011 Cameron Morris
 *
 * This file is part of Passfault.
 *
 * Passfault is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Passfault is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Passfault.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.passfault.dictionary;

import com.passfault.RandomPattern;
import java.util.LinkedList;
import java.util.List;

/**
 * AugmentationStrategy finds dictionary words that have been added to - augmented
 * with extra characters inserted in the word.  Extra characters are all non-alpha
 * characters.
 * @author cam
 */
public class AugmentationStrategy implements DictionaryStrategy {

  public final static String NAME = "INSERTION";

  @Override
  public String getName() {
    return NAME;
  }
  private int allowedExtraCharacters;

  /**
   * @param allowedDifferences number of different characters from a word;
   * Note that the more allowed differences means more consumed memory and more
   * search time.
   */
  public AugmentationStrategy(int allowedDifferences) {
    this.allowedExtraCharacters = allowedDifferences;
  }

  @Override
  public List<CandidatePattern> buildNextSubStrings(CandidatePattern subs, char c) {
    LinkedList<CandidatePattern> list = new LinkedList<CandidatePattern>();
    AugmentationContext context = subs.getDecorator(AugmentationContext.class);
    if (context!=null){
      context.currentChar = c;
    }
    if (!Character.isLetter(c)) {
      if (context == null) {//haven't found any insertions yet
        if (subs.getLength() > 0){ //it's not the beginning of the string
          context = new AugmentationContext();
          context.count = 1;
          context.currentChar = c;
          subs.addDecorator(AugmentationContext.class, context);
        }
      } else {
        context.count++;
      }
      CandidatePattern newsubs = (CandidatePattern) subs.copy();
      list.add(newsubs);
    } else {
      CandidatePattern newsubs = (CandidatePattern) subs.copy();
      newsubs.add(c);
      list.add(newsubs);
    }
    return list;
  }

  @Override
  public boolean isAdvanceable(CandidatePattern candidate) {
    AugmentationContext context = candidate.getDecorator(AugmentationContext.class);
    if (context == null) {
      return true;
    } else {
      return (context.count <= this.allowedExtraCharacters);
    }
  }

  @Override
  public void addContext(CandidatePattern cand, CharSequence password) {
    //Add add the context in the buildNextSubstrings
  }

  @Override
  public boolean isMatch(CandidatePattern candidate) {
    AugmentationContext context = candidate.getDecorator(AugmentationContext.class);
    if (context == null) {
      return false;
    } else {
      return (Character.isLetter(context.currentChar)) &&
          (context.count > 0) &&
          (context.count <= this.allowedExtraCharacters);
    }
  }

  private static class AugmentationContext implements StrategyContext {

    int count = 0;
    private char currentChar;

    @Override
    public String getDescription() {
      return "Augmentation";
    }

    @Override
    public int getCrackSizeFactor() {
      if (count == 0) {
        return 1;
      } else {
        return count * RandomPattern.RandomClasses.SpecialChars.getSize(); //todo add 1/chars in pattern
      }
    }

    @Override
    public StrategyContext copy() {
      AugmentationContext copy = new AugmentationContext();
      copy.count = this.count;
      copy.currentChar = this.currentChar;
      return copy;
    }
  }
}
