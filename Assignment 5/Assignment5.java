/*
*  Project name: Assignment5.java
*
*  Author: Connor Baker
*  Version: 0.5c
*  Created: October 22, 2016
*  Last Updated: October 24, 2016
*
*  Summary of problem specification:
*  Creates a file named dbs3.txt using FileWriter, with input sent via
*  BufferedWriter passing to PrintWriter. Using seven wrapper classes, create a
*  text based database that holds user-inputted information. The fields are:
*  lastName, firstName, employmentStatus, age, identificationNumber, salary.
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
*  http://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline
*    -after-using-next-nextint-or-other-nextfoo
*/

// Import necessary packages
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Assignment5 {
  // Create an arrays to hold user-inputted records
  String lastName[] = new String[10];
  String firstName[] = new String[10];
  boolean employmentStatus[] = new boolean[10];
  int identificationNumber[] = new int[10];
  int age[] = new int[10];
  double salary[] = new double[10];

  // Create a scanner to grab user input
  Scanner grabInput = new Scanner(System.in);

  // Create a String holding the database's filename
  String filename = "dbs3.txt";

  // Create a boolean telling us whether the file exists
  boolean appendMode;

  // Create a default constructor to hold the database
  Assignment5(int indexInitial, int indexFinal) {
    fillArrays(indexInitial, indexFinal);
  }

  // Create a method to call
  public void fillArrays(int indexInitial, int indexFinal) {
    for (int i = indexInitial; i < indexFinal; i++) {
    identificationNumber(i);
    lastName(i);
    firstName(i);
    age(i);
    employmentStatus(i);
    salary(i);
    }
  }

  // Method to print contents of file to terminal (accepts arguments)
  public void printFromFile(int indexInitial, int indexFinal)
    throws FileNotFoundException, IOException {
    // Create objects used to read from file
    FileReader fr = new FileReader(filename);
    BufferedReader br = new BufferedReader(fr);
    StringBuffer inputString;

    // Display the content of the file
    for (int i = indexInitial; i < indexFinal; i++) {
      inputString = new StringBuffer(br.readLine());
      System.out.println(inputString);
    }
    // Close input streams when done
    br.close();
    fr.close();
  }

  // Method to print user-inputted records to file (accepts arguments)
  public void printArraysToFile(int indexInitial, int indexFinal)
    throws IOException {
    // Check whether the file exists, and whether to use append mode
    appendMode = doesFileExist();
    System.out.println(appendMode);

    // Create the database
    FileWriter fw = new FileWriter(filename, appendMode);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter pw = new PrintWriter(bw);

    // Write header if initial write
    if (appendMode == false) {
      pw.print("Last\t");
      pw.print("First\t");
      pw.print("Age\t");
      pw.print("FTE\t"); // Full Time Employment
      pw.print("ID #\t");
      pw.print("Salary");
      pw.println();
    }

    for (int i = indexInitial; i < indexFinal; i++) {
      // Loop through all records, one row at a time
      pw.print(lastName[i] + "\t");
      pw.print(firstName[i] + "\t");
      pw.print(age[i] + "\t");
      pw.print(employmentStatus[i] + "\t");
      pw.print(identificationNumber[i] + "\t");
      pw.println(salary[i]);
    }
    // Close output streams
    // pw.close();
    bw.flush();
    bw.close();
    fw.close();
  }

  // Method to grab user-inputted last name
  public void lastName(int index) {
    System.out.println("Please input employee's last name: ");
    lastName[index] = grabInput.nextLine();
  }

  // Method to grab user-inputted first name
  public void firstName(int index) {
    System.out.println("Please input employee's first name: ");
    firstName[index] = grabInput.nextLine();
  }

  // Method to grab user-inputted age
  public void age(int index) {
    System.out.println("Please input employee's age: ");
    age[index] = Integer.parseInt(grabInput.nextLine());
  }

  // Method to grab user-inputted employment status
  public void employmentStatus(int index) {
    System.out.println("Please input employee's employment status: ");
    employmentStatus[index] = Boolean.parseBoolean(grabInput.nextLine());
  }

  // Method to grab user-inputted ID #
  public void identificationNumber(int index) {
    System.out.println("Please input employee's ID#: ");
    identificationNumber[index] = Integer.parseInt(grabInput.nextLine());
  }

  // Method to grab user-inputted salary
  public void salary(int index) {
    System.out.println("Please input employee's salary: ");
    salary[index] = Double.parseDouble(grabInput.nextLine());
  }

  // Method to determine whether to use append with FileWriter
  public boolean doesFileExist() {
    // Check if the file already exists
    File tempFile = new File(filename);
    boolean fileExists = tempFile.isFile();

    // Return the boolean
    return fileExists;
  }

  public static void main(String args[]) throws IOException {
    // Create the object and populate with initial records
    Assignment5 dbs3 = new Assignment5(0, 6);
    dbs3.printArraysToFile(0, 6);
    dbs3.printFromFile(0, 6);

    // Add more records to the database
    dbs3.fillArrays(6, 9);
    dbs3.printArraysToFile(6, 9);
    dbs3.printFromFile(0, 9);
  }
}
