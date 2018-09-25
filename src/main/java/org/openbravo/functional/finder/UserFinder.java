package org.openbravo.functional.finder;

import org.openbravo.functional.model.Movie;
import org.openbravo.functional.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserFinder {

  public List<User> getComedyLovers(List<User> allUsers) {
    return filterUsers(allUsers, new ComedyLoversFilter());
  }

  public List<User> getTeenagers(List<User> allUsers) {
    return filterUsers(allUsers, new UserFilter() {
      
      @Override
      public boolean applies(User user) {
        return user.getAge() >= 12 && user.getAge() <= 19;
      }
    });
  }

  public List<User> filterUsers(List<User> allUsers, UserFilter filter) {
    List<User> filteredUsers = new ArrayList<>();
    for (User user : allUsers) {
      if (filter.applies(user)) {
        filteredUsers.add(user);
      }
    }
    return filteredUsers;
  }

  private interface UserFilter {
    boolean applies(User user);
  }

  private class ComedyLoversFilter implements UserFilter {

    @Override
    public boolean applies(User user) {
      int totalFilms = user.getWatchedMovies().size();
      if (totalFilms == 0) {
        return false;
      }
      MovieFinder movieFinder = new MovieFinder();
      List<Movie> comedies = movieFinder.getComedies(user.getWatchedMovies());
      return comedies.size() == totalFilms;
    }
  }
}
