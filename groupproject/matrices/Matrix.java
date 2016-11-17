/*
*  Package Name: matrices
*  File Name: Matrix.java
*
*  Author: Connor Baker, Rae Bouldin
*  Version: 0.1b
*  Created: November 14, 2016
*  Last Updated: November 16, 2016
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
      }
      System.out.println(Arrays.deepToString(array));
    }
  }

  public static void sumOfArrays(int a[][], int b[][]) {
    int c[][] = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        c[i][j] = a[i][j] + b[i][j];
      }
    }
    System.out.println(Arrays.deepToString(c));
  }


  public static void productOfArrays(int a[][], int b[][]) {
    int c[][] = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        c[i][j] = a[i][0]*b[0][j] + a[i][1]*b[1][j] + a[i][2]*b[2][j];
      }
    }
    System.out.println(Arrays.deepToString(c));
  }

} // end class TuningCircuit
