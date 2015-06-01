package com.wandrell.tabletop.pendragon.model.character.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.dice.notation.DiceExpression;

public final class DefaultAttributesRandom implements AttributesRandom {

    private final DiceExpression appearance;
    private final DiceExpression constitution;
    private final DiceExpression dexterity;
    private final DiceExpression size;
    private final DiceExpression strength;

    public DefaultAttributesRandom(final DiceExpression appearance,
            final DiceExpression constitution, final DiceExpression dexterity,
            final DiceExpression size, final DiceExpression strength) {
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
    public final DiceExpression getAppearance() {
        return appearance;
    }

    @Override
    public final DiceExpression getConstitution() {
        return constitution;
    }

    @Override
    public final DiceExpression getDexterity() {
        return dexterity;
    }

    @Override
    public final DiceExpression getSize() {
        return size;
    }

    @Override
    public final DiceExpression getStrength() {
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
                .add("appearance", appearance.getPrintableText())
                .add("constitution", constitution.getPrintableText())
                .add("dexterity", dexterity.getPrintableText())
                .add("size", size.getPrintableText())
                .add("strength", strength.getPrintableText()).toString();
    }

}
