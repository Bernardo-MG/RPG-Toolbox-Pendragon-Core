package com.wandrell.tabletop.pendragon.model.character;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.character.Gender;
import com.wandrell.tabletop.pendragon.model.character.background.BackgroundInfo;
import com.wandrell.tabletop.pendragon.model.character.background.DefaultBackgroundInfo;
import com.wandrell.tabletop.pendragon.model.character.event.CharacterEchoAttributesListener;
import com.wandrell.tabletop.pendragon.model.character.event.CharacterEchoDerivedAttributesListener;
import com.wandrell.tabletop.pendragon.model.character.event.CharacterEchoTraitsListener;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonCharacterListener;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonEventThrower;
import com.wandrell.tabletop.pendragon.model.character.stats.AttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.DefaultAttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.DefaultSkillsHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.DefaultTraitsHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.DerivedAttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.GeneratedDerivedAttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.SkillsHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.TraitsHolder;
import com.wandrell.tabletop.stats.valuebox.DefaultValueBox;
import com.wandrell.tabletop.stats.valuebox.ValueBox;

public final class DefaultPendragonCharacter implements PendragonCharacter {

    private final AttributesHolder               attributes;
    private final BackgroundInfo                 background;
    private final DerivedAttributesHolder        derived;
    private final DerivedAttributeBuilder        derivedBuilder;
    private final PendragonEventThrower          eventThrower = new PendragonEventThrower();
    private final Collection<DistinctiveFeature> features     = new LinkedHashSet<DistinctiveFeature>();
    private Gender                               gender;
    private final ValueBox                       glory;
    private final String                         name;
    private final SkillsHolder                   skills;
    private final TraitsHolder                   traits;

    public DefaultPendragonCharacter(final DefaultPendragonCharacter character) {
        super();

        checkNotNull(character, "Received a null pointer as character");

        name = character.name;

        attributes = character.attributes.createNewInstance();

        setAttributesListeners();

        derivedBuilder = character.derivedBuilder;

        derived = new GeneratedDerivedAttributesHolder(attributes,
                derivedBuilder);
        setDerivedAttributesListener();

        background = character.background.createNewInstance();

        traits = character.traits.createNewInstance();

        setTraitsListeners();

        glory = new DefaultValueBox(character.glory.getValue());

        skills = character.skills.createNewInstance();
    }

    public DefaultPendragonCharacter(final String name,
            final AttributesHolder attributes,
            final DerivedAttributeBuilder derivedAttributeBuilder) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(derivedAttributeBuilder,
                "Received a null pointer as derived attributes builder");

        this.name = name;

        this.attributes = attributes;

        setAttributesListeners();

        derivedBuilder = derivedAttributeBuilder;

        derived = new GeneratedDerivedAttributesHolder(attributes,
                derivedAttributeBuilder);
        setDerivedAttributesListener();

        background = new DefaultBackgroundInfo();

        traits = new DefaultTraitsHolder();

        setTraitsListeners();

        glory = new DefaultValueBox();

        skills = new DefaultSkillsHolder();
    }

    public DefaultPendragonCharacter(final String name,
            final DerivedAttributeBuilder derivedAttributeBuilder) {
        this(name, new DefaultAttributesHolder(), derivedAttributeBuilder);
    }

    @Override
    public final void addDistinctiveFeature(final DistinctiveFeature feature) {
        checkNotNull(feature, "Received a null pointer as feature");

        getFeaturesModifiable().add(feature);
    }

    @Override
    public final void addPendragonCharacterListener(
            final PendragonCharacterListener listener) {
        getEventThrower().addPendragonCharacterListener(listener);
    }

    @Override
    public final void clearDistinctiveFeatures() {
        getFeaturesModifiable().clear();
    }

    @Override
    public final DefaultPendragonCharacter createNewInstance() {
        return new DefaultPendragonCharacter(this);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultPendragonCharacter other = (DefaultPendragonCharacter) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public final AttributesHolder getAttributes() {
        return attributes;
    }

    @Override
    public final BackgroundInfo getBackgroundInfo() {
        return background;
    }

    @Override
    public final DerivedAttributesHolder getDerivedAttributes() {
        return derived;
    }

    @Override
    public final Collection<DistinctiveFeature> getDistinctiveFeatures() {
        return Collections.unmodifiableCollection(getFeaturesModifiable());
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
    public final String getName() {
        return name;
    }

    @Override
    public final SkillsHolder getSkills() {
        return skills;
    }

    @Override
    public final TraitsHolder getTraits() {
        return traits;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final void
            removeDistinctiveFeature(final DistinctiveFeature feature) {
        getFeaturesModifiable().remove(feature);
    }

    @Override
    public final void removePendragonCharacterListener(
            final PendragonCharacterListener listener) {
        getEventThrower().removePendragonCharacterListener(listener);
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
    public final void setGlory(final Integer glory) {
        this.glory.setValue(glory);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

    private final PendragonEventThrower getEventThrower() {
        return eventThrower;
    }

    private final Collection<DistinctiveFeature> getFeaturesModifiable() {
        return features;
    }

    private final void setAttributesListeners() {
        getAttributes().addAttributesListener(
                new CharacterEchoAttributesListener(this, getEventThrower()));
    }

    private final void setDerivedAttributesListener() {
        getDerivedAttributes().addDerivedAttributesListener(
                new CharacterEchoDerivedAttributesListener(this,
                        getEventThrower()));
    }

    private final void setTraitsListeners() {
        getTraits().addTraitsListener(
                new CharacterEchoTraitsListener(this, getEventThrower()));
    }

}
