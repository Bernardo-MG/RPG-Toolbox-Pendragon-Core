package com.wandrell.tabletop.pendragon.character.background;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class DefaultReligion implements Religion {

    private Integer bonusArmor = 0;
    private Integer bonusDamage = 0;
    private final Map<String, Integer> bonusDerived = new LinkedHashMap<>();
    private final String name;
    private final Set<String> traits = new LinkedHashSet<String>();

    public DefaultReligion(final DefaultReligion religion) {
	super();

	name = religion.name;

	for (final String trait : traits) {
	    traits.add(trait);
	}

	for (final Entry<String, Integer> entry : religion.bonusDerived
		.entrySet()) {
	    bonusDerived.put(entry.getKey(), entry.getValue());
	}

	bonusArmor = religion.bonusArmor;
	bonusDamage = religion.bonusDamage;
    }

    public DefaultReligion(final String name) {
	super();

	if (name == null) {
	    throw new NullPointerException();
	}

	this.name = name;
    }

    public final void addDerivedAttributeBonus(final String name,
	    final Integer bonus) {
	getDerivedAttributesBonus().put(name, bonus);
    }

    @Override
    public final boolean equals(final Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	DefaultReligion other = (DefaultReligion) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    @Override
    public final Integer getArmorBonus() {
	return bonusArmor;
    }

    @Override
    public final Integer getDamageBonus() {
	return bonusDamage;
    }

    @Override
    public final Integer getDerivedAttributeBonus(final String name) {
	return getDerivedAttributesBonus().get(name);
    }

    @Override
    public final String getName() {
	return name;
    }

    @Override
    public final Collection<String> getReligiousTraits() {
	return Collections.unmodifiableCollection(_getTraits());
    }

    @Override
    public final Boolean hasDerivedAttributeBonus(final String name) {
	return getDerivedAttributesBonus().containsKey(name);
    }

    @Override
    public final int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public final Boolean hasTrait(final String trait) {
	return _getTraits().contains(trait);
    }

    public final void setArmorBonus(final Integer bonus) {
	bonusArmor = bonus;
    }

    public final void setDamageBonus(final Integer bonus) {
	bonusDamage = bonus;
    }

    public final void setReligiousTraits(final Collection<String> traits) {
	_getTraits().clear();

	for (final String trait : traits) {
	    if (trait == null) {
		throw new NullPointerException();
	    }

	    _getTraits().add(trait);
	}
    }

    @Override
    public final String toString() {
	return getName();
    }

    protected final Set<String> _getTraits() {
	return traits;
    }

    protected final Map<String, Integer> getDerivedAttributesBonus() {
	return bonusDerived;
    }

}
