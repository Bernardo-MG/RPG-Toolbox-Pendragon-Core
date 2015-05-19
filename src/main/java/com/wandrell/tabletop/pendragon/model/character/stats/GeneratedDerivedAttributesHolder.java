package com.wandrell.tabletop.pendragon.model.character.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import javax.swing.event.EventListenerList;

import com.wandrell.tabletop.pendragon.model.character.DerivedAttributeBuilder;
import com.wandrell.tabletop.pendragon.model.character.stats.event.DerivedAttributesListener;
import com.wandrell.tabletop.stat.event.ValueChangeEvent;
import com.wandrell.tabletop.stat.event.ValueChangeListener;
import com.wandrell.tabletop.stat.valuebox.ValueBox;

public final class GeneratedDerivedAttributesHolder implements
        DerivedAttributesHolder {

    private AttributesHolder              attributesHolder;
    private ValueBox                      damage;
    private final DerivedAttributeBuilder derivedBuilder;
    private ValueBox                      dexterityRoll;
    private ValueBox                      healingRate;
    private ValueBox                      hitPoints;
    private ValueBox                      knockdown;
    private final EventListenerList       listeners = new EventListenerList();
    private ValueBox                      majorWoundTreshold;
    private ValueBox                      moveRate;
    private ValueBox                      unconciousTreshold;
    private ValueBox                      weight;

    public GeneratedDerivedAttributesHolder(final AttributesHolder attributes,
            final DerivedAttributeBuilder derivedAttributeBuilder) {
        super();

        derivedBuilder = derivedAttributeBuilder;

        setAttributesHolder(attributes);
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
        GeneratedDerivedAttributesHolder other = (GeneratedDerivedAttributesHolder) obj;
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
    public final void setAttributesHolder(final AttributesHolder attributes) {
        damage = derivedBuilder.getDamage(attributesHolder, this);
        dexterityRoll = derivedBuilder.getDexterityRoll(attributesHolder, this);
        healingRate = derivedBuilder.getHealingRate(attributesHolder, this);
        hitPoints = derivedBuilder.getHitPoints(attributesHolder, this);
        knockdown = derivedBuilder.getKnockdown(attributesHolder, this);
        majorWoundTreshold = derivedBuilder.getMajorWoundTreshold(
                attributesHolder, this);
        moveRate = derivedBuilder.getMoveRate(attributesHolder, this);
        unconciousTreshold = derivedBuilder.getUnconciousTreshold(
                attributesHolder, this);
        weight = derivedBuilder.getWeight(attributesHolder, this);

        setDerivedAttributesListeners();
    }

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
