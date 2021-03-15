package de.bypixels;

import de.bypixels.Utils.GUIs.EventGUIHandler;
import de.bypixels.Utils.Texts.FileHander;
import de.bypixels.Utils.Texts.Messages;
import de.bypixels.Utils.Util;
import de.bypixels.Utils.GUIs.ChallangesMainGUICommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

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
        //Initiate UTIL
        util = new Util();
        try {
            this.getUtil().setFileHander(new FileHander());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        util.setup();
        Prefix = Messages.PREFIX.getMessage();

        eventGUIHandler = new EventGUIHandler(this);
        challangesMainGUICommand = new ChallangesMainGUICommand();
        pluginManager.registerEvents(eventGUIHandler, this);
        this.getCommand("challanges").setExecutor(getChallangesMainGUICommand());
    }

    private EventGUIHandler eventGUIHandler;

    public EventGUIHandler getEventGUIHandler() {
        return eventGUIHandler;
    }
    private ChallangesMainGUICommand challangesMainGUICommand;

    public ChallangesMainGUICommand getChallangesMainGUICommand() {
        return challangesMainGUICommand;
    }

    private static Challanges challenges;

    private Util util;

    private String Prefix;

    public String getPrefix() {
        return Prefix;
    }

    public Util getUtil() {
        return util;
    }

    public void setUtil(Util util) {
        this.util = util;
    }

    public static Challanges getChallenges() {
        return challenges;
    }


}
