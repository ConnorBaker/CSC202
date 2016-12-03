/*
*  Package Name: assignment10
*  File Name: StackArray.java
*
*  Author: Connor Baker
*  Version: 0.2a
*  Created: December 2, 2016
*  Last Updated: December 2, 2016
*/

// Declare package  name
package assignment10;

// Import necessary package(s)
import java.io.IOException;
import java.util.EmptyStackException;

public class StackArray extends Utility {
  // Declare our variables used in the class
  char[] stackOfChars;
  int top;

  StackArray() throws IOException {
    top = 0;
    getInput();
    getLengthOfInput();
    getStackOfChars();
    printStackOfChars();
  }

  // Create a stack of characters
  public void getStackOfChars() {
    stackOfChars = new char[capacityOfStack];

    // Use push to put new itrems on top of the stack
    for (int i = 0; i < capacityOfStack; i++) {
      push(input.charAt(i));
    }
  }

  public void printStackOfChars() {
    for (int i = 0; i < capacityOfStack; i++) {
      System.out.print(stackOfChars[i]);
    }
    System.out.println();
  }

  public char peek() throws EmptyStackException {
    // Check if the stack is empty
    if (isEmpty()) {
      throw new EmptyStackException();
    }

    // Return the charcter
    return stackOfChars[top];
  }

  public char pop() throws EmptyStackException {
    // Check if the stack is empty
    if (isEmpty()) {
      throw new EmptyStackException();
    }

    // Make a copy of, and remove the current top of the stack from the stack
    char charToReturn = stackOfChars[top];
    stackOfChars[top] = '\0';
    top--;

    // Return the value that we just removed
    return charToReturn;
  }

  public void push(char charToPush) {
    // We don't need to check that the stack isn't full, that shouldn't happen
    // Push the passed char to the top of the stack

    // Debugging
    // System.out.println("Debugging: stackOfChars["+top+"] is "+stackOfChars[top]);

    stackOfChars[top] = charToPush;
    top++;

    // Debugging
    // System.out.println("Debugging: stackOfChars["+(top-1)+"] is "+stackOfChars[top-1]);
  }


  // Check if the stack is empty
  public boolean isEmpty() {
    if (top == 0) {
      return true;
    } else {
      return false;
    }
  }

  // Check if the stack is full
  public boolean isFull() {
    if (top == capacityOfStack) {
      return true;
    } else {
      return false;
    }
  }

}
