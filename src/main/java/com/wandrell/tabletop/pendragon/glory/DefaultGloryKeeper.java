package com.wandrell.tabletop.pendragon.glory;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import com.wandrell.tabletop.valuehandler.ValueHandler;

public final class DefaultGloryKeeper implements GloryKeeper {

    private final Map<String, ValueHandler> annualSources;
    private final Collection<GloryEvent>    history;

    public DefaultGloryKeeper(final DefaultGloryKeeper glory) {
        super();

        annualSources = glory.annualSources;
        history = glory.history;
    }

    public DefaultGloryKeeper(final Map<String, ValueHandler> annualSources,
            final Collection<GloryEvent> history) {
        super();

        if (annualSources == null) {
            throw new NullPointerException();
        }

        if (history == null) {
            throw new NullPointerException();
        }

        this.annualSources = annualSources;
        this.history = history;
    }

    public final void addGlory(final DefaultGloryEvent event) {
        if (event == null) {
            throw new NullPointerException();
        }

        _getHistory().add(event);
    }

    @Override
    public final ValueHandler getAnnualGlorySource(final String name) {
        return _getAnnualGlorySources().get(name);
    }

    @Override
    public final Collection<ValueHandler> getAnnualGlorySources() {
        return Collections.unmodifiableCollection(_getAnnualGlorySources()
                .values());
    }

    @Override
    public final Collection<GloryEvent> getHistory() {
        return Collections.unmodifiableCollection(_getHistory());
    }

    @Override
    public final Boolean hasAnnualGlorySource(final String name) {
        return _getAnnualGlorySources().containsKey(name);
    }

    protected final Map<String, ValueHandler> _getAnnualGlorySources() {
        return annualSources;
    }

    protected final Collection<GloryEvent> _getHistory() {
        return history;
    }

}
