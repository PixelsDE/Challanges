package de.bypixels.challanges;

import de.bypixels.Challanges;
import de.bypixels.Utils.Messages;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class OneBlock implements Listener {


    public static boolean challangeStarted;


/*    challangeStarted = true;
    */

    private Challanges challenges;

    public OneBlock(Challanges challenges) {
        this.challenges = challenges;
    }


    public static Material block = null;


    @EventHandler(ignoreCancelled = true)
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Material playerBlock = player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType();
        if (!challangeStarted) return;
        if (block == null) return;
        if (playerBlock == Material.AIR || playerBlock == Material.CAVE_AIR || playerBlock == Material.LARGE_FERN) return;
        if (!playerBlock.equals(block)) {
            player.setHealth(0);
            resetChallange(player);
            player.sendTitle(Messages.BLOCKSTEP.getMessageTitle(), Messages.PREFIX.getMessage()+Messages.BLOCKSTEP.getMessage(), 10, 60, 10);
        }
    }



    void resetChallange(Player player) {
        challangeStarted = false;
        block = null;
        player.spigot().respawn();
    }
}
