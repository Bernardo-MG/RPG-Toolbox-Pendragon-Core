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

        public ValueBox getDamage(final PendragonBaseCharacter character);

        public ValueBox
                getDexterityRoll(final PendragonBaseCharacter character);

        public ValueBox getHealingRate(final PendragonBaseCharacter character);

        public ValueBox getHitPoints(final PendragonBaseCharacter character);

        public ValueBox getMajorWoundTreshold(
                final PendragonBaseCharacter character);

        public ValueBox getMovementRate(final PendragonBaseCharacter character);

        public ValueBox getUnconsciousTreshold(
                final PendragonBaseCharacter character);

        public ValueBox getWeight(final PendragonBaseCharacter character);

    }

    public DefaultPendragonBaseCharacter(
            final DefaultPendragonBaseCharacter character) {
        super();

        checkNotNull(character, "Received a null pointer as character");

        name = character.name;

        constitution = character.constitution.createNewInstance();
        dexterity = character.dexterity.createNewInstance();
        size = character.size.createNewInstance();
        strength = character.strength.createNewInstance();

        derivedBuilder = character.derivedBuilder;

        this.damage = derivedBuilder.getDamage(this);
        this.dexterityRoll = derivedBuilder.getDexterityRoll(this);
        this.healingRate = derivedBuilder.getHealingRate(this);
        this.hitPoints = derivedBuilder.getHitPoints(this);
        this.majorWoundTreshold = derivedBuilder.getMajorWoundTreshold(this);
        this.movementRate = derivedBuilder.getMovementRate(this);
        this.unconsciousTreshold = derivedBuilder.getUnconsciousTreshold(this);
        this.weight = derivedBuilder.getWeight(this);
    }

    public DefaultPendragonBaseCharacter(final String name,
            final Integer constitution, final Integer dexterity,
            final Integer size, final Integer strength,
            final DerivedAttributeBuilder derivedAttributeBuilder) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(constitution, "Received a null pointer as constitution");
        checkNotNull(dexterity, "Received a null pointer as dexterity");
        checkNotNull(size, "Received a null pointer as size");
        checkNotNull(strength, "Received a null pointer as strength");
        checkNotNull(derivedAttributeBuilder,
                "Received a null pointer as derived attributes builder");

        this.name = name;

        // TODO: Maybe the attributes limits should be configurable
        this.constitution = new DefaultEditableValueBox(constitution, 0,
                Integer.MAX_VALUE);
        this.dexterity = new DefaultEditableValueBox(dexterity, 0,
                Integer.MAX_VALUE);
        this.size = new DefaultEditableValueBox(size, 0, Integer.MAX_VALUE);
        this.strength = new DefaultEditableValueBox(strength, 0,
                Integer.MAX_VALUE);

        derivedBuilder = derivedAttributeBuilder;

        this.damage = derivedAttributeBuilder.getDamage(this);
        this.dexterityRoll = derivedAttributeBuilder.getDexterityRoll(this);
        this.healingRate = derivedAttributeBuilder.getHealingRate(this);
        this.hitPoints = derivedAttributeBuilder.getHitPoints(this);
        this.majorWoundTreshold = derivedAttributeBuilder
                .getMajorWoundTreshold(this);
        this.movementRate = derivedAttributeBuilder.getMovementRate(this);
        this.unconsciousTreshold = derivedAttributeBuilder
                .getUnconsciousTreshold(this);
        this.weight = derivedAttributeBuilder.getWeight(this);
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
        return constitution.getValue();
    }

    @Override
    public final Integer getDamage() {
        return damage.getValue();
    }

    @Override
    public final Integer getDexterity() {
        return dexterity.getValue();
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
        return size.getValue();
    }

    @Override
    public final Integer getStrength() {
        return strength.getValue();
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
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

}
