package Discordbot.eventListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Material type = event.getBlock().getType();
        if(type == Material.DIRT){
            event.setCancelled(true);
        }
        Data data = new Data(event.getPlayer().getDisplayName(), event.getEventName());
        Server.send(data);
}
    @EventHandler
    public void onPLayerJoin(PlayerJoinEvent event) {
       Data data = new Data(event.getPlayer().getDisplayName(), event.getEventName());
        Server.send(data);
}
}
