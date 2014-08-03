package com.wandrell.tabletop.pendragon.inventory;

import java.util.Collection;
import java.util.Map;

import com.wandrell.tabletop.pendragon.conf.PendragonToken;

public final class DefaultWeaponEquipment implements WeaponEquipment {

    private final PendragonEquipment item;
    private final String skill;

    public DefaultWeaponEquipment(final DefaultWeaponEquipment weapon) {
	super();

	skill = weapon.skill;
	item = weapon.item;
    }

    public DefaultWeaponEquipment(final PendragonEquipment item,
	    final String skill) {
	super();

	this.skill = skill;
	this.item = item;
    }

    @Override
    public final String getDescription() {
	return getBaseItem().getDescription();
    }

    @Override
    public final Boolean getFlag(final String name) {
	return getBaseItem().getFlag(name);
    }

    @Override
    public final Collection<String> getFlags() {
	return getBaseItem().getFlags();
    }

    @Override
    public final Map<String, Integer> getMiscelanyValues() {
	return getBaseItem().getMiscelanyValues();
    }

    @Override
    public final PendragonMoney getMoney() {
	return getBaseItem().getMoney();
    }

    @Override
    public final String getName() {
	return getBaseItem().getName();
    }

    @Override
    public final String getSkill() {
	return skill;
    }

    @Override
    public final Boolean hasFlag(final String name) {
	return getBaseItem().hasFlag(name);
    }

    @Override
    public final Boolean isDamageOverriden() {
	final int die, bonus;
	boolean result = false;

	if (getMiscelanyValues().containsKey(
		PendragonToken.VH_DAMAGE_OVERRIDE_DIE)) {
	    die = getMiscelanyValues().get(
		    PendragonToken.VH_DAMAGE_OVERRIDE_DIE);
	    result = die > 0;
	}

	if ((!result)
		&& (getMiscelanyValues()
			.containsKey(PendragonToken.VH_DAMAGE_OVERRIDE_BONUS))) {
	    bonus = getMiscelanyValues().get(
		    PendragonToken.VH_DAMAGE_OVERRIDE_BONUS);
	    result = bonus > 0;
	}

	return result;
    }

    private final PendragonEquipment getBaseItem() {
	return item;
    }

}
