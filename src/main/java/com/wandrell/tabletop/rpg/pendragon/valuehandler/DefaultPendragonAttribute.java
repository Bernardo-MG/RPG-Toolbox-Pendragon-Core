package com.wandrell.tabletop.rpg.pendragon.valuehandler;

import java.util.Collection;
import java.util.LinkedList;

import com.wandrell.tabletop.rpg.valuehandler.DefaultValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.DelegateValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.module.GeneratorModule;
import com.wandrell.tabletop.rpg.valuehandler.module.IntervalModule;
import com.wandrell.tabletop.rpg.valuehandler.module.StoreModule;
import com.wandrell.tabletop.rpg.valuehandler.module.ValidatorModule;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultPendragonAttribute implements PendragonAttribute,
	NewInstantiable {

    private final Collection<ValueHandler<Integer>> attributes = new LinkedList<>();
    private final DelegateValueHandler<Integer> vhComposite;

    public DefaultPendragonAttribute(final DefaultPendragonAttribute attribute) {
	super();

	vhComposite = attribute.vhComposite.createNewInstance();
    }

    public DefaultPendragonAttribute(final String name,
	    final String annotation, final GeneratorModule<Integer> generator,
	    final IntervalModule<Integer> interval,
	    final StoreModule<Integer> store,
	    final ValidatorModule<Integer> validator) {
	super();
	vhComposite = new DefaultValueHandler<Integer>(name, generator,
		interval, store, validator);
	vhComposite.setAnnotation(annotation);
    }

    @Override
    public Boolean acceptsValue(final Integer value) {
	return getValueHandler().acceptsValue(value);
    }

    @Override
    public void addValue(final Integer value) {
	getValueHandler().addValue(value);
    }

    @Override
    public DefaultPendragonAttribute createNewInstance() {
	return new DefaultPendragonAttribute(this);
    }

    @Override
    public void decreaseValue() {
	getValueHandler().decreaseValue();
    }

    @Override
    public String getAnnotation() {
	return getValueHandler().getAnnotation();
    }

    @Override
    public Collection<ValueHandler<Integer>> getDerivedAttributes() {
	return attributes;
    }

    @Override
    public Integer getLowerLimit() {
	return getValueHandler().getLowerLimit();
    }

    @Override
    public String getName() {
	return getValueHandler().getName();
    }

    @Override
    public Integer getStoredValue() {
	return getValueHandler().getStoredValue();
    }

    @Override
    public Integer getUpperLimit() {
	return getValueHandler().getUpperLimit();
    }

    @Override
    public void increaseValue() {
	getValueHandler().increaseValue();
    }

    @Override
    public Boolean isAbleToDecrease() {
	return getValueHandler().isAbleToDecrease();
    }

    @Override
    public Boolean isAbleToIncrease() {
	return getValueHandler().isAbleToIncrease();
    }

    @Override
    public Boolean isAnnotated() {
	return getValueHandler().isAnnotated();
    }

    public void setDerivedAttributes(
	    final Collection<ValueHandler<Integer>> attributes) {
	this.attributes.clear();
	this.attributes.addAll(attributes);
    }

    @Override
    public void setValue(final Integer value) {
	getValueHandler().setValue(value);
    }

    protected ValueHandler<Integer> getValueHandler() {
	return vhComposite;
    }

}
