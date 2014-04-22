package com.wandrell.tabletop.rpg.pendragon.valuehandler.module.store;

import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.module.StoreModule;

public class FatherClassGloryStore extends StoreModule<Integer> {

    private final ValueHandler<Integer> vhBaseGlory;
    private final ValueHandler<Integer> vhGloryPerYear;
    private final ValueHandler<Integer> vhYears;

    public FatherClassGloryStore(final FatherClassGloryStore vc) {
	super(vc);
	vhBaseGlory = vc.vhBaseGlory.createNewInstance();
	vhGloryPerYear = vc.vhGloryPerYear.createNewInstance();
	vhYears = vc.vhYears.createNewInstance();
    }

    public FatherClassGloryStore(final ValueHandler<Integer> vhBaseGlory,
	    final ValueHandler<Integer> vhYears,
	    final ValueHandler<Integer> vhGloryPerYear) {
	super();
	this.vhBaseGlory = vhBaseGlory;
	this.vhYears = vhYears;
	this.vhGloryPerYear = vhGloryPerYear;
    }

    @Override
    public void addValue(final Integer value) {
    }

    @Override
    public FatherClassGloryStore createNewInstance() {
	return new FatherClassGloryStore(this);
    }

    public ValueHandler<Integer> getBaseGlory() {
	return vhBaseGlory;
    }

    public ValueHandler<Integer> getGloryPerYear() {
	return vhGloryPerYear;
    }

    @Override
    public Integer getValue() {
	final Integer value;

	if ((getBaseGlory() != null) && (getGloryPerYear() != null)
		&& (getYears() != null)) {
	    value = getBaseGlory().getStoredValue()
		    + (getGloryPerYear().getStoredValue() * getYears()
			    .getStoredValue());
	} else {
	    value = 0;
	}

	return value;
    }

    public ValueHandler<Integer> getYears() {
	return vhYears;
    }

    @Override
    public void setValue(final Integer value) {
    }

}
