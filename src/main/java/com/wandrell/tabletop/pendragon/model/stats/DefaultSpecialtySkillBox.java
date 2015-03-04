package com.wandrell.tabletop.pendragon.model.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.event.ValueChangeListener;
import com.wandrell.tabletop.valuebox.DefaultSkillBox;
import com.wandrell.tabletop.valuebox.SkillBox;

public final class DefaultSpecialtySkillBox implements SpecialtySkillBox {

    private final SkillBox           composite;
    private final Collection<String> skills = new HashSet<String>();

    public DefaultSpecialtySkillBox(final DefaultSpecialtySkillBox skill) {
        super();

        checkNotNull(skill, "Received a null pointer as skill");

        composite = skill.composite.createNewInstance();

        skills.addAll(skill.skills);
    }

    public DefaultSpecialtySkillBox(final String name, final Integer value,
            final Integer lowerLimit, final Integer upperLimit,
            final Collection<String> skills) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(skills, "Received a null pointer as skills");

        composite = new DefaultSkillBox(name, value, lowerLimit, upperLimit);

        setSurrogatedSkillsNames(skills);
    }

    @Override
    public final void
            addValueChangeListener(final ValueChangeListener listener) {
        getBaseSkill().addValueChangeListener(listener);
    }

    @Override
    public final DefaultSpecialtySkillBox createNewInstance() {
        return new DefaultSpecialtySkillBox(this);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultSpecialtySkillBox other = (DefaultSpecialtySkillBox) obj;
        return Objects.equals(composite, other.composite);
    }

    @Override
    public final String getDescriptor() {
        return "";
    }

    @Override
    public final Integer getLowerLimit() {
        return getBaseSkill().getLowerLimit();
    }

    @Override
    public final String getName() {
        return getBaseSkill().getName();
    }

    @Override
    public final Collection<String> getSurrogatedSkills() {
        return Collections
                .unmodifiableCollection(getSurrogatedSkillsModifiable());
    }

    @Override
    public final Integer getUpperLimit() {
        return getBaseSkill().getUpperLimit();
    }

    @Override
    public final Integer getValue() {
        return getBaseSkill().getValue();
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(composite);
    }

    @Override
    public final Boolean isDescribed() {
        return false;
    }

    @Override
    public final void removeValueChangeListener(
            final ValueChangeListener listener) {
        getBaseSkill().removeValueChangeListener(listener);
    }

    @Override
    public final void setDescribed(final Boolean described) {
        getBaseSkill().setDescribed(described);
    }

    @Override
    public final void setDescriptor(final String descriptor) {}

    @Override
    public final void setLowerLimit(final Integer lowerLimit) {
        getBaseSkill().setLowerLimit(lowerLimit);
    }

    @Override
    public final void setUpperLimit(final Integer upperLimit) {
        getBaseSkill().setUpperLimit(upperLimit);
    }

    @Override
    public final void setValue(final Integer value) {
        getBaseSkill().setValue(value);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", getName())
                .add("value", getValue()).toString();
    }

    private final SkillBox getBaseSkill() {
        return composite;
    }

    private final Collection<String> getSurrogatedSkillsModifiable() {
        return skills;
    }

    private final void
            setSurrogatedSkillsNames(final Collection<String> skills) {
        getSurrogatedSkillsModifiable().clear();
        for (final String skill : skills) {
            checkNotNull(skill, "Received a null pointer as skill");

            getSurrogatedSkillsModifiable().add(skill);
        }
    }

}
