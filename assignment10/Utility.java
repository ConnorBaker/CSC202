/*
*  Package Name: assignment10
*  File Name: Utility.java
*
*  Author: Connor Baker
*  Version: 0.1a
*  Created: December 2, 2016
*  Last Updated: December 2, 2016
*/

// Declare package  name
package assignment10;

// Import necessary package(s)
import java.io.BufferedReader;
public class Utility {
  // Create our shared variables
  static  int lengthOfInput;
  static  String input;

  public void getInput() {
    // Create a BufferedReader to grab user input
    BufferedReader br = new BufferedReader(System.in);

    // Store captured user input as a String
    input = br.readLine();

    // Close our BufferedReader
    br.close();
  }

  public void getLengthOfInput(String s) {
    // Get the length of a String
    lengthOfInput = input.length();
  }

}
