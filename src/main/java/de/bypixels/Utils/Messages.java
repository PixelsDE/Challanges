package de.bypixels.Utils;

import de.bypixels.Challanges;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public enum Messages {

    ONEBLOCK(Challanges.getChallenges().getFileHander().getMessage("oneblock.title"), Challanges.getChallenges().getFileHander().getMessage("oneblock.message")),
    ERROR(Challanges.getChallenges().getFileHander().getMessage("error.title"), Challanges.getChallenges().getFileHander().getMessage("error.message")),
    ARGUMENTS(Challanges.getChallenges().getFileHander().getMessage("arguments.title"), Challanges.getChallenges().getFileHander().getMessage("arguments.message")),
    PERMISSION(Challanges.getChallenges().getFileHander().getMessage("permission.title"),  Challanges.getChallenges().getFileHander().getMessage("permission.message")),
    BLOCKSTEP(Challanges.getChallenges().getFileHander().getMessage("blockstep.title"), Challanges.getChallenges().getFileHander().getMessage("blockstep.message")),
    MUSTBEPLAYER(null, Challanges.getChallenges().getFileHander().getMessage("mustplayer.message")),
    PREFIX(null, Challanges.getChallenges().getFileHander().getMessage("prefix"));



    String messageTitle, message;

    Messages(String messageTitle, String message) {
        this.messageTitle = messageTitle;
        this.message = message;
    }


    public String getMessage() {
        return ChatColor.translateAlternateColorCodes('&',message);
    }


    public String getMessageTitle() {
        return ChatColor.translateAlternateColorCodes('&', messageTitle);
    }
}
