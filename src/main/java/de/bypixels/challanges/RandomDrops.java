package de.bypixels.challanges;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RandomDrops implements Listener, ChallangeHandler {

    private Inventory randromDropInventory;

    public Inventory getRandromDropInventory() {
        return randromDropInventory;
    }

    @Override
    public void startChallange(Player player, ItemStack startItem) {

    }

    @Override
    public void resetChallange(Player player) {

    }

    @Override
    public void setupChallange() {

    }
}
