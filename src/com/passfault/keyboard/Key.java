/* ©Copyright 2011 Cameron Morris
 *
 * This file is part of Passfault.
 *
 * Passfault is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Passfault is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Passfault.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.passfault.keyboard;

/**
 * This class represents an individual Key on a keyboard and contains it's
 * shift(upper) and non-shift(lower) character.  It also contains it's neighbors:
 * left,right,upper-left, lower-right, etc.
 *
 * @author cam
 */
class Key {
    char upper;
    char lower;
    Key left;
    Key right;
    Key upperLeft;
    Key upperRight;
    Key lowerLeft;
    Key lowerRight;
    
    static public enum Direction { UPPER_LEFT, UPPER_RIGHT, LEFT, SELF, RIGHT, LOWER_LEFT, LOWER_RIGHT                                                                                                                                };
    
    public Key next(Direction direction){
        switch (direction) {
            case UPPER_LEFT: return upperLeft;
            case UPPER_RIGHT: return upperRight;
            case LEFT: return left;
            case SELF: return this;
            case RIGHT: return right;
            case LOWER_LEFT: return lowerLeft;
            case LOWER_RIGHT: return lowerRight;
        }
        return null;
    }

    boolean match(Direction currentDirection, char c) {
        Key k = next(currentDirection);
        if (k!= null){
            return (k.lower == c || k.upper == c);
        }
        return false;
    }

    
    public Direction isSequence(char c){
        Direction direction=null;
        if (c == upper || c == lower){
            direction = Direction.SELF;
        } else if (left != null &&(c == left.upper || c == left.lower)){
            direction = Direction.LEFT;
        } else if (right != null &&(c == right.upper || c == right.lower)){
            direction = Direction.RIGHT;
        } else if (upperLeft != null &&(c == upperLeft.upper || c == upperLeft.lower)){
            direction = Direction.UPPER_LEFT;
        } else if (upperRight != null &&(c == upperRight.upper || c == upperRight.lower)){
            direction = Direction.UPPER_RIGHT;
        } else if (lowerLeft != null &&(c == lowerLeft.upper || c == lowerLeft.lower)){
            direction = Direction.LOWER_LEFT;
        } else if (lowerRight != null &&(c == lowerRight.upper || c == lowerRight.lower)){
            direction = Direction.LOWER_RIGHT;
        }
        return direction;
    }

}
