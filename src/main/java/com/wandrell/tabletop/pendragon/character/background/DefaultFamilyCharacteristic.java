package com.wandrell.tabletop.pendragon.character.background;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.pendragon.valuehandler.Attribute;
import com.wandrell.tabletop.pendragon.valuehandler.Skill;
import com.wandrell.tabletop.util.TokenUtil;

public class DefaultFamilyCharacteristic implements FamilyCharacteristic {

    private final Map<String, Attribute> attributes = new LinkedHashMap<>();
    private final String name;
    private final Map<String, Skill> skills = new LinkedHashMap<>();

    public DefaultFamilyCharacteristic(
	    final DefaultFamilyCharacteristic familyChar) {
	super();
	name = familyChar.name;

	for (final Entry<String, Attribute> entry : familyChar.attributes
		.entrySet()) {
	    attributes.put(entry.getKey(), entry.getValue());
	}

	for (final Entry<String, Skill> entry : familyChar.skills.entrySet()) {
	    skills.put(entry.getKey(), entry.getValue());
	}
    }

    public DefaultFamilyCharacteristic(final String name) {
	super();

	if (name == null) {
	    throw new NullPointerException();
	}

	this.name = name;
    }

    public final void addAttribute(final Attribute attribute) {
	if (attribute == null) {
	    throw new NullPointerException();
	}

	_getAttributes().put(attribute.getName(), attribute);
    }

    public final void addSkill(final Skill skill) {
	if (skill == null) {
	    throw new NullPointerException();
	}

	_getSkills().put(
		TokenUtil.getNameAndDescriptorToken(skill.getName(),
			skill.getDescriptor()), skill);
    }

    @Override
    public DefaultFamilyCharacteristic createNewInstance() {
	return new DefaultFamilyCharacteristic(this);
    }

    @Override
    public final Attribute getAttribute(final String name) {
	return _getAttributes().get(name);
    }

    @Override
    public final Collection<Attribute> getAttributes() {
	return Collections.unmodifiableCollection(_getAttributes().values());
    }

    @Override
    public final String getName() {
	return name;
    }

    @Override
    public final Skill getSkill(final String name, final String annotation) {
	return _getSkills().get(
		TokenUtil.getNameAndDescriptorToken(name, annotation));
    }

    @Override
    public final Collection<Skill> getSkills() {
	return Collections.unmodifiableCollection(_getSkills().values());
    }

    @Override
    public final Boolean hasAttribute(final String name) {
	return _getAttributes().containsKey(name);
    }

    @Override
    public final Boolean hasSkill(final String name, final String annotation) {
	return _getSkills().containsKey(
		TokenUtil.getNameAndDescriptorToken(name, annotation));
    }

    @Override
    public String toString() {
	return getName();
    }

    protected final Map<String, Attribute> _getAttributes() {
	return attributes;
    }

    protected final Map<String, Skill> _getSkills() {
	return skills;
    }

}
