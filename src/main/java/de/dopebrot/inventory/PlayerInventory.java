package de.dopebrot.inventory;

import de.dopebrot.Game;
import de.dopebrot.item.*;
import de.dopebrot.player.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerInventory {

    private List<IItem> items;
    private final Player player;
    private final Game game;
    public int size;

    public PlayerInventory(Player player, Game game) {
        this.size = 12;
        this.items = new ArrayList<>(size);
        this.player = player;
        this.game = game;
        fill();
    }

    // gets item from inventory
    public IItem getItem(int slot) {
        return items.get(slot);
    }

    private void fill() {
        for (int i = 0; i < this.size; i++) {
            items.add(new NullItem());
        }
    }


    public void setItem(int slot, IItem IItem) {
        items.set(slot, IItem);
    }

    // adds item to inventory
    public void addItem(IItem IItem) {
        if (!IItem.getEItemType().equals(EItemType.NULL)) {
            for (int i = 0; i < player.getInventory().size; i++) {
                IItem invitem = player.getInventory().getItem(i);
                if (invitem.getID() == IItem.getID()) {
                    if (invitem.getStack() + IItem.getStack() < invitem.getMaxStack()) {
                        invitem.setStack(invitem.getStack() + IItem.getStack());
                        break;
                    } else if (invitem.getStack() < invitem.getMaxStack()) {
                        IItem.setStack((invitem.getStack() + IItem.getStack()) - invitem.getMaxStack());
                        invitem.setStack(invitem.getMaxStack());
                        continue;
                    }
                }
            }
            items.add(IItem);
        }

    }

    //switches items from slot 1 to slot 2
    public void switchItem(int slotPrev, int slotNext) {
        IItem tmp = items.get(slotNext);
        items.set(slotNext, items.get(slotPrev));
        items.set(slotPrev, tmp);
    }

    public void removeItem(int slot) {
        items.remove(slot);
    }


}
