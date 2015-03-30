package com.wandrell.tabletop.pendragon.model.character.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import javax.swing.event.EventListenerList;

import com.wandrell.tabletop.event.ValueChangeEvent;
import com.wandrell.tabletop.event.ValueChangeListener;
import com.wandrell.tabletop.pendragon.model.character.stats.event.AttributesListener;
import com.wandrell.tabletop.valuebox.DefaultValueBox;
import com.wandrell.tabletop.valuebox.ValueBox;

public final class DefaultHumanAttributesHolder implements
        HumanAttributesHolder {

    private final ValueBox          app       = new DefaultValueBox();
    private final AttributesHolder  baseAttributes;
    private final EventListenerList listeners = new EventListenerList();

    {
        app.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireAppearanceChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
    }

    public DefaultHumanAttributesHolder() {
        super();

        baseAttributes = new DefaultAttributesHolder();
    }

    public DefaultHumanAttributesHolder(
            final DefaultHumanAttributesHolder holder) {
        super();

        checkNotNull(holder, "Received a null pointer as attributes holder");

        baseAttributes = holder.baseAttributes.createNewInstance();

        app.setValue(holder.app.getValue());
    }

    @Override
    public final void addAttributesListener(final AttributesListener listener) {
        checkNotNull(listener, "Received a null pointer as listener");

        getListeners().add(AttributesListener.class, listener);

        getBaseAttributes().addAttributesListener(listener);
    }

    @Override
    public final DefaultHumanAttributesHolder createNewInstance() {
        return new DefaultHumanAttributesHolder(this);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultHumanAttributesHolder other = (DefaultHumanAttributesHolder) obj;
        return Objects.equals(baseAttributes, other.baseAttributes)
                && Objects.equals(app, other.app);
    }

    @Override
    public final Integer getAppearance() {
        return app.getValue();
    }

    @Override
    public final Integer getConstitution() {
        return getBaseAttributes().getConstitution();
    }

    @Override
    public final Integer getDexterity() {
        return getBaseAttributes().getDexterity();
    }

    @Override
    public final Integer getSize() {
        return getBaseAttributes().getSize();
    }

    @Override
    public final Integer getStrength() {
        return getBaseAttributes().getStrength();
    }

    @Override
    public final void removeAttributesListener(AttributesListener listener) {
        getListeners().remove(AttributesListener.class, listener);

        getBaseAttributes().removeAttributesListener(listener);
    }

    @Override
    public final void setAppearance(final Integer appearance) {
        app.setValue(appearance);
    }

    @Override
    public final void setConstitution(final Integer constitution) {
        getBaseAttributes().setConstitution(constitution);
    }

    @Override
    public final void setDexterity(final Integer dexterity) {
        getBaseAttributes().setDexterity(dexterity);
    }

    @Override
    public final void setSize(final Integer size) {
        getBaseAttributes().setSize(size);
    }

    @Override
    public final void setStrength(final Integer strength) {
        getBaseAttributes().setStrength(strength);
    }

    private final void fireAppearanceChangedEvent(final ValueChangeEvent event) {
        final AttributesListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(AttributesListener.class);
        for (final AttributesListener l : listnrs) {
            l.appearanceChanged(event);
        }
    }

    private final AttributesHolder getBaseAttributes() {
        return baseAttributes;
    }

    private final EventListenerList getListeners() {
        return listeners;
    }

}
