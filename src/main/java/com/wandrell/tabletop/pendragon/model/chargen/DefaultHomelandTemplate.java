package com.wandrell.tabletop.pendragon.model.chargen;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.wandrell.tabletop.skill.NameAndDescriptor;

public final class DefaultHomelandTemplate implements HomelandTemplate {

    private final Collection<NameAndDescriptor>   directedTraits  = new LinkedList<NameAndDescriptor>();
    private final String                          name;
    private final Collection<NameAndDescriptor>   passions        = new LinkedList<NameAndDescriptor>();
    private final Map<NameAndDescriptor, Integer> skills          = new LinkedHashMap<NameAndDescriptor, Integer>();
    private final Map<String, Integer>            specialtySkills = new LinkedHashMap<String, Integer>();
    private final Map<String, Integer>            traits          = new LinkedHashMap<String, Integer>();

    public DefaultHomelandTemplate(final String name,
            final Map<NameAndDescriptor, Integer> skills,
            final Map<String, Integer> specialtySkills,
            final Map<String, Integer> traits,
            final Collection<NameAndDescriptor> directedTraits,
            final Collection<NameAndDescriptor> passions) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(skills, "Received a null pointer as skills");
        checkNotNull(specialtySkills,
                "Received a null pointer as specialty skills");
        checkNotNull(traits, "Received a null pointer as traits");
        checkNotNull(directedTraits,
                "Received a null pointer as directed traits");
        checkNotNull(passions, "Received a null pointer as passions");

        this.name = name;

        this.skills.putAll(skills);
        this.specialtySkills.putAll(specialtySkills);
        this.traits.putAll(traits);
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
    public final Collection<NameAndDescriptor> getDirectedTraits() {
        return Collections
                .unmodifiableCollection(getDirectedTraitsModifiable());
    }

    @Override
    public final String getHomeland() {
        return name;
    }

    @Override
    public final Collection<NameAndDescriptor> getPassions() {
        return Collections.unmodifiableCollection(getPassionsModifiable());
    }

    @Override
    public final Map<NameAndDescriptor, Integer> getSkills() {
        return Collections.unmodifiableMap(getSkillsModifiable());
    }

    @Override
    public final Map<String, Integer> getSpecialtySkills() {
        return Collections.unmodifiableMap(getSpecialtySkillsModifiable());
    }

    @Override
    public final Map<String, Integer> getTraits() {
        return Collections.unmodifiableMap(getTraitsModifiable());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

    private final Collection<NameAndDescriptor> getDirectedTraitsModifiable() {
        return directedTraits;
    }

    private final Collection<NameAndDescriptor> getPassionsModifiable() {
        return passions;
    }

    private final Map<NameAndDescriptor, Integer> getSkillsModifiable() {
        return skills;
    }

    private final Map<String, Integer> getSpecialtySkillsModifiable() {
        return specialtySkills;
    }

    private final Map<String, Integer> getTraitsModifiable() {
        return traits;
    }

}
