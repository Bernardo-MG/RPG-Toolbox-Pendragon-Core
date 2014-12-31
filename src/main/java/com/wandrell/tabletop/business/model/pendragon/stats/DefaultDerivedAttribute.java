package com.wandrell.tabletop.business.model.pendragon.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.valuebox.ValueBox;
import com.wandrell.tabletop.business.model.valuebox.derived.DerivedValueBox;
import com.wandrell.tabletop.business.model.valuebox.derived.DerivedValueViewPoint;
import com.wandrell.tabletop.business.model.valuebox.event.ValueBoxListener;

public final class DefaultDerivedAttribute implements DerivedAttribute {

    private final Collection<Attribute> attributes = new LinkedList<>();
    private final DerivedValueBox       composite;

    public DefaultDerivedAttribute(final DefaultDerivedAttribute attribute) {
        super();

        checkNotNull(attribute, "Received a null pointer as attribute");

        composite = new DerivedValueBox(attribute.composite.getViewPoint());
    }

    public DefaultDerivedAttribute(final String name,
            final DerivedValueViewPoint view) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(view, "Received a null pointer as view point");

        composite = new DerivedValueBox(view);
    }

    @Override
    public final void addValueEventListener(final ValueBoxListener listener) {
        getValueHandler().addValueEventListener(listener);
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
    public final void removeValueEventListener(final ValueBoxListener listener) {
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
        return MoreObjects.toStringHelper(this).add("value", getValue())
                .toString();
    }

    private final Collection<Attribute> getParentAttributesModifiable() {
        return attributes;
    }

    private final ValueBox getValueHandler() {
        return composite;
    }

}
