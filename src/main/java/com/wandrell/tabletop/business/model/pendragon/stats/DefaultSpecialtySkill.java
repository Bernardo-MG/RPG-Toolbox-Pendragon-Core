package com.wandrell.tabletop.business.model.pendragon.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.valuehandler.ModularEditableValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.event.ValueHandlerListener;
import com.wandrell.tabletop.business.model.valuehandler.module.generator.GeneratorModule;
import com.wandrell.tabletop.business.model.valuehandler.module.interval.IntervalModule;
import com.wandrell.tabletop.business.model.valuehandler.module.store.AbstractEditableStoreModule;
import com.wandrell.tabletop.business.model.valuehandler.module.store.ProxyStore;
import com.wandrell.tabletop.business.model.valuehandler.module.validator.ValidatorModule;

public final class DefaultSpecialtySkill implements SpecialtySkill {

    private final ModularEditableValueHandler composite;
    private final Set<String>                 skills = new HashSet<String>();

    public DefaultSpecialtySkill(final DefaultSpecialtySkill skill) {
        super();

        checkNotNull(skill, "Received a null pointer as skill");

        composite = skill.composite.createNewInstance();

        skills.addAll(skill.skills);
    }

    public DefaultSpecialtySkill(final String name,
            final GeneratorModule generator, final IntervalModule interval,
            final AbstractEditableStoreModule store,
            final ValidatorModule validator, final Collection<String> skills) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(generator, "Received a null pointer as generator");
        checkNotNull(interval, "Received a null pointer as interval");
        checkNotNull(store, "Received a null pointer as store");
        checkNotNull(validator, "Received a null pointer as validator");
        checkNotNull(skills, "Received a null pointer as skills");

        composite = new ModularEditableValueHandler(name, generator, interval,
                store, validator);

        setSurrogatedSkillsNames(skills);
    }

    @Override
    public final Boolean acceptsValue(final Integer value) {
        return getValueHandler().acceptsValue(value);
    }

    @Override
    public final void
            addValueEventListener(final ValueHandlerListener listener) {
        getValueHandler().addValueEventListener(listener);
    }

    @Override
    public final DefaultSpecialtySkill createNewInstance() {
        return new DefaultSpecialtySkill(this);
    }

    @Override
    public final void decreaseValue() {
        getValueHandler().decreaseValue();
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
    public final Integer getLowerLimit() {
        return getValueHandler().getLowerLimit();
    }

    @Override
    public final String getName() {
        return getValueHandler().getName();
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
    public final void increaseValue() {
        getValueHandler().increaseValue();
    }

    @Override
    public final Boolean isAbleToDecrease() {
        return getValueHandler().isAbleToDecrease();
    }

    @Override
    public final Boolean isAbleToIncrease() {
        return getValueHandler().isAbleToIncrease();
    }

    public final void registerSkill(final Skill skill) {
        checkNotNull(skill, "Received a null pointer as skill");

        if (getSurrogatedSkillsModifiable().contains(skill.getName())) {
            getValueHandler().setStore(new ProxyStore(getValueHandler()));
        }
    }

    @Override
    public final void removeValueEventListener(
            final ValueHandlerListener listener) {
        getValueHandler().removeValueEventListener(listener);
    }

    @Override
    public final void setValue(final Integer value) {
        getValueHandler().setValue(value);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", getName())
                .add("value", getValue()).toString();
    }

    private final Collection<String> getSurrogatedSkillsModifiable() {
        return skills;
    }

    private final ModularEditableValueHandler getValueHandler() {
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
