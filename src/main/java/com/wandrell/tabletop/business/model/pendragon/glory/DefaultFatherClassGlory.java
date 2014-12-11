package com.wandrell.tabletop.business.model.pendragon.glory;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;

public final class DefaultFatherClassGlory implements FatherClassGlory {

    private final Integer baseGlory;
    private final Integer gloryPerYear;
    private final String  name;

    public DefaultFatherClassGlory(
            final DefaultFatherClassGlory fatherClassGlory) {
        super();

        checkNotNull(fatherClassGlory,
                "Received a null pointer as father class glory");

        name = fatherClassGlory.name;
        baseGlory = fatherClassGlory.baseGlory;
        gloryPerYear = fatherClassGlory.gloryPerYear;
    }

    public DefaultFatherClassGlory(final String name, final Integer baseGlory,
            final Integer gloryPerYear) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(baseGlory, "Received a null pointer as base glory");
        checkNotNull(gloryPerYear, "Received a null pointer as glory per year");

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
        return Objects.equals(name, other.name);
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
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

}
