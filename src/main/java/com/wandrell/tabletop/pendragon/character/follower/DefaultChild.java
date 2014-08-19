package com.wandrell.tabletop.pendragon.character.follower;

import com.wandrell.tabletop.character.Gender;

public final class DefaultChild implements Child {

    private final Gender  gender;
    private final String  name;
    private final Integer yearBorn;
    private final Integer yearDeath;

    public DefaultChild(final DefaultChild data) {
        super();

        gender = data.gender;
        name = data.name;
        yearBorn = data.yearBorn;
        yearDeath = data.yearDeath;
    }

    public DefaultChild(final String name, final Gender gender,
            final Integer yearBorn, final Integer yearDeath) {
        super();

        if (name == null) {
            throw new NullPointerException();
        }

        if (gender == null) {
            throw new NullPointerException();
        }

        if (yearBorn == null) {
            throw new NullPointerException();
        }

        if (yearDeath == null) {
            throw new NullPointerException();
        }

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
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
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
