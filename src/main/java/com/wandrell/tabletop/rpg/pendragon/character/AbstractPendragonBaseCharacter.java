package com.wandrell.tabletop.rpg.pendragon.character;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

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

	for (final PendragonAttribute attribute : character.attributes.values()) {
	    attributes.put(attribute.getName(), attribute);
	}

	// initializeDerivedAttributes();
    }

    public AbstractPendragonBaseCharacter(
	    final Collection<PendragonAttribute> attributes) {
	super();

	setAttributes(attributes);
    }

    @Override
    public void addDerivedAttribute(final PendragonDerivedAttribute attribute) {
	getDerivedAttributesMap().put(attribute.getName(), attribute);
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
	return getAttributesMap().get(name);
    }

    @Override
    public Collection<PendragonAttribute> getAttributes() {
	return Collections.unmodifiableCollection(getAttributesMap().values());
    }

    @Override
    public PendragonDerivedAttribute getDerivedAttribute(final String name) {
	return getDerivedAttributesMap().get(name);
    }

    @Override
    public Collection<PendragonDerivedAttribute> getDerivedAttributes() {
	return Collections.unmodifiableCollection(getDerivedAttributesMap()
		.values());
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public Boolean hasAttribute(final String name) {
	return getAttributesMap().containsKey(name);
    }

    @Override
    public Boolean hasDerivedAttribute(final String name) {
	return getDerivedAttributesMap().containsKey(name);
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
	getDerivedAttributesMap().clear();
	for (final PendragonDerivedAttribute attribute : attributes) {
	    getDerivedAttributesMap().put(attribute.getName(), attribute);
	}
    }

    public void setName(final String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return getName();
    }

    private void initializeDerivedAttributes(
	    final Collection<PendragonDerivedAttribute> attributesDerived) {
	// TODO: Redo
	// final Iterator<ValueHandler<Integer>> itrDerAttr;
	// final List<SecondaryValuesValueHandler<Integer,
	// ValueHandler<Integer>>> listDerAttr;
	// SecondaryValuesValueHandler<Integer, ValueHandler<Integer>>
	// vhStoredDerAttribute;
	// ValueHandler<Integer> vhDerAttribute;
	//
	// itrDerAttr = attributesDerived.iterator();
	//
	// getDerivedAttributesMap().clear();
	// listDerAttr = new ArrayList<SecondaryValuesValueHandler<Integer,
	// ValueHandler<Integer>>>();
	// while (itrDerAttr.hasNext()) {
	// vhDerAttribute = itrDerAttr.next();
	//
	// vhStoredDerAttribute = new IntegerSecondaryValuesValueHandler(
	// vhDerAttribute.getName());
	// vhStoredDerAttribute.addValueHandler(vhDerAttribute);
	//
	// listDerAttr.addInterval(vhStoredDerAttribute);
	// }
	//
	// setDerivedAttributes(listDerAttr.iterator());
    }

    protected void addAttribute(final PendragonAttribute attribute) {
	getAttributesMap().put(attribute.getName(), attribute);
    }

    protected Map<String, PendragonAttribute> getAttributesMap() {
	return attributes;
    }

    protected Map<String, PendragonDerivedAttribute> getDerivedAttributesMap() {
	return attributesDerived;
    }

    protected void setAttributes(final Collection<PendragonAttribute> attributes) {
	getAttributesMap().clear();
	for (final PendragonAttribute attribute : attributes) {
	    addAttribute(attribute);
	}

	// initializeDerivedAttributes();
    }

}
