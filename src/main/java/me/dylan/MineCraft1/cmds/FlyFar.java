package me.dylan.MineCraft1.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyFar implements CommandExecutor {
    public FlyFar() {

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You can not fly!");
            return true;
        }

        Player player = (Player) sender;
        if (player.hasPermission("flyplugin.fly")) {
            player.setAllowFlight(true);
            player.sendMessage(ChatColor.BLUE + "You can now fly!");
            return true;
        }
        return true;
    }
}