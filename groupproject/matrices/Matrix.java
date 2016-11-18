/*
*  Package Name: matrices
*  File Name: Matrix.java
*
*  Author: Connor Baker, Rae Bouldin
*  Version: 0.1f
*  Created: November 14, 2016
*  Last Updated: November 17, 2016
*
*  A note in general about the array processing methods:
*  Instead of using array.length and array[i].length in all of the for loops,
*  I've decided to use the constant 3, because this project deals only with
*  matrices of the third order. I believe that using a constant instead of
*  referencing the size of the array (which in of itself requires passing the
*  array to another method and having java tally the length) provides a
*  meaningful speedup.
*
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

  // Set up objects to grab input from the file
  File inputFile;
  FileReader fr;
  BufferedReader br;

  // Default constructor for our object
  public Matrix() throws IOException {
    inputFile = new File(".\\matrices\\matrices.txt");
    fr = new FileReader(inputFile);
    br = new BufferedReader(fr);
    readArrayFromFile();
  }

  // Argumented constructor for our object
  public Matrix(String filename) throws IOException {
    inputFile = new File(filename);
    fr = new FileReader(inputFile);
    br = new BufferedReader(fr);
    readArrayFromFile();
  }

  // Method to fill the array from file
  public void readArrayFromFile() throws IOException {
    // Initialize our StringTokenizer
    StringTokenizer st;
    for (int i = 0; i < 3; i++) {
      // We must create a new string tokenizer for each new line we want to read
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        // Read the values of the array line by line
        array[i][j] = Integer.parseInt(st.nextToken());
      }
      // Print out the array
      System.out.println(Arrays.deepToString(array));
    }
  }

  // Method to take the sum of two arrays
  public static void sumOfArrays(int a[][], int b[][]) {
    // Initialize our resultant array
    int c[][] = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        // Sum the values of the elements of the two
        c[i][j] = a[i][j] + b[i][j];
      }
    }
    // Print out the array
    System.out.println(Arrays.deepToString(c));
  }

  // Method to take the product of two arrays
  public static void productOfArrays(int a[][], int b[][]) {
    // Initialize our resultant array
    int c[][] = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        // Calculates the product using  a formula derived in the documentation
        // See documentation, section X.X.X for more information
        c[i][j] = a[i][0]*b[0][j] + a[i][1]*b[1][j] + a[i][2]*b[2][j];
      }
    }
    // Print out the array
    System.out.println(Arrays.deepToString(c));
  }

  // Method to take the transpose of an array
  public static void transposeOfArray(int a[][]) {
    // Initialize our resultant array
    int c[][] = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        // Simply swapping the element's position yeilds the transpose
        // See documentation, section X.X.X for more information
        c[i][j] = a[j][i];
      }
    }
    // Print out the array
    System.out.println(Arrays.deepToString(c));
  }

  // Method to take the determinant of an array
  public static void determinantOfArray(int a[][]) {
    // Initialize our resultant array
    int determinant;
    determinant = a[0][0]*(a[1][1]*a[2][2]-a[1][2]*a[2][1])
                  - a[0][1]*(a[1][0]*a[2][2]-a[1][2]*a[2][0])
                  + a[0][2]*(a[1][0]*a[2][1]-a[1][1]*a[2][0]);
    // Print out the array
    System.out.println(determinant);
  }

} // end class TuningCircuit
