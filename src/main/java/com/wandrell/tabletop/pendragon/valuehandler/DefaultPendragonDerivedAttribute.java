package com.wandrell.tabletop.pendragon.valuehandler;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import com.wandrell.tabletop.valuehandler.DefaultValueHandler;
import com.wandrell.tabletop.valuehandler.DelegateValueHandler;
import com.wandrell.tabletop.valuehandler.ValueHandler;
import com.wandrell.tabletop.valuehandler.module.GeneratorModule;
import com.wandrell.tabletop.valuehandler.module.IntervalModule;
import com.wandrell.tabletop.valuehandler.module.StoreModule;
import com.wandrell.tabletop.valuehandler.module.ValidatorModule;

public class DefaultPendragonDerivedAttribute implements
	PendragonDerivedAttribute {

    private final Collection<PendragonAttribute> attributes = new LinkedList<>();
    private final DelegateValueHandler<Integer> composite;

    public DefaultPendragonDerivedAttribute(
	    final DefaultPendragonDerivedAttribute attribute) {
	super();

	composite = attribute.composite.createNewInstance();
    }

    public DefaultPendragonDerivedAttribute(final String name,
	    final GeneratorModule<Integer> generator,
	    final IntervalModule<Integer> interval,
	    final StoreModule<Integer> store,
	    final ValidatorModule<Integer> validator) {
	super();
	composite = new DefaultValueHandler<Integer>(name, generator, interval,
		store, validator);
    }

    @Override
    public final Boolean acceptsValue(final Integer value) {
	return getValueHandler().acceptsValue(value);
    }

    @Override
    public final void addValue(final Integer value) {
	getValueHandler().addValue(value);
    }

    @Override
    public DefaultPendragonDerivedAttribute createNewInstance() {
	return new DefaultPendragonDerivedAttribute(this);
    }

    @Override
    public final void decreaseValue() {
	getValueHandler().decreaseValue();
    }

    @Override
    public final Integer getLowerLimit() {
	return getValueHandler().getLowerLimit();
    }

    @Override
    public final String getName() {
	return getValueHandler().getName();
    }

    @Override
    public final Collection<PendragonAttribute> getParentAttributes() {
	return Collections.unmodifiableCollection(_getParentAttributes());
    }

    @Override
    public final Integer getStoredValue() {
	return getValueHandler().getStoredValue();
    }

    @Override
    public final Integer getUpperLimit() {
	return getValueHandler().getUpperLimit();
    }

    @Override
    public final void increaseValue() {
	getValueHandler().increaseValue();
    }

    @Override
    public final Boolean isAbleToDecrease() {
	return getValueHandler().isAbleToDecrease();
    }

    @Override
    public final Boolean isAbleToIncrease() {
	return getValueHandler().isAbleToIncrease();
    }

    public final void setParentAttributes(
	    final Collection<PendragonAttribute> attributes) {
	_getParentAttributes().clear();
	for (final PendragonAttribute attribute : attributes) {
	    if (attribute == null) {
		throw new NullPointerException();
	    }

	    _getParentAttributes().add(attribute);
	}
    }

    @Override
    public final void setValue(final Integer value) {
	getValueHandler().setValue(value);
    }

    protected final Collection<PendragonAttribute> _getParentAttributes() {
	return attributes;
    }

    protected final ValueHandler<Integer> getValueHandler() {
	return composite;
    }
}
