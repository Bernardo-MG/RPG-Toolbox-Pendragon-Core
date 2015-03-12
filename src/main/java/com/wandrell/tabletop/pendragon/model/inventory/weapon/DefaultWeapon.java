package com.wandrell.tabletop.pendragon.model.inventory.weapon;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.pendragon.model.inventory.DefaultItem;
import com.wandrell.tabletop.pendragon.model.inventory.Item;
import com.wandrell.tabletop.pendragon.model.inventory.Money;
import com.wandrell.tabletop.pendragon.model.inventory.armor.ArmorType;

public final class DefaultWeapon implements Weapon {

    private final Map<ArmorType, Integer> armorBonus;
    private final Boolean                 breakingEnemyOnDraw;
    private final Boolean                 breakingOnFumble;
    private final Integer                 damageBonus;
    private final Integer                 damageDiceBonus;
    private final Integer                 damageOverridenDice;
    private final Boolean                 hittingBack;
    private final Boolean                 ignoringShield;
    private final Item                    item;
    private final Boolean                 reducingShieldToRoll;
    private final String                  skill;
    private final Boolean                 twoHanded;

    public DefaultWeapon(final String name, final String description,
            final Money money, final String skill, final Integer damageBonus,
            final Integer damageDiceBonus, final Integer damageOverridenDice,
            final Map<ArmorType, Integer> armorBonus,
            final Boolean breakingEnemyOnDraw, final Boolean breakingOnFumble,
            final Boolean hittingBack, final Boolean ignoringShield,
            final Boolean reducingShieldToRoll, final Boolean twoHanded) {
        super();

        checkNotNull(skill, "Received a null pointer as skill");
        checkNotNull(breakingEnemyOnDraw,
                "Received a null pointer as breaks enemy on draw flag");
        checkNotNull(breakingOnFumble,
                "Received a null pointer as breaks on fumble lag");
        checkNotNull(armorBonus, "Received a null pointer as vs armor bonus");
        checkNotNull(damageBonus, "Received a null pointer as damage bonus");
        checkNotNull(damageDiceBonus,
                "Received a null pointer as damage dice bonus");
        checkNotNull(hittingBack,
                "Received a null pointer as hitting back flag");
        checkNotNull(ignoringShield,
                "Received a null pointer as ignoring shield flag");
        checkNotNull(reducingShieldToRoll,
                "Received a null pointer as reduces shield to a roll flag");
        checkNotNull(twoHanded, "Received a null pointer as two-handed flag");
        checkNotNull(damageOverridenDice,
                "Received a null pointer as damage override dice");

        this.item = new DefaultItem(name, description, money);

        this.skill = skill;

        this.damageBonus = damageBonus;
        this.damageDiceBonus = damageDiceBonus;

        this.damageOverridenDice = damageOverridenDice;

        this.armorBonus = armorBonus;

        this.breakingEnemyOnDraw = breakingEnemyOnDraw;
        this.breakingOnFumble = breakingOnFumble;
        this.hittingBack = hittingBack;
        this.ignoringShield = ignoringShield;
        this.reducingShieldToRoll = reducingShieldToRoll;
        this.twoHanded = twoHanded;
    }

    @Override
    public final Map<ArmorType, Integer> getArmorBonusDice() {
        return armorBonus;
    }

    @Override
    public final Integer getDamageBonus() {
        return damageBonus;
    }

    @Override
    public final Integer getDamageDiceBonus() {
        return damageDiceBonus;
    }

    @Override
    public final Integer getDamageOverrideDice() {
        return damageOverridenDice;
    }

    @Override
    public final String getDescription() {
        return getBaseItem().getDescription();
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
    public final Boolean isBreakingEnemyOnDraw() {
        return breakingEnemyOnDraw;
    }

    @Override
    public final Boolean isBreakingOnFumble() {
        return breakingOnFumble;
    }

    @Override
    public final Boolean isHittingBack() {
        return hittingBack;
    }

    @Override
    public final Boolean isIgnoringShield() {
        return ignoringShield;
    }

    @Override
    public final Boolean isReducingShieldToRoll() {
        return reducingShieldToRoll;
    }

    @Override
    public final Boolean isTwoHanded() {
        return twoHanded;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", getName())
                .toString();
    }

    private final Item getBaseItem() {
        return item;
    }

}
