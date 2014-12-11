package com.wandrell.tabletop.business.model.pendragon.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

public final class DefaultArmor implements Armor {

    private final Boolean   heavyLoad;
    private final Equipment item;
    private final ArmorType type;

    public DefaultArmor(final Equipment item, final ArmorType type,
            final Boolean heavyLoad) {
        super();

        checkNotNull(item, "Received a null pointer as item");
        checkNotNull(type, "Received a null pointer as armor type");
        checkNotNull(heavyLoad, "Received a null pointer as heavy load flag");

        this.item = item;
        this.type = type;
        this.heavyLoad = heavyLoad;
    }

    @Override
    public final ArmorType getArmorType() {
        return type;
    }

    @Override
    public final String getDescription() {
        return getBaseItem().getDescription();
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

    private final Equipment getBaseItem() {
        return item;
    }

}
