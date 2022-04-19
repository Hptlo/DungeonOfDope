package de.dopebrot.inventory;

public enum EArmorSlot {

    HEAD(3),
    CHEST(2),
    LEG(1),
    FOOT(0);


    public int slotID;

    EArmorSlot(int slotID) {
        this.slotID = slotID;
    }


}
