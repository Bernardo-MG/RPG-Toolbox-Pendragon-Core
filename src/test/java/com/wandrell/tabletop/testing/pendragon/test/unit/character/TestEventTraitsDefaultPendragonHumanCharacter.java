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

public final class TestEventTraitsDefaultPendragonHumanCharacter {

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

    public TestEventTraitsDefaultPendragonHumanCharacter() {
        super();
    }

    @Test
    public final void testSetArbitrary() {
        final PendragonHumanCharacter character;
        final PendragonCharacterListener listener;
        final Religion religion;

        religion = Mockito.mock(Religion.class);

        character = new DefaultPendragonHumanCharacter("character",
                derivedBuilder, "culture", religion, "", "", "");

        listener = Mockito.mock(PendragonCharacterListener.class);

        character.addPendragonCharacterListener(listener);

        character.getTraits().setArbitrary(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).traitChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

}
