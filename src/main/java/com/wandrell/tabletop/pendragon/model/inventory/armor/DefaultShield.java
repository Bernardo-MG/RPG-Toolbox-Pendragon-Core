package com.wandrell.tabletop.pendragon.model.inventory.armor;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.pendragon.model.inventory.DefaultItem;
import com.wandrell.tabletop.pendragon.model.inventory.Item;
import com.wandrell.tabletop.pendragon.model.inventory.Money;

public final class DefaultShield implements Shield {

    private final Integer armorValue;
    private final Item    item;

    public DefaultShield(final DefaultShield shield) {
        super();

        checkNotNull(shield, "Received a null pointer as shield");

        item = shield.item.createNewInstance();
        armorValue = shield.armorValue;
    }

    public DefaultShield(final String name, final String description,
            final Money money, final Integer armorValue) {
        super();

        checkNotNull(armorValue, "Received a null pointer as armor value");

        this.item = new DefaultItem(name, description, money);
        this.armorValue = armorValue;
    }

    @Override
    public final DefaultShield createNewInstance() {
        return new DefaultShield(this);
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
