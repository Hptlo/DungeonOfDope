package de.dopebrot.player.inventory;

public class Item {


    private EItem item;

    public Item(EItem item) {
        this.item = item;
    }


    public String getDisplayName() {
        return item.displayName;
    }

    public ItemType getItemType() {
        return item.itemType;
    }

}
