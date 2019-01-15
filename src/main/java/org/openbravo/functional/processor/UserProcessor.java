package org.openbravo.functional.processor;

import java.util.List;

import org.openbravo.functional.model.User;

public class UserProcessor {

  public void sendEmailToUsers(List<User> users) {
    doGenericActionOnUsers(users, user -> showInScreen(user));
  }

  public void doGenericActionOnUsers(List<User> users, UserAction action) {
    for (User user : users) {
      action.doAction(user);
    }
  }

  private interface UserAction {
    public void doAction(User p);
  }

  private static void showInScreen(User user) {
    // shows info about a User in the main screen
  }
}
