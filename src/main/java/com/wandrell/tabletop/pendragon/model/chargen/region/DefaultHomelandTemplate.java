package com.wandrell.tabletop.pendragon.model.chargen.region;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.wandrell.tabletop.valuebox.SkillBox;

public final class DefaultHomelandTemplate implements HomelandTemplate {

    private final Collection<SkillBox> directedTraits  = new LinkedList<>();
    private final String               name;
    private final Collection<SkillBox> passions        = new LinkedList<>();
    private final RegionTemplate       region;
    private final Collection<SkillBox> skills          = new LinkedList<>();
    private final Collection<SkillBox> specialtySkills = new LinkedList<>();

    public DefaultHomelandTemplate(final DefaultHomelandTemplate homeland) {
        super();

        checkNotNull(homeland, "Received a null pointer as homeland");

        name = homeland.name;
        region = homeland.region;

        skills.addAll(homeland.skills);
        specialtySkills.addAll(homeland.specialtySkills);
        directedTraits.addAll(homeland.directedTraits);
        passions.addAll(homeland.passions);
    }

    public DefaultHomelandTemplate(final String name,
            final RegionTemplate region, final Collection<SkillBox> skills,
            final Collection<SkillBox> specialtySkills,
            final Collection<SkillBox> directedTraits,
            final Collection<SkillBox> passions) {
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

        this.skills.addAll(skills);
        this.specialtySkills.addAll(specialtySkills);
        this.directedTraits.addAll(directedTraits);
        this.passions.addAll(passions);
    }

    @Override
    public final DefaultHomelandTemplate createNewInstance() {
        return new DefaultHomelandTemplate(this);
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
    public final Collection<SkillBox> getDirectedTraits() {
        return Collections
                .unmodifiableCollection(getDirectedTraitsModifiable());
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Collection<SkillBox> getPassions() {
        return Collections.unmodifiableCollection(getPassionsModifiable());
    }

    @Override
    public final RegionTemplate getRegion() {
        return region;
    }

    @Override
    public final Collection<SkillBox> getSkills() {
        return Collections.unmodifiableCollection(getSkillsModifiable());
    }

    @Override
    public final Collection<SkillBox> getSpecialtySkills() {
        return Collections
                .unmodifiableCollection(getSpecialtySkillsModifiable());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

    private final Collection<SkillBox> getDirectedTraitsModifiable() {
        return directedTraits;
    }

    private final Collection<SkillBox> getPassionsModifiable() {
        return passions;
    }

    private final Collection<SkillBox> getSkillsModifiable() {
        return skills;
    }

    private final Collection<SkillBox> getSpecialtySkillsModifiable() {
        return specialtySkills;
    }

}
