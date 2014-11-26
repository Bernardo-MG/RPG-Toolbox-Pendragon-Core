package com.wandrell.tabletop.business.model.pendragon.glory;

public final class DefaultGloryEvent implements GloryEvent {

    private final String  description;
    private final Integer glory;
    private final Integer year;

    public DefaultGloryEvent(final DefaultGloryEvent data) {
        super();

        glory = data.glory;
        year = data.year;
        description = data.description;
    }

    public DefaultGloryEvent(final Integer year, final Integer glory,
            final String description) {
        super();

        if (year == null) {
            throw new NullPointerException();
        }

        if (glory == null) {
            throw new NullPointerException();
        }

        if (description == null) {
            throw new NullPointerException();
        }

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
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (glory == null) {
            if (other.glory != null)
                return false;
        } else if (!glory.equals(other.glory))
            return false;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        return true;
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
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((glory == null) ? 0 : glory.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return String.format("[Year %d] [Gained %d] [%s]", getYear(),
                getGloryGained(), getDescription());
    }
}
