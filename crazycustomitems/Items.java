package org.test.crazycustomitems;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Items {
    public static ItemStack wizardHat;
    public static ItemStack gandalfStaff;
    public static void init() {
        createWizardHat();
        createGandalfStaff();
    }


    private static void createWizardHat() {
        ItemStack item = new ItemStack(Material.CARVED_PUMPKIN,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Wizard's Hat");
        List<String> lore = new ArrayList<>();
        lore.add("§5Passive Ability: §dGreater Wisdom");
        lore.add("§7When used with Gandalf’s Staff, the cooldown for §fStrategic Wisdom §7is lowered from §f75s §7to §f50s§7.");
        lore.add("§5Passive Ability: §dFurious Conjuring");
        lore.add("§7When used with Sarauman's Staff, the cooldown for §fFiery Curse §7is lowered from §f45s §7to §f30s§7.");
        meta.setLore(lore);
        meta.setCustomModelData(1);
        item.setItemMeta(meta);
        wizardHat = item;
    }
    private static void createGandalfStaff() {
        //create the item
        ItemStack item = new ItemStack(Material.STICK,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fScar");
        List<String> lore = new ArrayList<>();
        lore.add("§4Its a gun");
        meta.setLore(lore);
        meta.setCustomModelData(1);
        item.setItemMeta(meta);
        gandalfStaff = item;

        //recipe
        //ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("gandalfStaffRecipe"), item);
        //sr.shape("  C",
        //         " S ",
        //         "S  ");
        //sr.setIngredient('S', Material.STICK);
        //sr.setIngredient('C', Material.END_CRYSTAL);
        //Bukkit.getServer().addRecipe(sr);

    }
}