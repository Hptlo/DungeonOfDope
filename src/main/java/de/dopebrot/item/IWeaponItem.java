package de.dopebrot.item;

import java.util.ArrayList;

public interface IWeaponItem extends IItem {

    public float getBaseDamage();
    public float getDamageMultiplier();
    public int getCritChance();
    public float getCritDamageMultiplier();
    ArrayList<String> getStats();

}
