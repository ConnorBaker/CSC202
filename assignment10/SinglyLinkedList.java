/*
*  Package Name: assignment10
*  File Name: SinglyLinkedList.java
*
*  Author: Connor Baker
*  Version: 0.1c
*  Created: December 3, 2016
*  Last Updated: December 4, 2016
*
*  Reference: http://crunchify.com/a-simple-singly-linked-list-implementation-in-java/
*             This tutorial helped give me insight into how to build a generic class.
*/

// Declare package  name
package assignment10;

// Import necessary package(s)
import java.io.IOException;

public class SinglyLinkedList<V> {
  // Declare our variables used in the class
  Node<V> head, tail;
  int size;
  String input;

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


  public void addFirst(Node<V> Node) {
    if (tail == null) {
      tail = Node;
    }
    Node.setNext(head);
    head = Node;

    // Increment the size of our linked list
    size++;
  }

  public void addLast(Node<V> Node) {
    Node.setNext(null);
    tail.setNext(Node);
    tail = Node;

    // Increment the size of our linked list
    size++;
  }

  public void addAfter(Node<V> currentNode, Node<V> newNode) {
    if (currentNode == tail) {
      tail = newNode;
    }
    newNode.setNext(currentNode.getNext());
    currentNode.setNext(newNode);

    // Increment the size of our linked list
    size++;
  }

}
