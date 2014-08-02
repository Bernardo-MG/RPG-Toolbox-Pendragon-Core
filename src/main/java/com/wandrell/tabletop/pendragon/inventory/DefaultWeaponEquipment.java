package com.wandrell.tabletop.pendragon.inventory;

import java.util.Collection;

import com.wandrell.tabletop.pendragon.conf.PendragonToken;
import com.wandrell.tabletop.valuehandler.ValueHandler;

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
    public final ValueHandler<Integer> getMiscelanyValue(final String name) {
	return getBaseItem().getMiscelanyValue(name);
    }

    @Override
    public final Collection<ValueHandler<Integer>> getMiscelanyValues() {
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
    public final ValueHandler<Integer> getQuantity() {
	return getBaseItem().getQuantity();
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
    public final Boolean hasValue(final String name) {
	return getBaseItem().hasValue(name);
    }

    @Override
    public final Boolean isDamageOverriden() {
	final int die, bonus;
	boolean result = false;

	if (hasValue(PendragonToken.VH_DAMAGE_OVERRIDE_DIE)) {
	    die = getMiscelanyValue(PendragonToken.VH_DAMAGE_OVERRIDE_DIE)
		    .getStoredValue();
	    result = die > 0;
	}

	if ((!result) && (hasValue(PendragonToken.VH_DAMAGE_OVERRIDE_BONUS))) {
	    bonus = getMiscelanyValue(PendragonToken.VH_DAMAGE_OVERRIDE_BONUS)
		    .getStoredValue();
	    result = bonus > 0;
	}

	return result;
    }

    @Override
    public final void setDescription(final String description) {
	getBaseItem().setDescription(description);
    }

    @Override
    public final void setName(final String name) {
	getBaseItem().setName(name);
    }

    private final PendragonEquipment getBaseItem() {
	return item;
    }

}
