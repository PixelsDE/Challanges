package de.bypixels.challanges;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public interface ChallangeHandler {

    void startChallange(Player player, ItemStack startItem);
    void resetChallange(Player player);
    void setupChallange();
}
