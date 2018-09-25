package org.openbravo.functional.printer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;
import org.openbravo.functional.dataset.StreamingServiceStore;
import org.openbravo.functional.model.StreamingService;
import org.openbravo.functional.model.User;

public class UserPrinterShould extends StreamingServiceStore {

  @Test
  public void printBasicUserInfo() throws IOException, URISyntaxException {
    StreamingService streamingService = getStreamingService();
    User user = streamingService.getUsers().get("10");
    UserPrinter printer = new UserPrinter();

    String basicUserInfo = printer.printBasicUserInfo(user);
    assertEquals("Wrong basic user info", "AUMAGO", basicUserInfo);
  }

//  @Test
  public void printCompleteUserInfo() throws IOException, URISyntaxException {
    StreamingService streamingService = getStreamingService();
    User user = streamingService.getUsers().get("10");
    UserPrinter printer = new UserPrinter();

    String completeUserInfo = printer.printCompleteUserInfo(user);
    assertEquals("Wrong full user info", "aumago", completeUserInfo);
  }

}
