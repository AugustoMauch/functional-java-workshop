package org.openbravo.functional.finder;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openbravo.functional.dataset.StreamingServiceStore;
import org.openbravo.functional.model.StreamingService;
import org.openbravo.functional.model.User;

public class UserFinderShould extends StreamingServiceStore {

    @Test
    public void getTeenageUsers() throws IOException, URISyntaxException {
        StreamingService nlp = getStreamingService();
        List<User> users = new ArrayList<User>(nlp.getUsers().values());
        UserFinder userFinder = new UserFinder();

        List<User> teenagers = userFinder.getTeenagers(users);

        assertEquals("There should be 2 teenagers", 2, teenagers.size());
    }

    @Test
    public void getComedyLovers() throws IOException, URISyntaxException {
        StreamingService nlp = getStreamingService();
        List<User> users = new ArrayList<User>(nlp.getUsers().values());
        UserFinder userFinder = new UserFinder();

        List<User> teenagers = userFinder.getComedyLovers(users);

        assertEquals("There should be 1 comedy lover", 1, teenagers.size());
    }

}
