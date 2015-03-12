package com.wandrell.tabletop.testing.pendragon.test.unit.character;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.wandrell.tabletop.event.ValueChangeEvent;
import com.wandrell.tabletop.pendragon.model.character.DefaultPendragonBaseCharacter;
import com.wandrell.tabletop.pendragon.model.character.DerivedAttributeBuilder;
import com.wandrell.tabletop.pendragon.model.character.PendragonBaseCharacter;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonCharacterListener;
import com.wandrell.tabletop.valuebox.DefaultEditableValueBox;
import com.wandrell.tabletop.valuebox.EditableValueBox;

public final class TestEventDerivedAttributesDefaultPendragonBaseCharacter {

    private final EditableValueBox        damage      = new DefaultEditableValueBox(
                                                              0, 0,
                                                              Integer.MAX_VALUE);
    private final DerivedAttributeBuilder derivedBuilder;
    private final EditableValueBox        dexRoll     = new DefaultEditableValueBox(
                                                              0, 0,
                                                              Integer.MAX_VALUE);
    private final EditableValueBox        healingRate = new DefaultEditableValueBox(
                                                              0, 0,
                                                              Integer.MAX_VALUE);
    private final EditableValueBox        hitPoints   = new DefaultEditableValueBox(
                                                              0, 0,
                                                              Integer.MAX_VALUE);
    private final EditableValueBox        majorWound  = new DefaultEditableValueBox(
                                                              0, 0,
                                                              Integer.MAX_VALUE);
    private final EditableValueBox        moveRate    = new DefaultEditableValueBox(
                                                              0, 0,
                                                              Integer.MAX_VALUE);
    private final EditableValueBox        unconcious  = new DefaultEditableValueBox(
                                                              0, 0,
                                                              Integer.MAX_VALUE);
    private final EditableValueBox        weight      = new DefaultEditableValueBox(
                                                              0, 0,
                                                              Integer.MAX_VALUE);

    {
        derivedBuilder = Mockito.mock(DerivedAttributeBuilder.class);

        Mockito.when(
                derivedBuilder.getDamage(Matchers
                        .any(PendragonBaseCharacter.class))).thenReturn(damage);
        Mockito.when(
                derivedBuilder.getDexterityRoll(Matchers
                        .any(PendragonBaseCharacter.class)))
                .thenReturn(dexRoll);
        Mockito.when(
                derivedBuilder.getHealingRate(Matchers
                        .any(PendragonBaseCharacter.class))).thenReturn(
                healingRate);
        Mockito.when(
                derivedBuilder.getHitPoints(Matchers
                        .any(PendragonBaseCharacter.class))).thenReturn(
                hitPoints);
        Mockito.when(
                derivedBuilder.getMajorWoundTreshold(Matchers
                        .any(PendragonBaseCharacter.class))).thenReturn(
                majorWound);
        Mockito.when(
                derivedBuilder.getMoveRate(Matchers
                        .any(PendragonBaseCharacter.class))).thenReturn(
                moveRate);
        Mockito.when(
                derivedBuilder.getUnconciousTreshold(Matchers
                        .any(PendragonBaseCharacter.class))).thenReturn(
                unconcious);
        Mockito.when(
                derivedBuilder.getWeight(Matchers
                        .any(PendragonBaseCharacter.class))).thenReturn(weight);
    }

    public TestEventDerivedAttributesDefaultPendragonBaseCharacter() {
        super();
    }

    @Test
    public final void testDexRoll() {
        final PendragonBaseCharacter character;
        final PendragonCharacterListener listener;

        character = new DefaultPendragonBaseCharacter("character",
                derivedBuilder);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        dexRoll.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).dexterityRollChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testHealingRate() {
        final PendragonBaseCharacter character;
        final PendragonCharacterListener listener;

        character = new DefaultPendragonBaseCharacter("character",
                derivedBuilder);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        healingRate.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).healingRateChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testHitPoints() {
        final PendragonBaseCharacter character;
        final PendragonCharacterListener listener;

        character = new DefaultPendragonBaseCharacter("character",
                derivedBuilder);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        hitPoints.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).hitPointsChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testMajorWound() {
        final PendragonBaseCharacter character;
        final PendragonCharacterListener listener;

        character = new DefaultPendragonBaseCharacter("character",
                derivedBuilder);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        majorWound.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).majorWoundChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testMoveRate() {
        final PendragonBaseCharacter character;
        final PendragonCharacterListener listener;

        character = new DefaultPendragonBaseCharacter("character",
                derivedBuilder);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        moveRate.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).moveRateChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testSetDamage() {
        final PendragonBaseCharacter character;
        final PendragonCharacterListener listener;

        character = new DefaultPendragonBaseCharacter("character",
                derivedBuilder);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        damage.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).damageChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testUnconcious() {
        final PendragonBaseCharacter character;
        final PendragonCharacterListener listener;

        character = new DefaultPendragonBaseCharacter("character",
                derivedBuilder);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        unconcious.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).unconciousChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testWeight() {
        final PendragonBaseCharacter character;
        final PendragonCharacterListener listener;

        character = new DefaultPendragonBaseCharacter("character",
                derivedBuilder);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        weight.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).weightChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

}
