package de.bypixels;

import de.bypixels.Utils.Util;
import de.bypixels.challanges.OneBlock;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Challanges extends JavaPlugin {



    private static Util util = new Util();
    private static Challanges challenges;

    public static Challanges getChallenges() {
        return challenges;
    }

    public static Util getUtil() {
        return util;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        challenges = this;
        init(Bukkit.getPluginManager());
        Bukkit.getConsoleSender().sendMessage("§aServer and Plugin started!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    private void init(PluginManager pluginManager){
        pluginManager.registerEvents(new OneBlock(this), this);

        this.getCommand("OneBlock").setExecutor(new OneBlock(this));
    }
}
