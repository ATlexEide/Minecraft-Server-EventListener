package Discordbot.eventListener;
import org.bukkit.Bukkit;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Server {
    static void send(Data data){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:3000/events"))
                    .POST(HttpRequest.BodyPublishers.ofString("data.toString())"))
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> postResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            Bukkit.getLogger().info(postResponse.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
