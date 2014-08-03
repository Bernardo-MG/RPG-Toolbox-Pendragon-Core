package com.wandrell.tabletop.pendragon.inventory;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public final class DefaultPendragonEquipment implements PendragonEquipment {

    private final Set<String> flags;
    private final PendragonItem item;
    private final Map<String, Integer> values;

    public DefaultPendragonEquipment(final DefaultPendragonEquipment equipment) {
	super();

	item = equipment.item;

	values = equipment.values;
	flags = equipment.flags;
    }

    public DefaultPendragonEquipment(final PendragonItem item,
	    final Set<String> flags, final Map<String, Integer> values) {
	super();

	this.item = item;
	this.flags = flags;
	this.values = values;
    }

    @Override
    public final String getDescription() {
	return getBaseItem().getDescription();
    }

    @Override
    public final Boolean getFlag(final String name) {
	return _getFlags().contains(name);
    }

    @Override
    public final Collection<String> getFlags() {
	return Collections.unmodifiableCollection(_getFlags());
    }

    @Override
    public final Map<String, Integer> getMiscelanyValues() {
	return Collections.unmodifiableMap(_getMiscelanyValues());
    }

    @Override
    public final PendragonMoney getMoney() {
	return getBaseItem().getMoney();
    }

    @Override
    public final String getName() {
	return getBaseItem().getName();
    }

    @Override
    public final Boolean hasFlag(final String name) {
	return _getFlags().contains(name);
    }

    private final PendragonItem getBaseItem() {
	return item;
    }

    protected final Collection<String> _getFlags() {
	return flags;
    }

    protected final Map<String, Integer> _getMiscelanyValues() {
	return values;
    }

}
