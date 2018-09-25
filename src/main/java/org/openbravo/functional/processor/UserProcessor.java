package org.openbravo.functional.processor;

import org.openbravo.functional.model.User;

import java.util.List;

public class UserProcessor {

  public void sendEmailToUsers(List<User> Users) {
    doGenericActionOnUsers(Users, new UserAction() {
      @Override
      public void doAction(User User) {
        showInScreen(User);
      }
    });
  }

  public void doGenericActionOnUsers(List<User> Users, UserAction action) {
    for (User User : Users) {
      action.doAction(User);
    }
  }

  private interface UserAction {
    public void doAction(User p);
  }

  private static void showInScreen(User User) {
    // shows info about a User in the main screen
  }
}
