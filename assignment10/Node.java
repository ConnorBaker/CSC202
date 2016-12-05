/*
*  Package Name: assignment10
*  File Name: Node.java
*
*  Author: Connor Baker
*  Version: 0.2b
*  Created: December 3, 2016
*  Last Updated: December 5, 2016
*/

// Declare package  name
package assignment10;

// Import necessary package(s)

public class Node {
  char element;
  Node next;

  Node() {
    this('\0', null);
  }

  Node(char element) {
    this(element, null);
  }

  Node(char element, Node next) {
    this.element = element;
    this.next = next;
  }

  public void setNext(Node next) {
    this.next = next;
  }


  public Node getNext() {
    return next;
  }


  public void setChar(char element) {
    this.element = element;
  }


  public char getChar() {
    return element;
  }
}
