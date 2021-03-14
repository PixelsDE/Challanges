package de.bypixels.Utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Items {


    public ItemStack OneBlockItem() {
        ItemStack itemStack = new ItemStack(Material.STICKY_PISTON);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName("§3OneBlock Challange");
        List<String> lores = new ArrayList<>();
        lores.add("§7Starting the Challange");
        meta.setLore(lores);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemStack enchantmentSwitch(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta.hasEnchants()) {
            meta.removeEnchant(Enchantment.DURABILITY);
        } else {
            meta.addEnchant(Enchantment.DURABILITY, 0, true);
        }
        itemStack.setItemMeta(meta);
        return itemStack;
    }
}
