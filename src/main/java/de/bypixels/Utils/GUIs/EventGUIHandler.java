package de.bypixels.Utils.GUIs;

import de.bypixels.Challanges;
import de.bypixels.Utils.Texts.Durations;
import de.bypixels.Utils.Texts.Messages;
import de.bypixels.challanges.OneBlock;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class EventGUIHandler extends GUI implements Listener {
    private Challanges plugin;

    public EventGUIHandler(Challanges plugin) {

        this.plugin = plugin;
    }

    //@Method: Main Click Method for GUIs
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onUseGUIInventory(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        Inventory inventory = event.getClickedInventory();


        if (!Challanges.getChallenges().getUtil().getInventories().contains(inventory))
            return;


        event.setCancelled(true);
        player.updateInventory();
        if (!player.hasPermission("challanges.gui"))
            return;




        if (!(inventory == Challanges.getChallenges().getUtil().getClickGUI().getInventory())) return;


        //gets the Item
        // that was "Clicked"
        if (item.getItemMeta().getDisplayName().equals(Challanges.getChallenges().getUtil().getItems().OneBlockItem.getItemMeta().getDisplayName())) {
            if (!item.getItemMeta().hasEnchants()) {
                Bukkit.getPluginManager().registerEvents(Challanges.getChallenges().getUtil().getOneBlock(), Challanges.getChallenges());
                Challanges.getChallenges().getUtil().getOneBlock().startChallange(player, item);
                Challanges.getChallenges().getUtil().getOneBlock().getPlayersInChallange().add(player.getUniqueId());
            } else {
                Challanges.getChallenges().getUtil().getOneBlock().getPlayersInChallange().remove(player.getUniqueId());
                Challanges.getChallenges().getUtil().getOneBlock().getBlock().remove(player.getUniqueId());
                player.sendTitle(Messages.STOP.getMessageTitle(), Messages.PREFIX.getMessage() + Messages.STOP.getMessage(), Durations.STOP.getDurationIn(), Durations.STOP.getDurationMain(), Durations.STOP.getDurationOut());
            }
        } else if (item.getItemMeta().getDisplayName().equals(Challanges.getChallenges().getUtil().getItems().RandomDropGUIItem.getItemMeta().getDisplayName())) {
            if (!player.hasPermission("gui.backtomaingui")) return;
            player.closeInventory();
            player.openInventory(Challanges.getChallenges().getUtil().getInventories().get(1));
            Bukkit.getPluginManager().registerEvents(Challanges.getChallenges().getUtil().getRandomInventoryGUI(), Challanges.getChallenges());
        }


        //Colors the Item
        checkEnchantmentSwitch(item);


    }


    //@Method: Anti Death Message
    @EventHandler(ignoreCancelled = true)
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.setDeathMessage(null);
    }


}
