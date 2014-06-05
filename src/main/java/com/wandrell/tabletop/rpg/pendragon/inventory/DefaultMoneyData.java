package com.wandrell.tabletop.rpg.pendragon.inventory;

import com.wandrell.tabletop.rpg.conf.factory.ValueHandlerFactory;
import com.wandrell.tabletop.rpg.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultMoneyData implements PendragonMoneyData, NewInstantiable {

    private ValueHandler<Integer> vhDenarii;
    private ValueHandler<Integer> vhLibra;

    public DefaultMoneyData() {
	super();
	vhDenarii = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_DENARII);
	vhLibra = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_LIBRA);
    }

    public DefaultMoneyData(final DefaultMoneyData data) {
	super();

	vhDenarii = data.vhDenarii.createNewInstance();
	vhLibra = data.vhLibra.createNewInstance();
    }

    public DefaultMoneyData(final Integer libra, final Integer denarii) {
	super();
	this.vhDenarii = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_DENARII, denarii);
	this.vhLibra = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_LIBRA, libra);
    }

    @Override
    public DefaultMoneyData createNewInstance() {
	return new DefaultMoneyData(this);
    }

    @Override
    public boolean equals(final Object obj) {
	final DefaultMoneyData received;
	boolean equals;

	if (obj == this) {
	    equals = true;
	} else if (obj == null) {
	    equals = false;
	} else if (getClass() != obj.getClass()) {
	    equals = false;
	} else {
	    received = (DefaultMoneyData) obj;
	    if (received.vhDenarii == null) {
		equals = (vhDenarii == null);
	    } else {
		equals = (received.vhDenarii.equals(vhDenarii));
	    }
	    if ((equals) && (received.vhLibra == null)) {
		equals = (vhLibra == null);
	    } else if (equals) {
		equals = (received.vhLibra.equals(vhLibra));
	    }
	}

	return equals;
    }

    @Override
    public ValueHandler<Integer> getDenariiValueHandler() {
	return vhDenarii;
    }

    @Override
    public ValueHandler<Integer> getLibraValueHandler() {
	return vhLibra;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;

	result = prime * result
		+ ((vhDenarii == null) ? 0 : vhDenarii.hashCode());

	result = prime * result + ((vhLibra == null) ? 0 : vhLibra.hashCode());

	return result;
    }

}
