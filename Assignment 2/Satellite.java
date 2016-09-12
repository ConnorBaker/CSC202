/*
*  Author: Connor Baker
*  Version: 0.3a
*  Created: September 3, 2016
*  Last Updated: September 11, 2016
*
*  Description: Calculate the distance from a satellite (determined upon
*  runtime by user inputting the ID of the satellite) to a reciever by means of
*  the pseudo-range function given in class ((latencyFromReceiver -
*  latencyFromBroadcast) SPEED_OF_LIGHT). The latency from the broadcaster and
*  to the reciever are pre-determined and are not inputted by the user.
*/

// Import necessary packages
import java.util.Scanner;

public class Satellite {
  // Create variables to be used (both in seconds)
  static double latencyFromReceiver;
  static double latencyFromBroadcast;

  // Create named constant for the speed of light
  final static double SPEED_OF_LIGHT = 299792458;

  // Create argumented constructor for the Satellite
  Satellite(int input) { // begin Satellite()
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
  } // end Satellite()

  // Method to calculate the pseudo-range between a satellite and a receiver
  static double PsuedoRange() { // begin PsuedoRange()
    double temp = ((latencyFromReceiver - latencyFromBroadcast) *
      SPEED_OF_LIGHT);
    return temp;
  } // end PsuedoRange()

  public static void main(String[] args) { // begin main()
    // Create the scanner to grab input from the user
    Scanner scanner = new Scanner(System.in);

    // Prompt the user for input
    System.out.println("Please input the ID of satellite to be used to"
      + " calculate the distance to the reciever (Choice of 19, 20, 22, 24): ");

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
      System.out.println("Enter one of the given satellite IDs. Please re-run"
        + " the program.");
    }

    // Find the PsuedoRange
    double range = PsuedoRange();

    // Print out the result
    System.out.println("The pseudo-range from satellite ID #" + input +
      " to the receiver is "+ range + " meters.");
  } // begin main()
}
