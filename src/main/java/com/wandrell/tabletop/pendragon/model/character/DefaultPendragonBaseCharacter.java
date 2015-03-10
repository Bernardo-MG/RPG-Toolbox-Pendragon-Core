package com.wandrell.tabletop.pendragon.model.character;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import javax.swing.event.EventListenerList;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.event.ValueChangeEvent;
import com.wandrell.tabletop.event.ValueChangeListener;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonCharacterListener;
import com.wandrell.tabletop.valuebox.DefaultEditableValueBox;
import com.wandrell.tabletop.valuebox.EditableValueBox;
import com.wandrell.tabletop.valuebox.ValueBox;

public final class DefaultPendragonBaseCharacter implements
        PendragonBaseCharacter {

    private final EditableValueBox        constitution;
    private final ValueBox                damage;
    private final DerivedAttributeBuilder derivedBuilder;
    private final EditableValueBox        dexterity;
    private final ValueBox                dexterityRoll;
    private final ValueBox                healingRate;
    private final ValueBox                hitPoints;
    private final EventListenerList       listeners = new EventListenerList();
    private final ValueBox                majorWoundTreshold;
    private final ValueBox                movementRate;
    private final String                  name;
    private final EditableValueBox        size;
    private final EditableValueBox        strength;
    private final ValueBox                unconsciousTreshold;
    private final ValueBox                weight;

    public DefaultPendragonBaseCharacter(
            final DefaultPendragonBaseCharacter character) {
        super();

        checkNotNull(character, "Received a null pointer as character");

        name = character.name;

        constitution = character.getConstitutionValueBox().createNewInstance();
        dexterity = character.getDexterityValueBox().createNewInstance();
        size = character.getSizeValueBox().createNewInstance();
        strength = character.getStrengthValueBox().createNewInstance();

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

        derivedBuilder = character.derivedBuilder;

        this.damage = derivedBuilder.getDamage(this);
        this.dexterityRoll = derivedBuilder.getDexterityRoll(this);
        this.healingRate = derivedBuilder.getHealingRate(this);
        this.hitPoints = derivedBuilder.getHitPoints(this);
        this.majorWoundTreshold = derivedBuilder.getMajorWoundTreshold(this);
        this.movementRate = derivedBuilder.getMoveRate(this);
        this.unconsciousTreshold = derivedBuilder.getUnconciousTreshold(this);
        this.weight = derivedBuilder.getWeight(this);
    }

    public DefaultPendragonBaseCharacter(final String name,
            final DerivedAttributeBuilder derivedAttributeBuilder) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(derivedAttributeBuilder,
                "Received a null pointer as derived attributes builder");

        this.name = name;

        // TODO: Maybe the attributes limits should be configurable
        constitution = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        dexterity = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        size = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);
        strength = new DefaultEditableValueBox(0, 0, Integer.MAX_VALUE);

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

        derivedBuilder = derivedAttributeBuilder;

        this.damage = derivedAttributeBuilder.getDamage(this);
        this.dexterityRoll = derivedAttributeBuilder.getDexterityRoll(this);
        this.healingRate = derivedAttributeBuilder.getHealingRate(this);
        this.hitPoints = derivedAttributeBuilder.getHitPoints(this);
        this.majorWoundTreshold = derivedAttributeBuilder
                .getMajorWoundTreshold(this);
        this.movementRate = derivedAttributeBuilder.getMoveRate(this);
        this.unconsciousTreshold = derivedAttributeBuilder
                .getUnconciousTreshold(this);
        this.weight = derivedAttributeBuilder.getWeight(this);
    }

    @Override
    public final void addPendragonCharacterListener(
            final PendragonCharacterListener listener) {
        checkNotNull(listener, "Received a null pointer as listener");

        getListeners().add(PendragonCharacterListener.class, listener);
    }

    @Override
    public final DefaultPendragonBaseCharacter createNewInstance() {
        return new DefaultPendragonBaseCharacter(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultPendragonBaseCharacter other = (DefaultPendragonBaseCharacter) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public final Integer getConstitution() {
        return getConstitutionValueBox().getValue();
    }

    @Override
    public final Integer getDamage() {
        return damage.getValue();
    }

    @Override
    public final Integer getDexterity() {
        return getDexterityValueBox().getValue();
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
    public final Integer getMajorWoundTreshold() {
        return majorWoundTreshold.getValue();
    }

    @Override
    public final Integer getMoveRate() {
        return movementRate.getValue();
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Integer getSize() {
        return getSizeValueBox().getValue();
    }

    @Override
    public final Integer getStrength() {
        return getStrengthValueBox().getValue();
    }

    @Override
    public final Integer getUnconciousTreshold() {
        return unconsciousTreshold.getValue();
    }

    @Override
    public final Integer getWeight() {
        return weight.getValue();
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final void removePendragonCharacterListener(
            final PendragonCharacterListener listener) {
        checkNotNull(listener, "Received a null pointer as listener");

        getListeners().remove(PendragonCharacterListener.class, listener);
    }

    @Override
    public final void setConstitution(final Integer constitution) {
        getConstitutionValueBox().setValue(constitution);
    }

    @Override
    public final void setDexterity(final Integer dexterity) {
        getDexterityValueBox().setValue(dexterity);
    }

    @Override
    public final void setSize(final Integer size) {
        getSizeValueBox().setValue(size);
    }

    @Override
    public final void setStrength(final Integer strength) {
        getStrengthValueBox().setValue(strength);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

    private final EditableValueBox getConstitutionValueBox() {
        return constitution;
    }

    private final EditableValueBox getDexterityValueBox() {
        return dexterity;
    }

    private final EditableValueBox getSizeValueBox() {
        return size;
    }

    private final EditableValueBox getStrengthValueBox() {
        return strength;
    }

    protected final void fireConstitutionChangedEvent(
            final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.constitutionChanged(event);
        }
    }

    protected final void
            fireDexterityChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.dexterityChanged(event);
        }
    }

    protected final void fireSizeChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.sizeChanged(event);
        }
    }

    protected final void fireStrengthChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.strengthChanged(event);
        }
    }

    protected final EventListenerList getListeners() {
        return listeners;
    }

}
