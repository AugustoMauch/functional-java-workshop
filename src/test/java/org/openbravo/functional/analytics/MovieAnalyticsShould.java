package org.openbravo.functional.analytics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.openbravo.functional.dataset.StreamingServiceStore;
import org.openbravo.functional.model.Movie;
import org.openbravo.functional.model.StreamingService;
import org.openbravo.functional.model.User;

public class MovieAnalyticsShould extends StreamingServiceStore {

  @Test
  public void getMoviesByGenre() throws IOException, URISyntaxException {
    StreamingService nlp = getStreamingService();
    List<Movie> movies = new ArrayList<Movie>(nlp.getMovies().values());
    MovieAnalytics analytics = new MovieAnalytics();

    Map<String, List<Movie>> moviesByGenre = analytics.getMoviesByGenre(movies);

    assertEquals("There should be 4 different genres", 4, moviesByGenre.keySet().size());
  }

  @Test
  public void getAverageRatingOfComedies() throws IOException, URISyntaxException {
    StreamingService nlp = getStreamingService();
    List<Movie> movies = new ArrayList<Movie>(nlp.getMovies().values());
    MovieAnalytics analytics = new MovieAnalytics();

    double averageRating = analytics.getAverageRatingOfGenre(movies, "Comedy");

    assertEquals("Wrong average rating of comedies", 8, averageRating, 0.0001);
  }

  @Test
  public void getTotalDurationOfScorseseMovies() throws IOException, URISyntaxException {
    StreamingService nlp = getStreamingService();
    List<Movie> movies = new ArrayList<Movie>(nlp.getMovies().values());
    MovieAnalytics analytics = new MovieAnalytics();

    int totalDuration = analytics.getSumDurationOfMoviesOfDirector(movies, "Martin Scorsese");

    assertEquals("Wrong average rating of comedies", 348, totalDuration);
  }

  @Test
  public void getTop3AcclaimedMovieTitlesOrderedByRatingShould() throws IOException,
      URISyntaxException {
    StreamingService nlp = getStreamingService();
    List<Movie> movies = new ArrayList<Movie>(nlp.getMovies().values());
    MovieAnalytics analytics = new MovieAnalytics();

    List<String> acclaimedMovieTitles = analytics
        .getTop3AcclaimedMovieTitlesOrderedByRating(movies);

    assertEquals("There should be X acclaimed movies", 3, acclaimedMovieTitles.size());
    assertEquals("Best rated movie should be Gangs of New York", "Gangs of New York",
        acclaimedMovieTitles.get(0));
  }

  @Test
  public void checkThatUserHasWatchedMovie() throws IOException, URISyntaxException {
    StreamingService nlp = getStreamingService();
    User user = nlp.getUsers().get("20");
    Movie watchedMovie = nlp.getMovies().get("10");
    Movie notWatchedMvoie = nlp.getMovies().get("20");
    MovieAnalytics analytics = new MovieAnalytics();

    assertTrue("User should have watched this movie",
        analytics.userHasWatchedMovie(user, watchedMovie));
    assertFalse("User should not have watched this movie",
        analytics.userHasWatchedMovie(user, notWatchedMvoie));
  }

  @Test
  public void checkMovieIsPendingForUser() throws IOException, URISyntaxException {
    StreamingService nlp = getStreamingService();
    User user = nlp.getUsers().get("30");
    Movie pendingMovie = nlp.getMovies().get("10");
    Movie notPendingMvoie = nlp.getMovies().get("30");
    MovieAnalytics analytics = new MovieAnalytics();

    assertTrue("User wants to watch this movie",
        analytics.userWantsToWatchMovie(user, pendingMovie));
    assertFalse("User does not want to watch this movie",
        analytics.userWantsToWatchMovie(user, notPendingMvoie));
  }

}
