package com.wandrell.tabletop.pendragon.inventory;

import com.wandrell.tabletop.pendragon.conf.PendragonToken;

public class DefaultWeaponEquipment extends DefaultPendragonEquipment implements
	WeaponEquipment {

    private String skill;

    public DefaultWeaponEquipment() {
	super();
    }

    public DefaultWeaponEquipment(final DefaultWeaponEquipment weapon) {
	super(weapon);
	skill = weapon.skill;
    }

    public DefaultWeaponEquipment(final String skill) {
	super();
	this.skill = skill;
    }

    @Override
    public DefaultWeaponEquipment createNewInstance() {
	return new DefaultWeaponEquipment(this);
    }

    @Override
    public final String getSkill() {
	return skill;
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
    public final void setSkill(final String skill) {
	this.skill = skill;
    }

}
