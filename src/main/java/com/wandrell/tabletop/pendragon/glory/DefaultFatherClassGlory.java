package com.wandrell.tabletop.pendragon.glory;

public final class DefaultFatherClassGlory implements FatherClassGlory {

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
    public final boolean equals(final Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	DefaultFatherClassGlory other = (DefaultFatherClassGlory) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
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

    @Override
    public final int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    public final void setBaseGlory(final Integer glory) {
	baseGlory = glory;
    }

    public final void setGloryPerYear(final Integer glory) {
	gloryPerYear = glory;
    }

    @Override
    public final String toString() {
	return getName();
    }

}
