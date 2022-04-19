package de.dopebrot.inventory;

import de.dopebrot.Game;
import de.dopebrot.item.*;
import de.dopebrot.player.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerArmor {

    private final Game game;
    private final Player player;

    private final List<IArmorItem> armor;

    public PlayerArmor(Player player, Game game) {
        this.player = player;
        this.game = game;
        this.armor = new ArrayList<>(4);
        fill();
    }

    private void fill() {
        for (int i = 0; i < 4; i++) {
            armor.add(new ArmorItem(EItem.NULL, EArmorItemType.NULL, EItemType.NULL, EItemClass.NULL, 0,1,1,1,0f,0f ));
        }
    }


    public IArmorItem getArmor(EArmorSlot slot) {
        switch (slot) {
            case CHEST:
                return armor.get(EArmorSlot.CHEST.slotID);
            case HEAD:
                return armor.get(EArmorSlot.HEAD.slotID);
            case FOOT:
                return armor.get(EArmorSlot.FOOT.slotID);
            case LEG:
                return armor.get(EArmorSlot.LEG.slotID);
        }
        return null;
    }

    public void setArmor(EArmorSlot slot, IArmorItem item) {
        armor.set(slot.slotID, item);
    }


}
