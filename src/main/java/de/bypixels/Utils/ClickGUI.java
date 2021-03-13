package de.bypixels.Utils;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;


public class ClickGUI {

    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    private ItemStack oneblock(){
        ItemStack itemStack = new ItemStack(Material.STICKY_PISTON);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName("§3OneBlock Challange");
        List<String> lores = new ArrayList<>();
        lores.add("§7Starting the Challange");
        meta.setLore(lores);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public void createInventory() {
        inventory = Bukkit.createInventory(null,27, "§dChallanges Inventory");
        inventory.setItem(9, oneblock());


        fill(inventory);

    }


    private ItemStack enchantmentSwitch(ItemStack itemStack){
        ItemMeta meta  = itemStack.getItemMeta();
        if (meta.hasEnchants()){
                meta.removeEnchant(Enchantment.DURABILITY);
        }else{
            meta.addEnchant(Enchantment.DURABILITY, 0, true);
        }
        itemStack.setItemMeta(meta);
        return itemStack;
    }


    private void fill(Inventory inv) {
        ItemStack fill = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        ItemMeta fillMeta = fill.getItemMeta();
        fillMeta.setDisplayName("");
        fillMeta.addEnchant(Enchantment.DURABILITY, 0, true);
        fill.setItemMeta(fillMeta);
        for (int slot = 0; slot <= inv.getSize(); slot++) {
            if (inv.getItem(slot) == null)
                inv.setItem(slot, fill);
        }
    }
}
