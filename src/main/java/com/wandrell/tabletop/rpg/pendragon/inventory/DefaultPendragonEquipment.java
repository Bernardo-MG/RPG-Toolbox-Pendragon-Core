package com.wandrell.tabletop.rpg.pendragon.inventory;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;

public class DefaultPendragonEquipment extends DefaultPendragonItem implements
	PendragonEquipment {

    private final Set<String> flags = new TreeSet<String>();
    private final Map<String, ValueHandler<Integer>> values = new LinkedHashMap<>();

    public DefaultPendragonEquipment() {
	super();
    }

    public DefaultPendragonEquipment(final DefaultPendragonEquipment item) {
	super(item);

	for (final Entry<String, ValueHandler<Integer>> entry : values
		.entrySet()) {
	    values.put(entry.getKey(), entry.getValue().createNewInstance());
	}

	for (final String flag : item.flags) {
	    flags.add(flag);
	}
    }

    public final void addValue(final ValueHandler<Integer> bonus) {
	_getMiscelanyValues().put(bonus.getName(), bonus);
    }

    @Override
    public DefaultPendragonEquipment createNewInstance() {
	return new DefaultPendragonEquipment(this);
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
    public final Boolean hasFlag(final String name) {
	return _getFlags().contains(name);
    }

    @Override
    public final Boolean hasValue(final String name) {
	return _getMiscelanyValues().containsKey(name);
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

    public final void setValues(final Collection<ValueHandler<Integer>> values) {
	for (final ValueHandler<Integer> value : values) {
	    addValue(value);
	}
    }

    protected final Collection<String> _getFlags() {
	return flags;
    }

    protected final Map<String, ValueHandler<Integer>> _getMiscelanyValues() {
	return values;
    }

}
