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
