package me.dylan.MineCraft1.cmds;

import me.dylan.MineCraft1.HelloWorld;
import me.dylan.MineCraft1.util.CustomConfig;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;


public class BlockBreak implements CommandExecutor, Listener {
    private final HelloWorld plugin;
    private final CustomConfig config;

    public BlockBreak(HelloWorld plugin) {
        this.plugin = plugin;
        this.config = plugin.getCustomConfig();

    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        return false;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        this.config.get().getConfigurationSection("blocks").getKeys(false).forEach(key -> {
            if (key.equalsIgnoreCase(event.getBlock().getType().toString())) {
                ItemStack[] items = new ItemStack[this.config.get().getStringList("blocks." + key).size()];
                ItemStack item = null;
                int postion = 0;
                Random r = new Random();
                for (String i : this.config.get().getStringList("blocks." + key)) {
                    try {
                        item = new ItemStack(Material.matchMaterial(i), r.nextInt(16) + 1);
                    } catch (Exception e) {
                        item = new ItemStack((Material.matchMaterial(key)));
                    }
                    items[postion] = item;
                    postion++;

                }
                int num = r.nextInt(items.length);
                event.setDropItems(false);
                World world = event.getPlayer().getWorld();
                world.dropItemNaturally(event.getBlock().getLocation(), items[num]);

            }
        });
    }
}



