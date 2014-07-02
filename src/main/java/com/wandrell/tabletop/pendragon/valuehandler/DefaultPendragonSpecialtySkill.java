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

public class DefaultPendragonSpecialtySkill extends
	DefaultValueHandler<Integer> implements PendragonSpecialtySkill {

    private final Set<String> skills = new HashSet<String>();

    public DefaultPendragonSpecialtySkill(
	    final DefaultPendragonSpecialtySkill skill) {
	super(skill);
	skills.addAll(skill.skills);
    }

    public DefaultPendragonSpecialtySkill(final String name,
	    final GeneratorModule<Integer> generator,
	    final IntervalModule<Integer> interval,
	    final StoreModule<Integer> store,
	    final ValidatorModule<Integer> validator,
	    final Collection<String> skills) {
	super(name, generator, interval, store, validator);
	setSurrogatedSkillsNames(skills);
    }

    @Override
    public DefaultPendragonSpecialtySkill createNewInstance() {
	return new DefaultPendragonSpecialtySkill(this);
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
    public final void registerSkill(final PendragonSkill skill) {
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
