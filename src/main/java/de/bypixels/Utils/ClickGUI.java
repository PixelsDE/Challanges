package de.bypixels.Utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ClickGUI {

    private Inventory inventory = Bukkit.createInventory(null, 9, "§dChallanges Inventory");


    public void createInventory() {


    }


    private void fill(Inventory inv) {
        ItemStack fill = new ItemStack(Material.GLASS_PANE, (byte) 3);
        ItemMeta fillMeta = fill.getItemMeta();
        fillMeta.setDisplayName("");
        fillMeta.addEnchant(Enchantment.DURABILITY, 0, true);
        fill.setItemMeta(fillMeta);
        for (int slot = 0; slot <= inv.getSize(); slot++) {
            if (inv.getItem(slot) != null)
                inv.setItem(slot, fill);
        }
    }
}
