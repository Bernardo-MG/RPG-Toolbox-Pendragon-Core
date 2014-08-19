package com.wandrell.tabletop.pendragon.valuehandler.module.store;

import java.util.Collection;

import com.wandrell.tabletop.valuehandler.AbstractValueHandler;
import com.wandrell.tabletop.valuehandler.controller.ValueMarginController;
import com.wandrell.tabletop.valuehandler.module.StoreModule;

public final class ReligiousMarginStore extends StoreModule {

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

    public ReligiousMarginStore(final ReligiousMarginStore vc) {
        super(vc);

        controller = vc.controller.createNewInstance();
    }

    @Override
    public final void addValue(final Integer value) {}

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

    @Override
    public final void setValue(final Integer value) {}

    protected final ValueMarginController getController() {
        return controller;
    }

}
