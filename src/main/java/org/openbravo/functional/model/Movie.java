package org.openbravo.functional.model;

public class Movie {

  private String id;
  private String title;
  private Integer duration;
  private String director;
  private String genre;
  private double score;

  public Movie(String id, String title, Integer duration, String director, String genre, double score) {
    this.id = id;
    this.title = title;
    this.duration = duration;
    this.director = director;
    this.genre = genre;
    this.score = score;
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public int getDuration() {
    return duration;
  }

  public String getDirector() {
    return director;
  }

  public String getGenre() {
    return genre;
  }

  public double getScore() {
    return score;
  }
  
  @Override
  public boolean equals(Object other){
      if (other == null) return false;
      if (other == this) return true;
      if (!(other instanceof Movie))return false;
      Movie otherMyClass = (Movie)other;
     return id.equals(otherMyClass.getId());
  }
}
