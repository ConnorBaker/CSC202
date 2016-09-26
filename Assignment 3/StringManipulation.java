/*
*  Author: Connor Baker
*  Version: 0.4a
*  Created: September 21, 2016
*  Last Updated: September 26, 2016
*
*  Summary of problem specification:
*  Using InputStreamReader, BufferedReader, and StringBuffer classes, create a
*  program that accepts user input, outputs the input string, determines the
*  length of the input string, counts the number of letters, digits, special
*  characters, non-whitespace charactres, dollar signs after the tenth
*  character, finds the position of dollar sign after the tenth character, and
*  finds the position of every lowercase 'a' and converts the first occurance
*  into an uppercase 'A', and outputs the string.
*
*  Functionality:
*  Meets problem specification.
*
*  Explanation of components:
*  Uses a number of simple get methods, in combination with print methods to
*  display properties of the string in compliance with the problem
*  specification. Most methods have checks built into them (i.e. the
*  printlocationOfFirstDollarSign won't print anything if there are no
*  occurances.)
*  numberOfNonWhitespaceCharacters is calculated by taking the sum of
*  numberOfDigits, numberOfLetters, and numberOfSpecialCharacters. I can't
*  think of an example where it wouldn't be that (outside of Java's methods not
*  detecting/seeing some types of characters as one of them).
*
*  Assumptions made:
*  Java EA 9 didn't allow me to write anything that isn't backwards compliant
*  with the current version.
*
*  Project name:
*  StringManipulation.java
*
*  References used:
*  https://docs.oracle.com/javase/8/docs/
*  http://stackoverflow.com/questions/17629321/throwing-exception-in-main-method
*    (for how to use the keyword throws)
*
*  TODO: Optimize the if and for statements in printLocationsOfCharA(). We
*  don't need to start at the last known location in the for loop. It's most
*  likely more efficient to start at the newest one and then compare values
*  from there.
*/

// Import necessary packages
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class StringManipulation {
  // Initialize all of the object attributes
  StringBuffer inputstring; // User determined input
  int inputstringlength; // Length of input
  int numberOfLetters; // Number of letters in input
  int numberOfDigits; // Number of digits in input
  int numberOfSpecialCharacters; // Number of special characters in input
  int numberOfNonWhitespaceCharacters; // Number of non-whitespace characters in input
  int locationOfFirstLowercaseA; // Position of first miniscule a in input
  int locationOfFirstDollarSign; // Position of first dollar sign in input
  int numberOfDollarSigns; // Number of dollar signs in input

  // Create an argumented constructor
  StringManipulation(StringBuffer passedstring) {
    inputstring = passedstring;
    // I used inputstring.length() enough that it actually warranted creating a variable to hold the length
    inputstringlength = inputstring.length();
    numberOfLetters = getNumberOfLetters();
    numberOfDigits = getNumberOfDigits();
    numberOfSpecialCharacters = getNumberOfSpecialCharacters();
    numberOfDollarSigns = getNumberOfDollarSigns();
    // See mention in header for why numberOfNonWhitespaceCharacters doesn't require a method
    numberOfNonWhitespaceCharacters = numberOfLetters + numberOfDigits
    + numberOfSpecialCharacters;
    locationOfFirstLowercaseA = (inputstring.indexOf("a")+1);
    locationOfFirstDollarSign = ((inputstring.indexOf("$", 10)+1));
  }

  // Method to calculate the number of letters in a string
  public int getNumberOfLetters() {
    // Initialize our variable to hold numberOfLetters
    int num = 0;
    for (int i = 0; i < inputstringlength; i++) {
      // For the length of the string, check if each character is a letter
      if (Character.isLetter(inputstring.charAt(i))) {
        num++; // Add to our variable if it is a letter
      }
    }
    return num;
  }

  // Method to calculate the number of digits in a string
  public int getNumberOfDigits() {
    int num = 0;
    for (int i = 0; i < inputstringlength; i++) {
      // For the length of the string, check if each character is a digit
      if (Character.isDigit(inputstring.charAt(i))) {
        num++; // Add to our variable if it is a digit
      }
    }
    return num;
  }

  // Method to calculate the number of special characters in a string
  public int getNumberOfSpecialCharacters() {
    int num = 0;
    for (int i = 0; i < inputstringlength; i++) {
      // Anything that isn't a letter, digit, or whitespace is a special character
      if (!(Character.isLetterOrDigit(inputstring.charAt(i))) &&
      !(Character.isWhitespace(inputstring.charAt(i)))) {
        num++; // Add to our variable if it is a special character
      }
    }
    return num;
  }

  // Method to calculate the number of dollar signs in a string
  public int getNumberOfDollarSigns() {
    if (locationOfFirstDollarSign != 0) {
      for (int i = locationOfFirstDollarSign-1; i < inputstringlength; i++) {
        // Starting at the index of the first dollar sign, look for more
        if (inputstring.charAt(i) == '$') {
          numberOfDollarSigns++; // Increment each time we find one
        }
      }
      return numberOfDollarSigns;
    } else {
      numberOfDollarSigns = 0;
      return numberOfDollarSigns;
    }
  }

  // Method to turn the first lowercase a into an uppercase one
  public void lowercaseToUppercaseA() {
    if (locationOfFirstLowercaseA != 0) {
      inputstring.replace(locationOfFirstLowercaseA-1,
      locationOfFirstLowercaseA, "A");
    }
  }

  // Method to print the number of letters in a string
  public void printNumberOfLetters() {
    System.out.println("There are " + numberOfLetters + " letters in the"
      + " string.");
  }

  // Method to print the number of digits in a string
  public void printNumberOfDigits() {
    System.out.println("There are " + numberOfDigits + " digits in the"
      + " string.");
  }

  // Method to print the number of special characters in a string
  public void printNumberOfSpecialCharacters() {
    System.out.println("There are " + numberOfSpecialCharacters + " special"
      + " characters in the string.");
  }

  // Method to print the number of non-whitespace characters in a string
  public void printNumberOfNonWhitespaceCharacters() {
    System.out.println("There are " + numberOfNonWhitespaceCharacters
      + " non-whitespace characters in the string.");
  }

  // Method to print the first location of 'a' in a string
  public void printLocationOfFirstCharA() {
    if (locationOfFirstLowercaseA != 0) {
      System.out.println("The first 'a' is character number "
        + locationOfFirstLowercaseA + ".");
    } else {
      System.out.println("There are 0 'a's in the string.");
    }
  }

// Method to print the other locations of 'a' in a string
  public void printLocationsOfCharA() {
    if ((locationOfFirstLowercaseA != 0) &&
        (inputstring.indexOf("a", locationOfFirstLowercaseA) != 0)) {
      System.out.println("The other locations are at character number(s): ");
      for (int i = locationOfFirstLowercaseA+1; i < inputstringlength; i++) {
        if (inputstring.charAt(i) == 'a') {
          System.out.print((i+1) + " ");
        }
      }
      System.out.println();
    }
  }

  // Method to print the location of the first dollar sign in a string
  public void printlocationOfFirstDollarSign() {
    if (locationOfFirstDollarSign != 0) {
      System.out.println("The first '$' is at character number "
        + locationOfFirstDollarSign + ".");
    } else {
    }
  }

  // Method to print the number of dollar signs in a string
  public void printNumberOfDollarSigns() {
    System.out.println("There are " + numberOfDollarSigns + " '$' in the string.");
  }

  // Method to print the number of total characters in a string
  public void printNumberOfCharacters() {
    System.out.println("There are " + inputstringlength + " characters in the string.");
  }

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
    newObject.printNumberOfCharacters();
    newObject.printNumberOfNonWhitespaceCharacters();
    newObject.printNumberOfLetters();
    newObject.printNumberOfDigits();
    newObject.printNumberOfSpecialCharacters();
    newObject.printNumberOfDollarSigns();
    newObject.printlocationOfFirstDollarSign();
    newObject.printLocationOfFirstCharA();
    newObject.printLocationsOfCharA();
    newObject.lowercaseToUppercaseA();

    // Print the processed string back out to the user
    System.out.println(userinput);
  } // end main
}
