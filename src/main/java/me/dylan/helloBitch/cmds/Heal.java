package me.dylan.helloBitch.cmds;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Heal implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("doctor")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.MAGIC + "Take some health my G");
                return true;
            }
            Player player = (Player) sender;
            if (!player.hasPermission("doctor.use")) {
                player.sendMessage(ChatColor.RED + "Not for you yet my G");
                return true;
            }
            if (args.length == 0) {
                TextComponent message = new TextComponent("Would you like to be healed?");
                message.setColor(ChatColor.GOLD);
                message.setBold(true);
                message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/doctor healme"));
                message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                        new ComponentBuilder("Click here to be healed!").color(ChatColor.DARK_GRAY).italic(true).create()));
                player.spigot().sendMessage(message);
                return true;
            }
            if (args[0].equalsIgnoreCase("healme")) {
                player.setHealth(20.0);
                player.sendMessage(ChatColor.DARK_GREEN + "You have been healed!");
                return true;
            }
            player.sendMessage("usage: /doctor");
            return true;
        }
        return false;
    }
}
