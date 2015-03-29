package com.wandrell.tabletop.pendragon.model.character.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.swing.event.EventListenerList;

import com.wandrell.tabletop.event.ValueChangeEvent;
import com.wandrell.tabletop.event.ValueChangeListener;
import com.wandrell.tabletop.pendragon.model.character.stats.event.AttributesListener;
import com.wandrell.tabletop.valuebox.DefaultValueBox;
import com.wandrell.tabletop.valuebox.ValueBox;

public final class DefaultAttributesHolder implements AttributesHolder {

    private final ValueBox          con       = new DefaultValueBox();
    private final ValueBox          dex       = new DefaultValueBox();
    private final EventListenerList listeners = new EventListenerList();
    private final ValueBox          siz       = new DefaultValueBox();
    private final ValueBox          str       = new DefaultValueBox();

    {
        setAttributesListeners();
    }

    public DefaultAttributesHolder() {
        super();
    }

    public DefaultAttributesHolder(final DefaultAttributesHolder holder) {
        super();

        checkNotNull(holder, "Received a null pointer as attributes holder");

        con.setValue(holder.con.getValue());
        dex.setValue(holder.dex.getValue());
        siz.setValue(holder.con.getValue());
        str.setValue(holder.str.getValue());
    }

    @Override
    public final void addAttributesListener(final AttributesListener listener) {
        checkNotNull(listener, "Received a null pointer as listener");

        getListeners().add(AttributesListener.class, listener);
    }

    @Override
    public final DefaultAttributesHolder createNewInstance() {
        return new DefaultAttributesHolder(this);
    }

    @Override
    public final Integer getConstitution() {
        return con.getValue();
    }

    @Override
    public final Integer getDexterity() {
        return dex.getValue();
    }

    @Override
    public final Integer getSize() {
        return siz.getValue();
    }

    @Override
    public final Integer getStrength() {
        return str.getValue();
    }

    @Override
    public final void
            removeAttributesListener(final AttributesListener listener) {
        getListeners().remove(AttributesListener.class, listener);
    }

    @Override
    public final void setConstitution(final Integer constitution) {
        con.setValue(constitution);
    }

    @Override
    public final void setDexterity(final Integer dexterity) {
        dex.setValue(dexterity);
    }

    @Override
    public final void setSize(final Integer size) {
        siz.setValue(size);
    }

    @Override
    public final void setStrength(final Integer strength) {
        str.setValue(strength);
    }

    private final void
            fireConstitutionChangedEvent(final ValueChangeEvent event) {
        final AttributesListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(AttributesListener.class);
        for (final AttributesListener l : listnrs) {
            l.constitutionChanged(event);
        }
    }

    private final void fireDexterityChangedEvent(final ValueChangeEvent event) {
        final AttributesListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(AttributesListener.class);
        for (final AttributesListener l : listnrs) {
            l.dexterityChanged(event);
        }
    }

    private final void fireSizeChangedEvent(final ValueChangeEvent event) {
        final AttributesListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(AttributesListener.class);
        for (final AttributesListener l : listnrs) {
            l.sizeChanged(event);
        }
    }

    private final void fireStrengthChangedEvent(final ValueChangeEvent event) {
        final AttributesListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(AttributesListener.class);
        for (final AttributesListener l : listnrs) {
            l.strengthChanged(event);
        }
    }

    private final EventListenerList getListeners() {
        return listeners;
    }

    private final void setAttributesListeners() {
        con.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireConstitutionChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
        dex.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireDexterityChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
        siz.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireSizeChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
        str.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireStrengthChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
    }

}
