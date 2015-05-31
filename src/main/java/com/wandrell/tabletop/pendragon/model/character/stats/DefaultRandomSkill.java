package com.wandrell.tabletop.pendragon.model.character.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.dice.notation.DiceFormula;

public final class DefaultRandomSkill implements RandomSkill {

    private final String      descriptor;
    private final DiceFormula dice;
    private final String      name;

    public DefaultRandomSkill(final String name, final String descriptor,
            final DiceFormula dice) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(descriptor, "Received a null pointer as descriptor");
        checkNotNull(dice, "Received a null pointer as dice");

        this.name = name;
        this.descriptor = descriptor;
        this.dice = dice;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultRandomSkill other = (DefaultRandomSkill) obj;
        return Objects.equals(name, other.name)
                && Objects.equals(descriptor, other.descriptor)
                && Objects.equals(dice, other.dice);
    }

    @Override
    public final String getDescriptor() {
        return descriptor;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final DiceFormula getValue() {
        return dice;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(descriptor, name, dice);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name)
                .add("descriptor", descriptor)
                .add("value", dice.getPrintableText()).toString();
    }

}
