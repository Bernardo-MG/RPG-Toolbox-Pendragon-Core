package com.wandrell.tabletop.pendragon.inventory;

import com.wandrell.tabletop.conf.factory.ValueHandlerFactory;
import com.wandrell.tabletop.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.valuehandler.ValueHandler;

public class DefaultPendragonMoney implements PendragonMoney {

    private ValueHandler<Integer> denarii;
    private ValueHandler<Integer> libra;

    public DefaultPendragonMoney() {
	super();
	denarii = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_DENARII);
	libra = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_LIBRA);
    }

    public DefaultPendragonMoney(final DefaultPendragonMoney data) {
	super();

	denarii = data.denarii.createNewInstance();
	libra = data.libra.createNewInstance();
    }

    public DefaultPendragonMoney(final Integer libra, final Integer denarii) {
	super();
	this.denarii = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_DENARII, denarii);
	this.libra = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_LIBRA, libra);
    }

    @Override
    public DefaultPendragonMoney createNewInstance() {
	return new DefaultPendragonMoney(this);
    }

    @Override
    public boolean equals(final Object obj) {
	final DefaultPendragonMoney received;
	boolean equals;

	if (obj == this) {
	    equals = true;
	} else if (obj == null) {
	    equals = false;
	} else if (getClass() != obj.getClass()) {
	    equals = false;
	} else {
	    received = (DefaultPendragonMoney) obj;
	    if (received.denarii == null) {
		equals = (denarii == null);
	    } else {
		equals = (received.denarii.equals(denarii));
	    }
	    if ((equals) && (received.libra == null)) {
		equals = (libra == null);
	    } else if (equals) {
		equals = (received.libra.equals(libra));
	    }
	}

	return equals;
    }

    @Override
    public final ValueHandler<Integer> getDenarii() {
	return denarii;
    }

    @Override
    public final ValueHandler<Integer> getLibra() {
	return libra;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;

	result = prime * result + ((denarii == null) ? 0 : denarii.hashCode());

	result = prime * result + ((libra == null) ? 0 : libra.hashCode());

	return result;
    }

}
