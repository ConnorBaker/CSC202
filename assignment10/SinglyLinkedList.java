/*
*  Package Name: assignment10
*  File Name: SinglyLinkedList.java
*
*  Author: Connor Baker
*  Version: 0.2c
*  Created: December 3, 2016
*  Last Updated: December 5, 2016
*/

// Declare package  name
package assignment10;

// Import necessary package(s)
import java.io.IOException;

public class SinglyLinkedList {
  // Declare our variables used in the class
  String input;
  Node head, tail;
  int size;

  SinglyLinkedList() throws IOException {
    head = null;
    tail = null;
    size = 0;
    input = InputUtility.getInput();
  }

  SinglyLinkedList(String input) {
    head = null;
    tail = null;
    size = 0;
    this.input = input;
  }

  public void add(char element) {
    // Check if this is the first node to be created
    if (head == null) {
      head = new Node(element);
    }

    // Create a temporary node to hold the new element
    Node tempNode = new Node(element);
    Node currentNode = head;

    // Condition to halt the method
    if (currentNode == null) {
      System.out.println("ERROR: currentNode is null");
      return;
    }

    // Go to the end of the linked list and add the element
    while (currentNode.getNext() != null) {
      currentNode = currentNode.getNext();
    }

    // Set the last node's next to the new node
    currentNode.setNext(tempNode);

    // Increment the size of our linked list
    size++;
  }

  public void print() {
    if (head == null) {
      System.out.println("List is empty");
    }

    // Create a temporary node to traverse the list
    Node currentNode = head;

    // Condition to halt the method
    if (currentNode == null) {
      System.out.println("ERROR: currentNode is null");
      return;
    }

    // Iterate through the list, printing the contents of the node
    while (currentNode.getNext() != null) {
      currentNode = currentNode.getNext();
      System.out.print(currentNode.element);
    }
    // Add padding for console output
    System.out.println();
  }

  public void printInReverse(Node n) {
    if (n.next != null) {
      printInReverse(n.next);
    }
    System.out.print(n.element);
  }

  public void print(int index) {
    if (head == null) {
      System.out.println("List is empty");
    }

    // Create a temporary node to traverse the list
    Node currentNode = head;
    int i = 0;

    // Condition to halt the method
    if (currentNode == null) {
      System.out.println("ERROR: currentNode is null");
      return;
    }

    // Iterate through the list, printing the contents of the node
    while ((currentNode.getNext() != null) && (i < index)) {
      currentNode = currentNode.getNext();
      System.out.print(currentNode.element);
      i++;
    }
    // Add padding for console output
    System.out.println();
  }

}
