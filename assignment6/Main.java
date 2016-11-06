/*
*  Package Name: assignment6
*  File Name: Main.java
*
*  Author: Connor Baker
*  Version: 0.4a
*  Created: October 31, 2016
*  Last Updated: November 6, 2016
*/

// Declare our package
package assignment6;

// Import packages
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class Main { // begin class Main
  public static void main(String args[]) throws IOException { // begin main method
    // Create our object
    TuningCircuit circuit = new TuningCircuit();

    // Create our output stream
    File outputFile = new File("frequency.txt");
    RandomAccessFile raf = new RandomAccessFile(outputFile, "rw");

    // Run processing on our object
    while (true) { // begin outer while
      // Condition to break out of while loop
      if (circuit.fMax < circuit.standardFrequency) { //begin if
        /*
        *  The value given for inductance is great enough that all frequency
        *  calculated will be below the standard tuning frequency for any given
        *  capacitance within a range of any capacitance, due to calculatefMax
        *  being a strictly monotonic decreasing function (given inductance and
        *  capacitance minimum are strictly monotonic increasing functions,
        *  which they are).
        */
        break;
      } // end if

      // Calculuate the values of fMax for a given capacitance
      while (circuit.cMin < circuit.cMax) { // begin inner while
        // Increment cMin by 15 picofarad
        circuit.cMin += 0.000000000015;

        // Get the new value of fMax
        circuit.calculatefMax();

        // If fMax is less than 16.7MHZ terminate the program
        if (circuit.fMax > circuit.standardFrequency) { // begin if
          // Print the new value of fMax
          System.out.println("new fMax is " + circuit.fMax + " hertz. Add to file.");
          raf.writeDouble(circuit.fMax);
        } else {
          // Reset the cMin of our object and halt
          System.out.println("new fMax is "+circuit.fMax+" hertz. Don't add to"
              + " file because it is smaller than " + circuit.standardFrequency + " hertz. Halt calculations and increment inductance by 2%.");
          circuit.cMin = 0.000000000015;
          circuit.calculatefMax();
          break;
        } // end if
      } // end inner while

      // If the halt condition is not yet met, increment and run again
      circuit.inductance *= 1.02;
    } // end outer while

    raf.close();
  } // end main method
} // end class Main
