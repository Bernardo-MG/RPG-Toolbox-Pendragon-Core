package com.wandrell.tabletop.rpg.pendragon.inventory;

import com.wandrell.tabletop.rpg.inventory.DefaultItemData;
import com.wandrell.tabletop.rpg.pendragon.conf.factory.PendragonFactory;

public class DefaultPendragonItem extends DefaultItemData implements
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
    public DefaultPendragonItem createNewInstance() {
	return new DefaultPendragonItem(this);
    }

    @Override
    public boolean equals(final Object obj) {
	final boolean equals;
	final DefaultPendragonItem received;

	if (!super.equals(obj)) {
	    equals = false;
	} else {
	    received = (DefaultPendragonItem) obj;
	    if (received.money == null) {
		equals = (money == null);
	    } else {
		equals = (received.money.equals(money));
	    }
	}

	return equals;
    }

    @Override
    public final PendragonMoney getMoney() {
	return money;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();

	result = prime * result + ((money == null) ? 0 : money.hashCode());

	return result;
    }

}
