package com.wandrell.tabletop.pendragon.model.character.event;

import static com.google.common.base.Preconditions.checkNotNull;

import com.wandrell.tabletop.event.ValueChangeEvent;
import com.wandrell.tabletop.pendragon.model.character.PendragonBaseCharacter;
import com.wandrell.tabletop.pendragon.model.character.stats.event.DerivedAttributesListener;

public final class CharacterEchoDerivedAttributesListener implements
        DerivedAttributesListener {

    private final PendragonBaseCharacter character;
    private final PendragonEventThrower  eventThrower;

    public CharacterEchoDerivedAttributesListener(
            final PendragonBaseCharacter character,
            final PendragonEventThrower eventThrower) {
        super();

        checkNotNull(character, "Received a null pointer as character");
        checkNotNull(eventThrower, "Received a null pointer as event thrower");

        this.character = character;
        this.eventThrower = eventThrower;
    }

    @Override
    public final void damageChanged(final ValueChangeEvent event) {
        getEventThrower().fireDamageChangedEvent(
                new ValueChangeEvent(character, event.getOldValue(), event
                        .getNewValue()));
    }

    @Override
    public final void dexterityRollChanged(final ValueChangeEvent event) {
        getEventThrower().fireDexterityRollChangedEvent(
                new ValueChangeEvent(character, event.getOldValue(), event
                        .getNewValue()));
    }

    @Override
    public final void healingRateChanged(final ValueChangeEvent event) {
        getEventThrower().fireHealingRateChangedEvent(
                new ValueChangeEvent(character, event.getOldValue(), event
                        .getNewValue()));
    }

    @Override
    public final void hitPointsChanged(final ValueChangeEvent event) {
        getEventThrower().fireHitPointsChangedEvent(
                new ValueChangeEvent(character, event.getOldValue(), event
                        .getNewValue()));
    }

    @Override
    public final void knockdownChanged(final ValueChangeEvent event) {
        getEventThrower().fireKnockdownChangedEvent(
                new ValueChangeEvent(character, event.getOldValue(), event
                        .getNewValue()));
    }

    @Override
    public final void majorWoundChanged(final ValueChangeEvent event) {
        getEventThrower().fireMajorWoundChangedEvent(
                new ValueChangeEvent(character, event.getOldValue(), event
                        .getNewValue()));
    }

    @Override
    public final void moveRateChanged(final ValueChangeEvent event) {
        getEventThrower().fireMoveRateChangedEvent(
                new ValueChangeEvent(character, event.getOldValue(), event
                        .getNewValue()));
    }

    @Override
    public final void unconciousChanged(final ValueChangeEvent event) {
        getEventThrower().fireUnconciousChangedEvent(
                new ValueChangeEvent(character, event.getOldValue(), event
                        .getNewValue()));
    }

    @Override
    public final void weightChanged(final ValueChangeEvent event) {
        getEventThrower().fireWeightChangedEvent(
                new ValueChangeEvent(character, event.getOldValue(), event
                        .getNewValue()));
    }

    private final PendragonEventThrower getEventThrower() {
        return eventThrower;
    }

}
