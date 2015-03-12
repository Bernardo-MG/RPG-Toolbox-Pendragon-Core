package com.wandrell.tabletop.testing.pendragon.test.unit.character;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.wandrell.tabletop.event.ValueChangeEvent;
import com.wandrell.tabletop.pendragon.model.character.DefaultPendragonHumanCharacter;
import com.wandrell.tabletop.pendragon.model.character.DerivedAttributeBuilder;
import com.wandrell.tabletop.pendragon.model.character.PendragonBaseCharacter;
import com.wandrell.tabletop.pendragon.model.character.PendragonHumanCharacter;
import com.wandrell.tabletop.pendragon.model.character.background.Religion;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonCharacterListener;
import com.wandrell.tabletop.valuebox.ValueBox;

public final class TestEventAttributesDefaultPendragonHumanCharacter {

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

    public TestEventAttributesDefaultPendragonHumanCharacter() {
        super();
    }

    @Test
    public final void testSetAppearance() {
        final PendragonHumanCharacter character;
        final PendragonCharacterListener listener;
        final Religion religion;

        religion = Mockito.mock(Religion.class);

        character = new DefaultPendragonHumanCharacter("character",
                derivedBuilder, "culture", religion);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        character.setAppearance(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).appearanceChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testSetConstitution() {
        final PendragonHumanCharacter character;
        final PendragonCharacterListener listener;
        final Religion religion;

        religion = Mockito.mock(Religion.class);

        character = new DefaultPendragonHumanCharacter("character",
                derivedBuilder, "culture", religion);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        character.setConstitution(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).constitutionChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testSetDexterity() {
        final PendragonHumanCharacter character;
        final PendragonCharacterListener listener;
        final Religion religion;

        religion = Mockito.mock(Religion.class);

        character = new DefaultPendragonHumanCharacter("character",
                derivedBuilder, "culture", religion);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        character.setDexterity(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).dexterityChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testSetSize() {
        final PendragonHumanCharacter character;
        final PendragonCharacterListener listener;
        final Religion religion;

        religion = Mockito.mock(Religion.class);

        character = new DefaultPendragonHumanCharacter("character",
                derivedBuilder, "culture", religion);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        character.setSize(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).sizeChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testSetStrength() {
        final PendragonHumanCharacter character;
        final PendragonCharacterListener listener;
        final Religion religion;

        religion = Mockito.mock(Religion.class);

        character = new DefaultPendragonHumanCharacter("character",
                derivedBuilder, "culture", religion);

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        character.setStrength(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).strengthChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

}
