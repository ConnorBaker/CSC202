/*
*  Package Name: assignment6
*  File Name: Main.java
*
*  Author: Connor Baker
*  Version: 0.2a
*  Created: October 31, 2016
*  Last Updated: November 2, 2016
*
*  Summary of problem specification:
*  Using a standard tuning frequency of 16.7MHZ, find the inducance of a
*  circuit using formulae given in class (see formulae section). After find the
*  inductance, input it into the formula given to find frequency minimum and
*  frequency maximum, recording the values of both. Then, increment the
*  capacitance by 15 picofarad, recording the new value of frequency minimum
*  for each increment, until we meet frequency maximum, writing all these
*  values to a random access file.
*
*  Functionality:
*  Working on it.
*
*  Explanation of Components:
*  See comments.
*
*  Formulae Used:
*  inductance = ((2pi/frequency)^2)/capacitance
*  capacitance = sqrt(capacitanceMinimum*capacitanceMaximum)
*  frequencyMinimum = (2pi)/sqrt(inductance*capacitanceMaximum)
*  frequencyMaximum = (2pi)/sqrt(inductance*capacitanceMinimum)
*
*  Assumptions:
*  Java EA 9 didn't allow me to write anything that isn't backwards compliant
*  with the current version.
*
*  References:
*  http://download.java.net/java/jdk9/docs/api/
*/

// Declare our package
package assignment6;

public class Main {
  public static void main(String args[]) {
    TuningCircuit circuit = new TuningCircuit();

    /*
    *  TODO: Have the while loop keep only the greatest value of fMax. We know
    *  (thanks to the formula for frequencyMaximum) that if the next value of
    *  fMax is lower, we can halt calculation, because every value thereafter
    *  will be lower as well (since we're gradually increasing the value of the
    *  denominator as we increment capacitanceMinimum).
    */
    // Calculuate the values of fMax for a given capacitance
    while (circuit.cMin < circuit.cMax) {
      // Increment cMin by 15 picofarad
      circuit.cMin = circuit.cMin + 0.000000000015;
      // Get the new value of fMax
      circuit.getfMax();
      // Print the new value of fMax
      System.out.println("new fMax is "+circuit.fMax);
    }
    // Reset cMin to it's default value
    circuit.cMin = 0.000000000015;

  }
}
