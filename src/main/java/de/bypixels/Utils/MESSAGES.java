package de.bypixels.Utils;

public enum MESSAGES {

    ONEBLOCK("§aChallange started!", "§aOneBlock Challenge started!"),
    ERROR("ERROR", "§cAn Error accured!"),
    ARGUMENTS("§cArgument Lenght", "§cNot Enought or too many arguments!"),
    PERMISSION("§cNo Permission", "§cYou dont have the Permission to do so!"),
    BLOCKSTEP(null, "§cYou stepped on the wrong Block!");

    String messageTitle, message;

    MESSAGES(String messageTitle, String message) {
        this.messageTitle = messageTitle;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


    public String getMessageTitle() {
        return messageTitle;
    }
}
