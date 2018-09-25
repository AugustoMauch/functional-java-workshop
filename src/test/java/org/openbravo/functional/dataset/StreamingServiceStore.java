package org.openbravo.functional.dataset;

import org.openbravo.functional.loader.DataLoader;
import org.openbravo.functional.model.StreamingService;

import java.io.IOException;
import java.net.URISyntaxException;

public class StreamingServiceStore {

  private static StreamingService streamingService;

  protected static StreamingService getStreamingService() throws IOException, URISyntaxException {
    if (streamingService == null) {
      DataLoader loader = new DataLoader();
      streamingService = loader.loadStreamingService();
    }
    return streamingService;
  }
}
