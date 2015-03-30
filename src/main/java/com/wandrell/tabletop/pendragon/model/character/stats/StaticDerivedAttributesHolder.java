package com.wandrell.tabletop.pendragon.model.character.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import javax.swing.event.EventListenerList;

import com.wandrell.tabletop.event.ValueChangeEvent;
import com.wandrell.tabletop.event.ValueChangeListener;
import com.wandrell.tabletop.pendragon.model.character.stats.event.DerivedAttributesListener;
import com.wandrell.tabletop.valuebox.DefaultValueBox;
import com.wandrell.tabletop.valuebox.ValueBox;

public final class StaticDerivedAttributesHolder implements
        DerivedAttributesHolder {

    private ValueBox                damage             = new DefaultValueBox();
    private ValueBox                dexterityRoll      = new DefaultValueBox();
    private ValueBox                healingRate        = new DefaultValueBox();
    private ValueBox                hitPoints          = new DefaultValueBox();
    private ValueBox                knockdown          = new DefaultValueBox();
    private final EventListenerList listeners          = new EventListenerList();
    private ValueBox                majorWoundTreshold = new DefaultValueBox();
    private ValueBox                moveRate           = new DefaultValueBox();
    private ValueBox                unconciousTreshold = new DefaultValueBox();
    private ValueBox                weight             = new DefaultValueBox();

    {
        setDerivedAttributesListeners();
    }

    public StaticDerivedAttributesHolder(final Integer damage,
            final Integer dexterityRoll, final Integer healingRate,
            final Integer hitPoints, final Integer knockdown,
            final Integer majorWoundTreshold, final Integer moveRate,
            final Integer unconciousTreshold, final Integer weight) {
        super();

        this.damage = new DefaultValueBox(damage);
        this.dexterityRoll = new DefaultValueBox(dexterityRoll);
        this.healingRate = new DefaultValueBox(healingRate);
        this.hitPoints = new DefaultValueBox(hitPoints);
        this.knockdown = new DefaultValueBox(knockdown);
        this.majorWoundTreshold = new DefaultValueBox(majorWoundTreshold);
        this.moveRate = new DefaultValueBox(moveRate);
        this.unconciousTreshold = new DefaultValueBox(unconciousTreshold);
        this.weight = new DefaultValueBox(weight);
    }

    @Override
    public final void addDerivedAttributesListener(
            final DerivedAttributesListener listener) {
        checkNotNull(listener, "Received a null pointer as listener");

        getListeners().add(DerivedAttributesListener.class, listener);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StaticDerivedAttributesHolder other = (StaticDerivedAttributesHolder) obj;
        return Objects.equals(damage, other.damage)
                && Objects.equals(dexterityRoll, other.dexterityRoll)
                && Objects.equals(healingRate, other.healingRate)
                && Objects.equals(hitPoints, other.hitPoints)
                && Objects.equals(knockdown, other.knockdown)
                && Objects.equals(majorWoundTreshold, other.majorWoundTreshold)
                && Objects.equals(moveRate, other.moveRate)
                && Objects.equals(unconciousTreshold, other.unconciousTreshold)
                && Objects.equals(weight, other.weight);
    }

    @Override
    public final Integer getDamage() {
        return damage.getValue();
    }

    @Override
    public final Integer getDexterityRoll() {
        return dexterityRoll.getValue();
    }

    @Override
    public final Integer getHealingRate() {
        return healingRate.getValue();
    }

    @Override
    public final Integer getHitPoints() {
        return hitPoints.getValue();
    }

    @Override
    public final Integer getKnockdown() {
        return knockdown.getValue();
    }

    @Override
    public final Integer getMajorWoundTreshold() {
        return majorWoundTreshold.getValue();
    }

    @Override
    public final Integer getMoveRate() {
        return moveRate.getValue();
    }

    @Override
    public final Integer getUnconciousTreshold() {
        return unconciousTreshold.getValue();
    }

    @Override
    public final Integer getWeight() {
        return weight.getValue();
    }

    @Override
    public final void removeDerivedAttributesListener(
            final DerivedAttributesListener listener) {
        getListeners().remove(DerivedAttributesListener.class, listener);
    }

    @Override
    public final void setAttributesHolder(final AttributesHolder attributes) {}

    private final void fireDamageChangedEvent(final ValueChangeEvent event) {
        final DerivedAttributesListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(DerivedAttributesListener.class);
        for (final DerivedAttributesListener l : listnrs) {
            l.damageChanged(event);
        }
    }

    private final void fireDexterityRollChangedEvent(
            final ValueChangeEvent event) {
        final DerivedAttributesListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(DerivedAttributesListener.class);
        for (final DerivedAttributesListener l : listnrs) {
            l.dexterityRollChanged(event);
        }
    }

    private final void
            fireHealingRateChangedEvent(final ValueChangeEvent event) {
        final DerivedAttributesListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(DerivedAttributesListener.class);
        for (final DerivedAttributesListener l : listnrs) {
            l.healingRateChanged(event);
        }
    }

    private final void fireHitPointsChangedEvent(final ValueChangeEvent event) {
        final DerivedAttributesListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(DerivedAttributesListener.class);
        for (final DerivedAttributesListener l : listnrs) {
            l.hitPointsChanged(event);
        }
    }

    private final void fireKnockdownChangedEvent(final ValueChangeEvent event) {
        final DerivedAttributesListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(DerivedAttributesListener.class);
        for (final DerivedAttributesListener l : listnrs) {
            l.knockdownChanged(event);
        }
    }

    private final void fireMajorWoundChangedEvent(final ValueChangeEvent event) {
        final DerivedAttributesListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(DerivedAttributesListener.class);
        for (final DerivedAttributesListener l : listnrs) {
            l.majorWoundChanged(event);
        }
    }

    private final void fireMoveRateChangedEvent(final ValueChangeEvent event) {
        final DerivedAttributesListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(DerivedAttributesListener.class);
        for (final DerivedAttributesListener l : listnrs) {
            l.moveRateChanged(event);
        }
    }

    private final void fireUnconciousChangedEvent(final ValueChangeEvent event) {
        final DerivedAttributesListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(DerivedAttributesListener.class);
        for (final DerivedAttributesListener l : listnrs) {
            l.unconciousChanged(event);
        }
    }

    private final void fireWeightChangedEvent(final ValueChangeEvent event) {
        final DerivedAttributesListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(DerivedAttributesListener.class);
        for (final DerivedAttributesListener l : listnrs) {
            l.weightChanged(event);
        }
    }

    private final EventListenerList getListeners() {
        return listeners;
    }

    private final void setDerivedAttributesListeners() {
        damage.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireDamageChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
        dexterityRoll.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireDexterityRollChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
        healingRate.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireHealingRateChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
        hitPoints.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireHitPointsChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
        knockdown.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireKnockdownChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
        majorWoundTreshold.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireMajorWoundChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
        moveRate.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireMoveRateChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
        unconciousTreshold.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireUnconciousChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
        weight.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireWeightChangedEvent(new ValueChangeEvent(this, event
                        .getOldValue(), event.getNewValue()));
            }

        });
    }

}
