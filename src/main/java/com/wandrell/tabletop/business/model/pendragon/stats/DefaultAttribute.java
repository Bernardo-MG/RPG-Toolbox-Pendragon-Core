package com.wandrell.tabletop.business.model.pendragon.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.valuehandler.EditableValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.ModularEditableValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.event.ValueHandlerListener;
import com.wandrell.tabletop.business.model.valuehandler.module.generator.GeneratorModule;
import com.wandrell.tabletop.business.model.valuehandler.module.interval.IntervalModule;
import com.wandrell.tabletop.business.model.valuehandler.module.store.AbstractEditableStoreModule;
import com.wandrell.tabletop.business.model.valuehandler.module.validator.ValidatorModule;

public final class DefaultAttribute implements Attribute {

    private final Collection<DerivedAttribute> attributes = new LinkedList<>();
    private final ModularEditableValueHandler  composite;

    public DefaultAttribute(final DefaultAttribute attribute) {
        super();

        checkNotNull(attribute, "Received a null pointer as attribute");

        composite = attribute.composite.createNewInstance();
    }

    public DefaultAttribute(final String name, final GeneratorModule generator,
            final IntervalModule interval,
            final AbstractEditableStoreModule store,
            final ValidatorModule validator) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(generator, "Received a null pointer as generator");
        checkNotNull(interval, "Received a null pointer as interval");
        checkNotNull(store, "Received a null pointer as store");
        checkNotNull(validator, "Received a null pointer as validator");

        composite = new ModularEditableValueHandler(name, generator, interval,
                store, validator);
    }

    @Override
    public final Boolean acceptsValue(final Integer value) {
        return getValueHandler().acceptsValue(value);
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultAttribute other = (DefaultAttribute) obj;
        return Objects.equals(composite, other.composite);
    }

    @Override
    public final Collection<DerivedAttribute> getDerivedAttributes() {
        return Collections
                .unmodifiableCollection(getDerivedAttributesModifiable());
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
    public final int hashCode() {
        return getValueHandler().hashCode();
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
            final Collection<DerivedAttribute> attributes) {
        getDerivedAttributesModifiable().clear();
        for (final DerivedAttribute attribute : attributes) {
            checkNotNull(attribute, "Received a null pointer as attribute");

            getDerivedAttributesModifiable().add(attribute);
        }
    }

    @Override
    public final void setValue(final Integer value) {
        getValueHandler().setValue(value);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", getName())
                .add("value", getValue()).toString();
    }

    private final Collection<DerivedAttribute> getDerivedAttributesModifiable() {
        return attributes;
    }

    private final EditableValueHandler getValueHandler() {
        return composite;
    }

}
