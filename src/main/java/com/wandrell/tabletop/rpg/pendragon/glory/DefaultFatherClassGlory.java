package com.wandrell.tabletop.rpg.pendragon.glory;

import com.wandrell.tabletop.rpg.conf.factory.ValueHandlerFactory;
import com.wandrell.tabletop.rpg.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultFatherClassGlory implements FatherClassGlory,
	Comparable<FatherClassGlory>, NewInstantiable {

    private String name;
    private final ValueHandler<Integer> vhBaseGlory;
    private final ValueHandler<Integer> vhGloryPerYear;

    public DefaultFatherClassGlory() {
	super();
	vhBaseGlory = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_FATHER_CLASS_BASE_GLORY);
	vhGloryPerYear = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_FATHER_CLASS_GLORY_PER_YEAR);
    }

    public DefaultFatherClassGlory(
	    final DefaultFatherClassGlory fatherClassGlory) {
	super();
	name = fatherClassGlory.name;
	vhBaseGlory = fatherClassGlory.vhBaseGlory.createNewInstance();
	vhGloryPerYear = fatherClassGlory.vhGloryPerYear.createNewInstance();
    }

    @Override
    public int compareTo(final FatherClassGlory fcg) {
	return getName().compareTo(fcg.getName());
    }

    @Override
    public DefaultFatherClassGlory createNewInstance() {
	return new DefaultFatherClassGlory(this);
    }

    @Override
    public ValueHandler<Integer> getBaseGlory() {
	return vhBaseGlory;
    }

    @Override
    public ValueHandler<Integer> getGloryPerYear() {
	return vhGloryPerYear;
    }

    @Override
    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

}
