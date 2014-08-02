package com.wandrell.tabletop.pendragon.character.background.culture;

import java.util.Collection;

import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.pendragon.valuehandler.Attribute;
import com.wandrell.tabletop.pendragon.valuehandler.DirectedTrait;
import com.wandrell.tabletop.pendragon.valuehandler.Passion;
import com.wandrell.tabletop.pendragon.valuehandler.Skill;
import com.wandrell.tabletop.pendragon.valuehandler.SpecialtySkill;
import com.wandrell.tabletop.pendragon.valuehandler.Trait;
import com.wandrell.tabletop.valuehandler.ValueHandler;

public final class DefaultCultureCharacterTemplate implements
	CultureCharacterTemplate {

    public DefaultCultureCharacterTemplate() {
	super();
    }

    public DefaultCultureCharacterTemplate(
	    final DefaultCultureCharacterTemplate template) {
	super();
    }

    @Override
    public final DefaultCultureCharacterTemplate createNewInstance() {
	return new DefaultCultureCharacterTemplate(this);
    }

    @Override
    public final Attribute getAttribute(final String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Interval<Integer> getAttributeInterval(final String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Collection<Interval<Integer>> getAttributeIntervals() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Collection<Attribute> getAttributes() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final ValueHandler<Integer> getDerivedAttribute(final String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Collection<ValueHandler<Integer>> getDerivedAttributes() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final DirectedTrait getDirectedTrait(final String name,
	    final String annotation) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Collection<DirectedTrait> getDirectedTraits() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Skill getExclusiveSkill(final String name,
	    final String annotation) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Collection<Skill> getExclusiveSkills() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Passion getPassion(final String name, final String annotation) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Collection<Passion> getPassions() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Skill getSkill(final String name, final String annotation) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Collection<Skill> getSkills() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final SpecialtySkill getSpecialtySkill(final String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Collection<SpecialtySkill> getSpecialtySkills() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Trait getTrait(final String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Collection<Trait> getTraits() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final String getValuesText() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Boolean hasAttribute(final String name) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public final Boolean hasAttributeInterval(final String name) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public final Boolean hasDerivedAttribute(final String name) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public final Boolean hasDirectedTrait(final String name,
	    final String annotation) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public final Boolean hasExclusiveSkill(final String name,
	    final String annotation) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public final Boolean hasPassion(final String name, final String annotation) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public final Boolean hasSkill(final String name, final String annotation) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public final Boolean hasSpecialtySkill(final String name) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public final Boolean hasTrait(final String name) {
	// TODO Auto-generated method stub
	return false;
    }

}
