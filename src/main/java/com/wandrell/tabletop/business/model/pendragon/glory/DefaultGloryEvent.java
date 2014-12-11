package com.wandrell.tabletop.business.model.pendragon.glory;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;

public final class DefaultGloryEvent implements GloryEvent {

    private final String  description;
    private final Integer glory;
    private final Integer year;

    public DefaultGloryEvent(final DefaultGloryEvent event) {
        super();

        checkNotNull(event, "Received a null pointer as glory event");

        glory = event.glory;
        year = event.year;
        description = event.description;
    }

    public DefaultGloryEvent(final Integer year, final Integer glory,
            final String description) {
        super();

        checkNotNull(year, "Received a null pointer as year");
        checkNotNull(glory, "Received a null pointer as glory");
        checkNotNull(description, "Received a null pointer as description");

        this.year = year;
        this.glory = glory;
        this.description = description;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultGloryEvent other = (DefaultGloryEvent) obj;
        return Objects.equals(description, other.description)
                && Objects.equals(glory, other.glory)
                && Objects.equals(year, other.year);
    }

    @Override
    public final String getDescription() {
        return description;
    }

    @Override
    public final Integer getGloryGained() {
        return glory;
    }

    @Override
    public final Integer getYear() {
        return year;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(description, glory, year);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("description", description)
                .add("glory", glory).add("year", year).toString();
    }
}
