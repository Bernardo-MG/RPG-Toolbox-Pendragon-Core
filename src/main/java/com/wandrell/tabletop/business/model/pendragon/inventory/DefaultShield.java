package com.wandrell.tabletop.business.model.pendragon.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

public final class DefaultShield implements Shield {

    private final Equipment item;

    public DefaultShield(final Equipment item) {
        super();

        checkNotNull(item, "Received a null pointer as item");

        this.item = item;
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

    private final Equipment getBaseItem() {
        return item;
    }

}
