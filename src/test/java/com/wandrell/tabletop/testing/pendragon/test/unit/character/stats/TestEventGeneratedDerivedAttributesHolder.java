package com.wandrell.tabletop.testing.pendragon.test.unit.character.stats;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.wandrell.tabletop.pendragon.model.character.DerivedAttributeBuilder;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonCharacterListener;
import com.wandrell.tabletop.pendragon.model.character.stats.AttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.DefaultAttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.DerivedAttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.GeneratedDerivedAttributesHolder;
import com.wandrell.tabletop.stat.event.ValueChangeEvent;
import com.wandrell.tabletop.stat.valuebox.DefaultValueBox;
import com.wandrell.tabletop.stat.valuebox.ValueBox;

public final class TestEventGeneratedDerivedAttributesHolder {

    private final ValueBox                damage      = new DefaultValueBox();
    private final ValueBox                dexRoll     = new DefaultValueBox();
    private final ValueBox                healingRate = new DefaultValueBox();
    private final ValueBox                hitPoints   = new DefaultValueBox();
    private final DerivedAttributesHolder holder;
    private final ValueBox                knockdown   = new DefaultValueBox();
    private final ValueBox                majorWound  = new DefaultValueBox();
    private final ValueBox                moveRate    = new DefaultValueBox();
    private final ValueBox                unconcious  = new DefaultValueBox();
    private final ValueBox                weight      = new DefaultValueBox();

    {
        final DerivedAttributeBuilder derivedBuilder;

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
                derivedBuilder.getKnockdown(
                        Matchers.any(AttributesHolder.class),
                        Matchers.any(DerivedAttributesHolder.class)))
                .thenReturn(knockdown);
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

        holder = new GeneratedDerivedAttributesHolder(
                new DefaultAttributesHolder(), derivedBuilder);
    }

    public TestEventGeneratedDerivedAttributesHolder() {
        super();
    }

    @Test
    public final void testDexRoll() {
        final PendragonCharacterListener listener;

        listener = Mockito.mock(PendragonCharacterListener.class);

        holder.addDerivedAttributesListener(listener);

        dexRoll.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).dexterityRollChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testHealingRate() {
        final PendragonCharacterListener listener;

        listener = Mockito.mock(PendragonCharacterListener.class);

        holder.addDerivedAttributesListener(listener);

        healingRate.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).healingRateChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testHitPoints() {
        final PendragonCharacterListener listener;

        listener = Mockito.mock(PendragonCharacterListener.class);

        holder.addDerivedAttributesListener(listener);

        hitPoints.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).hitPointsChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testKnockdown() {
        final PendragonCharacterListener listener;

        listener = Mockito.mock(PendragonCharacterListener.class);

        holder.addDerivedAttributesListener(listener);

        knockdown.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).knockdownChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testMajorWound() {
        final PendragonCharacterListener listener;

        listener = Mockito.mock(PendragonCharacterListener.class);

        holder.addDerivedAttributesListener(listener);

        majorWound.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).majorWoundChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testMoveRate() {
        final PendragonCharacterListener listener;

        listener = Mockito.mock(PendragonCharacterListener.class);

        holder.addDerivedAttributesListener(listener);

        moveRate.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).moveRateChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testSetDamage() {
        final PendragonCharacterListener listener;

        listener = Mockito.mock(PendragonCharacterListener.class);

        holder.addDerivedAttributesListener(listener);

        damage.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).damageChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testUnconcious() {
        final PendragonCharacterListener listener;

        listener = Mockito.mock(PendragonCharacterListener.class);

        holder.addDerivedAttributesListener(listener);

        unconcious.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).unconciousChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testWeight() {
        final PendragonCharacterListener listener;

        listener = Mockito.mock(PendragonCharacterListener.class);

        holder.addDerivedAttributesListener(listener);

        weight.setValue(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).weightChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

}
