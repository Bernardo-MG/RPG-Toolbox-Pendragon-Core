package com.wandrell.tabletop.rpg.pendragon.valuehandler.module.store;

import java.util.Collection;

import com.wandrell.tabletop.rpg.valuehandler.AbstractValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.module.StoreModule;
import com.wandrell.tabletop.rpg.valuehandler.module.store.AbstractMarginStore;
import com.wandrell.tabletop.rpg.valuehandler.module.store.IntegerMarginStore;

public class ReligiousMarginStore extends StoreModule<Integer> {

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
    public void addValue(final Integer value) {
    }

    @Override
    public ReligiousMarginStore createNewInstance() {
	return new ReligiousMarginStore(this);
    }

    @Override
    public Integer getValue() {
	return store.getAboveMarginCount() + store.getInMarginCount();
    }

    public boolean isOn() {
	return ((store.getValueHandlers().size() > 0) && (getValue() == store
		.getValueHandlers().size()));
    }

    @Override
    public void setValue(final Integer value) {
    }

}
