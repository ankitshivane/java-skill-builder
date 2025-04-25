package skillbuilder.java11.programs.httpClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientDemo {
    public static void main(String[] args) {
        // Test With Get Method
//            getMethDemo();
        // Test WIth Post Method
        postMethodDemo();

    }

    private static void getMethDemo() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.restful-api.dev/objects"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Status Code:" + response.statusCode());
        System.out.println("API Response:" + response.body());
    }

    private static void postMethodDemo() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString("{\"name\":\"Apple MacBook Pro 16\",\"data\":{\"year\":2019,\"price\":1849.99,\"CPU model\":\"Intel Core i9\",\"Hard disk size\":\"1 TB\"}}"))
                .header("Content-Type", "application/json")
                .uri(URI.create("https://api.restful-api.dev/objects"))
                .build();
        try {
            HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("API Response:" + res.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
