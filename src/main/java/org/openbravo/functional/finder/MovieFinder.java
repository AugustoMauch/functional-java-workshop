package org.openbravo.functional.finder;

import org.openbravo.functional.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieFinder {

  public List<Movie> getLongMovies(List<Movie> movies) {
    return filterMovies(movies, new LongMovieFilter());
  }

  public List<Movie> getComedies(List<Movie> movies) {
    return filterMovies(movies, new MovieFilter() {
      @Override
      public boolean applies(Movie movie) {
        return movie.getGenre().equals("Comedy");
      }
    });
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

  private class LongMovieFilter implements MovieFilter {
    @Override
    public boolean applies(Movie movie) {
      return movie.getDuration() >= 120;
    }
  }
}
