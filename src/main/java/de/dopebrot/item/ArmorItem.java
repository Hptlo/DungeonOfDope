package de.dopebrot.item;

public class ArmorItem implements IArmorItem {

    private int id;
    private int levelNeed;
    private float protection;
    private float protectionMultiplier;
    private EItemClass eItemClass;
    private EItemType eItemType;
    private EItem eItem;
    private String displayName;
    private String description;
    private int stack;
    private int maxStack;
    private EArmorItemType eArmorItemType;

    public ArmorItem(EItem eItem, EArmorItemType eArmorItemType, EItemType eItemType, EItemClass eItemClass, int id, int stack, int maxStack, int levelNeed, float protection, float protectionMultiplier) {
        this.id = id;
        this.levelNeed = levelNeed;
        this.protection = protection;
        this.protectionMultiplier = protectionMultiplier;
        this.eItemClass = eItemClass;
        this.eItemType = eItemType;
        this.eItem = eItem;
        this.displayName = eItem.displayName;
        this.description = eItem.description;
        this.stack = stack;
        this.maxStack = maxStack;
        this.eArmorItemType = eArmorItemType;
    }

    @Override
    public int getLevelNeed() {
        return levelNeed;
    }

    @Override
    public float getProtection() {
        return protection;
    }

    @Override
    public float getProtectionMultiplier() {
        return protectionMultiplier;
    }

    @Override
    public EArmorItemType getArmorType() {
        return null;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public EItemClass getItemClass() {
        return eItemClass;
    }

    @Override
    public EItem getEItem() {
        return eItem;
    }

    @Override
    public EItemType getEItemType() {
        return eItemType;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getStack() {
        return stack;
    }

    @Override
    public int getMaxStack() {
        return maxStack;
    }

    @Override
    public void setStack(int stack) {

    }
}
