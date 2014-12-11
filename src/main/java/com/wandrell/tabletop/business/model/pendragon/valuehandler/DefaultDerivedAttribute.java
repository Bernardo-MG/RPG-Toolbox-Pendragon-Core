package com.wandrell.tabletop.business.model.pendragon.valuehandler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.valuehandler.ModularDerivedValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.ValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.event.ValueHandlerListener;
import com.wandrell.tabletop.business.model.valuehandler.module.store.StoreModule;

public final class DefaultDerivedAttribute implements DerivedAttribute {

    private final Collection<Attribute>      attributes = new LinkedList<>();
    private final ModularDerivedValueHandler composite;

    public DefaultDerivedAttribute(final DefaultDerivedAttribute attribute) {
        super();

        checkNotNull(attribute, "Received a null pointer as attribute");

        composite = attribute.composite.createNewInstance();
    }

    public DefaultDerivedAttribute(final String name, final StoreModule store) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(store, "Received a null pointer as store");

        composite = new ModularDerivedValueHandler(name, store);
    }

    @Override
    public final void
            addValueEventListener(final ValueHandlerListener listener) {
        getValueHandler().addValueEventListener(listener);
    }

    @Override
    public final DefaultDerivedAttribute createNewInstance() {
        return new DefaultDerivedAttribute(this);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultDerivedAttribute other = (DefaultDerivedAttribute) obj;
        return Objects.equals(composite, other.composite);
    }

    @Override
    public final String getName() {
        return getValueHandler().getName();
    }

    @Override
    public final Collection<Attribute> getParentAttributes() {
        return Collections
                .unmodifiableCollection(getParentAttributesModifiable());
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
    public final void removeValueEventListener(
            final ValueHandlerListener listener) {
        getValueHandler().removeValueEventListener(listener);
    }

    public final void
            setParentAttributes(final Collection<Attribute> attributes) {
        getParentAttributesModifiable().clear();
        for (final Attribute attribute : attributes) {
            checkNotNull(attribute, "Received a null pointer as attribute");

            getParentAttributesModifiable().add(attribute);
        }
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", getName())
                .add("value", getValue()).toString();
    }

    private final Collection<Attribute> getParentAttributesModifiable() {
        return attributes;
    }

    private final ValueHandler getValueHandler() {
        return composite;
    }

}
