package com.wandrell.tabletop.pendragon.valuehandler.module.store;

import java.util.Collection;

import com.wandrell.tabletop.valuehandler.AbstractValueHandler;
import com.wandrell.tabletop.valuehandler.module.StoreModule;
import com.wandrell.tabletop.valuehandler.module.store.AbstractMarginStore;
import com.wandrell.tabletop.valuehandler.module.store.IntegerMarginStore;

public final class TraitsBonusMarginStore extends StoreModule<Integer> {

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
    public TraitsBonusMarginStore(
	    final Collection<AbstractValueHandler<Integer>> values,
	    final Integer valueMargin) {
	super();
	store = new IntegerMarginStore<AbstractValueHandler<Integer>>(values,
		valueMargin);
    }

    public TraitsBonusMarginStore(final TraitsBonusMarginStore vc) {
	super(vc);
	store = vc.store.createNewInstance();
    }

    @Override
    public final void addValue(final Integer value) {
    }

    @Override
    public final TraitsBonusMarginStore createNewInstance() {
	return new TraitsBonusMarginStore(this);
    }

    @Override
    public final Integer getValue() {
	return store.getAllSum();
    }

    public final Boolean isOn() {
	return (getValue() >= store.getMargin());
    }

    @Override
    public final void setValue(final Integer value) {
    }

}
