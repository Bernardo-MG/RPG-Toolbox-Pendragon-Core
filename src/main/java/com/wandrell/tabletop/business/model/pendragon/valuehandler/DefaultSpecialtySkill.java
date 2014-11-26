package com.wandrell.tabletop.business.model.pendragon.valuehandler;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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

        composite = skill.composite.createNewInstance();

        skills.addAll(skill.skills);
    }

    public DefaultSpecialtySkill(final String name,
            final GeneratorModule generator, final IntervalModule interval,
            final AbstractEditableStoreModule store,
            final ValidatorModule validator, final Collection<String> skills) {
        super();
        // TODO: This is dependant of DefaultValueHandler
        composite = new ModularEditableValueHandler(name, generator, interval,
                store, validator);

        setSurrogatedSkillsNames(skills);
    }

    @Override
    public final Boolean acceptsValue(final Integer value) {
        return getValueHandler().acceptsValue(value);
    }

    @Override
    public final void addValue(final Integer value) {
        getValueHandler().addValue(value);
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
    public final Integer getLowerLimit() {
        return getValueHandler().getLowerLimit();
    }

    @Override
    public final String getName() {
        return getValueHandler().getName();
    }

    @Override
    public final Collection<String> getSurrogatedSkills() {
        return Collections.unmodifiableCollection(_getSurrogatedSkills());
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

    @Override
    public final Boolean isSkillContained(final String name) {
        return _getSurrogatedSkills().contains(name);
    }

    @Override
    public final void registerSkill(final Skill skill) {
        // TODO: This may be better be done somewhere else
        if (skill == null) {
            throw new NullPointerException();
        }

        if (isSkillContained(skill.getName())) {
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
        return getName();
    }

    private final void
            setSurrogatedSkillsNames(final Collection<String> skills) {
        _getSurrogatedSkills().clear();
        for (final String skill : skills) {
            if (skill == null) {
                throw new NullPointerException();
            }

            _getSurrogatedSkills().add(skill);
        }
    }

    protected final Collection<String> _getSurrogatedSkills() {
        return skills;
    }

    protected final ModularEditableValueHandler getValueHandler() {
        return composite;
    }

}
