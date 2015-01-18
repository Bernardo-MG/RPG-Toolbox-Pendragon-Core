package com.wandrell.tabletop.business.model.pendragon.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.valuebox.DefaultEditableValueBox;
import com.wandrell.tabletop.business.model.valuebox.EditableValueBox;
import com.wandrell.tabletop.business.util.event.ValueChangeListener;

public final class DefaultTrait implements Trait {

    private final DefaultEditableValueBox composite;
    private final Boolean                 goodTrait;
    private Trait                         traitMirror;

    public DefaultTrait(final DefaultTrait trait) {
        super();

        checkNotNull(trait, "Received a null pointer as trait");

        composite = trait.composite.createNewInstance();

        goodTrait = trait.goodTrait;
    }

    public DefaultTrait(final Integer value, final Integer lowerLimit,
            final Integer upperLimit, final boolean goodTrait) {
        super();

        checkNotNull(goodTrait, "Received a null pointer as good trait flag");

        composite = new DefaultEditableValueBox(value, lowerLimit, upperLimit);

        this.goodTrait = goodTrait;
    }

    @Override
    public final void
            addValueChangeListener(final ValueChangeListener listener) {
        getValueHandler().addValueChangeListener(listener);
    }

    @Override
    public final DefaultTrait createNewInstance() {
        return new DefaultTrait(this);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultTrait other = (DefaultTrait) obj;
        return Objects.equals(composite, other.composite);
    }

    @Override
    public final Integer getLowerLimit() {
        return getValueHandler().getLowerLimit();
    }

    @Override
    public final Trait getMirrorTrait() {
        return traitMirror;
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
        return Objects.hashCode(composite);
    }

    @Override
    public final Boolean isGoodTrait() {
        return goodTrait;
    }

    @Override
    public final void removeValueChangeListener(
            final ValueChangeListener listener) {
        getValueHandler().removeValueChangeListener(listener);
    }

    @Override
    public final void setLowerLimit(final Integer lowerLimit) {
        getValueHandler().setLowerLimit(lowerLimit);
    }

    public final void setMirrorTrait(final Trait trait) {
        traitMirror = trait;
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
                .add("good", goodTrait).toString();
    }

    protected final EditableValueBox getValueHandler() {
        return composite;
    }

}
