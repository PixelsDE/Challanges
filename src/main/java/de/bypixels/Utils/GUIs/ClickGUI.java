package de.bypixels.Utils.GUIs;

import de.bypixels.Challanges;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;


public class ClickGUI extends GUI {


    public ClickGUI(int inventorySize, String inventoryName) {
        super(inventorySize, inventoryName);
        createInventory();
        addItem(9, Challanges.getChallenges().getUtil().getItems().OneBlockItem);
    }


}
