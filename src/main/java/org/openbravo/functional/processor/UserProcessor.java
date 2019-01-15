package org.openbravo.functional.processor;

import java.util.List;
import java.util.function.Consumer;

import org.openbravo.functional.model.User;

public class UserProcessor {

  public void sendEmailToUsers(List<User> users) {
    doGenericActionOnUsers(users, user -> showInScreen(user));
  }

  public void doGenericActionOnUsers(List<User> users, Consumer<User> action) {
    for (User user : users) {
      action.accept(user);
    }
  }

  private static void showInScreen(User user) {
    // shows info about a User in the main screen
  }
}
