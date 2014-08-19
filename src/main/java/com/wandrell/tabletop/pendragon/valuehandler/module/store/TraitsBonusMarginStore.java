package com.wandrell.tabletop.pendragon.valuehandler.module.store;

import java.util.Collection;

import com.wandrell.tabletop.valuehandler.AbstractValueHandler;
import com.wandrell.tabletop.valuehandler.ValueHandler;
import com.wandrell.tabletop.valuehandler.controller.ValueMarginController;
import com.wandrell.tabletop.valuehandler.module.StoreModule;

public final class TraitsBonusMarginStore extends StoreModule {

    private final ValueMarginController controller;

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
            final Collection<AbstractValueHandler> values,
            final Integer valueMargin) {
        super();
        controller = new ValueMarginController(values, valueMargin);
    }

    public TraitsBonusMarginStore(final TraitsBonusMarginStore vc) {
        super(vc);
        controller = vc.controller.createNewInstance();
    }

    @Override
    public final void addValue(final Integer value) {}

    @Override
    public final TraitsBonusMarginStore createNewInstance() {
        return new TraitsBonusMarginStore(this);
    }

    @Override
    public final Integer getValue() {
        Integer sum;

        sum = 0;
        for (final ValueHandler vh : getController().getValueHandlers()) {
            sum += vh.getStoredValue();
        }

        return sum;
    }

    public final Boolean isOn() {
        return (getValue() >= getController().getMargin());
    }

    @Override
    public final void setValue(final Integer value) {}

    protected final ValueMarginController getController() {
        return controller;
    }

}
