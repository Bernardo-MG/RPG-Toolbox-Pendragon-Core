package com.wandrell.tabletop.business.model.pendragon.character.follower;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.character.Gender;

public final class DefaultChild implements Child {

    private final Gender  gender;
    private final String  name;
    private final Integer yearBorn;
    private final Integer yearDeath;

    public DefaultChild(final DefaultChild child) {
        super();

        checkNotNull(child, "Received a null pointer as child");

        gender = child.gender;
        name = child.name;
        yearBorn = child.yearBorn;
        yearDeath = child.yearDeath;
    }

    public DefaultChild(final String name, final Gender gender,
            final Integer yearBorn, final Integer yearDeath) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(gender, "Received a null pointer as gender");
        checkNotNull(yearBorn, "Received a null pointer as yearBorn");
        checkNotNull(yearDeath, "Received a null pointer as yearDeath");

        this.name = name;
        this.gender = gender;
        this.yearBorn = yearBorn;
        this.yearDeath = yearDeath;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultChild other = (DefaultChild) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public final Gender getGender() {
        return gender;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Integer getYearBorn() {
        return yearBorn;
    }

    @Override
    public final Integer getYearDeath() {
        return yearDeath;
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
