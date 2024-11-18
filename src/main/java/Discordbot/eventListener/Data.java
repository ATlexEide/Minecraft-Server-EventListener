package Discordbot.eventListener;

public class Data {
    public int onlinePlayers = 0;
    public String player;
    public String event;
    public Data(String _player, String _event) {
        player = _player;
        event = _event;
    }
}