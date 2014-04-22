package com.wandrell.tabletop.rpg.pendragon.character.background;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.rpg.conf.factory.ValueHandlerFactory;
import com.wandrell.tabletop.rpg.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.rpg.pendragon.inventory.DefaultMoneyData;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.DefaultPendragonSkill;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonSkill;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultFatherClass implements FatherClass, NewInstantiable {

    private final DefaultMoneyData dataMoney;
    private String name = "";
    private final Map<String, PendragonSkill> storeSkillsGroup = new LinkedHashMap<>();
    private final Map<String, ValueHandler<Integer>> storeSkillsPoints = new LinkedHashMap<>();
    private ValueHandler<Integer> vhPointsSkillsGroup;

    public DefaultFatherClass() {
	super();
	dataMoney = new DefaultMoneyData();

	vhPointsSkillsGroup = ValueHandlerFactory
		.getDefaultIntegerValueHandler(PendragonLabels.VH_SKILLS_POINTS);
    }

    public DefaultFatherClass(final DefaultFatherClass data) {
	super();

	for (final Entry<String, PendragonSkill> entry : data.storeSkillsGroup
		.entrySet()) {
	    storeSkillsGroup.put(entry.getKey(), entry.getValue());
	}
	for (final Entry<String, ValueHandler<Integer>> entry : data.storeSkillsPoints
		.entrySet()) {
	    storeSkillsPoints.put(entry.getKey(), entry.getValue());
	}

	name = data.name;

	dataMoney = data.dataMoney.createNewInstance();

	vhPointsSkillsGroup = data.vhPointsSkillsGroup.createNewInstance();
    }

    @Override
    public void addSkillsPoints(final ValueHandler<Integer> vhValue) {
	getSkillsPointsStore().put(vhValue.getName(), vhValue);
    }

    @Override
    public DefaultFatherClass createNewInstance() {
	return new DefaultFatherClass(this);
    }

    @Override
    public DefaultMoneyData getMoneyData() {
	return dataMoney;
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public Collection<PendragonSkill> getSkillsGroup() {
	return Collections.unmodifiableCollection(getSkillsGroupStore()
		.values());
    }

    @Override
    public ValueHandler<Integer> getSkillsGroupPoints() {
	return vhPointsSkillsGroup;
    }

    @Override
    public Collection<ValueHandler<Integer>> getSkillsPoints() {
	return Collections.unmodifiableCollection(getSkillsPointsStore()
		.values());
    }

    @Override
    public ValueHandler<Integer> getSkillsPoints(final String name) {
	return getSkillsPointsStore().get(name);
    }

    @Override
    public boolean hasSkillsPoints(final String name) {
	return getSkillsPointsStore().containsKey(name);
    }

    public void setName(final String name) {
	this.name = name;
    }

    public void setSkillPoints(
	    final Iterator<? extends ValueHandler<Integer>> itrPoints) {
	getSkillsPointsStore().clear();
	while (itrPoints.hasNext()) {
	    addSkillsPoints(itrPoints.next());
	}
    }

    public void setSkillsGroup(final Iterator<DefaultPendragonSkill> itrSkills,
	    final ValueHandler<Integer> vhPoints) {
	getSkillsGroupStore().clear();
	while (itrSkills.hasNext()) {
	    addSkillToSkillsGroup(itrSkills.next());
	}

	// TODO: ¿No basta asignar el valor contenido?
	vhPointsSkillsGroup = vhPoints;
    }

    private void addSkillToSkillsGroup(final PendragonSkill vhSkill) {
	getSkillsGroupStore().put(vhSkill.getName(), vhSkill);
    }

    private Map<String, PendragonSkill> getSkillsGroupStore() {
	return storeSkillsGroup;
    }

    private Map<String, ValueHandler<Integer>> getSkillsPointsStore() {
	return storeSkillsPoints;
    }

}
