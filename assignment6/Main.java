/*
*  Project name: TuningCircuits.java
*
*  Author: Connor Baker
*  Version: 0.1a
*  Created: October 31, 2016
*  Last Updated: October 31, 2016
*
*  Summary of problem specification:
*  Write a program in java of a tuning circuit for a frequency range of fMin to
*  fMax. Must use a random access file. A variable capacitor is used, with cMin
*  to cMax (15pf to 365pf in 15pf intervals). A typical tuning frequency is
*  16.7MHZ. Read all the variables, compute the value of L (inductance) for any
*  given frequency. Then, compute the the new given value
*
*  Functionality:
*  Currently meets problem specification, except for the condition of using
*  seven wrapper classes.
*
*  Explanation of components:
*  See comments.
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
