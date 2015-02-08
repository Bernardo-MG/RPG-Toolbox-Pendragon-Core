package com.wandrell.tabletop.business.model.pendragon.character;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import com.wandrell.tabletop.business.model.character.Gender;
import com.wandrell.tabletop.business.model.pendragon.character.DefaultPendragonBaseCharacter.DerivedAttributeBuilder;
import com.wandrell.tabletop.business.model.pendragon.character.follower.Follower;
import com.wandrell.tabletop.business.model.pendragon.character.follower.Wife;
import com.wandrell.tabletop.business.model.pendragon.glory.GloryManager;
import com.wandrell.tabletop.business.model.pendragon.inventory.Item;
import com.wandrell.tabletop.business.model.pendragon.inventory.Money;
import com.wandrell.tabletop.business.model.pendragon.manor.Pet;
import com.wandrell.tabletop.business.model.pendragon.stats.Skill;
import com.wandrell.tabletop.business.model.pendragon.stats.SpecialtySkill;
import com.wandrell.tabletop.business.model.valuebox.DefaultEditableValueBox;
import com.wandrell.tabletop.business.model.valuebox.EditableValueBox;
import com.wandrell.tabletop.business.model.valuebox.SkillBox;

public final class DefaultPendragonPlayerCharacter implements
        PendragonPlayerCharacter {

    private final EditableValueBox               armor;
    private final String                         culture;
    private final Collection<Skill>              exclusiveSkills = new LinkedHashSet<>();
    private final String                         fatherClass;
    private final Collection<DistinctiveFeature> features        = new LinkedHashSet<>();
    private final Collection<Follower>           followers       = new LinkedHashSet<>();
    private final GloryManager                   glory;
    private final Collection<Item>               holdingsAtHome  = new LinkedHashSet<>();
    private final Collection<Item>               holdingsCarried = new LinkedHashSet<>();
    private final String                         homeland;
    private final Collection<Horse>              horses          = new LinkedHashSet<>();
    private final PendragonHumanCharacter        humanCharacter;
    private final Boolean                        knight;
    private final Money                          money;
    private final Collection<Pet>                pets            = new LinkedHashSet<>();
    private final String                         playerName;
    private final String                         religion;
    private final Collection<Wife>               wives           = new LinkedHashSet<>();

    public DefaultPendragonPlayerCharacter(
            final DefaultPendragonPlayerCharacter character) {
        super();

        checkNotNull(character, "Received a null pointer as character");

        humanCharacter = character.humanCharacter.createNewInstance();

        playerName = character.playerName;
        knight = character.knight;
        homeland = character.homeland;
        fatherClass = character.fatherClass;
        culture = character.culture;

        // TODO: Copy correctly
        followers.addAll(character.followers);
        horses.addAll(character.horses);
        pets.addAll(character.pets);

        for (final DistinctiveFeature feature : character.features) {
            features.add(feature);
        }

        for (final Skill skill : character.exclusiveSkills) {
            exclusiveSkills.add(skill);
        }

        // TODO: Copy correctly
        holdingsAtHome.addAll(character.holdingsAtHome);
        holdingsCarried.addAll(character.holdingsCarried);
        wives.addAll(character.wives);
        followers.addAll(character.followers);
        horses.addAll(character.horses);

        // Initializes data holders
        armor = character.getArmorValueBox().createNewInstance();
        glory = character.glory;
        money = character.money.createNewInstance();

        religion = character.religion;

        // TODO: Handle this
        // getGloryData().setReligiousAnnualGlorySwitch(
        // getTraitsBonusSwitchsData().getBonusSwitch(
        // PendragonLabels.BONUS_TRAITS_RELIGIOUS_SWITCH));
    }

    public DefaultPendragonPlayerCharacter(final String name,
            final DerivedAttributeBuilder derivedAttributeBuilder,
            final String player, final String religion, final String culture,
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
                derivedAttributeBuilder);

        playerName = player;

        this.religion = religion;
        this.culture = culture;
        this.fatherClass = fatherClass;
        this.homeland = homeland;

        this.knight = knight;

        // Initializes data holders
        this.glory = glory;
        this.money = money;
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
    public final void addExclusiveSkill(final Skill skill) {
        checkNotNull(skill, "Received a null pointer as skill");

        getExclusiveSkillsModifiable().add(skill);
    }

    @Override
    public final void addFollower(final Follower follower) {
        checkNotNull(follower, "Received a null pointer as follower");

        getFollowersModifiable().add(follower);
    }

    @Override
    public final void addHoldingAtHome(final Item item) {
        checkNotNull(item, "Received a null pointer as item");

        getHoldingsAtHomeModifiable().add(item);
    }

    @Override
    public final void addHoldingCarried(final Item item) {
        checkNotNull(item, "Received a null pointer as item");

        getHoldingsCarriedModifiable().add(item);
    }

    @Override
    public final void addHorse(final Horse horse) {
        checkNotNull(horse, "Received a null pointer as horse");

        getHorsesModifiable().add(horse);
    }

    @Override
    public final void addPassion(final SkillBox passion) {
        checkNotNull(passion, "Received a null pointer as passion");

        getBaseCharacter().addPassion(passion);
    }

    @Override
    public final void addPet(final Pet pet) {
        checkNotNull(pet, "Received a null pointer as pet");

        getPetsModifiable().add(pet);
    }

    @Override
    public final void addSkill(Skill skill) {
        checkNotNull(skill, "Received a null pointer as skill");

        getBaseCharacter().addSkill(skill);
    }

    @Override
    public final void addSpecialtySkill(final SpecialtySkill skill) {
        checkNotNull(skill, "Received a null pointer as specialty skill");

        getBaseCharacter().addSpecialtySkill(skill);
    }

    @Override
    public final void addWife(final Wife wife) {
        checkNotNull(wife, "Received a null pointer as wife");

        getWivesModifiable().add(wife);
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
    public final void clearExclusiveSkills() {
        getExclusiveSkillsModifiable().clear();
    }

    @Override
    public final void clearFollowers() {
        getFollowersModifiable().clear();
    }

    @Override
    public final void clearHoldingsAtHome() {
        getHoldingsAtHomeModifiable().clear();
    }

    @Override
    public final void clearHoldingsCarried() {
        getHoldingsCarriedModifiable().clear();
    }

    @Override
    public final void clearHorses() {
        getHorsesModifiable().clear();
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
    public final void clearWives() {
        getWivesModifiable().clear();
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
    public final Integer getArmor() {
        return getArmorValueBox().getValue();
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
        return culture;
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
    public final Collection<Skill> getExclusiveSkills() {
        return Collections
                .unmodifiableCollection(getExclusiveSkillsModifiable());
    }

    @Override
    public final String getFatherClass() {
        return fatherClass;
    }

    @Override
    public final Collection<Follower> getFollowers() {
        return Collections.unmodifiableCollection(getFollowersModifiable());
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
    public final GloryManager getGlory() {
        return glory;
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
    public final Collection<Item> getHoldingsAtHome() {
        return Collections
                .unmodifiableCollection(getHoldingsAtHomeModifiable());
    }

    @Override
    public final Collection<Item> getHoldingsCarried() {
        return Collections
                .unmodifiableCollection(getHoldingsCarriedModifiable());
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
    public final Collection<Horse> getHorses() {
        return Collections.unmodifiableCollection(getHorsesModifiable());
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
    public final Money getMoney() {
        return money;
    }

    @Override
    public final Integer getMovementRate() {
        return getBaseCharacter().getMovementRate();
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
    public final String getReligion() {
        return religion;
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
    public final Collection<Skill> getSkills() {
        return getBaseCharacter().getSkills();
    }

    @Override
    public final Collection<SpecialtySkill> getSpecialtySkills() {
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
    public final Integer getUnconsciousTreshold() {
        return getBaseCharacter().getUnconsciousTreshold();
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
    public final Collection<Wife> getWives() {
        return Collections.unmodifiableCollection(getWivesModifiable());
    }

    @Override
    public final Integer getWorldly() {
        return getBaseCharacter().getWorldly();
    }

    @Override
    public final Boolean isKnight() {
        return knight;
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
    public final void removeExclusiveSkill(final Skill skill) {
        getExclusiveSkillsModifiable().remove(skill);
    }

    @Override
    public final void removeFollower(final Follower follower) {
        getFollowersModifiable().remove(follower);
    }

    @Override
    public final void removeHoldingAtHome(final Item item) {
        getHoldingsAtHomeModifiable().remove(item);
    }

    @Override
    public final void removeHoldingCarried(final Item item) {
        getHoldingsCarriedModifiable().remove(item);
    }

    @Override
    public final void removeHorse(final Horse horse) {
        getHorsesModifiable().remove(horse);
    }

    @Override
    public final void removePassion(final SkillBox passion) {
        getBaseCharacter().removePassion(passion);
    }

    @Override
    public final void removePet(final Pet pet) {
        getPetsModifiable().remove(pet);
    }

    @Override
    public final void removeSkill(final Skill skill) {
        getBaseCharacter().removeSkill(skill);
    }

    @Override
    public final void removeSpecialtySkill(final SpecialtySkill skill) {
        getBaseCharacter().removeSpecialtySkill(skill);
    }

    @Override
    public final void removeWife(final Wife wife) {
        getWivesModifiable().remove(wife);
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
    public final void setExclusiveSkills(final Collection<Skill> skills) {
        getExclusiveSkillsModifiable().clear();
        for (final Skill skill : skills) {
            addExclusiveSkill(skill);
        }
    }

    @Override
    public final void setFollowers(final Collection<Follower> followers) {
        getFollowersModifiable().clear();
        for (final Follower follower : followers) {
            addFollower(follower);
        }
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
    public final void setHoldingsAtHome(final Collection<Item> items) {
        getHoldingsAtHomeModifiable().clear();
        for (final Item item : items) {
            addHoldingAtHome(item);
        }
    }

    @Override
    public final void setHoldingsCarried(final Collection<Item> items) {
        getHoldingsCarriedModifiable().clear();
        for (final Item item : items) {
            addHoldingCarried(item);
        }
    }

    @Override
    public final void setHonest(final Integer honest) {
        getBaseCharacter().setHonest(honest);
    }

    @Override
    public final void setHorses(final Collection<Horse> horses) {
        getHorsesModifiable().clear();
        for (final Horse horse : horses) {
            getHorsesModifiable().add(horse);
        }
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
    public final void setSelfish(final Integer selfish) {
        getBaseCharacter().setSelfish(selfish);
    }

    @Override
    public final void setSize(final Integer size) {
        getBaseCharacter().setSize(size);
    }

    @Override
    public final void setSkills(final Collection<Skill> skills) {
        getBaseCharacter().setSkills(skills);
    }

    @Override
    public final void
            setSpecialtySkills(final Collection<SpecialtySkill> skills) {
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
    public final void setWives(final Collection<Wife> wives) {
        getWivesModifiable().clear();
        for (final Wife wife : wives) {
            addWife(wife);
        }
    }

    private final EditableValueBox getArmorValueBox() {
        return armor;
    }

    private final PendragonHumanCharacter getBaseCharacter() {
        return humanCharacter;
    }

    private final Collection<Skill> getExclusiveSkillsModifiable() {
        return exclusiveSkills;
    }

    private final Collection<DistinctiveFeature> getFeaturesModifiable() {
        return features;
    }

    private final Collection<Follower> getFollowersModifiable() {
        return followers;
    }

    private final Collection<Item> getHoldingsAtHomeModifiable() {
        return holdingsAtHome;
    }

    private final Collection<Item> getHoldingsCarriedModifiable() {
        return holdingsCarried;
    }

    private final Collection<Horse> getHorsesModifiable() {
        return horses;
    }

    private final Collection<Pet> getPetsModifiable() {
        return pets;
    }

    private final Collection<Wife> getWivesModifiable() {
        return wives;
    }

}
