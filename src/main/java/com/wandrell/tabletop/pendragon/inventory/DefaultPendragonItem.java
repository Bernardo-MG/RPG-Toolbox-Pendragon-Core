package com.wandrell.tabletop.pendragon.inventory;

public final class DefaultPendragonItem implements PendragonItem {

    private final String description;
    private final PendragonMoney money;
    private final String name;

    public DefaultPendragonItem(final DefaultPendragonItem item) {
	super();

	name = item.name;
	description = item.description;
	money = item.money.createNewInstance();
    }

    public DefaultPendragonItem(final String name, final String description,
	    final PendragonMoney money) {
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
    public final PendragonMoney getMoney() {
	return money;
    }

    @Override
    public final String getName() {
	return name;
    }

}
