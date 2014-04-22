package com.wandrell.tabletop.rpg.pendragon.inventory;

import com.wandrell.tabletop.rpg.inventory.DefaultItemData;

public class DefaultPendragonItem extends DefaultItemData implements
	PendragonItem {

    private final PendragonMoneyData dataMoney;

    public DefaultPendragonItem() {
	super();

	dataMoney = new DefaultMoneyData();
    }

    public DefaultPendragonItem(final DefaultPendragonItem item) {
	super(item);

	dataMoney = item.dataMoney.createNewInstance();
    }

    public DefaultPendragonItem(final String name, final String description,
	    final int valueLibra, final int valueDenarii) {
	super(name, description);

	dataMoney = new DefaultMoneyData(valueLibra, valueDenarii);
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
	    if (received.dataMoney == null) {
		equals = (dataMoney == null);
	    } else {
		equals = (received.dataMoney.equals(dataMoney));
	    }
	}

	return equals;
    }

    @Override
    public PendragonMoneyData getMoneyData() {
	return dataMoney;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();

	result = prime * result
		+ ((dataMoney == null) ? 0 : dataMoney.hashCode());

	return result;
    }

}
