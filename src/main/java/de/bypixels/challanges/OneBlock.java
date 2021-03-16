package de.bypixels.challanges;

import de.bypixels.Challanges;
import de.bypixels.Utils.Texts.Durations;
import de.bypixels.Utils.Texts.Messages;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class OneBlock implements Listener, ChallangeHandler {

    public OneBlock() {
    }

    private HashMap<UUID, Material> block = new HashMap();


    private ArrayList<UUID> playersInChallange = new ArrayList<UUID>();

    @EventHandler(ignoreCancelled = true)
    public void onPlayerMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        Material playerBlock = player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType();
        if (!playersInChallange.contains(player.getUniqueId())) return;
        if (block.get(player.getUniqueId()) == null) return;
        if (playerBlock == Material.AIR || playerBlock == Material.CAVE_AIR || playerBlock == Material.LARGE_FERN) return;
        if (!playerBlock.equals(block.get(player.getUniqueId()))) {
            player.sendTitle(Messages.BLOCKSTEP.getMessageTitle(), Messages.PREFIX.getMessage() + Messages.BLOCKSTEP.getMessage(), Durations.WRONGSTEP.getDurationIn(), Durations.WRONGSTEP.getDurationMain(), Durations.WRONGSTEP.getDurationOut());

            resetChallange(player, Challanges.getChallenges().getUtil().getItems().OneBlockItem);
        }
    }


    public HashMap<UUID, Material> getBlock() {
        return block;
    }

    @Override
    public void startChallange(Player player, ItemStack startItem) {
        if (!player.hasPermission("challange.oneblock")) return;
            player.sendTitle(Messages.ONEBLOCK.getMessageTitle(), Messages.PREFIX.getMessage() + Messages.ONEBLOCK.getMessage(), Durations.ONEBLOCK.getDurationIn(), Durations.ONEBLOCK.getDurationMain(), Durations.WRONGSTEP.getDurationOut());
            Challanges.getChallenges().getUtil().getOneBlock().block.put(player.getUniqueId(), player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType());
    }

    public ArrayList<UUID> getPlayersInChallange() {
        return playersInChallange;
    }

    @Override
    public void resetChallange(Player player, ItemStack startItem) {
        if (!playersInChallange.contains(player.getUniqueId()))
            return;
        player.setHealth(0);
        block.remove(player.getUniqueId());
        player.spigot().respawn();
        Challanges.getChallenges().getUtil().getOneBlock().block.put(player.getUniqueId(), player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType());
    }

    @Override
    public void setupChallange() {
    }
}
