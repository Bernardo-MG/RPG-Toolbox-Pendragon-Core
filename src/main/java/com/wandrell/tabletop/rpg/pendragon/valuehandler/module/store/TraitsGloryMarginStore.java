package com.wandrell.tabletop.rpg.pendragon.valuehandler.module.store;

import java.util.Collection;

import com.wandrell.tabletop.rpg.valuehandler.AbstractValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.module.StoreModule;
import com.wandrell.tabletop.rpg.valuehandler.module.store.AbstractMarginStore;
import com.wandrell.tabletop.rpg.valuehandler.module.store.IntegerMarginStore;

public class TraitsGloryMarginStore extends StoreModule<Integer> {

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
    public void addValue(Integer value) {
    }

    @Override
    public TraitsGloryMarginStore createNewInstance() {
	return new TraitsGloryMarginStore(this);
    }

    @Override
    public Integer getValue() {
	return store.getInMarginSum() + store.getAboveMarginSum();
    }

    @Override
    public void setValue(Integer value) {
    }

}
