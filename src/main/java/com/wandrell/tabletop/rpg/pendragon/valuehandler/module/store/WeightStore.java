package com.wandrell.tabletop.rpg.pendragon.valuehandler.module.store;

import com.wandrell.tabletop.rpg.pendragon.util.PendragonRulesUtils;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.module.StoreModule;

public class WeightStore extends StoreModule<Integer> {

    private final ValueHandler<Integer> size;

    public WeightStore(final ValueHandler<Integer> size) {
	super();
	this.size = size;
    }

    public WeightStore(final WeightStore store) {
	super(store);
	size = store.size.createNewInstance();
    }

    @Override
    public final void addValue(final Integer value) {
    }

    @Override
    public WeightStore createNewInstance() {
	return new WeightStore(this);
    }

    @Override
    public final Integer getValue() {
	return PendragonRulesUtils.weightCalculator(getWeight()
		.getStoredValue());
    }

    @Override
    public final void setValue(final Integer value) {
    }

    protected final ValueHandler<Integer> getWeight() {
	return size;
    }

}
