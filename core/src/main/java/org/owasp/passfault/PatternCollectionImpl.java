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

package org.owasp.passfault;

import org.owasp.passfault.api.PatternCollection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.logging.Logger.getLogger;

/**
 * This class holds the results of the analysis of a password.  An instance
 * of this class begins with a password to search.  Then it is handed to
 * multiple PatternFinders.
 *
 * This class contains the logic for post-analysis of the finders found
 * (although this logic might be better if separated from this class)  This
 * logic includes finding the weakest combination of finders and locating
 * repeated finders.
 *
 * @author cam
 */
public class PatternCollectionImpl implements PatternCollection {

  private static final Logger log = getLogger(PatternCollectionImpl.class.getName());

  private CharSequence password;
  private Map<Integer, List<PasswordPattern>> foundPatterns = new HashMap<>();
  private RandomPattern randomPatternFinder = new RandomPattern();

  public PatternCollectionImpl(CharSequence password) {
    this.password = password;
  }

  @Override
  public List<PasswordPattern> getPatternsByIndex(int i) {
    return foundPatterns.get(i);
  }

  @Override
  public List<PasswordPattern> getAllPatterns() {
    return stream().collect(Collectors.toList());
  }

  @Override
  public Stream<PasswordPattern> stream() {
    return foundPatterns.values().stream().flatMap(List::stream);
  }

  @Override
  public CharSequence getPassword() {
    return password;
  }

  @Override
  public int getCount() {
    return (int) stream().count();
  }

  @Override
  public void addAll(PatternCollection toAdd) {
    //TODO compare passwords to make sure they are the same
    toAdd.stream().forEach( (PasswordPattern pattern) -> this.putPattern(pattern) );

  }

  /**
   * This method is called by pattern finders to store a newly discovered pattern
   * in a password.
   * @param patt pattern found in the password.
   */
  /*
   * Interesting things happen with random finders.  Some short finders can be
   * more complex than random finders.  Looking and testing all possible
   * combinations of random finders within a pattern is possible and was
   * experimented with.  However, having different classes of random (upper, lower,
   * numbers...) made it hard to determine if it was worthwhile.  The best solution
   * tried was to compare a newly found pattern to the random pattern of the same
   * sequence, and discard the pattern if random was better(smaller).
   */
  @Override
  synchronized public void putPattern(PasswordPattern patt) {
    log.log(Level.FINEST, "Found a pattern: matches {0} as a {1} pattern, size={2}", new Object[] {
        patt.getMatchString(), patt.getDescription(), patt.getCost()});

    PasswordPattern randomPattern = randomPatternFinder.getRandomPattern(password, patt.getStartIndex(), patt.getLength());
    if (patt.getCost() > randomPattern.getCost()) {
      //random is less expensive so throw away the pattern
      log.log(Level.FINER, "Pattern discarded because random is smaller: {0}", patt.getName());
      //patt = randomPattern;
      return;
    }
    List<PasswordPattern> patterns = getIndexSet(patt.getStartIndex());
    boolean worsePatternAlreadyFound = false;
    for (PasswordPattern passwordPattern : patterns) {
      if (patt.getLength() == passwordPattern.getLength()
          && patt.getCost() > passwordPattern.getCost()) {
        worsePatternAlreadyFound = true;
        log.log(Level.FINER, "discarding found pattern since a smaller pattern already exists: {0}", patt.getName());
      }
    }
    if (!worsePatternAlreadyFound) {
      patterns.add(patt);
    }
  }

  /**
   * This is a lazy loading getter for a list of finders that begin on the
   * index of the password.
   * @param startIndex index of the a character in a the password where the list
   * of finders begin.
   *
   * @return a List of finders found for the starting index of where a pattern
   * starts.
   */
  private List<PasswordPattern> getIndexSet(int startIndex) {
    if (!foundPatterns.containsKey(startIndex)) {
      foundPatterns.put(startIndex, new LinkedList<>());
    }
    return foundPatterns.get(startIndex);
  }
}
