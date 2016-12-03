/*
*  Package Name: assignment10
*  File Name: Utility.java
*
*  Author: Connor Baker
*  Version: 0.1b
*  Created: December 2, 2016
*  Last Updated: December 2, 2016
*/

// Declare package  name
package assignment10;

// Import necessary package(s)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Utility {
  // Create our shared variables
  static int capacityOfStack;
  static String input;

  public void getInput() throws IOException {
    // Create a BufferedReader to grab user input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Store captured user input as a String
    input = br.readLine();

    // Close our BufferedReader
    br.close();

    // Debugging
    System.out.println("Debugging: input was "+input);
  }

  public void getLengthOfInput() {
    // Get the length of a String
    capacityOfStack = input.length();

    // Debugging
    System.out.println("Debugging: capacityOfStack is "+capacityOfStack);
  }

}
