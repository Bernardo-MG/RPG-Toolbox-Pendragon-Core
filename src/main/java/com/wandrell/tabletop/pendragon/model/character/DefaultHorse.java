package com.wandrell.tabletop.pendragon.model.character;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.character.Gender;
import com.wandrell.tabletop.pendragon.model.character.background.BackgroundInfo;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonCharacterListener;
import com.wandrell.tabletop.pendragon.model.character.stats.AttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.DerivedAttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.HorseDerivedAttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.SkillsHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.TraitsHolder;

public final class DefaultHorse implements Horse {

    private Boolean                       armored;
    private final PendragonCharacter      baseCharacter;
    private Boolean                       combat;
    private final Integer                 damage;
    private final DerivedAttributesHolder derived;
    private Boolean                       hunting;
    private final Integer                 moveRate;
    private final Integer                 naturalArmor;
    private Boolean                       ruined;
    private final String                  type;

    public DefaultHorse(final DefaultHorse horse) {
        super();

        checkNotNull(horse, "Received a null pointer as horse");

        baseCharacter = horse.baseCharacter.createNewInstance();

        type = horse.type;

        naturalArmor = horse.naturalArmor;
        damage = horse.damage;
        moveRate = horse.moveRate;
        this.derived = new HorseDerivedAttributesHolder(baseCharacter, damage,
                moveRate);

        combat = horse.combat;
        hunting = horse.hunting;
        armored = horse.armored;
    }

    public DefaultHorse(final String name,
            final DerivedAttributeBuilder derivedAttributeBuilder,
            final String type, final Integer naturalArmor,
            final Integer damage, final Integer moveRate, final Boolean combat,
            final Boolean hunting, final Boolean armored) {
        super();

        checkNotNull(type, "Received a null pointer as type");
        checkNotNull(naturalArmor, "Received a null pointer as natural armor");
        checkNotNull(damage, "Received a null pointer as damage");
        checkNotNull(moveRate, "Received a null pointer as move rate");
        checkNotNull(combat, "Received a null pointer as combat flag");
        checkNotNull(hunting, "Received a null pointer as hunting flag");
        checkNotNull(armored, "Received a null pointer as armored flag");

        baseCharacter = new DefaultPendragonCharacter(name,
                derivedAttributeBuilder);

        this.type = type;

        // TODO: These should be editable
        this.naturalArmor = naturalArmor;
        this.damage = damage;
        this.moveRate = moveRate;
        this.derived = new HorseDerivedAttributesHolder(baseCharacter, damage,
                moveRate);

        this.combat = combat;
        this.hunting = hunting;
        this.armored = armored;
    }

    @Override
    public final void addDistinctiveFeature(final DistinctiveFeature feature) {
        getBaseCharacter().addDistinctiveFeature(feature);
    }

    @Override
    public final void addPendragonCharacterListener(
            final PendragonCharacterListener listener) {
        getBaseCharacter().addPendragonCharacterListener(listener);
    }

    @Override
    public final void clearDistinctiveFeatures() {
        getBaseCharacter().clearDistinctiveFeatures();
    }

    @Override
    public final DefaultHorse createNewInstance() {
        return new DefaultHorse(this);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultHorse other = (DefaultHorse) obj;
        return Objects.equals(getName(), other.getName())
                && Objects.equals(type, other.type);
    }

    @Override
    public final AttributesHolder getAttributes() {
        return getBaseCharacter().getAttributes();
    }

    @Override
    public final BackgroundInfo getBackgroundInfo() {
        return getBaseCharacter().getBackgroundInfo();
    }

    @Override
    public final DerivedAttributesHolder getDerivedAttributes() {
        return derived;
    }

    @Override
    public final Collection<DistinctiveFeature> getDistinctiveFeatures() {
        return getBaseCharacter().getDistinctiveFeatures();
    }

    @Override
    public final Gender getGender() {
        return getBaseCharacter().getGender();
    }

    @Override
    public final Integer getGlory() {
        return getBaseCharacter().getGlory();
    }

    @Override
    public final String getHorseType() {
        return type;
    }

    @Override
    public final String getName() {
        return getBaseCharacter().getName();
    }

    @Override
    public final Integer getNaturalArmor() {
        return naturalArmor;
    }

    @Override
    public final SkillsHolder getSkills() {
        return getBaseCharacter().getSkills();
    }

    @Override
    public final TraitsHolder getTraits() {
        return getBaseCharacter().getTraits();
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getName(), type);
    }

    @Override
    public final Boolean isArmored() {
        return armored;
    }

    @Override
    public final Boolean isCombatHorse() {
        return combat;
    }

    @Override
    public final Boolean isHuntingHorse() {
        return hunting;
    }

    @Override
    public final Boolean isRuined() {
        return ruined;
    }

    @Override
    public final void
            removeDistinctiveFeature(final DistinctiveFeature feature) {
        getBaseCharacter().removeDistinctiveFeature(feature);
    }

    @Override
    public final void removePendragonCharacterListener(
            final PendragonCharacterListener listener) {
        getBaseCharacter().removePendragonCharacterListener(listener);
    }

    @Override
    public final void setArmoredHorse(final Boolean armored) {
        this.armored = armored;
    }

    @Override
    public final void setCombatHorse(final Boolean combat) {
        this.combat = combat;
    }

    @Override
    public final void setDistinctiveFeatures(
            final Collection<DistinctiveFeature> features) {
        getBaseCharacter().setDistinctiveFeatures(features);
    }

    @Override
    public final void setGlory(final Integer glory) {
        getBaseCharacter().setGlory(glory);
    }

    @Override
    public final void setHuntingHorse(final Boolean hunting) {
        this.hunting = hunting;
    }

    @Override
    public final void setRuined(final Boolean ruined) {
        this.ruined = ruined;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("type", type)
                .add("name", getName()).toString();
    }

    private final PendragonCharacter getBaseCharacter() {
        return baseCharacter;
    }

}
