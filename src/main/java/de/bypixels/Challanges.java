package de.bypixels;

import de.bypixels.Utils.EventGUIHandler;
import de.bypixels.Utils.FileHander;
import de.bypixels.Utils.Messages;
import de.bypixels.Utils.Util;
import de.bypixels.challanges.ChallangesGUI;
import de.bypixels.challanges.OneBlock;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class Challanges extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
        challenges = this;
        init(Bukkit.getPluginManager());
        Bukkit.getConsoleSender().sendMessage(Messages.PREFIX.getMessage() + "§aServer and Plugin started!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    private void init(PluginManager pluginManager) {
        try {
            fileHander = new FileHander();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        pluginManager.registerEvents(new EventGUIHandler(this), this);
        this.getCommand("challanges").setExecutor(new ChallangesGUI(this));
    }
    //TODO: Random drop und random craft Challange + Inventar erstellen



    private Util util = new Util();
    private static Challanges challenges;

    public static Challanges getChallenges() {
        return challenges;
    }

    public Util getUtil() {
        return util;
    }

    private FileHander fileHander;

    public FileHander getFileHander() {
        return fileHander;
    }
}
