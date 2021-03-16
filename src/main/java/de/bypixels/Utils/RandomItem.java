package de.bypixels.Utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomItem {


    public RandomItem() {
        List<Material> allBlocks = new ArrayList<>();
        for (Material material : Material.values()) allBlocks.add(material);
        //all materials added to allBlocks (i hope)
        blocks = new ArrayList<>(allBlocks);
        System.out.println(Material.values().length + "  test  " + allBlocks.size());
        for (Material material : Material.values()) {
            int i = random.nextInt(allBlocks.size());
            newDrops.put(material, allBlocks.get(i));
            allBlocks.remove(allBlocks.get(i));
        }
    }

    private HashMap<Material, Material> newDrops = new HashMap<>();
    private Random random = new Random();
    private List<Material> blocks;

    public HashMap<Material, Material> getNewDrops() {
        return newDrops;
    }

    public void dropRandomItemOnBreak(Location location, Block block) {
        Material material = newDrops.get(block.getType());
        //passiert bis hier
        try {
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(material));
        } catch (IllegalArgumentException exception) {
            //if block is not droppable sets new block

            blocks.remove(material);
            int i = random.nextInt(blocks.size());
            newDrops.put(block.getType(), blocks.get(i));
            material = blocks.get(i);
            try {
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(material));
            } catch (Exception e) {
                blocks.remove(material);
                int a = random.nextInt(blocks.size());
                newDrops.put(block.getType(), blocks.get(a));
                material = blocks.get(a);
            }
        }
    }


    public void setRandomItemOnCraft(Inventory inventory, ItemStack itemStack) {
        Material material = newDrops.get(inventory.getType());
        try {
            itemStack.setType(newDrops.get(itemStack));
        } catch (Exception exception) {
            blocks.remove(material);
            int i = random.nextInt(blocks.size());
            newDrops.put(itemStack.getType(), blocks.get(i));
            material = blocks.get(i);
            try {
                itemStack.setType(newDrops.get(itemStack));
            } catch (Exception e) {
                blocks.remove(material);
                int a = random.nextInt(blocks.size());
                newDrops.put(itemStack.getType(), blocks.get(a));
                material = blocks.get(a);
            }
        }
    }
}
