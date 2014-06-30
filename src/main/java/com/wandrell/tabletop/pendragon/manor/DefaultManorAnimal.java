package com.wandrell.tabletop.pendragon.manor;

import com.wandrell.tabletop.dice.RollTable;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultManorAnimal implements ManorAnimal {

    private String name;
    private final RollTable<AnimalYearResult> rolltable;

    @SuppressWarnings("unchecked")
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
    public DefaultManorAnimal createNewInstance() {
	return new DefaultManorAnimal(this);
    }

    @Override
    public final RollTable<AnimalYearResult> getAnnualCheckMap() {
	return rolltable;
    }

    @Override
    public final String getName() {
	return name;
    }

    public final void setName(final String name) {
	if (name == null) {
	    throw new NullPointerException();
	}

	this.name = name;
    }

}
