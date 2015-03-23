package com.wandrell.tabletop.pendragon.model.character;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import javax.swing.event.EventListenerList;

import com.wandrell.tabletop.character.Gender;
import com.wandrell.tabletop.event.ValueChangeEvent;
import com.wandrell.tabletop.event.ValueChangeListener;
import com.wandrell.tabletop.pendragon.model.character.background.Religion;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonCharacterListener;
import com.wandrell.tabletop.pendragon.model.character.stats.DefaultTraitsHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.PendragonSkillBox;
import com.wandrell.tabletop.pendragon.model.character.stats.SpecialtySkillBox;
import com.wandrell.tabletop.pendragon.model.character.stats.TraitsHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.event.TraitsListener;
import com.wandrell.tabletop.valuebox.DefaultEditableValueBox;
import com.wandrell.tabletop.valuebox.EditableValueBox;
import com.wandrell.tabletop.valuebox.SkillBox;

public final class DefaultPendragonHumanCharacter implements
        PendragonHumanCharacter {

    private final EditableValueBox               appearance;
    private final PendragonBaseCharacter         baseCharacter;
    private final String                         culture;
    private final Collection<SkillBox>           directedTraits  = new LinkedHashSet<SkillBox>();
    private final String                         fatherClass;
    private final Collection<DistinctiveFeature> features        = new LinkedHashSet<DistinctiveFeature>();
    private Gender                               gender;
    private final EditableValueBox               glory;
    private final String                         homeland;
    private Boolean                              knight          = false;
    private final EventListenerList              listeners       = new EventListenerList();
    private final Collection<SkillBox>           passions        = new LinkedHashSet<SkillBox>();
    private final String                         playerName;
    private Religion                             religion;
    private final Collection<SpecialtySkillBox>  skillsSpecialty = new LinkedHashSet<SpecialtySkillBox>();
    private final TraitsHolder                   traits;

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

        gender = character.gender;

        religion = character.religion;

        knight = character.knight;

        culture = character.culture;

        playerName = character.playerName;
        homeland = character.homeland;
        fatherClass = character.fatherClass;

        glory = character.glory.createNewInstance();

        traits = character.traits.createNewInstance();
        getTraits().addTraitsListener(new TraitsListener() {

            @Override
            public final void traitChanged(final ValueChangeEvent event) {
                fireTraitChangedEvent(event);
            }

        });

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

        for (final DistinctiveFeature feature : character.features) {
            features.add(feature);
        }
    }

    public DefaultPendragonHumanCharacter(final String name,
            final DerivedAttributeBuilder derivedAttributeBuilder,
            final String culture, final Religion religion,
            final String homeland, final String fatherClass, final String player) {
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

        this.culture = culture;
        this.religion = religion;
        playerName = player;

        this.fatherClass = fatherClass;
        this.homeland = homeland;

        glory = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);

        traits = new DefaultTraitsHolder();
        getTraits().addTraitsListener(new TraitsListener() {

            @Override
            public final void traitChanged(final ValueChangeEvent event) {
                fireTraitChangedEvent(event);
            }

        });
    }

    @Override
    public final void addDirectedTrait(final SkillBox trait) {
        checkNotNull(trait, "Received a null pointer as trait");

        getDirectedTraitsModifiable().add(trait);
    }

    @Override
    public final void addDistinctiveFeature(final DistinctiveFeature feature) {
        checkNotNull(feature, "Received a null pointer as feature");

        getFeaturesModifiable().add(feature);
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
        getBaseCharacter().addSkill(skill);
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
    public final void clearDistinctiveFeatures() {
        getFeaturesModifiable().clear();
    }

    @Override
    public final void clearPassions() {
        getPassionsModifiable().clear();
    }

    @Override
    public final void clearSkills() {
        getBaseCharacter().clearSkills();
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
    public final Integer getConstitution() {
        return getBaseCharacter().getConstitution();
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
    public final Collection<DistinctiveFeature> getDistinctiveFeatures() {
        return Collections.unmodifiableCollection(getFeaturesModifiable());
    }

    @Override
    public final String getFatherClass() {
        return fatherClass;
    }

    @Override
    public final Gender getGender() {
        return gender;
    }

    @Override
    public final Integer getGlory() {
        return glory.getValue();
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
    public final Integer getMajorWoundTreshold() {
        return getBaseCharacter().getMajorWoundTreshold();
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
    public final String getPlayerName() {
        return playerName;
    }

    @Override
    public final Religion getReligion() {
        return religion;
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
        return Collections
                .unmodifiableCollection(getSpecialtySkillsModifiable());
    }

    @Override
    public final Integer getStrength() {
        return getBaseCharacter().getStrength();
    }

    @Override
    public final TraitsHolder getTraits() {
        return traits;
    }

    @Override
    public final Integer getUnconciousTreshold() {
        return getBaseCharacter().getUnconciousTreshold();
    }

    @Override
    public final Integer getWeight() {
        return getBaseCharacter().getWeight();
    }

    @Override
    public final Boolean isKnight() {
        return knight;
    }

    @Override
    public final void removeDirectedTrait(final SkillBox directedTrait) {
        getDirectedTraitsModifiable().remove(directedTrait);
    }

    @Override
    public final void
            removeDistinctiveFeature(final DistinctiveFeature feature) {
        getFeaturesModifiable().remove(feature);
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
        getBaseCharacter().removeSkill(skill);
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
    public final void setConstitution(final Integer constitution) {
        getBaseCharacter().setConstitution(constitution);
    }

    @Override
    public final void setDexterity(final Integer dexterity) {
        getBaseCharacter().setDexterity(dexterity);
    }

    @Override
    public final void setDirectedTraits(final Collection<SkillBox> traits) {
        checkNotNull(traits, "Received a null pointer as directed traits");

        getDirectedTraitsModifiable().clear();
        for (final SkillBox trait : traits) {
            addDirectedTrait(trait);
        }
    }

    @Override
    public final void setDistinctiveFeatures(
            final Collection<DistinctiveFeature> features) {
        getFeaturesModifiable().clear();

        for (final DistinctiveFeature feature : features) {
            getFeaturesModifiable().add(feature);
        }
    }

    public final void setGender(final Gender gender) {
        checkNotNull(gender, "Received a null pointer as gender");

        this.gender = gender;
    }

    @Override
    public final void setGlory(final Integer glory) {
        this.glory.setValue(glory);
    }

    @Override
    public final void setKnight(final Boolean knight) {
        this.knight = knight;
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
    public final void setReligion(final Religion religion) {
        checkNotNull(religion, "Received a null pointer as religion");

        this.religion = religion;
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

    private final Collection<DistinctiveFeature> getFeaturesModifiable() {
        return features;
    }

    private final Collection<SkillBox> getPassionsModifiable() {
        return passions;
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

    protected final void fireTraitChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.traitChanged(event);
        }
    }

    protected final EventListenerList getListeners() {
        return listeners;
    }

}
