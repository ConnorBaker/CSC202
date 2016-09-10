/*
*  Author: Connor Baker
*  Version: 0.9c
*  Created: August 31, 2016
*  Last Updated: September 10 , 2016
*
*  Description: Take input from command line and pipe to the argumented
*  constructor. We ask a user to input information about a movie and then print
*  it back out to them (with a bit of extra formatting).
*
*  TODO: Make sure that we check for a correct value with like (and that the
*  user doesn't input something like 'kitty' instead of a valid double).
*  Consider switching over to using a String instead.
*/

// Import necessary packages
import java.util.Scanner;

public class Movie {
  // Initialize all necessary variables for class Movie
  double like; // Critic rating out of five stars
  String name; // Name of the movie
  String star; // Lead actor/actress
  String rating; // MPAA assigned rating (G, PG, etc.)
  String showTime; // Time the movie begins playing
  String length; // Duration of the movie

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
  Movie(String argumentedName, String argumentedStar, String argumentedRating,
    String argumentedShowTime, String argumentedLength, double argumentedLike) {
    like = argumentedLike;
    name = argumentedName;
    star = argumentedStar;
    rating = argumentedRating;
    showTime = argumentedShowTime;
    length = argumentedLength;
  }

  // Method that prints variable name to terminal
  void displayName() {
    System.out.print("\n\nYou've entered the movie " + name + ", ");
  }

  // Method that prints variable star to terminal
  void displayStar() {
    System.out.print("starring the well-loved " + star + " as the lead. \n");
  }

  // Method that prints variable like to terminal
  void displayLike() {
    System.out.print("Critics have given this movie a " + like + " out of five"
      + " stars. \n");
  }

  // Method that prints variable rating to terminal
  void displayRating() {
    System.out.print("The MPAA has rated this movie " + rating + ", so be sure"
      + " to keep that in mind when purchasing tickets. \n");
  }

  // Method that prints variable showTime to terminal
  void displayShowtime() {
    System.out.print("The show-time that you're interested in is at " +
      showTime + ", ");
  }

  // Method that prints variable length to terminal
  void displayLength() {
    System.out.print("and it runs for a total of " + length+ ". \n");
  }

  // Method that calls all other display methods
  void displayAllAttributes() {
    displayName();
    displayStar();
    displayLike();
    displayRating();
    displayShowtime();
    displayLength();
  }

  public static void main(String[] args) {

    // Create scanner to grab input from user
    Scanner scanner = new Scanner(System.in);
    System.out.println("Do you wish to enter details about a movie? Type YES"
      + " or NO, followed by the ENTER key: ");
    String useArgumentedConstructor = scanner.nextLine();

    // Determine whether to use the default constructor or not
    if (useArgumentedConstructor.equalsIgnoreCase("yes")) {
      // Create an array of strings to hold arguments to pass to the constructor
      String[] arguments = new String[5];

      // Create a list of prompts to display for each iteration of our loop
      String[] arrayOfPrompts = {
        "Please enter the name of the movie, followed by the ENTER key: ",
        "Please enter the lead actor/actress, followed by the ENTER key: ",
        "Please enter the MPAA rating, followed by the ENTER key: ",
        "Please enter the show time of the movie, followed by the ENTER key: ",
        "Please enter the length of the movie, followed by the ENTER key: ",
        "Please enter the rating of the movie (out of 5.0), followed by the"
          + " ENTER key: "
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
      Movie newMovie = new Movie(arguments[0], arguments[1], arguments[2],
        arguments[3], arguments[4], newLike);

      // Print everything from the argumented constructor
      newMovie.displayAllAttributes();

    } else if (useArgumentedConstructor.equalsIgnoreCase("no")) {
      // Create the default constructor
      Movie newMovie = new Movie();

      // Print everything from the default constructor
      newMovie.displayAllAttributes();
    } else {
      // Warn the user that they didn't input a valid option
      System.out.println("You didn't type YES or NO. Run the program again.");
    }
  }
}
