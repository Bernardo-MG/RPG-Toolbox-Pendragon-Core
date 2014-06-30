package com.wandrell.tabletop.pendragon.character;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.wandrell.tabletop.pendragon.valuehandler.PendragonAttribute;
import com.wandrell.tabletop.valuehandler.ValueHandler;

public class DefaultHorseCharacter extends AbstractPendragonBaseCharacter
	implements HorseCharacter {

    private final Set<String> flags = new LinkedHashSet<String>();
    private final Map<String, ValueHandler<Integer>> secondaryAttributes = new LinkedHashMap<>();
    private String type = "";

    public DefaultHorseCharacter(final Collection<PendragonAttribute> attributes) {
	super(attributes);
    }

    public DefaultHorseCharacter(final DefaultHorseCharacter horse) {
	super(horse);

	for (final Entry<String, ValueHandler<Integer>> entry : horse.secondaryAttributes
		.entrySet()) {
	    secondaryAttributes.put(entry.getKey(), entry.getValue()
		    .createNewInstance());
	}

	type = horse.type;
	flags.addAll(horse.flags);
    }

    @Override
    public void addSecondaryAttribute(final ValueHandler<Integer> attribute) {
	if (attribute == null) {
	    throw new NullPointerException();
	}

	_getSecondaryAttributes().put(attribute.getName(), attribute);
    }

    @Override
    public DefaultHorseCharacter createNewInstance() {
	return new DefaultHorseCharacter(this);
    }

    @Override
    public Boolean getFlag(final String flag) {
	return _getFlags().contains(flag);
    }

    @Override
    public Collection<String> getFlags() {
	return Collections.unmodifiableCollection(_getFlags());
    }

    @Override
    public String getHorseType() {
	return type;
    }

    @Override
    public ValueHandler<Integer> getSecondaryAttribute(final String name) {
	return _getSecondaryAttributes().get(name);
    }

    @Override
    public Collection<ValueHandler<Integer>> getSecondaryAttributes() {
	return Collections.unmodifiableCollection(_getSecondaryAttributes()
		.values());
    }

    @Override
    public Boolean hasFlag(final String name) {
	return _getFlags().contains(name);
    }

    @Override
    public Boolean hasSecondaryAttribute(final String name) {
	return _getSecondaryAttributes().containsKey(name);
    }

    public void setFlag(final String name, final Boolean value) {
	if (name == null) {
	    throw new NullPointerException();
	}

	if (value == null) {
	    throw new NullPointerException();
	}

	if ((hasFlag(name)) && (!value)) {
	    _getFlags().remove(name);
	} else if (value) {
	    _getFlags().add(name);
	}
    }

    public void setFlags(final Collection<String> flags) {
	_getFlags().clear();
	for (final String flag : flags) {
	    if (flag == null) {
		throw new NullPointerException();
	    }

	    _getFlags().add(flag);
	}
    }

    public void setHorseType(final String type) {
	if (type == null) {
	    throw new NullPointerException();
	}

	this.type = type;
    }

    public void setSecondaryAttributes(
	    final Collection<ValueHandler<Integer>> attributes) {
	_getSecondaryAttributes().clear();
	for (final ValueHandler<Integer> attribute : attributes) {
	    addSecondaryAttribute(attribute);
	}
    }

    protected Set<String> _getFlags() {
	return flags;
    }

    protected Map<String, ValueHandler<Integer>> _getSecondaryAttributes() {
	return secondaryAttributes;
    }

}
