package de.bypixels.challanges;

import de.bypixels.Challanges;
import de.bypixels.Utils.RandomItem;
import de.bypixels.Utils.Texts.Durations;
import de.bypixels.Utils.Texts.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class RandomDrops implements Listener, ChallangeHandler {

    private ArrayList<UUID> playersInChallange = new ArrayList<UUID>();

    public ArrayList<UUID> getPlayersInChallange() {
        return playersInChallange;
    }


    //the challange main part!
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent event) {
        if (randomItem.getNewDrops().isEmpty() || !playersInChallange.contains(event.getPlayer().getUniqueId())) return;
        Player player = event.getPlayer();
        Block block = event.getBlock();
        block.getDrops().clear();
        event.setCancelled(true);
        randomItem.dropRandomItemOnBreak(block.getLocation(), block);
        event.getBlock().setType(Material.AIR);
    }

    @Override
    public void startChallange(Player player, ItemStack startItem) {
        setupChallange();
        if (!player.hasPermission("challange.randomdropbreak")) return;
        player.sendTitle(Messages.BLOCKBREAK.getMessageTitle(), Messages.PREFIX.getMessage() + Messages.BLOCKBREAK.getMessage(), Durations.BLOCKBREAK.getDurationIn(), Durations.BLOCKBREAK.getDurationMain(), Durations.BLOCKBREAK.getDurationOut());
    }

    @Override
    public void resetChallange(Player player, ItemStack startItem) {
        Challanges.getChallenges().getUtil().getGUI().checkEnchantmentSwitch(startItem);
    }




private RandomItem randomItem;
    @Override
    public void setupChallange() {
        randomItem = new RandomItem();
    }
}
