package com.wandrell.tabletop.business.model.pendragon.valuehandler.module.store;

import java.util.Collection;

import com.wandrell.tabletop.business.model.valuehandler.AbstractValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.module.store.AbstractStoreModule;
import com.wandrell.tabletop.business.util.valuehandler.ValueMarginController;

public final class TraitsGloryMarginStore extends AbstractStoreModule {

    private final ValueMarginController controller;

    public TraitsGloryMarginStore(
            final Collection<AbstractValueHandler> values,
            final Integer valueMargin) {
        super();
        controller = new ValueMarginController(values, valueMargin);
    }

    public TraitsGloryMarginStore(final TraitsGloryMarginStore store) {
        super();

        controller = store.controller.createNewInstance();
    }

    @Override
    public TraitsGloryMarginStore createNewInstance() {
        return new TraitsGloryMarginStore(this);
    }

    @Override
    public final Integer getValue() {
        return getController().getInMarginSum()
                + getController().getAboveMarginSum();
    }

    protected final ValueMarginController getController() {
        return controller;
    }

}
