package org.openbravo.functional.finder;

import java.util.ArrayList;
import java.util.List;

import org.openbravo.functional.model.Movie;

public class MovieFinder {

  public List<Movie> getLongMovies(List<Movie> movies) {
    return filterMovies(movies, movie -> movie.getDuration() >= 120);
  }

  public List<Movie> getComedies(List<Movie> movies) {
    return filterMovies(movies, movie -> movie.getGenre().equals("Comedy"));
  }

  public List<Movie> filterMovies(List<Movie> allMovies, MovieFilter filter) {
    List<Movie> filteredMovies = new ArrayList<>();
    for (Movie movie : allMovies) {
      if (filter.applies(movie)) {
        filteredMovies.add(movie);
      }
    }
    return filteredMovies;
  }

  private interface MovieFilter {
    boolean applies(Movie movie);
  }

}
