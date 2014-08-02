package com.wandrell.tabletop.pendragon.valuehandler.module.store;

import java.util.Collection;

import com.wandrell.tabletop.valuehandler.AbstractValueHandler;
import com.wandrell.tabletop.valuehandler.module.StoreModule;
import com.wandrell.tabletop.valuehandler.module.store.AbstractMarginStore;
import com.wandrell.tabletop.valuehandler.module.store.IntegerMarginStore;

public final class TraitsGloryMarginStore extends StoreModule<Integer> {

    private final AbstractMarginStore<Integer, AbstractValueHandler<Integer>> store;

    public TraitsGloryMarginStore(
	    final Collection<AbstractValueHandler<Integer>> values,
	    final Integer valueMargin) {
	super();
	store = new IntegerMarginStore<AbstractValueHandler<Integer>>(values,
		valueMargin);
    }

    public TraitsGloryMarginStore(final TraitsGloryMarginStore vc) {
	super(vc);
	store = vc.store.createNewInstance();
    }

    @Override
    public final void addValue(Integer value) {
    }

    @Override
    public TraitsGloryMarginStore createNewInstance() {
	return new TraitsGloryMarginStore(this);
    }

    @Override
    public final Integer getValue() {
	return store.getInMarginSum() + store.getAboveMarginSum();
    }

    @Override
    public final void setValue(Integer value) {
    }

}
