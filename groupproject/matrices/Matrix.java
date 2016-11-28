/*
*  Package Name: matrices
*  File Name: Matrix.java
*
*  Author: Connor Baker, Rae Bouldin
*  Version: 0.4a
*  Created: November 14, 2016
*  Last Updated: November 28, 2016
*
*  A note in general about the matrix processing methods:
*  Instead of using matrix.length and matrix[i].length in all of the for loops,
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

public class Matrix {
  // Create our matrix for processing
  double matrix[][];

  // Default constructor for our object
  public Matrix() {
    // Call the argumented constructor
    this(new double[3][3]);
  }

  // Default constructor for our object
  public Matrix(double matrix[][]) {
    this.matrix = matrix;
  }

  // Method to create a copy of a matrix
  public Matrix copy() {
    double matrix[][] = new double[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        mat[i][j] = matrix[i][j];
      }
    }
    return new Matrix(matrix);
  }

  // Method to fill the matrix from file
  public static Matrix readMatrixFromFile(String filename) throws IOException {
    // Initialize our matrix
    double matrix[][] = new double[3][3];

    // Initialize input stream
    BufferedReader br = new BufferedReader(new FileReader(new File(filename)));

    // Initialize our StringTokenizer
    StringTokenizer st;
    for (int i = 0; i < 3; i++) {
      // We must create a new string tokenizer for each new line we want to read
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        // Read the values of the matrix line by line
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // Print out the matrix
    System.out.println("The matrix read from file is:");
    printMatrixToConsole(matrix);

    // Close buffered reader
    br.close();

    // Return our new matrix
    return new Matrix(matrix);
  }

  // Method to take the determinant of a matrix
  public double determinantOfMatrix() {
    return  matrix[0][0]*(matrix[1][1]*matrix[2][2]-a[1][2]*matrix[2][1])
          - matrix[0][1]*(matrix[1][0]*matrix[2][2]-matrix[1][2]*matrix[2][0])
          + matrix[0][2]*(matrix[1][0]*matrix[2][1]-matrix[1][1]*matrix[2][0]);
  }

  // Method to take the transpose of a matrix
  public Matrix transposeOfMatrix() {
    // Create our resultant matrix
    Matrix transpose = new Matrix();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        // Simply swapping the element's position yeilds the transpose
        // See documentation, section X.X.X for more information
        transpose.matrix[i][j] = matrix[j][i];
      }
    }

    // Return the new matrix
    return transpose;
  }

  // Method to take the cafactor matrix of a matrix
  public Matrix cofactorOfMatrix() {
    // Initialize our resultant matrix
    Matrix cofactor = new Matrix();
    // Calculates the cofactor matrix using a formula derived in the documentation
    // See documentation, section X.X.X for more information
    cofactor.matrix[0][0] =     matrix[1][1]*matrix[2][2] - matrix[1][2]*matrix[2][1];
    cofactor.matrix[0][1] = -1*(matrix[1][0]*matrix[2][2] - matrix[1][2]*matrix[2][0]);
    cofactor.matrix[0][2] =     matrix[1][0]*matrix[2][1] - matrix[1][1]*matrix[2][0];
    cofactor.matrix[1][0] = -1*(matrix[0][1]*matrix[2][2] - matrix[0][2]*matrix[2][1]);
    cofactor.matrix[1][1] =     matrix[0][0]*matrix[2][2] - matrix[0][2]*matrix[2][0];
    cofactor.matrix[1][2] = -1*(matrix[0][0]*matrix[2][1] - matrix[0][1]*matrix[2][0]);
    cofactor.matrix[2][0] =     matrix[0][1]*matrix[1][2] - matrix[0][2]*matrix[1][1];
    cofactor.matrix[2][1] = -1*(matrix[0][0]*matrix[1][2] - matrix[0][2]*matrix[1][0]);
    cofactor.matrix[2][2] =     matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];

    // Return the new matrix
    return cofactor;
  }

  // Calculates the inverse of a matrix
  public Matrix inverseOfMatrix() {
    // Call the other methods we need to make this work
    Matrix inverse = new Matrix();
    Matrix transpose = transpose();
    double determinant = determinant();
    //Calculate the inverse
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        inverse.matrix[i][j] = ((1.0/determinant)*transpose.matrix[i][j]);
      }
    }

    // Return the new matrix
    return inverse;
  }

  // Method to take the sum of two matricess
  public Matrix add(Matrix addend) {
    // Initialize our resultant matrix
    Matrix sum = new Matrix();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        // Sum the values of the elements of the two
        sum.matrix[i][j] = this.matrix[i][j] + addend.matrix[i][j];
      }
    }

    // Return the new matrix
    return sum;
  }

  // Method to take the product of two matrices
  public Matrix multiply(Matrix multiplicand) {
    // Initialize our resultant matrix
    Matrix product = new Matrix();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        // Calculates the product using  a formula derived in the documentation
        // See documentation, section X.X.X for more information
        product.matrix[i][j] = this.matrix[i][0]*multiplicand.matrix[0][j]
                             + this.matrix[i][1]*multiplicand.matrix[1][j]
                             + this.matrix[i][2]*multiplicand.matrix[2][j];
      }
    }

    // Return the new matrix
    return product;
  }

  // Method to find the sample standard deviation of the main diagonals
  public double standardDeviation(Matrix second) {
    // Initialize our mean
    double mean = 0;
    // Calculates the mean of the diagonals
    // See documentation, section X.X.X for more information
    for (int i = 0; i < 3; i++) {
      mean += this.matrix[i][i] + second.matrix[i][i];
    }
    // Divide the sum by the number of elements summed
    mean /= 6.0;

    // Initialize our variance
    double variance = 0.0;
    // Calculates the variance of the elements of the diagonals
    // See documentation, section X.X.X for more information
    for (int i = 0; i < 3; i++) {
      // Calculates the mean of the diagonals
      // See documentation, section X.X.X for more information
      variance += Math.pow(((this.matrix[i][i] - mean)), 2.0) +
                  Math.pow(((second.matrix[i][i] - mean)), 2.0);
    }
    // Divide the variance by the number of elements summed
    variance /= 5.0;

    // Return the standard deviation of the elements
    return Math.sqrt(variance);
  }

  // Method to print
  public static void print(int a[][], String console) throws IOException {
    // Print out the matrix
    System.out.println("The "+console+" of the matrix is: ");
    printMatrixToConsole(a);
  }

  // Method to print
  public static void print(int a[][], String console, String filename) throws IOException {
    // Print out the matrix
    System.out.println("The "+console+" of the matrix is: ");
    printMatrixToConsole(a);
    printMatrixToFile(a, filename);
  }

  // Method to print
  public static void print(double a[][], String console) throws IOException {
    // Print out the matrix
    System.out.println("The "+console+" of the matrix is: ");
    printMatrixToConsole(a);
  }

  // Method to print
  public static void print(double a[][], String console, String filename) throws IOException {
    // Print out the matrix
    System.out.println("The "+console+" of the matrix is: ");
    printMatrixToConsole(a);
    printMatrixToFile(a, filename);
  }

  // Method to print a matrix to console
  public static void printMatrixToConsole(int a[][]) {
    for (int i = 0; i < 3; i++) {
      System.out.println(a[i][0] + " " + a[i][1] + " " + a[i][2]);
    }
  }

  // Method to print a matrix to console
  public static void printMatrixToConsole(double a[][]) {
    for (int i = 0; i < 3; i++) {
      System.out.println(a[i][0] + " " + a[i][1] + " " + a[i][2]);
    }
  }

  // Method to print a matrix to file
  public static void printMatrixToFile(int a[][], String filename) throws IOException {
    FileWriter tmpFile = new FileWriter(filename);
    BufferedWriter tempBW = new BufferedWriter(tmpFile);
    PrintWriter tempPW = new PrintWriter(tempBW);
    for (int i = 0; i < 3; i++) {
      tempPW.println(a[i][0] + " " + a[i][1] + " " + a[i][2]);
    }

    // Close the output file streams
    tempPW.flush();
    tempPW.close();
  }

  // Method to print a matrix to file
  public static void printMatrixToFile(double a[][], String filename) throws IOException {
    FileWriter tmpFile = new FileWriter(filename);
    BufferedWriter tempBW = new BufferedWriter(tmpFile);
    PrintWriter tempPW = new PrintWriter(tempBW);
    for (int i = 0; i < 3; i++) {
      tempPW.println(a[i][0] + " " + a[i][1] + " " + a[i][2]);
    }

    // Close the output file streams
    tempPW.flush();
    tempPW.close();
  }

  // Method to print an integer to file
  public static void printNumberToFile(int a, String filename) throws IOException {
    FileWriter tmpFile = new FileWriter(filename);
    BufferedWriter tempBW = new BufferedWriter(tmpFile);
    PrintWriter tempPW = new PrintWriter(tempBW);
    tempPW.println(a);

    // Close the output file streams
    tempPW.flush();
    tempPW.close();
  }

  // Method to print an double to file
  public static void printNumberToFile(double a, String filename) throws IOException {
    FileWriter tmpFile = new FileWriter(filename);
    BufferedWriter tempBW = new BufferedWriter(tmpFile);
    PrintWriter tempPW = new PrintWriter(tempBW);
    tempPW.println(a);

    // Close the output file streams
    tempPW.flush();
    tempPW.close();
  }
} // end class
