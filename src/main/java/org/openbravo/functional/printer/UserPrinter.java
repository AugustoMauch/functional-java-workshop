package org.openbravo.functional.printer;

import org.openbravo.functional.model.User;

public class UserPrinter {

  public String printBasicUserInfo(User aUser) {
    return printInfo(aUser, new UserStringifier() {

      @Override
      public String stringify(User user) {
        return user.getUsername();
      }

      @Override
      public boolean shouldUpperCase() {
        return true;
      }
    });
  }

  public String printCompleteUserInfo(User aUser) {
    return printInfo(aUser, new UserStringifier() {

      @Override
      public String stringify(User user) {
        StringBuilder builder = new StringBuilder();
        builder.append(user.getUsername() + "\n");
        builder.append(user.getAge() + "\n");
        user.getEmail().ifPresent(email -> builder.append(email.toLowerCase() + "\n"));
        user.getAnyPendingMovie().ifPresent(movie -> builder.append(movie.getTitle() + "\n"));
        return builder.toString();
      }

      @Override
      public boolean shouldUpperCase() {
        return false;
      }
    });
  }

  private String printInfo(User user, UserStringifier stringifier) {
    String info = stringifier.stringify(user);
    if (stringifier.shouldUpperCase()) {
      return info.toUpperCase();
    } else {
      return info;
    }
  }

  private interface UserStringifier {
    String stringify(User user);

    boolean shouldUpperCase();
  }
}
