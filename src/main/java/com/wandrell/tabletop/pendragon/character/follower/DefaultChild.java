package com.wandrell.tabletop.pendragon.character.follower;

import com.wandrell.tabletop.character.Gender;

public class DefaultChild implements Child {

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
    public DefaultChild createNewInstance() {
	return new DefaultChild(this);
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
    public int hashCode() {
	final int prime = 31;
	int result = 1;

	result = prime * result + ((gender == null) ? 0 : gender.hashCode());

	result = prime * result + ((name == null) ? 0 : name.hashCode());

	result = prime * result
		+ ((yearBorn == null) ? 0 : yearBorn.hashCode());

	result = prime * result
		+ ((yearDeath == null) ? 0 : yearDeath.hashCode());

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
    public String toString() {
	return getName();
    }
}
