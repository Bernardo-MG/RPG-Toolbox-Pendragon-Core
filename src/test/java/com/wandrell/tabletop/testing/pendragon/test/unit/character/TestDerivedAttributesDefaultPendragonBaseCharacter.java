package com.wandrell.tabletop.testing.pendragon.test.unit.character;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.pendragon.model.character.DefaultPendragonBaseCharacter;
import com.wandrell.tabletop.pendragon.model.character.DerivedAttributeBuilder;
import com.wandrell.tabletop.pendragon.model.character.PendragonBaseCharacter;
import com.wandrell.tabletop.valuebox.ValueBox;

public final class TestDerivedAttributesDefaultPendragonBaseCharacter {

    private final PendragonBaseCharacter character;

    {
        final DerivedAttributeBuilder builder;

        builder = new DerivedAttributeBuilder() {

            @Override
            public final ValueBox getDamage(
                    final PendragonBaseCharacter character) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(1);

                return value;
            }

            @Override
            public final ValueBox getDexterityRoll(
                    final PendragonBaseCharacter character) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(2);

                return value;
            }

            @Override
            public final ValueBox getHealingRate(
                    final PendragonBaseCharacter character) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(3);

                return value;
            }

            @Override
            public final ValueBox getHitPoints(
                    final PendragonBaseCharacter character) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(4);

                return value;
            }

            @Override
            public final ValueBox getMajorWoundTreshold(
                    final PendragonBaseCharacter character) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(5);

                return value;
            }

            @Override
            public final ValueBox getMoveRate(
                    final PendragonBaseCharacter character) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(6);

                return value;
            }

            @Override
            public final ValueBox getUnconciousTreshold(
                    final PendragonBaseCharacter character) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(7);

                return value;
            }

            @Override
            public final ValueBox getWeight(
                    final PendragonBaseCharacter character) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(8);

                return value;
            }

        };

        character = new DefaultPendragonBaseCharacter("character", builder);
    }

    public TestDerivedAttributesDefaultPendragonBaseCharacter() {
        super();
    }

    @Test
    public final void testDamage() {
        Assert.assertEquals(character.getDamage(), (Integer) 1);
    }

    @Test
    public final void testDexterityRoll() {
        Assert.assertEquals(character.getDexterityRoll(), (Integer) 2);
    }

    @Test
    public final void testHealingRate() {
        Assert.assertEquals(character.getHealingRate(), (Integer) 3);
    }

    @Test
    public final void testHitPoints() {
        Assert.assertEquals(character.getHitPoints(), (Integer) 4);
    }

    @Test
    public final void testMajorWound() {
        Assert.assertEquals(character.getMajorWoundTreshold(), (Integer) 5);
    }

    @Test
    public final void testMoveRate() {
        Assert.assertEquals(character.getMoveRate(), (Integer) 6);
    }

    @Test
    public final void testUnconcious() {
        Assert.assertEquals(character.getUnconciousTreshold(), (Integer) 7);
    }

    @Test
    public final void testWeight() {
        Assert.assertEquals(character.getWeight(), (Integer) 8);
    }

}
