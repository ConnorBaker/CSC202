/*
*  Author: Connor Baker
*  Version: 0.6a
*  Created: August 29, 2016
*  Last Updated: August 29, 2016
*
*  Description: Take input from command line (after sanitization) and pipe to
*  methods. We ask a user to input information about a movie and then print it
*  back out to them (with a bit of extra formatting).
*
*  TODO: Strings are immutable. If I want to modify them I have to create a new
*  object. Doing this introduces a new name to keep track of. Find a way to
*  either modify the String using a Java class or make a new string equal to
*  the desired modified string, set the old string equal to null to for GC, and
*  then set the new string equal to the old String's name (which takes care of
*  the name changing).
*
*  TODO: Implement the argumented constructor. Currently the program does not
*  accept user input.
*
*  TODO: Anwari likes to see the input printed out after being input ("You
*  entered:" kind of thing).
*/

// Import necessary packages
import java.util.Scanner;

public class Movie {
  // Initialize all variables used in class Movie
  double like = 0.0; // Review by critics/fans out of 5.0

  String name = "";
  String star = "";
  String rating = "";
  String showTime = "";
  String length = "";

  // Default constructor for Movie
  Movie() {
    String name = "The Life of Connor Baker";
    String star = "Connor Baker";
    String rating = "G";
    String showTime = "8:30pm";
    String length = "2h30m";
    like = 5.0;
  }

  // Argumented constructor for Movie
  // Movie(String newName, String newStar, String newRating, double newLike, String newShowTime, String newLength) {
  Movie(String name, double like) {
    name = setName("");
    // String newStar = setStar();
    // String newRating = setRating();
    // String newShowTime = setShowTime();
    // String newLength = setLength();
    // like = setLike();
  }

  String setName(String newName) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please input the name of the movie, and the press the ENTER key");
    newName = scanner.nextLine();
    scanner.close(); // Make sure to close the scanner
    return newName;
  }

  void displayName() {
    System.out.println("Movie Title: " + name);
  }

  // void setStar(String newStar) {
  //   Scanner scanner = new Scanner(System.in);
  //   System.out.println("Please input the name of the movie, and the press the ENTER key");
  //   star = scanner.next();
  //   scanner.close(); // Make sure to close the scanner
  // }
  //
  // void displayStar() {
  //   System.out.println("Leading Actor/Actress: " + star);
  // }
  //
  // void setRating(String newRating) {
  //   Scanner scanner = new Scanner(System.in);
  //   System.out.println("Please input the name of the movie, and the press the ENTER key");
  //   rating = scanner.next();
  //   scanner.close(); // Make sure to close the scanner
  // }
  //
  // void displayRating() {
  //   System.out.println("MPAA Rating: " + rating);
  // }
  //
  // void setShowTime(String newShowTime) {
  //   Scanner scanner = new Scanner(System.in);
  //   System.out.println("Please input the name of the movie, and the press the ENTER key");
  //   showTime = scanner.next();
  //   scanner.close(); // Make sure to close the scanner
  // }
  //
  // void displayShowTime() {
  //   System.out.println("Movie Starts at: " + showTime);
  // }
  //
  // void setLength(String newLength) {
  //   Scanner scanner = new Scanner(System.in);
  //   System.out.println("Please input the name of the movie, and the press the ENTER key");
  //   length = scanner.next();
  //   scanner.close(); // Make sure to close the scanner
  // }
  //
  // void displayLength() {
  //   System.out.println("Movie Runtime: " + length);
  // }

  void setLike() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please input the rating of the movie (out of 5.0), and then press the ENTER key");
    like = scanner.nextDouble();
    scanner.close(); // Make sure to close the scanner
  }

  void displayLike() {
    System.out.println("Critics Review (out of 5.0): " + like);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Do you wish to enter details about a movie? Type YES or NO and then press ENTER.");
    String useArgumentedConstructor = scanner.nextLine();
    if (useArgumentedConstructor.equalsIgnoreCase("yes")) {
      Movie newMovie = new Movie();
      // newMovie.setLike();
      newMovie.setName();
      // newMovie.setStar();
      // newMovie.setRating();
      // newMovie.setLike();
      // newMovie.setShowTime();
      // newMovie.setLength();
      newMovie.displayLike();
      newMovie.displayName();
      // newMovie.displayStar();
      // newMovie.displayRating();
      // newMovie.displayLike();
      // newMovie.displayShowTime();
      // newMovie.displayLength();
    } else if (useArgumentedConstructor.equalsIgnoreCase("no")) {
      Movie newMovie = new Movie();
      newMovie.displayLike();
      newMovie.displayName();
      // newMovie.displayStar();
      // newMovie.displayRating();
      // newMovie.displayLike();
      // newMovie.displayShowTime();
      // newMovie.displayLength();
    } else {

    }
    scanner.close(); // Make sure to close the scanner
  }
}
