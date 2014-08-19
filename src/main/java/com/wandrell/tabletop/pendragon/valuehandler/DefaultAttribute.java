package com.wandrell.tabletop.pendragon.valuehandler;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import com.wandrell.tabletop.valuehandler.DefaultValueHandler;
import com.wandrell.tabletop.valuehandler.DelegateValueHandler;
import com.wandrell.tabletop.valuehandler.ValueHandler;
import com.wandrell.tabletop.valuehandler.module.GeneratorModule;
import com.wandrell.tabletop.valuehandler.module.IntervalModule;
import com.wandrell.tabletop.valuehandler.module.StoreModule;
import com.wandrell.tabletop.valuehandler.module.ValidatorModule;

public final class DefaultAttribute implements Attribute {

    private final Collection<ValueHandler> attributes = new LinkedList<>();
    private final DelegateValueHandler     composite;

    public DefaultAttribute(final DefaultAttribute attribute) {
        super();

        composite = attribute.composite.createNewInstance();
    }

    public DefaultAttribute(final String name, final GeneratorModule generator,
            final IntervalModule interval, final StoreModule store,
            final ValidatorModule validator) {
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
    public final DefaultAttribute createNewInstance() {
        return new DefaultAttribute(this);
    }

    @Override
    public final void decreaseValue() {
        getValueHandler().decreaseValue();
    }

    @Override
    public final Collection<ValueHandler> getDerivedAttributes() {
        return Collections.unmodifiableCollection(_getDerivedAttributes());
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

    public final void setDerivedAttributes(
            final Collection<ValueHandler> attributes) {
        _getDerivedAttributes().clear();
        for (final ValueHandler attribute : attributes) {
            if (attribute == null) {
                throw new NullPointerException();
            }

            _getDerivedAttributes().add(attribute);
        }
    }

    @Override
    public final void setValue(final Integer value) {
        getValueHandler().setValue(value);
    }

    @Override
    public final String toString() {
        return getName();
    }

    protected final Collection<ValueHandler> _getDerivedAttributes() {
        return attributes;
    }

    protected final ValueHandler getValueHandler() {
        return composite;
    }

}
