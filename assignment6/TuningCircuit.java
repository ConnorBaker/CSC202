/*
*  Package Name: assignment6
*  File Name: TuningCircuit.java
*
*  Author: Connor Baker
*  Version: 0.3a
*  Created: October 31, 2016
*  Last Updated: November 5, 2016
*/

// Declare our package
package assignment6;

public class TuningCircuit { // begin class TuningCircuit
  // cMin & cMax, fMin & fMax are capacitance and frequency bounds, respectively
  double inductance, capacitance, cMin, cMax, frequency, fMin, fMax;

  // Variables which we use frequently should be pre-computed
  final double fourPiSquared = 4*Math.PI*Math.PI;
  final double twoPi = 2*Math.PI;

  // Default constructor for our object
  public TuningCircuit() {
    frequency = 16700000;
    cMin = 0.000000000015;
    cMax = 0.000000000365;
    getCapacitance();
    getInductance();
    getfMin();
    getfMax();
  }

  // Our method to calculate the capacitance of our circuit
  public void getCapacitance() {
    // See equation (2)
    capacitance = Math.sqrt(cMin * cMax);
  }

  // Our method to calculate the inductance of our circuit
  public void getInductance() {
    // See equation (1)
    inductance = ((fourPiSquared/(frequency*frequency))/capacitance);
  }

  // Our method to calculate the frequencyMinimum of our circuit
  public void getfMin() {
    // See equation (3)
    fMin = (twoPi/Math.sqrt(inductance*cMax));
  }

  // Our method to calculate the frequencyMaximum of our circuit
  public void getfMax() {
    // See equation (4)
    fMax = (twoPi/Math.sqrt(inductance*cMin));
  }
} // end class TuningCircuit
