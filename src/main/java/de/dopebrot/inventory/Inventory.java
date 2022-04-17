package de.dopebrot.inventory;

import de.dopebrot.Game;
import de.dopebrot.item.Item;
import de.dopebrot.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Item> items;
    private final Player player;
    private final Game game;
    public int size;

    public Inventory(Player player, Game game) {
        this.size = 12;
        this.items = new ArrayList<>(size);
        this.player = player;
        this.game = game;
    }

    // gets item from inventory
    public Item getItem(int slot) {
        return items.get(slot);
    }


    // adds item to inventory
    public void addItem(Item item) {
        items.add(item);
    }

    //switches items from slot 1 to slot 2
    public void switchItem(int slotPrev, int slotNext) {
        Item tmp = items.get(slotNext);
        items.set(slotNext, items.get(slotPrev));
        items.set(slotPrev, tmp);
    }

    public void removeItem(int slot) {
        items.remove(slot);
    }


}
