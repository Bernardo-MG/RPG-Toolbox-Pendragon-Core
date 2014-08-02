package com.wandrell.tabletop.pendragon.inventory;

import com.wandrell.tabletop.inventory.DefaultItemData;
import com.wandrell.tabletop.pendragon.conf.factory.PendragonFactory;

public final class DefaultPendragonItem extends DefaultItemData implements
	PendragonItem {

    private final PendragonMoney money;

    public DefaultPendragonItem() {
	super();

	money = PendragonFactory.getInstance().getMoney();
    }

    public DefaultPendragonItem(final DefaultPendragonItem item) {
	super(item);

	money = item.money.createNewInstance();
    }

    public DefaultPendragonItem(final String name, final String description,
	    final int libra, final int denarii) {
	super(name, description);

	money = PendragonFactory.getInstance().getMoney(libra, denarii);
    }

    @Override
    public final DefaultPendragonItem createNewInstance() {
	return new DefaultPendragonItem(this);
    }

    @Override
    public final PendragonMoney getMoney() {
	return money;
    }

}
