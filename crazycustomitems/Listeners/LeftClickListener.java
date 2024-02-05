package org.test.crazycustomitems.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;
import org.test.crazycustomitems.Items;

import java.util.List;

public class LeftClickListener implements Listener{


    @EventHandler
    public void onLeftClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getItem() != null && event.getAction().isLeftClick() && !player.isSneaking() && event.getItem().getItemMeta().equals(Items.gandalfStaff.getItemMeta())){
            Vector direction = player.getLocation().getDirection();
            direction = direction.multiply(2);
            player.setVelocity(direction);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 15, 2));

        }
    }

    @EventHandler
    public void onShiftLeftClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getItem() != null && event.getAction().isLeftClick() && player.isSneaking() && event.getItem().getItemMeta().equals(Items.gandalfStaff.getItemMeta())){
            List<Entity> nearbyEntities = player.getNearbyEntities(5, 5, 5);
            Location loc = player.getLocation();
            for (double i = 0; i <360; i +=5){
                double angle = i * Math.PI / 180;
                double x = 5 * Math.cos(angle);
                double z = 5 * Math.sin(angle);
                loc.getWorld().spawnParticle(Particle.FLAME, loc.getX() + x, loc.getY() + 0.5, loc.getZ() + z, 0);
            }
            for (double y = 0; y <= 2; y += 0.05) {
                double radius = y;
                double x = radius * Math.cos(2 * Math.PI * y);
                double z = radius * Math.sin(2 * Math.PI * y);

                loc.getWorld().spawnParticle(Particle.FLAME, loc.getX() + x, loc.getY() + y + 2, loc.getZ() + z, 0);

            }
            for (Entity entity : nearbyEntities) {
                if (entity instanceof LivingEntity){
                        ((LivingEntity)entity).damage(10.0);
                }
            }
        }
    }
}
