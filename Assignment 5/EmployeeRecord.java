/*
*  Project name: EmployeeRecord.java
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
*  The ever-illuminating IllegalArgument of internet chatroom legends.
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
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeRecord {
  // Initialize some primitives
  String lastName, firstName;
  boolean employmentStatus;
  int age, identificationNumber;
  double salary;

  // Create a scanner to grab user input
  Scanner grabInput = new Scanner(System.in);

  // Create a String holding the database's filename
  String filename = "dbs3.txt";

  // Create a boolean telling us whether the file exists
  boolean appendMode;

  // Create an argumented constructor to hold employee information
  EmployeeRecord(String lastName, String firstName,
      boolean employmentStatus, int age, int identificationNumber,
      double salary) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.employmentStatus = employmentStatus;
    this.age = age;
    this.identificationNumber = identificationNumber;
    this.salary = salary;
  }

  public static void main(String args[]) {
    ArrayList<EmployeeRecord>;
  }
}
