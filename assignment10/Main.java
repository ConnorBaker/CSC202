/*
*  Package Name: assignment10
*  File Name: Main.java
*
*  Author: Connor Baker
*  Version: 0.2b
*  Created: December 2, 2016
*  Last Updated: December 5, 2016
*/

// Declare package  name
package assignment10;

// Import necessary package(s)
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    // Get user input
    String input = InputUtility.getInput();

    // Print output back to the user
    System.out.println("You inputted: "+input);

    // Make the new stack array
    newStackArray(input);

    // Make the new singly linked list
    newSinglyLinkedList(input);

    // Make the new doubly linked list
    newDoublyLinkedList(input);
  }

  public static void newStackArray(String input) {
    // Create a new StackArray object
    StackArray newStackArray = new StackArray(input);

    // Fill the new StackArray object
    newStackArray.getStackOfChars();

    // Print the new stack
    System.out.println("The stack array returns: ");
    newStackArray.printStackOfChars();
  }

  public static void newSinglyLinkedList(String input) {
    // Create a new SinglyLinkedList
    SinglyLinkedList newSinglyLinkedList = new SinglyLinkedList(input);

    // Fill the new linked list
    for (int i = 0; i < input.length(); i++) {
      newSinglyLinkedList.add(input.charAt(i));
    }

    // Print the new linked list
    System.out.println("The singly linked list returns: ");
    newSinglyLinkedList.print();
  }

  public static void newDoublyLinkedList(String input) {
    // Create a new SinglyLinkedList
    DoublyLinkedList newDoublyLinkedList = new DoublyLinkedList(input);

    // Fill the new linked list
    for (int i = 0; i < input.length(); i++) {
      newDoublyLinkedList.add(input.charAt(i));
    }

    // Print the new linked list
    System.out.println("The doubly linked list returns: ");
    newDoublyLinkedList.print();
  }
}
