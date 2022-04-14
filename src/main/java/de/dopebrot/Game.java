package de.dopebrot;

import de.dopebrot.player.Player;

import java.util.Scanner;

public class Game {

    public MessageManager message;
    public Player player;
    public CommandManager commandManager;
    private Scanner reader;


    private boolean isFirstTime;
    private boolean isActionMessage;
    public boolean canExecuteCommands;
    public boolean canChangeLocation;


    public Game(String playerName, Player player) {
        this.player = player;
        message = new MessageManager(this);
        reader = new Scanner(System.in);
        commandManager = new CommandManager(this,player);
        isFirstTime = true;
        isActionMessage = false;
        canExecuteCommands = false;
        canChangeLocation = false;
        if (isFirstTime) {
            tutorial();
        }
    }

    private void tutorial() {
        message.gameMessage("You are now in your home.");
        message.gameMessage(2000, "Do you want to play the Tutorial?");
        message.actionMessage(100, "Yes", "No");
        isActionMessage = true;
        while (isActionMessage) {
            String tempReader = reader.nextLine();
            if (message.interactiveMessage(tempReader) == 1) {
                message.gameMessage(1500, "This could be a tutorial message");
                message.gameMessage(3500, "So this was the tutorial, if you want to get help in the future or get stuck");
                message.gameMessage(4000, "Just type help in the console and i'll see what i can do!");
                message.splitterMessage("----- -----");
                message.transitionText(" ");
                canExecuteCommands = true;
                start();
                isActionMessage = false;
            } else if (message.interactiveMessage(tempReader) == 0) {
                message.gameMessage(1500, "I see you are an expert.");
                message.gameMessage(1500, "Ok for now im gonna leave you.");
                canExecuteCommands = true;
                start();
                isActionMessage = false;
            } else {
                message.gameMessage("Pick \"Yes\" or \"No\", \"" + tempReader + "\" is not an answer");
            }
        }
    }


    public void changeLocation(Locations newLocation) {
        if (!player.getCurrentLocation().equals(newLocation)) {
            canExecuteCommands = false;
            message.gameMessage("Traveling to " + newLocation.displayName);
            message.delay(500);
            message.transitionText(150, 15, " .");
            message.splitterMessage("------ You are now in " + newLocation.displayName + " ------");
            player.setCurrentLocation(newLocation);
            message.transitionText(" ");
            canExecuteCommands = true;
        } else {
            message.gameMessage(250, "You are already in " + newLocation.displayName);
        }
    }






    public void start() {
        canChangeLocation = true;
        while (canExecuteCommands) {
            commandManager.parseCommand(reader.nextLine());
        }
    }

}
