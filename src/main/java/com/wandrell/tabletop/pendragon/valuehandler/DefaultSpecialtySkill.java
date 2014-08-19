package com.wandrell.tabletop.pendragon.valuehandler;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.wandrell.tabletop.valuehandler.DefaultValueHandler;
import com.wandrell.tabletop.valuehandler.DelegateValueHandler;
import com.wandrell.tabletop.valuehandler.module.GeneratorModule;
import com.wandrell.tabletop.valuehandler.module.IntervalModule;
import com.wandrell.tabletop.valuehandler.module.StoreModule;
import com.wandrell.tabletop.valuehandler.module.ValidatorModule;
import com.wandrell.tabletop.valuehandler.module.store.ProxyStore;

public final class DefaultSpecialtySkill implements SpecialtySkill {

    private final DelegateValueHandler composite;
    private final Set<String>          skills = new HashSet<String>();

    public DefaultSpecialtySkill(final DefaultSpecialtySkill skill) {
        super();

        composite = skill.composite.createNewInstance();

        skills.addAll(skill.skills);
    }

    public DefaultSpecialtySkill(final String name,
            final GeneratorModule generator, final IntervalModule interval,
            final StoreModule store, final ValidatorModule validator,
            final Collection<String> skills) {
        super();
        // TODO: This is dependant of DefaultValueHandler
        composite = new DefaultValueHandler(name, generator, interval, store,
                validator);

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
    public final Integer getStoredValue() {
        return getValueHandler().getStoredValue();
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

        if (!(skill instanceof DelegateValueHandler)) {
            // TODO: Error
        } else if (isSkillContained(skill.getName())) {
            ((DelegateValueHandler) skill).setStore(new ProxyStore(
                    getValueHandler()));
        }
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

    protected final DelegateValueHandler getValueHandler() {
        return composite;
    }

}
