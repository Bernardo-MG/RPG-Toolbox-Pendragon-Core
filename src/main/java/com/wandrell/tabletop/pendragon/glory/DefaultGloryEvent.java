package com.wandrell.tabletop.pendragon.glory;

public class DefaultGloryEvent implements GloryEvent {

    private final String description;
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

	this.year = year;
	this.glory = glory;
	this.description = description;
    }

    @Override
    public DefaultGloryEvent createNewInstance() {
	return new DefaultGloryEvent(this);
    }

    @Override
    public boolean equals(final Object obj) {
	final DefaultGloryEvent received;
	boolean equals;

	if (obj == this) {
	    equals = true;
	} else if (obj == null) {
	    equals = false;
	} else if (getClass() != obj.getClass()) {
	    equals = false;
	} else {
	    received = (DefaultGloryEvent) obj;
	    if (received.description == null) {
		equals = (description == null);
	    } else {
		equals = (received.description.equals(description));
	    }
	    if ((equals) && (received.glory == null)) {
		equals = (glory == null);
	    } else if (equals) {
		equals = (received.glory.equals(glory));
	    }
	    if ((equals) && (received.year == null)) {
		equals = (year == null);
	    } else if (equals) {
		equals = (received.year.equals(year));
	    }
	}

	return equals;
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
    public String toString() {
	return String.format("[Year %d] [Gained %d] [%s]", getYear(),
		getGloryGained(), getDescription());
    }
}
