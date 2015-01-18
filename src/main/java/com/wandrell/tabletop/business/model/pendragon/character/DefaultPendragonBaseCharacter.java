package com.wandrell.tabletop.business.model.pendragon.character;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.valuebox.DefaultEditableValueBox;
import com.wandrell.tabletop.business.model.valuebox.EditableValueBox;
import com.wandrell.tabletop.business.model.valuebox.ValueBox;

public final class DefaultPendragonBaseCharacter implements
        PendragonBaseCharacter {

    private final EditableValueBox        constitution;
    private final ValueBox                damage;
    private final DerivedAttributeBuilder derivedBuilder;
    private final EditableValueBox        dexterity;
    private final ValueBox                dexterityRoll;
    private final ValueBox                healingRate;
    private final ValueBox                hitPoints;
    private final ValueBox                majorWoundTreshold;
    private final ValueBox                movementRate;
    private final String                  name;
    private final EditableValueBox        size;
    private final EditableValueBox        strength;
    private final ValueBox                unconsciousTreshold;
    private final ValueBox                weight;

    public interface DerivedAttributeBuilder {

        public ValueBox getDamage(final ValueBox constitution,
                final ValueBox dexterity, final ValueBox size,
                final ValueBox strength);

        public ValueBox getDexterityRoll(final ValueBox constitution,
                final ValueBox dexterity, final ValueBox size,
                final ValueBox strength);

        public ValueBox getHealingRate(final ValueBox constitution,
                final ValueBox dexterity, final ValueBox size,
                final ValueBox strength);

        public ValueBox getHitPoints(final ValueBox constitution,
                final ValueBox dexterity, final ValueBox size,
                final ValueBox strength);

        public ValueBox getMajorWoundTreshold(final ValueBox constitution,
                final ValueBox dexterity, final ValueBox size,
                final ValueBox strength);

        public ValueBox getMovementRate(final ValueBox constitution,
                final ValueBox dexterity, final ValueBox size,
                final ValueBox strength);

        public ValueBox getUnconsciousTreshold(final ValueBox constitution,
                final ValueBox dexterity, final ValueBox size,
                final ValueBox strength);

        public ValueBox getWeight(final ValueBox constitution,
                final ValueBox dexterity, final ValueBox size,
                final ValueBox strength);

    }

    public DefaultPendragonBaseCharacter(
            final DefaultPendragonBaseCharacter character) {
        super();

        checkNotNull(character, "Received a null pointer as character");

        name = character.name;

        constitution = character.getConstitutionValueBox().createNewInstance();
        dexterity = character.getDexterityValueBox().createNewInstance();
        size = character.getSizeValueBox().createNewInstance();
        strength = character.getStrengthValueBox().createNewInstance();

        derivedBuilder = character.derivedBuilder;

        this.damage = derivedBuilder.getDamage(constitution, dexterity, size,
                strength);
        this.dexterityRoll = derivedBuilder.getDexterityRoll(constitution,
                dexterity, size, strength);
        this.healingRate = derivedBuilder.getHealingRate(constitution,
                dexterity, size, strength);
        this.hitPoints = derivedBuilder.getHitPoints(constitution, dexterity,
                size, strength);
        this.majorWoundTreshold = derivedBuilder.getMajorWoundTreshold(
                constitution, dexterity, size, strength);
        this.movementRate = derivedBuilder.getMovementRate(constitution,
                dexterity, size, strength);
        this.unconsciousTreshold = derivedBuilder.getUnconsciousTreshold(
                constitution, dexterity, size, strength);
        this.weight = derivedBuilder.getWeight(constitution, dexterity, size,
                strength);
    }

    public DefaultPendragonBaseCharacter(final String name,
            final DerivedAttributeBuilder derivedAttributeBuilder) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(derivedAttributeBuilder,
                "Received a null pointer as derived attributes builder");

        this.name = name;

        // TODO: Maybe the attributes limits should be configurable
        this.constitution = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.dexterity = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.size = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        this.strength = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);

        derivedBuilder = derivedAttributeBuilder;

        this.damage = derivedAttributeBuilder.getDamage(constitution,
                dexterity, size, strength);
        this.dexterityRoll = derivedAttributeBuilder.getDexterityRoll(
                constitution, dexterity, size, strength);
        this.healingRate = derivedAttributeBuilder.getHealingRate(constitution,
                dexterity, size, strength);
        this.hitPoints = derivedAttributeBuilder.getHitPoints(constitution,
                dexterity, size, strength);
        this.majorWoundTreshold = derivedAttributeBuilder
                .getMajorWoundTreshold(constitution, dexterity, size, strength);
        this.movementRate = derivedAttributeBuilder.getMovementRate(
                constitution, dexterity, size, strength);
        this.unconsciousTreshold = derivedAttributeBuilder
                .getUnconsciousTreshold(constitution, dexterity, size, strength);
        this.weight = derivedAttributeBuilder.getWeight(constitution,
                dexterity, size, strength);
    }

    @Override
    public final DefaultPendragonBaseCharacter createNewInstance() {
        return new DefaultPendragonBaseCharacter(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultPendragonBaseCharacter other = (DefaultPendragonBaseCharacter) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public final Integer getConstitution() {
        return getConstitutionValueBox().getValue();
    }

    @Override
    public final Integer getDamage() {
        return damage.getValue();
    }

    @Override
    public final Integer getDexterity() {
        return getDexterityValueBox().getValue();
    }

    @Override
    public final Integer getDexterityRoll() {
        return dexterityRoll.getValue();
    }

    @Override
    public final Integer getHealingRate() {
        return healingRate.getValue();
    }

    @Override
    public final Integer getHitPoints() {
        return hitPoints.getValue();
    }

    @Override
    public final Integer getMajorWoundTreshold() {
        return majorWoundTreshold.getValue();
    }

    @Override
    public final Integer getMovementRate() {
        return movementRate.getValue();
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Integer getSize() {
        return getSizeValueBox().getValue();
    }

    @Override
    public final Integer getStrength() {
        return getStrengthValueBox().getValue();
    }

    @Override
    public final Integer getUnconsciousTreshold() {
        return unconsciousTreshold.getValue();
    }

    @Override
    public final Integer getWeight() {
        return weight.getValue();
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final void setConstitution(final Integer constitution) {
        getConstitutionValueBox().setValue(constitution);
    }

    @Override
    public final void setDexterity(final Integer dexterity) {
        getDexterityValueBox().setValue(dexterity);
    }

    @Override
    public final void setSize(final Integer size) {
        getSizeValueBox().setValue(size);
    }

    @Override
    public final void setStrength(final Integer strength) {
        getStrengthValueBox().setValue(strength);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

    private final EditableValueBox getConstitutionValueBox() {
        return constitution;
    }

    private final EditableValueBox getDexterityValueBox() {
        return dexterity;
    }

    private final EditableValueBox getSizeValueBox() {
        return size;
    }

    private final EditableValueBox getStrengthValueBox() {
        return strength;
    }

}
