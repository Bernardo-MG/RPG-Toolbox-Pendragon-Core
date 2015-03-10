package com.wandrell.tabletop.testing.pendragon.test.unit;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.wandrell.tabletop.event.ValueChangeEvent;
import com.wandrell.tabletop.pendragon.model.character.DefaultPendragonHumanCharacter;
import com.wandrell.tabletop.pendragon.model.character.DerivedAttributeBuilder;
import com.wandrell.tabletop.pendragon.model.character.PendragonHumanCharacter;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonCharacterListener;

public final class TestEventDefaultPendragonHumanCharacter {

    public TestEventDefaultPendragonHumanCharacter() {
        super();
    }

    @Test
    public final void testSetAppearance() {
        final PendragonHumanCharacter character;
        final PendragonCharacterListener listener;

        character = new DefaultPendragonHumanCharacter("character",
                Mockito.mock(DerivedAttributeBuilder.class));

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

        character = new DefaultPendragonHumanCharacter("character",
                Mockito.mock(DerivedAttributeBuilder.class));

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

        character = new DefaultPendragonHumanCharacter("character",
                Mockito.mock(DerivedAttributeBuilder.class));

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

        character = new DefaultPendragonHumanCharacter("character",
                Mockito.mock(DerivedAttributeBuilder.class));

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

        character = new DefaultPendragonHumanCharacter("character",
                Mockito.mock(DerivedAttributeBuilder.class));

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        character.setStrength(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).strengthChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

}
