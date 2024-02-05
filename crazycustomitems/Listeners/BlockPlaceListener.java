package org.test.crazycustomitems.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.test.crazycustomitems.Commands.GandalfStaff;
import org.test.crazycustomitems.Commands.WizardHat;
import org.test.crazycustomitems.Items;


public class BlockPlaceListener implements Listener{

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        ItemStack item = event.getItemInHand();
        ItemMeta meta = item.getItemMeta();

        // Check if the item is a carved pumpkin and has custom model data of 1
        if (item.getType() == Material.CARVED_PUMPKIN && meta.hasCustomModelData() && meta.getCustomModelData() == 1) {
            // Cancel the event, preventing the block from being placed
            event.setCancelled(true);
        }
    }
}

