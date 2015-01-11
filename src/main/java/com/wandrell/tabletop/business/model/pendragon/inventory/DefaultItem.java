package com.wandrell.tabletop.business.model.pendragon.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;

public final class DefaultItem implements Item {

    private final String description;
    private final Money  money;
    private final String name;

    public DefaultItem(final String name, final String description,
            final Money money) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(description, "Received a null pointer as description");
        checkNotNull(money, "Received a null pointer as money");

        this.name = name;
        this.description = description;
        this.money = money;
    }

    @Override
    public final String getDescription() {
        return description;
    }

    @Override
    public final Money getMoney() {
        return money;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

}
