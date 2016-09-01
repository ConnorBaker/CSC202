/*
*  Author: Connor Baker
*  Version: 0.1a
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

    // Create an array of booleans to determine the converted number
    boolean[] array = new boolean[input.length()-1];

    for (int i = 1; i < input.length(); i++) {
      if (Integer.parseInt(input.substring(i)) == 1) {
        System.out.println(Integer.parseInt(input.substring(i)));
        System.out.println("right");
      } else if (Integer.parseInt(input.substring(i)) == 0) {
        System.out.println(Integer.parseInt(input.substring(i)));
        System.out.println("left");
      } else {
        System.out.println(Integer.parseInt(input.substring(i)));
        System.out.println("The 'decimal' must be in base two. Please input the number in the correct format.");
        break;
      }
    }
  }
}
