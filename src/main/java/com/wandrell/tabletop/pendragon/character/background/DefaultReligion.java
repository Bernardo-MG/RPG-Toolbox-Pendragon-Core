package com.wandrell.tabletop.pendragon.character.background;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public final class DefaultReligion implements Religion {

    private final Integer              bonusArmor;
    private final Integer              bonusDamage;
    private final Map<String, Integer> bonusDerived;
    private final String               name;
    private final Collection<String>   traits;

    public DefaultReligion(final DefaultReligion religion) {
        super();

        name = religion.name;

        traits = religion.traits;

        bonusDerived = religion.bonusDerived;

        bonusArmor = religion.bonusArmor;
        bonusDamage = religion.bonusDamage;
    }

    public DefaultReligion(final String name,
            final Map<String, Integer> bonusDerived, final Integer bonusArmor,
            final Integer bonusDamage, final Collection<String> traits) {
        super();

        if (name == null) {
            throw new NullPointerException();
        }

        if (bonusDerived == null) {
            throw new NullPointerException();
        }

        if (bonusArmor == null) {
            throw new NullPointerException();
        }

        if (bonusDamage == null) {
            throw new NullPointerException();
        }

        if (traits == null) {
            throw new NullPointerException();
        }

        this.name = name;

        this.bonusDerived = bonusDerived;

        this.bonusArmor = bonusArmor;

        this.bonusDamage = bonusDamage;

        this.traits = traits;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultReligion other = (DefaultReligion) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public final Integer getArmorBonus() {
        return bonusArmor;
    }

    @Override
    public final Integer getDamageBonus() {
        return bonusDamage;
    }

    @Override
    public final Integer getDerivedAttributeBonus(final String name) {
        return getDerivedAttributesBonus().get(name);
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Collection<String> getReligiousTraits() {
        return Collections.unmodifiableCollection(_getReligiousTraits());
    }

    @Override
    public final Boolean hasDerivedAttributeBonus(final String name) {
        return getDerivedAttributesBonus().containsKey(name);
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public final Boolean hasTrait(final String trait) {
        return _getReligiousTraits().contains(trait);
    }

    @Override
    public final String toString() {
        return getName();
    }

    protected final Collection<String> _getReligiousTraits() {
        return traits;
    }

    protected final Map<String, Integer> getDerivedAttributesBonus() {
        return bonusDerived;
    }

}
