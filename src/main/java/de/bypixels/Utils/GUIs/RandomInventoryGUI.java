package de.bypixels.Utils.GUIs;

import de.bypixels.Challanges;
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
        addItem(Challanges.getChallenges().getUtil().getItems().BackDoorItem, 8);

    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);
        player.updateInventory();
        ItemStack item = event.getCurrentItem();
        if (!inventory.equals(getInventory())) return;
        if (!player.hasPermission("challanges.gui.randomgui")) return;
        if (item.getItemMeta().equals(Challanges.getChallenges().getUtil().getItems().BackDoorItem.getItemMeta())){
            player.closeInventory();
            player.openInventory(Challanges.getChallenges().getUtil().getClickGUI().getInventory());
        }

        //TODO: Items und ereignisse hier adden

    }

    //TODO: Random drop und random craft Challange
}
