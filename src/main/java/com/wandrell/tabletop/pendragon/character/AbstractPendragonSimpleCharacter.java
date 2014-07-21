package com.wandrell.tabletop.pendragon.character;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.character.Gender;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonAttribute;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonDirectedTrait;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonPassion;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonSkill;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonSpecialtySkill;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonTrait;
import com.wandrell.tabletop.util.TokenUtil;

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
    public final void addDirectedTrait(final PendragonDirectedTrait trait) {
	if (trait == null) {
	    throw new NullPointerException();
	}

	_getDirectedTraits().put(
		TokenUtil.getNameAndDescriptorToken(trait.getName(),
			trait.getDescriptor()), trait);
    }

    @Override
    public final void addPassion(final PendragonPassion passion) {
	if (passion == null) {
	    throw new NullPointerException();
	}

	_getPassions().put(
		TokenUtil.getNameAndDescriptorToken(passion.getName(),
			passion.getDescriptor()), passion);
    }

    @Override
    public final void addSkill(final PendragonSkill skill) {
	if (skill == null) {
	    throw new NullPointerException();
	}

	_getSkills().put(
		TokenUtil.getNameAndDescriptorToken(skill.getName(),
			skill.getDescriptor()), skill);
	registerIntoAdvancedSkill(skill);
    }

    @Override
    public final void addSpecialtySkill(final PendragonSpecialtySkill skill) {
	if (skill == null) {
	    throw new NullPointerException();
	}

	_getSpecialtySkills().put(skill.getName(), skill);
	assembleAdvancedSkill(skill);
    }

    @Override
    public final PendragonDirectedTrait getDirectedTrait(final String name,
	    final String annotation) {
	return _getDirectedTraits().get(
		TokenUtil.getNameAndDescriptorToken(name, annotation));
    }

    @Override
    public final Collection<PendragonDirectedTrait> getDirectedTraits() {
	return Collections
		.unmodifiableCollection(_getDirectedTraits().values());
    }

    @Override
    public final Gender getGender() {
	return gender;
    }

    @Override
    public final PendragonPassion getPassion(final String name,
	    final String annotation) {
	return _getPassions().get(
		TokenUtil.getNameAndDescriptorToken(name, annotation));
    }

    @Override
    public final Collection<PendragonPassion> getPassions() {
	return Collections.unmodifiableCollection(_getPassions().values());
    }

    @Override
    public final PendragonSkill getSkill(final String name,
	    final String annotation) {
	return _getSkills().get(
		TokenUtil.getNameAndDescriptorToken(name, annotation));
    }

    @Override
    public final Collection<PendragonSkill> getSkills() {
	return Collections.unmodifiableCollection(_getSkills().values());
    }

    @Override
    public final PendragonSpecialtySkill getSpecialtySkill(final String name) {
	return _getSpecialtySkills().get(name);
    }

    @Override
    public final Collection<PendragonSpecialtySkill> getSpecialtySkills() {
	return Collections.unmodifiableCollection(_getSpecialtySkills()
		.values());
    }

    @Override
    public final PendragonTrait getTrait(final String name) {
	return _getTraits().get(name);
    }

    @Override
    public final Collection<PendragonTrait> getTraits() {
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

    public final void setDirectedTraits(
	    final Collection<PendragonDirectedTrait> traits) {
	_getDirectedTraits().clear();
	for (final PendragonDirectedTrait trait : traits) {
	    addDirectedTrait(trait);
	}
    }

    public final void setGender(final Gender gender) {
	this.gender = gender;
    }

    public final void setPassions(final Collection<PendragonPassion> passions) {
	_getPassions().clear();
	for (final PendragonPassion passion : passions) {
	    addPassion(passion);
	}
    }

    public final void setSpecialtySkills(
	    final Collection<PendragonSpecialtySkill> skills) {
	_getSpecialtySkills().clear();
	for (final PendragonSpecialtySkill skill : skills) {
	    addSpecialtySkill(skill);
	}
    }

    private final void assembleAdvancedSkill(
	    final PendragonSpecialtySkill vhAdvSkill) {
	for (final String skill : vhAdvSkill.getSurrogatedSkills()) {
	    if (hasSkill(skill, "")) {
		vhAdvSkill.registerSkill(getSkill(skill, ""));
	    }
	}
    }

    private final void registerIntoAdvancedSkill(final PendragonSkill vhSkill) {
	for (final PendragonSpecialtySkill skill : getSpecialtySkills()) {
	    if (skill.isSkillContained(vhSkill.getName())) {
		skill.registerSkill(vhSkill);
	    }
	}
    }

    protected final Map<String, PendragonDirectedTrait> _getDirectedTraits() {
	return directedTraits;
    }

    protected final Map<String, PendragonPassion> _getPassions() {
	return passions;
    }

    protected final Map<String, PendragonSkill> _getSkills() {
	return skills;
    }

    protected final Map<String, PendragonSpecialtySkill> _getSpecialtySkills() {
	return skillsSpecialty;
    }

    protected final Map<String, PendragonTrait> _getTraits() {
	return traits;
    }

    protected final void addTrait(final PendragonTrait vhTrait) {
	_getTraits().put(vhTrait.getName(), vhTrait);
	_getTraits().put(vhTrait.getMirrorTrait().getName(),
		vhTrait.getMirrorTrait());
    }

}
