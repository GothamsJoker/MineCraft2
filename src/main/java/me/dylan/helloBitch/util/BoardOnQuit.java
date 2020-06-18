package me.dylan.helloBitch.util;

import me.dylan.helloBitch.HelloWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class BoardOnQuit implements Listener {
    private final HelloWorld plugin;

    public BoardOnQuit(HelloWorld plugin) {
        this.plugin = plugin;

    }

    @EventHandler
    public void ScoreQuit(PlayerQuitEvent event) {
        LobbyBoard board = new LobbyBoard(event.getPlayer().getUniqueId());
        if (board.hasID()) {
            board.stop();
        }
    }

}
