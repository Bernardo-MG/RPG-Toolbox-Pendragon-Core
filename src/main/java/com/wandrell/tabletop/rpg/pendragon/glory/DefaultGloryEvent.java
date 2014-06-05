package com.wandrell.tabletop.rpg.pendragon.glory;

import com.wandrell.tabletop.rpg.conf.factory.ValueHandlerFactory;
import com.wandrell.tabletop.rpg.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultGloryEvent implements GloryEvent, NewInstantiable,
	Comparable<GloryEvent> {

    private final String infoGlory;
    private final ValueHandler<Integer> vhGloryGained;
    private final ValueHandler<Integer> vhYear;

    public DefaultGloryEvent(final DefaultGloryEvent data) {
	super();

	vhGloryGained = data.vhGloryGained.createNewInstance();
	vhYear = data.vhYear.createNewInstance();
	infoGlory = data.infoGlory;
    }

    public DefaultGloryEvent(final Integer year, final Integer gloryGained,
	    final String info) {
	super();

	vhYear = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_GLORY_EVENT_YEAR_NAME, year);
	vhGloryGained = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_GLORY_EVENT_GLORY_GAINED, gloryGained);
	this.infoGlory = info;
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
	    if (received.infoGlory == null) {
		equals = (infoGlory == null);
	    } else {
		equals = (received.infoGlory.equals(infoGlory));
	    }
	    if ((equals) && (received.vhGloryGained == null)) {
		equals = (vhGloryGained == null);
	    } else if (equals) {
		equals = (received.vhGloryGained.equals(vhGloryGained));
	    }
	    if ((equals) && (received.vhYear == null)) {
		equals = (vhYear == null);
	    } else if (equals) {
		equals = (received.vhYear.equals(vhYear));
	    }
	}

	return equals;
    }

    @Override
    public ValueHandler<Integer> getGloryGained() {
	return vhGloryGained;
    }

    @Override
    public String getInfo() {
	return infoGlory;
    }

    @Override
    public ValueHandler<Integer> getYear() {
	return vhYear;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;

	result = prime * result
		+ ((infoGlory == null) ? 0 : infoGlory.hashCode());
	result = prime
		* result
		+ (((vhGloryGained == null) || (vhGloryGained.getStoredValue() == null)) ? 0
			: vhGloryGained.getStoredValue().hashCode());
	result = prime
		* result
		+ (((vhYear == null) || (vhYear.getStoredValue() == null)) ? 0
			: vhYear.getStoredValue().hashCode());
	return result;
    }
}
