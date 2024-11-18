package Discordbot.eventListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.Bukkit;
import java.io.IOException;
import java.net.URI;
import java.net.http.*;



public class Server {
    static void send(Data data){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(data);
            Bukkit.getServer().getLogger().info("JSON:");
            Bukkit.getServer().getLogger().info(json);

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:3000/events"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    }catch(IOException | InterruptedException e){
        Bukkit.getLogger().severe("Error sending data");
    }
}}