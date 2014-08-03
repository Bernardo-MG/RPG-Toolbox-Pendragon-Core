package com.wandrell.tabletop.pendragon.inventory;

import java.util.Collection;
import java.util.Map;

public final class DefaultShield implements Shield {

    private final Equipment item;

    public DefaultShield(final DefaultShield shield) {
	super();

	item = shield.item;
    }

    public DefaultShield(final Equipment item) {
	super();

	this.item = item;
    }

    @Override
    public final String getDescription() {
	return getBaseItem().getDescription();
    }

    @Override
    public final Boolean getFlag(final String name) {
	return getBaseItem().getFlag(name);
    }

    @Override
    public final Collection<String> getFlags() {
	return getBaseItem().getFlags();
    }

    @Override
    public final Map<String, Integer> getMiscelanyValues() {
	return getBaseItem().getMiscelanyValues();
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
    public final Boolean hasFlag(final String name) {
	return getBaseItem().hasFlag(name);
    }

    private final Equipment getBaseItem() {
	return item;
    }

}
