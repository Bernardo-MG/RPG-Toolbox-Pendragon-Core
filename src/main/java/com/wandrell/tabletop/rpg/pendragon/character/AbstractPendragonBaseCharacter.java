package com.wandrell.tabletop.rpg.pendragon.character;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonAttribute;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonDerivedAttribute;

public abstract class AbstractPendragonBaseCharacter implements
	PendragonBaseCharacter {

    private final Map<String, PendragonAttribute> attributes = new LinkedHashMap<>();
    private final Map<String, PendragonDerivedAttribute> attributesDerived = new LinkedHashMap<>();
    private String name = "";

    public AbstractPendragonBaseCharacter(
	    final AbstractPendragonBaseCharacter character) {
	super();
	name = character.name;

	for (final Entry<String, PendragonAttribute> entry : character.attributes
		.entrySet()) {
	    attributes.put(entry.getKey(), entry.getValue());
	}

	// initializeDerivedAttributes();
    }

    public AbstractPendragonBaseCharacter(
	    final Collection<PendragonAttribute> attributes) {
	super();

	for (final PendragonAttribute attribute : attributes) {
	    if (attribute == null) {
		throw new NullPointerException();
	    }

	    this.attributes.put(attribute.getName(), attribute);
	}

	// initializeDerivedAttributes();
    }

    @Override
    public void addDerivedAttribute(final PendragonDerivedAttribute attribute) {
	if (attribute == null) {
	    throw new NullPointerException();
	}

	_getDerivedAttributes().put(attribute.getName(), attribute);
    }

    @Override
    public boolean equals(final Object obj) {
	final AbstractPendragonBaseCharacter received;
	boolean equals;

	if (obj == this) {
	    equals = true;
	} else if (obj == null) {
	    equals = false;
	} else if (getClass() != obj.getClass()) {
	    equals = false;
	} else {
	    received = (AbstractPendragonBaseCharacter) obj;
	    if (received.name == null) {
		equals = (name == null);
	    } else {
		equals = (received.name.equals(name));
	    }
	}

	return equals;
    }

    @Override
    public PendragonAttribute getAttribute(final String name) {
	return _getAttributes().get(name);
    }

    @Override
    public Collection<PendragonAttribute> getAttributes() {
	return Collections.unmodifiableCollection(_getAttributes().values());
    }

    @Override
    public PendragonDerivedAttribute getDerivedAttribute(final String name) {
	return _getDerivedAttributes().get(name);
    }

    @Override
    public Collection<PendragonDerivedAttribute> getDerivedAttributes() {
	return Collections.unmodifiableCollection(_getDerivedAttributes()
		.values());
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public Boolean hasAttribute(final String name) {
	return _getAttributes().containsKey(name);
    }

    @Override
    public Boolean hasDerivedAttribute(final String name) {
	return _getDerivedAttributes().containsKey(name);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;

	result = prime * result + ((name == null) ? 0 : name.hashCode());

	return result;
    }

    public void setDerivedAttributes(
	    final Collection<PendragonDerivedAttribute> attributes) {
	if (attributes == null) {
	    throw new NullPointerException();
	}

	_getDerivedAttributes().clear();
	for (final PendragonDerivedAttribute attribute : attributes) {
	    if (attribute == null) {
		throw new NullPointerException();
	    }

	    _getDerivedAttributes().put(attribute.getName(), attribute);
	}
    }

    public void setName(final String name) {
	if (name == null) {
	    throw new NullPointerException();
	}

	this.name = name;
    }

    @Override
    public String toString() {
	return getName();
    }

    protected Map<String, PendragonAttribute> _getAttributes() {
	return attributes;
    }

    protected Map<String, PendragonDerivedAttribute> _getDerivedAttributes() {
	return attributesDerived;
    }

    protected void addAttribute(final PendragonAttribute attribute) {
	_getAttributes().put(attribute.getName(), attribute);
    }

}
