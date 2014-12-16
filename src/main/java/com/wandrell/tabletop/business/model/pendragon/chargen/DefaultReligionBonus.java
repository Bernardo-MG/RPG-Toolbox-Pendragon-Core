package com.wandrell.tabletop.business.model.pendragon.chargen;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

import com.google.common.base.MoreObjects;

public final class DefaultReligionBonus implements ReligionBonus {

    private final Integer              bonusArmor;
    private final Integer              bonusDamage;
    private final Map<String, Integer> bonusDerived;
    private final String               name;
    private final Collection<String>   traits;

    public DefaultReligionBonus(final String name,
            final Map<String, Integer> bonusDerived, final Integer bonusArmor,
            final Integer bonusDamage, final Collection<String> traits) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(bonusDerived,
                "Received a null pointer as derived attributes bonus");
        checkNotNull(bonusArmor, "Received a null pointer as armor bonus");
        checkNotNull(bonusDamage, "Received a null pointer as damage bonus");
        checkNotNull(traits, "Received a null pointer as traits");

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
        DefaultReligionBonus other = (DefaultReligionBonus) obj;
        return Objects.equals(name, other.name);
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
    public final Map<String, Integer> getDerivedAttributeBonus() {
        return Collections
                .unmodifiableMap(getDerivedAttributesBonusModifiable());
    }

    @Override
    public final String getReligion() {
        return name;
    }

    @Override
    public final Collection<String> getReligiousTraits() {
        return Collections
                .unmodifiableCollection(getReligiousTraitsModifiable());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

    private final Map<String, Integer> getDerivedAttributesBonusModifiable() {
        return bonusDerived;
    }

    private final Collection<String> getReligiousTraitsModifiable() {
        return traits;
    }

}
