package Discordbot.eventListener;

public class Data {
    static int onlinePlayers = 0;
    static String player;
    static String event;
    Data(String player, String event) {
        this.player = player;
        this.event = event;
    }
}
