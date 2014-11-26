package com.wandrell.tabletop.business.model.pendragon.valuehandler;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import com.wandrell.tabletop.business.model.valuehandler.EditableValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.ModularEditableValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.event.ValueHandlerListener;
import com.wandrell.tabletop.business.model.valuehandler.module.generator.GeneratorModule;
import com.wandrell.tabletop.business.model.valuehandler.module.interval.IntervalModule;
import com.wandrell.tabletop.business.model.valuehandler.module.store.AbstractEditableStoreModule;
import com.wandrell.tabletop.business.model.valuehandler.module.validator.ValidatorModule;

public final class DefaultAttribute implements Attribute {

    private final Collection<EditableValueHandler> attributes = new LinkedList<>();
    private final ModularEditableValueHandler      composite;

    public DefaultAttribute(final DefaultAttribute attribute) {
        super();

        composite = attribute.composite.createNewInstance();
    }

    public DefaultAttribute(final String name, final GeneratorModule generator,
            final IntervalModule interval,
            final AbstractEditableStoreModule store,
            final ValidatorModule validator) {
        super();
        composite = new ModularEditableValueHandler(name, generator, interval,
                store, validator);
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
    public final void
            addValueEventListener(final ValueHandlerListener listener) {
        getValueHandler().addValueEventListener(listener);
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
    public final Collection<EditableValueHandler> getDerivedAttributes() {
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
    public final Integer getUpperLimit() {
        return getValueHandler().getUpperLimit();
    }

    @Override
    public final Integer getValue() {
        return getValueHandler().getValue();
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

    @Override
    public final void removeValueEventListener(
            final ValueHandlerListener listener) {
        getValueHandler().removeValueEventListener(listener);
    }

    public final void setDerivedAttributes(
            final Collection<EditableValueHandler> attributes) {
        _getDerivedAttributes().clear();
        for (final EditableValueHandler attribute : attributes) {
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

    protected final Collection<EditableValueHandler> _getDerivedAttributes() {
        return attributes;
    }

    protected final EditableValueHandler getValueHandler() {
        return composite;
    }

}
