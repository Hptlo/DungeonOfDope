package de.dopebrot.item;

public interface IArmorItem extends IItem {

    int getLevelNeed();
    float getProtection();
    float getProtectionMultiplier();
    EArmorItemType getArmorType();

}
