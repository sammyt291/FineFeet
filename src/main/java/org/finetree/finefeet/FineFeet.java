package org.finetree.finefeet;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import redempt.redlib.config.ConfigManager;

import static org.finetree.finefeet.Config.usePermissions;

public final class FineFeet extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        //Initialize Config
        ConfigManager config = ConfigManager.create(this);
        config.target(Config.class).saveDefaults().load();

        //Metrics
        Metrics metrics = new Metrics(this, 20224);

        getServer().getConsoleSender().sendMessage(ChatColor.WHITE + "["+ ChatColor.GOLD +"FineFeet"+ ChatColor.WHITE +"] "+ ChatColor.GREEN +"enabled");
        getServer().getPluginManager().registerEvents(this, this);
    }
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.WHITE + "["+ ChatColor.GOLD +"FineFeet"+ ChatColor.WHITE +"] "+ ChatColor.RED +"disabled");
    }

    @EventHandler
    public void onPlayerTouch(PlayerInteractEvent event){

        Player who = event.getPlayer();
        ItemStack feet = who.getInventory().getBoots();
        Block block = event.getClickedBlock();

        if(event.getAction() == Action.PHYSICAL && feet == null && block != null){
            if(usePermissions){
                if(!who.hasPermission("finefeet.use")){
                    return;
                }
            }

            if(block.getType() == Material.FARMLAND) {
                event.setCancelled(true);
            }
        }
    }
}
