package de.dopebrot.item;

public class Item {


    private EItemType itemType;
    private int amount;

    public Item(EItemType itemType) {
        this.itemType = itemType;
        this.amount = 1;
    }

    public Item(EItemType itemType, int amount) {
        this.itemType = itemType;
        this.amount = amount;
    }

    public EItemType getItemType() {
        return itemType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}