package com.wandrell.tabletop.pendragon.model.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public final class DefaultItem implements Item {

    private final String description;
    private final Money  money;
    private final String name;

    public DefaultItem(final DefaultItem item) {
        super();

        checkNotNull(item, "Received a null pointer as item");

        name = item.name;
        description = item.description;
        money = item.money;
    }

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
    public final DefaultItem createNewInstance() {
        return new DefaultItem(this);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultItem other = (DefaultItem) obj;
        return Objects.equal(name, other.name);
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
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

}
