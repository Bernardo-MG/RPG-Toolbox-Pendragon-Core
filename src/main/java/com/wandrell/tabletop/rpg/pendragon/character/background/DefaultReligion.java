package com.wandrell.tabletop.rpg.pendragon.character.background;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.util.iterator.NotRemoveIterator;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultReligion implements Religion, NewInstantiable {

    private String name = "";
    private final Set<String> setTraits = new LinkedHashSet<String>();

    public DefaultReligion() {
	super();
    }

    public DefaultReligion(final DefaultReligion religion) {
	super();

	name = religion.name;

	setReligiousTraits(religion.getReligiousTraitsIterator());
    }

    @Override
    public DefaultReligion createNewInstance() {
	return new DefaultReligion(this);
    }

    @Override
    public ValueHandler<Integer> getArmorBonus() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ValueHandler<Integer> getDamageBonus() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ValueHandler<Integer> getDerivedAttributeBonus(String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Collection<ValueHandler<Integer>> getDerivedAttributesBonus() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public Iterator<String> getReligiousTraitsIterator() {
	return new NotRemoveIterator<>(getTraitsSet().iterator());
    }

    @Override
    public boolean hasDerivedAttributeBonus(String name) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean hasTrait(final String trait) {
	return getTraitsSet().contains(trait);
    }

    public void setName(final String name) {
	this.name = name;
    }

    public void setReligiousTraits(final Iterator<String> itrTraits) {
	while (itrTraits.hasNext()) {
	    getTraitsSet().add(itrTraits.next());
	}
    }

    private Set<String> getTraitsSet() {
	return setTraits;
    }

}
