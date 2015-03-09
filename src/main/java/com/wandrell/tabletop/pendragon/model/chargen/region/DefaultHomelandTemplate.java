package com.wandrell.tabletop.pendragon.model.chargen.region;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.wandrell.tabletop.skill.SkillName;

public final class DefaultHomelandTemplate implements HomelandTemplate {

    private final Collection<SkillName>   directedTraits  = new LinkedList<SkillName>();
    private final String                  name;
    private final Collection<SkillName>   passions        = new LinkedList<SkillName>();
    private final RegionTemplate          region;
    private final Map<SkillName, Integer> skills          = new LinkedHashMap<SkillName, Integer>();
    private final Map<String, Integer>    specialtySkills = new LinkedHashMap<String, Integer>();

    public DefaultHomelandTemplate(final String name,
            final RegionTemplate region, final Map<SkillName, Integer> skills,
            final Map<String, Integer> specialtySkills,
            final Collection<SkillName> directedTraits,
            final Collection<SkillName> passions) {
        super();

        checkNotNull(region, "Received a null pointer as region");
        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(skills, "Received a null pointer as skills");
        checkNotNull(specialtySkills,
                "Received a null pointer as specialty skills");
        checkNotNull(directedTraits,
                "Received a null pointer as directed traits");
        checkNotNull(passions, "Received a null pointer as passions");

        this.name = name;
        this.region = region;

        this.skills.putAll(skills);
        this.specialtySkills.putAll(specialtySkills);
        this.directedTraits.addAll(directedTraits);
        this.passions.addAll(passions);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultHomelandTemplate other = (DefaultHomelandTemplate) obj;
        return Objects.equal(name, other.name);
    }

    @Override
    public final Collection<SkillName> getDirectedTraits() {
        return Collections
                .unmodifiableCollection(getDirectedTraitsModifiable());
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Collection<SkillName> getPassions() {
        return Collections.unmodifiableCollection(getPassionsModifiable());
    }

    @Override
    public final RegionTemplate getRegion() {
        return region;
    }

    @Override
    public final Map<SkillName, Integer> getSkills() {
        return Collections.unmodifiableMap(getSkillsModifiable());
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

    private final Collection<SkillName> getDirectedTraitsModifiable() {
        return directedTraits;
    }

    private final Collection<SkillName> getPassionsModifiable() {
        return passions;
    }

    private final Map<SkillName, Integer> getSkillsModifiable() {
        return skills;
    }

    private final Map<String, Integer> getSpecialtySkillsModifiable() {
        return specialtySkills;
    }

}
