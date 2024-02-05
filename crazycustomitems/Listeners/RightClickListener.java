package org.test.crazycustomitems.Listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.test.crazycustomitems.Items;

import java.util.Collection;

public class RightClickListener implements Listener{

    public boolean areThereEntities(Location location, double radius){
        Collection<Entity> nearbyEntities = location.getWorld().getNearbyEntities(location, radius, radius, radius);
        //nearbyEntities.remove(player);
        return !nearbyEntities.isEmpty();
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getItem() != null && event.getAction().isRightClick() && event.getItem().getItemMeta().equals(Items.gandalfStaff.getItemMeta())){
            if(player.getInventory().contains(Material.IRON_NUGGET, 1)){
                //ItemStack Iron = new ItemStack(Material.IRON_NUGGET, 1);
                //event.getPlayer().getInventory().removeItem(Iron);
                player.getInventory().removeItem(new ItemStack(Material.IRON_NUGGET, 1));
                for(double vectorMultiplier = 2.1; vectorMultiplier < 27; vectorMultiplier = vectorMultiplier + 0.5){
                    Location blocksAway = player.getLocation().add(player.getLocation().getDirection().multiply(vectorMultiplier));
                    blocksAway.setY(blocksAway.getY() + 1.4);

                    if(!areThereEntities(blocksAway, 1)){
                        event.getPlayer().getWorld().spawnParticle(Particle.FLAME, blocksAway, 1, 0, 0, 0, -0.0005);


                    } else{
                        event.getPlayer().getWorld().createExplosion(blocksAway, 2, false, true);
                        break;
                    }
                }
            } else {
                event.getPlayer().sendMessage("§4(!) §cYou do not have any ammo!");
            }

        }
    }
}
