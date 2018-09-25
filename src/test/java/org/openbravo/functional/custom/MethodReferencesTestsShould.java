package org.openbravo.functional.custom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.openbravo.functional.model.Movie;
import org.openbravo.functional.model.User;
import org.openbravo.functional.practice.MethodReferencesTests;

public class MethodReferencesTestsShould {
  

  @Test
  public void intToStringShould() {
    assertEquals("Int not properly stringified ", "10", MethodReferencesTests.intToString.apply(10));
  }
  
  @Test
  public void getUserNameShould() {
    User user = getMinorTestUser();
    
    assertEquals("Int not properly stringified ", "testUserName", MethodReferencesTests.getUserName.apply(user));
  }
  
  @Test
  public void userIsMinorShould() {
    assertTrue("User should be a minor ", MethodReferencesTests.userIsMinor.test(getMinorTestUser()));
    assertFalse("User should be an adult ", MethodReferencesTests.userIsMinor.test(getAdultTestUser()));
  }  
  
  @Test
  public void userNameStartsWithAShould() {
    assertTrue("Username should start with A ", MethodReferencesTests.userNameStartsWithA.test(getAdultTestUser()));
    assertFalse("User should not start with A", MethodReferencesTests.userNameStartsWithA.test(getMinorTestUser()));
  }  
  
  @Test
  public void dateSupplierShould() {
    LocalDate localDate = MethodReferencesTests.dateSupplier.get();
    
    assertTrue("Date supplier should return new localDate ", localDate instanceof LocalDate);
  }  
  
  @Test
  public void stringSupplierShould() {
    String string = MethodReferencesTests.newStringSupplier.get();
    
    assertEquals("String supplier should return empty string", "", string);
  }    
  
  @Test
  public void userHasWatchedMovieShould() {
    assertTrue("User should have watched movie", MethodReferencesTests.userHasWatchedMovie.apply(getAdultTestUser(), getTestMovie()));
    assertFalse("User should not have watched movie", MethodReferencesTests.userHasWatchedMovie.apply(getMinorTestUser(), getTestMovie()));
  }  
  
  @Test
  public void movieHasBeenWatchedByUserShould() {
    assertTrue("User should have watched movie", MethodReferencesTests.movieHasBeenWatchedByUser.apply(getTestMovie(), getAdultTestUser()));
    assertFalse("User should not have watched movie", MethodReferencesTests.movieHasBeenWatchedByUser.apply(getTestMovie(), getMinorTestUser()));
  }    

  private User getMinorTestUser() {
    return new User("10", "testUserName", 16, "test@gmail.com", Collections.emptyList(), Collections.emptyList());
  }  
  
  private User getAdultTestUser() {
    List<Movie> watchedMovies = new ArrayList<>(); 
    watchedMovies.add(getTestMovie());
    return new User("10", "AnotherUser", 20, "test@gmail.com", Collections.emptyList(), watchedMovies);
  }    
  
  private Movie getTestMovie() {
    return new Movie("10", "Big", 100, "Penny Marshall", "Comedy", 9);
  }  
  
}
