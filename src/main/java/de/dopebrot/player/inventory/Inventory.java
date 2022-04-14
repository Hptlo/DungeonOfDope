package de.dopebrot.player.inventory;

import de.dopebrot.player.Player;

import java.util.ArrayList;

public class Inventory {

    private Player player;

    private ArrayList<Item> inventory;
    private ArrayList<Item> armor;

    private final int inventorySize = 32;
    private final int armorSize = 4;


    public Inventory(Player player) {
        this.player = player;
        this.inventory = new ArrayList<>(32);
        this.armor = new ArrayList<>(4);
        fillNothing();
    }

    private void fillNothing() {
        Item nuller = new Item(EItem.NULL);
        for (int i = 0; i < inventorySize; i++) {
            inventory.add(nuller);
        }
        for (int i = 0; i < armorSize; i++) {
            armor.add(nuller);
        }
        
    }

    public Item getItem(int slotID) {
        if (slotID < inventorySize) {
            return inventory.get(slotID);
        } else {
            return inventory.get(0);
        }
    }

    public Item getArmor(int slotID) {
        if (slotID < armorSize) {
            return armor.get(slotID);
        } else {
            return armor.get(0);
        }
    }

    public Item getArmor(ArmorSlot armorSlot) {
        if (armorSlot.id < armorSize) {
            return armor.get(armorSlot.id);
        } else {
            return armor.get(0);
        }
    }

    public void setItem(int slotID, Item item) {
        inventory.set(slotID,item);
    }


}
