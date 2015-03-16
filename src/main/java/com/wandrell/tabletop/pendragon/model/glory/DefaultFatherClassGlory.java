package com.wandrell.tabletop.pendragon.model.glory;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;

public final class DefaultFatherClassGlory implements FatherClassGlory {

    private final Integer baseGlory;
    private final String  name;
    private final Integer yearlyGlory;

    public DefaultFatherClassGlory(final DefaultFatherClassGlory glory) {
        super();

        checkNotNull(glory, "Received a null pointer as father class glory");

        name = glory.name;
        baseGlory = glory.baseGlory;
        yearlyGlory = glory.yearlyGlory;
    }

    public DefaultFatherClassGlory(final String name, final Integer baseGlory,
            final Integer yearlyGlory) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(baseGlory, "Received a null pointer as base glory");
        checkNotNull(yearlyGlory, "Received a null pointer as glory per year");

        this.name = name;
        this.baseGlory = baseGlory;
        this.yearlyGlory = yearlyGlory;
    }

    @Override
    public final DefaultFatherClassGlory createNewInstance() {
        return new DefaultFatherClassGlory(this);
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
    public final String getFatherClass() {
        return name;
    }

    @Override
    public final Integer getYearlyGlory() {
        return yearlyGlory;
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
