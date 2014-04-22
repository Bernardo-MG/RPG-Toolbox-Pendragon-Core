package com.wandrell.tabletop.rpg.pendragon.character.background.culture;

import java.util.Collection;

import com.wandrell.tabletop.rpg.interval.Interval;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonAggregatedSkill;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonAttribute;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonDirectedTrait;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonPassion;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonSkill;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonTrait;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultCultureCharacterTemplate implements
	CultureCharacterTemplate, NewInstantiable {

    public DefaultCultureCharacterTemplate() {
	super();
    }

    public DefaultCultureCharacterTemplate(
	    final DefaultCultureCharacterTemplate template) {
	super();
    }

    @Override
    public DefaultCultureCharacterTemplate createNewInstance() {
	return new DefaultCultureCharacterTemplate(this);
    }

    @Override
    public PendragonAggregatedSkill getAdvancedSkill(String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Collection<PendragonAggregatedSkill> getAdvancedSkills() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PendragonAttribute getAttribute(String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Interval<Integer> getAttributeInterval(String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Collection<Interval<Integer>> getAttributeIntervals() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Collection<PendragonAttribute> getAttributes() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ValueHandler<Integer> getDerivedAttribute(String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Collection<ValueHandler<Integer>> getDerivedAttributes() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PendragonDirectedTrait getDirectedTrait(String name,
	    String annotation) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Collection<PendragonDirectedTrait> getDirectedTraits() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PendragonSkill getExclusiveSkill(String name, String annotation) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Collection<PendragonSkill> getExclusiveSkills() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PendragonPassion getPassion(String name, String annotation) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Collection<PendragonPassion> getPassions() {
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
    public PendragonTrait getTrait(String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Collection<PendragonTrait> getTraits() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String getValuesText() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean hasAdvancedSkill(String name) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean hasAttribute(String name) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean hasAttributeInterval(String name) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean hasDerivedAttribute(String name) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean hasDirectedTrait(String name, String annotation) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean hasExclusiveSkill(String name, String annotation) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean hasPassion(String name, String annotation) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean hasSkill(String name, String annotation) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean hasTrait(String name) {
	// TODO Auto-generated method stub
	return false;
    }

}
