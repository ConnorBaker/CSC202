/*
*  Package Name: matrices
*  File Name: Main.java
*
*  Author: Connor Baker, Rae Bouldin
*  Version: 0.3a
*  Created: November 14, 2016
*  Last Updated: November 19, 2016
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
    // Create our two initial matrices
    Matrix matrix1 = new Matrix();
    Matrix matrix2 = new Matrix(".\\matrices\\matrix2.txt");

    // Calculate the sum of the matrices
    Matrix.sumOfMatrices(matrix1.matrix, matrix2.matrix,
        ".\\matrices\\sumofmatrices.txt");

    // Calculate the transpose, cofactor, determinant, and inverse of the sum matrix
    Matrix matrix3 = new Matrix(".\\matrices\\sumofmatrices.txt");
    Matrix.transposeOfMatrix(matrix3.matrix, ".\\matrices\\transposeofmatrix1.txt");
    Matrix.cofactorOfMatrix(matrix3.matrix, ".\\matrices\\cofactormatrix1.txt");
    Matrix.determinantOfMatrix(matrix3.matrix, ".\\matrices\\determinant1.txt");
    matrix3.inverseOfMatrix(".\\matrices\\inversematrix1.txt");

    // Calculate the product of the matrices
    Matrix.productOfMatrices(matrix1.matrix, matrix2.matrix,
    ".\\matrices\\productofmatrices.txt");

    // Calculate the transpose, cofactor, determinant, and inverse of the product matrix
    Matrix matrix4 = new Matrix(".\\matrices\\productofmatrices.txt");
    Matrix.transposeOfMatrix(matrix4.matrix, ".\\matrices\\transposeofmatrix2.txt");
    Matrix.cofactorOfMatrix(matrix4.matrix, ".\\matrices\\cofactormatrix2.txt");
    Matrix.determinantOfMatrix(matrix4.matrix, ".\\matrices\\determinant2.txt");
    matrix4.inverseOfMatrix(".\\matrices\\inversematrix2.txt");
  } // end main()
} // end class Main
