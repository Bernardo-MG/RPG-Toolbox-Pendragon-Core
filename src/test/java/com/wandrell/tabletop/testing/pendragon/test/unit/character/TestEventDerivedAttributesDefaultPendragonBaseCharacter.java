package com.wandrell.tabletop.testing.pendragon.test.unit.character;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.wandrell.tabletop.event.ValueChangeEvent;
import com.wandrell.tabletop.pendragon.model.character.DefaultPendragonBaseCharacter;
import com.wandrell.tabletop.pendragon.model.character.DerivedAttributeBuilder;
import com.wandrell.tabletop.pendragon.model.character.PendragonBaseCharacter;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonCharacterListener;
import com.wandrell.tabletop.pendragon.model.character.stats.AttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.DerivedAttributesHolder;
import com.wandrell.tabletop.valuebox.DefaultValueBox;
import com.wandrell.tabletop.valuebox.ValueBox;

public final class TestEventDerivedAttributesDefaultPendragonBaseCharacter {

    private final ValueBox                damage      = new DefaultValueBox(0);
    private final DerivedAttributeBuilder derivedBuilder;
    private final ValueBox                dexRoll     = new DefaultValueBox(0);
    private final ValueBox                healingRate = new DefaultValueBox(0);
    private final ValueBox                hitPoints   = new DefaultValueBox(0);
    private final ValueBox                majorWound  = new DefaultValueBox(0);
    private final ValueBox                moveRate    = new DefaultValueBox(0);
    private final ValueBox                unconcious  = new DefaultValueBox(0);
    private final ValueBox                weight      = new DefaultValueBox(0);

    {
        derivedBuilder = Mockito.mock(DerivedAttributeBuilder.class);

        Mockito.when(
                derivedBuilder.getDamage(Matchers.any(AttributesHolder.class),
                        Matchers.any(DerivedAttributesHolder.class)))
                .thenReturn(damage);
        Mockito.when(
                derivedBuilder.getDexterityRoll(
                        Matchers.any(AttributesHolder.class),
                        Matchers.any(DerivedAttributesHolder.class)))
                .thenReturn(dexRoll);
        Mockito.when(
                derivedBuilder.getHealingRate(
                        Matchers.any(AttributesHolder.class),
                        Matchers.any(DerivedAttributesHolder.class)))
                .thenReturn(healingRate);
        Mockito.when(
                derivedBuilder.getHitPoints(
                        Matchers.any(AttributesHolder.class),
                        Matchers.any(DerivedAttributesHolder.class)))
                .thenReturn(hitPoints);
        Mockito.when(
                derivedBuilder.getMajorWoundTreshold(
                        Matchers.any(AttributesHolder.class),
                        Matchers.any(DerivedAttributesHolder.class)))
                .thenReturn(majorWound);
        Mockito.when(
                derivedBuilder.getMoveRate(
                        Matchers.any(AttributesHolder.class),
                        Matchers.any(DerivedAttributesHolder.class)))
                .thenReturn(moveRate);
        Mockito.when(
                derivedBuilder.getUnconciousTreshold(
                        Matchers.any(AttributesHolder.class),
                        Matchers.any(DerivedAttributesHolder.class)))
                .thenReturn(unconcious);
        Mockito.when(
                derivedBuilder.getWeight(Matchers.any(AttributesHolder.class),
                        Matchers.any(DerivedAttributesHolder.class)))
                .thenReturn(weight);
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
