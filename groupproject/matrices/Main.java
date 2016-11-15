/*
*  Package Name: matrices
*  File Name: Main.java
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

public class Main { // begin class Main
  public static void main(String args[]) throws IOException { // begin main
    // Create our object
    Matrix matrix1 = new Matrix();
    Matrix matrix2 = new Matrix();
    int c[][] = productOfArrays(matrix1, matrix2);

  } // end main()
} // end class Main
