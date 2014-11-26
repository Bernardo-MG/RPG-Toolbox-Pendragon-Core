package com.wandrell.tabletop.business.model.pendragon.inventory;

import java.util.Collection;
import java.util.Map;

import com.wandrell.tabletop.business.conf.pendragon.PendragonToken;

public final class DefaultWeapon implements Weapon {

    private final Equipment item;
    private final String    skill;

    public DefaultWeapon(final DefaultWeapon weapon) {
        super();

        skill = weapon.skill;
        item = weapon.item;
    }

    public DefaultWeapon(final Equipment item, final String skill) {
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
    public final Money getMoney() {
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

    private final Equipment getBaseItem() {
        return item;
    }

}
