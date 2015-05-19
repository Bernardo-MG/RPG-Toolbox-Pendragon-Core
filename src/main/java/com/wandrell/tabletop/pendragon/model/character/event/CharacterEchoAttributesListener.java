package com.wandrell.tabletop.pendragon.model.character.event;

import static com.google.common.base.Preconditions.checkNotNull;

import com.wandrell.tabletop.pendragon.model.character.PendragonCharacter;
import com.wandrell.tabletop.pendragon.model.character.stats.event.AttributesListener;
import com.wandrell.tabletop.stat.event.ValueChangeEvent;

public final class CharacterEchoAttributesListener implements
        AttributesListener {

    private final PendragonCharacter    character;
    private final PendragonEventThrower eventThrower;

    public CharacterEchoAttributesListener(final PendragonCharacter character,
            final PendragonEventThrower eventThrower) {
        super();

        checkNotNull(character, "Received a null pointer as character");
        checkNotNull(eventThrower, "Received a null pointer as event thrower");

        this.character = character;
        this.eventThrower = eventThrower;
    }

    @Override
    public final void appearanceChanged(final ValueChangeEvent event) {
        getEventThrower().fireAppearanceChangedEvent(
                new ValueChangeEvent(character, event.getOldValue(), event
                        .getNewValue()));
    }

    @Override
    public final void constitutionChanged(final ValueChangeEvent event) {
        getEventThrower().fireConstitutionChangedEvent(
                new ValueChangeEvent(character, event.getOldValue(), event
                        .getNewValue()));
    }

    @Override
    public final void dexterityChanged(final ValueChangeEvent event) {
        getEventThrower().fireDexterityChangedEvent(
                new ValueChangeEvent(character, event.getOldValue(), event
                        .getNewValue()));
    }

    @Override
    public final void sizeChanged(final ValueChangeEvent event) {
        getEventThrower().fireSizeChangedEvent(
                new ValueChangeEvent(character, event.getOldValue(), event
                        .getNewValue()));
    }

    @Override
    public final void strengthChanged(final ValueChangeEvent event) {
        getEventThrower().fireStrengthChangedEvent(
                new ValueChangeEvent(character, event.getOldValue(), event
                        .getNewValue()));
    }

    private final PendragonEventThrower getEventThrower() {
        return eventThrower;
    }

}
