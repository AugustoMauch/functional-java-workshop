package org.openbravo.functional.model;

import java.util.List;

public class User {

  private String id;
  private String username;
  private int age;
  private String email;
  private List<Movie> pendingMovies;
  private List<Movie> watchedMovies;

  public User(String id, String username, int age, String email, List<Movie> pendingMovies, List<Movie> watchedMovies) {
    this.id = id;
    this.username = username;
    this.age = age;
    this.email = email;
    this.pendingMovies = pendingMovies;
    this.watchedMovies = watchedMovies;
  }

  public String getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public int getAge() {
    return age;
  }
  
  public boolean isMinor() {
    return age < 18;
  }

  public String getEmail() {
    return email;
  }
  
  public boolean hasWatchedMovie(Movie movie) {
    return watchedMovies.contains(movie);
  }

  public List<Movie> getPendingMovies() {
    return pendingMovies;
  }

  public List<Movie> getWatchedMovies() {
    return watchedMovies;
  }

  public Movie getAnyPendingMovie() {
    if (pendingMovies.isEmpty()) {
      return null;
    } else {
      return pendingMovies.get(0);
    }
  }
}
