package de.dopebrot.item;

public enum EItemType {

    SWORD(false),
    WAND(false),
    FOOD(true),
    POTION(true);


    public boolean isStackable;

    EItemType(boolean isStackable) {
        this.isStackable = isStackable;
    }

}
