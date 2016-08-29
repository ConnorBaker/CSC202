/*
*  Author: Connor Baker
*  Version: 0.2a
*  Created: August 29, 2016
*  Last Updated: August 29, 2016
*
*  Description: Take input from command line (after sanitization) and pipe to
*  methods. We ask a user to input information about a movie and then print it
*  back out to them.
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
*/

// Import necessary packages
import java.util.Scanner;

public class Movie {
  // Initialize all variables used in class Movie
  double like = 0.0; // Review by critics/fans out of 5.0

  // /*
  // *  Initialize all strings used in the class Movie (they are immutable),
  // *  which
  // *  poses a problem to us in terms of modifying them from the default
  // *  constructor
  // */
  // String name = null; // Name of the movie
  // String star = null; // Lead actor/actress of the movie
  // String rating = null; // MPAA rating assigned to the movie
  // String showTime = null; // Time at which the movie plays
  // String length = null; // The duration of the movie

  // Default constructor for Movie
  Movie() {
    String name = "The Life of Connor Baker";
    String star = "Connor Baker";
    String rating = "G";
    like = 5.0;
    String showTime = "8:30pm";
    String length = "2h30m";
  }

  // Argumented constructor for Movie
  // Movie(String newName, String newStar, String newRating, double newLike, String newShowTime, String newLength) {
  Movie(double newLike) {
    // name = newName;
    // star = newStar;
    // rating = newRating;
    like = newLike;
    // showTime = newShowTime;
    // length = newLength;
  }

  // void setName(String newName) {
  //   Scanner scanner = new Scanner(System.in);
  //   System.out.println("Please input the name of the movie, and the press the ENTER key");
  //   newName = scanner.next();
  //   scanner.close();
  //   return newName;
  // }

  void displayName() {
    System.out.println(name);
  }

  // void setStar(String newStar) {
  //
  // }

  void displayStar() {
    System.out.println(star);
  }

  // void setRating(String newRating) {
  //
  // }

  void displayRating() {
    System.out.println(rating);
  }

  void setLike(double newLike) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please input the rating of the movie (out of 5.0), and then press the ENTER key");
    newLike = scanner.nextDouble();
    scanner.close();
  }

  void displayLike() {
    System.out.println(like);
  }

  // void setShowTime(String newShowTime) {
  //
  // }

  void displayShowTime() {
    System.out.println(showTime);
  }

  // void setLength(String newLength) {
  //
  // }

  void displayLength() {
    System.out.println(length);
  }

  public static void main(String[] args) {
    Movie newMovie = new Movie();
    newMovie.displayName();
    newMovie.displayStar();
    newMovie.displayRating();
    newMovie.displayLike();
    newMovie.displayShowTime();
    newMovie.displayLength();
  }
}
