package com.wandrell.tabletop.rpg.pendragon.valuehandler;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.wandrell.tabletop.rpg.valuehandler.DefaultValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.DelegateValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.module.GeneratorModule;
import com.wandrell.tabletop.rpg.valuehandler.module.IntervalModule;
import com.wandrell.tabletop.rpg.valuehandler.module.StoreModule;
import com.wandrell.tabletop.rpg.valuehandler.module.ValidatorModule;
import com.wandrell.tabletop.rpg.valuehandler.module.store.ProxyStore;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultPendragonAggregatedSkill extends
	DefaultValueHandler<Integer> implements PendragonAggregatedSkill,
	NewInstantiable {

    private final Set<String> setSurrogatedSkills = new HashSet<String>();

    public DefaultPendragonAggregatedSkill(
	    final DefaultPendragonAggregatedSkill skill) {
	super(skill);
	setSurrogatedSkills.addAll(skill.setSurrogatedSkills);
    }

    public DefaultPendragonAggregatedSkill(final String name,
	    final GeneratorModule<Integer> generator,
	    final IntervalModule<Integer> interval,
	    final StoreModule<Integer> store,
	    final ValidatorModule<Integer> validator,
	    final Iterator<String> itrSurrogatedSkills) {
	super(name, generator, interval, store, validator);
	setSurrogatedSkillsNames(itrSurrogatedSkills);
    }

    @Override
    public DefaultPendragonAggregatedSkill createNewInstance() {
	return new DefaultPendragonAggregatedSkill(this);
    }

    @Override
    public Collection<String> getSkillsNames() {
	return getSurrogatedSkillsSet();
    }

    @Override
    public boolean isSkillContained(final String name) {
	return getSurrogatedSkillsSet().contains(name);
    }

    @Override
    public void register(final PendragonSkill vhSkill) {
	if (!(vhSkill instanceof DelegateValueHandler<?>)) {
	    // TODO: Error
	} else if (isSkillContained(vhSkill.getName())) {
	    ((DelegateValueHandler<Integer>) vhSkill)
		    .setStore(new ProxyStore<Integer>(this));
	}
    }

    public void setSurrogatedSkillsNames(final Iterator<String> itrSkills) {
	getSurrogatedSkillsSet().clear();
	while (itrSkills.hasNext()) {
	    addSurrogatedSkillName(itrSkills.next());
	}
    }

    protected void addSurrogatedSkillName(final String skill) {
	setSurrogatedSkills.add(skill);
    }

    protected Set<String> getSurrogatedSkillsSet() {
	return setSurrogatedSkills;
    }

}
