package org.openbravo.functional.practice;

import java.time.LocalDate;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.openbravo.functional.model.Movie;
import org.openbravo.functional.model.User;

public class MethodReferencesTests {
  
  public static Function<Integer, String> intToString = integer -> String.valueOf(integer);
  
  public static  Function<User, String> getUserName = user -> user.getUsername();

  public static  Predicate<User> userIsMinor = user -> user.isMinor();
  
  public static  Predicate<User> userNameStartsWithA = user -> user.getUsername().startsWith("A");
  
  public static  Consumer<User> printUserName = user -> System.out.println(user.getUsername());
  
  public static  BiFunction<User, Movie, Boolean> userHasWatchedMovie = (user, movie) -> user.hasWatchedMovie(movie);

  public static  BiFunction<Movie, User, Boolean> movieHasBeenWatchedByUser = (movie, user) -> user.hasWatchedMovie(movie);
  
  public static  Supplier<LocalDate> dateSupplier = () -> LocalDate.now(); 
  
  public static  Supplier<String> newStringSupplier = () -> new String();
  

}
