package com.wandrell.tabletop.pendragon.model.manor;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.interval.IntervalTable;

public final class DefaultPet implements Pet {

    private final String                          name;
    private final IntervalTable<AnimalYearResult> rolltable;

    public DefaultPet(final String name,
            final IntervalTable<AnimalYearResult> rolltable) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(rolltable, "Received a null pointer as roll table");

        this.name = name;

        this.rolltable = rolltable;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultPet other = (DefaultPet) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public final IntervalTable<AnimalYearResult> getAnnualCheckMap() {
        return rolltable;
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
