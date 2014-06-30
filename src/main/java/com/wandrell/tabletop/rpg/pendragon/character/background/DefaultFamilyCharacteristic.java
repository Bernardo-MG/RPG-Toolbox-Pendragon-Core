package com.wandrell.tabletop.rpg.pendragon.character.background;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.rpg.pendragon.util.PendragonValueHandlerUtils;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonAttribute;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonSkill;

public class DefaultFamilyCharacteristic implements FamilyCharacteristic {

    private final Map<String, PendragonAttribute> attributes = new LinkedHashMap<>();
    private final String name;
    private final Map<String, PendragonSkill> skills = new LinkedHashMap<>();

    public DefaultFamilyCharacteristic(
	    final DefaultFamilyCharacteristic familyChar) {
	super();
	name = familyChar.name;

	for (final Entry<String, PendragonAttribute> entry : familyChar.attributes
		.entrySet()) {
	    attributes.put(entry.getKey(), entry.getValue());
	}

	for (final Entry<String, PendragonSkill> entry : familyChar.skills
		.entrySet()) {
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

    public final void addAttribute(final PendragonAttribute attribute) {
	if (attribute == null) {
	    throw new NullPointerException();
	}

	_getAttributes().put(attribute.getName(), attribute);
    }

    public final void addSkill(final PendragonSkill skill) {
	if (skill == null) {
	    throw new NullPointerException();
	}

	_getSkills().put(
		PendragonValueHandlerUtils.getNameAnnotationKey(
			skill.getName(), skill.getAnnotation()), skill);
    }

    @Override
    public DefaultFamilyCharacteristic createNewInstance() {
	return new DefaultFamilyCharacteristic(this);
    }

    @Override
    public final PendragonAttribute getAttribute(final String name) {
	return _getAttributes().get(name);
    }

    @Override
    public final Collection<PendragonAttribute> getAttributes() {
	return Collections.unmodifiableCollection(_getAttributes().values());
    }

    @Override
    public final String getName() {
	return name;
    }

    @Override
    public final PendragonSkill getSkill(final String name,
	    final String annotation) {
	return _getSkills().get(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public final Collection<PendragonSkill> getSkills() {
	return Collections.unmodifiableCollection(_getSkills().values());
    }

    @Override
    public final Boolean hasAttribute(final String name) {
	return _getAttributes().containsKey(name);
    }

    @Override
    public final Boolean hasSkill(final String name, final String annotation) {
	return _getSkills().containsKey(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public String toString() {
	return getName();
    }

    protected final Map<String, PendragonAttribute> _getAttributes() {
	return attributes;
    }

    protected final Map<String, PendragonSkill> _getSkills() {
	return skills;
    }

}
