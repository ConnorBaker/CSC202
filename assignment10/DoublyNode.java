/*
*  Package Name: assignment10
*  File Name: DoublyNode.java
*
*  Author: Connor Baker
*  Version: 0.1a
*  Created: December 5, 2016
*  Last Updated: December 5, 2016
*/

// Declare package  name
package assignment10;

// Import necessary package(s)

public class DoublyNode {
  DoublyNode next;
  DoublyNode previous;
  char element;

  DoublyNode() {
    this('\0', null, null);
  }

  DoublyNode(char element) {
    this(element, null, null);
  }

  DoublyNode(char element, DoublyNode previous, DoublyNode next) {
    this.element = element;
    this.previous = previous;
    this.next = next;
  }

  public void setPrevious(DoublyNode previous) {
    this.previous = previous;
  }

  public void setNext(DoublyNode next) {
    this.next = next;
  }

  public DoublyNode getPrevious() {
    return previous;
  }

  public DoublyNode getNext() {
    return next;
  }

  public void setChar(char element) {
    this.element = element;
  }

  public char getChar() {
    return element;
  }
}
