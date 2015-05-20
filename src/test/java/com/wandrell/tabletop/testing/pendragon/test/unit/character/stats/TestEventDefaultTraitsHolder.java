package com.wandrell.tabletop.testing.pendragon.test.unit.character.stats;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.wandrell.tabletop.pendragon.model.character.stats.DefaultTraitsHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.TraitsHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.event.TraitsListener;
import com.wandrell.tabletop.stats.event.ValueChangeEvent;

public final class TestEventDefaultTraitsHolder {

    public TestEventDefaultTraitsHolder() {
        super();
    }

    @Test
    public final void testSetArbitrary() {
        final TraitsHolder holder;
        final TraitsListener listener;

        holder = new DefaultTraitsHolder();

        listener = Mockito.mock(TraitsListener.class);

        holder.addTraitsListener(listener);

        holder.setArbitrary(1);

        Mockito.verify(listener, Mockito.atLeastOnce()).traitChanged(
                Matchers.any(ValueChangeEvent.class));
        Mockito.verifyNoMoreInteractions(listener);
    }

}
