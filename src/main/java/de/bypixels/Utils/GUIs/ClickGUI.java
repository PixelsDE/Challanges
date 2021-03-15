package de.bypixels.Utils.GUIs;

import de.bypixels.Challanges;
import de.bypixels.Utils.Texts.Durations;
import de.bypixels.Utils.Texts.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;


public class ClickGUI extends GUI implements CommandExecutor {


    public ClickGUI(int inventorySize, String inventoryName) {
        super(inventorySize, inventoryName);
        createInventory();
        addItem(9, Challanges.getChallenges().getUtil().getItems().OneBlockItem);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, String[] args) {
        if (command.getName().equalsIgnoreCase("challanges")) {
            if (!(commandSender instanceof Player)) {
                Bukkit.getConsoleSender().sendMessage(Messages.PREFIX.getMessage() + Messages.MUSTBEPLAYER.getMessage());
                return false;
            }
            Player player = (Player) commandSender;
            if (!player.hasPermission("challanges.gui")) {
                player.sendTitle(Messages.PERMISSION.getMessageTitle(), Messages.PREFIX.getMessage() + Messages.PERMISSION.getMessage(), Durations.PERMISSION.getDurationIn(), Durations.PERMISSION.getDurationMain(), Durations.PERMISSION.getDurationOut());
                return false;
            }
            if (args.length != 0) {
                player.sendTitle(Messages.ARGUMENTS.getMessageTitle(), Messages.PREFIX.getMessage() + Messages.ARGUMENTS.getMessage(), Durations.ARGUMENTS.getDurationIn(), Durations.ARGUMENTS.getDurationMain(), Durations.ARGUMENTS.getDurationOut());
                return false;
            }
            player.openInventory(Challanges.getChallenges().getUtil().getClickGUI().getInventory());

        }
        return false;

    }
}
