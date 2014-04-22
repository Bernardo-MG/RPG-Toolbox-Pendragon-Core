package com.wandrell.tabletop.rpg.pendragon.character;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonAttribute;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultHorseCharacter extends AbstractPendragonBaseCharacter
	implements HorseCharacter, NewInstantiable {

    private String nameType = "";
    private final Set<String> setFlags = new TreeSet<String>();
    private final Map<String, ValueHandler<Integer>> storeSecondaryAttributes = new LinkedHashMap<>();

    public DefaultHorseCharacter(final Collection<PendragonAttribute> attributes) {
	super(attributes);
    }

    public DefaultHorseCharacter(final DefaultHorseCharacter horse) {
	super(horse);

	for (final Entry<String, ValueHandler<Integer>> entry : horse.storeSecondaryAttributes
		.entrySet()) {
	    storeSecondaryAttributes.put(entry.getKey(), entry.getValue()
		    .createNewInstance());
	}

	setHorseType(horse.nameType);
	setFlags.addAll(horse.setFlags);
    }

    @Override
    public void addSecondaryAttribute(final ValueHandler<Integer> attribute) {
	getSecondaryAttributesStore().put(attribute.getName(), attribute);
    }

    @Override
    public DefaultHorseCharacter createNewInstance() {
	return new DefaultHorseCharacter(this);
    }

    @Override
    public Boolean getFlag(final String flag) {
	return getFlagsSet().contains(flag);
    }

    @Override
    public Collection<String> getFlags() {
	return getFlagsSet();
    }

    @Override
    public String getHorseType() {
	return nameType;
    }

    @Override
    public ValueHandler<Integer> getSecondaryAttribute(final String name) {
	return getSecondaryAttributesStore().get(name);
    }

    @Override
    public Collection<ValueHandler<Integer>> getSecondaryAttributes() {
	return Collections.unmodifiableCollection(getSecondaryAttributesStore()
		.values());
    }

    @Override
    public Boolean hasFlag(final String name) {
	return getFlagsSet().contains(name);
    }

    @Override
    public Boolean hasSecondaryAttribute(final String name) {
	return getSecondaryAttributesStore().containsKey(name);
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
	    getFlagsSet().add(itrFlags.next());
	}
    }

    public void setHorseType(final String type) {
	this.nameType = type;
    }

    public void setSecondaryAttributes(
	    final Collection<ValueHandler<Integer>> attributes) {
	getSecondaryAttributesStore().clear();
	for (final ValueHandler<Integer> attribute : attributes) {
	    addSecondaryAttribute(attribute);
	}
    }

    protected Set<String> getFlagsSet() {
	return setFlags;
    }

    protected Map<String, ValueHandler<Integer>> getSecondaryAttributesStore() {
	return storeSecondaryAttributes;
    }

}
