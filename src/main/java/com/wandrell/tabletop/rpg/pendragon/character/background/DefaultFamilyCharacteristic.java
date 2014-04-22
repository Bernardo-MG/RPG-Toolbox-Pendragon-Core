package com.wandrell.tabletop.rpg.pendragon.character.background;

import java.util.Collection;

import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonAttribute;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonSkill;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultFamilyCharacteristic implements FamilyCharacteristic,
	NewInstantiable {

    public DefaultFamilyCharacteristic() {
	super();
    }

    public DefaultFamilyCharacteristic(
	    final DefaultFamilyCharacteristic familyChar) {
	super();
    }

    @Override
    public DefaultFamilyCharacteristic createNewInstance() {
	return new DefaultFamilyCharacteristic(this);
    }

    @Override
    public PendragonAttribute getAttribute(String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Collection<PendragonAttribute> getAttributes() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String getName() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PendragonSkill getSkill(String name, String annotation) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Collection<PendragonSkill> getSkills() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean hasAttribute(String name) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean hasSkill(String name, String annotation) {
	// TODO Auto-generated method stub
	return false;
    }

}
