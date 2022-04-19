package de.dopebrot.item;

public interface IItem {

    int getID();

    EItemClass getItemClass();

    EItem getEItem();

    EItemType getEItemType();

    String getDisplayName();

    String getDescription();

    int getStack();

    int getMaxStack();

    void setStack(int stack);

}
