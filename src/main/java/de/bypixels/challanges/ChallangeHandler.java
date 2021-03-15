package de.bypixels.challanges;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.UUID;

public interface ChallangeHandler {

    void startChallange(Player player, ItemStack startItem);
    void resetChallange(Player player);
    void setupChallange();
    ArrayList<UUID> playersInChallange = new ArrayList<>();
}
