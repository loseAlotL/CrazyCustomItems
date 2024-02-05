package org.test.crazycustomitems;

import org.bukkit.plugin.java.JavaPlugin;
import org.test.crazycustomitems.Commands.GandalfStaff;
import org.test.crazycustomitems.Commands.WizardHat;
import org.test.crazycustomitems.Listeners.BlockPlaceListener;
import org.test.crazycustomitems.Listeners.LeftClickListener;
import org.test.crazycustomitems.Listeners.RightClickListener;

import static org.bukkit.Bukkit.getPlayer;

public final class CrazyCustomItems extends JavaPlugin{

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new RightClickListener(), this);
        getServer().getPluginManager().registerEvents(new LeftClickListener(), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        Items.init();
        this.getCommand("getwizardhat").setExecutor(new WizardHat());
        this.getCommand("getgandalfstaff").setExecutor(new GandalfStaff());
    }





    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
