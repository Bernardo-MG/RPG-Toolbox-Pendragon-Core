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
import com.wandrell.util.iterator.NotRemoveIterator;

public class DefaultPendragonEquipment extends DefaultPendragonItem implements
	PendragonEquipment {

    private final Set<String> setFlags = new TreeSet<String>();
    private final Map<String, ValueHandler<Integer>> storeValues = new LinkedHashMap<>();

    public DefaultPendragonEquipment() {
	super();
    }

    public DefaultPendragonEquipment(final DefaultPendragonEquipment item) {
	super(item);

	for (final Entry<String, ValueHandler<Integer>> entry : storeValues
		.entrySet()) {
	    storeValues.put(entry.getKey(), entry.getValue()
		    .createNewInstance());
	}

	for (final String flag : item.setFlags) {
	    setFlags.add(flag);
	}
    }

    public void addValue(final ValueHandler<Integer> bonus) {
	getValuesStore().put(bonus.getName(), bonus);
    }

    @Override
    public DefaultPendragonEquipment createNewInstance() {
	return new DefaultPendragonEquipment(this);
    }

    @Override
    public Boolean getFlag(final String name) {
	return getFlagsSet().contains(name);
    }

    @Override
    public Iterator<String> getFlagsIterator() {
	return new NotRemoveIterator<>(getFlagsSet().iterator());
    }

    @Override
    public ValueHandler<Integer> getMiscelanyValue(final String name) {
	return getValuesStore().get(name);
    }

    @Override
    public Collection<ValueHandler<Integer>> getMiscelanyValues() {
	return Collections.unmodifiableCollection(getValuesStore().values());
    }

    @Override
    public Boolean hasFlag(final String name) {
	return getFlagsSet().contains(name);
    }

    @Override
    public Boolean hasValue(final String name) {
	return getValuesStore().containsKey(name);
    }

    public void setFlag(final String name, final Boolean value) {
	if ((hasFlag(name)) && (!value)) {
	    getFlagsSet().remove(name);
	} else if (value) {
	    getFlagsSet().add(name);
	}
    }

    public void setFlags(final Iterator<String> itrFlags) {
	getFlagsSet().clear();
	while (itrFlags.hasNext()) {
	    setFlag(itrFlags.next(), true);
	}
    }

    public void setValues(final Collection<ValueHandler<Integer>> values) {
	for (final ValueHandler<Integer> value : values) {
	    addValue(value);
	}
    }

    protected Set<String> getFlagsSet() {
	return setFlags;
    }

    protected Map<String, ValueHandler<Integer>> getValuesStore() {
	return storeValues;
    }

}
