package de.bypixels.Utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemGenerator {

    private ItemStack itemStack;
    private ItemMeta meta;
    private String itemName;
    private List<String> lores = new ArrayList<>();
    private HashMap<Enchantment, Integer> itemEnchantments  = new HashMap<>();
    private Material material;

    public ItemGenerator(Material material) {
        this.material = material;
        this.itemStack = new ItemStack(material);
        this.meta = itemStack.getItemMeta();
    }

    public ItemGenerator() {
    }

    public ItemGenerator create(Material material){
        this.material = material;
        this.itemStack = new ItemStack(material);
        this.meta = itemStack.getItemMeta();
        return this;
    }
    public ItemStack build() {
        for (Enchantment enchantment : itemEnchantments.keySet())
            meta.addEnchant(enchantment, itemEnchantments.get(enchantment), false);
        meta.setDisplayName(itemName);
        meta.setLore(lores);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemGenerator setItemName(String name) {
        this.itemName = name;
        return this;
    }

    public ItemGenerator addLore(String lore) {
        this.lores.add(lore);
        return this;
    }

    public ItemGenerator addEnchantment(Enchantment enchantment, Integer level){
        this.itemEnchantments.put(enchantment, level);
        return this;
    }
}
