package com.wandrell.tabletop.pendragon.model.character.event;

import static com.google.common.base.Preconditions.checkNotNull;

import com.wandrell.tabletop.event.ValueChangeEvent;
import com.wandrell.tabletop.pendragon.model.character.PendragonCharacter;
import com.wandrell.tabletop.pendragon.model.character.stats.event.TraitsListener;

public class CharacterEchoTraitsListener implements TraitsListener {

    private final PendragonCharacter    character;
    private final PendragonEventThrower eventThrower;

    public CharacterEchoTraitsListener(final PendragonCharacter character,
            final PendragonEventThrower eventThrower) {
        super();

        checkNotNull(character, "Received a null pointer as character");
        checkNotNull(eventThrower, "Received a null pointer as event thrower");

        this.character = character;
        this.eventThrower = eventThrower;
    }

    @Override
    public final void traitChanged(final ValueChangeEvent event) {
        getEventThrower().fireTraitChangedEvent(
                new ValueChangeEvent(character, event.getOldValue(), event
                        .getNewValue()));
    }

    private final PendragonEventThrower getEventThrower() {
        return eventThrower;
    }

}
