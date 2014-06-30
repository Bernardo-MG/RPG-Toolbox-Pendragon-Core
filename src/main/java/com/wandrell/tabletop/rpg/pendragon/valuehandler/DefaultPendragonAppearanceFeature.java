package com.wandrell.tabletop.rpg.pendragon.valuehandler;

import com.wandrell.tabletop.rpg.valuehandler.DefaultValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.DelegateValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.module.GeneratorModule;
import com.wandrell.tabletop.rpg.valuehandler.module.IntervalModule;
import com.wandrell.tabletop.rpg.valuehandler.module.StoreModule;
import com.wandrell.tabletop.rpg.valuehandler.module.ValidatorModule;

public class DefaultPendragonAppearanceFeature implements
	PendragonAppearanceFeature {

    private String annotation;
    private final DelegateValueHandler<Integer> composite;

    public DefaultPendragonAppearanceFeature(
	    final DefaultPendragonAppearanceFeature vh) {
	super();
	composite = vh.composite.createNewInstance();
    }

    public DefaultPendragonAppearanceFeature(final String name,
	    final String annotation, final GeneratorModule<Integer> generator,
	    final IntervalModule<Integer> interval,
	    final StoreModule<Integer> store,
	    final ValidatorModule<Integer> validator) {
	super();
	composite = new DefaultValueHandler<Integer>(name, generator, interval,
		store, validator);
	this.annotation = annotation;
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
    public DefaultPendragonAppearanceFeature createNewInstance() {
	return new DefaultPendragonAppearanceFeature(this);
    }

    @Override
    public final void decreaseValue() {
	getValueHandler().decreaseValue();
    }

    @Override
    public final String getAnnotation() {
	return annotation;
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

    public final void setAnnotation(final String annotation) {
	if (annotation == null) {
	    throw new NullPointerException();
	}

	this.annotation = annotation;
    }

    @Override
    public final void setValue(final Integer value) {
	getValueHandler().setValue(value);
    }

    protected final ValueHandler<Integer> getValueHandler() {
	return composite;
    }

}
