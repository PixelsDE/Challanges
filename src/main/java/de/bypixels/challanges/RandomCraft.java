package de.bypixels.challanges;

import de.bypixels.Utils.RandomItem;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.UUID;

public class RandomCraft implements ChallangeHandler, Listener {


    private ArrayList<UUID> playersInChallange = new ArrayList<>();

    @EventHandler(ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent event) {
        if (!playersInChallange.contains(event.getWhoClicked().getUniqueId())) return;
        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
    //TODO: hier randomCraft
    }

    @Override
    public void startChallange(Player player, ItemStack startItem) {

    }

    @Override
    public void resetChallange(Player player, ItemStack startItem) {

    }

    private RandomItem randomItem;

    @Override
    public void setupChallange() {
        randomItem = new RandomItem();
    }
}
