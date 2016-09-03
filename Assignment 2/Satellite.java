/*
*  Author: Connor Baker
*  Version: 0.1a
*  Created: September 3, 2016
*  Last Updated: September 3, 2016
*
*  Description: Calculate the position of the receiver on the surface of the
*  earth by using three satellites to triangulate.
*
*/

// Import necessary packages
import java.util.Scanner;

public class Satellite {

  // Create variables to be used (both in seconds)
  static double latencyFromReceiver;
  static double latencyFromBroadcast;

  // Create named constant for the speed of light
  final static double SPEED_OF_LIGHT = 299792458;

  // Create default constructor for the Satellite
  Satellite(int input) {
    if (input == 19) {
      latencyFromReceiver = 0.0025;
      latencyFromBroadcast = 0.00000002;
    } else if (input == 20) {
      latencyFromReceiver = 0.001;
      latencyFromBroadcast = 0.00000001;
    } else if (input == 22) {
      latencyFromReceiver = 0.00059;
      latencyFromBroadcast = 0.0000000012;
    } else if (input == 24) {
      latencyFromReceiver = 0.0012;
      latencyFromBroadcast = 0.0000000015;
    }
  }

  // Method to calculate the pseudo-range between a satellite and a receiver
  static double PsuedoRange() {
    double temp = ((latencyFromReceiver - latencyFromBroadcast) * SPEED_OF_LIGHT);
    return temp;
  }

  public static void main(String[] args) {
    // Create the scanner to grab input from the user
    Scanner scanner = new Scanner(System.in);

    // Prompt the user for input
    System.out.println("Please input the ID of satellite to be used to  calculate the distance to the reciever (Choice of 19, 20, 22, 24): ");

    // Grab input from the user
    int input = scanner.nextInt();

    // Close the scanner after use
    scanner.close();

    // Determine which of the satellites to use to compute the distance
    if (input == 19) {
      Satellite newSatellite = new Satellite(19);
    } else if (input == 20) {
      Satellite newSatellite = new Satellite(20);
    } else if (input == 22) {
      Satellite newSatellite = new Satellite(22);
    } else if (input == 24) {
      Satellite newSatellite = new Satellite(24);
    } else {
      System.out.println("Enter a correct choice. Re-run the program.");
    }

    // Find the PsuedoRange
    double range = PsuedoRange();

    // Print out the result
    System.out.println("The result is: " + range + " meters.");
  }
}
