package com.wandrell.tabletop.pendragon.inventory;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import com.wandrell.tabletop.valuehandler.ValueHandler;

public final class DefaultPendragonEquipment implements PendragonEquipment {

    private final Set<String> flags = new TreeSet<String>();
    private final PendragonItem item;
    private final Map<String, ValueHandler<Integer>> values = new LinkedHashMap<>();

    public DefaultPendragonEquipment(final DefaultPendragonEquipment equipment) {
	super();

	item = equipment.item;

	for (final Entry<String, ValueHandler<Integer>> entry : values
		.entrySet()) {
	    values.put(entry.getKey(), entry.getValue().createNewInstance());
	}

	for (final String flag : equipment.flags) {
	    flags.add(flag);
	}
    }

    public DefaultPendragonEquipment(final PendragonItem item) {
	super();

	this.item = item;
    }

    public final void addValue(final ValueHandler<Integer> bonus) {
	_getMiscelanyValues().put(bonus.getName(), bonus);
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
    public final ValueHandler<Integer> getMiscelanyValue(final String name) {
	return _getMiscelanyValues().get(name);
    }

    @Override
    public final Collection<ValueHandler<Integer>> getMiscelanyValues() {
	return Collections.unmodifiableCollection(_getMiscelanyValues()
		.values());
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
    public final ValueHandler<Integer> getQuantity() {
	return getBaseItem().getQuantity();
    }

    @Override
    public final Boolean hasFlag(final String name) {
	return _getFlags().contains(name);
    }

    @Override
    public final Boolean hasValue(final String name) {
	return _getMiscelanyValues().containsKey(name);
    }

    @Override
    public final void setDescription(final String description) {
	getBaseItem().setDescription(description);
    }

    public final void setFlag(final String name, final Boolean value) {
	if ((hasFlag(name)) && (!value)) {
	    _getFlags().remove(name);
	} else if (value) {
	    _getFlags().add(name);
	}
    }

    public final void setFlags(final Iterator<String> itrFlags) {
	_getFlags().clear();
	while (itrFlags.hasNext()) {
	    setFlag(itrFlags.next(), true);
	}
    }

    @Override
    public final void setName(final String name) {
	getBaseItem().setName(name);
    }

    public final void setValues(final Collection<ValueHandler<Integer>> values) {
	for (final ValueHandler<Integer> value : values) {
	    addValue(value);
	}
    }

    private final PendragonItem getBaseItem() {
	return item;
    }

    protected final Collection<String> _getFlags() {
	return flags;
    }

    protected final Map<String, ValueHandler<Integer>> _getMiscelanyValues() {
	return values;
    }

}
