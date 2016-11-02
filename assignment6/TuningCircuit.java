// Import necessary packages

package assignment6;

public class TuningCircuit {
  // cMin & cMax, fMin & fMax are capacitance and frequency bounds, respectively
  double inductance, capacitance, cMin, cMax, frequency, fMin, fMax;

  public TuningCircuit() {
    frequency = 16700000;
    cMin = 0.000000000015;
    cMax = 0.000000000365;
    capacitance = getCapacitance(cMin, cMax);
  }

  public double getCapacitance(double cMin, double cMax) {
    double capacitance;
    this.capacitance = Math.sqrt(this.cMin * this.cMax);
    return this.capacitance;
  }

  // public void getfMin() {
  //
  // }
  //
  // public void getfMin() {
  //
  // }
}
