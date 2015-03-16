package com.wandrell.tabletop.pendragon.model.chargen;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.skill.SkillName;

public final class DefaultFatherClassTemplate implements FatherClassTemplate {

    private final Map<SkillName, Integer> directedTraits;
    private final Map<SkillName, Integer> directedTraitsBase;
    private final Dice                    money;
    private final String                  name;
    private final Collection<SkillName>   skillsGroup;
    private final Integer                 skillsGroupPointsBonus;
    private final Integer                 skillsGroupPointsDivide;
    private final Integer                 skillsNonCombatPoints;
    private final Integer                 skillsPoints;
    private final Map<String, Integer>    specialtySkills;

    public DefaultFatherClassTemplate(
            final DefaultFatherClassTemplate fatherClass) {
        super();

        checkNotNull(fatherClass, "Received a null pointer as father class");

        name = fatherClass.name;

        money = fatherClass.money;

        skillsGroupPointsBonus = fatherClass.skillsGroupPointsBonus;
        skillsGroupPointsDivide = fatherClass.skillsGroupPointsDivide;

        // TODO: Copy this correctly
        skillsGroup = new LinkedList<>(fatherClass.skillsGroup);
        specialtySkills = new LinkedHashMap<>(fatherClass.specialtySkills);

        // TODO: Copy this correctly
        directedTraits = new LinkedHashMap<>(fatherClass.directedTraits);
        directedTraitsBase = new LinkedHashMap<>(fatherClass.directedTraitsBase);

        skillsPoints = fatherClass.skillsPoints;

        skillsNonCombatPoints = fatherClass.skillsNonCombatPoints;
    }

    public DefaultFatherClassTemplate(final String name,
            final Integer skillsGroupPoints,
            final Integer skillsGroupPointsDivide, final Integer skillsPoints,
            final Integer skillsNonCombatPoints, final Dice money,
            final Collection<SkillName> skillsGroup,
            final Map<String, Integer> specialtySkills,
            final Map<SkillName, Integer> directedTraits,
            final Map<SkillName, Integer> directedTraitsBase) {
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
    public final DefaultFatherClassTemplate createNewInstance() {
        return new DefaultFatherClassTemplate(this);
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
    public final Map<SkillName, Integer> getDirectedTraits() {
        return Collections.unmodifiableMap(getDirectedTraitsModifiable());
    }

    @Override
    public final Map<SkillName, Integer> getDirectedTraitsBase() {
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
    public final Collection<SkillName> getSkillsGroup() {
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

    private final Map<SkillName, Integer> getDirectedTraitsBaseModifiable() {
        return directedTraitsBase;
    }

    private final Map<SkillName, Integer> getDirectedTraitsModifiable() {
        return directedTraits;
    }

    private final Collection<SkillName> getSkillsGroupModifiable() {
        return skillsGroup;
    }

    private final Map<String, Integer> getSpecialtySkillsModifiable() {
        return specialtySkills;
    }

}
