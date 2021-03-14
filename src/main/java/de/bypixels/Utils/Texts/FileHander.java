package de.bypixels.Utils.Texts;

import de.bypixels.Challanges;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;

public class FileHander {

    private File file = new File(Challanges.getChallenges().getDataFolder(), "settings.yml");
    ;
    private FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);

    public String getMessage(String path) {
        return configuration.getString(path);
    }

    public boolean getBoolean(String path) {
        return configuration.getBoolean(path);
    }

   public int getInteger(String path){
        return configuration.getInt(path);
    }

    public FileHander() throws IOException, InvalidConfigurationException {
        configuration.addDefault("prefix", "&7[&3Pixels-Challanges§7]&f ");
        configuration.addDefault("oneblock.title", "&aChallange started!");
        configuration.addDefault("oneblock.message", "&7OneBlock Challenge started!");
        configuration.addDefault("error.title", "&4ERROR");
        configuration.addDefault("error.message", "&cAn Error accured!");
        configuration.addDefault("arguments.title", "&4Argument Lenght");
        configuration.addDefault("argument.message", "&cNot Enought or too many arguments!");
        configuration.addDefault("permission.title", "&4No Permission");
        configuration.addDefault("permission.message", "&cYou dont have the Permission to do so!");
        configuration.addDefault("blockstep.title", "&4Wrong Block");
        configuration.addDefault("blockstep.message", "&cYou stepped on the wrong Block!");
        configuration.addDefault("mustplayer.message", "&cYou must be a Player to do this!");
        configuration.set("animation.wrongstep.in", 10);
        configuration.set("animation.wrongstep.main", 70);
        configuration.set("animation.wrongstep.out", 10);
        configuration.set("animation.oneblock.in", 10);
        configuration.set("animation.oneblock.main", 70);
        configuration.set("animation.oneblock.out", 10);
        configuration.set("animation.permission.in", 10);
        configuration.set("animation.permission.main", 70);
        configuration.set("animation.permission.out", 10);
        configuration.set("animation.arguments.in", 10);
        configuration.set("animation.arguments.main", 70);
        configuration.set("animation.arguments.out", 10);


        configuration.options().copyDefaults(true);
        configuration.save(file);
    }
}