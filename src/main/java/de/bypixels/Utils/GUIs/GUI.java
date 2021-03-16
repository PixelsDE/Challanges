package de.bypixels.Utils.GUIs;

import de.bypixels.Challanges;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUI {
    public GUI(int inventorySize, String inventoryName) {
        this.inventorySize = inventorySize;
        this.inventoryName = inventoryName;
        createInventory();
    }


    public Inventory createInventory() {
        inventory = Bukkit.createInventory(null, inventorySize, inventoryName);
        fill();
        return inventory;
    }

    private static Material fillMaterial = Material.PURPLE_STAINED_GLASS_PANE;

    public void fill() {
        ItemStack fill = new ItemStack(fillMaterial);
        ItemMeta fillMeta = fill.getItemMeta();
        fillMeta.setDisplayName("");
        fillMeta.addEnchant(Enchantment.DURABILITY, 0, true);
        fill.setItemMeta(fillMeta);
        for (int slot = 0; slot <= inventory.getSize() - 1; slot++) {
            if (inventory.getItem(slot) == null)
                inventory.setItem(slot, fill);
        }
    }


    public void addItem(ItemStack item, int position) {
        getInventory().setItem(position - 1, item);
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


    public static Material getFillMaterial() {
        return fillMaterial;
    }

    public void checkEnchantmentSwitch(ItemStack item) {
        if (item.getType() != Material.ACACIA_DOOR && item.getType() != Material.DIAMOND && item.getType() != GUI.getFillMaterial())
            Challanges.getChallenges().getUtil().getItems().enchantmentSwitch(item);
    }

    public static void setFillMaterial(Material fillMaterial) {
        GUI.fillMaterial = fillMaterial;
    }

    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public GUI() {
    }
}
