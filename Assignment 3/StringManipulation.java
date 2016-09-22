/*
*  Author: Connor Baker
*  Version: 0.1a
*  Created: September 21, 2016
*  Last Updated: September 22, 2016
*
*  Description: Take in a String through InputStreamReader and BufferedReader,
*  and perform some processing on it. To be expanded later.
*
*  TODO: Speed up calculation of numberOfNonWhitespaceCharacters.
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
  String inputstring;
  int numberOfLetters;
  int numberOfDigits;
  int numberOfSpecialCharacters;
  int numberOfNonWhitespaceCharacters;

  // Create a default constructor
  StringManipulation() { // begin no-arg StringManipulation()
    inputstring = "Hey lol what'$ up[a] 123456 i'm so tired ugh!";
    numberOfLetters = 25;
    numberOfDigits = 6;
    numberOfSpecialCharacters = 6;
    numberOfNonWhitespaceCharacters = 37;
  } // end no-arg StringManipulation()

  // Create an argumented constructor
  StringManipulation(String passedstring) { // begin arg'd StringManipulation()
    inputstring = passedstring;
    numberOfLetters = getNumberOfLetters(inputstring.length());
    numberOfDigits = getNumberOfDigits(inputstring.length());
    numberOfSpecialCharacters =
      getNumberOfSpecialCharacters(inputstring.length());
    numberOfNonWhitespaceCharacters =
      getNumberOfNonWhitespaceCharacters(inputstring.length());
  } // end arg'd StringManipulation()

  // Create method to calculate the number of letters in a string
  public int getNumberOfLetters(int stringlength) { // begin getNumberOfLetters()
    // Initialize our variable to hold numberOfLetters
    int num = 0;
    for (int i = 0; i < stringlength; i++) {
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
  public int getNumberOfDigits(int stringlength) { // begin getNumberOfDigits()
    int num = 0;
    for (int i = 0; i < stringlength; i++) {
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
  public int getNumberOfSpecialCharacters(int stringlength) { // begin getNumberOfSpecialCharacters()
    int num = 0;
    for (int i = 0; i < stringlength; i++) {
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

  /*
  *  If we want to speed this up, we know this value will almost always be
  *  numberOfSpecialCharacters + numberOfDigits + numberOfLetters. We don't
  *  need the performance penalty incurred by using logic inside of a for loop.
  */
  // Create method to calculate the number non-whitespace characters in a string
  public int getNumberOfNonWhitespaceCharacters(int stringlength) { // begin getNumberOfNonWhitespaceCharacters()
    int num = 0;
    for (int i = 0; i < stringlength; i++) {
      if (Character.isLetterOrDigit(inputstring.charAt(i)) ||
      !(Character.isWhitespace(inputstring.charAt(i)))) {
        num++;
      }
    }
    return num;
  } // end getNumberOfNonWhitespaceCharacters()

  public void printNumberOfNonWhitespaceCharacters() { // begin printNumberOfNonWhitespaceCharacters()
    System.out.println("There are " + numberOfNonWhitespaceCharacters
      + " non-whitespace characters in the string.");
  } // eng printNumberOfNonWhitespaceCharacters()

  public static void main(String args[]) { // begin main()
    String stringtopass = "Hey lol what'$ up[a] 123456 i'm so tired ugh!";
    System.out.println(stringtopass);
    StringManipulation newObject = new StringManipulation(stringtopass);
    newObject.printNumberOfLetters();
    newObject.printNumberOfDigits();
    newObject.printNumberOfSpecialCharacters();
    newObject.printNumberOfNonWhitespaceCharacters();
  } // end main()
}
