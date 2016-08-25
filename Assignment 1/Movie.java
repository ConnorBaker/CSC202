/*
*  Author: Connor Baker
*  Version: 0.1a
*  Created: August 25, 2016
*  Last Updated: August 25, 2016
*
*  Description: Take input from command line (after sanitization) and pipe to
*  methods. We ask a user to input information about a movie and then print it
*  back out to them.
*
*  TODO: Make it all work.
*/

// Import necessary packages
import java.util.Scanner;

public class Movie {
  // Initialize all variables used in class Movie
  double like = 0.0; // Review by critics/fans out of 5.0

  // /*
  // * Initialize all strings used in the class Movie (they are immutable), which
  // * poses a problem to us in terms of modifying them from the default
  // * constructor
  // */
  // String name = null; // Name of the movie
  // String star = null; // Lead actor/actress of the movie
  // String rating = null; // MPAA rating assigned to the movie
  // String showTime = null; // Time at which the movie plays
  // String length = null; // The duration of the movie

  // Default constructor for Movie
  Movie() {
    // name = "The Life of Connor Baker";
    // star = "Connor Baker";
    // rating = "G";
    like = 5.0;
    // showTime = "8:30pm";
    // length = "2h30m";
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
  //
  // String getName() {
  //   return name;
  // }
  //
  // void setStar(String newStar) {
  //
  // }
  //
  // String getStar() {
  //   return star;
  // }
  //
  // void setRating(String newRating) {
  //
  // }
  //
  // String getRating() {
  //   return rating;
  // }
  //
  void setLike(double newLike) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please input the rating of the movie (out of 5.0), and then press the ENTER key");
    newLike = scanner.nextDouble();
    scanner.close();
  }

  double getLike() {
    return like;
  }
  //
  // void setShowTime(String newShowTime) {
  //
  // }
  //
  // String getShowTime() {
  //   return showTime;
  // }
  //
  // void setLength(String newLength) {
  //
  // }
  //
  // String getLength() {
  //   return length;
  // }

  public static void main(String[] args) {
    Movie newMovie = new Movie();
    System.out.println(getLike());
  }
}
