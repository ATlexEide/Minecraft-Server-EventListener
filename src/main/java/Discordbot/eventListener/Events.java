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
        Data EventData = new Data();
        EventData.player = event.getPlayer().getName();
        EventData.event = event.getEventName();
        EventData.playerCount++;
        String json = gson.toJson(EventData);
        Bukkit.getServer().getLogger().info("JSON:");
        Bukkit.getServer().getLogger().info(json);
        String player = event.getPlayer().getDisplayName();
        String eventName = event.getEventName();
        Server.send(json);
}
@EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
    String player = event.getPlayer().getDisplayName();
    String eventName = event.getEventName();
    /*Server.send();*/
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
