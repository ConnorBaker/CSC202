/*
*  Author: Connor Baker
*  Version: 0.2a
*  Created: September 1, 2016
*  Last Updated: September 1, 2016
*
*  Description: Take input from command line (in the form of a 'decimal' in
*  base two) and convert it to the corresponding decimal in base 10.
*/

// Import necessary packages
import java.util.Scanner;
import java.lang.Integer;

public class Base2to10 {
  public static void main(String[] args) {
    // Create the scanner to grab input from the user
    Scanner scanner = new Scanner(System.in);

    // Prompt user for input
    System.out.println("Please input a 'decimal' in base two between 0 and 1 (ex. 0.1011), followed by the ENTER key: ");

    // Grab input from user
    String input = scanner.nextLine();

    // Make sure to close the scanner
    scanner.close();

    // Create an array of char to determine the converted number
    char[] array = new char[input.length()];

    // Populate the char array
    for (int i = 0; i < input.length(); i++) {
      array[i] = input.charAt(i);
    }

    // Create an array of booleans to help calculate the nubmer
    int[] movementarray = new int[array.length];

    // Populate the movementarray
    for (int i = 0; i < array.length; i++) {
      if (Integer.valueOf(array[i]) == 1) {
        movementarray[i] = 1;
      } else {
        movementarray[i] = 0;
      }
    }

    for (int i = 0; i < movementarray.length(); i++) {
      if (movementarray[i] == 1) {
        System.out.println("right");
      } else {
        System.out.println("left");
      }
    }
  }
}
