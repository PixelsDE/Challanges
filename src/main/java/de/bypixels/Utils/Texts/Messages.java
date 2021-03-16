package de.bypixels.Utils.Texts;

import de.bypixels.Challanges;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public enum Messages {

    ONEBLOCK(Challanges.getChallenges().getUtil().getFileHander().getMessage("oneblock.title"), Challanges.getChallenges().getUtil().getFileHander().getMessage("oneblock.message")),
    ERROR(Challanges.getChallenges().getUtil().getFileHander().getMessage("error.title"), Challanges.getChallenges().getUtil().getFileHander().getMessage("error.message")),
    ARGUMENTS(Challanges.getChallenges().getUtil().getFileHander().getMessage("arguments.title"), Challanges.getChallenges().getUtil().getFileHander().getMessage("arguments.message")),
    PERMISSION(Challanges.getChallenges().getUtil().getFileHander().getMessage("permission.title"), Challanges.getChallenges().getUtil().getFileHander().getMessage("permission.message")),
    BLOCKSTEP(Challanges.getChallenges().getUtil().getFileHander().getMessage("blockstep.title"), Challanges.getChallenges().getUtil().getFileHander().getMessage("blockstep.message")),
    MUSTBEPLAYER(Challanges.getChallenges().getUtil().getFileHander().getMessage("mustplayer.message"), Challanges.getChallenges().getUtil().getFileHander().getMessage("mustplayer.message")),
    PREFIX(Challanges.getChallenges().getUtil().getFileHander().getMessage("prefix"), Challanges.getChallenges().getUtil().getFileHander().getMessage("prefix")),
    BLOCKBREAK(Challanges.getChallenges().getUtil().getFileHander().getMessage("random.blockbreak.title"), Challanges.getChallenges().getUtil().getFileHander().getMessage("random.blockbreak.message")),
    STOP(Challanges.getChallenges().getUtil().getFileHander().getMessage("challange.stop.title"), Challanges.getChallenges().getUtil().getFileHander().getMessage("challange.stop.message"));

    String messageTitle, message;

    Messages(String messageTitle, String message) {
        this.messageTitle = messageTitle;
        this.message = message;
    }


    public String getMessage() {
        return ChatColor.translateAlternateColorCodes('&', message);
    }


    public String getMessageTitle() {
        return ChatColor.translateAlternateColorCodes('&', messageTitle);
    }
}
