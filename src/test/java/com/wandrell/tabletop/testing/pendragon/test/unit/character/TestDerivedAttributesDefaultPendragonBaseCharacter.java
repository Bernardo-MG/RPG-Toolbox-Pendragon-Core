package com.wandrell.tabletop.testing.pendragon.test.unit.character;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.pendragon.model.character.DefaultPendragonCharacter;
import com.wandrell.tabletop.pendragon.model.character.DerivedAttributeBuilder;
import com.wandrell.tabletop.pendragon.model.character.PendragonCharacter;
import com.wandrell.tabletop.pendragon.model.character.stats.AttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.DerivedAttributesHolder;
import com.wandrell.tabletop.valuebox.ValueBox;

public final class TestDerivedAttributesDefaultPendragonBaseCharacter {

    private final PendragonCharacter character;

    {
        final DerivedAttributeBuilder builder;

        builder = new DerivedAttributeBuilder() {

            @Override
            public final ValueBox getDamage(final AttributesHolder attributes,
                    final DerivedAttributesHolder derived) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(1);

                return value;
            }

            @Override
            public final ValueBox getDexterityRoll(
                    final AttributesHolder attributes,
                    final DerivedAttributesHolder derived) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(2);

                return value;
            }

            @Override
            public final ValueBox getHealingRate(
                    final AttributesHolder attributes,
                    final DerivedAttributesHolder derived) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(3);

                return value;
            }

            @Override
            public final ValueBox getHitPoints(
                    final AttributesHolder attributes,
                    final DerivedAttributesHolder derived) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(4);

                return value;
            }

            @Override
            public final ValueBox getKnockdown(
                    final AttributesHolder attributes,
                    final DerivedAttributesHolder derived) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(9);

                return value;
            }

            @Override
            public final ValueBox getMajorWoundTreshold(
                    final AttributesHolder attributes,
                    final DerivedAttributesHolder derived) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(5);

                return value;
            }

            @Override
            public final ValueBox getMoveRate(
                    final AttributesHolder attributes,
                    final DerivedAttributesHolder derived) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(6);

                return value;
            }

            @Override
            public final ValueBox getUnconciousTreshold(
                    final AttributesHolder attributes,
                    final DerivedAttributesHolder derived) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(7);

                return value;
            }

            @Override
            public final ValueBox getWeight(final AttributesHolder attributes,
                    final DerivedAttributesHolder derived) {
                final ValueBox value;

                value = Mockito.mock(ValueBox.class);

                Mockito.when(value.getValue()).thenReturn(8);

                return value;
            }

        };

        character = new DefaultPendragonCharacter("character", builder);
    }

    public TestDerivedAttributesDefaultPendragonBaseCharacter() {
        super();
    }

    @Test
    public final void testDamage() {
        Assert.assertEquals(character.getDerivedAttributes().getDamage(),
                (Integer) 1);
    }

    @Test
    public final void testDexterityRoll() {
        Assert.assertEquals(
                character.getDerivedAttributes().getDexterityRoll(),
                (Integer) 2);
    }

    @Test
    public final void testHealingRate() {
        Assert.assertEquals(character.getDerivedAttributes().getHealingRate(),
                (Integer) 3);
    }

    @Test
    public final void testHitPoints() {
        Assert.assertEquals(character.getDerivedAttributes().getHitPoints(),
                (Integer) 4);
    }

    @Test
    public final void testKnockdown() {
        Assert.assertEquals(character.getDerivedAttributes().getKnockdown(),
                (Integer) 9);
    }

    @Test
    public final void testMajorWound() {
        Assert.assertEquals(character.getDerivedAttributes()
                .getMajorWoundTreshold(), (Integer) 5);
    }

    @Test
    public final void testMoveRate() {
        Assert.assertEquals(character.getDerivedAttributes().getMoveRate(),
                (Integer) 6);
    }

    @Test
    public final void testUnconcious() {
        Assert.assertEquals(character.getDerivedAttributes()
                .getUnconciousTreshold(), (Integer) 7);
    }

    @Test
    public final void testWeight() {
        Assert.assertEquals(character.getDerivedAttributes().getWeight(),
                (Integer) 8);
    }

}
