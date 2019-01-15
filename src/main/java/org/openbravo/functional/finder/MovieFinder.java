package org.openbravo.functional.finder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.openbravo.functional.model.Movie;

public class MovieFinder {

  public List<Movie> getLongMovies(List<Movie> movies) {
    return filterMovies(movies, movie -> movie.getDuration() >= 120);
  }

  public List<Movie> getComedies(List<Movie> movies) {
    return filterMovies(movies, movie -> movie.getGenre().equals("Comedy"));
  }

  public List<Movie> filterMovies(List<Movie> allMovies, Predicate<Movie> filter) {
    List<Movie> filteredMovies = new ArrayList<>();
    for (Movie movie : allMovies) {
      if (filter.test(movie)) {
        filteredMovies.add(movie);
      }
    }
    return filteredMovies;
  }

}
