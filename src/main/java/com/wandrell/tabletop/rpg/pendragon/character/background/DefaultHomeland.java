package com.wandrell.tabletop.rpg.pendragon.character.background;

import com.wandrell.util.tag.NewInstantiable;

public class DefaultHomeland implements Homeland, NewInstantiable {

    private String name = "";

    public DefaultHomeland() {
	super();
    }

    public DefaultHomeland(final DefaultHomeland homeland) {
	super();

	name = homeland.name;
    }

    @Override
    public DefaultHomeland createNewInstance() {
	return new DefaultHomeland(this);
    }

    @Override
    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

}
