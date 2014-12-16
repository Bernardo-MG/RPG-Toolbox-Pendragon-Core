package com.wandrell.tabletop.business.model.pendragon.chargen;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.pendragon.inventory.Money;

public final class DefaultFatherClassBonus implements FatherClassBonus {

    private final Money              money;
    private final String             name;
    private final Collection<String> skillsGroup;
    private final Integer            skillsGroupPoints;
    private final Integer            skillsNonCombatPoints;
    private final Integer            skillsPoints;

    public DefaultFatherClassBonus(final String name,
            final Integer skillsGroupPoints,
            final Collection<String> skillsGroup, final Integer skillsPoints,
            final Integer skillsNonCombatPoints, final Money money) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(skillsGroupPoints,
                "Received a null pointer as skills group points");
        checkNotNull(skillsGroup, "Received a null pointer as skills group");
        checkNotNull(skillsPoints, "Received a null pointer as skills points");
        checkNotNull(skillsNonCombatPoints,
                "Received a null pointer as non combat skills points");
        checkNotNull(money, "Received a null pointer as money");

        this.name = name;

        this.money = money;

        this.skillsGroupPoints = skillsGroupPoints;

        this.skillsGroup = skillsGroup;

        this.skillsPoints = skillsPoints;

        this.skillsNonCombatPoints = skillsNonCombatPoints;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultFatherClassBonus other = (DefaultFatherClassBonus) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public final String getFatherClass() {
        return name;
    }

    @Override
    public final Money getMoney() {
        return money;
    }

    @Override
    public final Integer getNonCombatSkillsPoints() {
        return skillsNonCombatPoints;
    }

    @Override
    public final Collection<String> getSkillsGroup() {
        return Collections.unmodifiableCollection(getSkillsGroupModifiable());
    }

    @Override
    public final Integer getSkillsGroupPoints() {
        return skillsGroupPoints;
    }

    @Override
    public final Integer getSkillsPoints() {
        return skillsPoints;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

    private final Collection<String> getSkillsGroupModifiable() {
        return skillsGroup;
    }

}
