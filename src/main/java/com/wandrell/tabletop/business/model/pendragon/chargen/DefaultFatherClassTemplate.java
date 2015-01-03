package com.wandrell.tabletop.business.model.pendragon.chargen;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.dice.Dice;
import com.wandrell.tabletop.business.model.skill.NameAndDescriptor;

public final class DefaultFatherClassTemplate implements FatherClassTemplate {

    private final Map<NameAndDescriptor, Integer> directedTraits;
    private final Map<NameAndDescriptor, Integer> directedTraitsBase;
    private final Dice                            money;
    private final String                          name;
    private final Collection<NameAndDescriptor>   skillsGroup;
    private final Integer                         skillsGroupPointsBonus;
    private final Integer                         skillsGroupPointsDivide;
    private final Integer                         skillsNonCombatPoints;
    private final Integer                         skillsPoints;
    private final Map<String, Integer>            specialtySkills;

    public DefaultFatherClassTemplate(final String name,
            final Integer skillsGroupPoints,
            final Integer skillsGroupPointsDivide, final Integer skillsPoints,
            final Integer skillsNonCombatPoints, final Dice money,
            final Collection<NameAndDescriptor> skillsGroup,
            final Map<String, Integer> specialtySkills,
            final Map<NameAndDescriptor, Integer> directedTraits,
            final Map<NameAndDescriptor, Integer> directedTraitsBase) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(skillsPoints, "Received a null pointer as skills points");
        checkNotNull(skillsNonCombatPoints,
                "Received a null pointer as non combat skills points");
        checkNotNull(money, "Received a null pointer as money");
        checkNotNull(skillsGroupPoints,
                "Received a null pointer as skills group points to add");
        checkNotNull(skillsGroupPointsDivide,
                "Received a null pointer as skills group points to divide");
        checkNotNull(skillsGroup, "Received a null pointer as skills group");
        checkNotNull(directedTraits,
                "Received a null pointer as directed traits bonus");
        checkNotNull(directedTraitsBase,
                "Received a null pointer as directed traits base values");
        checkNotNull(specialtySkills,
                "Received a null pointer as specialty skills");

        this.name = name;

        this.money = money;

        this.skillsGroupPointsBonus = skillsGroupPoints;
        this.skillsGroupPointsDivide = skillsGroupPointsDivide;

        this.skillsGroup = skillsGroup;
        this.specialtySkills = specialtySkills;

        this.directedTraits = directedTraits;
        this.directedTraitsBase = directedTraitsBase;

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
        DefaultFatherClassTemplate other = (DefaultFatherClassTemplate) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public final Map<NameAndDescriptor, Integer> getDirectedTraits() {
        return Collections.unmodifiableMap(getDirectedTraitsModifiable());
    }

    @Override
    public final Map<NameAndDescriptor, Integer> getDirectedTraitsBase() {
        return Collections.unmodifiableMap(getDirectedTraitsBaseModifiable());
    }

    @Override
    public final Dice getMoney() {
        return money;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Integer getNonCombatSkillBonus() {
        return skillsNonCombatPoints;
    }

    @Override
    public final Collection<NameAndDescriptor> getSkillsGroup() {
        return Collections.unmodifiableCollection(getSkillsGroupModifiable());
    }

    @Override
    public final Integer getSkillsGroupBonusPoints() {
        return skillsGroupPointsBonus;
    }

    @Override
    public final Integer getSkillsGroupDividePoints() {
        return skillsGroupPointsDivide;
    }

    @Override
    public final Integer getSkillsPoints() {
        return skillsPoints;
    }

    @Override
    public final Map<String, Integer> getSpecialtySkills() {
        return Collections.unmodifiableMap(getSpecialtySkillsModifiable());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

    private final Map<NameAndDescriptor, Integer>
            getDirectedTraitsBaseModifiable() {
        return directedTraitsBase;
    }

    private final Map<NameAndDescriptor, Integer> getDirectedTraitsModifiable() {
        return directedTraits;
    }

    private final Collection<NameAndDescriptor> getSkillsGroupModifiable() {
        return skillsGroup;
    }

    private final Map<String, Integer> getSpecialtySkillsModifiable() {
        return specialtySkills;
    }

}
