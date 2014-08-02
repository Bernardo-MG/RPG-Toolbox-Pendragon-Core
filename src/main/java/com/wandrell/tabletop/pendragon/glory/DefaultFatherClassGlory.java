package com.wandrell.tabletop.pendragon.glory;

public class DefaultFatherClassGlory implements FatherClassGlory {

    private Integer baseGlory = 0;
    private Integer gloryPerYear = 0;
    private final String name;

    public DefaultFatherClassGlory(
	    final DefaultFatherClassGlory fatherClassGlory) {
	super();
	name = fatherClassGlory.name;
	baseGlory = fatherClassGlory.baseGlory;
	gloryPerYear = fatherClassGlory.gloryPerYear;
    }

    public DefaultFatherClassGlory(final String name) {
	super();

	this.name = name;
    }

    @Override
    public DefaultFatherClassGlory createNewInstance() {
	return new DefaultFatherClassGlory(this);
    }

    @Override
    public final Integer getBaseGlory() {
	return baseGlory;
    }

    @Override
    public final Integer getGloryPerYear() {
	return gloryPerYear;
    }

    @Override
    public final String getName() {
	return name;
    }

    public final void setBaseGlory(final Integer glory) {
	baseGlory = glory;
    }

    public final void setGloryPerYear(final Integer glory) {
	gloryPerYear = glory;
    }

    @Override
    public String toString() {
	return getName();
    }

}
