package de.bypixels.challanges;

import de.bypixels.Challanges;
import de.bypixels.Utils.MESSAGES;
import de.bypixels.Utils.Util;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class OneBlock implements Listener, CommandExecutor {


    public static boolean challangeStarted;

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("oneblock"))
            return false;
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(Challanges.getUtil().Messages().ERROR.getMessage());
            return false;
        }
        Player player = (Player) sender;

        if (args.length > 0) {
            player.sendTitle(challenges.getChallenges().getUtil().Messages().ARGUMENTS.getMessageTitle(), challenges.getChallenges().getUtil().Messages().ONEBLOCK.getMessage(), 10, 50, 10);
            return false;

        }
        if (!player.hasPermission("Challanges.oneblock")) {
            player.sendTitle(challenges.getChallenges().getUtil().Messages().PERMISSION.getMessageTitle(), challenges.getChallenges().getUtil().Messages().ONEBLOCK.getMessage(), 10, 50, 10);
            return false;
        }


        //ab hier geschied der Command
        player.sendTitle(challenges.getChallenges().getUtil().Messages().ONEBLOCK.getMessageTitle(), challenges.getChallenges().getUtil().Messages().ONEBLOCK.getMessage(), 10, 50, 10);
        challangeStarted = true;
        block = player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType();
        return false;
    }


    private Challanges challenges;

    public OneBlock(Challanges challenges) {
        this.challenges = challenges;
    }


    private static Material block = null;


    @EventHandler(ignoreCancelled = true)
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Material playerBlock = player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType();

        if (!challangeStarted) return;
        if (block == null) return;
        if (player.isJumping()) return;
        if (playerBlock == Material.AIR || playerBlock == Material.CAVE_AIR || playerBlock == Material.LARGE_FERN) return;
        if (!playerBlock.equals(block)) {
            player.setHealth(0);
            resetChallange();
            player.sendMessage(Challanges.getUtil().Messages().BLOCKSTEP.getMessage());
        }
    }

    void resetChallange() {
        challangeStarted = false;
        block = null;
    }
}
