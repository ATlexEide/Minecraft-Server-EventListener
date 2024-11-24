package Discordbot.eventListener;
import org.bukkit.Bukkit;
import java.io.IOException;
import java.net.URI;
import java.net.http.*;



public class Server {
    static HttpClient client = HttpClient.newHttpClient();

    static void send(String data){
        try {
            Bukkit.getServer().getLogger().info(data);

            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:3000/events"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(data))
                    .build();
            HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:3000/server/chat"))
                    .build();
            HttpResponse getResponse = client.sendAsync(getRequest, HttpResponse.BodyHandlers.ofString()).join();
            Bukkit.getLogger().info(getResponse.toString());
            if(getResponse.statusCode() == 200){
                Bukkit.getServer().broadcastMessage(getResponse.body().toString());
            }
    }catch(IOException | InterruptedException e){
        Bukkit.getLogger().severe("Error sending data, discord bot possibly not running");
    }
}




}