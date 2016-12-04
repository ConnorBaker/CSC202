/*
*  Package Name: assignment10
*  File Name: Main.java
*
*  Author: Connor Baker
*  Version: 0.1e
*  Created: December 2, 2016
*  Last Updated: December 4, 2016
*/

// Declare package  name
package assignment10;

// Import necessary package(s)
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    // Get user input
    String input = InputUtility.getInput();

    // Create a new StackArray object
    StackArray newStackArray = new StackArray(input);

    // Fill the new StackArray object
    newStackArray.getStackOfChars();
    newStackArray.printStackOfChars();

    // Create a new SinglyLinkedList
    SinglyLinkedList<Character> newSinglyLinkedList = new SinglyLinkedList<>(input);
    newSinglyLinkedList.getSinglyLinkedListOfChars();

  }
}
