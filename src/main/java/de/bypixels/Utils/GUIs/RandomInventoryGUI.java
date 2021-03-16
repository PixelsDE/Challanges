package de.bypixels.Utils.GUIs;

import de.bypixels.Challanges;
import de.bypixels.Utils.Texts.Durations;
import de.bypixels.Utils.Texts.Messages;
import de.bypixels.Utils.Util;
import de.bypixels.challanges.RandomDrops;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RandomInventoryGUI extends GUI implements Listener {
    public RandomInventoryGUI(int inventorySize, String inventoryName) {
        super(inventorySize, inventoryName);
        addItem(Challanges.getChallenges().getUtil().getItems().BackDoorItem, 9);
        addItem(Challanges.getChallenges().getUtil().getItems().RandomDropBreak, 3);

    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.NORMAL)
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();


        if (!Challanges.getChallenges().getUtil().getInventories().contains(inventory))
            return;

        if (!inventory.equals(Challanges.getChallenges().getUtil().getRandomInventoryGUI().getInventory())) return;
        event.setCancelled(true);
        player.updateInventory();
        if (!player.hasPermission("gui.randomgui")) return;

        if (item.getItemMeta().getDisplayName().equals(Challanges.getChallenges().getUtil().getItems().BackDoorItem.getItemMeta().getDisplayName())) {
            player.closeInventory();
            player.openInventory(Challanges.getChallenges().getUtil().getClickGUI().getInventory());
            return;
        }else if (item.getItemMeta().getDisplayName().equals(Challanges.getChallenges().getUtil().getItems().RandomDropBreak.getItemMeta().getDisplayName())){
            if (!item.getItemMeta().hasEnchants()) {
                Challanges.getChallenges().getUtil().getRandomDrops().getPlayersInChallange().add(player.getUniqueId());
                Bukkit.getPluginManager().registerEvents(Challanges.getChallenges().getUtil().getRandomDrops(), Challanges.getChallenges());
                Challanges.getChallenges().getUtil().getRandomDrops().startChallange(player, item);
                checkEnchantmentSwitch(item);
            }else {
                if (Challanges.getChallenges().getUtil().getRandomDrops().getPlayersInChallange().contains(player.getUniqueId()))
                    Challanges.getChallenges().getUtil().getRandomDrops().getPlayersInChallange().remove(player.getUniqueId());
                player.sendTitle(Messages.STOP.getMessageTitle(), Messages.PREFIX.getMessage() + Messages.STOP.getMessage(), Durations.STOP.getDurationIn(), Durations.STOP.getDurationMain(), Durations.STOP.getDurationOut());
                checkEnchantmentSwitch(item);
            }
        }
    }

}
