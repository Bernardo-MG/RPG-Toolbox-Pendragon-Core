package com.wandrell.tabletop.pendragon.character.background;

public class DefaultHomeland implements Homeland {

    private final String name;

    public DefaultHomeland(final DefaultHomeland homeland) {
	super();

	name = homeland.name;
    }

    public DefaultHomeland(final String name) {
	super();

	if (name == null) {
	    throw new NullPointerException();
	}

	this.name = name;
    }

    @Override
    public DefaultHomeland createNewInstance() {
	return new DefaultHomeland(this);
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public String toString() {
	return getName();
    }

}
