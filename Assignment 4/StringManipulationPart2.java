/*
*  Project name: StringManipulationPart2.java
*
*  Author: Connor Baker
*  Version: 0.3a
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
*  Meets problem specification.
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
  StringBuffer inputstring3; // Third user determined input (their name)

  // Create an argumented constructor
  StringManipulationPart2(StringBuffer passedstring) {
    inputstring = passedstring;
  }

  // Swap all dollarsigns with octothorpes
  public void replaceDollarSignsWithOctothorpes() {
    System.out.println("Removing $ and replacing with #.");
    for (int i = 0; i < inputstring.length(); i++) {
      if (inputstring.charAt(i) == '$') {
        inputstring.replace(i, i+1,"#");
      }
    }
    System.out.println(inputstring);
  }

  // Method to delete all speical characters except for octothorpes, whitepsaces
  // and periods (which we use later).
  public void deleteAllOtherSpecialCharacters() {
    System.out.println("Deleting special characters except for periods,"
      + " and whitespaces.");
    for (int i = (inputstring.length()-1); i > -1; i--) {
      if (!(Character.isLetterOrDigit(inputstring.charAt(i))) &&
          !(Character.isWhitespace(inputstring.charAt(i))) &&
          !(inputstring.charAt(i) == '.')) {
        inputstring.deleteCharAt(i);
      }
    }
    System.out.println(inputstring);
  }

  // Method to turn the first lowercase a into an uppercase one
  public void capitalizeFirstLetterOfEveryWord() {
    System.out.println("Capitilizing the first letter of every word in the"
      + " first sentence.");
    int i = 0;
    while (!(inputstring.charAt(i) == '.')) {
      if (Character.isLetter(inputstring.charAt(i))) {
        if (i == 0) {
          inputstring.setCharAt(i,
            Character.toUpperCase(inputstring.charAt(i)));
        } else {
          if (Character.isWhitespace(inputstring.charAt(i-1))) {
            inputstring.setCharAt(i,
              Character.toUpperCase(inputstring.charAt(i)));
          }
        }
      }
      i++;
    }
    System.out.println(inputstring);
  }

  public void lowercaseFirstLine() {
    System.out.println("Making all letters in the first sentence (except that"
      + " of the first word) lowercase.");
    int i = 0;
    while (!(inputstring.charAt(i) == '.')) {
      if (Character.isLetter(inputstring.charAt(i))) {
        if (i == 0) {
          inputstring.setCharAt(i,
            Character.toLowerCase(inputstring.charAt(i)));
        } else {
          if (Character.isWhitespace(inputstring.charAt(i-1))) {
            inputstring.setCharAt(i,
              Character.toLowerCase(inputstring.charAt(i)));
          }
        }
      }
      i++;
    }
    System.out.println(inputstring);
  }

  // Append author name in uppercase to end of file
  public void appendAuthorName() {
    System.out.println("Appending the author's name.");
    inputstring.append("CONNOR BAKER");
    System.out.println(inputstring);
  }

// Append user's second input to end of file
  public StringBuffer appendSecondUserInput(StringBuffer userinput2) {
    System.out.println("Appending the user's second input.");
    inputstring.append(userinput2);
    System.out.println(inputstring);
    return null;
  }

  // Compare the lengths of the author's and user's name
  public StringBuffer compareUserInput3(StringBuffer userinput3) {
    System.out.println("Comparing the length of the user's and author's"
      + " names.");
    int x = 12; // Length of my name
    int y = userinput3.length(); // Length of user's name
    System.out.println("The difference between the author's name and the user's"
      + " name is: " + (y - x));
    return null;
  }

  public static void main(String args[]) throws IOException { // begin main
    // Create readers to grab user input
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    // Prompt user for input
    System.out.println("Please input your first string (greater than 300"
    + " printable characters) followed by ENTER: ");
    StringBuffer userinput = new StringBuffer(br.readLine());

    // Print the user's input back out to them
    System.out.println("You just entered: \n" + userinput);

    // Create our object using the user's input
    StringManipulationPart2 newObject = new StringManipulationPart2(userinput);

    // Do stuff to the object
    newObject.replaceDollarSignsWithOctothorpes();
    newObject.deleteAllOtherSpecialCharacters();
    newObject.capitalizeFirstLetterOfEveryWord();
    newObject.lowercaseFirstLine();
    newObject.appendAuthorName();

    // Prompt user for input again
    System.out.println("Please input another few other words"
    + " (a minumum of 5): ");
    StringBuffer inputstring2 = new StringBuffer(br.readLine());

    // Print the user's input back out to them again
    System.out.println("You just entered: \n" + inputstring2);

    // Continue doing stuff to the object
    newObject.appendSecondUserInput(inputstring2);

    // Prompt user for input for the last time
    System.out.println("Please input your name.");
    StringBuffer inputstring3 = new StringBuffer(br.readLine());

    // Print the user's input back out to them again
    System.out.println("You just entered: \n" + inputstring3);

    // Finish doing stuff to the object
    newObject.compareUserInput3(inputstring3);

    // Print the processed string back out to the user
    System.out.println(userinput);
  } // end main
}
