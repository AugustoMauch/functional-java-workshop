package org.openbravo.functional.model;

import java.util.Map;

public class StreamingService {

  private Map<String, User> users;
  private Map<String, Movie> movies;

  public StreamingService(Map<String, User> users, Map<String, Movie> movies) {
    this.users = users;
    this.movies = movies;
  }

  public Map<String, User> getUsers() {
    return users;
  }

  public Map<String, Movie> getMovies() {
    return movies;
  }

}
