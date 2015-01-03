package com.wandrell.tabletop.business.model.pendragon.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.valuebox.DefaultEditableValueBox;
import com.wandrell.tabletop.business.model.valuebox.EditableValueBox;
import com.wandrell.tabletop.business.model.valuebox.event.ValueBoxListener;

public final class DefaultDirectedTrait implements DirectedTrait {

    private final DefaultEditableValueBox composite;
    private String                        descriptor = "";
    private final String                  name;
    private Trait                         trait;

    public DefaultDirectedTrait(final DefaultDirectedTrait trait) {
        super();

        checkNotNull(trait, "Received a null pointer as trait");

        name = trait.name;

        composite = trait.composite.createNewInstance();

        descriptor = trait.descriptor;
    }

    public DefaultDirectedTrait(final String name, final Integer value,
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
    public final DefaultDirectedTrait createNewInstance() {
        return new DefaultDirectedTrait(this);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultDirectedTrait other = (DefaultDirectedTrait) obj;
        return Objects.equals(composite, other.composite)
                && Objects.equals(descriptor, other.descriptor)
                && Objects.equals(trait, other.trait);
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
    public final Trait getTrait() {
        return trait;
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
        return Objects.hash(composite, descriptor, trait);
    }

    @Override
    public final Boolean isDescribed() {
        return true;
    }

    @Override
    public final void removeValueEventListener(final ValueBoxListener listener) {
        getValueHandler().removeValueEventListener(listener);
    }

    @Override
    public final void setDescriptor(final String descriptor) {
        if (descriptor == null) {
            throw new NullPointerException();
        }

        this.descriptor = descriptor;
    }

    @Override
    public final void setLowerLimit(final Integer lowerLimit) {
        getValueHandler().setLowerLimit(lowerLimit);
    }

    public final void setTrait(final Trait trait) {
        checkNotNull(trait, "Received a null pointer as trait");

        this.trait = trait;
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
                .add("descriptor", descriptor).add("value", getValue())
                .toString();
    }

    private final EditableValueBox getValueHandler() {
        return composite;
    }

}
