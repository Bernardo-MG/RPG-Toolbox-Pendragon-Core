package com.wandrell.tabletop.business.model.pendragon.chargen;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collections;
import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public final class DefaultHomelandBonus implements HomelandBonus {

    private final Map<String, String>  directedTraits;
    private final String               name;
    private final Map<String, String>  passions;
    private final Map<String, Integer> skills;
    private final Map<String, Integer> traits;

    public DefaultHomelandBonus(final String name,
            final Map<String, Integer> traits,
            final Map<String, Integer> skills,
            final Map<String, String> passions,
            final Map<String, String> directedTraits) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(traits, "Received a null pointer as traits");
        checkNotNull(skills, "Received a null pointer as skills");
        checkNotNull(passions, "Received a null pointer as dpassions");
        checkNotNull(directedTraits,
                "Received a null pointer as directed traits");

        this.name = name;

        this.traits = traits;
        this.skills = skills;
        this.passions = passions;
        this.directedTraits = directedTraits;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultHomelandBonus other = (DefaultHomelandBonus) obj;
        return Objects.equal(name, other.name);
    }

    @Override
    public final Map<String, String> getDirectedTraitsBonus() {
        return Collections.unmodifiableMap(getDirectedTraitsBonusModifiable());
    }

    @Override
    public final String getHomeland() {
        return name;
    }

    @Override
    public final Map<String, String> getPassionsBonus() {
        return Collections.unmodifiableMap(getPassionsBonusModifiable());
    }

    @Override
    public final Map<String, Integer> getSkillsBonus() {
        return Collections.unmodifiableMap(getSkillsBonusModifiable());
    }

    @Override
    public final Map<String, Integer> getTraitsBonus() {
        return Collections.unmodifiableMap(getTraitsBonusModifiable());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

    private final Map<String, String> getDirectedTraitsBonusModifiable() {
        return directedTraits;
    }

    private final Map<String, String> getPassionsBonusModifiable() {
        return passions;
    }

    private final Map<String, Integer> getSkillsBonusModifiable() {
        return skills;
    }

    private final Map<String, Integer> getTraitsBonusModifiable() {
        return traits;
    }

}
