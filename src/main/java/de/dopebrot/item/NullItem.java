package de.dopebrot.item;

public class NullItem implements IItem {

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public EItemClass getItemClass() {
        return EItemClass.NULL;
    }

    @Override
    public EItem getEItem() {
        return EItem.NULL;
    }

    @Override
    public EItemType getEItemType() {
        return EItemType.NULL;
    }

    @Override
    public String getDisplayName() {
        return "Nothing";
    }

    @Override
    public String getDescription() {
        return "Nothing";
    }

    @Override
    public int getStack() {
        return 1;
    }

    @Override
    public int getMaxStack() {
        return 1;
    }

    @Override
    public void setStack(int stack) {}
}
