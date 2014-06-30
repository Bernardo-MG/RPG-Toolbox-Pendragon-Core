package com.wandrell.tabletop.pendragon.glory;

import com.wandrell.tabletop.conf.factory.ValueHandlerFactory;
import com.wandrell.tabletop.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.valuehandler.ValueHandler;

public class DefaultFatherClassGlory implements FatherClassGlory {

    private final ValueHandler<Integer> baseGlory;
    private final ValueHandler<Integer> gloryPerYear;
    private final String name;

    public DefaultFatherClassGlory(
	    final DefaultFatherClassGlory fatherClassGlory) {
	super();
	name = fatherClassGlory.name;
	baseGlory = fatherClassGlory.baseGlory.createNewInstance();
	gloryPerYear = fatherClassGlory.gloryPerYear.createNewInstance();
    }

    public DefaultFatherClassGlory(final String name) {
	super();

	this.name = name;
	baseGlory = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_FATHER_CLASS_BASE_GLORY);
	gloryPerYear = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_FATHER_CLASS_GLORY_PER_YEAR);
    }

    @Override
    public DefaultFatherClassGlory createNewInstance() {
	return new DefaultFatherClassGlory(this);
    }

    @Override
    public final ValueHandler<Integer> getBaseGlory() {
	return baseGlory;
    }

    @Override
    public final ValueHandler<Integer> getGloryPerYear() {
	return gloryPerYear;
    }

    @Override
    public final String getName() {
	return name;
    }

    @Override
    public String toString() {
	return getName();
    }

}
