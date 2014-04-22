package com.wandrell.tabletop.rpg.pendragon.character;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import com.wandrell.tabletop.rpg.character.Gender;
import com.wandrell.tabletop.rpg.pendragon.util.PendragonValueHandlerUtils;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonAggregatedSkill;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonAttribute;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonDirectedTrait;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonPassion;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonSkill;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonTrait;

public abstract class AbstractPendragonSimpleCharacter extends
	AbstractPendragonBaseCharacter implements PendragonSimpleCharacter {

    private Gender gender = null;
    private final Map<String, PendragonAggregatedSkill> skillsAdvanced = new LinkedHashMap<>();
    private final Map<String, PendragonDirectedTrait> storeDirectedTraits = new LinkedHashMap<>();
    private final Map<String, PendragonPassion> storePassions = new LinkedHashMap<>();
    private final Map<String, PendragonSkill> storeSkills = new LinkedHashMap<>();
    private final Map<String, PendragonTrait> traits = new LinkedHashMap<>();

    public AbstractPendragonSimpleCharacter(
	    final AbstractPendragonSimpleCharacter character) {
	super(character);

	for (final PendragonAggregatedSkill skill : character.skillsAdvanced
		.values()) {
	    addAdvancedSkill(skill.createNewInstance());
	}
	for (final PendragonDirectedTrait trait : character.storeDirectedTraits
		.values()) {
	    addDirectedTrait(trait.createNewInstance());
	}
	for (final PendragonPassion passion : character.storePassions.values()) {
	    addPassion(passion.createNewInstance());
	}
	for (final PendragonSkill skill : character.storeSkills.values()) {
	    addSkill(skill.createNewInstance());
	}

	for (final PendragonTrait trait : character.traits.values()) {
	    getTrait(trait.getName()).setValue(trait.getStoredValue());
	}

	setGender(character.gender);
    }

    public AbstractPendragonSimpleCharacter(
	    final Collection<PendragonAttribute> attributes,
	    final Collection<PendragonTrait> traits) {
	super(attributes);

	setTraits(traits);
    }

    @Override
    public void addAdvancedSkill(final PendragonAggregatedSkill skill) {
	getAdvancedSkillsMap().put(skill.getName(), skill);
	assembleAdvancedSkill(skill);
    }

    @Override
    public void addDirectedTrait(final PendragonDirectedTrait trait) {
	getDirectedTraitsStore().put(
		PendragonValueHandlerUtils.getNameAnnotationKey(
			trait.getName(), trait.getAnnotation()), trait);
    }

    @Override
    public void addPassion(final PendragonPassion passion) {
	getPassionsStore().put(
		PendragonValueHandlerUtils.getNameAnnotationKey(
			passion.getName(), passion.getAnnotation()), passion);
    }

    @Override
    public void addSkill(final PendragonSkill skill) {
	getSkillsStore().put(
		PendragonValueHandlerUtils.getNameAnnotationKey(
			skill.getName(), skill.getAnnotation()), skill);
	registerIntoAdvancedSkill(skill);
    }

    @Override
    public PendragonAggregatedSkill getAdvancedSkill(final String name) {
	return getAdvancedSkillsMap().get(name);
    }

    @Override
    public Collection<PendragonAggregatedSkill> getAdvancedSkills() {
	return Collections.unmodifiableCollection(getAdvancedSkillsMap()
		.values());
    }

    @Override
    public PendragonDirectedTrait getDirectedTrait(final String name,
	    final String annotation) {
	return getDirectedTraitsStore().get(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public Collection<PendragonDirectedTrait> getDirectedTraits() {
	return Collections.unmodifiableCollection(getDirectedTraitsStore()
		.values());
    }

    @Override
    public Gender getGender() {
	return gender;
    }

    @Override
    public PendragonPassion getPassion(final String name,
	    final String annotation) {
	return getPassionsStore().get(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public Collection<PendragonPassion> getPassions() {
	return Collections.unmodifiableCollection(getPassionsStore().values());
    }

    @Override
    public PendragonSkill getSkill(final String name, final String annotation) {
	return getSkillsStore().get(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public Collection<PendragonSkill> getSkills() {
	return Collections.unmodifiableCollection(getSkillsStore().values());
    }

    @Override
    public PendragonTrait getTrait(final String name) {
	return getTraitsMap().get(name);
    }

    @Override
    public Collection<PendragonTrait> getTraits() {
	return Collections.unmodifiableCollection(getTraitsMap().values());
    }

    @Override
    public Boolean hasAdvancedSkill(final String name) {
	return getAdvancedSkillsMap().containsKey(name);
    }

    @Override
    public boolean hasDirectedTrait(final String name, final String annotation) {
	return getDirectedTraitsStore().containsKey(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public boolean hasPassion(final String name, final String annotation) {
	return getPassionsStore().containsKey(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public boolean hasSkill(final String name, final String annotation) {
	return getSkillsStore().containsKey(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public boolean hasTrait(final String name) {
	return getTraitsMap().containsKey(name);
    }

    @Override
    public void removePassion(final String name, final String annotation) {
	getPassionsStore().containsKey(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    public void setAdvancedSkills(
	    final Collection<PendragonAggregatedSkill> skills) {
	getAdvancedSkillsMap().clear();
	for (final PendragonAggregatedSkill skill : skills) {
	    addAdvancedSkill(skill);
	}
    }

    public void setDirectedTraits(
	    final Collection<PendragonDirectedTrait> traits) {
	getDirectedTraitsStore().clear();
	for (final PendragonDirectedTrait trait : traits) {
	    addDirectedTrait(trait);
	}
    }

    public void setGender(final Gender gender) {
	this.gender = gender;
    }

    public void setPassions(final Collection<PendragonPassion> passions) {
	getPassionsStore().clear();
	for (final PendragonPassion passion : passions) {
	    addPassion(passion);
	}
    }

    private void assembleAdvancedSkill(final PendragonAggregatedSkill vhAdvSkill) {
	for (final String skill : vhAdvSkill.getSkillsNames()) {
	    if (hasSkill(skill, "")) {
		vhAdvSkill.register(getSkill(skill, ""));
	    }
	}
    }

    private void registerIntoAdvancedSkill(final PendragonSkill vhSkill) {
	for (final PendragonAggregatedSkill skill : getAdvancedSkills()) {
	    if (skill.isSkillContained(vhSkill.getName())) {
		skill.register(vhSkill);
	    }
	}
    }

    protected void addTrait(final PendragonTrait vhTrait) {
	getTraitsMap().put(vhTrait.getName(), vhTrait);
	getTraitsMap().put(vhTrait.getMirrorTrait().getName(),
		vhTrait.getMirrorTrait());
    }

    protected Map<String, PendragonAggregatedSkill> getAdvancedSkillsMap() {
	return skillsAdvanced;
    }

    protected Map<String, PendragonDirectedTrait> getDirectedTraitsStore() {
	return storeDirectedTraits;
    }

    protected Map<String, PendragonPassion> getPassionsStore() {
	return storePassions;
    }

    protected Map<String, PendragonSkill> getSkillsStore() {
	return storeSkills;
    }

    protected Map<String, PendragonTrait> getTraitsMap() {
	return traits;
    }

    protected void setSkills(final Collection<PendragonSkill> skills) {
	getSkillsStore().clear();
	for (final PendragonSkill skill : skills) {
	    addSkill(skill);
	}
    }

    protected void setTraits(final Collection<PendragonTrait> traits) {
	getTraitsMap().clear();
	for (final PendragonTrait trait : traits) {
	    addTrait(trait);
	}
    }

}
