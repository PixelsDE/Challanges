package de.bypixels.Utils;

import de.bypixels.Challanges;
import de.bypixels.Utils.GUIs.ClickGUI;
import de.bypixels.Utils.Texts.Durations;
import de.bypixels.Utils.Texts.FileHander;
import de.bypixels.Utils.Texts.Messages;
import de.bypixels.challanges.OneBlock;
import de.bypixels.challanges.RandomDrops;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.inventory.Inventory;

import java.io.IOException;
import java.util.ArrayList;

public class Util {

    private Messages messages;

    public Util() {
        items = new Items();

    }

    public void setup() {
        clickGUI = new ClickGUI(27, "§dChallanges Inventory");
        addInventories();
    }

    private Items items;

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

    private RandomDrops randomDrops = new RandomDrops();

    public RandomDrops getRandomDrops() {
        return randomDrops;
    }

    public void addInventories() {
        inventories.add(Challanges.getChallenges().getUtil().getClickGUI().getInventory());
        inventories.add(getRandomDrops().getRandromDropInventory());
    }
}


