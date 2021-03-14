package de.bypixels.challanges;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class RandomDrops implements Listener {

    private Inventory randromDropInventory;

    public Inventory getRandromDropInventory() {
        return randromDropInventory;
    }

    public void createInventory(){
        randromDropInventory = Bukkit.createInventory(null, 9, "§3Random Drop Inventory");

    }




}
