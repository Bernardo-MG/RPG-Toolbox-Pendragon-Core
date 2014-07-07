package com.wandrell.tabletop.pendragon.character;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonAttribute;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonDerivedAttribute;

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
    public final void addDerivedAttribute(
	    final PendragonDerivedAttribute attribute) {
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
    public final PendragonAttribute getAppearance() {
	return _getAttributes().get(PendragonLabels.ATTRIBUTE_APPEARANCE);
    }

    @Override
    public final Collection<PendragonAttribute> getAttributes() {
	return Collections.unmodifiableCollection(_getAttributes().values());
    }

    @Override
    public final PendragonAttribute getConstitution() {
	return _getAttributes().get(PendragonLabels.ATTRIBUTE_CONSTITUTION);
    }

    @Override
    public final PendragonAttribute getDamage() {
	return _getAttributes().get(PendragonLabels.DERIVED_ATTRIBUTE_DAMAGE);
    }

    @Override
    public final Collection<PendragonDerivedAttribute> getDerivedAttributes() {
	return Collections.unmodifiableCollection(_getDerivedAttributes()
		.values());
    }

    @Override
    public final PendragonAttribute getDexterity() {
	return _getAttributes().get(PendragonLabels.ATTRIBUTE_DEXTERITY);
    }

    @Override
    public final PendragonAttribute getHealingRate() {
	return _getAttributes()
		.get(PendragonLabels.DERIVED_ATTRIBUTE_HEAL_RATE);
    }

    @Override
    public final PendragonAttribute getHitPoints() {
	return _getAttributes().get(
		PendragonLabels.DERIVED_ATTRIBUTE_HIT_POINTS);
    }

    @Override
    public final PendragonAttribute getMoveRate() {
	return _getAttributes().get(
		PendragonLabels.DERIVED_ATTRIBUTE_MOVEMENT_RATE);
    }

    @Override
    public final String getName() {
	return name;
    }

    @Override
    public final PendragonAttribute getSize() {
	return _getAttributes().get(PendragonLabels.ATTRIBUTE_SIZE);
    }

    @Override
    public final PendragonAttribute getStrength() {
	return _getAttributes().get(PendragonLabels.ATTRIBUTE_STRENGTH);
    }

    @Override
    public final PendragonAttribute getUnconsciousTreshold() {
	return _getAttributes().get(
		PendragonLabels.DERIVED_ATTRIBUTE_UNCONSCIOUS);
    }

    @Override
    public final Boolean hasAttribute(final String name) {
	return _getAttributes().containsKey(name);
    }

    @Override
    public final Boolean hasDerivedAttribute(final String name) {
	return _getDerivedAttributes().containsKey(name);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;

	result = prime * result + ((name == null) ? 0 : name.hashCode());

	return result;
    }

    public final void setDerivedAttributes(
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

    public final void setName(final String name) {
	if (name == null) {
	    throw new NullPointerException();
	}

	this.name = name;
    }

    @Override
    public String toString() {
	return getName();
    }

    protected final Map<String, PendragonAttribute> _getAttributes() {
	return attributes;
    }

    protected final Map<String, PendragonDerivedAttribute> _getDerivedAttributes() {
	return attributesDerived;
    }

    protected final void addAttribute(final PendragonAttribute attribute) {
	_getAttributes().put(attribute.getName(), attribute);
    }

}
