package com.wandrell.tabletop.pendragon.model.character;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import javax.swing.event.EventListenerList;

import com.wandrell.tabletop.character.Gender;
import com.wandrell.tabletop.event.ValueChangeEvent;
import com.wandrell.tabletop.event.ValueChangeListener;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonCharacterListener;
import com.wandrell.tabletop.pendragon.model.stats.PendragonSkillBox;
import com.wandrell.tabletop.pendragon.model.stats.SpecialtySkillBox;
import com.wandrell.tabletop.valuebox.DefaultEditableValueBox;
import com.wandrell.tabletop.valuebox.EditableValueBox;
import com.wandrell.tabletop.valuebox.SkillBox;

public final class DefaultPendragonHumanCharacter implements
        PendragonHumanCharacter {

    private final EditableValueBox              appearance;
    private final EditableValueBox              arbitrary;
    private final PendragonBaseCharacter        baseCharacter;
    private final EditableValueBox              chaste;
    private final EditableValueBox              cowardly;
    private final EditableValueBox              cruel;
    private final EditableValueBox              deceitful;
    private final Collection<SkillBox>          directedTraits  = new LinkedHashSet<SkillBox>();
    private final EditableValueBox              energetic;
    private final EditableValueBox              forgiving;
    private Gender                              gender;
    private final EditableValueBox              generous;
    private final EditableValueBox              honest;
    private final EditableValueBox              indulgent;
    private final EditableValueBox              just;
    private final EditableValueBox              lazy;
    private final EventListenerList             listeners       = new EventListenerList();
    private final EditableValueBox              lustful;
    private final EditableValueBox              merciful;
    private final EditableValueBox              modest;
    private final Collection<SkillBox>          passions        = new LinkedHashSet<SkillBox>();
    private final EditableValueBox              pious;
    private final EditableValueBox              proud;
    private final EditableValueBox              prudent;
    private final EditableValueBox              reckless;
    private final EditableValueBox              selfish;
    private final Collection<PendragonSkillBox> skills          = new LinkedHashSet<PendragonSkillBox>();
    private final Collection<SpecialtySkillBox> skillsSpecialty = new LinkedHashSet<SpecialtySkillBox>();
    private final EditableValueBox              suspicious;
    private final EditableValueBox              temperate;
    private final EditableValueBox              trusting;
    private final EditableValueBox              valorous;
    private final EditableValueBox              vengeful;
    private final EditableValueBox              worldly;

    public DefaultPendragonHumanCharacter(
            final DefaultPendragonHumanCharacter character) {
        super();

        checkNotNull(character, "Received a null pointer as character");

        baseCharacter = character.baseCharacter.createNewInstance();

        appearance = character.appearance.createNewInstance();

        appearance.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireAppearanceChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });

        chaste = character.chaste.createNewInstance();
        energetic = character.energetic.createNewInstance();
        forgiving = character.forgiving.createNewInstance();
        generous = character.generous.createNewInstance();
        honest = character.honest.createNewInstance();
        just = character.just.createNewInstance();
        merciful = character.merciful.createNewInstance();
        modest = character.modest.createNewInstance();
        pious = character.pious.createNewInstance();
        prudent = character.prudent.createNewInstance();
        temperate = character.temperate.createNewInstance();
        trusting = character.trusting.createNewInstance();
        valorous = character.valorous.createNewInstance();

        this.arbitrary = character.arbitrary.createNewInstance();
        this.cowardly = character.cowardly.createNewInstance();
        this.cruel = character.cruel.createNewInstance();
        this.deceitful = character.deceitful.createNewInstance();
        this.indulgent = character.indulgent.createNewInstance();
        this.lazy = character.lazy.createNewInstance();
        this.lustful = character.lustful.createNewInstance();
        this.proud = character.proud.createNewInstance();
        this.reckless = character.reckless.createNewInstance();
        this.selfish = character.selfish.createNewInstance();
        this.suspicious = character.suspicious.createNewInstance();
        this.vengeful = character.vengeful.createNewInstance();
        this.worldly = character.worldly.createNewInstance();

        for (final SpecialtySkillBox skill : character.skillsSpecialty) {
            // TODO: Make sure this works
            skillsSpecialty.add(skill.createNewInstance());
        }

        for (final SkillBox trait : character.directedTraits) {
            directedTraits.add(trait.createNewInstance());
        }

        for (final SkillBox passion : character.passions) {
            passions.add(passion.createNewInstance());
        }

        for (final PendragonSkillBox skill : character.skills) {
            skills.add(skill.createNewInstance());
        }

        gender = character.gender;
    }

    public DefaultPendragonHumanCharacter(final String name,
            final DerivedAttributeBuilder derivedAttributeBuilder) {
        super();

        this.baseCharacter = new DefaultPendragonBaseCharacter(name,
                derivedAttributeBuilder);

        this.appearance = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);

        appearance.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireAppearanceChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });

        this.chaste = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.energetic = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.forgiving = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.generous = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.honest = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.just = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.merciful = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.modest = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.pious = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.prudent = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.temperate = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.trusting = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.valorous = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);

        this.arbitrary = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.cowardly = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.cruel = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.deceitful = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.indulgent = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.lazy = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.lustful = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.proud = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.reckless = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.selfish = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.suspicious = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.vengeful = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.worldly = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
    }

    @Override
    public final void addDirectedTrait(final SkillBox trait) {
        checkNotNull(trait, "Received a null pointer as trait");

        getDirectedTraitsModifiable().add(trait);
    }

    @Override
    public final void addPassion(final SkillBox passion) {
        checkNotNull(passion, "Received a null pointer as passion");

        getPassionsModifiable().add(passion);
    }

    @Override
    public final void addPendragonCharacterListener(
            final PendragonCharacterListener listener) {
        checkNotNull(listener, "Received a null pointer as listener");

        getListeners().add(PendragonCharacterListener.class, listener);

        getBaseCharacter().addPendragonCharacterListener(listener);
    }

    @Override
    public final void addSkill(final PendragonSkillBox skill) {
        checkNotNull(skill, "Received a null pointer as skill");

        getSkillsModifiable().add(skill);
        registerIntoSpecialtySkill(skill);
    }

    @Override
    public final void addSpecialtySkill(final SpecialtySkillBox skill) {
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
    public final Integer getAppearance() {
        return appearance.getValue();
    }

    @Override
    public final Integer getArbitrary() {
        return arbitrary.getValue();
    }

    @Override
    public final Integer getChaste() {
        return chaste.getValue();
    }

    @Override
    public final Integer getConstitution() {
        return getBaseCharacter().getConstitution();
    }

    @Override
    public final Integer getCowardly() {
        return cowardly.getValue();
    }

    @Override
    public final Integer getCruel() {
        return cruel.getValue();
    }

    @Override
    public final Integer getDamage() {
        return getBaseCharacter().getDamage();
    }

    @Override
    public final Integer getDeceitful() {
        return deceitful.getValue();
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
        return Collections
                .unmodifiableCollection(getDirectedTraitsModifiable());
    }

    @Override
    public final Integer getEnergetic() {
        return energetic.getValue();
    }

    @Override
    public final Integer getForgiving() {
        return forgiving.getValue();
    }

    @Override
    public final Gender getGender() {
        return gender;
    }

    @Override
    public final Integer getGenerous() {
        return generous.getValue();
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
    public final Integer getHonest() {
        return honest.getValue();
    }

    @Override
    public final Integer getIndulgent() {
        return indulgent.getValue();
    }

    @Override
    public final Integer getJust() {
        return just.getValue();
    }

    @Override
    public final Integer getLazy() {
        return lazy.getValue();
    }

    @Override
    public final Integer getLustful() {
        return lustful.getValue();
    }

    @Override
    public final Integer getMajorWoundTreshold() {
        return getBaseCharacter().getMajorWoundTreshold();
    }

    @Override
    public final Integer getMerciful() {
        return merciful.getValue();
    }

    @Override
    public final Integer getModest() {
        return modest.getValue();
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
        return Collections.unmodifiableCollection(getPassionsModifiable());
    }

    @Override
    public final Integer getPious() {
        return pious.getValue();
    }

    @Override
    public final Integer getProud() {
        return proud.getValue();
    }

    @Override
    public final Integer getPrudent() {
        return prudent.getValue();
    }

    @Override
    public final Integer getReckless() {
        return reckless.getValue();
    }

    @Override
    public final Integer getSelfish() {
        return selfish.getValue();
    }

    @Override
    public final Integer getSize() {
        return getBaseCharacter().getSize();
    }

    @Override
    public final Collection<PendragonSkillBox> getSkills() {
        return Collections.unmodifiableCollection(getSkillsModifiable());
    }

    @Override
    public final Collection<SpecialtySkillBox> getSpecialtySkills() {
        return Collections
                .unmodifiableCollection(getSpecialtySkillsModifiable());
    }

    @Override
    public final Integer getStrength() {
        return getBaseCharacter().getStrength();
    }

    @Override
    public final Integer getSuspicious() {
        return suspicious.getValue();
    }

    @Override
    public final Integer getTemperate() {
        return temperate.getValue();
    }

    @Override
    public final Integer getTrusting() {
        return trusting.getValue();
    }

    @Override
    public final Integer getUnconciousTreshold() {
        return getBaseCharacter().getUnconciousTreshold();
    }

    @Override
    public final Integer getValorous() {
        return valorous.getValue();
    }

    @Override
    public final Integer getVengeful() {
        return vengeful.getValue();
    }

    @Override
    public final Integer getWeight() {
        return getBaseCharacter().getWeight();
    }

    @Override
    public final Integer getWorldly() {
        return worldly.getValue();
    }

    @Override
    public final void removeDirectedTrait(final SkillBox directedTrait) {
        getDirectedTraitsModifiable().remove(directedTrait);
    }

    @Override
    public final void removePassion(final SkillBox passion) {
        getPassionsModifiable().remove(passion);
    }

    @Override
    public final void removePendragonCharacterListener(
            final PendragonCharacterListener listener) {
        checkNotNull(listener, "Received a null pointer as listener");

        getBaseCharacter().removePendragonCharacterListener(listener);
    }

    @Override
    public final void removeSkill(final PendragonSkillBox skill) {
        getSkillsModifiable().remove(skill);
    }

    @Override
    public final void removeSpecialtySkill(final SpecialtySkillBox skill) {
        getSpecialtySkillsModifiable().remove(skill);
    }

    @Override
    public final void setAppearance(final Integer appearance) {
        this.appearance.setValue(appearance);
    }

    @Override
    public final void setArbitrary(final Integer arbitrary) {
        this.arbitrary.setValue(arbitrary);
    }

    @Override
    public final void setChaste(final Integer chaste) {
        this.chaste.setValue(chaste);
    }

    @Override
    public final void setConstitution(final Integer constitution) {
        getBaseCharacter().setConstitution(constitution);
    }

    @Override
    public final void setCowardly(final Integer cowardly) {
        this.cowardly.setValue(cowardly);
    }

    @Override
    public final void setCruel(final Integer cruel) {
        this.cruel.setValue(cruel);
    }

    @Override
    public final void setDeceitful(final Integer deceitful) {
        this.deceitful.setValue(deceitful);
    }

    @Override
    public final void setDexterity(final Integer dexterity) {
        getBaseCharacter().setDexterity(dexterity);
    }

    @Override
    public final void setDirectedTraits(final Collection<SkillBox> traits) {
        getDirectedTraitsModifiable().clear();
        for (final SkillBox trait : traits) {
            addDirectedTrait(trait);
        }
    }

    @Override
    public final void setEnergetic(final Integer energetic) {
        this.energetic.setValue(energetic);
    }

    @Override
    public final void setForgiving(final Integer forgiving) {
        this.forgiving.setValue(forgiving);
    }

    public final void setGender(final Gender gender) {
        this.gender = gender;
    }

    @Override
    public final void setGenerous(final Integer generous) {
        this.generous.setValue(generous);
    }

    @Override
    public final void setHonest(final Integer honest) {
        this.honest.setValue(honest);
    }

    @Override
    public final void setIndulgent(final Integer indulgent) {
        this.indulgent.setValue(indulgent);
    }

    @Override
    public final void setJust(final Integer just) {
        this.just.setValue(just);
    }

    @Override
    public final void setLazy(final Integer lazy) {
        this.lazy.setValue(lazy);
    }

    @Override
    public final void setLustful(final Integer lustful) {
        this.lustful.setValue(lustful);
    }

    @Override
    public final void setMerciful(final Integer merciful) {
        this.merciful.setValue(merciful);
    }

    @Override
    public final void setModest(final Integer modest) {
        this.modest.setValue(modest);
    }

    @Override
    public final void setPassions(final Collection<SkillBox> passions) {
        checkNotNull(passions, "Received a null pointer as passions");

        getPassionsModifiable().clear();
        for (final SkillBox passion : passions) {
            addPassion(passion);
        }
    }

    @Override
    public final void setPious(final Integer pious) {
        this.pious.setValue(pious);
    }

    @Override
    public final void setProud(final Integer proud) {
        this.proud.setValue(proud);
    }

    @Override
    public final void setPrudent(final Integer prudent) {
        this.prudent.setValue(prudent);
    }

    @Override
    public final void setReckless(final Integer reckless) {
        this.reckless.setValue(reckless);
    }

    @Override
    public final void setSelfish(final Integer selfish) {
        this.selfish.setValue(selfish);
    }

    @Override
    public final void setSize(final Integer size) {
        getBaseCharacter().setSize(size);
    }

    @Override
    public final void setSkills(final Collection<PendragonSkillBox> skills) {
        checkNotNull(skills, "Received a null pointer as skills");

        getSkillsModifiable().clear();

        for (final PendragonSkillBox skill : skills) {
            getSkillsModifiable().add(skill);
        }
    }

    @Override
    public final void setSpecialtySkills(
            final Collection<SpecialtySkillBox> skills) {
        checkNotNull(skills, "Received a null pointer as specialty skills");

        getSpecialtySkillsModifiable().clear();
        for (final SpecialtySkillBox skill : skills) {
            addSpecialtySkill(skill);
        }
    }

    @Override
    public final void setStrength(final Integer strength) {
        getBaseCharacter().setStrength(strength);
    }

    @Override
    public final void setSuspicious(final Integer suspicious) {
        this.suspicious.setValue(suspicious);
    }

    @Override
    public final void setTemperate(final Integer temperate) {
        this.temperate.setValue(temperate);
    }

    @Override
    public final void setTrusting(final Integer trusting) {
        this.trusting.setValue(trusting);
    }

    @Override
    public final void setValorous(final Integer valorous) {
        this.valorous.setValue(valorous);
    }

    private final void
            assembleSpecialtySkill(final SpecialtySkillBox vhAdvSkill) {
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

    private final Collection<SkillBox> getDirectedTraitsModifiable() {
        return directedTraits;
    }

    private final Collection<SkillBox> getPassionsModifiable() {
        return passions;
    }

    private final Collection<PendragonSkillBox> getSkillsModifiable() {
        return skills;
    }

    private final Collection<SpecialtySkillBox> getSpecialtySkillsModifiable() {
        return skillsSpecialty;
    }

    private final void registerIntoSpecialtySkill(
            final PendragonSkillBox vhSkill) {
        // for (final SpecialtySkill skill : getSpecialtySkills()) {
        // TODO: Do somehow
        // if (skill.isSkillContained(vhSkill.getName())) {
        // skill.registerSkill(vhSkill);
        // }
        // }
    }

    protected final void
            fireAppearanceChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.appearanceChanged(event);
        }
    }

    protected final EventListenerList getListeners() {
        return listeners;
    }

}
