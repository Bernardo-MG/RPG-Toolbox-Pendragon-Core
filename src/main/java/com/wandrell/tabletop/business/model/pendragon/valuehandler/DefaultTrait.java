package com.wandrell.tabletop.business.model.pendragon.valuehandler;

import com.wandrell.tabletop.business.model.valuehandler.EditableValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.ModularEditableValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.event.ValueHandlerListener;
import com.wandrell.tabletop.business.model.valuehandler.module.generator.GeneratorModule;
import com.wandrell.tabletop.business.model.valuehandler.module.interval.IntervalModule;
import com.wandrell.tabletop.business.model.valuehandler.module.store.AbstractEditableStoreModule;
import com.wandrell.tabletop.business.model.valuehandler.module.validator.ValidatorModule;

public final class DefaultTrait implements Trait {

    private final ModularEditableValueHandler composite;
    private final boolean                     goodTrait;
    private Trait                             traitMirror;

    public DefaultTrait(final DefaultTrait vh) {
        super();
        composite = vh.composite.createNewInstance();

        goodTrait = vh.goodTrait;
    }

    public DefaultTrait(final String name, final GeneratorModule generator,
            final IntervalModule interval,
            final AbstractEditableStoreModule store,
            final ValidatorModule validator, final boolean goodTrait) {
        super();

        composite = new ModularEditableValueHandler(name, generator, interval,
                store, validator);

        this.goodTrait = goodTrait;
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
    public final DefaultTrait createNewInstance() {
        return new DefaultTrait(this);
    }

    @Override
    public final void decreaseValue() {
        getValueHandler().decreaseValue();
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
    public final Boolean isGoodTrait() {
        return goodTrait;
    }

    @Override
    public final void removeValueEventListener(
            final ValueHandlerListener listener) {
        getValueHandler().removeValueEventListener(listener);
    }

    public final void setMirrorTrait(final Trait trait) {
        traitMirror = trait;
    }

    @Override
    public final void setValue(final Integer value) {
        getValueHandler().setValue(value);
    }

    @Override
    public final String toString() {
        return getName();
    }

    protected final EditableValueHandler getValueHandler() {
        return composite;
    }

}
