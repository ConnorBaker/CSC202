/*
*  Package Name: assignment10
*  File Name: Node.java
*
*  Author: Connor Baker
*  Version: 0.2c
*  Created: December 3, 2016
*  Last Updated: December 7, 2016
*/

// Declare package  name
package assignment10;

// Import necessary package(s)

public class Node {
  char element;
  Node next;

  // Default constructor calls the argumented constructor
  Node() {
    this('\0', null);
  }

  // Argumented constructor for the head
  Node(char element) {
    this(element, null);
  }

  // Argumented constructor for actual nodes
  Node(char element, Node next) {
    this.element = element;
    this.next = next;
  }

  // Set the link to the next node
  public void setNext(Node next) {
    this.next = next;
  }

  // Get the link to the next node
  public Node getNext() {
    return next;
  }

  // Set the character value of the node
  public void setChar(char element) {
    this.element = element;
  }

  // Get the character value of the node
  public char getChar() {
    return element;
  }
}
