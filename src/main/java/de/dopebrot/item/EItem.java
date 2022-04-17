package de.dopebrot.item;

public enum EItem {

    STONE_SWORD("Stone Sword", "Just an old Stone Sword");

    public String displayName;
    public String description;

    EItem(String displayName, String description) {
        this.description = description;
        this.displayName = displayName;
    }

}
