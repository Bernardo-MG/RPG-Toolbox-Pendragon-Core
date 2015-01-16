package com.wandrell.tabletop.business.model.pendragon.character;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import com.wandrell.tabletop.business.model.character.Gender;
import com.wandrell.tabletop.business.model.pendragon.stats.Attribute;
import com.wandrell.tabletop.business.model.pendragon.stats.DirectedTrait;
import com.wandrell.tabletop.business.model.pendragon.stats.Passion;
import com.wandrell.tabletop.business.model.pendragon.stats.Skill;
import com.wandrell.tabletop.business.model.pendragon.stats.SpecialtySkill;
import com.wandrell.tabletop.business.model.pendragon.stats.Trait;

public final class DefaultPendragonHumanCharacter implements
        PendragonHumanCharacter {

    private final Attribute                  appearance;
    private final PendragonBaseCharacter     baseCharacter;
    private final Trait                      chaste;
    private final Collection<DirectedTrait>  directedTraits  = new LinkedHashSet<>();
    private final Trait                      energetic;
    private final Trait                      forgiving;
    private Gender                           gender;
    private final Trait                      generous;
    private final Trait                      honest;
    private final Trait                      just;
    private final Trait                      merciful;
    private final Trait                      modest;
    private final Collection<Passion>        passions        = new LinkedHashSet<>();
    private final Trait                      pious;
    private final Trait                      prudent;
    private final Collection<Skill>          skills          = new LinkedHashSet<>();
    private final Collection<SpecialtySkill> skillsSpecialty = new LinkedHashSet<>();
    private final Trait                      temperate;
    private final Trait                      trusting;
    private final Trait                      valorous;

    public DefaultPendragonHumanCharacter(
            final DefaultPendragonHumanCharacter character) {
        super();

        checkNotNull(character, "Received a null pointer as character");

        baseCharacter = character.baseCharacter.createNewInstance();

        appearance = character.appearance;

        // TODO: Correctly initialize traits
        chaste = character.chaste;
        energetic = character.energetic;
        forgiving = character.forgiving;
        generous = character.generous;
        honest = character.honest;
        just = character.just;
        merciful = character.merciful;
        modest = character.modest;
        pious = character.pious;
        prudent = character.prudent;
        temperate = character.temperate;
        trusting = character.trusting;
        valorous = character.valorous;

        for (final SpecialtySkill skill : character.skillsSpecialty) {
            // TODO: Make sure this works
            skillsSpecialty.add(skill.createNewInstance());
        }

        for (final DirectedTrait trait : character.directedTraits) {
            directedTraits.add(trait.createNewInstance());
        }

        for (final Passion passion : character.passions) {
            passions.add(passion.createNewInstance());
        }

        for (final Skill skill : character.skills) {
            skills.add(skill.createNewInstance());
        }

        gender = character.gender;
    }

    public DefaultPendragonHumanCharacter(
            final PendragonBaseCharacter baseCharacter,
            final Attribute appearance, final Trait chaste,
            final Trait energetic, final Trait forgiving, final Trait generous,
            final Trait honest, final Trait just, final Trait merciful,
            final Trait modest, final Trait pious, final Trait prudent,
            final Trait temperate, final Trait trusting, final Trait valorous) {
        super();

        checkNotNull(baseCharacter, "Received a null pointer as base character");
        checkNotNull(appearance, "Received a null pointer as appearance");
        checkNotNull(chaste, "Received a null pointer as chaste");
        checkNotNull(energetic, "Received a null pointer as energetic");
        checkNotNull(forgiving, "Received a null pointer as forgiving");
        checkNotNull(generous, "Received a null pointer as generous");
        checkNotNull(honest, "Received a null pointer as honest");
        checkNotNull(just, "Received a null pointer as just");
        checkNotNull(merciful, "Received a null pointer as merciful");
        checkNotNull(modest, "Received a null pointer as modest");
        checkNotNull(pious, "Received a null pointer as pious");
        checkNotNull(prudent, "Received a null pointer as prudent");
        checkNotNull(temperate, "Received a null pointer as temperate");
        checkNotNull(trusting, "Received a null pointer as trusting");
        checkNotNull(valorous, "Received a null pointer as valorous");

        this.baseCharacter = baseCharacter;

        this.appearance = appearance;

        this.chaste = chaste;
        this.energetic = energetic;
        this.forgiving = forgiving;
        this.generous = generous;
        this.honest = honest;
        this.just = just;
        this.merciful = merciful;
        this.modest = modest;
        this.pious = pious;
        this.prudent = prudent;
        this.temperate = temperate;
        this.trusting = trusting;
        this.valorous = valorous;
    }

    @Override
    public final void addDirectedTrait(final DirectedTrait trait) {
        checkNotNull(trait, "Received a null pointer as trait");

        getDirectedTraitsModifiable().add(trait);
    }

    @Override
    public final void addPassion(final Passion passion) {
        checkNotNull(passion, "Received a null pointer as passion");

        getPassionsModifiable().add(passion);
    }

    @Override
    public final void addSkill(final Skill skill) {
        checkNotNull(skill, "Received a null pointer as skill");

        getSkillsModifiable().add(skill);
        registerIntoSpecialtySkill(skill);
    }

    @Override
    public final void addSpecialtySkill(final SpecialtySkill skill) {
        checkNotNull(skill, "Received a null pointer as specialty skill");

        getSpecialtySkillsModifiable().add(skill);
        assembleSpecialtySkill(skill);
    }

    @Override
    public final void clearDirectedTraits() {
        getDirectedTraitsModifiable().clear();
    }

    @Override
    public final void clearPassions() {
        getPassionsModifiable().clear();
    }

    @Override
    public void clearSkills() {
        getSkillsModifiable().clear();
    }

    @Override
    public final void clearSpecialtySkills() {
        getSpecialtySkillsModifiable().clear();
    }

    @Override
    public final DefaultPendragonHumanCharacter createNewInstance() {
        return new DefaultPendragonHumanCharacter(this);
    }

    @Override
    public final Attribute getAppearance() {
        return appearance;
    }

    @Override
    public final Trait getArbitrary() {
        return getJust().getMirrorTrait();
    }

    @Override
    public final Trait getChaste() {
        return chaste;
    }

    @Override
    public final Integer getConstitution() {
        return getBaseCharacter().getConstitution();
    }

    @Override
    public final Trait getCowardly() {
        return getValorous().getMirrorTrait();
    }

    @Override
    public final Trait getCruel() {
        return getMerciful().getMirrorTrait();
    }

    @Override
    public final Integer getDamage() {
        return getBaseCharacter().getDamage();
    }

    @Override
    public final Trait getDeceitful() {
        return getHonest().getMirrorTrait();
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
    public final Collection<DirectedTrait> getDirectedTraits() {
        return Collections
                .unmodifiableCollection(getDirectedTraitsModifiable());
    }

    @Override
    public final Trait getEnergetic() {
        return energetic;
    }

    @Override
    public final Trait getForgiving() {
        return forgiving;
    }

    @Override
    public final Gender getGender() {
        return gender;
    }

    @Override
    public final Trait getGenerous() {
        return generous;
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
    public final Trait getHonest() {
        return honest;
    }

    @Override
    public final Trait getIndulgent() {
        return getTemperate().getMirrorTrait();
    }

    @Override
    public final Trait getJust() {
        return just;
    }

    @Override
    public final Trait getLazy() {
        return getEnergetic().getMirrorTrait();
    }

    @Override
    public final Trait getLustful() {
        return getChaste().getMirrorTrait();
    }

    @Override
    public final Integer getMajorWoundTreshold() {
        return getBaseCharacter().getMajorWoundTreshold();
    }

    @Override
    public final Trait getMerciful() {
        return merciful;
    }

    @Override
    public final Trait getModest() {
        return modest;
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
    public final Collection<Passion> getPassions() {
        return Collections.unmodifiableCollection(getPassionsModifiable());
    }

    @Override
    public final Trait getPious() {
        return pious;
    }

    @Override
    public final Trait getProud() {
        return getModest().getMirrorTrait();
    }

    @Override
    public final Trait getPrudent() {
        return prudent;
    }

    @Override
    public final Trait getReckless() {
        return getPrudent().getMirrorTrait();
    }

    @Override
    public final Trait getSelfish() {
        return getGenerous().getMirrorTrait();
    }

    @Override
    public final Integer getSize() {
        return getBaseCharacter().getSize();
    }

    @Override
    public final Collection<Skill> getSkills() {
        return Collections.unmodifiableCollection(getSkillsModifiable());
    }

    @Override
    public final Collection<SpecialtySkill> getSpecialtySkills() {
        return Collections
                .unmodifiableCollection(getSpecialtySkillsModifiable());
    }

    @Override
    public final Integer getStrength() {
        return getBaseCharacter().getStrength();
    }

    @Override
    public final Trait getSuspicious() {
        return getTrusting().getMirrorTrait();
    }

    @Override
    public final Trait getTemperate() {
        return temperate;
    }

    @Override
    public final Trait getTrusting() {
        return trusting;
    }

    @Override
    public final Integer getUnconsciousTreshold() {
        return getBaseCharacter().getUnconsciousTreshold();
    }

    @Override
    public final Trait getValorous() {
        return valorous;
    }

    @Override
    public final Trait getVengeful() {
        return getForgiving().getMirrorTrait();
    }

    @Override
    public final Integer getWeight() {
        return getBaseCharacter().getWeight();
    }

    @Override
    public final Trait getWordly() {
        return getPious().getMirrorTrait();
    }

    @Override
    public final void removeDirectedTrait(final DirectedTrait directedTrait) {
        getDirectedTraitsModifiable().remove(directedTrait);
    }

    @Override
    public final void removePassion(final Passion passion) {
        getPassionsModifiable().remove(passion);
    }

    @Override
    public final void removeSkill(final Skill skill) {
        getSkillsModifiable().remove(skill);
    }

    @Override
    public final void removeSpecialtySkill(final SpecialtySkill skill) {
        getSpecialtySkillsModifiable().remove(skill);
    }

    @Override
    public final void setDirectedTraits(final Collection<DirectedTrait> traits) {
        getDirectedTraitsModifiable().clear();
        for (final DirectedTrait trait : traits) {
            addDirectedTrait(trait);
        }
    }

    public final void setGender(final Gender gender) {
        this.gender = gender;
    }

    @Override
    public final void setPassions(final Collection<Passion> passions) {
        checkNotNull(passions, "Received a null pointer as passions");

        getPassionsModifiable().clear();
        for (final Passion passion : passions) {
            addPassion(passion);
        }
    }

    @Override
    public final void setSkills(final Collection<Skill> skills) {
        checkNotNull(skills, "Received a null pointer as skills");

        getSkillsModifiable().clear();

        for (final Skill skill : skills) {
            getSkillsModifiable().add(skill);
        }
    }

    @Override
    public final void
            setSpecialtySkills(final Collection<SpecialtySkill> skills) {
        checkNotNull(skills, "Received a null pointer as specialty skills");

        getSpecialtySkillsModifiable().clear();
        for (final SpecialtySkill skill : skills) {
            addSpecialtySkill(skill);
        }
    }

    private final void assembleSpecialtySkill(final SpecialtySkill vhAdvSkill) {
        // for (final String skill : vhAdvSkill.getSurrogatedSkills()) {
        // if (hasSkill(skill, "")) {
        // TODO: Do somehow
        // vhAdvSkill.registerSkill(getSkill(skill, ""));
        // }
        // }
    }

    private final PendragonBaseCharacter getBaseCharacter() {
        return baseCharacter;
    }

    private final Collection<DirectedTrait> getDirectedTraitsModifiable() {
        return directedTraits;
    }

    private final Collection<Passion> getPassionsModifiable() {
        return passions;
    }

    private final Collection<Skill> getSkillsModifiable() {
        return skills;
    }

    private final Collection<SpecialtySkill> getSpecialtySkillsModifiable() {
        return skillsSpecialty;
    }

    private final void registerIntoSpecialtySkill(final Skill vhSkill) {
        // for (final SpecialtySkill skill : getSpecialtySkills()) {
        // TODO: Do somehow
        // if (skill.isSkillContained(vhSkill.getName())) {
        // skill.registerSkill(vhSkill);
        // }
        // }
    }

}
