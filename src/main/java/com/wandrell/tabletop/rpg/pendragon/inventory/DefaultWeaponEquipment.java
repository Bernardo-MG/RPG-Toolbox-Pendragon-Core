package com.wandrell.tabletop.rpg.pendragon.inventory;

import com.wandrell.tabletop.rpg.pendragon.conf.PendragonLabels;

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
    public String getSkill() {
	return skill;
    }

    @Override
    public boolean isDamageOverriden() {
	final int die, bonus;
	boolean result = false;

	if (hasValue(PendragonLabels.VH_DAMAGE_OVERRIDE_DIE)) {
	    die = getMiscelanyValue(PendragonLabels.VH_DAMAGE_OVERRIDE_DIE)
		    .getStoredValue();
	    result = die > 0;
	}

	if ((!result) && (hasValue(PendragonLabels.VH_DAMAGE_OVERRIDE_BONUS))) {
	    bonus = getMiscelanyValue(PendragonLabels.VH_DAMAGE_OVERRIDE_BONUS)
		    .getStoredValue();
	    result = bonus > 0;
	}

	return result;
    }

    @Override
    public void setSkill(final String skill) {
	this.skill = skill;
    }

}
