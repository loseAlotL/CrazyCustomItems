package org.test.crazycustomitems.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.test.crazycustomitems.Items;

public class GandalfStaff implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        //if (!(sender instanceof Player)) {
            //sender.sendMessage("Only players can use that command!");
            //return true;
        //}
        Player player = (Player) sender;
        if(cmd.getName().equals("getgandalfstaff")){
            player.getInventory().addItem(Items.gandalfStaff);
            player.sendMessage("It worked!");
            return true;
        }
        return false;
    }
}
