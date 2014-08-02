package com.wandrell.tabletop.pendragon.character;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.character.Gender;
import com.wandrell.tabletop.pendragon.valuehandler.Attribute;
import com.wandrell.tabletop.pendragon.valuehandler.DirectedTrait;
import com.wandrell.tabletop.pendragon.valuehandler.Passion;
import com.wandrell.tabletop.pendragon.valuehandler.Skill;
import com.wandrell.tabletop.pendragon.valuehandler.SpecialtySkill;
import com.wandrell.tabletop.pendragon.valuehandler.Trait;
import com.wandrell.tabletop.util.TokenUtil;

public abstract class AbstractPendragonSimpleCharacter extends
	AbstractPendragonBaseCharacter implements PendragonSimpleCharacter {

    private final Map<String, DirectedTrait> directedTraits = new LinkedHashMap<>();
    private Gender gender = null;
    private final Map<String, Passion> passions = new LinkedHashMap<>();
    private final Map<String, Skill> skills = new LinkedHashMap<>();
    private final Map<String, SpecialtySkill> skillsSpecialty = new LinkedHashMap<>();
    private final Map<String, Trait> traits = new LinkedHashMap<>();

    public AbstractPendragonSimpleCharacter(
	    final AbstractPendragonSimpleCharacter character) {
	super(character);

	for (final Entry<String, SpecialtySkill> entry : character.skillsSpecialty
		.entrySet()) {
	    skillsSpecialty.put(entry.getKey(), entry.getValue());
	}

	for (final Entry<String, DirectedTrait> entry : character.directedTraits
		.entrySet()) {
	    directedTraits.put(entry.getKey(), entry.getValue());
	}

	for (final Entry<String, Passion> entry : character.passions.entrySet()) {
	    passions.put(entry.getKey(), entry.getValue());
	}

	for (final Entry<String, Skill> entry : character.skills.entrySet()) {
	    skills.put(entry.getKey(), entry.getValue());
	}

	for (final Entry<String, Trait> entry : character.traits.entrySet()) {
	    traits.put(entry.getKey(), entry.getValue());
	}

	gender = character.gender;
    }

    public AbstractPendragonSimpleCharacter(
	    final Collection<Attribute> attributes,
	    final Collection<Trait> traits) {
	super(attributes);

	for (final Trait trait : traits) {
	    if (trait == null) {
		throw new NullPointerException();
	    }

	    this.traits.put(trait.getName(), trait);
	}
    }

    @Override
    public final void addDirectedTrait(final DirectedTrait trait) {
	if (trait == null) {
	    throw new NullPointerException();
	}

	_getDirectedTraits().put(
		TokenUtil.getNameAndDescriptorToken(trait.getName(),
			trait.getDescriptor()), trait);
    }

    @Override
    public final void addPassion(final Passion passion) {
	if (passion == null) {
	    throw new NullPointerException();
	}

	_getPassions().put(
		TokenUtil.getNameAndDescriptorToken(passion.getName(),
			passion.getDescriptor()), passion);
    }

    @Override
    public final void addSkill(final Skill skill) {
	if (skill == null) {
	    throw new NullPointerException();
	}

	_getSkills().put(
		TokenUtil.getNameAndDescriptorToken(skill.getName(),
			skill.getDescriptor()), skill);
	registerIntoAdvancedSkill(skill);
    }

    @Override
    public final void addSpecialtySkill(final SpecialtySkill skill) {
	if (skill == null) {
	    throw new NullPointerException();
	}

	_getSpecialtySkills().put(skill.getName(), skill);
	assembleAdvancedSkill(skill);
    }

    @Override
    public abstract AbstractPendragonSimpleCharacter createNewInstance();

    @Override
    public final DirectedTrait getDirectedTrait(final String name,
	    final String annotation) {
	return _getDirectedTraits().get(
		TokenUtil.getNameAndDescriptorToken(name, annotation));
    }

    @Override
    public final Collection<DirectedTrait> getDirectedTraits() {
	return Collections
		.unmodifiableCollection(_getDirectedTraits().values());
    }

    @Override
    public final Gender getGender() {
	return gender;
    }

    @Override
    public final Passion getPassion(final String name, final String annotation) {
	return _getPassions().get(
		TokenUtil.getNameAndDescriptorToken(name, annotation));
    }

    @Override
    public final Collection<Passion> getPassions() {
	return Collections.unmodifiableCollection(_getPassions().values());
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
    public final SpecialtySkill getSpecialtySkill(final String name) {
	return _getSpecialtySkills().get(name);
    }

    @Override
    public final Collection<SpecialtySkill> getSpecialtySkills() {
	return Collections.unmodifiableCollection(_getSpecialtySkills()
		.values());
    }

    @Override
    public final Trait getTrait(final String name) {
	return _getTraits().get(name);
    }

    @Override
    public final Collection<Trait> getTraits() {
	return Collections.unmodifiableCollection(_getTraits().values());
    }

    @Override
    public final Boolean hasDirectedTrait(final String name,
	    final String annotation) {
	return _getDirectedTraits().containsKey(
		TokenUtil.getNameAndDescriptorToken(name, annotation));
    }

    @Override
    public final Boolean hasPassion(final String name, final String annotation) {
	return _getPassions().containsKey(
		TokenUtil.getNameAndDescriptorToken(name, annotation));
    }

    @Override
    public final Boolean hasSkill(final String name, final String annotation) {
	return _getSkills().containsKey(
		TokenUtil.getNameAndDescriptorToken(name, annotation));
    }

    @Override
    public final Boolean hasSpecialtySkill(final String name) {
	return _getSpecialtySkills().containsKey(name);
    }

    @Override
    public final Boolean hasTrait(final String name) {
	return _getTraits().containsKey(name);
    }

    public final void removePassion(final String name, final String annotation) {
	// TODO: Is this required?
	_getPassions().containsKey(
		TokenUtil.getNameAndDescriptorToken(name, annotation));
    }

    public final void setDirectedTraits(final Collection<DirectedTrait> traits) {
	_getDirectedTraits().clear();
	for (final DirectedTrait trait : traits) {
	    addDirectedTrait(trait);
	}
    }

    public final void setGender(final Gender gender) {
	this.gender = gender;
    }

    public final void setPassions(final Collection<Passion> passions) {
	_getPassions().clear();
	for (final Passion passion : passions) {
	    addPassion(passion);
	}
    }

    public final void setSpecialtySkills(final Collection<SpecialtySkill> skills) {
	_getSpecialtySkills().clear();
	for (final SpecialtySkill skill : skills) {
	    addSpecialtySkill(skill);
	}
    }

    private final void assembleAdvancedSkill(final SpecialtySkill vhAdvSkill) {
	for (final String skill : vhAdvSkill.getSurrogatedSkills()) {
	    if (hasSkill(skill, "")) {
		vhAdvSkill.registerSkill(getSkill(skill, ""));
	    }
	}
    }

    private final void registerIntoAdvancedSkill(final Skill vhSkill) {
	for (final SpecialtySkill skill : getSpecialtySkills()) {
	    if (skill.isSkillContained(vhSkill.getName())) {
		skill.registerSkill(vhSkill);
	    }
	}
    }

    protected final Map<String, DirectedTrait> _getDirectedTraits() {
	return directedTraits;
    }

    protected final Map<String, Passion> _getPassions() {
	return passions;
    }

    protected final Map<String, Skill> _getSkills() {
	return skills;
    }

    protected final Map<String, SpecialtySkill> _getSpecialtySkills() {
	return skillsSpecialty;
    }

    protected final Map<String, Trait> _getTraits() {
	return traits;
    }

    protected final void addTrait(final Trait vhTrait) {
	_getTraits().put(vhTrait.getName(), vhTrait);
	_getTraits().put(vhTrait.getMirrorTrait().getName(),
		vhTrait.getMirrorTrait());
    }

}
