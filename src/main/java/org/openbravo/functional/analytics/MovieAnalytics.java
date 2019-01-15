package org.openbravo.functional.analytics;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

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

  public boolean userInteractsWithMovie(User user, Movie movie,
      BiFunction<User, Movie, Boolean> interaction) {
    return interaction.apply(user, movie);
  }

  public List<String> getTop3AcclaimedMovieTitlesOrderedByRating(List<Movie> movies) {
    return movies.stream() //
        .filter(movie -> movie.getScore() >= 9) //
        .sorted(Comparator.comparing(Movie::getScore).reversed()) //
        .map(movie -> movie.getTitle()) //
        .limit(3) //
        .collect(Collectors.toList());
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
    return movies.stream() //
        .collect(Collectors.groupingBy(Movie::getGenre));
  }

}
