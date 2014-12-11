package com.wandrell.tabletop.business.model.pendragon.glory;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;

import com.wandrell.tabletop.business.model.valuehandler.ValueHandler;

public final class DefaultGloryKeeper implements GloryManager {

    private final ValueHandler           chivaldryGlory;
    private final Collection<GloryEvent> events;
    private final ValueHandler           gentlewomanGlory;
    private final ValueHandler           passionsGlory;
    private final ValueHandler           religiousGlory;
    private final ValueHandler           traitsGlory;
    private final ValueHandler           yearlyGlory;

    public DefaultGloryKeeper(final Collection<GloryEvent> events,
            final ValueHandler chivaldryGlory,
            final ValueHandler gentlewomanGlory,
            final ValueHandler passionsGlory,
            final ValueHandler religiousGlory, final ValueHandler traitsGlory,
            final ValueHandler yearlyGlory) {
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

    public DefaultGloryKeeper(final DefaultGloryKeeper glory) {
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
    public final ValueHandler getChivaldryGlory() {
        return chivaldryGlory;
    }

    @Override
    public final Collection<GloryEvent> getEvents() {
        return Collections.unmodifiableCollection(getEventsModifiable());
    }

    @Override
    public final ValueHandler getGentlewomanGlory() {
        return gentlewomanGlory;
    }

    @Override
    public final ValueHandler getPassionsGlory() {
        return passionsGlory;
    }

    @Override
    public final ValueHandler getReligiousGlory() {
        return religiousGlory;
    }

    @Override
    public final ValueHandler getTraitsGlory() {
        return traitsGlory;
    }

    @Override
    public final ValueHandler getYearlyGlory() {
        return yearlyGlory;
    }

    private final Collection<GloryEvent> getEventsModifiable() {
        return events;
    }

}
