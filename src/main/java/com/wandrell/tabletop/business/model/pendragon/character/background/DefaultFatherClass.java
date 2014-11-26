package com.wandrell.tabletop.business.model.pendragon.character.background;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import com.wandrell.tabletop.business.model.pendragon.inventory.Money;

public final class DefaultFatherClass implements FatherClass {

    private final Money                money;
    private final String               name;
    private final Collection<String>   skillsGroup;
    private final Integer              skillsGroupPoints;
    private final Map<String, Integer> skillsPoints;

    public DefaultFatherClass(final DefaultFatherClass data) {
        super();

        name = data.name;

        skillsGroup = data.skillsGroup;

        skillsPoints = data.skillsPoints;

        money = data.money.createNewInstance();

        skillsGroupPoints = data.skillsGroupPoints;
    }

    public DefaultFatherClass(final String name,
            final Integer skillsGroupPoints,
            final Collection<String> skillsGroup,
            final Map<String, Integer> skillsPoints, final Money money) {
        super();

        if (name == null) {
            throw new NullPointerException();
        }

        if (money == null) {
            throw new NullPointerException();
        }

        if (skillsGroupPoints == null) {
            throw new NullPointerException();
        }

        if (skillsGroup == null) {
            throw new NullPointerException();
        }

        if (skillsPoints == null) {
            throw new NullPointerException();
        }

        this.name = name;

        this.money = money;

        this.skillsGroupPoints = skillsGroupPoints;

        this.skillsGroup = skillsGroup;

        this.skillsPoints = skillsPoints;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultFatherClass other = (DefaultFatherClass) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public final Money getMoney() {
        return money;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Collection<String> getSkillsGroup() {
        return Collections.unmodifiableCollection(_getSkillsGroup());
    }

    @Override
    public final Integer getSkillsGroupPoints() {
        return skillsGroupPoints;
    }

    @Override
    public final Map<String, Integer> getSkillsPoints() {
        return Collections.unmodifiableMap(_getSkillsPoints());
    }

    @Override
    public final Integer getSkillsPoints(final String name) {
        return _getSkillsPoints().get(name);
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public final Boolean hasSkillsPoints(final String name) {
        return _getSkillsPoints().containsKey(name);
    }

    @Override
    public final String toString() {
        return getName();
    }

    protected final Collection<String> _getSkillsGroup() {
        return skillsGroup;
    }

    protected final Map<String, Integer> _getSkillsPoints() {
        return skillsPoints;
    }

}
