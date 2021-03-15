package de.bypixels.Utils;

import de.bypixels.Challanges;
import de.bypixels.Utils.GUIs.ClickGUI;
import de.bypixels.Utils.GUIs.EventGUIHandler;
import de.bypixels.Utils.GUIs.RandomInventoryGUI;
import de.bypixels.Utils.Texts.Durations;
import de.bypixels.Utils.Texts.FileHander;
import de.bypixels.Utils.Texts.Messages;
import de.bypixels.challanges.OneBlock;
import de.bypixels.challanges.RandomDrops;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Util {

    public void setup() {
        items = new Items();
        getRandomDrops().setupChallange();
       clickGUI = new ClickGUI(27,  "§dChallanges Inventory");
        randomInventoryGUI= new RandomInventoryGUI(9, "§3Random Drop Inventory");
        addInventories();
    }

    public void addInventories() {
        inventories.add(clickGUI.getInventory());
        inventories.add(randomInventoryGUI.getInventory());
    }


    private EventGUIHandler eventGUIHandler;

    public EventGUIHandler getEventGUIHandler() {
        return eventGUIHandler;
    }

    public void setEventGUIHandler(EventGUIHandler eventGUIHandler) {
        this.eventGUIHandler = eventGUIHandler;
    }

    private Items items;

    private HashMap<UUID, List[]> playerChallanges = new HashMap<>();

    public Items getItems() {
        return items;
    }

    private ClickGUI clickGUI;

    public ClickGUI getClickGUI() {
        return clickGUI;
    }

    private FileHander fileHander;

    public FileHander getFileHander() {
        return fileHander;
    }

    public void setFileHander(FileHander fileHander) {
        this.fileHander = fileHander;
    }

    private ArrayList<Inventory> inventories = new ArrayList<>();

    public ArrayList<Inventory> getInventories() {
        return inventories;
    }


    private RandomInventoryGUI randomInventoryGUI;

    private RandomDrops randomDrops = new RandomDrops();

    public RandomDrops getRandomDrops() {
        return randomDrops;
    }

    public RandomInventoryGUI getRandomInventoryGUI() {
        return randomInventoryGUI;
    }

}


