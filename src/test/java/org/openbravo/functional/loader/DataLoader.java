package org.openbravo.functional.loader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openbravo.functional.model.Movie;
import org.openbravo.functional.model.StreamingService;
import org.openbravo.functional.model.User;

public class DataLoader {

  public StreamingService loadStreamingService() throws IOException, URISyntaxException {
    String content = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("streaming_service_data.json").toURI())));
    JSONObject json = new JSONObject(content);
    Map<String, Movie> movieMap = readMovies(json.getJSONArray("movies"));
    Map<String, User> userMap = readUsers(json.getJSONArray("users"), movieMap);
    return new StreamingService(userMap, movieMap);
  }

  private Map<String, Movie> readMovies(JSONArray array) {
    return StreamSupport.stream(array.spliterator(), false) //
        .map(json -> jsonToMovie((JSONObject) json)) //
        .collect(Collectors.toMap(movie -> movie.getId(), movie -> movie));
  }

  private Map<String, User> readUsers(JSONArray array, Map<String, Movie> movieMap) {
    return StreamSupport.stream(array.spliterator(), false) //
        .map(json -> jsonToUser((JSONObject) json, movieMap)) //
        .collect(Collectors.toMap(participant -> participant.getId(), participant -> participant));
  }

  private Movie jsonToMovie(JSONObject json) {
    return new Movie(json.getString("id"), //
        json.getString("title"), //
        json.getInt("duration"), //
        json.getString("director"), //
        json.getString("genre"), //
        json.getDouble("score"));
  }

  private User jsonToUser(JSONObject json, Map<String, Movie> movieMap) {
    JSONArray pending = json.getJSONArray("pendingMovies");
    List<Movie> pendingMovies = StreamSupport.stream(pending.spliterator(), false) //
        .map(movieMap::get).collect(Collectors.toList());

    JSONArray watched = json.getJSONArray("watchedMovies");
    List<Movie> watchedMovies = StreamSupport.stream(watched.spliterator(), false) //
        .map(movieMap::get).collect(Collectors.toList());

    String email = json.has("email") ? json.getString("email") : null;

    return new User(json.getString("id"), //
        json.getString("username"), //
        json.getInt("age"), //
        email, //
        pendingMovies, watchedMovies);
  }
}
