package de.dopebrot.item;

public class WeaponItem extends Item {


    private float baseDamage;
    private float maxDamage;
    private float manaUsage;
    private EItemType itemType;

    public WeaponItem(EItemType itemType, float baseDamage, float maxDamage, float manaUsage) {
        super(itemType);
    }

    public float getBaseDamage() {
        return baseDamage;
    }

    public float getMaxDamage() {
        return maxDamage;
    }

    public float getManaUsage() {
        return manaUsage;
    }

    @Override
    public EItemType getItemType() {
        return itemType;
    }

    public boolean isStackable() {
        return itemType.isStackable;
    }
}
