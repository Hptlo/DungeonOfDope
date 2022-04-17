package de.dopebrot;

import de.dopebrot.player.Locations;
import de.dopebrot.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandManager {

    private Game game;
    private String cmdName;
    private List<String> args;
    private Player player;

    public CommandManager(Game game, Player player) {
        this.game = game;
        this.player = player;
    }

    public void parseCommand(String userInput) {
        ArrayList<String> args = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        String parsedString = userInput;
        parsedString = parsedString.trim();
        if (parsedString.contains(" ")) {
            if (parsedString.split(" ").length > 0) {
                parsedString = parsedString.replaceAll("[ ]{2,}", " ");
                Collections.addAll(args, parsedString.split(" "));
                this.cmdName = args.get(0);
                args.remove(0);
                this.args = args;
            }
        } else {
            this.cmdName = parsedString;
        }
        findCommand();
    }

    public void findCommand() {
        switch (cmdName.toLowerCase()) {
            case "help":
            case "info":
            case "h":
                help();
                break;
            case "player":
            case "p":
                infoPlayer();
                break;
            case "enemy":
                game.message.gameMessage("Unfortunately this feature is not done yet.");
                game.message.gameMessage("Blame this on DopeBrot");
                break;
            case "goto":
                changeMap();
                break;
            case "clear":
            case "cc":
            case "clearchat":
                clearChat();
                break;
            case "damageme":
                game.message.gameMessage("You hit yourself -5 HP");
                break;
            case "save":
            case "sleep":
                if (player.getCurrentLocation().equals(Locations.HOME)) {
                    game.save();
                } else {
                    game.message.gameMessage(250,"You are not at Home");
                }
                break;
            default:
                break;
        }
    }

    private void help() {
        game.message.splitterMessage("--------<I>--------");
        game.message.gameMessage(250, "Commands:");
        game.message.gameMessage(150, "\tHelp/Info : shows this screen");
        game.message.gameMessage(150, "\tPlayer : shows player stats");
        game.message.gameMessage(150, "\tEnemy : shows enemy stats");
        game.message.gameMessage(150, "\tInventory : opens your inventory");
        game.message.gameMessage(150, "\tShop : shows items you can but at the shop");
        game.message.gameMessage(150, "\tGoto : moves to another location.");
        game.message.splitterMessage("--------<I>--------");
    }

    private void changeMap() {
        if (game.canChangeLocation) {
            if (args.size() > 0) {
                switch (args.get(0).toLowerCase()) {
                    case "h":
                    case "b":
                    case "home":
                    case "base":
                    case "safe":
                        game.changeLocation(Locations.HOME);
                        break;
                    case "d":
                    case "dungeon":
                    case "farming":
                    case "adventure":
                        game.changeLocation(Locations.DUNGEON);
                        break;
                    case "shop":
                    case "town":
                    case "s":
                    case "t":
                        game.changeLocation(Locations.SHOP);
                        break;
                    default:
                        game.message.gameMessage(100, "Sorry but this Location was not found. try (Home, Dungeon, Shop)");
                        break;
                }
            }
        } else {
            game.message.gameMessage("you can't travel right now!");
        }
    }

    private void infoPlayer() {
        game.message.splitterMessage("---- " + player.getUsername() + "'s Stats ----");
        game.message.splitterMessage(" Health: " + player.getHealth() + " / " + player.getMaxHealth());
        game.message.splitterMessage(" Mana: " + player.getMana() + " / " + player.getMaxMana());
        game.message.splitterMessage(" Level: " + player.getLevel());
        game.message.splitterMessage(" Exp: " + player.getExp() + " / " + player.getNextlevelexp());
        game.message.splitterMessage(" Schmeckels: " + player.getCoins());
        game.message.splitterMessage(" Kills: " + player.getKills());
//        game.message.splitterMessage(" Hand: " + player.getInventory().getItem(0).getDisplayName());
//        game.message.splitterMessage(" Amor:");
//        game.message.splitterMessage("  > Head: " + player.getInventory().getArmor(ArmorSlot.HELMET).getDisplayName());
//        game.message.splitterMessage("  > Chest: " + player.getInventory().getArmor(ArmorSlot.CHESTPLATE).getDisplayName());
//        game.message.splitterMessage("  > Legs: " + player.getInventory().getArmor(ArmorSlot.LEGGINGS).getDisplayName());
//        game.message.splitterMessage("  > Foot: " + player.getInventory().getArmor(ArmorSlot.BOOTS).getDisplayName());
        game.message.splitterMessage("---- " + game.message.replaceLenght(player.getUsername(), '-') + "-------- ----");
        game.message.splitterMessage(" ");
    }

    private void clearChat() {
        for (int i = 0; i < 50; i++) {
            game.message.splitterMessage(" ");
        }
    }

}
