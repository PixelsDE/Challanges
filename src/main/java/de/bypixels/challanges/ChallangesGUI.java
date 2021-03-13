package de.bypixels.challanges;

import de.bypixels.Challanges;
import de.bypixels.Utils.Messages;
import de.bypixels.Utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChallangesGUI implements CommandExecutor {

    private Challanges challenges;

    public ChallangesGUI(Challanges challenges) {
        this.challenges = challenges;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, String[] args) {
        if (command.getName().equalsIgnoreCase("challanges")) {
            if (!(commandSender instanceof Player)) {
                Bukkit.getConsoleSender().sendMessage(Messages.PREFIX.getMessage()+Messages.MUSTBEPLAYER.getMessage());
                return false;
            }
            Player player = (Player) commandSender;
            if (!player.hasPermission("challanges.gui")) {
                player.sendTitle(Messages.PERMISSION.getMessageTitle(), Messages.PREFIX.getMessage()+Messages.PERMISSION.getMessage(), 10, 50, 10);
                return false;
            }
            if (args.length != 0) {
                player.sendTitle(Messages.ARGUMENTS.getMessageTitle(), Messages.PREFIX.getMessage()+Messages.ARGUMENTS.getMessage(), 10, 50, 10);
                return false;
            }
            player.openInventory(Challanges.getChallenges().getUtil().getClickGUI().createInventory());

        }
        return false;

    }
}

