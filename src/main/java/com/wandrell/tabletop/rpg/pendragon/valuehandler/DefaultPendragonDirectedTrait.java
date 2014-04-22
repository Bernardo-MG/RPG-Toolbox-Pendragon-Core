package com.wandrell.tabletop.rpg.pendragon.valuehandler;

import com.wandrell.tabletop.rpg.valuehandler.DefaultValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.DelegateValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.module.GeneratorModule;
import com.wandrell.tabletop.rpg.valuehandler.module.IntervalModule;
import com.wandrell.tabletop.rpg.valuehandler.module.StoreModule;
import com.wandrell.tabletop.rpg.valuehandler.module.ValidatorModule;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultPendragonDirectedTrait implements PendragonDirectedTrait,
	NewInstantiable {

    private final DelegateValueHandler<Integer> vhComposite;
    private ValueHandler<Integer> vhTrait;

    public DefaultPendragonDirectedTrait(
	    final DefaultPendragonDirectedTrait passion) {
	super();

	vhComposite = passion.vhComposite.createNewInstance();
    }

    public DefaultPendragonDirectedTrait(final String name,
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
    public DefaultPendragonDirectedTrait createNewInstance() {
	return new DefaultPendragonDirectedTrait(this);
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
    public ValueHandler<Integer> getTrait() {
	return vhTrait;
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

    public void setTrait(final ValueHandler<Integer> vhTrait) {
	this.vhTrait = vhTrait;
    }

    @Override
    public void setValue(final Integer value) {
	getValueHandler().setValue(value);
    }

    protected ValueHandler<Integer> getValueHandler() {
	return vhComposite;
    }

}
