package com.wandrell.tabletop.pendragon.valuehandler.module.store;

import com.wandrell.tabletop.pendragon.util.PendragonRulesUtils;
import com.wandrell.tabletop.valuehandler.ValueHandler;
import com.wandrell.tabletop.valuehandler.module.StoreModule;

public class FeaturesStore extends StoreModule<Integer> {

    private final ValueHandler<Integer> appearance;

    public FeaturesStore(final FeaturesStore module) {
	super(module);
	appearance = module.appearance.createNewInstance();
    }

    public FeaturesStore(final ValueHandler<Integer> appearance) {
	super();

	this.appearance = appearance;
    }

    @Override
    public final void addValue(final Integer value) {
    }

    @Override
    public final FeaturesStore createNewInstance() {
	return new FeaturesStore(this);
    }

    @Override
    public final Integer getValue() {
	// TODO: Recalculate only if the attribute has changed
	return PendragonRulesUtils
		.getFeaturesCount(appearance.getStoredValue());
    }

    @Override
    public final void setValue(final Integer value) {
    }

}
