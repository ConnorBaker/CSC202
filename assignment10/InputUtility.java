/*
*  Package Name: assignment10
*  File Name: InputUtility.java
*
*  Author: Connor Baker
*  Version: 0.1b
*  Created: December 3, 2016
*  Last Updated: December 3, 2016
*/

// Declare package  name
package assignment10;

// Import necessary package(s)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class InputUtility {
  public static String getInput() throws IOException {
    // Create a BufferedReader to grab user input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Store captured user input as a String
    String input = br.readLine();

    // Close our BufferedReader
    br.close();

    // Debugging
    // System.out.println("Debugging: input was "+input);

    // Return the input
    return input;
  }

  public static int getLengthOfInput(String s) {
    // Get the length of a String
    int capacityOfStack = s.length();

    // Debugging
    // System.out.println("Debugging: capacityOfStack is "+capacityOfStack);

    // Return the length of the input
    return capacityOfStack;
  }

}
