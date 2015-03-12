package com.wandrell.tabletop.pendragon.model.character;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import com.wandrell.tabletop.character.Gender;
import com.wandrell.tabletop.pendragon.model.character.background.Religion;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonCharacterListener;
import com.wandrell.tabletop.pendragon.model.glory.GloryManager;
import com.wandrell.tabletop.pendragon.model.inventory.Money;
import com.wandrell.tabletop.pendragon.model.manor.Pet;
import com.wandrell.tabletop.pendragon.model.stats.PendragonSkillBox;
import com.wandrell.tabletop.pendragon.model.stats.SpecialtySkillBox;
import com.wandrell.tabletop.valuebox.DefaultEditableValueBox;
import com.wandrell.tabletop.valuebox.EditableValueBox;
import com.wandrell.tabletop.valuebox.SkillBox;

public final class DefaultPendragonPlayerCharacter implements
        PendragonPlayerCharacter {

    private final EditableValueBox               armor;
    private final String                         fatherClass;
    private final Collection<DistinctiveFeature> features = new LinkedHashSet<DistinctiveFeature>();
    private final GloryManager                   glory;
    private final String                         homeland;
    private final PendragonHumanCharacter        humanCharacter;
    private final Collection<Pet>                pets     = new LinkedHashSet<Pet>();
    private final String                         playerName;

    public DefaultPendragonPlayerCharacter(
            final DefaultPendragonPlayerCharacter character) {
        super();

        checkNotNull(character, "Received a null pointer as character");

        humanCharacter = character.humanCharacter.createNewInstance();

        playerName = character.playerName;
        homeland = character.homeland;
        fatherClass = character.fatherClass;

        // TODO: Copy correctly
        pets.addAll(character.pets);

        for (final DistinctiveFeature feature : character.features) {
            features.add(feature);
        }

        // Initializes data holders
        armor = character.getArmorValueBox().createNewInstance();
        glory = character.glory;

        // TODO: Handle this
        // getGloryData().setReligiousAnnualGlorySwitch(
        // getTraitsBonusSwitchsData().getBonusSwitch(
        // PendragonLabels.BONUS_TRAITS_RELIGIOUS_SWITCH));
    }

    public DefaultPendragonPlayerCharacter(final String name,
            final DerivedAttributeBuilder derivedAttributeBuilder,
            final String player, final Religion religion, final String culture,
            final String fatherClass, final String homeland,
            final GloryManager glory, final Money money, final Boolean knight) {
        super();

        checkNotNull(player, "Received a null pointer as player name");
        checkNotNull(religion, "Received a null pointer as religion");
        checkNotNull(culture, "Received a null pointer as culture");
        checkNotNull(fatherClass, "Received a null pointer as father class");
        checkNotNull(homeland, "Received a null pointer as homeland");
        checkNotNull(glory, "Received a null pointer as glory");
        checkNotNull(money, "Received a null pointer as money");
        checkNotNull(knight, "Received a null pointer as knight flag");

        humanCharacter = new DefaultPendragonHumanCharacter(name,
                derivedAttributeBuilder, culture, religion);

        playerName = player;

        this.fatherClass = fatherClass;
        this.homeland = homeland;

        // Initializes data holders
        this.glory = glory;
        this.armor = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
    }

    @Override
    public final void addDirectedTrait(final SkillBox directedTrait) {
        checkNotNull(directedTrait, "Received a null pointer as directed trait");

        getBaseCharacter().addDirectedTrait(directedTrait);
    }

    @Override
    public final void addDistinctiveFeature(final DistinctiveFeature feature) {
        checkNotNull(feature, "Received a null pointer as feature");

        getFeaturesModifiable().add(feature);
    }

    @Override
    public final void addPassion(final SkillBox passion) {
        checkNotNull(passion, "Received a null pointer as passion");

        getBaseCharacter().addPassion(passion);
    }

    @Override
    public final void addPendragonCharacterListener(
            final PendragonCharacterListener listener) {
        getBaseCharacter().addPendragonCharacterListener(listener);
    }

    @Override
    public final void addPet(final Pet pet) {
        checkNotNull(pet, "Received a null pointer as pet");

        getPetsModifiable().add(pet);
    }

    @Override
    public final void addSkill(PendragonSkillBox skill) {
        checkNotNull(skill, "Received a null pointer as skill");

        getBaseCharacter().addSkill(skill);
    }

    @Override
    public final void addSpecialtySkill(final SpecialtySkillBox skill) {
        checkNotNull(skill, "Received a null pointer as specialty skill");

        getBaseCharacter().addSpecialtySkill(skill);
    }

    @Override
    public final void clearDirectedTraits() {
        getBaseCharacter().clearDirectedTraits();
    }

    @Override
    public final void clearDistinctiveFeatures() {
        getFeaturesModifiable().clear();
    }

    @Override
    public final void clearPassions() {
        getBaseCharacter().clearPassions();
    }

    @Override
    public final void clearPet() {
        getPetsModifiable().clear();
    }

    @Override
    public final void clearSkills() {
        getBaseCharacter().clearSkills();
    }

    @Override
    public final void clearSpecialtySkills() {
        getBaseCharacter().clearSpecialtySkills();
    }

    @Override
    public final DefaultPendragonPlayerCharacter createNewInstance() {
        return new DefaultPendragonPlayerCharacter(this);
    }

    @Override
    public final Integer getAppearance() {
        return getBaseCharacter().getAppearance();
    }

    @Override
    public final Integer getArbitrary() {
        return getBaseCharacter().getArbitrary();
    }

    @Override
    public final Integer getChaste() {
        return getBaseCharacter().getChaste();
    }

    @Override
    public final Integer getConstitution() {
        return getBaseCharacter().getConstitution();
    }

    @Override
    public final Integer getCowardly() {
        return getBaseCharacter().getCowardly();
    }

    @Override
    public final Integer getCruel() {
        return getBaseCharacter().getCruel();
    }

    @Override
    public final String getCulture() {
        return getBaseCharacter().getCulture();
    }

    @Override
    public final Integer getDamage() {
        return getBaseCharacter().getDamage();
    }

    @Override
    public final Integer getDeceitful() {
        return getBaseCharacter().getDeceitful();
    }

    @Override
    public final Integer getDexterity() {
        return getBaseCharacter().getDexterity();
    }

    @Override
    public final Integer getDexterityRoll() {
        return getBaseCharacter().getDexterityRoll();
    }

    @Override
    public final Collection<SkillBox> getDirectedTraits() {
        return getBaseCharacter().getDirectedTraits();
    }

    @Override
    public final Collection<DistinctiveFeature> getDistinctiveFeatures() {
        return Collections.unmodifiableCollection(getFeaturesModifiable());
    }

    @Override
    public final Integer getEnergetic() {
        return getBaseCharacter().getEnergetic();
    }

    @Override
    public final String getFatherClass() {
        return fatherClass;
    }

    @Override
    public final Integer getForgiving() {
        return getBaseCharacter().getForgiving();
    }

    @Override
    public final Gender getGender() {
        return getBaseCharacter().getGender();
    }

    @Override
    public final Integer getGenerous() {
        return getBaseCharacter().getGenerous();
    }

    @Override
    public final Integer getGlory() {
        return getBaseCharacter().getGlory();
    }

    @Override
    public final Integer getHealingRate() {
        return getBaseCharacter().getHealingRate();
    }

    @Override
    public final Integer getHitPoints() {
        return getBaseCharacter().getHitPoints();
    }

    @Override
    public final String getHomeland() {
        return homeland;
    }

    @Override
    public final Integer getHonest() {
        return getBaseCharacter().getHonest();
    }

    @Override
    public final Integer getIndulgent() {
        return getBaseCharacter().getIndulgent();
    }

    @Override
    public final Integer getJust() {
        return getBaseCharacter().getJust();
    }

    @Override
    public final Integer getLazy() {
        return getBaseCharacter().getLazy();
    }

    @Override
    public final Integer getLustful() {
        return getBaseCharacter().getLustful();
    }

    @Override
    public final Integer getMajorWoundTreshold() {
        return getBaseCharacter().getMajorWoundTreshold();
    }

    @Override
    public final Integer getMerciful() {
        return getBaseCharacter().getMerciful();
    }

    @Override
    public final Integer getModest() {
        return getBaseCharacter().getModest();
    }

    @Override
    public final Integer getMoveRate() {
        return getBaseCharacter().getMoveRate();
    }

    @Override
    public final String getName() {
        return getBaseCharacter().getName();
    }

    @Override
    public final Collection<SkillBox> getPassions() {
        return getBaseCharacter().getPassions();
    }

    @Override
    public final Collection<Pet> getPets() {
        return Collections.unmodifiableCollection(getPetsModifiable());
    }

    @Override
    public final Integer getPious() {
        return getBaseCharacter().getPious();
    }

    @Override
    public final String getPlayerName() {
        return playerName;
    }

    @Override
    public final Integer getProud() {
        return getBaseCharacter().getProud();
    }

    @Override
    public final Integer getPrudent() {
        return getBaseCharacter().getPrudent();
    }

    @Override
    public final Integer getReckless() {
        return getBaseCharacter().getReckless();
    }

    @Override
    public final Religion getReligion() {
        return getBaseCharacter().getReligion();
    }

    @Override
    public final Integer getSelfish() {
        return getBaseCharacter().getSelfish();
    }

    @Override
    public final Integer getSize() {
        return getBaseCharacter().getSize();
    }

    @Override
    public final Collection<PendragonSkillBox> getSkills() {
        return getBaseCharacter().getSkills();
    }

    @Override
    public final Collection<SpecialtySkillBox> getSpecialtySkills() {
        return getBaseCharacter().getSpecialtySkills();
    }

    @Override
    public final Integer getStrength() {
        return getBaseCharacter().getStrength();
    }

    @Override
    public final Integer getSuspicious() {
        return getBaseCharacter().getSuspicious();
    }

    @Override
    public final Integer getTemperate() {
        return getBaseCharacter().getTemperate();
    }

    @Override
    public final Integer getTrusting() {
        return getBaseCharacter().getTrusting();
    }

    @Override
    public final Integer getUnconciousTreshold() {
        return getBaseCharacter().getUnconciousTreshold();
    }

    @Override
    public final Integer getValorous() {
        return getBaseCharacter().getValorous();
    }

    @Override
    public final Integer getVengeful() {
        return getBaseCharacter().getVengeful();
    }

    @Override
    public final Integer getWeight() {
        return getBaseCharacter().getWeight();
    }

    @Override
    public final Integer getWorldly() {
        return getBaseCharacter().getWorldly();
    }

    @Override
    public final Boolean isKnight() {
        return getBaseCharacter().isKnight();
    }

    @Override
    public final void removeDirectedTrait(final SkillBox directedTrait) {
        getBaseCharacter().removeDirectedTrait(directedTrait);
    }

    @Override
    public final void
            removeDistinctiveFeature(final DistinctiveFeature feature) {
        getFeaturesModifiable().remove(feature);
    }

    @Override
    public final void removePassion(final SkillBox passion) {
        getBaseCharacter().removePassion(passion);
    }

    @Override
    public final void removePendragonCharacterListener(
            final PendragonCharacterListener listener) {
        getBaseCharacter().removePendragonCharacterListener(listener);
    }

    @Override
    public final void removePet(final Pet pet) {
        getPetsModifiable().remove(pet);
    }

    @Override
    public final void removeSkill(final PendragonSkillBox skill) {
        getBaseCharacter().removeSkill(skill);
    }

    @Override
    public final void removeSpecialtySkill(final SpecialtySkillBox skill) {
        getBaseCharacter().removeSpecialtySkill(skill);
    }

    @Override
    public final void setAppearance(final Integer appearance) {
        getBaseCharacter().setAppearance(appearance);
    }

    @Override
    public final void setArbitrary(final Integer arbitrary) {
        getBaseCharacter().setArbitrary(arbitrary);
    }

    @Override
    public final void setChaste(final Integer chaste) {
        getBaseCharacter().setChaste(chaste);
    }

    @Override
    public final void setConstitution(final Integer constitution) {
        getBaseCharacter().setConstitution(constitution);
    }

    @Override
    public final void setCowardly(final Integer cowardly) {
        getBaseCharacter().setCowardly(cowardly);
    }

    @Override
    public final void setCruel(final Integer cruel) {
        getBaseCharacter().setCruel(cruel);
    }

    @Override
    public final void setDeceitful(final Integer deceitful) {
        getBaseCharacter().setDeceitful(deceitful);
    }

    @Override
    public final void setDexterity(final Integer dexterity) {
        getBaseCharacter().setDexterity(dexterity);
    }

    @Override
    public final void setDirectedTraits(Collection<SkillBox> directedTraits) {
        getBaseCharacter().setDirectedTraits(directedTraits);
    }

    @Override
    public final void setDistinctiveFeatures(
            final Collection<DistinctiveFeature> features) {
        getFeaturesModifiable().clear();

        for (final DistinctiveFeature feature : features) {
            getFeaturesModifiable().add(feature);
        }
    }

    @Override
    public final void setEnergetic(final Integer energetic) {
        getBaseCharacter().setEnergetic(energetic);
    }

    @Override
    public final void setForgiving(final Integer forgiving) {
        getBaseCharacter().setForgiving(forgiving);
    }

    @Override
    public final void setGenerous(final Integer generous) {
        getBaseCharacter().setGenerous(generous);
    }

    @Override
    public final void setGlory(final Integer glory) {
        getBaseCharacter().setGlory(glory);
    }

    @Override
    public final void setHonest(final Integer honest) {
        getBaseCharacter().setHonest(honest);
    }

    @Override
    public final void setIndulgent(final Integer indulgent) {
        getBaseCharacter().setIndulgent(indulgent);
    }

    @Override
    public final void setJust(final Integer just) {
        getBaseCharacter().setJust(just);
    }

    @Override
    public final void setKnight(final Boolean knight) {
        getBaseCharacter().setKnight(knight);
    }

    @Override
    public final void setLazy(final Integer lazy) {
        getBaseCharacter().setLazy(lazy);
    }

    @Override
    public final void setLustful(final Integer lustful) {
        getBaseCharacter().setLustful(lustful);
    }

    @Override
    public final void setMerciful(final Integer merciful) {
        getBaseCharacter().setMerciful(merciful);
    }

    @Override
    public final void setModest(final Integer modest) {
        getBaseCharacter().setModest(modest);
    }

    @Override
    public final void setPassions(final Collection<SkillBox> passions) {
        getBaseCharacter().setPassions(passions);
    }

    @Override
    public final void setPets(final Collection<Pet> pets) {
        getPetsModifiable().clear();
        for (final Pet pet : pets) {
            getPetsModifiable().add(pet);
        }
    }

    @Override
    public final void setPious(final Integer pious) {
        getBaseCharacter().setPious(pious);
    }

    @Override
    public final void setProud(final Integer proud) {
        getBaseCharacter().setProud(proud);
    }

    @Override
    public final void setPrudent(final Integer prudent) {
        getBaseCharacter().setPrudent(prudent);
    }

    @Override
    public final void setReckless(final Integer reckless) {
        getBaseCharacter().setReckless(reckless);
    }

    @Override
    public final void setReligion(final Religion religion) {
        getBaseCharacter().setReligion(religion);
    }

    @Override
    public final void setSelfish(final Integer selfish) {
        getBaseCharacter().setSelfish(selfish);
    }

    @Override
    public final void setSize(final Integer size) {
        getBaseCharacter().setSize(size);
    }

    @Override
    public final void setSkills(final Collection<PendragonSkillBox> skills) {
        getBaseCharacter().setSkills(skills);
    }

    @Override
    public final void setSpecialtySkills(
            final Collection<SpecialtySkillBox> skills) {
        getBaseCharacter().setSpecialtySkills(skills);
    }

    @Override
    public final void setStrength(final Integer strength) {
        getBaseCharacter().setStrength(strength);
    }

    @Override
    public final void setSuspicious(final Integer suspicious) {
        getBaseCharacter().setSuspicious(suspicious);
    }

    @Override
    public final void setTemperate(final Integer temperate) {
        getBaseCharacter().setTemperate(temperate);
    }

    @Override
    public final void setTrusting(final Integer trusting) {
        getBaseCharacter().setTrusting(trusting);
    }

    @Override
    public final void setValorous(final Integer valorous) {
        getBaseCharacter().setValorous(valorous);
    }

    private final EditableValueBox getArmorValueBox() {
        return armor;
    }

    private final PendragonHumanCharacter getBaseCharacter() {
        return humanCharacter;
    }

    private final Collection<DistinctiveFeature> getFeaturesModifiable() {
        return features;
    }

    private final Collection<Pet> getPetsModifiable() {
        return pets;
    }

}
