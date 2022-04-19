package de.dopebrot;

import de.dopebrot.inventory.EArmorSlot;
import de.dopebrot.item.SwordItem;
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
    private MessageManager gMessage;

    public CommandManager(Game game, Player player) {
        this.game = game;
        this.player = player;
        this.gMessage = game.message;
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
                gMessage.gameMessage("Unfortunately this feature is not done yet.");
                gMessage.gameMessage("Blame this on DopeBrot");
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
                gMessage.gameMessage("You hit yourself -5 HP");
                break;
            case "save":
            case "sleep":
                if (player.getCurrentLocation().equals(Locations.HOME)) {
                    game.save();
                } else {
                    gMessage.gameMessage(250, "You are not at Home");
                }
                break;
            case "item":
                itemInfo();
                break;
            case "switch":
                itemSwitch();
                break;
            default:
                break;
        }
    }

    private void help() {
        gMessage.splitterMessage("--------<I>--------");
        gMessage.gameMessage(250, "Commands:");
        gMessage.gameMessage(150, "\tHelp/Info : shows this screen");
        gMessage.gameMessage(150, "\tPlayer : shows player stats");
        gMessage.gameMessage(150, "\tEnemy : shows enemy stats");
        gMessage.gameMessage(150, "\tInventory : opens your inventory");
        gMessage.gameMessage(150, "\tShop : shows items you can but at the shop");
        gMessage.gameMessage(150, "\tGoto : moves to another location.");
        gMessage.splitterMessage("--------<I>--------");
    }

    private void changeMap() {
        if (game.canChangeLocation) {
            if (args != null) {
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
                        gMessage.gameMessage(100, "Sorry but \"" + args.get(0) + "\" is no Location. try \"Home\",\"Shop\",\"Dungeon\"");
                        break;
                }
            } else {
                gMessage.gameMessage("Please Choose a destination like \"Home\",\"Shop\",\"Dungeon\"");
            }
        } else {
            gMessage.gameMessage("you can't travel right now!");
        }
    }

    private void infoPlayer() {
        gMessage.splitterMessage("---- " + player.getUsername() + "'s Stats ----");
        gMessage.splitterMessage(" Health: " + player.getHealth() + " / " + player.getMaxHealth());
        gMessage.splitterMessage(" Mana: " + player.getMana() + " / " + player.getMaxMana());
        gMessage.splitterMessage(" Level: " + player.getLevel());
        gMessage.splitterMessage(" Exp: " + player.getExp() + " / " + player.getNextlevelexp());
        gMessage.splitterMessage(" Schmeckels: " + player.getCoins());
        gMessage.splitterMessage(" Kills: " + player.getKills());
        gMessage.splitterMessage(" Hand: " + player.getInventory().getItem(0).getDisplayName());
        gMessage.splitterMessage(" Amor:");
        gMessage.splitterMessage("  > Head: " + player.getArmorInventory().getArmor(EArmorSlot.HEAD).getDisplayName());
        gMessage.splitterMessage("  > Chest: " + player.getArmorInventory().getArmor(EArmorSlot.CHEST).getDisplayName());
        gMessage.splitterMessage("  > Legs: " + player.getArmorInventory().getArmor(EArmorSlot.LEG).getDisplayName());
        gMessage.splitterMessage("  > Foot: " + player.getArmorInventory().getArmor(EArmorSlot.FOOT).getDisplayName());
        gMessage.splitterMessage("---- " + gMessage.replaceLenght(player.getUsername(), '-') + "-------- ----");
        gMessage.splitterMessage(" ");
    }

    private void clearChat() {
        for (int i = 0; i < 50; i++) {
            gMessage.splitterMessage(" ");
        }
    }

    private void itemInfo() {
        gMessage.splitterMessage("--- -- " + player.getInventory().getItem(0).getDisplayName()+ "'s Stats" + " -- ---");
        switch (player.getInventory().getItem(0).getItemClass()) {
            case SwordItem:
                SwordItem item = (SwordItem) player.getInventory().getItem(0);
                for (int i = 0; i < item.getStats().size(); i++) {
                    gMessage.splitterMessage(item.getStats().get(i));
                }
                break;
            case HealPotionItem:
                break;
            default:
                gMessage.splitterMessage("This item has no Stats!");
                break;
        }
        gMessage.splitterMessage("--- -- " + gMessage.replaceLenght(player.getInventory().getItem(0).getDisplayName() + "'s Stats",'-') + " -- ---");


    }

    private void itemSwitch() {
        int slotfrom = 1;
        int slotto = 0;
        if (args != null) {
            if (args.size() == 1) {
                try {
                    slotfrom = Integer.parseInt(args.get(0));
                } catch (NumberFormatException e) {
                    gMessage.gameMessage(250, args.get(0) + " is not a Number!");
                }
                player.getInventory().switchItem(slotfrom, slotto);
                gMessage.gameMessage(250, "Switched Items: " + player.getInventory().getItem(slotfrom).getDisplayName() + " <-> " + player.getInventory().getItem(slotto).getDisplayName());
            } else if (args.size() >= 2) {
                try {
                    slotfrom = Integer.parseInt(args.get(0));
                } catch (NumberFormatException e) {
                    gMessage.gameMessage(250, args.get(0) + " is not a Number!");
                    return;
                }
                try {
                    slotto = Integer.parseInt(args.get(1));
                } catch (NumberFormatException e) {
                    gMessage.gameMessage(250, args.get(0) + " is not a Number!");
                    return;
                }
                player.getInventory().switchItem(slotfrom, slotto);
                gMessage.gameMessage(250, "Switched Items: " + player.getInventory().getItem(slotfrom).getDisplayName() + " <-> " + player.getInventory().getItem(slotto));
            }
            args.clear();
        }
    }

}
