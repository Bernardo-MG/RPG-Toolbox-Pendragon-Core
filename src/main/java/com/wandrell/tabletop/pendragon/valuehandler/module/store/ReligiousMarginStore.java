package com.wandrell.tabletop.pendragon.valuehandler.module.store;

import java.util.Collection;

import com.wandrell.tabletop.valuehandler.AbstractValueHandler;
import com.wandrell.tabletop.valuehandler.module.StoreModule;
import com.wandrell.tabletop.valuehandler.module.store.AbstractMarginStore;
import com.wandrell.tabletop.valuehandler.module.store.IntegerMarginStore;

public class ReligiousMarginStore extends StoreModule<Integer> {

    @SuppressWarnings("unused")
    private boolean flagOn = false;
    private final AbstractMarginStore<Integer, AbstractValueHandler<Integer>> store;

    /**
     * Basic constructor.
     * 
     * @param parent
     *            the parent
     * @param values
     *            the values to be stored
     * @param valueMargin
     *            the value level for the checks
     */
    public ReligiousMarginStore(
	    final Collection<AbstractValueHandler<Integer>> values,
	    final Integer valueMargin) {
	super();
	store = new IntegerMarginStore<AbstractValueHandler<Integer>>(values,
		valueMargin);
    }

    public ReligiousMarginStore(final ReligiousMarginStore vc) {
	super(vc);
	store = vc.store.createNewInstance();
    }

    @Override
    public final void addValue(final Integer value) {
    }

    @Override
    public final ReligiousMarginStore createNewInstance() {
	return new ReligiousMarginStore(this);
    }

    @Override
    public final Integer getValue() {
	return store.getAboveMarginCount() + store.getInMarginCount();
    }

    public final Boolean isOn() {
	return ((store.getValueHandlers().size() > 0) && (getValue() == store
		.getValueHandlers().size()));
    }

    @Override
    public final void setValue(final Integer value) {
    }

}
