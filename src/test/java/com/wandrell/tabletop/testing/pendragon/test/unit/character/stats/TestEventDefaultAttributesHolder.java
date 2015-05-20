package com.wandrell.tabletop.testing.pendragon.test.unit.character.stats;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.wandrell.tabletop.pendragon.model.character.stats.AttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.DefaultAttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.event.AttributesListener;
import com.wandrell.tabletop.stats.event.ValueChangeEvent;

public final class TestEventDefaultAttributesHolder {

    private final AttributesHolder attributes = new DefaultAttributesHolder();

    public TestEventDefaultAttributesHolder() {
        super();
    }

    @Test
    public final void testSetAppearance() {
        final AttributesListener listener;

        listener = Mockito.mock(AttributesListener.class);

        attributes.addAttributesListener(listener);

        attributes.setAppearance(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).appearanceChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testSetConstitution() {
        final AttributesListener listener;

        listener = Mockito.mock(AttributesListener.class);

        attributes.addAttributesListener(listener);

        attributes.setConstitution(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).constitutionChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testSetDexterity() {
        final AttributesListener listener;

        listener = Mockito.mock(AttributesListener.class);

        attributes.addAttributesListener(listener);

        attributes.setDexterity(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).dexterityChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testSetSize() {
        final AttributesListener listener;

        listener = Mockito.mock(AttributesListener.class);

        attributes.addAttributesListener(listener);

        attributes.setSize(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).sizeChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

    @Test
    public final void testSetStrength() {
        final AttributesListener listener;

        listener = Mockito.mock(AttributesListener.class);

        attributes.addAttributesListener(listener);

        attributes.setStrength(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).strengthChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

}
