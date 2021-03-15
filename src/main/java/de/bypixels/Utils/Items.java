package de.bypixels.Utils;

import de.bypixels.Utils.Texts.Messages;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Items extends ItemGenerator{


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



    public ItemStack BackDoorItem =create(Material.ACACIA_DOOR).setItemName("§7Back to Main GUI").addLore(ChatColor.GRAY + "Brings you back to the Main GUI").addEnchantment(Enchantment.DURABILITY, 0).build();

    public ItemStack RandomDropItem = new ItemGenerator(Material.DIAMOND).setItemName("§fRandom ItemDrop").addLore("§7Drops a Random Block").addLore("§7Every time you break a block!").addEnchantment(Enchantment.DURABILITY, 0).build();
    public ItemStack OneBlockItem = create(Material.STICKY_PISTON).setItemName("§3OneBlock Challange").addLore("§7Starting the Challange").build();

}
