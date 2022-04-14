package de.dopebrot.player.inventory;

public enum EItem {


    // W = WEAPON
    // F = FOOD
    // P = POTION

    NULL(ItemType.NULL,"Nothing"),

    W_SWORD_IRON(ItemType.WEAPON, "Iron Sword"),
    W_SWORD_GOLD(ItemType.WEAPON, "Gold Sword"),
    F_WHEAT_BREAD(ItemType.FOOD, "Bread"),
    P_HEAL_1(ItemType.POTION, "Healing Potion");

    public ItemType itemType;
    public String displayName;

    EItem(ItemType itemType, String displayName) {
        this.displayName = displayName;
        this.itemType = itemType;
    }


}
