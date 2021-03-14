package de.bypixels.Utils.GUIs;

import de.bypixels.Challanges;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUI {


    public void fill(Inventory inv) {
        ItemStack fill = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        ItemMeta fillMeta = fill.getItemMeta();
        fillMeta.setDisplayName("");
        fillMeta.addEnchant(Enchantment.DURABILITY, 0, true);
        fill.setItemMeta(fillMeta);
        for (int slot = 0; slot <= inv.getSize() - 1; slot++) {
            if (inv.getItem(slot) == null)
                inv.setItem(slot, fill);
        }
    }

    private int inventorySize;
    private String inventoryName;

    public int getInventorySize() {
        return inventorySize;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public GUI(int inventorySize, String inventoryName) {
        this.inventorySize = inventorySize;
        this.inventoryName = inventoryName;
    }

    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void addItem(int position, ItemStack item) {
        getInventory().setItem(position, item);
    }

    public Inventory createInventory() {
        inventory = Bukkit.createInventory(null, inventorySize, inventoryName);
        fill(inventory);
        return inventory;
    }
}
