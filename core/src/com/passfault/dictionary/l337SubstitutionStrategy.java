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


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * SubstitutionStrategy defines a matching strategy where letters in a word
 * can be substituted by a special character or number.  
 * @author cam
 */
public class l337SubstitutionStrategy implements DictionaryStrategy {

  public final static String NAME = "LEET";
  private final static Map<Character, Set<LeetChar>> leetList =
      new HashMap<Character, Set<LeetChar>>();

  static {
    //programmatically setup leetList
    String[][] abcs = new String[26][];
    abcs[0] = new String[]{"4", "@", "/-\\", "/\\", "^", "aye", "∂", "ci", "λ", "Z"};
    abcs[1] = new String[]{"8","|3","6","13","|3","ß","]3"};
    abcs[2] = new String[]{"(","<","¢","{","©","sea","see"};
    abcs[3] = new String[]{"|)","[)","∂","])","I>","|>","0","ð","cl"};
    abcs[4] = new String[]{"3","£","&","€","[-","ə"};
    abcs[5] = new String[]{"|=","]=","}","ph","(=","ʃ"};
    abcs[6] = new String[]{"6","9","&","(_+","C-","gee","jee","(γ,","cj"};
    abcs[7] = new String[]{"|-|","#","]-[","[-]",")-(","(-)",":-:","}{","}-{","#","aych"};
    abcs[8] = new String[]{"!","1","|","eye","3y3","ai","¡"};
    abcs[9] = new String[]{"|","_/","]","¿","</","_)","ʝ"};
    abcs[10] = new String[]{"X","|<","|X","|{","ɮ"};
    abcs[11] = new String[]{"1","7","|_","£","|","|_","lJ","¬"};
    abcs[12] = new String[]{"/\\/\\","|\\/|","em","|v|","[V]","^^","nn","//\\//\\","(V)","(\\/)","/|\\","/|/|",".\\","/^^\\","/V\\","|^^|"};
    abcs[13] = new String[]{"|\\|","/\\/","//\\\\//","[\\]","<\\>","{\\}","//","₪","[]\\[]","]\\[","~"};
    abcs[14] = new String[]{"0","()","oh","[]","¤","Ω"};
    abcs[15] = new String[]{"|*","|o","|º","|>","|\"","?","9","[]D","|7","q","þ","¶","℗","|D"};
    abcs[16] = new String[]{"0_","0,","(,)","<|","cue","9","¶"};
    abcs[17] = new String[]{"|2","2","/2","I2","|^","|~","lz","®","[z","|`","l2","Я",".-","ʁ"};
    abcs[18] = new String[]{"5","$","z","§","es"};
    abcs[19] = new String[]{"7","+","-|-","1","']['","†"};
    abcs[20] = new String[]{"|_|","(_)","Y3W","M","µ","[_]","\\_/","\\_\\","/_/"};
    abcs[21] = new String[]{"\\/","√","\\//"};
    abcs[22] = new String[]{"\\/\\/","vv","'//","\\\\'","\\^/","(n)","\\X/","\\|/","\\_|_/","\\\\//\\\\//","\\_:_/","]I[","UU","Ш","ɰ"};
    abcs[23] = new String[]{"%","><","Ж","}{","ecks","×","*",")(","ex"};
    abcs[24] = new String[]{"j","`/","`(","-/","'/","Ψ","φ","λ","Ч","¥"};
    abcs[25] = new String[]{"2","≥","~/_","%","ʒ","7_"};

    int alternativesSum = 0;
    for (int i=0; i<abcs.length; i++){

      alternativesSum += abcs[0].length;
      char ch = (char) ('a' + i);
      for(String subs: abcs[i]){
        char startChar = subs.charAt(0);
        Set<LeetChar> set = leetList.get(startChar);
        if (set == null){
          set = new HashSet<LeetChar>();
          leetList.put(startChar, set);
        }
        set.add(new LeetChar(ch, subs));
      }
    }
    averageAlternatives = alternativesSum/26;
  }
  private static final int averageAlternatives;


  @Override
  public String getName() {
    return NAME;
  }

  public l337SubstitutionStrategy() {}

  @Override
  public List<CandidatePattern> buildNextSubStrings(CandidatePattern subs, char c) {
    LinkedList<CandidatePattern> list = new LinkedList<CandidatePattern>();
    l337Context context = subs.getDecorator(l337Context.class);
    if (context == null) {
      context = new l337Context();
      subs.addDecorator(l337Context.class, context);
    }

    //if we are already looking to complete a leet sequence
    if (context.isIncompleteLeetSequence()){
      if (context.isMatch(c)){
        CandidatePattern newsubs = subs.copy();
        //add the candidate for the next round
        list.add(newsubs);

        //addvance the character in the context
        l337Context newContext = newsubs.getDecorator(l337Context.class);
        char candidateLeetChar = newContext.currentLeetChar.normalChar;
        newContext.nextChar(c);
        if (!newContext.isIncompleteLeetSequence()){
          //we found a completed leet sequence, add the substiture char
          newsubs.add(candidateLeetChar);
        }
      }
    } else if (leetList.containsKey(c)) {
        //if are not in a leet sequence but want to start one
        Set<LeetChar> sequences = leetList.get(c);
        for (LeetChar leetSequence: sequences) {
          CandidatePattern newsubs = subs.copy();
          l337Context newContext = newsubs.getDecorator(l337Context.class);
          newContext.setCurrentLeetCandidate(leetSequence);
          newContext.nextChar(c);

          if (!newContext.isIncompleteLeetSequence()){
            //we found a single character leet sequence, add the substiture char
            newsubs.add(leetSequence.normalChar);
          }
          list.add(newsubs);
        }
    }
    if (Character.isLetter(c)){
      //we need to clone the substring for the next generation, as it is possible it will be used externally
      CandidatePattern newsubs = (CandidatePattern) subs.copy();
      newsubs.add(c);
      list.add(newsubs);
    }
    return list;
  }

  @Override
  public boolean isAdvanceable(CandidatePattern candidate) {
    return true;
  }

  @Override
  public boolean isMatch(CandidatePattern candidate) {
    l337Context context = candidate.getDecorator(l337Context.class);
    if (context != null && context.isIncompleteLeetSequence()){
      //if we are still seeking to complete a leet sequence then it isn't a match (yet)
      return false;
    }
    return context.leetCount>0;
  }

  @Override
  public void addContext(CandidatePattern cand, CharSequence password) {
    //we will wait until we find a leet possible letter, it'll save memory and run faster
  }

  private static class l337Context implements StrategyContext {

    int index = 0;
    LeetChar currentLeetChar = null;
    int leetCount = 0;
    int extraCharsCount = 0;

    public boolean isIncompleteLeetSequence(){
      return currentLeetChar != null;
    }
    
    @Override
    public String getDescription() {
      return "'Elite' Substitution";
    }

    @Override
    public int getCrackSizeFactor() {
      return leetCount*averageAlternatives;
    }

    @Override
    public l337Context copy() {
      l337Context toReturn = new l337Context();
      toReturn.currentLeetChar = currentLeetChar;
      toReturn.extraCharsCount = extraCharsCount;
      toReturn.index = index;
      toReturn.leetCount = leetCount;
      return toReturn;
    }

    public void setCurrentLeetCandidate(LeetChar leetSequence) {
      this.currentLeetChar = leetSequence;
    }

    public void nextChar(char ch) {
      if(!isMatch(ch)){
        throw new IllegalArgumentException("Cannot advance character since they do not match");
      }
      index++;
      if (currentLeetChar.leetSequence.length() == index){
        index = 0;
        extraCharsCount += currentLeetChar.leetSequence.length()-1;
        currentLeetChar = null;
        leetCount++;
      }
    }

    public boolean isMatch(char c) {
      return c == currentLeetChar.leetSequence.charAt(index);
    }
  }

  private static class LeetChar {
    public final char normalChar;
    public final String leetSequence;
    public LeetChar(char ch, String subs) {
      normalChar = ch;
      leetSequence = subs;
    }
  }
}
