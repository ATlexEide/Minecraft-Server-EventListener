package Discordbot.eventListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @EventHandler
    public void onPLayerJoin(PlayerJoinEvent event) {
        Data.onlinePlayers++;
        Data JoinData = new Data();
        JoinData.player = event.getPlayer().getName();
        JoinData.event = event.getEventName();
        String json = gson.toJson(JoinData);
        Bukkit.getServer().getLogger().info("JSON:");
        Bukkit.getServer().getLogger().info(json);
        Server.send(json);
}
@EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
    Data.onlinePlayers--;
    Data LeaveData = new Data();
    LeaveData.player = event.getPlayer().getName();
    LeaveData.event = event.getEventName();
    String json = gson.toJson(LeaveData);
    Bukkit.getServer().getLogger().info("JSON:");
    Bukkit.getServer().getLogger().info(json);
    Server.send(json);
}
/*@EventHandler
    public void onPlayerChangeGameMode(PlayerGameModeChangeEvent event) {
    String player = event.getPlayer().getDisplayName();
    String eventName = event.getEventName();
    GameMode newGamemode = event.getNewGameMode();
    Data data = new Data(event);
    Server.send(data);
}*/
}
