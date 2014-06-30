package com.wandrell.tabletop.pendragon.character.background;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.wandrell.tabletop.conf.factory.ValueHandlerFactory;
import com.wandrell.tabletop.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.valuehandler.ValueHandler;

public class DefaultReligion implements Religion {

    private final ValueHandler<Integer> bonusArmor;
    private final ValueHandler<Integer> bonusDamage;
    private final Map<String, ValueHandler<Integer>> bonusDerived = new LinkedHashMap<>();
    private final String name;
    private final Set<String> traits = new LinkedHashSet<String>();

    public DefaultReligion(final DefaultReligion religion) {
	super();

	name = religion.name;

	for (final String trait : traits) {
	    traits.add(trait);
	}

	bonusArmor = religion.bonusArmor.createNewInstance();
	bonusDamage = religion.bonusDamage.createNewInstance();

	for (final Entry<String, ValueHandler<Integer>> entry : religion.bonusDerived
		.entrySet()) {
	    bonusDerived.put(entry.getKey(), entry.getValue());
	}
    }

    public DefaultReligion(final String name) {
	super();

	if (name == null) {
	    throw new NullPointerException();
	}

	this.name = name;

	bonusArmor = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_ARMOR);
	bonusDamage = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_DAMAGE);
    }

    @Override
    public DefaultReligion createNewInstance() {
	return new DefaultReligion(this);
    }

    @Override
    public final ValueHandler<Integer> getArmorBonus() {
	return bonusArmor;
    }

    @Override
    public final ValueHandler<Integer> getDamageBonus() {
	return bonusDamage;
    }

    @Override
    public final ValueHandler<Integer> getDerivedAttributeBonus(
	    final String name) {
	return _getDerivedAttributesBonus().get(name);
    }

    @Override
    public final Collection<ValueHandler<Integer>> getDerivedAttributesBonus() {
	return Collections.unmodifiableCollection(_getDerivedAttributesBonus()
		.values());
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
	return _getDerivedAttributesBonus().containsKey(name);
    }

    @Override
    public final Boolean hasTrait(final String trait) {
	return _getTraits().contains(trait);
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
    public String toString() {
	return getName();
    }

    protected final Map<String, ValueHandler<Integer>> _getDerivedAttributesBonus() {
	return bonusDerived;
    }

    protected final Set<String> _getTraits() {
	return traits;
    }

}
