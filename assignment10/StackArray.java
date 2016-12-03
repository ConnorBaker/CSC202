/*
*  Package Name: assignment10
*  File Name: StackArray.java
*
*  Author: Connor Baker
*  Version: 0.1a
*  Created: December 2, 2016
*  Last Updated: December 2, 2016
*/

// Declare package  name
package assignment10;

public class StackArray {
  // Declare our variables used in the class
  char[] stackOfChars;
  int top;

  StackArray() {
    top = -1;
    getInput();
    getLengthOfInput();
    getStackOfChars();
  }

  // Check if the stack is empty
  boolean isEmpty() {
    if (top = -1) {
      return true;
    } else {
      return false;
    }
  }

  // Check if the stack is full
  boolean isFull() {
    if (top = length) {
      return true;
    } else {
      return false;
    }
  }

}
