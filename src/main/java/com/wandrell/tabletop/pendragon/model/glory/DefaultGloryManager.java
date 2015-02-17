package com.wandrell.tabletop.pendragon.model.glory;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;

import com.wandrell.tabletop.valuebox.ValueBox;

public final class DefaultGloryManager implements GloryManager {

    private final ValueBox               chivaldryGlory;
    private final Collection<GloryEvent> events;
    private final ValueBox               gentlewomanGlory;
    private final ValueBox               passionsGlory;
    private final ValueBox               religiousGlory;
    private final ValueBox               traitsGlory;
    private final ValueBox               yearlyGlory;

    public DefaultGloryManager(final Collection<GloryEvent> events,
            final ValueBox chivaldryGlory, final ValueBox gentlewomanGlory,
            final ValueBox passionsGlory, final ValueBox religiousGlory,
            final ValueBox traitsGlory, final ValueBox yearlyGlory) {
        super();

        checkNotNull(events, "Received a null pointer as events");
        checkNotNull(chivaldryGlory,
                "Received a null pointer as chivaldry glory");
        checkNotNull(gentlewomanGlory,
                "Received a null pointer as gentlewoman glory");
        checkNotNull(passionsGlory, "Received a null pointer as passions glory");
        checkNotNull(religiousGlory,
                "Received a null pointer as religious glory");
        checkNotNull(traitsGlory, "Received a null pointer as traits glory");
        checkNotNull(yearlyGlory, "Received a null pointer as yearly glory");

        this.events = events;

        this.chivaldryGlory = chivaldryGlory;
        this.gentlewomanGlory = gentlewomanGlory;
        this.passionsGlory = passionsGlory;
        this.religiousGlory = religiousGlory;
        this.traitsGlory = traitsGlory;
        this.yearlyGlory = yearlyGlory;
    }

    public DefaultGloryManager(final DefaultGloryManager glory) {
        super();

        checkNotNull(glory, "Received a null pointer as glory");

        events = glory.events;

        chivaldryGlory = glory.chivaldryGlory;
        gentlewomanGlory = glory.gentlewomanGlory;
        passionsGlory = glory.passionsGlory;
        religiousGlory = glory.religiousGlory;
        traitsGlory = glory.traitsGlory;
        ;
        yearlyGlory = glory.yearlyGlory;
    }

    public final void addGlory(final DefaultGloryEvent event) {
        checkNotNull(event, "Received a null pointer as glory event");

        getEventsModifiable().add(event);
    }

    @Override
    public final ValueBox getChivaldryGlory() {
        return chivaldryGlory;
    }

    @Override
    public final Collection<GloryEvent> getEvents() {
        return Collections.unmodifiableCollection(getEventsModifiable());
    }

    @Override
    public final ValueBox getGentlewomanGlory() {
        return gentlewomanGlory;
    }

    @Override
    public final ValueBox getPassionsGlory() {
        return passionsGlory;
    }

    @Override
    public final ValueBox getReligiousGlory() {
        return religiousGlory;
    }

    @Override
    public final ValueBox getTraitsGlory() {
        return traitsGlory;
    }

    @Override
    public final ValueBox getYearlyGlory() {
        return yearlyGlory;
    }

    private final Collection<GloryEvent> getEventsModifiable() {
        return events;
    }

}
