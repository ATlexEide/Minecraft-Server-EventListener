package Discordbot.eventListener;

import java.util.Objects;

public class Data {
    private static int onlinePlayers;
    public String player;
    public String event;
    public int playerCount;
    public Data(String _player, String _event) {
        player = _player;
        event = _event;
        if(Objects.equals(_event, "PlayerJoinEvent")){
           onlinePlayers++;
        }if(Objects.equals(_event, "PlayerLeaveEvent")){
            onlinePlayers--;
        }
        playerCount = getPlayerCount();
    }
    public static int getPlayerCount (){
        return onlinePlayers;
    }
}