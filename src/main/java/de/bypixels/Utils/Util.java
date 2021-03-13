package de.bypixels.Utils;

import de.bypixels.challanges.RandomDrops;

public class Util {

    private Messages messages;

    public Util( ) {
          }

    public Messages getMessages() {
        return messages;
    }

    private ClickGUI clickGUI= new ClickGUI();

    public ClickGUI getClickGUI() {
        return clickGUI;
    }

    private RandomDrops randomDrops = new RandomDrops();

    public RandomDrops getRandomDrops() {
        return randomDrops;
    }
}


