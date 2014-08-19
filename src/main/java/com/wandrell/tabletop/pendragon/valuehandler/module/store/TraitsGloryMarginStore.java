package com.wandrell.tabletop.pendragon.valuehandler.module.store;

import java.util.Collection;

import com.wandrell.tabletop.valuehandler.AbstractValueHandler;
import com.wandrell.tabletop.valuehandler.controller.ValueMarginController;
import com.wandrell.tabletop.valuehandler.module.StoreModule;

public final class TraitsGloryMarginStore extends StoreModule {

    private final ValueMarginController controller;

    public TraitsGloryMarginStore(
            final Collection<AbstractValueHandler> values,
            final Integer valueMargin) {
        super();
        controller = new ValueMarginController(values, valueMargin);
    }

    public TraitsGloryMarginStore(final TraitsGloryMarginStore vc) {
        super(vc);
        controller = vc.controller.createNewInstance();
    }

    @Override
    public final void addValue(Integer value) {}

    @Override
    public TraitsGloryMarginStore createNewInstance() {
        return new TraitsGloryMarginStore(this);
    }

    @Override
    public final Integer getValue() {
        return getController().getInMarginSum()
                + getController().getAboveMarginSum();
    }

    @Override
    public final void setValue(Integer value) {}

    protected final ValueMarginController getController() {
        return controller;
    }

}
