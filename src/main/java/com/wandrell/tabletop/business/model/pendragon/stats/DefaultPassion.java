package com.wandrell.tabletop.business.model.pendragon.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.valuebox.DefaultEditableValueBox;
import com.wandrell.tabletop.business.model.valuebox.EditableValueBox;
import com.wandrell.tabletop.business.model.valuebox.event.ValueBoxListener;

public final class DefaultPassion implements Passion {

    private final DefaultEditableValueBox composite;
    private String                        descriptor = "";
    private final String                  name;

    public DefaultPassion(final DefaultPassion passion) {
        super();

        checkNotNull(passion, "Received a null pointer as passion");

        name = passion.name;

        composite = passion.composite.createNewInstance();

        descriptor = passion.descriptor;
    }

    public DefaultPassion(final String name, final Integer value,
            final Integer lowerLimit, final Integer upperLimit) {
        super();

        checkNotNull(name, "Received a null pointer as name");

        this.name = name;

        composite = new DefaultEditableValueBox(value, lowerLimit, upperLimit);
    }

    @Override
    public final void addValueEventListener(final ValueBoxListener listener) {
        getValueHandler().addValueEventListener(listener);
    }

    @Override
    public final DefaultPassion createNewInstance() {
        return new DefaultPassion(this);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultPassion other = (DefaultPassion) obj;
        return Objects.equals(composite, other.composite)
                && Objects.equals(descriptor, other.descriptor);
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
        return name;
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
        return Objects.hash(composite, descriptor);
    }

    @Override
    public final Boolean isDescribed() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public final void removeValueEventListener(final ValueBoxListener listener) {
        getValueHandler().removeValueEventListener(listener);
    }

    @Override
    public final void setDescriptor(final String descriptor) {
        checkNotNull(descriptor, "Received a null pointer as descriptor");

        this.descriptor = descriptor;
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
        return MoreObjects.toStringHelper(this).add("name", name)
                .add("descriptor", getDescriptor()).add("value", getValue())
                .toString();
    }

    private final EditableValueBox getValueHandler() {
        return composite;
    }

}
