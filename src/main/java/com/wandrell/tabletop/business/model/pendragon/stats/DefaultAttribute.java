package com.wandrell.tabletop.business.model.pendragon.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.valuebox.DefaultEditableValueBox;
import com.wandrell.tabletop.business.model.valuebox.EditableValueBox;
import com.wandrell.tabletop.business.model.valuebox.event.ValueBoxListener;

public final class DefaultAttribute implements Attribute {

    private final Collection<DerivedAttribute> attributes = new LinkedList<>();
    private final DefaultEditableValueBox      composite;

    public DefaultAttribute(final DefaultAttribute attribute) {
        super();

        checkNotNull(attribute, "Received a null pointer as attribute");

        composite = attribute.composite.createNewInstance();
    }

    public DefaultAttribute(final Integer value, final Integer lowerLimit,
            final Integer upperLimit) {
        super();

        composite = new DefaultEditableValueBox(value, lowerLimit, upperLimit);
    }

    @Override
    public final void addValueEventListener(final ValueBoxListener listener) {
        getValueHandler().addValueEventListener(listener);
    }

    @Override
    public final DefaultAttribute createNewInstance() {
        return new DefaultAttribute(this);
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
    public final void removeValueEventListener(final ValueBoxListener listener) {
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
    public final void setLowerLimit(final Integer lowerLimit) {
        getValueHandler().setLowerLimit(lowerLimit);
    }

    @Override
    public final void setUpperLimit(final Integer upperLimit) {
        getValueHandler().setUpperLimit(upperLimit);
    }

    @Override
    public final void setValue(final Integer value) {
        getValueHandler().setValue(value);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("value", getValue())
                .toString();
    }

    private final Collection<DerivedAttribute> getDerivedAttributesModifiable() {
        return attributes;
    }

    private final EditableValueBox getValueHandler() {
        return composite;
    }

}
