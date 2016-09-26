/*
*  Author: Connor Baker
*  Version: 0.3a
*  Created: September 21, 2016
*  Last Updated: September 25, 2016
*
*  Description: Take in a String through InputStreamReader and BufferedReader,
*  and perform some processing on it. To be expanded later.
*
*  Note: numberOfNonWhitespaceCharacters is calculated through the sum of
*  numberOfDigits, numberOfLetters, and numberOfSpecialCharacters. I can't
*  think of an example where it wouldn't be that (outside of Java's methods not
*  detecting/seeing some types of characters as one of them)
*
*  Summary of problem specification:
*  Functionality:
*  Explanation of components:
*  Assumptions made:
*  Project name:
*  References used:
*
*
*  TODO: Create a variable stringlength to remove the need for calling .length()
*  TODO: Finish adding in comments
*  TODO: Finish adding functionality.
*  TODO: Revamp the header.
*/

// Import necessary packages
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringManipulation {
  // Initialize all of the object attributes
  StringBuffer inputstring;
  int inputstringlength;
  int numberOfLetters;
  int numberOfDigits;
  int numberOfSpecialCharacters;
  int numberOfNonWhitespaceCharacters;
  int locationOfFirstLowercaseA;
  int locationOfFirstDollarSign;
  int numberOfDollarSigns;

  // Create an argumented constructor
  StringManipulation(StringBuffer passedstring) { // begin arg'd StringManipulation()
    inputstring = passedstring;
    inputstringlength = inputstring.length();
    numberOfLetters = getNumberOfLetters();
    numberOfDigits = getNumberOfDigits();
    numberOfSpecialCharacters = getNumberOfSpecialCharacters();
    numberOfNonWhitespaceCharacters = numberOfLetters + numberOfDigits
                                      + numberOfSpecialCharacters;
    locationOfFirstLowercaseA = (inputstring.indexOf("a")+1);
    locationOfFirstDollarSign = ((inputstring.indexOf("$", 10)+1));
    numberOfDollarSigns = getNumberOfDollarSigns();
  } // end arg'd StringManipulation()

  // Create method to calculate the number of letters in a string
  public int getNumberOfLetters() { // begin getNumberOfLetters()
    // Initialize our variable to hold numberOfLetters
    int num = 0;
    for (int i = 0; i < inputstringlength; i++) {
      // For the length of the string, check if each
      if (Character.isLetter(inputstring.charAt(i))) {
        num++;
      }
    }
    return num;
  } // end getNumberOfLetters()

  public void printNumberOfLetters() { // begin printNumberOfLetters()
    System.out.println("There are " + numberOfLetters + " letters in the"
    + " string.");
  } // end printNumberOfLetters()

  // Create method to calculate the number of digits in a string
  public int getNumberOfDigits() { // begin getNumberOfDigits()
    int num = 0;
    for (int i = 0; i < inputstringlength; i++) {
      if (Character.isDigit(inputstring.charAt(i))) {
        num++;
      }
    }
    return num;
  } // end getNumberOfDigits()

  public void printNumberOfDigits() { // begin printNumberOfDigits()
    System.out.println("There are " + numberOfDigits + " digits in the"
    + " string.");
  } // end printNumberOfDigits()

  // Create method to calculate the number of special characters in a string
  public int getNumberOfSpecialCharacters() { // begin getNumberOfSpecialCharacters()
    int num = 0;
    for (int i = 0; i < inputstringlength; i++) {
      if (!(Character.isLetterOrDigit(inputstring.charAt(i))) &&
      !(Character.isWhitespace(inputstring.charAt(i)))) {
        num++;
      }
    }
    return num;
  } // end getNumberOfSpecialCharacters()

  public void printNumberOfSpecialCharacters() { // begin printNumberOfSpecialCharacters()
    System.out.println("There are " + numberOfSpecialCharacters + " special"
    + " characters in the string.");
  } // end printNumberOfSpecialCharacters()

  public void printNumberOfNonWhitespaceCharacters() { // begin printNumberOfNonWhitespaceCharacters()
    System.out.println("There are " + numberOfNonWhitespaceCharacters
      + " non-whitespace characters in the string.");
  } // eng printNumberOfNonWhitespaceCharacters()

  public void printLocationOfCharA() {
    System.out.println("The first 'a' is character number "
      + locationOfFirstLowercaseA);
    System.out.println("The other locations are at character number(s): ");
    for (int i = locationOfFirstLowercaseA; i < inputstringlength; i++) {
      if (inputstring.charAt(i) == 'a') {
        System.out.print(i + " ");
      }
    }
    System.out.println();
  }

  public void lowercaseToUppercaseA() {
    inputstring.replace(locationOfFirstLowercaseA,
                        locationOfFirstLowercaseA, "A");
  }

  public void printlocationOfFirstDollarSigns() {
     System.out.println("The first '$' is at character number "
      + locationOfFirstDollarSign);
  }

  public int getNumberOfDollarSigns() {
     for (int i = locationOfFirstDollarSign-1; i < inputstringlength; i++) {
       if (inputstring.charAt(i) == '$') {
         numberOfDollarSigns++;
       }
     }
     return numberOfDollarSigns;
  }

  public void printNumberOfDollarSigns() {
    System.out.println("There are " + numberOfDollarSigns + " '$'.");
  }

  public void printNumberOfCharachters() {
    System.out.println("There are " + inputstringlength + " characters.");
  }

  public static void main(String args[]) { // begin main()
    StringBuffer stringtopass = new StringBuffer("Hey lol what'$ up[a] 123456 i'm so tired ugh!");
    System.out.println(stringtopass);
    StringManipulation newObject = new StringManipulation(stringtopass);
    newObject.printNumberOfCharachters();
    newObject.printNumberOfNonWhitespaceCharacters();
    newObject.printNumberOfLetters();
    newObject.printNumberOfDigits();
    newObject.printNumberOfSpecialCharacters();
    newObject.printLocationOfCharA();
    newObject.lowercaseToUppercaseA();
    newObject.printlocationOfFirstDollarSigns();
    newObject.printNumberOfDollarSigns();
    System.out.println(stringtopass);
  } // end main()
}
