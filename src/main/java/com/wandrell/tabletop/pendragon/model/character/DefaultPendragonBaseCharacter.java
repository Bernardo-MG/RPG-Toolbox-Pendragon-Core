package com.wandrell.tabletop.pendragon.model.character;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;

import javax.swing.event.EventListenerList;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.event.ValueChangeEvent;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonCharacterListener;
import com.wandrell.tabletop.pendragon.model.character.stats.AttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.DefaultAttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.DerivedAttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.GeneratedDerivedAttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.PendragonSkillBox;
import com.wandrell.tabletop.pendragon.model.character.stats.event.AttributesListener;
import com.wandrell.tabletop.pendragon.model.character.stats.event.DerivedAttributesListener;

public final class DefaultPendragonBaseCharacter implements
        PendragonBaseCharacter {

    private final AttributesHolder              attributes;
    private final DerivedAttributesHolder       derived;
    private final DerivedAttributeBuilder       derivedBuilder;
    private final EventListenerList             listeners = new EventListenerList();
    private final String                        name;
    private final Collection<PendragonSkillBox> skills    = new LinkedHashSet<PendragonSkillBox>();

    public DefaultPendragonBaseCharacter(
            final DefaultPendragonBaseCharacter character) {
        super();

        checkNotNull(character, "Received a null pointer as character");

        name = character.name;

        attributes = character.attributes.createNewInstance();

        setAttributesListeners();

        derivedBuilder = character.derivedBuilder;

        derived = new GeneratedDerivedAttributesHolder(attributes,
                derivedBuilder);
        setDerivedAttributesListener();

        for (final PendragonSkillBox skill : character.skills) {
            skills.add(skill.createNewInstance());
        }
    }

    public DefaultPendragonBaseCharacter(final String name,
            final AttributesHolder attributes,
            final DerivedAttributeBuilder derivedAttributeBuilder) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(derivedAttributeBuilder,
                "Received a null pointer as derived attributes builder");

        this.name = name;

        this.attributes = attributes;

        setAttributesListeners();

        derivedBuilder = derivedAttributeBuilder;

        derived = new GeneratedDerivedAttributesHolder(attributes,
                derivedAttributeBuilder);
        setDerivedAttributesListener();
    }

    public DefaultPendragonBaseCharacter(final String name,
            final DerivedAttributeBuilder derivedAttributeBuilder) {
        this(name, new DefaultAttributesHolder(), derivedAttributeBuilder);
    }

    @Override
    public final void addPendragonCharacterListener(
            final PendragonCharacterListener listener) {
        checkNotNull(listener, "Received a null pointer as listener");

        getListeners().add(PendragonCharacterListener.class, listener);
    }

    @Override
    public final void addSkill(final PendragonSkillBox skill) {
        checkNotNull(skill, "Received a null pointer as skill");

        getSkillsModifiable().add(skill);
    }

    @Override
    public final void clearSkills() {
        getSkillsModifiable().clear();
    }

    @Override
    public final DefaultPendragonBaseCharacter createNewInstance() {
        return new DefaultPendragonBaseCharacter(this);
    }

    @Override
    public final boolean equals(Object obj) {
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
    public final AttributesHolder getAttributes() {
        return attributes;
    }

    @Override
    public final DerivedAttributesHolder getDerivedAttributes() {
        return derived;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Collection<PendragonSkillBox> getSkills() {
        return Collections.unmodifiableCollection(getSkillsModifiable());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final void removePendragonCharacterListener(
            final PendragonCharacterListener listener) {
        getListeners().remove(PendragonCharacterListener.class, listener);
    }

    @Override
    public final void removeSkill(final PendragonSkillBox skill) {
        getSkillsModifiable().remove(skill);
    }

    @Override
    public final void setSkills(final Collection<PendragonSkillBox> skills) {
        checkNotNull(skills, "Received a null pointer as skills");

        getSkillsModifiable().clear();

        for (final PendragonSkillBox skill : skills) {
            getSkillsModifiable().add(skill);
        }
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

    private final void fireAppearanceChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.appearanceChanged(event);
        }
    }

    private final void
            fireConstitutionChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.constitutionChanged(event);
        }
    }

    private final void fireDamageChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.damageChanged(event);
        }
    }

    private final void fireDexterityChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.dexterityChanged(event);
        }
    }

    private final void fireDexterityRollChangedEvent(
            final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.dexterityRollChanged(event);
        }
    }

    private final void
            fireHealingRateChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.healingRateChanged(event);
        }
    }

    private final void fireHitPointsChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.hitPointsChanged(event);
        }
    }

    private final void fireKnockdownChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.knockdownChanged(event);
        }
    }

    private final void fireMajorWoundChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.majorWoundChanged(event);
        }
    }

    private final void fireMoveRateChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.moveRateChanged(event);
        }
    }

    private final void fireSizeChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.sizeChanged(event);
        }
    }

    private final void fireStrengthChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.strengthChanged(event);
        }
    }

    private final void fireUnconciousChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.unconciousChanged(event);
        }
    }

    private final void fireWeightChangedEvent(final ValueChangeEvent event) {
        final PendragonCharacterListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(PendragonCharacterListener.class);
        for (final PendragonCharacterListener l : listnrs) {
            l.weightChanged(event);
        }
    }

    private final EventListenerList getListeners() {
        return listeners;
    }

    private final Collection<PendragonSkillBox> getSkillsModifiable() {
        return skills;
    }

    private final void setAttributesListeners() {
        final PendragonBaseCharacter character = this;

        getAttributes().addAttributesListener(new AttributesListener() {

            @Override
            public final void appearanceChanged(final ValueChangeEvent event) {
                fireAppearanceChangedEvent(new ValueChangeEvent(character,
                        event.getOldValue(), event.getNewValue()));
            }

            @Override
            public final void constitutionChanged(final ValueChangeEvent event) {
                fireConstitutionChangedEvent(new ValueChangeEvent(character,
                        event.getOldValue(), event.getNewValue()));
            }

            @Override
            public final void dexterityChanged(final ValueChangeEvent event) {
                fireDexterityChangedEvent(new ValueChangeEvent(character, event
                        .getOldValue(), event.getNewValue()));
            }

            @Override
            public final void sizeChanged(final ValueChangeEvent event) {
                fireSizeChangedEvent(new ValueChangeEvent(character, event
                        .getOldValue(), event.getNewValue()));
            }

            @Override
            public final void strengthChanged(final ValueChangeEvent event) {
                fireStrengthChangedEvent(new ValueChangeEvent(character, event
                        .getOldValue(), event.getNewValue()));
            }

        });
    }

    private final void setDerivedAttributesListener() {
        final PendragonBaseCharacter character = this;

        getDerivedAttributes().addDerivedAttributesListener(
                new DerivedAttributesListener() {

                    @Override
                    public final void
                            damageChanged(final ValueChangeEvent event) {
                        fireDamageChangedEvent(new ValueChangeEvent(character,
                                event.getOldValue(), event.getNewValue()));
                    }

                    @Override
                    public final void dexterityRollChanged(
                            final ValueChangeEvent event) {
                        fireDexterityRollChangedEvent(new ValueChangeEvent(
                                character, event.getOldValue(), event
                                        .getNewValue()));
                    }

                    @Override
                    public final void healingRateChanged(
                            final ValueChangeEvent event) {
                        fireHealingRateChangedEvent(new ValueChangeEvent(
                                character, event.getOldValue(), event
                                        .getNewValue()));
                    }

                    @Override
                    public final void hitPointsChanged(
                            final ValueChangeEvent event) {
                        fireHitPointsChangedEvent(new ValueChangeEvent(
                                character, event.getOldValue(), event
                                        .getNewValue()));
                    }

                    @Override
                    public final void knockdownChanged(
                            final ValueChangeEvent event) {
                        fireKnockdownChangedEvent(new ValueChangeEvent(
                                character, event.getOldValue(), event
                                        .getNewValue()));
                    }

                    @Override
                    public final void majorWoundChanged(
                            final ValueChangeEvent event) {
                        fireMajorWoundChangedEvent(new ValueChangeEvent(
                                character, event.getOldValue(), event
                                        .getNewValue()));
                    }

                    @Override
                    public final void moveRateChanged(
                            final ValueChangeEvent event) {
                        fireMoveRateChangedEvent(new ValueChangeEvent(
                                character, event.getOldValue(), event
                                        .getNewValue()));
                    }

                    @Override
                    public final void unconciousChanged(
                            final ValueChangeEvent event) {
                        fireUnconciousChangedEvent(new ValueChangeEvent(
                                character, event.getOldValue(), event
                                        .getNewValue()));
                    }

                    @Override
                    public final void
                            weightChanged(final ValueChangeEvent event) {
                        fireWeightChangedEvent(new ValueChangeEvent(character,
                                event.getOldValue(), event.getNewValue()));
                    }

                });
    }

}
