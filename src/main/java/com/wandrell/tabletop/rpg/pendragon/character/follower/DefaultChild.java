package com.wandrell.tabletop.rpg.pendragon.character.follower;

import com.wandrell.tabletop.rpg.character.Gender;
import com.wandrell.tabletop.rpg.conf.factory.ValueHandlerFactory;
import com.wandrell.tabletop.rpg.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultChild implements Child, NewInstantiable {

    private Gender genderChild = Gender.MALE;
    private String nameChild = "";
    private final ValueHandler<Integer> vhYearBorn;
    private final ValueHandler<Integer> vhYearDeath;

    public DefaultChild() {
	super();

	vhYearBorn = ValueHandlerFactory
		.getDefaultIntegerValueHandler(PendragonLabels.VH_YEAR_BORN);
	vhYearDeath = ValueHandlerFactory
		.getDefaultIntegerValueHandler(PendragonLabels.VH_YEAR_DEATH);
    }

    public DefaultChild(final DefaultChild data) {
	super();

	genderChild = data.genderChild;
	nameChild = data.nameChild;
	vhYearBorn = data.vhYearBorn.createNewInstance();
	vhYearDeath = data.vhYearDeath.createNewInstance();
    }

    @Override
    public DefaultChild createNewInstance() {
	return new DefaultChild(this);
    }

    @Override
    public Gender getGender() {
	return genderChild;
    }

    @Override
    public String getName() {
	return nameChild;
    }

    @Override
    public ValueHandler<Integer> getYearBorn() {
	return vhYearBorn;
    }

    @Override
    public ValueHandler<Integer> getYearDeath() {
	return vhYearDeath;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;

	result = prime * result
		+ ((genderChild == null) ? 0 : genderChild.hashCode());

	result = prime * result
		+ ((nameChild == null) ? 0 : nameChild.hashCode());

	result = prime * result
		+ ((vhYearBorn == null) ? 0 : vhYearBorn.hashCode());

	result = prime * result
		+ ((vhYearDeath == null) ? 0 : vhYearDeath.hashCode());

	return result;
    }

    public void setGender(final Gender gender) {
	this.genderChild = gender;
    }

    public void setName(final String name) {
	nameChild = name;
    }

    @Override
    public String toString() {
	return getName();
    }
}
