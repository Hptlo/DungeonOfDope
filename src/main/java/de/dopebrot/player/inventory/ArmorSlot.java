package de.dopebrot.player.inventory;

public enum ArmorSlot {

    HELMET(0, "Helmet"),
    CHESTPLATE(1, "Chestplate"),
    LEGGINGS(2, "Leggings"),
    BOOTS(3, "Boots");

    public int id;
    public String slotName;

    ArmorSlot(int id, String slotName) {
        this.id = id;
        this.slotName = slotName;
    }


}
