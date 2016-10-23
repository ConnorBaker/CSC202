/*
*  Project name: Assignment5.java
*
*  Author: Connor Baker
*  Version: 0.1a
*  Created: October 22, 2016
*  Last Updated: October 22, 2016
*
*  Summary of problem specification:
*  Creates a file named dbs3.txt using FileWriter, with input sent via
*  BufferedWriter passing to PrintWriter. Using seven wrapper classes, create a
*  text based database that holds user-inputted information. The fields are:
*  firstName, lastName, identificationNumber, age, salary, employmentStatus.
*  After the file is created, send the contents to terminal. Then, add three
*  more records (with the author's being the third record), and display again.
*  Then, use StringTokenizer to convert to the proper type, sending to wrapper
*  classes. Finally, give everyone a 2% raise, and print to the terminal again.
*
*  Functionality:
*  Being expanded to meet problem specification.
*
*  Explanation of components:
*  See comments.
*
*  Assumptions made:
*  Java EA 9 didn't allow me to write anything that isn't backwards compliant
*  with the current version.
*
*  References used:
*  https://docs.oracle.com/javase/8/docs/
*/

// Import necessary packages
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Assignment5 {


  public static void main(String args[]) throws IOException {
    // Create a String holding the database's filename
    String filename = "dbs3.txt";

    // Check if the file already exists
    File tempFile = new File(filename);
    boolean fileExists = tempFile.isFile();

    // Print whether the file exists
    if (fileExists == false) {
      System.out.println(filename + " did not exist, and has been created.");
    } else {
      System.out.println(filename + " already exists. Using append mode.");
    }

    // Create the database
    FileWriter fw = new FileWriter(filename, fileExists);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter pw = new PrintWriter(bw);

    pw.println("File is no longer empty.");
    pw.close();
    System.out.println("File created.");
  }
}
