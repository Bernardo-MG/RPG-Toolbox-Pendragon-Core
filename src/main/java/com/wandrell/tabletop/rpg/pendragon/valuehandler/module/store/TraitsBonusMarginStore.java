package com.wandrell.tabletop.rpg.pendragon.valuehandler.module.store;

import java.util.Collection;

import com.wandrell.tabletop.rpg.valuehandler.AbstractValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.module.StoreModule;
import com.wandrell.tabletop.rpg.valuehandler.module.store.AbstractMarginStore;
import com.wandrell.tabletop.rpg.valuehandler.module.store.IntegerMarginStore;

public class TraitsBonusMarginStore extends StoreModule<Integer> {

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
    public void addValue(final Integer value) {
    }

    @Override
    public TraitsBonusMarginStore createNewInstance() {
	return new TraitsBonusMarginStore(this);
    }

    @Override
    public Integer getValue() {
	return store.getAllSum();
    }

    public boolean isOn() {
	return (getValue() >= store.getMargin());
    }

    @Override
    public void setValue(final Integer value) {
    }

}
