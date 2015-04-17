package com.wandrell.tabletop.pendragon.model.character.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import com.wandrell.tabletop.dice.Dice;

public final class DefaultRandomSkill implements RandomSkill {

    private final String descriptor;
    private final Dice   dice;
    private final String name;

    public DefaultRandomSkill(final String name, final String descriptor,
            final Dice dice) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(descriptor, "Received a null pointer as descriptor");
        checkNotNull(dice, "Received a null pointer as dice");

        this.name = name;
        this.descriptor = descriptor;
        this.dice = dice;
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
    public final Dice getValue() {
        return dice;
    }

}
