package org.openbravo.functional.finder;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openbravo.functional.dataset.StreamingServiceStore;
import org.openbravo.functional.model.Movie;
import org.openbravo.functional.model.StreamingService;

public class MovieFinderShould extends StreamingServiceStore {

  @Test
  public void getLongFilms() throws IOException, URISyntaxException {
    StreamingService nlp = getStreamingService();
    List<Movie> movies = new ArrayList<Movie>(nlp.getMovies().values());
    MovieFinder movieFinder = new MovieFinder();

    List<Movie> longFilms = movieFinder
        .getLongMovies(movies);

    assertEquals("There should be 2 long films", 2, longFilms.size());
  }

  @Test
  public void getComedies() throws IOException, URISyntaxException {
    StreamingService nlp = getStreamingService();
    List<Movie> movies = new ArrayList<Movie>(nlp.getMovies().values());
    MovieFinder movieFinder = new MovieFinder();

    List<Movie> longFilms = movieFinder
            .getComedies(movies);

    assertEquals("There should be 3 long films", 3, longFilms.size());
  }

}
