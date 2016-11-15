/*
*  Package Name: assignment9
*  File Name: Matrix.java
*
*  Author: Connor Baker
*  Version: 0.1a
*  Created: November 14, 2016
*  Last Updated: November 14, 2016
*/

// Declare our package
package assignment9;

// Import packages (more than we need, we can cut down later)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Matrix { // begin class TuningCircuit
  // Create input streams
  InputStreamReader isr = new InputStreamReader(System.in);
  BufferedReader br = new BufferedReader(isr);
  StringTokenizer st;

  // Create our array for processing
  int array[][] = new int[3][4];

  // Default constructor for our object
  public Matrix() throws IOException {
    getNewMatrix();
  }

  public void getNewMatrix() throws IOException {
    System.out.println("Enter the coefficient matrix in form x1 x2 x3"
        + " augmented with b");
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 4; j++) {
        array[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    System.out.println(Arrays.deepToString(array));
  }

} // end class TuningCircuit
