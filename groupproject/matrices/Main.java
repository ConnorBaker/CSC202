/*
*  Package Name: matrices
*  File Name: Main.java
*
*  Author: Connor Baker, Rae Bouldin
*  Version: 0.6a
*  Created: November 14, 2016
*  Last Updated: November 28, 2016
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
    Matrix matrix1 = Matrix.readMatrixFromFile(".\\matrices\\matrix1.txt");
    Matrix matrix2 = Matrix.readMatrixFromFile(".\\matrices\\matrix2.txt");

    // Calculate the standard deviation of the two inputted matrice's main diagonals
    Matrix.printNumberToFile(matrix1.standardDeviation(matrix2),
        ".\\matrices\\standardDeviation.txt");

    // Calculate the sum of the matrices and print it to file
    Matrix sum = matrix1.add(matrix2);
    Matrix.printMatrixToFile(sum, ".\\matrices\\sum.txt");

    // Calculate the transpose of the sum and print it to file
    Matrix transposeOfSum = sum.transpose();
    Matrix.printMatrixToFile(transposeOfSum,".\\matrices\\transposeofsum.txt");

    // Calculate the cofactor of the sum and print it to file
    Matrix cofactorOfSum = sum.cofactor();
    Matrix.printMatrixToFile(cofactorOfSum,".\\matrices\\cofactorofsum.txt");

    // Calculate the determinant of the sum
    double determinantOfSum = sum.determinant();
    Matrix.printNumberToFile(determinantOfSum, ".\\matrices\\determinantofsum.txt");

    // Calculate the inverse of the sum and print it to file
    Matrix inverseOfSum = sum.inverse();
    Matrix.printMatrixToFile(inverseOfSum,".\\matrices\\inverseofsum.txt");

    // Calculate the product of the matrices and print it to file
    Matrix product = matrix1.multiply(matrix2);
    Matrix.printMatrixToFile(product, ".\\matrices\\product.txt");

    // Calculate the transpose of the product and print it to file
    Matrix transposeOfproduct = product.transpose();
    Matrix.printMatrixToFile(transposeOfproduct,".\\matrices\\transposeofproduct.txt");

    // Calculate the cofactor of the product and print it to file
    Matrix cofactorOfproduct = product.cofactor();
    Matrix.printMatrixToFile(cofactorOfproduct,".\\matrices\\cofactorofproduct.txt");

    // Calculate the determinant of the product
    double determinantOfproduct = product.determinant();
    Matrix.printNumberToFile(determinantOfproduct,
        ".\\matrices\\determinantofproduct.txt");

    // Calculate the product of the sum and the first column of the product
  double inverseOfSumTimesProductColumn[] = inverseOfSum.multiplyByColumn(product);
     Matrix.printMatrixToFile(inverseOfSumTimesProductColumn,
         ".\\matrices\\inverseOfSumTimesProductColumn.txt");

    // Calculate the inverse of the product and print it to file
    Matrix inverseOfproduct = product.inverse();
    Matrix.printMatrixToFile(inverseOfproduct,".\\matrices\\inverseofproduct.txt");
  } // end main()
} // end class Main
