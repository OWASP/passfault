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

/**
 * StrategyContext is an interface defining the context or state that a strategy
 * will store on a candidate pattern.
 * @author cam
 */
//todo: remove Cloneable
public interface StrategyContext {

  StrategyContext copy();

  String getDescription();

  /**
   * Each dictionary word pattern size is the number of words in the dictionary.
   * Other dictionary based patterns will multiply number of words by the
   * crackSizeFactor to calculate the overall pattern size.
   * @return
   */
  int getCrackSizeFactor();
}
