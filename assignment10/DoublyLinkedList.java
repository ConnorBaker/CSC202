/*
*  Package Name: assignment10
*  File Name: DoublyLinkedList.java
*
*  Author: Connor Baker
*  Version: 0.2b
*  Created: December 3, 2016
*  Last Updated: December 5, 2016
*/

// Declare package  name
package assignment10;

// Import necessary package(s)
import java.io.IOException;

public class DoublyLinkedList {
  // Declare our variables used in the class
  String input;
  DoublyNode head, tail;
  int size;

  DoublyLinkedList() throws IOException {
    head = null;
    tail = null;
    size = 0;
    input = InputUtility.getInput();
  }

  DoublyLinkedList(String input) {
    head = null;
    tail = null;
    size = 0;
    this.input = input;
  }

  public void add(char element) {
    // Check if this is the first node to be created
    if (head == null) {
      head = new DoublyNode(element);
    }

    // Create a temporary node to hold the new element
    DoublyNode tempDoublyNode = new DoublyNode(element);
    DoublyNode currentDoublyNode = head;

    // Condition to halt the method
    if (currentDoublyNode == null) {
      System.out.println("ERROR: currentDoublyNode is null");
      return;
    }

    // Go to the end of the linked list and add the element
    while (currentDoublyNode.getNext() != null) {
      currentDoublyNode = currentDoublyNode.getNext();
    }

    // Set the last node's next to the new node
    currentDoublyNode.setNext(tempDoublyNode);

    // Increment the size of our linked list
    size++;
  }

  public void print() {
    if (head == null) {
      System.out.println("List is empty");
    }

    // Create a temporary node to traverse the list
    DoublyNode currentDoublyNode = head;

    // Condition to halt the method
    if (currentDoublyNode == null) {
      System.out.println("ERROR: currentDoublyNode is null");
      return;
    }

    // Iterate through the list, printing the contents of the node
    while (currentDoublyNode.getNext() != null) {
      currentDoublyNode = currentDoublyNode.getNext();
      System.out.print(currentDoublyNode.element);
    }
    // Add padding for console output
    System.out.println();
  }

  public void printInReverse(DoublyNode n) {
    if (n.previous != head) {
      printInReverse(n.previous);
    }
    System.out.print(n.element);
  }

  public void print(int index) {
    if (head == null) {
      System.out.println("List is empty");
    }

    // Create a temporary node to traverse the list
    DoublyNode currentDoublyNode = head;
    int i = 0;

    // Condition to halt the method
    if (currentDoublyNode == null) {
      System.out.println("ERROR: currentDoublyNode is null");
      return;
    }

    // Iterate through the list, printing the contents of the node
    while ((currentDoublyNode.getNext() != null) && (i < index)) {
      currentDoublyNode = currentDoublyNode.getNext();
      System.out.print(currentDoublyNode.element);
      i++;
    }
    // Add padding for console output
    System.out.println();
  }
}
