package org.openbravo.functional.processor;

import org.openbravo.functional.model.User;

import java.util.List;

public class UserProcessor {

  public void sendEmailToUsers(List<User> users) {
    doGenericActionOnUsers(users, new UserAction() {
      @Override
      public void doAction(User user) {
        showInScreen(user);
      }
    });
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
