package com.wandrell.tabletop.pendragon.valuehandler;

import com.wandrell.tabletop.valuehandler.DefaultValueHandler;
import com.wandrell.tabletop.valuehandler.DelegateValueHandler;
import com.wandrell.tabletop.valuehandler.ValueHandler;
import com.wandrell.tabletop.valuehandler.module.GeneratorModule;
import com.wandrell.tabletop.valuehandler.module.IntervalModule;
import com.wandrell.tabletop.valuehandler.module.StoreModule;
import com.wandrell.tabletop.valuehandler.module.ValidatorModule;

public final class DefaultDistinctiveFeature implements DistinctiveFeature {

    private final DelegateValueHandler composite;
    private String                     descriptor = "";

    public DefaultDistinctiveFeature(final DefaultDistinctiveFeature feature) {
        super();
        composite = feature.composite.createNewInstance();

        descriptor = feature.descriptor;
    }

    public DefaultDistinctiveFeature(final String name,
            final GeneratorModule generator, final IntervalModule interval,
            final StoreModule store, final ValidatorModule validator) {
        super();
        composite = new DefaultValueHandler(name, generator, interval, store,
                validator);
    }

    @Override
    public final Boolean acceptsValue(final Integer value) {
        return getValueHandler().acceptsValue(value);
    }

    @Override
    public final void addValue(final Integer value) {
        getValueHandler().addValue(value);
    }

    @Override
    public final DefaultDistinctiveFeature createNewInstance() {
        return new DefaultDistinctiveFeature(this);
    }

    @Override
    public final void decreaseValue() {
        getValueHandler().decreaseValue();
    }

    @Override
    public final String getDescriptor() {
        return descriptor;
    }

    @Override
    public final Integer getLowerLimit() {
        return getValueHandler().getLowerLimit();
    }

    @Override
    public final String getName() {
        return getValueHandler().getName();
    }

    @Override
    public final Integer getStoredValue() {
        return getValueHandler().getStoredValue();
    }

    @Override
    public final Integer getUpperLimit() {
        return getValueHandler().getUpperLimit();
    }

    @Override
    public final void increaseValue() {
        getValueHandler().increaseValue();
    }

    @Override
    public final Boolean isAbleToDecrease() {
        return getValueHandler().isAbleToDecrease();
    }

    @Override
    public final Boolean isAbleToIncrease() {
        return getValueHandler().isAbleToIncrease();
    }

    public final void setDescriptor(final String descriptor) {
        if (descriptor == null) {
            throw new NullPointerException();
        }

        this.descriptor = descriptor;
    }

    @Override
    public final void setValue(final Integer value) {
        getValueHandler().setValue(value);
    }

    @Override
    public final String toString() {
        return String.format("%s (%s)", getName(), getDescriptor());
    }

    protected final ValueHandler getValueHandler() {
        return composite;
    }

}
