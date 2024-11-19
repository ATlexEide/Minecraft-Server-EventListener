package Discordbot.eventListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {


    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Material type = event.getBlock().getType();
        if(type == Material.DIRT){
            event.setCancelled(true);
        }
        String player = event.getPlayer().getDisplayName();
        String eventS = event.getEventName();
        String data = "player:%s, event:%s";
}
    @EventHandler
    public void onPLayerJoin(PlayerJoinEvent event) {
        String player = event.getPlayer().getDisplayName();
        String eventName = event.getEventName();
        Data data = new Data(player, eventName);
        Server.send(data);
}
@EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
    String player = event.getPlayer().getDisplayName();
    String eventName = event.getEventName();
    Data data = new Data(player, eventName);
    Server.send(data);
}
}
