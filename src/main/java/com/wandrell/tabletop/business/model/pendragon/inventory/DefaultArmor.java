package com.wandrell.tabletop.business.model.pendragon.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;

public final class DefaultArmor implements Armor {

    private final Integer   armorValue;
    private final Integer   dexModifier;
    private final Boolean   heavyLoad;
    private final Item      item;
    private final ArmorType type;

    public DefaultArmor(final String name, final String description,
            final Money money, final ArmorType type, final Integer armorValue,
            final Integer dexModifier, final Boolean heavyLoad) {
        super();

        checkNotNull(type, "Received a null pointer as armor type");
        checkNotNull(armorValue, "Received a null pointer as armor value");
        checkNotNull(dexModifier,
                "Received a null pointer as dexterity modifier");
        checkNotNull(heavyLoad, "Received a null pointer as heavy load flag");

        this.item = new DefaultItem(name, description, money);
        this.type = type;
        this.armorValue = armorValue;
        this.dexModifier = dexModifier;
        this.heavyLoad = heavyLoad;
    }

    @Override
    public final ArmorType getArmorType() {
        return type;
    }

    @Override
    public final Integer getArmorValue() {
        return armorValue;
    }

    @Override
    public final String getDescription() {
        return getBaseItem().getDescription();
    }

    @Override
    public final Integer getDexterityModifier() {
        return dexModifier;
    }

    @Override
    public final Money getMoney() {
        return getBaseItem().getMoney();
    }

    @Override
    public final String getName() {
        return getBaseItem().getName();
    }

    @Override
    public final Boolean isHeavyLoad() {
        return heavyLoad;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", getName())
                .toString();
    }

    private final Item getBaseItem() {
        return item;
    }

}
