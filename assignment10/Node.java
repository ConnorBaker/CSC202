/*
*  Package Name: assignment10
*  File Name: Node.java
*
*  Author: Connor Baker
*  Version: 0.1a
*  Created: December 3, 2016
*  Last Updated: December 3, 2016
*
*  Reference: http://crunchify.com/a-simple-singly-linked-list-implementation-in-java/
*             This tutorial helped give me insight into how to build a generic class.
*/

// Declare package  name
package assignment10;

// Import necessary package(s)

public class Node<V> {
  // Declare our variables used in the class
  V element;
  Node<V> next;

  public Node() {
    this(null, null);
  }

  public Node(V element, Node<V> next) {
    this.element = element;
    this.next = next;
  }

  public V getElement() {
    return element;
  }

  public Node<V> getNext() {
    return next;
  }

  public void setElement(V element) {
    this.element = element;
  }

  public void setNext(Node<V> next) {
    this.next = next;
  }

}
