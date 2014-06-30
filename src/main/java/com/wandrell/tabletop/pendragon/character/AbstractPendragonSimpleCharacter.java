package com.wandrell.tabletop.pendragon.character;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.character.Gender;
import com.wandrell.tabletop.pendragon.util.PendragonValueHandlerUtils;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonAttribute;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonDirectedTrait;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonPassion;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonSkill;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonSpecialtySkill;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonTrait;

public abstract class AbstractPendragonSimpleCharacter extends
	AbstractPendragonBaseCharacter implements PendragonSimpleCharacter {

    private final Map<String, PendragonDirectedTrait> directedTraits = new LinkedHashMap<>();
    private Gender gender = null;
    private final Map<String, PendragonPassion> passions = new LinkedHashMap<>();
    private final Map<String, PendragonSkill> skills = new LinkedHashMap<>();
    private final Map<String, PendragonSpecialtySkill> skillsSpecialty = new LinkedHashMap<>();
    private final Map<String, PendragonTrait> traits = new LinkedHashMap<>();

    public AbstractPendragonSimpleCharacter(
	    final AbstractPendragonSimpleCharacter character) {
	super(character);

	for (final Entry<String, PendragonSpecialtySkill> entry : character.skillsSpecialty
		.entrySet()) {
	    skillsSpecialty.put(entry.getKey(), entry.getValue());
	}

	for (final Entry<String, PendragonDirectedTrait> entry : character.directedTraits
		.entrySet()) {
	    directedTraits.put(entry.getKey(), entry.getValue());
	}

	for (final Entry<String, PendragonPassion> entry : character.passions
		.entrySet()) {
	    passions.put(entry.getKey(), entry.getValue());
	}

	for (final Entry<String, PendragonSkill> entry : character.skills
		.entrySet()) {
	    skills.put(entry.getKey(), entry.getValue());
	}

	for (final Entry<String, PendragonTrait> entry : character.traits
		.entrySet()) {
	    traits.put(entry.getKey(), entry.getValue());
	}

	gender = character.gender;
    }

    public AbstractPendragonSimpleCharacter(
	    final Collection<PendragonAttribute> attributes,
	    final Collection<PendragonTrait> traits) {
	super(attributes);

	for (final PendragonTrait trait : traits) {
	    if (trait == null) {
		throw new NullPointerException();
	    }

	    this.traits.put(trait.getName(), trait);
	}
    }

    @Override
    public void addDirectedTrait(final PendragonDirectedTrait trait) {
	if (trait == null) {
	    throw new NullPointerException();
	}

	_getDirectedTraits().put(
		PendragonValueHandlerUtils.getNameAnnotationKey(
			trait.getName(), trait.getAnnotation()), trait);
    }

    @Override
    public void addPassion(final PendragonPassion passion) {
	if (passion == null) {
	    throw new NullPointerException();
	}

	_getPassions().put(
		PendragonValueHandlerUtils.getNameAnnotationKey(
			passion.getName(), passion.getAnnotation()), passion);
    }

    @Override
    public void addSkill(final PendragonSkill skill) {
	if (skill == null) {
	    throw new NullPointerException();
	}

	_getSkills().put(
		PendragonValueHandlerUtils.getNameAnnotationKey(
			skill.getName(), skill.getAnnotation()), skill);
	registerIntoAdvancedSkill(skill);
    }

    @Override
    public void addSpecialtySkill(final PendragonSpecialtySkill skill) {
	if (skill == null) {
	    throw new NullPointerException();
	}

	_getSpecialtySkills().put(skill.getName(), skill);
	assembleAdvancedSkill(skill);
    }

    @Override
    public PendragonDirectedTrait getDirectedTrait(final String name,
	    final String annotation) {
	return _getDirectedTraits().get(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public Collection<PendragonDirectedTrait> getDirectedTraits() {
	return Collections
		.unmodifiableCollection(_getDirectedTraits().values());
    }

    @Override
    public Gender getGender() {
	return gender;
    }

    @Override
    public PendragonPassion getPassion(final String name,
	    final String annotation) {
	return _getPassions().get(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public Collection<PendragonPassion> getPassions() {
	return Collections.unmodifiableCollection(_getPassions().values());
    }

    @Override
    public PendragonSkill getSkill(final String name, final String annotation) {
	return _getSkills().get(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public Collection<PendragonSkill> getSkills() {
	return Collections.unmodifiableCollection(_getSkills().values());
    }

    @Override
    public PendragonSpecialtySkill getSpecialtySkill(final String name) {
	return _getSpecialtySkills().get(name);
    }

    @Override
    public Collection<PendragonSpecialtySkill> getSpecialtySkills() {
	return Collections.unmodifiableCollection(_getSpecialtySkills()
		.values());
    }

    @Override
    public PendragonTrait getTrait(final String name) {
	return _getTraits().get(name);
    }

    @Override
    public Collection<PendragonTrait> getTraits() {
	return Collections.unmodifiableCollection(_getTraits().values());
    }

    @Override
    public boolean hasDirectedTrait(final String name, final String annotation) {
	return _getDirectedTraits().containsKey(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public boolean hasPassion(final String name, final String annotation) {
	return _getPassions().containsKey(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public boolean hasSkill(final String name, final String annotation) {
	return _getSkills().containsKey(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public Boolean hasSpecialtySkill(final String name) {
	return _getSpecialtySkills().containsKey(name);
    }

    @Override
    public boolean hasTrait(final String name) {
	return _getTraits().containsKey(name);
    }

    public void removePassion(final String name, final String annotation) {
	// TODO: Is this required?
	_getPassions().containsKey(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    public void setDirectedTraits(
	    final Collection<PendragonDirectedTrait> traits) {
	_getDirectedTraits().clear();
	for (final PendragonDirectedTrait trait : traits) {
	    addDirectedTrait(trait);
	}
    }

    public void setGender(final Gender gender) {
	this.gender = gender;
    }

    public void setPassions(final Collection<PendragonPassion> passions) {
	_getPassions().clear();
	for (final PendragonPassion passion : passions) {
	    addPassion(passion);
	}
    }

    public void setSpecialtySkills(
	    final Collection<PendragonSpecialtySkill> skills) {
	_getSpecialtySkills().clear();
	for (final PendragonSpecialtySkill skill : skills) {
	    addSpecialtySkill(skill);
	}
    }

    private void assembleAdvancedSkill(final PendragonSpecialtySkill vhAdvSkill) {
	for (final String skill : vhAdvSkill.getSurrogatedSkills()) {
	    if (hasSkill(skill, "")) {
		vhAdvSkill.registerSkill(getSkill(skill, ""));
	    }
	}
    }

    private void registerIntoAdvancedSkill(final PendragonSkill vhSkill) {
	for (final PendragonSpecialtySkill skill : getSpecialtySkills()) {
	    if (skill.isSkillContained(vhSkill.getName())) {
		skill.registerSkill(vhSkill);
	    }
	}
    }

    protected Map<String, PendragonDirectedTrait> _getDirectedTraits() {
	return directedTraits;
    }

    protected Map<String, PendragonPassion> _getPassions() {
	return passions;
    }

    protected Map<String, PendragonSkill> _getSkills() {
	return skills;
    }

    protected Map<String, PendragonSpecialtySkill> _getSpecialtySkills() {
	return skillsSpecialty;
    }

    protected Map<String, PendragonTrait> _getTraits() {
	return traits;
    }

    protected void addTrait(final PendragonTrait vhTrait) {
	_getTraits().put(vhTrait.getName(), vhTrait);
	_getTraits().put(vhTrait.getMirrorTrait().getName(),
		vhTrait.getMirrorTrait());
    }

}
