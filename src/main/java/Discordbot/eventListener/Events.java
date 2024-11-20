package Discordbot.eventListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.function.Supplier;

public class Events implements Listener {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @EventHandler
    public void onPLayerJoin(PlayerJoinEvent event) {
        Data JoinData = new Data();
        JoinData.player = event.getPlayer().getName();
        JoinData.event = event.getEventName();
        JoinData.playerCount++;
        String json = gson.toJson(JoinData);
        Bukkit.getServer().getLogger().info("JSON:");
        Bukkit.getServer().getLogger().info(json);
        Server.send(json);
}
@EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
    Data LeaveData = new Data();
    LeaveData.player = event.getPlayer().getName();
    LeaveData.event = event.getEventName();
    LeaveData.playerCount--;
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
