/* ©Copyright 2011 Cameron Morris
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.owasp.passfault.dictionary;

import java.util.LinkedList;
import java.util.List;

import org.owasp.passfault.RandomPattern;

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
