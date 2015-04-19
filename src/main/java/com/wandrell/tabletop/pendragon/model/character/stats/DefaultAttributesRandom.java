package com.wandrell.tabletop.pendragon.model.character.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.dice.Dice;

public final class DefaultAttributesRandom implements AttributesRandom {

    private final Dice appearance;
    private final Dice constitution;
    private final Dice dexterity;
    private final Dice size;
    private final Dice strength;

    public DefaultAttributesRandom(final Dice appearance,
            final Dice constitution, final Dice dexterity, final Dice size,
            final Dice strength) {
        super();

        checkNotNull(appearance, "Received a null pointer as appearance");
        checkNotNull(constitution, "Received a null pointer as constitution");
        checkNotNull(dexterity, "Received a null pointer as dexterity");
        checkNotNull(size, "Received a null pointer as size");
        checkNotNull(strength, "Received a null pointer as name");

        this.appearance = appearance;
        this.constitution = constitution;
        this.dexterity = dexterity;
        this.size = size;
        this.strength = strength;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultAttributesRandom other = (DefaultAttributesRandom) obj;
        return Objects.equals(appearance, other.appearance)
                && Objects.equals(constitution, other.constitution)
                && Objects.equals(dexterity, other.dexterity)
                && Objects.equals(size, other.size)
                && Objects.equals(strength, other.strength);
    }

    @Override
    public final Dice getAppearance() {
        return appearance;
    }

    @Override
    public final Dice getConstitution() {
        return constitution;
    }

    @Override
    public final Dice getDexterity() {
        return dexterity;
    }

    @Override
    public final Dice getSize() {
        return size;
    }

    @Override
    public final Dice getStrength() {
        return strength;
    }

    @Override
    public final int hashCode() {
        return Objects
                .hash(appearance, constitution, dexterity, size, strength);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("appearance", appearance.getTextValue())
                .add("constitution", constitution.getTextValue())
                .add("dexterity", dexterity.getTextValue())
                .add("size", size.getTextValue())
                .add("strength", strength.getTextValue()).toString();
    }

}
