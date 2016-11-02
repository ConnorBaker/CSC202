/*
*  Package Name: assignment6
*  File Name: TuningCircuit.java
*
*  Author: Connor Baker
*  Version: 0.2a
*  Created: October 31, 2016
*  Last Updated: November 2, 2016
*/

// Declare our package
package assignment6;

public class TuningCircuit {
  // cMin & cMax, fMin & fMax are capacitance and frequency bounds, respectively
  double inductance, capacitance, cMin, cMax, frequency, fMin, fMax;

  public TuningCircuit() {
    frequency = 16700000;
    cMin = 0.000000000015;
    cMax = 0.000000000365;
    getCapacitance();
    getInductance();
    getfMin();
    getfMax();
  }

  public void getCapacitance() {
    capacitance = Math.sqrt(cMin * cMax);
  }

  public void getInductance() {
    inductance = (((4*Math.PI*Math.PI)/(frequency*frequency))/capacitance);
  }

  public void getfMin() {
    fMin = ((2*Math.PI)/Math.sqrt(inductance*cMax));
  }

  public void getfMax() {
    fMax = ((2*Math.PI)/Math.sqrt(inductance*cMin));
  }
}
