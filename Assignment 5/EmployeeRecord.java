/*
*  Project name: EmployeeRecord.java
*
*  Author: Connor Baker
*  Version: 0.7a
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
  static Scanner grabInput = new Scanner(System.in);

  // Create a String holding the database's filename
  static String filename = "dbs3.txt";

  // Create a boolean telling us whether the file exists
  static boolean appendMode;

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

  // Create a new method that creates a new EmployeeRecord object
  public static EmployeeRecord createNewEmployeeRecord() {
    return new EmployeeRecord(getLastName(), getFirstName(),
        getEmploymentStatus(), getAge(), getID(), getSalary());
  }

  // Method to grab user-inputted last name
  public static String getLastName() {
    System.out.println("Please input employee's last name: ");
    String lastName = grabInput.nextLine();
    return lastName;
  }

  // Method to grab user-inputted first name
  public static String getFirstName() {
    System.out.println("Please input employee's first name: ");
    String firstName = grabInput.nextLine();
    return firstName;
  }

  // Method to grab user-inputted employment status
  public static boolean getEmploymentStatus() {
    System.out.println("Please input employee's employment status: ");
    boolean employmentStatus = Boolean.parseBoolean(grabInput.nextLine());
    return employmentStatus;
  }

  // Method to grab user-inputted age
  public static int getAge() {
    System.out.println("Please input employee's age: ");
    int age = Integer.parseInt(grabInput.nextLine());
    return age;
  }

  // Method to grab user-inputted ID #
  public static int getID() {
    System.out.println("Please input employee's ID#: ");
    int identificationNumber = Integer.parseInt(grabInput.nextLine());
    return identificationNumber;
  }

  // Method to grab user-inputted salary
  public static double getSalary() {
    System.out.println("Please input employee's salary: ");
    double salary = Double.parseDouble(grabInput.nextLine());
    return salary;
  }

  // Method to determine whether to use append with FileWriter
  public static boolean doesFileExist() {
    // Check if the file already exists
    File tempFile = new File(filename);
    boolean fileExists = tempFile.isFile();
    // Return the boolean
    return fileExists;
  }

  public String printEmployeeRecord() {
    return String.format("%s\t%s\t%d\t%b\t%d\t%.2f", lastName,
      firstName, age, employmentStatus, identificationNumber, salary);
  }

  // Method to print user-inputted records to file
  public static void printEmployeeRecordToFile(ArrayList<EmployeeRecord>
      record) throws IOException {
    // Check whether the file exists, and whether to use append mode
    appendMode = doesFileExist();
    // Create the database
    FileWriter fw = new FileWriter(filename, appendMode);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter pw = new PrintWriter(bw);
    for (EmployeeRecord iterator : record) {
      pw.println(iterator.printEmployeeRecord());
    }
    // Close output streams
    bw.flush();
    bw.close();
    fw.close();
  }

  // Method to print user-inputted records to screen
  public static void printEmployeeRecordToScreen(ArrayList<EmployeeRecord>  record) {
    for (EmployeeRecord iterator : record) {
      System.out.println(iterator.printEmployeeRecord());
    }
  }

  public static void main(String args[]) throws IOException {
    ArrayList<EmployeeRecord> records = new ArrayList<>();
    records.add(createNewEmployeeRecord());
    printEmployeeRecordToScreen(records);
    printEmployeeRecordToFile(records);
  }
}
