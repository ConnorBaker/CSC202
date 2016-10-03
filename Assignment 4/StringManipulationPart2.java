/*
*  Project name:
*  StringManipulationPart2.java
*
*  Author: Connor Baker
*  Version: 0.1a
*  Created: September 26, 2016
*  Last Updated: October 3, 2016
*
*  Summary of problem specification:
*  Using InputStreamReader, BufferedReader, and StringBuffer classes, create a
*  program that accepts user input in the form of a string, replaces every '$'
*  with a '#', deletes all other special characters (excluding whitespaces and
*  periods), changes the first letter of every word to uppercase, change the
*  first sentence of the text to all lowercase (excluding the first character
*  of the first word), inserts the author's name in uppercase at the end of the
*  last sentence, asks the user to enter a new (minimum of five word) input
*  which is added to the end of the string, and asks the user for their name,
*  to be compared to the author's name, outputting the result of the lengthwise
*  comparison. At every point in the processing, the program outputs the
*  current version of the string.
*
*  Functionality:
*  None currently.
*
*  Explanation of components:
*  None currently.
*
*  Assumptions made:
*  Java EA 9 didn't allow me to write anything that isn't backwards compliant
*  with the current version.
*
*  References used:
*  https://docs.oracle.com/javase/8/docs/
*  http://stackoverflow.com/questions/17629321/throwing-exception-in-main-method
*    (for how to use the keyword throws)
*/

// Import necessary packages
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class StringManipulationPart2 {
  // Initialize all of the object attributes
  StringBuffer inputstring; // User determined input
  StringBuffer inputstring2; // Second user determined input
  int inputstringlength; // Length of input
  int inputstring2length; // Length of input

  // Create an argumented constructor
  StringManipulation(StringBuffer passedstring) {
    inputstring = passedstring;
    // I used inputstring.length() enough that it actually warranted creating a variable to hold the length
    inputstringlength = inputstring.length();
  }

  // Method to calculate the number of dollar signs in a string
  public void replaceDollarSignsWithOctothorpes() {
    for (int i = 0; i < inputstringlength; i++) {
      // Starting at the index of the first dollar sign, look for more
      if (inputstring.charAt(i) == '$') {
        // implement swapping Functionality
        inputstring.replace("$");
      }
    }
    System.out.println(inputstring);
  }

  // Method to delete all speical characters except for octothorpes
  public void deleteAllOtherSpecialCharacters() {
    for (int i = inputstringlength; i > 0; i--) {
      // Starting at the index of the first dollar sign, look for more
      if ((!(Character.isLetterOrDigit(inputstring.charAt(i))) &&
          !(Character.isWhitespace(inputstring.charAt(i)))) && (inputstring.charAt(i) != '.')) {
        // implement swapping Functionality
        inputstring.deleteCharAt(i);
      }
    }
    System.out.println(inputstring);
  }
  }

  // Method to turn the first lowercase a into an uppercase one
  // Fix array out of bounds for i-1
  public void capitalizeFirstLetterOfEveryWord() {
    for (int i = 0; i < inputstringlength; i++) {
      if ((Character.isLetter(inputstring.charAt(i))) &&
          (Character.isWhitespace(inputstring.charAt(i-1)))) {
        Character.toUpperCase(inputstring.charAt(i));
      }
    }
    System.out.println(inputstring);
  }

  // Make it end at first period.
  public void lowercaseFirstLine() {
    for (int i = 0; i < inputstringlength; i++) {
      if ((Character.isLetter(inputstring.charAt(i))) && (Character.isWhitespace(inputstring.charAt(i-1)))) {
        Character.toUpperCase(inputstring.charAt(i));
      }
    }
    System.out.println(inputstring);
  }

  // Append author name in uppercase to end of file
  public void appendAuthorName() {
    inputstring.append("CONNOR BAKER");
    System.out.println(inputstring);
  }

  // Implement functionaity.
  // public void compareUserInput2() {
  //
  // }

  public static void main(String args[]) throws IOException { // begin main
    // Create readers to grab user input
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    // Prompt user for input
    System.out.println("Please input whatever followed by ENTER: ");
    StringBuffer userinput = new StringBuffer(br.readLine());

    // Print the user's input back out to them
    System.out.println("You just entered: \n" + userinput);

    // Create our object using the user's input
    StringManipulation newObject = new StringManipulation(userinput);

    // Print the object's important attributes

    // Print the processed string back out to the user
    System.out.println(userinput);
  } // end main
}
