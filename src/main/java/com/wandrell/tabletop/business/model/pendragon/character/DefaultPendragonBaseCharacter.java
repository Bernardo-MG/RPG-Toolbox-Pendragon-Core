package com.wandrell.tabletop.business.model.pendragon.character;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.pendragon.stats.Attribute;
import com.wandrell.tabletop.business.model.pendragon.stats.DerivedAttribute;

public final class DefaultPendragonBaseCharacter implements
        PendragonBaseCharacter {

    private final Attribute               constitution;

    private final DerivedAttribute        damage;
    private final DerivedAttributeBuilder derivedBuilder;
    private final Attribute               dexterity;
    private final DerivedAttribute        dexterityRoll;
    private final DerivedAttribute        healingRate;
    private final DerivedAttribute        hitPoints;
    private final DerivedAttribute        majorWoundTreshold;
    private final DerivedAttribute        movementRate;
    private final String                  name;
    private final Attribute               size;
    private final Attribute               strength;
    private final DerivedAttribute        unconsciousTreshold;
    private final DerivedAttribute        weight;

    public interface DerivedAttributeBuilder {

        public DerivedAttribute
                getDamage(final PendragonBaseCharacter character);

        public DerivedAttribute getDexterityRoll(
                final PendragonBaseCharacter character);

        public DerivedAttribute getHealingRate(
                final PendragonBaseCharacter character);

        public DerivedAttribute getHitPoints(
                final PendragonBaseCharacter character);

        public DerivedAttribute getMajorWoundTreshold(
                final PendragonBaseCharacter character);

        public DerivedAttribute getMovementRate(
                final PendragonBaseCharacter character);

        public DerivedAttribute getUnconsciousTreshold(
                final PendragonBaseCharacter character);

        public DerivedAttribute
                getWeight(final PendragonBaseCharacter character);

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
            final Attribute constitution, final Attribute dexterity,
            final Attribute size, final Attribute strength,
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

        this.constitution = constitution;
        this.dexterity = dexterity;
        this.size = size;
        this.strength = strength;

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
    public final Attribute getConstitution() {
        return constitution;
    }

    @Override
    public final DerivedAttribute getDamage() {
        return damage;
    }

    @Override
    public final Attribute getDexterity() {
        return dexterity;
    }

    @Override
    public final DerivedAttribute getDexterityRoll() {
        return dexterityRoll;
    }

    @Override
    public final DerivedAttribute getHealingRate() {
        return healingRate;
    }

    @Override
    public final DerivedAttribute getHitPoints() {
        return hitPoints;
    }

    @Override
    public final DerivedAttribute getMajorWoundTreshold() {
        return majorWoundTreshold;
    }

    @Override
    public final DerivedAttribute getMovementRate() {
        return movementRate;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Attribute getSize() {
        return size;
    }

    @Override
    public final Attribute getStrength() {
        return strength;
    }

    @Override
    public final DerivedAttribute getUnconsciousTreshold() {
        return unconsciousTreshold;
    }

    @Override
    public final DerivedAttribute getWeight() {
        return weight;
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
