package com.wandrell.tabletop.pendragon.valuehandler;

import com.wandrell.tabletop.valuehandler.DefaultValueHandler;
import com.wandrell.tabletop.valuehandler.DelegateValueHandler;
import com.wandrell.tabletop.valuehandler.ValueHandler;
import com.wandrell.tabletop.valuehandler.module.GeneratorModule;
import com.wandrell.tabletop.valuehandler.module.IntervalModule;
import com.wandrell.tabletop.valuehandler.module.StoreModule;
import com.wandrell.tabletop.valuehandler.module.ValidatorModule;

public final class DefaultDirectedTrait implements DirectedTrait {

    private final DelegateValueHandler composite;
    private String                     descriptor = "";
    private ValueHandler               trait;

    public DefaultDirectedTrait(final DefaultDirectedTrait passion) {
        super();

        composite = passion.composite.createNewInstance();

        descriptor = passion.descriptor;
    }

    public DefaultDirectedTrait(final String name,
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
    public final DefaultDirectedTrait createNewInstance() {
        return new DefaultDirectedTrait(this);
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
    public final ValueHandler getTrait() {
        return trait;
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

    public final void setTrait(final ValueHandler trait) {
        if (trait == null) {
            throw new NullPointerException();
        }

        this.trait = trait;
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
