/*
*  Package Name: matrices
*  File Name: Matrix.java
*
*  Author: Connor Baker, Rae Bouldin
*  Version: 0.1a
*  Created: November 14, 2016
*  Last Updated: November 14, 2016
*/

// Declare our package
package matrices;

// Import packages (more than we need, we can cut down later)
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Matrix { // begin class TuningCircuit
  // Create our array for processing
  int array[][] = new int[3][3];

  // Set up objects to grab input from the user
  File inputFile = new File(".\\matrices\\matrices.txt");
  FileReader fr = new FileReader(inputFile);
  BufferedReader br = new BufferedReader(fr);

  // Default constructor for our object
  public Matrix() throws IOException {
    fillArray();
  }

  // // Argumented constructor for our object
  // public Matrix(int array[][], int numOfRows, int numOfCols) throws IOException {
  //
  // }

  public void fillArray() throws IOException {
    StringTokenizer st;
    for (int i = 0; i < array.length; i++) {
      // We must create a new string tokenizer for each new line we want to read
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < array[i].length; j++) {
        array[i][j] = Integer.parseInt(st.nextToken());

        // Print out information about the array so we can see what's happening
        System.out.println(array[i][j]);
      }
    }
  }

  public int[][] productOfArrays(int a[][], int b[][]) {
    int c[][] = new int[3][3];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        c[i][j] = a[i][j] + b[i][j];
      }
    }
    System.out.println(Arrays.deepToString(c));
    return c[][];
  }

} // end class TuningCircuit
