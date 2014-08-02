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

public final class DefaultSpecialtySkill extends DefaultValueHandler<Integer>
	implements SpecialtySkill {

    private final Set<String> skills = new HashSet<String>();

    public DefaultSpecialtySkill(final DefaultSpecialtySkill skill) {
	super(skill);
	skills.addAll(skill.skills);
    }

    public DefaultSpecialtySkill(final String name,
	    final GeneratorModule<Integer> generator,
	    final IntervalModule<Integer> interval,
	    final StoreModule<Integer> store,
	    final ValidatorModule<Integer> validator,
	    final Collection<String> skills) {
	super(name, generator, interval, store, validator);

	setSurrogatedSkillsNames(skills);
    }

    @Override
    public final DefaultSpecialtySkill createNewInstance() {
	return new DefaultSpecialtySkill(this);
    }

    @Override
    public final Collection<String> getSurrogatedSkills() {
	return Collections.unmodifiableCollection(_getSurrogatedSkills());
    }

    @Override
    public final Boolean isSkillContained(final String name) {
	return _getSurrogatedSkills().contains(name);
    }

    @SuppressWarnings("unchecked")
    @Override
    public final void registerSkill(final Skill skill) {
	// TODO: This may be better be done somewhere else
	if (skill == null) {
	    throw new NullPointerException();
	}

	if (!(skill instanceof DelegateValueHandler<?>)) {
	    // TODO: Error
	} else if (isSkillContained(skill.getName())) {
	    ((DelegateValueHandler<Integer>) skill)
		    .setStore(new ProxyStore<Integer>(this));
	}
    }

    @Override
    public final String toString() {
	return getName();
    }

    private final void setSurrogatedSkillsNames(final Collection<String> skills) {
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

}
