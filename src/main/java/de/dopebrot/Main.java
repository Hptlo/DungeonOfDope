package de.dopebrot;

import de.dopebrot.player.Player;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    private static Scanner reader;

    public static boolean showDebug;

    private static boolean checkUsername(String s) {
        boolean isSupported = true;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                case 'A':
                case 'b':
                case 'B':
                case 'c':
                case 'C':
                case 'd':
                case 'D':
                case 'e':
                case 'E':
                case 'f':
                case 'F':
                case 'g':
                case 'G':
                case 'h':
                case 'H':
                case 'i':
                case 'I':
                case 'j':
                case 'J':
                case 'k':
                case 'K':
                case 'l':
                case 'L':
                case 'm':
                case 'M':
                case 'n':
                case 'N':
                case 'o':
                case 'O':
                case 'p':
                case 'P':
                case 'q':
                case 'Q':
                case 'r':
                case 'R':
                case 's':
                case 'S':
                case 't':
                case 'T':
                case 'u':
                case 'U':
                case 'v':
                case 'V':
                case 'w':
                case 'W':
                case 'x':
                case 'X':
                case 'y':
                case 'Y':
                case 'z':
                case 'Z':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    break;
                default:
                    isSupported = false;
                    break;
            }
        }
        return isSupported;
    }

    private static void delayedTransition(int delayMS, int repeatAmount, String text) {
        for (int i = 0; i < repeatAmount; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(delayMS);
                message.transitionText(text);
            } catch (InterruptedException e) {
                message.debugMessage("cant delay message :delayedTransition: " + e.getMessage());
                message.transitionText(text);
            }
        }

    }

    private static void delay(int delayMS) {
        try {
            TimeUnit.MILLISECONDS.sleep(delayMS);
        } catch (InterruptedException e) {
            message.debugMessage("cant delay :delay: " + e.getMessage());

        }
    }


    /*
        1. Messaging System
        2. Command System
        3. Item / Inventory System
        4. Player / Enemy System
        5. Map System
        6. Battle System
    */

    // TODO: Messaging System

    /*
        this is the main class here will the game start in
        prefab is done here before game stats eg:
           savegames / languages / whatever
     */

    private static String username;
    private static Game game;
    private static MessageManager message;
    private static SavegameManager savegameManager;
    private static final File saveFile = new File("savegame.yml");

    public static void main(String[] args) {
        savegameManager = new SavegameManager(saveFile);
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("-debug")) {
                System.out.println("!!! DEBUG MODE IS ACTIVE !!!");
            }
            if (saveFile.exists()) {
                game = savegameManager.load();
            } else {
                System.out.println("!!! This Game creates a Savefile in this Directory !!!");
                savegameManager.save();
            }
        }


        reader = new Scanner(System.in);
        message = new MessageManager(game);
        message.gameMessage(550, "Hello there Adventurer!");
        message.gameMessage(1850, "How would you like to call your Hero?");
        while (username == null) {
            String tmpname = reader.nextLine();
            if (checkUsername(tmpname)) {
                if (tmpname.length() > 15) {
                    message.gameMessage(250, "Oh slow down there Cowboy this name is way to long!");
                } else if (tmpname.length() < 3) {
                    message.gameMessage(250, "Who does read that that's way to short!");
                } else {
                    username = tmpname;
                    message.gameMessage(500, "Okay you're Hero now belongs the name " + username);
                    message.gameMessage(2000, "I don't know what that means but i guess its a good Name!");
                    delay(2000);
                    delayedTransition(555, 10, "\n");
                    try {
                        Thread.sleep(1000);
                        game = new Game(username, new Player(username));
                    } catch (InterruptedException e) {
                        message.debugMessage("Error on timer: " + e.getMessage());
                        game = new Game(username, new Player(username));
                    }

                }
            } else {
                message.gameMessage("Sorry buddy but we only support [A-Z, 1-0]");
            }
        }
    }


}
