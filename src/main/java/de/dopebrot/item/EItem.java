package de.dopebrot.item;

public enum EItem {

    IRON_SWORD(101, "Iron Sword", "Just some old Rusty Iron Sword"),
    STONE_SWORD(102, "Stone Sword", "Grandpa's Sword o' Pebble"),

    IRON_HELMET(501, "Iron Helmet", "its a Bucket..."),
    IRON_CHESTPLATE(502, "Iron Chestplate", ""),
    IRON_LEGGINGS(503, "Iron Leggings", "Not Comfortably but they look good!"),
    IRON_BOOTS(504, "Iron Boots", "You can walk trough glass with them on"),


    HEALING_POTION(201, "Healing Potion", "Bottle of Red Liquid, in Video Games read means Health."),

    APPLE(301, "Apple", "Some Fruit out of your Garden"),


    NULL(0, "Nothing", "");

    public String displayName;
    public String description;
    public int id;

    EItem(int id, String displayName, String description) {
        this.id = id;
        this.displayName = displayName;
        this.description = description;
    }

}
