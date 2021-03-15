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
import java.util.UUID;

public class OneBlock implements Listener, ChallangeHandler {

    public OneBlock() {
    }

    private static Material block = null;

    public static void setBlock(Material block) {
        OneBlock.block = block;
    }

    private ArrayList<UUID> playersInChallange = new ArrayList<UUID>();

    @EventHandler(ignoreCancelled = true)
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Material playerBlock = player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType();
        if (!isChallangeStarted()) return;
        if (block == null) return;
        if (playerBlock == Material.AIR || playerBlock == Material.CAVE_AIR || playerBlock == Material.LARGE_FERN) return;
        if (!playerBlock.equals(block)) {
            resetChallange(player);
        }
    }


    private boolean challangeStarted = false;

    public boolean isChallangeStarted() {
        return challangeStarted;
    }

    public void setChallangeStarted(boolean challangeStarted) {
        this.challangeStarted = challangeStarted;
    }

    @Override
    public void startChallange(Player player, ItemStack startItem) {
        if (!player.hasPermission("challange.oneblock")) return;
        if (startItem.getItemMeta().hasEnchants()) {
            setChallangeStarted(true);
            playersInChallange.add(player.getUniqueId());
            OneBlock.setBlock(player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType());
            player.sendTitle(Messages.ONEBLOCK.getMessageTitle(), Messages.PREFIX.getMessage() + Messages.ONEBLOCK.getMessage(), Durations.ONEBLOCK.getDurationIn(), Durations.ONEBLOCK.getDurationMain(), Durations.WRONGSTEP.getDurationOut());
        } else {
            setChallangeStarted(false);
        }
    }


    @Override
    public void resetChallange(Player player) {
        if (!playersInChallange.contains(player.getUniqueId()))
            return;
        player.setHealth(0);
        playersInChallange.remove(player.getUniqueId());
        player.sendTitle(Messages.BLOCKSTEP.getMessageTitle(), Messages.PREFIX.getMessage() + Messages.BLOCKSTEP.getMessage(), Durations.WRONGSTEP.getDurationIn(), Durations.WRONGSTEP.getDurationMain(), Durations.WRONGSTEP.getDurationOut());
        player.spigot().respawn();
    }

    @Override
    public void setupChallange() {
    }
}
