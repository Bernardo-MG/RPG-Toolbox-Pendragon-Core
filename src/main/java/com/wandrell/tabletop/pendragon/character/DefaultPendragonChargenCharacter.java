package com.wandrell.tabletop.pendragon.character;

import java.util.Collection;

import com.wandrell.tabletop.character.Gender;
import com.wandrell.tabletop.pendragon.character.background.FamilyCharacteristic;
import com.wandrell.tabletop.pendragon.character.background.FatherClass;
import com.wandrell.tabletop.pendragon.character.background.Homeland;
import com.wandrell.tabletop.pendragon.character.background.Religion;
import com.wandrell.tabletop.pendragon.character.background.culture.Culture;
import com.wandrell.tabletop.pendragon.character.follower.Follower;
import com.wandrell.tabletop.pendragon.character.follower.Wife;
import com.wandrell.tabletop.pendragon.character.module.TraitsBonusSwitchsData;
import com.wandrell.tabletop.pendragon.conf.PendragonToken;
import com.wandrell.tabletop.pendragon.glory.GloryKeeper;
import com.wandrell.tabletop.pendragon.inventory.ArmorData;
import com.wandrell.tabletop.pendragon.inventory.PendragonItem;
import com.wandrell.tabletop.pendragon.inventory.PendragonMoney;
import com.wandrell.tabletop.pendragon.manor.ManorAnimal;
import com.wandrell.tabletop.pendragon.util.TextValue;
import com.wandrell.tabletop.pendragon.valuehandler.Attribute;
import com.wandrell.tabletop.pendragon.valuehandler.DerivedAttribute;
import com.wandrell.tabletop.pendragon.valuehandler.DirectedTrait;
import com.wandrell.tabletop.pendragon.valuehandler.DistinctiveFeature;
import com.wandrell.tabletop.pendragon.valuehandler.Passion;
import com.wandrell.tabletop.pendragon.valuehandler.Skill;
import com.wandrell.tabletop.pendragon.valuehandler.SpecialtySkill;
import com.wandrell.tabletop.pendragon.valuehandler.Trait;
import com.wandrell.tabletop.valuehandler.ValueHandler;

public final class DefaultPendragonChargenCharacter implements
	PendragonChargenCharacter {

    private class StatusFlags {
	public Boolean flagFamilyCharChosen = false;
	// TODO: Quitar esto de aquí
	public Boolean flagKnightChosen = false;

	public StatusFlags() {
	    super();
	}
    }

    private final PendragonPlayerCharacter character;
    private Culture culture;
    private FatherClass fatherClass;
    private final StatusFlags holderStatusFlags = new StatusFlags();
    private Homeland homeland;

    public DefaultPendragonChargenCharacter(
	    final DefaultPendragonChargenCharacter character) {
	super();

	this.character = character.character.createNewInstance();
	culture = character.culture;
	homeland = character.homeland;
    }

    public DefaultPendragonChargenCharacter(
	    final PendragonPlayerCharacter character) {
	super();

	this.character = character;
    }

    @Override
    public final void addDerivedAttribute(final DerivedAttribute attribute) {
	getBaseCharacter().addDerivedAttribute(attribute);
    }

    @Override
    public final void addDirectedTrait(final DirectedTrait directedTrait) {
	getBaseCharacter().addDirectedTrait(directedTrait);
    }

    @Override
    public final void addDistinctiveFeature(final DistinctiveFeature feature) {
	getBaseCharacter().addDistinctiveFeature(feature);
    }

    @Override
    public final void addExclusiveSkill(final Skill skill) {
	getBaseCharacter().addExclusiveSkill(skill);
    }

    @Override
    public final void addFollower(final Follower follower) {
	getBaseCharacter().addFollower(follower);
    }

    @Override
    public final void addHoldingAtHome(final PendragonItem item) {
	getBaseCharacter().addHoldingAtHome(item);
    }

    @Override
    public final void addHoldingCarried(final PendragonItem item) {
	getBaseCharacter().addHoldingAtHome(item);
    }

    @Override
    public final void addHorse(final HorseCharacter horse) {
	getBaseCharacter().addHorse(horse);
    }

    @Override
    public final void addPassion(final Passion passion) {
	getBaseCharacter().addPassion(passion);
    }

    @Override
    public final void addPet(final ManorAnimal pet) {
	getBaseCharacter().addPet(pet);
    }

    @Override
    public final void addSkill(Skill skill) {
	getBaseCharacter().addSkill(skill);
    }

    @Override
    public final void addSpecialtySkill(SpecialtySkill skill) {
	getBaseCharacter().addSpecialtySkill(skill);
    }

    @Override
    public final void addTextValue(final String key, final String value) {
	getBaseCharacter().addTextValue(key, value);
    }

    @Override
    public final void addValueHandler(final ValueHandler<Integer> value) {
	getBaseCharacter().addValueHandler(value);
    }

    @Override
    public final void addWife(final Wife wife) {
	getBaseCharacter().addWife(wife);
    }

    @Override
    public final DefaultPendragonChargenCharacter createNewInstance() {
	return new DefaultPendragonChargenCharacter(this);
    }

    @Override
    public final boolean equals(final Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	DefaultPendragonChargenCharacter other = (DefaultPendragonChargenCharacter) obj;
	if (character == null) {
	    if (other.character != null)
		return false;
	} else if (!character.equals(other.character))
	    return false;
	return true;
    }

    @Override
    public final Attribute getAppearance() {
	return getBaseCharacter().getAppearance();
    }

    @Override
    public final ArmorData getArmor() {
	return getBaseCharacter().getArmor();
    }

    @Override
    public final Collection<Attribute> getAttributes() {
	return getBaseCharacter().getAttributes();
    }

    @Override
    public final Attribute getConstitution() {
	return getBaseCharacter().getConstitution();
    }

    @Override
    public final Culture getCulture() {
	return culture;
    }

    @Override
    public final DerivedAttribute getDamage() {
	return getBaseCharacter().getDamage();
    }

    @Override
    public final Collection<DerivedAttribute> getDerivedAttributes() {
	return getBaseCharacter().getDerivedAttributes();
    }

    @Override
    public final Attribute getDexterity() {
	return getBaseCharacter().getDexterity();
    }

    @Override
    public final DerivedAttribute getDexterityRoll() {
	return getBaseCharacter().getDexterityRoll();
    }

    @Override
    public final DirectedTrait getDirectedTrait(final String name,
	    final String annotation) {
	return getBaseCharacter().getDirectedTrait(name, annotation);
    }

    @Override
    public final Collection<DirectedTrait> getDirectedTraits() {
	return getBaseCharacter().getDirectedTraits();
    }

    @Override
    public final Collection<DistinctiveFeature> getDistinctiveFeatures() {
	return getBaseCharacter().getDistinctiveFeatures();
    }

    @Override
    public final DerivedAttribute getDistinctiveFeaturesCount() {
	return getBaseCharacter().getDistinctiveFeaturesCount();
    }

    @Override
    public final Skill getExclusiveSkill(final String name,
	    final String annotation) {
	return getBaseCharacter().getExclusiveSkill(name, annotation);
    }

    @Override
    public final Collection<Skill> getExclusiveSkills() {
	return getBaseCharacter().getExclusiveSkills();
    }

    @Override
    public final FatherClass getFatherClass() {
	return fatherClass;
    }

    @Override
    public final Boolean getFlag(final String name) {
	return getBaseCharacter().getFlag(name);
    }

    @Override
    public final Collection<String> getFlags() {
	return getBaseCharacter().getFlags();
    }

    @Override
    public final Collection<Follower> getFollowers() {
	return getBaseCharacter().getFollowers();
    }

    @Override
    public final Gender getGender() {
	return getBaseCharacter().getGender();
    }

    @Override
    public final GloryKeeper getGlory() {
	return getBaseCharacter().getGlory();
    }

    @Override
    public final DerivedAttribute getHealingRate() {
	return getBaseCharacter().getHealingRate();
    }

    @Override
    public final DerivedAttribute getHitPoints() {
	return getBaseCharacter().getHitPoints();
    }

    @Override
    public final Collection<PendragonItem> getHoldingsAtHome() {
	return getBaseCharacter().getHoldingsAtHome();
    }

    @Override
    public final Collection<PendragonItem> getHoldingsCarried() {
	return getBaseCharacter().getHoldingsCarried();
    }

    @Override
    public final Homeland getHomeland() {
	return homeland;
    }

    @Override
    public final Collection<HorseCharacter> getHorses() {
	return getBaseCharacter().getHorses();
    }

    @Override
    public final DerivedAttribute getMajorWoundTreshold() {
	return getBaseCharacter().getMajorWoundTreshold();
    }

    @Override
    public final PendragonMoney getMoney() {
	return getBaseCharacter().getMoney();
    }

    @Override
    public final DerivedAttribute getMovementRate() {
	return getBaseCharacter().getMovementRate();
    }

    @Override
    public final String getName() {
	return getBaseCharacter().getName();
    }

    @Override
    public final Passion getPassion(final String name, final String annotation) {
	return getBaseCharacter().getPassion(name, annotation);
    }

    @Override
    public final Collection<Passion> getPassions() {
	return getBaseCharacter().getPassions();
    }

    @Override
    public final Collection<ManorAnimal> getPets() {
	return getBaseCharacter().getPets();
    }

    @Override
    public final String getPlayerName() {
	return getBaseCharacter().getPlayerName();
    }

    @Override
    public final Religion getReligion() {
	return getBaseCharacter().getReligion();
    }

    @Override
    public final DerivedAttribute getSize() {
	return getBaseCharacter().getSize();
    }

    @Override
    public final Skill getSkill(final String name, final String annotation) {
	return getBaseCharacter().getSkill(name, annotation);
    }

    @Override
    public final Collection<Skill> getSkills() {
	return getBaseCharacter().getSkills();
    }

    @Override
    public final SpecialtySkill getSpecialtySkill(final String name) {
	return getBaseCharacter().getSpecialtySkill(name);
    }

    @Override
    public final Collection<SpecialtySkill> getSpecialtySkills() {
	return getBaseCharacter().getSpecialtySkills();
    }

    @Override
    public final Attribute getStrength() {
	return getBaseCharacter().getStrength();
    }

    @Override
    public final String getTextValue(final String name) {
	return getBaseCharacter().getTextValue(name);
    }

    @Override
    public final Collection<TextValue> getTextValues() {
	return getBaseCharacter().getTextValues();
    }

    @Override
    public final Trait getTrait(final String name) {
	return getBaseCharacter().getTrait(name);
    }

    @Override
    public final Collection<Trait> getTraits() {
	return getBaseCharacter().getTraits();
    }

    @Override
    public final TraitsBonusSwitchsData getTraitsBonusSwitchsData() {
	return getBaseCharacter().getTraitsBonusSwitchsData();
    }

    @Override
    public final DerivedAttribute getUnconsciousTreshold() {
	return getBaseCharacter().getUnconsciousTreshold();
    }

    @Override
    public final ValueHandler<Integer> getValueHandler(final String name) {
	return getBaseCharacter().getValueHandler(name);
    }

    @Override
    public final Collection<ValueHandler<Integer>> getValueHandlers() {
	return getBaseCharacter().getValueHandlers();
    }

    @Override
    public final DerivedAttribute getWeight() {
	return getBaseCharacter().getWeight();
    }

    @Override
    public final Collection<Wife> getWives() {
	return getBaseCharacter().getWives();
    }

    @Override
    public final Boolean hasAttribute(final String name) {
	return getBaseCharacter().hasAttribute(name);
    }

    @Override
    public final Boolean hasDerivedAttribute(final String name) {
	return getBaseCharacter().hasDerivedAttribute(name);
    }

    @Override
    public final Boolean hasDirectedTrait(final String name,
	    final String annotation) {
	return getBaseCharacter().hasDirectedTrait(name, annotation);
    }

    @Override
    public final Boolean hasExclusiveSkill(final String name,
	    final String annotation) {
	return getBaseCharacter().hasExclusiveSkill(name, annotation);
    }

    @Override
    public final int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((character == null) ? 0 : character.hashCode());
	return result;
    }

    @Override
    public final Boolean hasPassion(final String name, final String annotation) {
	return getBaseCharacter().hasPassion(name, annotation);
    }

    @Override
    public final Boolean hasSkill(final String name, final String annotation) {
	return getBaseCharacter().hasSkill(name, annotation);
    }

    @Override
    public final Boolean hasSpecialtySkill(final String name) {
	return getBaseCharacter().hasSpecialtySkill(name);
    }

    @Override
    public final Boolean hasTextValue(final String name) {
	return getBaseCharacter().hasTextValue(name);
    }

    @Override
    public final Boolean hasTrait(final String name) {
	return getBaseCharacter().hasTrait(name);
    }

    @Override
    public final Boolean hasValueHandler(final String name) {
	return getBaseCharacter().hasValueHandler(name);
    }

    @Override
    public final Boolean isKnight() {
	return getBaseCharacter().isKnight();
    }

    @Override
    public final Boolean isKnightChosen() {
	return getCharFlags().flagKnightChosen;
    }

    @Override
    public final void setCulture(final Culture culture) {
	if (culture == null) {
	    throw new NullPointerException();
	}

	this.culture = culture;

	addTextValue(PendragonToken.TEXT_CULTURE_NAME, culture.getName());
    }

    @Override
    public final void setFamilyCharacteristic(
	    final FamilyCharacteristic characteristic) {
	if (!holderStatusFlags.flagFamilyCharChosen) {
	    // TODO: Quizás sea mejor hacer esto fuera
	    // ValueHandlerServicesFactory.getTemplateService().loadBonusTemplate(
	    // this, characteristic);

	    if (characteristic == null) {
		throw new NullPointerException();
	    }

	    addTextValue(PendragonToken.TEXT_FAMILY_CHARACTERISTIC,
		    characteristic.getName());
	    holderStatusFlags.flagFamilyCharChosen = true;
	}
    }

    @Override
    public final void setFatherClassData(final FatherClass fatherClass) {
	if (this.fatherClass == null) {
	    this.fatherClass = fatherClass;

	    if (fatherClass == null) {
		throw new NullPointerException();
	    }

	    addTextValue(PendragonToken.TEXT_FATHER_CLASS,
		    fatherClass.getName());
	    // ValueHandlerServicesFactory.getTemplateService()
	    // .loadBaseValuesTemplate(this,
	    // dataFatherClass.getBaseValuesTemplate());
	    // ValueHandlerServicesFactory.getTemplateService().loadBonusTemplate(
	    // this, dataFatherClass.getBonusValuesTemplate());
	}
    }

    @Override
    public final void setHomelandData(final Homeland homeland) {
	if (this.homeland == null) {
	    this.homeland = homeland;
	    addTextValue(PendragonToken.TEXT_HOMELAND, homeland.getName());
	}
    }

    @Override
    public final void setKnight(final Boolean isKnight) {
	getBaseCharacter().setKnight(isKnight);
	getCharFlags().flagKnightChosen = isKnight;
    }

    @Override
    public final String toString() {
	return getBaseCharacter().toString();
    }

    private final PendragonPlayerCharacter getBaseCharacter() {
	return character;
    }

    private final StatusFlags getCharFlags() {
	return holderStatusFlags;
    }

}
