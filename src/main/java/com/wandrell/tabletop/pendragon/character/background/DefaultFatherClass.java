package com.wandrell.tabletop.pendragon.character.background;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.conf.factory.ValueHandlerFactory;
import com.wandrell.tabletop.pendragon.conf.PendragonToken;
import com.wandrell.tabletop.pendragon.conf.factory.PendragonFactory;
import com.wandrell.tabletop.pendragon.inventory.PendragonMoney;
import com.wandrell.tabletop.pendragon.valuehandler.Skill;
import com.wandrell.tabletop.valuehandler.ValueHandler;

public final class DefaultFatherClass implements FatherClass {

    private final PendragonMoney money;
    private final String name;
    private final Map<String, Skill> skillsGroup = new LinkedHashMap<>();
    private ValueHandler<Integer> skillsGroupPoints;
    private final Map<String, ValueHandler<Integer>> skillsPoints = new LinkedHashMap<>();

    public DefaultFatherClass(final DefaultFatherClass data) {
	super();

	name = data.name;

	for (final Entry<String, Skill> entry : data.skillsGroup.entrySet()) {
	    skillsGroup.put(entry.getKey(), entry.getValue());
	}
	for (final Entry<String, ValueHandler<Integer>> entry : data.skillsPoints
		.entrySet()) {
	    skillsPoints.put(entry.getKey(), entry.getValue());
	}

	money = data.money.createNewInstance();

	skillsGroupPoints = data.skillsGroupPoints.createNewInstance();
    }

    public DefaultFatherClass(final String name) {
	super();

	if (name == null) {
	    throw new NullPointerException();
	}

	this.name = name;

	money = PendragonFactory.getInstance().getMoney();

	skillsGroupPoints = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonToken.VH_SKILLS_POINTS);
    }

    @Override
    public final void addSkillsPoints(final ValueHandler<Integer> vhValue) {
	_getSkillsPoints().put(vhValue.getName(), vhValue);
    }

    @Override
    public final DefaultFatherClass createNewInstance() {
	return new DefaultFatherClass(this);
    }

    @Override
    public final boolean equals(final Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	DefaultFatherClass other = (DefaultFatherClass) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    @Override
    public final PendragonMoney getMoney() {
	return money;
    }

    @Override
    public final String getName() {
	return name;
    }

    @Override
    public final Collection<Skill> getSkillsGroup() {
	return Collections.unmodifiableCollection(_getSkillsGroup().values());
    }

    @Override
    public final ValueHandler<Integer> getSkillsGroupPoints() {
	return skillsGroupPoints;
    }

    @Override
    public final Collection<ValueHandler<Integer>> getSkillsPoints() {
	return Collections.unmodifiableCollection(_getSkillsPoints().values());
    }

    @Override
    public final ValueHandler<Integer> getSkillsPoints(final String name) {
	return _getSkillsPoints().get(name);
    }

    @Override
    public final int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public final Boolean hasSkillsPoints(final String name) {
	return _getSkillsPoints().containsKey(name);
    }

    public final void setSkillPoints(
	    final Collection<ValueHandler<Integer>> points) {
	_getSkillsPoints().clear();
	for (final ValueHandler<Integer> p : points) {
	    addSkillsPoints(p);
	}
    }

    public final void setSkillsGroup(final Collection<Skill> skills,
	    final ValueHandler<Integer> points) {
	_getSkillsGroup().clear();
	for (final Skill skill : skills) {
	    _getSkillsGroup().put(skill.getName(), skill);
	}

	skillsGroupPoints.setValue(points.getStoredValue());
    }

    @Override
    public final String toString() {
	return getName();
    }

    protected final Map<String, Skill> _getSkillsGroup() {
	return skillsGroup;
    }

    protected final Map<String, ValueHandler<Integer>> _getSkillsPoints() {
	return skillsPoints;
    }

}
