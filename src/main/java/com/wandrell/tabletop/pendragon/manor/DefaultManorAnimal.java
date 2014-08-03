package com.wandrell.tabletop.pendragon.manor;

import com.wandrell.tabletop.dice.RollTable;

public final class DefaultManorAnimal implements ManorAnimal {

    private final String name;
    private final RollTable<AnimalYearResult> rolltable;

    public DefaultManorAnimal(final DefaultManorAnimal animal) {
	super();

	name = animal.name;
	rolltable = animal.rolltable;
    }

    public DefaultManorAnimal(final String name,
	    final RollTable<AnimalYearResult> rolltable) {
	super();

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
	DefaultManorAnimal other = (DefaultManorAnimal) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    @Override
    public final RollTable<AnimalYearResult> getAnnualCheckMap() {
	return rolltable;
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
