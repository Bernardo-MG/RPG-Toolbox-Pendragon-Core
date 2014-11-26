package com.wandrell.tabletop.business.model.pendragon.inventory;

public final class DefaultItem implements Item {

    private final String description;
    private final Money  money;
    private final String name;

    public DefaultItem(final DefaultItem item) {
        super();

        name = item.name;
        description = item.description;
        money = item.money.createNewInstance();
    }

    public DefaultItem(final String name, final String description,
            final Money money) {
        super();

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

}
