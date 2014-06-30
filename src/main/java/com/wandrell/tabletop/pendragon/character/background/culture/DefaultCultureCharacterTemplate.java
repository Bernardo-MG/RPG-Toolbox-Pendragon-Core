package com.wandrell.tabletop.pendragon.character.background.culture;

import java.util.Collection;

import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonAttribute;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonDirectedTrait;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonPassion;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonSkill;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonSpecialtySkill;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonTrait;
import com.wandrell.tabletop.valuehandler.ValueHandler;

public class DefaultCultureCharacterTemplate implements
	CultureCharacterTemplate {

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
    public final PendragonAttribute getAttribute(final String name) {
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
    public final Collection<PendragonAttribute> getAttributes() {
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
    public final PendragonDirectedTrait getDirectedTrait(final String name,
	    final String annotation) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Collection<PendragonDirectedTrait> getDirectedTraits() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final PendragonSkill getExclusiveSkill(final String name,
	    final String annotation) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Collection<PendragonSkill> getExclusiveSkills() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final PendragonPassion getPassion(final String name,
	    final String annotation) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Collection<PendragonPassion> getPassions() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final PendragonSkill getSkill(final String name,
	    final String annotation) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Collection<PendragonSkill> getSkills() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final PendragonSpecialtySkill getSpecialtySkill(final String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Collection<PendragonSpecialtySkill> getSpecialtySkills() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final PendragonTrait getTrait(final String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public final Collection<PendragonTrait> getTraits() {
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
