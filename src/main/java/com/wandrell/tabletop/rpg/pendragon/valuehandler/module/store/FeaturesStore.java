package com.wandrell.tabletop.rpg.pendragon.valuehandler.module.store;

import com.wandrell.tabletop.rpg.pendragon.util.PendragonRulesUtils;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.module.StoreModule;

public class FeaturesStore extends StoreModule<Integer> {

    private final ValueHandler<Integer> vhApp;

    public FeaturesStore(final FeaturesStore vc) {
	super(vc);
	vhApp = vc.vhApp.createNewInstance();
    }

    public FeaturesStore(final ValueHandler<Integer> vhApp) {
	super();

	this.vhApp = vhApp;
    }

    @Override
    public void addValue(final Integer value) {
    }

    @Override
    public FeaturesStore createNewInstance() {
	return new FeaturesStore(this);
    }

    @Override
    public Integer getValue() {
	// TODO: Recalculate only if the attribute has changed
	return PendragonRulesUtils.getFeaturesCount(vhApp.getStoredValue());
    }

    @Override
    public void setValue(final Integer value) {
    }

}
