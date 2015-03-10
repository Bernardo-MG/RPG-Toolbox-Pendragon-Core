package com.wandrell.tabletop.testing.pendragon.test.unit;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.wandrell.tabletop.event.ValueChangeEvent;
import com.wandrell.tabletop.pendragon.model.character.DefaultPendragonBaseCharacter;
import com.wandrell.tabletop.pendragon.model.character.DerivedAttributeBuilder;
import com.wandrell.tabletop.pendragon.model.character.PendragonBaseCharacter;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonCharacterListener;
import com.wandrell.tabletop.valuebox.ValueBox;

public final class TestEventAttributesDefaultPendragonBaseCharacter {

    private final DerivedAttributeBuilder derivedBuilder;

    {
        derivedBuilder = Mockito.mock(DerivedAttributeBuilder.class);

        Mockito.when(
                derivedBuilder.getDamage(Matchers
                        .any(PendragonBaseCharacter.class))).thenReturn(
                Mockito.mock(ValueBox.class));
        Mockito.when(
                derivedBuilder.getDexterityRoll(Matchers
                        .any(PendragonBaseCharacter.class))).thenReturn(
                Mockito.mock(ValueBox.class));
        Mockito.when(
                derivedBuilder.getHealingRate(Matchers
                        .any(PendragonBaseCharacter.class))).thenReturn(
                Mockito.mock(ValueBox.class));
        Mockito.when(
                derivedBuilder.getHitPoints(Matchers
                        .any(PendragonBaseCharacter.class))).thenReturn(
                Mockito.mock(ValueBox.class));
        Mockito.when(
                derivedBuilder.getMajorWoundTreshold(Matchers
                        .any(PendragonBaseCharacter.class))).thenReturn(
                Mockito.mock(ValueBox.class));
        Mockito.when(
                derivedBuilder.getMoveRate(Matchers
                        .any(PendragonBaseCharacter.class))).thenReturn(
                Mockito.mock(ValueBox.class));
        Mockito.when(
                derivedBuilder.getUnconciousTreshold(Matchers
                        .any(PendragonBaseCharacter.class))).thenReturn(
                Mockito.mock(ValueBox.class));
        Mockito.when(
                derivedBuilder.getWeight(Matchers
                        .any(PendragonBaseCharacter.class))).thenReturn(
                Mockito.mock(ValueBox.class));
    }

    public TestEventAttributesDefaultPendragonBaseCharacter() {
        super();
    }

    @Test
    public final void testSetConstitution() {
        final PendragonBaseCharacter character;
        final PendragonCharacterListener listener;

        character = new DefaultPendragonBaseCharacter("character",
                derivedBuilder);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        character.setConstitution(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).constitutionChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testSetDexterity() {
        final PendragonBaseCharacter character;
        final PendragonCharacterListener listener;

        character = new DefaultPendragonBaseCharacter("character",
                derivedBuilder);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        character.setDexterity(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).dexterityChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testSetSize() {
        final PendragonBaseCharacter character;
        final PendragonCharacterListener listener;

        character = new DefaultPendragonBaseCharacter("character",
                derivedBuilder);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        character.setSize(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).sizeChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testSetStrength() {
        final PendragonBaseCharacter character;
        final PendragonCharacterListener listener;

        character = new DefaultPendragonBaseCharacter("character",
                derivedBuilder);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        character.setStrength(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).strengthChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

}
