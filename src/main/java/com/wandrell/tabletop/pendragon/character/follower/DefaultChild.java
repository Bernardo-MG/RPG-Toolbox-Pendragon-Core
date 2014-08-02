package com.wandrell.tabletop.pendragon.character.follower;

import com.wandrell.tabletop.character.Gender;

public final class DefaultChild implements Child {

    private Gender gender = Gender.MALE;
    private String name = "";
    private Integer yearBorn = 0;
    private Integer yearDeath = 0;

    public DefaultChild() {
	super();
    }

    public DefaultChild(final DefaultChild data) {
	super();

	gender = data.gender;
	name = data.name;
	yearBorn = data.yearBorn;
	yearDeath = data.yearDeath;
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

    public final void setBirthYear(final Integer year) {
	yearBorn = year;
    }

    public final void setDeathYear(final Integer year) {
	yearDeath = year;
    }

    public final void setGender(final Gender gender) {
	if (gender == null) {
	    throw new NullPointerException();
	}

	this.gender = gender;
    }

    public final void setName(final String name) {
	if (name == null) {
	    throw new NullPointerException();
	}

	this.name = name;
    }

    @Override
    public final String toString() {
	return getName();
    }
}
