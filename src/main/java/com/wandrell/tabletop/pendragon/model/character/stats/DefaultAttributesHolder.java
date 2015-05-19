package com.wandrell.tabletop.pendragon.model.character.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import javax.swing.event.EventListenerList;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.pendragon.model.character.stats.event.AttributesListener;
import com.wandrell.tabletop.stat.event.ValueChangeEvent;
import com.wandrell.tabletop.stat.event.ValueChangeListener;
import com.wandrell.tabletop.stat.valuebox.DefaultValueBox;
import com.wandrell.tabletop.stat.valuebox.ValueBox;

public final class DefaultAttributesHolder implements AttributesHolder {

    private final ValueBox          appearance   = new DefaultValueBox();
    private final ValueBox          constitution = new DefaultValueBox();
    private final ValueBox          dexterity    = new DefaultValueBox();
    private final EventListenerList listeners    = new EventListenerList();
    private final ValueBox          size         = new DefaultValueBox();
    private final ValueBox          strength     = new DefaultValueBox();

    {
        setAttributesListeners();
    }

    public DefaultAttributesHolder() {
        super();
    }

    public DefaultAttributesHolder(final DefaultAttributesHolder holder) {
        super();

        checkNotNull(holder, "Received a null pointer as attributes holder");

        appearance.setValue(holder.appearance.getValue());
        constitution.setValue(holder.constitution.getValue());
        dexterity.setValue(holder.dexterity.getValue());
        size.setValue(holder.constitution.getValue());
        strength.setValue(holder.strength.getValue());
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
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultAttributesHolder other = (DefaultAttributesHolder) obj;
        return Objects.equals(appearance, other.appearance)
                && Objects.equals(constitution, other.constitution)
                && Objects.equals(dexterity, other.dexterity)
                && Objects.equals(size, other.size)
                && Objects.equals(strength, other.strength);
    }

    @Override
    public final Integer getAppearance() {
        return appearance.getValue();
    }

    @Override
    public final Integer getConstitution() {
        return constitution.getValue();
    }

    @Override
    public final Integer getDexterity() {
        return dexterity.getValue();
    }

    @Override
    public final Integer getSize() {
        return size.getValue();
    }

    @Override
    public final Integer getStrength() {
        return strength.getValue();
    }

    @Override
    public final int hashCode() {
        return Objects
                .hash(appearance, constitution, dexterity, size, strength);
    }

    @Override
    public final void
            removeAttributesListener(final AttributesListener listener) {
        getListeners().remove(AttributesListener.class, listener);
    }

    @Override
    public final void setAppearance(final Integer appearance) {
        this.appearance.setValue(appearance);
    }

    @Override
    public final void setConstitution(final Integer constitution) {
        this.constitution.setValue(constitution);
    }

    @Override
    public final void setDexterity(final Integer dexterity) {
        this.dexterity.setValue(dexterity);
    }

    @Override
    public final void setSize(final Integer size) {
        this.size.setValue(size);
    }

    @Override
    public final void setStrength(final Integer strength) {
        this.strength.setValue(strength);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("appearance", appearance.getValue())
                .add("constitution", constitution.getValue())
                .add("dexterity", dexterity.getValue())
                .add("size", size.getValue())
                .add("strength", strength.getValue()).toString();
    }

    private final void fireAppearanceChangedEvent(final ValueChangeEvent event) {
        final AttributesListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(AttributesListener.class);
        for (final AttributesListener l : listnrs) {
            l.appearanceChanged(event);
        }
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
        appearance.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireAppearanceChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
        constitution.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireConstitutionChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
        dexterity.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireDexterityChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
        size.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireSizeChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
        strength.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireStrengthChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
    }

}
