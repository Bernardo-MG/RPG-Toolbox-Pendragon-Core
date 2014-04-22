package com.wandrell.tabletop.rpg.pendragon.manor;

import com.wandrell.tabletop.rpg.dice.RollTable;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultManorAnimal implements ManorAnimal,
	Comparable<ManorAnimal>, NewInstantiable {

    private String name;
    private final RollTable<AnimalYearResult> rolltable;

    public DefaultManorAnimal(final DefaultManorAnimal animal) {
	super();

	name = animal.name;

	if (animal.rolltable instanceof NewInstantiable) {
	    rolltable = (RollTable<AnimalYearResult>) ((NewInstantiable) animal.rolltable)
		    .createNewInstance();
	} else {
	    rolltable = animal.rolltable;
	}
    }

    public DefaultManorAnimal(final RollTable<AnimalYearResult> rolltable) {
	super();

	this.rolltable = rolltable;
    }

    @Override
    public int compareTo(final ManorAnimal o) {
	return getName().compareTo(o.getName());
    }

    @Override
    public DefaultManorAnimal createNewInstance() {
	return new DefaultManorAnimal(this);
    }

    @Override
    public RollTable<AnimalYearResult> getAnnualCheckMap() {
	return rolltable;
    }

    @Override
    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

}
