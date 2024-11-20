package Discordbot.eventListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
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
    Server.send(json);
}
@EventHandler
    public void onPlayerChangeGameMode(PlayerGameModeChangeEvent event) {
    Data GameModeChangeData = new Data();
    GameModeChangeData.player = event.getPlayer().getDisplayName();
    GameModeChangeData.event = event.getEventName();
    GameModeChangeData.gamemode = event.getPlayer().getGameMode().toString();
    GameModeChangeData.newGamemode = event.getNewGameMode().toString();
    String json = gson.toJson(GameModeChangeData);
    Server.send(json);
}
}
