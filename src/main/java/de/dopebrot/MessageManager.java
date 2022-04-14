package de.dopebrot;

import java.util.concurrent.TimeUnit;

public class MessageManager {

    private final int messageDelay = 1550;
    private final Game game;

    public MessageManager(Game game) {
        this.game = game;
    }

    public void gameMessage(int delayMS, String text) {
        try {
            TimeUnit.MILLISECONDS.sleep(delayMS);
            System.out.println(" DOD]: " + text);
        } catch (InterruptedException e) {
            debugMessage("could not delay message: " + e.getMessage());
            System.out.println(" DOD]: " + text);
        }
    }

    public void gameMessage(String text) {
        try {
            TimeUnit.MILLISECONDS.sleep(messageDelay);
            System.out.println(" DOD]: " + text);
        } catch (InterruptedException e) {
            debugMessage("could not delay message: " + e.getMessage());
            System.out.println(" DOD]: " + text);
        }
    }

    public void actionMessage(int delayMS, String istrue, String isfalse) {
        try {
            TimeUnit.MILLISECONDS.sleep(messageDelay);
            System.out.println(" --- [" + isfalse + "] [" + istrue + "] ---");
        } catch (InterruptedException e) {
            debugMessage("could not delay message: " + e.getMessage());
            System.out.println(" --- [" + isfalse + "] [" + istrue + "] ---");
        }
    }

    public void splitterMessage(String splitter) {
        System.out.println(splitter);
    }

    public int interactiveMessage(String input) {
        switch (input.toLowerCase()) {
            case "yes":
            case "ya":
            case "ok":
            case "1":
            case "true":
                return 1;
            case "no":
            case "na":
            case "nope":
            case "0":
            case "false":
                return 0;
        }
        return 2;
    }

    public void transitionText(String text) {
        System.out.println(text);
    }

    public void transitionText(int amount, String text) {
        for (int i = 0; i < amount; i++) {
            System.out.println(text);
        }
    }

    public void delay(int delayMS) {
        try {
            TimeUnit.MILLISECONDS.sleep(delayMS);
        } catch (InterruptedException e) {
            debugMessage("cant delay :delay: " + e.getMessage());

        }
    }


    public String replaceLenght(String s, char c) {
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            s1 = s1 + c;
        }
        return s1;
    }


    public void transitionText(int delay, int amount, String text) {
        for (int i = 0; i < amount; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
                System.out.println(text);
            } catch (InterruptedException e) {
                debugMessage("cant delay message :delayedTransition: " + e.getMessage());
                System.out.println(text);
            }
        }

    }


    public void debugMessage(String text) {
        if (Main.showDebug) {
            System.out.println(" DB]: " + text);
        }
    }


}
