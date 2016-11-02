/*
*  Project name: TuningCircuits.java
*
*  Author: Connor Baker
*  Version: 0.1b
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
*  Explanation of components:
*  See comments.
*
*  Formulae used:
*  inductance = ((2pi/frequency)^2)/capacitance
*  capacitance = sqrt(capacitanceMaximum*capacitanceMinimum)
*  frequencyMinimum = (2pi)/sqrt(inductance*capacitanceMaximum)
*  frequencyMaximum = (2pi)/sqrt(inductance*capacitanceMinimum)
*
*  Assumptions made:
*  Java EA 9 didn't allow me to write anything that isn't backwards compliant
*  with the current version.
*
*  References used:
*  http://download.java.net/java/jdk9/docs/api/
*/

package assignment6;

public class Main {
  public static void main(String args[]) {
    TuningCircuit circuit = new TuningCircuit();
    System.out.println(circuit.capacitance);
  }
}
