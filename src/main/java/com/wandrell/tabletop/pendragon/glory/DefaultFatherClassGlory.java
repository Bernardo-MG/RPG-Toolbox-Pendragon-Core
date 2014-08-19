package com.wandrell.tabletop.pendragon.glory;

public final class DefaultFatherClassGlory implements FatherClassGlory {

    private final Integer baseGlory;
    private final Integer gloryPerYear;
    private final String  name;

    public DefaultFatherClassGlory(
            final DefaultFatherClassGlory fatherClassGlory) {
        super();
        name = fatherClassGlory.name;
        baseGlory = fatherClassGlory.baseGlory;
        gloryPerYear = fatherClassGlory.gloryPerYear;
    }

    public DefaultFatherClassGlory(final String name, final Integer baseGlory,
            final Integer gloryPerYear) {
        super();

        if (name == null) {
            throw new NullPointerException();
        }

        if (baseGlory == null) {
            throw new NullPointerException();
        }

        if (gloryPerYear == null) {
            throw new NullPointerException();
        }

        this.name = name;
        this.baseGlory = baseGlory;
        this.gloryPerYear = gloryPerYear;
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

    @Override
    public final String toString() {
        return getName();
    }

}
