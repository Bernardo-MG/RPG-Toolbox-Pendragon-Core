package com.wandrell.tabletop.business.model.pendragon.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;

public final class DefaultShield implements Shield {

    private final Integer armorValue;
    private final Item    item;

    public DefaultShield(final String name, final String description,
            final Money money, final Integer armorValue) {
        super();

        checkNotNull(armorValue, "Received a null pointer as armor value");

        this.item = new DefaultItem(name, description, money);
        this.armorValue = armorValue;
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
    public final Money getMoney() {
        return getBaseItem().getMoney();
    }

    @Override
    public final String getName() {
        return getBaseItem().getName();
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
