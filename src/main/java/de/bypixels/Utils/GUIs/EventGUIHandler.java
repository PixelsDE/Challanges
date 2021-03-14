package de.bypixels.Utils.GUIs;

import de.bypixels.Challanges;
import de.bypixels.Utils.Texts.Durations;
import de.bypixels.Utils.Texts.Messages;
import de.bypixels.challanges.OneBlock;
import org.bukkit.Bukkit;
import org.bukkit.block.BlockFace;
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

        if (inventory.equals(Challanges.getChallenges().getUtil().getClickGUI().getInventory())) {

            Challanges.getChallenges().getUtil().getItems().enchantmentSwitch(item);

            if (item.getItemMeta().getDisplayName().equals(Challanges.getChallenges().getUtil().getItems().OneBlockItem().getItemMeta().getDisplayName()))
                oneBlockItem(player, item);
            else if (inventory.equals(Challanges.getChallenges().getUtil().getRandomDrops().getRandromDropInventory()))
                randomDropInventory(item, player);

        }

    }


    private void oneBlockItem(Player player, ItemStack item) {
        if (!player.hasPermission("challange.oneblock")) return;

        if (item.getItemMeta().hasEnchants()) {
            OneBlock.challangeStarted = true;
            OneBlock.setBlock(player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType());
            player.sendTitle(Messages.ONEBLOCK.getMessageTitle(), Messages.PREFIX.getMessage() + Messages.ONEBLOCK.getMessage(), Durations.ONEBLOCK.getDurationIn(), Durations.ONEBLOCK.getDurationMain(),Durations.WRONGSTEP.getDurationOut());
            Bukkit.getPluginManager().registerEvents(new OneBlock(Challanges.getChallenges()), Challanges.getChallenges());
        } else {
            OneBlock.challangeStarted = false;
        }
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
