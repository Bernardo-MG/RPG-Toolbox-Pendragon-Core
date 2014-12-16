package com.wandrell.tabletop.business.model.pendragon.stats.module.store;

import java.util.Collection;

import com.wandrell.tabletop.business.model.valuehandler.AbstractValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.ValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.module.store.AbstractStoreModule;
import com.wandrell.tabletop.business.util.valuehandler.ValueMarginController;

public final class TraitsBonusMarginStore extends AbstractStoreModule {

    private final ValueMarginController controller;

    public TraitsBonusMarginStore(
            final Collection<AbstractValueHandler> values,
            final Integer valueMargin) {
        super();
        controller = new ValueMarginController(values, valueMargin);
    }

    public TraitsBonusMarginStore(final TraitsBonusMarginStore store) {
        super();

        controller = store.controller.createNewInstance();
    }

    @Override
    public final TraitsBonusMarginStore createNewInstance() {
        return new TraitsBonusMarginStore(this);
    }

    @Override
    public final Integer getValue() {
        Integer sum;

        sum = 0;
        for (final ValueHandler vh : getController().getValueHandlers()) {
            sum += vh.getValue();
        }

        return sum;
    }

    public final Boolean isOn() {
        return (getValue() >= getController().getMargin());
    }

    private final ValueMarginController getController() {
        return controller;
    }

}
