package de.bypixels.Utils;

import de.bypixels.Challanges;
import de.bypixels.challanges.OneBlock;
import de.bypixels.challanges.RandomDrops;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EventGUIHandler extends ClickGUI implements Listener {
    private Challanges plugin;

    public EventGUIHandler(Challanges plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onUseGUIInventory(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();

        if (event.getInventory().equals(Challanges.getChallenges().getUtil().getClickGUI().getInventory())) {
            if (!player.hasPermission("challanges.gui")) {
                event.setCancelled(true);
                player.updateInventory();
                return;
            }
            Inventory inventory = event.getInventory();
            event.setCancelled(true);
            Challanges.getChallenges().getUtil().getClickGUI().enchantmentSwitch(event.getCurrentItem());
            player.updateInventory();
            if (item.getItemMeta().getDisplayName().equals(Challanges.getChallenges().getUtil().getClickGUI().oneblock().getItemMeta().getDisplayName()))
                oneBlockItem(player, item);
        }else if (event.getInventory().equals(Challanges.getChallenges().getUtil().getRandomDrops().getRandromDropInventory())){
            randomDropInventory(item, player, event);

        }
    }


    private void oneBlockItem(Player player, ItemStack item) {
        if (!player.hasPermission("challange.oneblock")) return;
        if (item.getItemMeta().hasEnchants()) {
            OneBlock.challangeStarted = true;
            OneBlock.block = player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType();
            player.sendTitle(Messages.ONEBLOCK.getMessageTitle(), Messages.PREFIX.getMessage() + Messages.ONEBLOCK.getMessage(), 20, 70, 10);
            Bukkit.getPluginManager().registerEvents(new OneBlock(Challanges.getChallenges()), Challanges.getChallenges());
        } else {
            OneBlock.challangeStarted = false;
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.setDeathMessage(null);
    }


    //TODO: Event fürs random drop machen

    private void randomDropInventory(ItemStack item, Player player, InventoryClickEvent event){
        if (!player.hasPermission("challanges.gui")) {
            event.setCancelled(true);
            player.updateInventory();
            return;
        }

    }

}
