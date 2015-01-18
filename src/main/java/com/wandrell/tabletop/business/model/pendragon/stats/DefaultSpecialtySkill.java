package com.wandrell.tabletop.business.model.pendragon.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.valuebox.DefaultEditableValueBox;
import com.wandrell.tabletop.business.util.event.ValueChangeListener;

public final class DefaultSpecialtySkill implements SpecialtySkill {

    private final DefaultEditableValueBox composite;
    private final String                  name;
    private final Collection<String>      skills = new HashSet<String>();

    public DefaultSpecialtySkill(final DefaultSpecialtySkill skill) {
        super();

        checkNotNull(skill, "Received a null pointer as skill");

        name = skill.name;

        composite = skill.composite.createNewInstance();

        skills.addAll(skill.skills);
    }

    public DefaultSpecialtySkill(final String name, final Integer value,
            final Integer lowerLimit, final Integer upperLimit,
            final Collection<String> skills) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(skills, "Received a null pointer as skills");

        this.name = name;

        composite = new DefaultEditableValueBox(value, lowerLimit, upperLimit);

        setSurrogatedSkillsNames(skills);
    }

    @Override
    public final void
            addValueChangeListener(final ValueChangeListener listener) {
        getValueHandler().addValueChangeListener(listener);
    }

    @Override
    public final DefaultSpecialtySkill createNewInstance() {
        return new DefaultSpecialtySkill(this);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultSpecialtySkill other = (DefaultSpecialtySkill) obj;
        return Objects.equals(composite, other.composite);
    }

    @Override
    public final String getDescriptor() {
        return "";
    }

    @Override
    public final Integer getLowerLimit() {
        return getValueHandler().getLowerLimit();
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Collection<String> getSurrogatedSkills() {
        return Collections
                .unmodifiableCollection(getSurrogatedSkillsModifiable());
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
        getValueHandler().removeValueChangeListener(listener);
    }

    @Override
    public final void setDescriptor(final String descriptor) {}

    @Override
    public final void setLowerLimit(final Integer lowerLimit) {
        getValueHandler().setLowerLimit(lowerLimit);
    }

    @Override
    public final void setUpperLimit(final Integer upperLimit) {
        getValueHandler().setUpperLimit(upperLimit);
    }

    @Override
    public final void setValue(final Integer value) {
        getValueHandler().setValue(value);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name)
                .add("value", getValue()).toString();
    }

    private final Collection<String> getSurrogatedSkillsModifiable() {
        return skills;
    }

    private final DefaultEditableValueBox getValueHandler() {
        return composite;
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
