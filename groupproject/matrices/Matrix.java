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

public class Matrix { // begin class TuningCircuit
  // Create our matrix for processing
  int matrix[][] = new int[3][3];
  int transpose[][] = new int[3][3];
  int cofactor[][] = new int[3][3];
  double inverse[][] = new double[3][3];
  int determinant;

  // Set up objects to grab input from the file
  File file;
  FileReader fr;
  BufferedReader br;

  // Set up objects to stream output to
  BufferedWriter bw;
  PrintWriter pw;

  // Default constructor for our object
  public Matrix() throws IOException {
    file = new File(".\\matrices\\matrix1.txt");
    fr = new FileReader(file);
    br = new BufferedReader(fr);
    readMatrixFromFile();
  }

  // Argumented constructor for our object
  public Matrix(String filename) throws IOException {
    file = new File(filename);
    fr = new FileReader(file);
    br = new BufferedReader(fr);
    readMatrixFromFile();
  }

  // Method to fill the matrix from file
  public void readMatrixFromFile() throws IOException {
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
  }

  // Method to take the determinant of a matrix
  public void determinantOfMatrix(int a[][]) {
    determinant =   a[0][0]*(a[1][1]*a[2][2]-a[1][2]*a[2][1])
                  - a[0][1]*(a[1][0]*a[2][2]-a[1][2]*a[2][0])
                  + a[0][2]*(a[1][0]*a[2][1]-a[1][1]*a[2][0]);
  }

  // Method to take the determinant of a matrix
  public void determinantOfMatrix(int a[][], String filename) throws IOException {
    determinant =   a[0][0]*(a[1][1]*a[2][2]-a[1][2]*a[2][1])
                  - a[0][1]*(a[1][0]*a[2][2]-a[1][2]*a[2][0])
                  + a[0][2]*(a[1][0]*a[2][1]-a[1][1]*a[2][0]);

    // Print out the matrix
    System.out.println("The determinant of the matrix is: " +determinant);
    printNumberToFile(determinant, filename);
  }

  // Method to take the transpose of a matrix
  public void transposeOfMatrix(int a[][]) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        // Simply swapping the element's position yeilds the transpose
        // See documentation, section X.X.X for more information
        transpose[i][j] = a[j][i];
      }
    }
  }

  // Method to take the transpose of a matrix
  public void transposeOfMatrix(int a[][], String filename) throws IOException {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        // Simply swapping the element's position yeilds the transpose
        // See documentation, section X.X.X for more information
        transpose[i][j] = a[j][i];
      }
    }
    // Print out the matrix
    print(transpose, "transpose", filename);
  }

  // Method to take the cafactor matrix of a matrix
  public void cofactorOfMatrix(int a[][]) {
    // Initialize our resultant matrix
    // Calculates the cofactor matrix using a formula derived in the documentation
    // See documentation, section X.X.X for more information
    cofactor[0][0] = a[1][1]*a[2][2] - a[1][2]*a[2][1];
    cofactor[0][1] = -1*(a[1][0]*a[2][2] - a[1][2]*a[2][0]);
    cofactor[0][2] = a[1][0]*a[2][1] - a[1][1]*a[2][0];
    cofactor[1][0] = -1*(a[0][1]*a[2][2] - a[0][2]*a[2][1]);
    cofactor[1][1] = a[0][0]*a[2][2] - a[0][2]*a[2][0];
    cofactor[1][2] = -1*(a[0][0]*a[2][1] - a[0][1]*a[2][0]);
    cofactor[2][0] = a[0][1]*a[1][2] - a[0][2]*a[1][1];
    cofactor[2][1] = -1*(a[0][0]*a[1][2] - a[0][2]*a[1][0]);
    cofactor[2][2] = a[0][0]*a[1][1] - a[0][1]*a[1][0];
  }

  // Method to take the cafactor matrix of a matrix
  public void cofactorOfMatrix(int a[][], String filename) throws IOException {
    // Initialize our resultant matrix
    // Calculates the cofactor matrix using a formula derived in the documentation
    // See documentation, section X.X.X for more information
    cofactor[0][0] = a[1][1]*a[2][2] - a[1][2]*a[2][1];
    cofactor[0][1] = -1*(a[1][0]*a[2][2] - a[1][2]*a[2][0]);
    cofactor[0][2] = a[1][0]*a[2][1] - a[1][1]*a[2][0];
    cofactor[1][0] = -1*(a[0][1]*a[2][2] - a[0][2]*a[2][1]);
    cofactor[1][1] = a[0][0]*a[2][2] - a[0][2]*a[2][0];
    cofactor[1][2] = -1*(a[0][0]*a[2][1] - a[0][1]*a[2][0]);
    cofactor[2][0] = a[0][1]*a[1][2] - a[0][2]*a[1][1];
    cofactor[2][1] = -1*(a[0][0]*a[1][2] - a[0][2]*a[1][0]);
    cofactor[2][2] = a[0][0]*a[1][1] - a[0][1]*a[1][0];

    // Print out the matrix
    print(cofactor, "cofactor", filename);
  }

  // Calculates the inverse of a matrix
  public void inverseOfMatrix() throws IOException {
    // transposeOfMatrix(cofactor);
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        inverse[i][j] = ((1.0/determinant)*transpose[i][j]);
      }
    }
  }

  // Calculates the inverse of a matrix
  public void inverseOfMatrix(String filename) throws IOException {
    // transposeOfMatrix(cofactor);
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        inverse[i][j] = ((1.0/determinant)*transpose[i][j]);
      }
    }
    // Print out the matrix
    print(inverse, "inverse", filename);
  }

  // Method to take the sum of two matricess
  public static void sumOfMatrices(int a[][], int b[][], String filename) throws IOException {
    // Initialize our resultant matrix
    int c[][] = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        // Sum the values of the elements of the two
        c[i][j] = a[i][j] + b[i][j];
      }
    }
    // Print out the matrix
    print(c, "sum", filename);
  }

  // Method to take the product of two matrices
  public static void productOfMatrices(int a[][], int b[][], String filename) throws IOException {
    // Initialize our resultant matrix
    int c[][] = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        // Calculates the product using  a formula derived in the documentation
        // See documentation, section X.X.X for more information
        c[i][j] = a[i][0]*b[0][j] + a[i][1]*b[1][j] + a[i][2]*b[2][j];
      }
    }
    // Print out the matrix
    print(c, "product", filename);
  }

  // Method to find the sample standard deviation of the main diagonals
  public static void stdDeviation(int a[][], int b[][], String filename) throws IOException {
    // Initialize our mean
    double mean = 0;
    // Calculates the mean of the diagonals
    // See documentation, section X.X.X for more information
    for (int i = 0; i < 3; i++) {
      mean += a[i][i] + b[i][i];
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
      variance += Math.pow(((a[i][i] - mean)), 2.0) + Math.pow(((b[i][i] - mean)), 2.0);
    }
    // Divide the variance by the number of elements summed
    variance /= 5.0;

    // Calculate the standard deviation of the elements
    double stdDeviation = Math.sqrt(variance);

    // Print out the standard deviation
    System.out.println("The standard deviation of the main diagonals is: " +stdDeviation);
    printNumberToFile(stdDeviation, filename);
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
} // end class TuningCircuit
