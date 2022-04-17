package de.dopebrot.player;


import de.dopebrot.Game;
import de.dopebrot.inventory.Inventory;
import de.dopebrot.item.Item;

import java.util.ArrayList;

public class Player {


    private String username;
    private Locations currentLocation;
    private int coins;
    private int level;
    private int kills;

    private float maxHealth;
    private float health;
    private float maxMana;
    private float mana;
    private float exp;
    private float nextlevelexp;
    private Inventory inventory;
    private Game game;


    public Player(String username, Game game) {
        this.game = game;
        this.username = username;
        this.currentLocation = Locations.HOME;
        this.coins = 15;
        this.level = 1;
        this.kills = 0;
        this.exp = 0f;
        this.nextlevelexp = 15f;
        this.health = 100f;
        this.maxHealth = 100f;
        this.mana = 50f;
        this.maxMana = 50f;
        this.inventory = new Inventory(this, game);
    }

    public Locations getCurrentLocation() {
        return this.currentLocation;
    }


    public String getUsername() {
        return username;
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    public float getHealth() {
        return health;
    }

    public float getMaxMana() {
        return maxMana;
    }

    public float getMana() {
        return mana;
    }

    public int getCoins() {
        return coins;
    }

    public int getLevel() {
        return level;
    }

    public int getKills() {
        return this.kills;
    }


    public float getExp() {
        return exp;
    }

    public float getNextlevelexp() {
        return nextlevelexp;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setCurrentLocation(Locations location) {
        this.currentLocation = location;
    }

    public void setCoins(int coins) {
        coins = coins;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setMaxHealth(float maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public void setMaxMana(float maxMana) {
        this.maxMana = maxMana;
    }

    public void setMana(float mana) {
        this.mana = mana;
    }

    public void setExp(float exp) {
        this.exp = exp;
    }

    public void setNextlevelexp(float nextlevelexp) {
        this.nextlevelexp = nextlevelexp;
    }



}
