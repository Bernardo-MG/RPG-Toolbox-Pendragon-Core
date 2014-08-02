package com.wandrell.tabletop.pendragon.character;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.pendragon.conf.PendragonToken;
import com.wandrell.tabletop.pendragon.valuehandler.Attribute;
import com.wandrell.tabletop.pendragon.valuehandler.DerivedAttribute;

public abstract class AbstractPendragonBaseCharacter implements
	PendragonBaseCharacter {

    private final Map<String, Attribute> attributes = new LinkedHashMap<>();
    private final Map<String, DerivedAttribute> attributesDerived = new LinkedHashMap<>();
    private String name = "";

    public AbstractPendragonBaseCharacter(
	    final AbstractPendragonBaseCharacter character) {
	super();
	name = character.name;

	for (final Entry<String, Attribute> entry : character.attributes
		.entrySet()) {
	    attributes.put(entry.getKey(), entry.getValue());
	}

	// initializeDerivedAttributes();
    }

    public AbstractPendragonBaseCharacter(final Collection<Attribute> attributes) {
	super();

	for (final Attribute attribute : attributes) {
	    if (attribute == null) {
		throw new NullPointerException();
	    }

	    this.attributes.put(attribute.getName(), attribute);
	}

	// initializeDerivedAttributes();
    }

    @Override
    public final void addDerivedAttribute(final DerivedAttribute attribute) {
	if (attribute == null) {
	    throw new NullPointerException();
	}

	_getDerivedAttributes().put(attribute.getName(), attribute);
    }

    @Override
    public abstract AbstractPendragonBaseCharacter createNewInstance();

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	AbstractPendragonBaseCharacter other = (AbstractPendragonBaseCharacter) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    @Override
    public final Attribute getAppearance() {
	return _getAttributes().get(PendragonToken.ATTRIBUTE_APPEARANCE);
    }

    @Override
    public final Collection<Attribute> getAttributes() {
	return Collections.unmodifiableCollection(_getAttributes().values());
    }

    @Override
    public final Attribute getConstitution() {
	return _getAttributes().get(PendragonToken.ATTRIBUTE_CONSTITUTION);
    }

    @Override
    public final DerivedAttribute getDamage() {
	return _getDerivedAttributes().get(
		PendragonToken.DERIVED_ATTRIBUTE_DAMAGE);
    }

    @Override
    public final Collection<DerivedAttribute> getDerivedAttributes() {
	return Collections.unmodifiableCollection(_getDerivedAttributes()
		.values());
    }

    @Override
    public final Attribute getDexterity() {
	return _getAttributes().get(PendragonToken.ATTRIBUTE_DEXTERITY);
    }

    @Override
    public final DerivedAttribute getDexterityRoll() {
	return _getDerivedAttributes().get(
		PendragonToken.DERIVED_ATTRIBUTE_DEXTERITY_ROLL);
    }

    @Override
    public final DerivedAttribute getHealingRate() {
	return _getDerivedAttributes().get(
		PendragonToken.DERIVED_ATTRIBUTE_HEAL_RATE);
    }

    @Override
    public final DerivedAttribute getHitPoints() {
	return _getDerivedAttributes().get(
		PendragonToken.DERIVED_ATTRIBUTE_HIT_POINTS);
    }

    @Override
    public final DerivedAttribute getMajorWoundTreshold() {
	return _getDerivedAttributes().get(
		PendragonToken.DERIVED_ATTRIBUTE_MAJOR_WOUND);
    }

    @Override
    public final DerivedAttribute getMovementRate() {
	return _getDerivedAttributes().get(
		PendragonToken.DERIVED_ATTRIBUTE_MOVEMENT_RATE);
    }

    @Override
    public final String getName() {
	return name;
    }

    @Override
    public final DerivedAttribute getSize() {
	return _getDerivedAttributes().get(PendragonToken.ATTRIBUTE_SIZE);
    }

    @Override
    public final Attribute getStrength() {
	return _getAttributes().get(PendragonToken.ATTRIBUTE_STRENGTH);
    }

    @Override
    public final DerivedAttribute getUnconsciousTreshold() {
	return _getDerivedAttributes().get(
		PendragonToken.DERIVED_ATTRIBUTE_UNCONSCIOUS);
    }

    @Override
    public final DerivedAttribute getWeight() {
	return _getDerivedAttributes().get(
		PendragonToken.DERIVED_ATTRIBUTE_WEIGHT);
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
	    final Collection<DerivedAttribute> attributes) {
	if (attributes == null) {
	    throw new NullPointerException();
	}

	_getDerivedAttributes().clear();
	for (final DerivedAttribute attribute : attributes) {
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

    protected final Map<String, Attribute> _getAttributes() {
	return attributes;
    }

    protected final Map<String, DerivedAttribute> _getDerivedAttributes() {
	return attributesDerived;
    }

    protected final void addAttribute(final Attribute attribute) {
	_getAttributes().put(attribute.getName(), attribute);
    }

}
