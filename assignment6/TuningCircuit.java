/*
*  Package Name: assignment6
*  File Name: TuningCircuit.java
*
*  Author: Connor Baker
*  Version: 0.5a
*  Created: October 31, 2016
*  Last Updated: November 6, 2016
*/

// Declare our package
package assignment6;

// Import packages
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class TuningCircuit { // begin class TuningCircuit
  // cMin & cMax, fMin & fMax are capacitance and frequency bounds, respectively
  double inductance, capacitance, cMin, cMax, standardFrequency, fMin, fMax;

  // Variables which we use frequently should be pre-computed
  double cMinInitial;
  final double fourPiSquared = 4*Math.PI*Math.PI;
  final double twoPi = 2*Math.PI;

  // Set up objects to grab input from the user
  InputStreamReader inputStreamReader = new InputStreamReader(System.in);
  BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

  // @Override public String toString() {
  //   return String.format("inductance=%g, capacitance=%g, cMin=%g, cMax=%g, standardFrequency=%g, fMin=%g, fMax=%g", inductance, capacitance, cMin, cMax, standardFrequency, fMin, fMax);
  // }

  // Default constructor for our object
  public TuningCircuit() throws IOException {
    promptUserForStandardFrequency();
    promptUserForCapacitanceMinimum();
    promptUserForCapacitanceMaximum();
    calculateCapacitance();
    calculateInductance();
    calculatefMin();
    calculatefMax();
  }

  // Our method to request the standard frequency from the user
  public void promptUserForStandardFrequency() throws IOException {
    System.out.println("Input the standard frequency in hertz:");
    standardFrequency = Double.parseDouble(bufferedReader.readLine());
  }

  // Our method to request the lower bound of capacitance from the user
  public void promptUserForCapacitanceMinimum() throws IOException {
    System.out.println("Input the lower bound of capacitance in farad:");
    cMinInitial = Double.parseDouble(bufferedReader.readLine());
    cMin = cMinInitial;
  }

  // Our method to request the upper bound of capacitance from the user
  public void promptUserForCapacitanceMaximum() throws IOException {
    System.out.println("Input the upper bound of capacitance in farad:");
    cMax = Double.parseDouble(bufferedReader.readLine());
  }

  // Our method to calculate the capacitance of our circuit
  public void calculateCapacitance() {
    // See equation (2)
    capacitance = Math.sqrt(cMin * cMax);
  }

  // Our method to calculate the inductance of our circuit
  public void calculateInductance() {
    // See equation (1)
    inductance = ((fourPiSquared/(standardFrequency*standardFrequency))/capacitance);
  }

  // Our method to calculate the frequencyMinimum of our circuit
  public void calculatefMin() {
    // See equation (3)
    fMin = (twoPi/Math.sqrt(inductance*cMax));
  }

  // Our method to calculate the frequencyMaximum of our circuit
  public void calculatefMax() {
    // See equation (4)
    fMax = (twoPi/Math.sqrt(inductance*cMin));
  }
} // end class TuningCircuit
