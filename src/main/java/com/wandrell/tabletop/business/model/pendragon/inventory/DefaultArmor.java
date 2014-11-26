package com.wandrell.tabletop.business.model.pendragon.inventory;

import java.util.Collection;
import java.util.Map;

public final class DefaultArmor implements Armor {

    private final Equipment item;

    public DefaultArmor(final DefaultArmor armor) {
        super();

        item = armor.item;
    }

    public DefaultArmor(final Equipment item) {
        super();

        this.item = item;
    }

    @Override
    public final String getDescription() {
        return getBaseItem().getDescription();
    }

    @Override
    public final Boolean getFlag(final String name) {
        return getBaseItem().getFlag(name);
    }

    @Override
    public final Collection<String> getFlags() {
        return getBaseItem().getFlags();
    }

    @Override
    public final Map<String, Integer> getMiscelanyValues() {
        return getBaseItem().getMiscelanyValues();
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
    public final Boolean hasFlag(final String name) {
        return getBaseItem().hasFlag(name);
    }

    private final Equipment getBaseItem() {
        return item;
    }

}
