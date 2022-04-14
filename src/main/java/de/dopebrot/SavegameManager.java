package de.dopebrot;

import de.dopebrot.player.inventory.Item;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class SavegameManager {

    private File file;
    private Properties properties;
    private Game game;

    public SavegameManager(File savefile) {

    }


    public void save() {

    }

    public Game load() {
        game.player.setCurrentLocation(Locations.valueOf(properties.getProperty("player.location")));
        game.player.setCoins(Integer.parseInt(properties.getProperty("player.coins")));
        game.player.setKills(Integer.parseInt(properties.getProperty("player.kills")));
        game.player.setExp(Float.parseFloat(properties.getProperty("player.exp")));
        game.player.setHealth(Float.parseFloat(properties.getProperty("player.health")));
        game.player.setMaxHealth(Float.parseFloat(properties.getProperty("player.maxhealth")));
        game.player.setLevel(Integer.parseInt(properties.getProperty("player.level")));
        game.player.setMana(Float.parseFloat(properties.getProperty("player.mana")));
        game.player.setMaxMana(Float.parseFloat(properties.getProperty("player.maxmana")));



        game.player.setInventory();

        return game;
    }


}
