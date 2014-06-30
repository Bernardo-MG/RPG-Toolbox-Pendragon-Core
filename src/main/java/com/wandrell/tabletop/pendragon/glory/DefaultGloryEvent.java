package com.wandrell.tabletop.pendragon.glory;

import com.wandrell.tabletop.conf.factory.ValueHandlerFactory;
import com.wandrell.tabletop.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.valuehandler.ValueHandler;

public class DefaultGloryEvent implements GloryEvent {

    private final String description;
    private final ValueHandler<Integer> gloryGained;
    private final ValueHandler<Integer> year;

    public DefaultGloryEvent(final DefaultGloryEvent data) {
	super();

	gloryGained = data.gloryGained.createNewInstance();
	year = data.year.createNewInstance();
	description = data.description;
    }

    public DefaultGloryEvent(final Integer year, final Integer gloryGained,
	    final String description) {
	super();

	this.year = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_GLORY_EVENT_YEAR_NAME, year);
	this.gloryGained = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_GLORY_EVENT_GLORY_GAINED, gloryGained);
	this.description = description;
    }

    @Override
    public int compareTo(final GloryEvent data) {
	return getYear().getStoredValue().compareTo(
		data.getYear().getStoredValue());
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
	    if ((equals) && (received.gloryGained == null)) {
		equals = (gloryGained == null);
	    } else if (equals) {
		equals = (received.gloryGained.equals(gloryGained));
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
    public final ValueHandler<Integer> getGloryGained() {
	return gloryGained;
    }

    @Override
    public final ValueHandler<Integer> getYear() {
	return year;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;

	result = prime * result
		+ ((description == null) ? 0 : description.hashCode());
	result = prime
		* result
		+ (((gloryGained == null) || (gloryGained.getStoredValue() == null)) ? 0
			: gloryGained.getStoredValue().hashCode());
	result = prime
		* result
		+ (((year == null) || (year.getStoredValue() == null)) ? 0
			: year.getStoredValue().hashCode());
	return result;
    }

    @Override
    public String toString() {
	return String.format("[Year %d] [Gained %d] [%s]", getYear()
		.getStoredValue(), getGloryGained().getStoredValue(),
		getDescription());
    }
}
