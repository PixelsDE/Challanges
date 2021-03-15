package de.bypixels.Utils.GUIs;

import de.bypixels.Challanges;
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


public class EventGUIHandler implements Listener {
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

        if (!inventory.equals(Challanges.getChallenges().getUtil().getClickGUI().getInventory())) return;

        //gets the Item
        // that was "Clicked"
        if (item.getItemMeta().equals(Challanges.getChallenges().getUtil().getItems().OneBlockItem.getItemMeta())) {
            oneBlock = new OneBlock();
            Bukkit.getPluginManager().registerEvents(oneBlock, Challanges.getChallenges());
            oneBlock.startChallange(player, item);
        } else if (item.getItemMeta().equals(Challanges.getChallenges().getUtil().getItems().RandomDropGUIItem.getItemMeta())) {
            Bukkit.getPluginManager().registerEvents(Challanges.getChallenges().getUtil().getRandomInventoryGUI(), Challanges.getChallenges());
            player.closeInventory();
            player.openInventory(Challanges.getChallenges().getUtil().getRandomInventoryGUI().getInventory());

        }
        //Colors the Item
        if (item.getType() != Material.ACACIA_DOOR && item.getType() != Material.DIAMOND && item.getType() != GUI.getFillMaterial())
            Challanges.getChallenges().getUtil().getItems().enchantmentSwitch(item);


    }

    private OneBlock oneBlock;

    public OneBlock getOneBlock() {
        return oneBlock;
    }

    //@Method: Anti Death Message
    @EventHandler(ignoreCancelled = true)
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.setDeathMessage(null);
    }


    //TODO: Event fürs random drop machen

    private void randomDropInventory(ItemStack item, Player player) {
        if (!player.hasPermission("challanges.gui"))
            //TODO here
            return;


    }

    private void backToMainGUI(ItemStack item, Player player) {
        if (!player.hasPermission("challanges.gui.random"))
            return;
    }

}
