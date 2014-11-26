package com.wandrell.tabletop.business.model.pendragon.valuehandler.module.store;

import java.util.Collection;

import com.wandrell.tabletop.business.model.valuehandler.AbstractValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.module.store.AbstractStoreModule;
import com.wandrell.tabletop.business.util.valuehandler.ValueMarginController;

public final class ReligiousMarginStore extends AbstractStoreModule {

    private final ValueMarginController controller;
    @SuppressWarnings("unused")
    private boolean                     flagOn = false;

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
    public ReligiousMarginStore(final Collection<AbstractValueHandler> values,
            final Integer valueMargin) {
        super();
        controller = new ValueMarginController(values, valueMargin);
    }

    public ReligiousMarginStore(final ReligiousMarginStore store) {
        super();

        controller = store.controller.createNewInstance();
    }

    @Override
    public final ReligiousMarginStore createNewInstance() {
        return new ReligiousMarginStore(this);
    }

    @Override
    public final Integer getValue() {
        return getController().getAboveMarginCount()
                + getController().getInMarginCount();
    }

    public final Boolean isOn() {
        return ((getController().getValueHandlers().size() > 0) && (getValue() == getController()
                .getValueHandlers().size()));
    }

    protected final ValueMarginController getController() {
        return controller;
    }

}
