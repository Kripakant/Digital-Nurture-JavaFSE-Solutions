// Exercise 36: HTTP Client API (Java 11+)
// Objective: Make HTTP requests from Java.
//
// Fetches data from the public GitHub API and prints status + body.
// Requires network access to run, but compiles offline.
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Exercise36_HTTPClientAPI {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/octocat"))
                .header("Accept", "application/vnd.github+json")
                .GET()
                .build();

        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response status code: " + response.statusCode());
            System.out.println("Response body:");
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            System.out.println("Request failed: " + e.getMessage());
            // Restore the interrupted status if applicable.
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
