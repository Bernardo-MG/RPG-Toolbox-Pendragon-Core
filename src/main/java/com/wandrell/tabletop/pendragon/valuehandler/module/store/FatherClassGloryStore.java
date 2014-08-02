package com.wandrell.tabletop.pendragon.valuehandler.module.store;

import com.wandrell.tabletop.valuehandler.ValueHandler;
import com.wandrell.tabletop.valuehandler.module.StoreModule;

public final class FatherClassGloryStore extends StoreModule<Integer> {

    private final ValueHandler<Integer> baseGlory;
    private final ValueHandler<Integer> gloryPerYear;
    private final ValueHandler<Integer> years;

    public FatherClassGloryStore(final FatherClassGloryStore module) {
	super(module);
	baseGlory = module.baseGlory.createNewInstance();
	gloryPerYear = module.gloryPerYear.createNewInstance();
	years = module.years.createNewInstance();
    }

    public FatherClassGloryStore(final ValueHandler<Integer> vhBaseGlory,
	    final ValueHandler<Integer> vhYears,
	    final ValueHandler<Integer> vhGloryPerYear) {
	super();
	this.baseGlory = vhBaseGlory;
	this.years = vhYears;
	this.gloryPerYear = vhGloryPerYear;
    }

    @Override
    public final void addValue(final Integer value) {
    }

    @Override
    public final FatherClassGloryStore createNewInstance() {
	return new FatherClassGloryStore(this);
    }

    public final ValueHandler<Integer> getBaseGlory() {
	return baseGlory;
    }

    public final ValueHandler<Integer> getGloryPerYear() {
	return gloryPerYear;
    }

    @Override
    public final Integer getValue() {
	final Integer value;

	value = getBaseGlory().getStoredValue()
		+ (getGloryPerYear().getStoredValue() * getYears()
			.getStoredValue());

	return value;
    }

    public final ValueHandler<Integer> getYears() {
	return years;
    }

    @Override
    public final void setValue(final Integer value) {
    }

}
