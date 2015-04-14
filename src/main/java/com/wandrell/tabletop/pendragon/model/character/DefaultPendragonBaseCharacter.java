package com.wandrell.tabletop.pendragon.model.character;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.pendragon.model.character.event.CharacterEchoAttributesListener;
import com.wandrell.tabletop.pendragon.model.character.event.CharacterEchoDerivedAttributesListener;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonCharacterListener;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonEventThrower;
import com.wandrell.tabletop.pendragon.model.character.stats.AttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.DefaultAttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.DerivedAttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.GeneratedDerivedAttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.PendragonSkillBox;

public final class DefaultPendragonBaseCharacter implements
        PendragonBaseCharacter {

    private final AttributesHolder              attributes;
    private final DerivedAttributesHolder       derived;
    private final DerivedAttributeBuilder       derivedBuilder;
    private final PendragonEventThrower         eventThrower = new PendragonEventThrower();
    private final String                        name;
    private final Collection<PendragonSkillBox> skills       = new LinkedHashSet<PendragonSkillBox>();

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
        getEventThrower().addPendragonCharacterListener(listener);
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
        getEventThrower().removePendragonCharacterListener(listener);
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

    private final PendragonEventThrower getEventThrower() {
        return eventThrower;
    }

    private final Collection<PendragonSkillBox> getSkillsModifiable() {
        return skills;
    }

    private final void setAttributesListeners() {
        getAttributes().addAttributesListener(
                new CharacterEchoAttributesListener(this, getEventThrower()));
    }

    private final void setDerivedAttributesListener() {
        getDerivedAttributes().addDerivedAttributesListener(
                new CharacterEchoDerivedAttributesListener(this,
                        getEventThrower()));
    }

}
