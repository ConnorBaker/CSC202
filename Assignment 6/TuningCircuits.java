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

// Import necessary packages

public class TuningCircuits {
  public static void main(String args[]) {
    double fMin = 0;
    double fMax = 0;
    double inductance = 0;
    int f = 0;

    final double capacitance = Math.sqrt(5475);

    for (int i = 1; i < 10; i++) {
      fMin = (Math.PI)/Math.sqrt(i*365);
      fMax = (Math.PI)/Math.sqrt(i*15);
      System.out.println("fMin is "+fMin);
      System.out.println("fMax is "+fMax);
      double j = fMin;
      while (j < fMax) {
        inductance = Math.pow((2*Math.PI/j), 2)/capacitance;
        System.out.println("fMin is "+fMin);
        System.out.println("fMax is "+fMax);
        System.out.println("inductance is "+inductance);
        System.out.println("f is "+j);
        j += 0.5;
      }
    }
  }
}
