/*
*  Package Name: assignment6
*  File Name: Main.java
*
*  Author: Connor Baker
*  Version: 0.3a
*  Created: October 31, 2016
*  Last Updated: November 5, 2016
*/

// Declare our package
package assignment6;

public class Main { // begin class Main
  public static void main(String args[]) { // begin main()
    // Create our object
    TuningCircuit circuit = new TuningCircuit();

    // Run processing on our object
    while (true) { // begin outer while
      // Condition to break out of while loop
      if (circuit.fMax < circuit.frequency) { //begin if
        /*
        *  The value given for inductance is great enough that all frequency
        *  calculated will be below the standard tuning frequency for any given
        *  capacitance within our range of 15-365 picofarad.
        */
        break;
      } // end if

      // Calculuate the values of fMax for a given capacitance
      while (circuit.cMin < circuit.cMax) { // begin inner while
        // Increment cMin by 15 picofarad
        circuit.cMin += 0.000000000015;

        // Get the new value of fMax
        circuit.getfMax();

        // If fMax is less than 16.7MHZ terminate the program
        if (circuit.fMax > circuit.frequency) { // begin if
          // Print the new value of fMax
          System.out.println("new fMax is "+circuit.fMax);
        } else {
          // Reset the cMin of our object and halt
          circuit.cMin = 0.000000000015;
          circuit.getfMax();
          break;
        } // end if
      } // end inner while

      // If the halt condition is not yet met, increment and run again
      circuit.inductance *= 1.02;
    } // end outer while
  } // end main()
} // end class Main
