package com.wandrell.tabletop.business.model.pendragon.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

import com.wandrell.tabletop.business.model.dice.Dice;

public final class DefaultWeapon implements Weapon {

    private final Boolean   breakingEnemyOnDraw;
    private final Boolean   breakingOnFumble;
    private final Integer   damageBonus;
    private final Boolean   damageOverriden;
    private final Dice      damageOverridenDice;
    private final Boolean   hittingBack;
    private final Boolean   ignoringShield;
    private final Equipment item;
    private final Boolean   reducingShieldToRoll;
    private final String    skill;
    private final Boolean   twoHanded;

    public DefaultWeapon(final Equipment item, final String skill,
            final Boolean breakingEnemyOnDraw, final Boolean breakingOnFumble,
            final Integer damageBonus, final Boolean damageOverriden,
            final Boolean hittingBack, final Boolean ignoringShield,
            final Boolean reducingShieldToRoll, final Boolean twoHanded,
            final Dice damageOverridenDice) {
        super();

        checkNotNull(item, "Received a null pointer as item");
        checkNotNull(skill, "Received a null pointer as skill");
        checkNotNull(breakingEnemyOnDraw,
                "Received a null pointer as breaks enemy on draw flag");
        checkNotNull(breakingOnFumble,
                "Received a null pointer as breaks on fumble lag");
        checkNotNull(damageBonus, "Received a null pointer as damage bonus");
        checkNotNull(damageOverriden,
                "Received a null pointer as damage overriden flag");
        checkNotNull(hittingBack,
                "Received a null pointer as hitting back flag");
        checkNotNull(ignoringShield,
                "Received a null pointer as ignoring shield flag");
        checkNotNull(reducingShieldToRoll,
                "Received a null pointer as reduces shield to a roll flag");
        checkNotNull(twoHanded, "Received a null pointer as two-handed flag");
        checkNotNull(damageOverridenDice,
                "Received a null pointer as damage override dice");

        this.skill = skill;
        this.item = item;

        this.breakingEnemyOnDraw = breakingEnemyOnDraw;
        this.breakingOnFumble = breakingOnFumble;
        this.damageBonus = damageBonus;
        this.damageOverriden = damageOverriden;
        this.hittingBack = hittingBack;
        this.ignoringShield = ignoringShield;
        this.reducingShieldToRoll = reducingShieldToRoll;
        this.twoHanded = twoHanded;

        this.damageOverridenDice = damageOverridenDice;
    }

    @Override
    public final Integer getDamageBonus() {
        return damageBonus;
    }

    @Override
    public final Dice getDamageOverridenDice() {
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
    public final Boolean isDamageOverriden() {
        return damageOverriden;
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

    private final Equipment getBaseItem() {
        return item;
    }

}
