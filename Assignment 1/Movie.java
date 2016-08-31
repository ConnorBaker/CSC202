/*
*  Author: Connor Baker
*  Version: 0.7a
*  Created: August 31, 2016
*  Last Updated: August 31, 2016
*
*  Description: Take input from command line (after sanitization) and pipe to
*  methods. We ask a user to input information about a movie and then print it
*  back out to them (with a bit of extra formatting).
*/

// Import necessary packages
import java.util.Scanner;

public class Movie {
  // Initialize all necessary variables for class Movie
  double like;
  String name;
  String star;
  String rating;
  String showTime;
  String length;

  // Default constructor for Movie
  Movie() {
    like = 5.0;
    name = "The Life of Connor Baker";
    star = "Connor Baker";
    rating = "G";
    showTime = "8:30pm";
    length = "2h30m";
  }

  // Argumented constructor for Movie
  Movie(String argumentedName, String argumentedStar, String argumentedRating, String argumentedShowTime, String argumentedLength, double argumentedLike) {
    like = argumentedLike;
    name = argumentedName;
    star = argumentedStar;
    rating = argumentedRating;
    showTime = argumentedShowTime;
    length = argumentedLength;
  }

  void setLike() {

  }

  void setName() {

  }

  void setStar() {

  }

  void setRating() {

  }

  void setShowTime() {

  }

  void setLength() {

  }

  void displayLike() {
    System.out.println(like);
  }

  void displayName() {
    System.out.println(name);
  }

  void displayStar() {
    System.out.println(star);
  }

  void displayRating() {
    System.out.println(rating);
  }

  void displayShowtime() {
    System.out.println(showTime);
  }

  void displayLength() {
    System.out.println(length);
  }

  void displayAllAttributes() {
    displayLike();
    displayName();
    displayStar();
    displayRating();
    displayShowtime();
    displayLength();
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Do you wish to enter details about a movie? Type YES or NO, followed by the ENTER key: ");
    String useArgumentedConstructor = scanner.nextLine();


    // Determine whether to use the default constructor or not
    if (useArgumentedConstructor.equalsIgnoreCase("yes")) {
      // Create an array of strings to hold arguments to pass to the augmented
      // movie constructor
      String[] arguments = new String[5];

      // Create a list of prompts to display for each iteration of our loop
      String[] arrayOfPrompts = {
        "Please enter the title of the movie, followed by the ENTER key: ",
        "Please enter the lead actor/actress, followed by the ENTER key: ",
        "Please enter the MPAA rating, followed by the ENTER key: ",
        "Please enter the show time of the movie, followed by the ENTER key: ",
        "Please enter the length of the movie, followed by the ENTER key: ",
        "Please enter the rating of the movie (out of 5.0), followed by the ENTER key: "
      };

      // Use a for loop to grab user input for the arguments array
      for (int i = 0; i < arrayOfPrompts.length - 1; i++) {
        System.out.println(arrayOfPrompts[i]);
        arguments[i] = scanner.nextLine();
      }

      // Grab the last of the inputs, a double for critic rating
      System.out.println(arrayOfPrompts[5]);
      double newLike = scanner.nextDouble();

      // Make sure to close the scanner
      scanner.close();

      // Create the argumented constructor
      Movie newMovie = new Movie(arguments[0], arguments[1], arguments[2], arguments[3], arguments[4], newLike);

      // Print everything from the constructor
      newMovie.displayAllAttributes();

    } else if (useArgumentedConstructor.equalsIgnoreCase("no")) {
      // Create the default constructor
      Movie newMovie = new Movie();

      // Print everything from the constructor
      newMovie.displayAllAttributes();
    } else {
      System.out.println("You didn't type YES or NO. It isn't case senstive.");
    }
  }
}
