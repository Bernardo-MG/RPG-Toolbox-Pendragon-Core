package com.wandrell.tabletop.pendragon.model.inventory.weapon;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.wandrell.tabletop.pendragon.model.inventory.Money;
import com.wandrell.tabletop.pendragon.model.inventory.armor.ArmorType;
import com.wandrell.tabletop.pendragon.model.inventory.armor.DefaultArmor;

public final class DefaultRangedWeapon implements RangedWeapon {

    private final Integer range;
    private final Integer reload;
    private final Weapon  weapon;

    public DefaultRangedWeapon(final DefaultRangedWeapon weapon) {
        super();

        checkNotNull(weapon, "Received a null pointer as ranged weapon");

        this.weapon = weapon.weapon.createNewInstance();

        range = weapon.range;
        reload = weapon.reload;
    }

    public DefaultRangedWeapon(final String name, final String description,
            final Money money, final String skill, final Integer damageBonus,
            final Integer damageDiceBonus, final Integer damageOverridenDice,
            final Map<ArmorType, Integer> armorBonus,
            final Boolean breakingEnemyOnDraw, final Boolean breakingOnFumble,
            final Boolean hittingBack, final Boolean ignoringShield,
            final Boolean reducingShieldToRoll, final Boolean twoHanded,
            final Integer range, final Integer reload) {
        super();

        checkNotNull(range, "Received a null pointer as range");
        checkNotNull(reload, "Received a null pointer as rounds to reload");

        weapon = new DefaultWeapon(name, description, money, skill,
                damageBonus, damageDiceBonus, damageOverridenDice, armorBonus,
                breakingEnemyOnDraw, breakingOnFumble, hittingBack,
                ignoringShield, ignoringShield, twoHanded);

        this.range = range;
        this.reload = reload;
    }

    @Override
    public final DefaultRangedWeapon createNewInstance() {
        return new DefaultRangedWeapon(this);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultArmor other = (DefaultArmor) obj;
        return Objects.equal(getName(), other.getName());
    }

    @Override
    public final Map<ArmorType, Integer> getArmorBonusDice() {
        return getBaseWeapon().getArmorBonusDice();
    }

    @Override
    public final Integer getDamageBonus() {
        return getBaseWeapon().getDamageBonus();
    }

    @Override
    public final Integer getDamageDiceBonus() {
        return getBaseWeapon().getDamageDiceBonus();
    }

    @Override
    public final Integer getDamageOverrideDice() {
        return getBaseWeapon().getDamageOverrideDice();
    }

    @Override
    public final String getDescription() {
        return getBaseWeapon().getDescription();
    }

    @Override
    public final Integer getMaxRange() {
        return range;
    }

    @Override
    public final Money getMoney() {
        return getBaseWeapon().getMoney();
    }

    @Override
    public final String getName() {
        return getBaseWeapon().getName();
    }

    @Override
    public final Integer getRoundsToReload() {
        return reload;
    }

    @Override
    public final String getSkill() {
        return getBaseWeapon().getSkill();
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(getName());
    }

    @Override
    public final Boolean isBreakingEnemyOnDraw() {
        return getBaseWeapon().isBreakingEnemyOnDraw();
    }

    @Override
    public final Boolean isBreakingOnFumble() {
        return getBaseWeapon().isBreakingOnFumble();
    }

    @Override
    public final Boolean isHittingBack() {
        return getBaseWeapon().isHittingBack();
    }

    @Override
    public final Boolean isIgnoringShield() {
        return getBaseWeapon().isIgnoringShield();
    }

    @Override
    public final Boolean isReducingShieldToRoll() {
        return getBaseWeapon().isReducingShieldToRoll();
    }

    @Override
    public final Boolean isTwoHanded() {
        return getBaseWeapon().isTwoHanded();
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", getName())
                .toString();
    }

    private final Weapon getBaseWeapon() {
        return weapon;
    }

}
