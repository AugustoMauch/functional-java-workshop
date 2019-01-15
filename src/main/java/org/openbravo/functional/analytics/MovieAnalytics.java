package org.openbravo.functional.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openbravo.functional.model.Movie;
import org.openbravo.functional.model.User;

public class MovieAnalytics {

  public boolean userHasWatchedMovie(User aUser, Movie aMovie) {
    return userInteractsWithMovie(aUser, aMovie,
        (user, movie) -> user.getWatchedMovies().contains(movie));
  }

  public boolean userWantsToWatchMovie(User aUser, Movie aMovie) {
    return userInteractsWithMovie(aUser, aMovie,
        (user, movie) -> user.getPendingMovies().contains(movie));
  }

  public boolean userInteractsWithMovie(User user, Movie movie, UserMovieInteraction interaction) {
    return interaction.interacts(user, movie);
  }

  private interface UserMovieInteraction {
    boolean interacts(User user, Movie movie);
  }

  public List<String> getTop3AcclaimedMovieTitlesOrderedByRating(List<Movie> movies) {
    List<Movie> acclaimedMovies = new ArrayList<>();
    for (Movie movie : movies) {
      if (movie.getScore() >= 9) {
        acclaimedMovies.add(movie);
      }
    }
    Collections.sort(acclaimedMovies, new Comparator<Movie>() {
      @Override
      public int compare(Movie o1, Movie o2) {
        return Double.compare(o2.getScore(), o1.getScore());
      }
    });
    List<String> movieTitles = new ArrayList<>();
    for (Movie movie : acclaimedMovies) {
      movieTitles.add(movie.getTitle());
      if (movieTitles.size() >= 3) {
        break;
      }
    }
    return movieTitles;
  }

  public int getSumDurationOfMoviesOfDirector(List<Movie> movies, String director) {
    int totalDuration = 0;
    for (Movie movie : movies) {
      if (director.equals(movie.getDirector())) {
        totalDuration += movie.getDuration();
      }
    }
    return totalDuration;
  }

  public double getAverageRatingOfGenre(List<Movie> movies, String genre) {
    int nComedies = 0;
    int sumRating = 0;
    for (Movie movie : movies) {
      if (genre.equals(movie.getGenre())) {
        nComedies++;
        sumRating += movie.getScore();
      }
    }
    return sumRating / nComedies;
  }

  public Map<String, List<Movie>> getMoviesByGenre(List<Movie> movies) {
    Map<String, List<Movie>> moviesByGenre = new HashMap<>();
    for (Movie movie : movies) {
      String genre = movie.getGenre();
      if (!moviesByGenre.containsKey(genre)) {
        moviesByGenre.put(genre, new ArrayList<>());
      }
      moviesByGenre.get(genre).add(movie);
    }
    return moviesByGenre;
  }

}
