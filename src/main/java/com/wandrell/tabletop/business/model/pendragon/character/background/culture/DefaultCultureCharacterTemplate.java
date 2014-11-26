package com.wandrell.tabletop.business.model.pendragon.character.background.culture;

import java.util.Collection;

import com.wandrell.tabletop.business.model.interval.Interval;
import com.wandrell.tabletop.business.model.pendragon.valuehandler.Attribute;
import com.wandrell.tabletop.business.model.pendragon.valuehandler.DirectedTrait;
import com.wandrell.tabletop.business.model.pendragon.valuehandler.Passion;
import com.wandrell.tabletop.business.model.pendragon.valuehandler.Skill;
import com.wandrell.tabletop.business.model.pendragon.valuehandler.SpecialtySkill;
import com.wandrell.tabletop.business.model.pendragon.valuehandler.Trait;
import com.wandrell.tabletop.business.model.valuehandler.EditableValueHandler;

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
    public final Attribute getAttribute(final String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public final Interval getAttributeInterval(final String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public final Collection<Interval> getAttributeIntervals() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public final Collection<Attribute> getAttributes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public final EditableValueHandler getDerivedAttribute(final String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public final Collection<EditableValueHandler> getDerivedAttributes() {
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
