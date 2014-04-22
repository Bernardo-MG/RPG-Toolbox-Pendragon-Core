package com.wandrell.tabletop.rpg.pendragon.valuehandler.module.store;

import com.wandrell.tabletop.rpg.pendragon.util.PendragonRulesUtils;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.module.StoreModule;

public class WeightStore extends StoreModule<Integer> {

    private final ValueHandler<Integer> vhWeight;

    public WeightStore(final ValueHandler<Integer> size) {
	super();
	vhWeight = size;
    }

    public WeightStore(final WeightStore store) {
	super(store);
	vhWeight = store.vhWeight.createNewInstance();
    }

    @Override
    public void addValue(final Integer value) {
    }

    @Override
    public WeightStore createNewInstance() {
	return new WeightStore(this);
    }

    @Override
    public Integer getValue() {
	return PendragonRulesUtils.weightCalculator(getWeight()
		.getStoredValue());
    }

    @Override
    public void setValue(final Integer value) {
    }

    protected ValueHandler<Integer> getWeight() {
	return vhWeight;
    }

}
