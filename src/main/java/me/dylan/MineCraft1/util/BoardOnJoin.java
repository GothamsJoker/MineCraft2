package me.dylan.MineCraft1.util;


import me.dylan.MineCraft1.HelloWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BoardOnJoin implements Listener {
    private final HelloWorld plugin;

    public BoardOnJoin(HelloWorld plugin) {
        this.plugin = plugin;


    }

    @EventHandler
    public void ScoreJoin(PlayerJoinEvent event) {
        new CreateBoard(this.plugin).loadBoard(event.getPlayer());
        new ScoreBoardStart(this.plugin).Start(event.getPlayer());

    }
}
