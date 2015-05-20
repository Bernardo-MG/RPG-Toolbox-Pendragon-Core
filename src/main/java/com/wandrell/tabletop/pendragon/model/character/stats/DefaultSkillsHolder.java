package com.wandrell.tabletop.pendragon.model.character.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import com.wandrell.tabletop.stats.valuebox.DefaultSkillBox;
import com.wandrell.tabletop.stats.valuebox.SkillBox;

public final class DefaultSkillsHolder implements SkillsHolder {

    private final Collection<SkillBox>          directedTraits  = new LinkedHashSet<SkillBox>();
    private final Collection<SkillBox>          passions        = new LinkedHashSet<SkillBox>();
    private final Collection<PendragonSkillBox> skills          = new LinkedHashSet<PendragonSkillBox>();
    private final Collection<SpecialtySkillBox> skillsSpecialty = new LinkedHashSet<SpecialtySkillBox>();

    public DefaultSkillsHolder() {
        super();
    }

    public DefaultSkillsHolder(final DefaultSkillsHolder skills) {
        super();

        for (final SkillBox passion : skills.passions) {
            passions.add(new DefaultSkillBox(passion.getName(), passion
                    .getDescriptor(), passion.getValue()));
        }

        for (final SpecialtySkillBox skill : skills.skillsSpecialty) {
            skillsSpecialty.add(new DefaultSpecialtySkillBox(skill));
        }

        for (final PendragonSkillBox skill : skills.skills) {
            this.skills.add(new DefaultPendragonSkillBox(skill));
        }

        for (final SkillBox skill : skills.directedTraits) {
            directedTraits.add(new DefaultSkillBox(skill.getName(), skill
                    .getDescriptor(), skill.getValue()));
        }
    }

    @Override
    public final void addDirectedTrait(final SkillBox trait) {
        checkNotNull(trait, "Received a null pointer as trait");

        getDirectedTraitsModifiable().add(trait);
    }

    @Override
    public final void addPassion(final SkillBox passion) {
        checkNotNull(passion, "Received a null pointer as passion");

        getPassionsModifiable().add(passion);
    }

    @Override
    public final void addSkill(final PendragonSkillBox skill) {
        checkNotNull(skill, "Received a null pointer as skill");

        getSkillsModifiable().add(skill);
        registerIntoSpecialtySkill(skill);
    }

    @Override
    public final void addSpecialtySkill(final SpecialtySkillBox skill) {
        checkNotNull(skill, "Received a null pointer as specialty skill");

        getSpecialtySkillsModifiable().add(skill);
        assembleSpecialtySkill(skill);
    }

    @Override
    public final void clearDirectedTraits() {
        getDirectedTraitsModifiable().clear();
    }

    @Override
    public final void clearPassions() {
        getPassionsModifiable().clear();
    }

    @Override
    public final void clearSkills() {
        getSkillsModifiable().clear();
        ;
    }

    @Override
    public final void clearSpecialtySkills() {
        getSpecialtySkillsModifiable().clear();
    }

    @Override
    public DefaultSkillsHolder createNewInstance() {
        return new DefaultSkillsHolder(this);
    }

    @Override
    public final Collection<SkillBox> getDirectedTraits() {
        return Collections
                .unmodifiableCollection(getDirectedTraitsModifiable());
    }

    @Override
    public final Collection<SkillBox> getPassions() {
        return Collections.unmodifiableCollection(getPassionsModifiable());
    }

    @Override
    public final Collection<PendragonSkillBox> getSkills() {
        return Collections.unmodifiableCollection(getSkillsModifiable());
    }

    @Override
    public final Collection<SpecialtySkillBox> getSpecialtySkills() {
        return Collections
                .unmodifiableCollection(getSpecialtySkillsModifiable());
    }

    @Override
    public final void removeDirectedTrait(final SkillBox directedTrait) {
        getDirectedTraitsModifiable().remove(directedTrait);
    }

    @Override
    public final void removePassion(final SkillBox passion) {
        getPassionsModifiable().remove(passion);
    }

    @Override
    public final void removeSkill(final PendragonSkillBox skill) {
        getSkillsModifiable().remove(skill);
    }

    @Override
    public final void removeSpecialtySkill(final SpecialtySkillBox skill) {
        getSpecialtySkillsModifiable().remove(skill);
    }

    @Override
    public final void setDirectedTraits(final Collection<SkillBox> traits) {
        checkNotNull(traits, "Received a null pointer as directed traits");

        getDirectedTraitsModifiable().clear();
        for (final SkillBox trait : traits) {
            addDirectedTrait(trait);
        }
    }

    @Override
    public final void setPassions(final Collection<SkillBox> passions) {
        checkNotNull(passions, "Received a null pointer as passions");

        getPassionsModifiable().clear();
        for (final SkillBox passion : passions) {
            addPassion(passion);
        }
    }

    @Override
    public final void setSkills(final Collection<PendragonSkillBox> skills) {
        checkNotNull(skills, "Received a null pointer as skills");

        getSkillsModifiable().clear();

        for (final PendragonSkillBox skill : skills) {
            getSkillsModifiable().add(skill);
        }
    }

    @Override
    public final void setSpecialtySkills(
            final Collection<SpecialtySkillBox> skills) {
        checkNotNull(skills, "Received a null pointer as specialty skills");

        getSpecialtySkillsModifiable().clear();
        for (final SpecialtySkillBox skill : skills) {
            addSpecialtySkill(skill);
        }
    }

    private final void
            assembleSpecialtySkill(final SpecialtySkillBox vhAdvSkill) {
        // for (final String skill : vhAdvSkill.getSurrogatedSkills()) {
        // if (hasSkill(skill, "")) {
        // TODO: Do somehow
        // vhAdvSkill.registerSkill(getSkill(skill, ""));
        // }
        // }
    }

    private final Collection<SkillBox> getDirectedTraitsModifiable() {
        return directedTraits;
    }

    private final Collection<SkillBox> getPassionsModifiable() {
        return passions;
    }

    private final Collection<PendragonSkillBox> getSkillsModifiable() {
        return skills;
    }

    private final Collection<SpecialtySkillBox> getSpecialtySkillsModifiable() {
        return skillsSpecialty;
    }

    private final void registerIntoSpecialtySkill(
            final PendragonSkillBox vhSkill) {
        // for (final SpecialtySkill skill : getSpecialtySkills()) {
        // TODO: Do somehow
        // if (skill.isSkillContained(vhSkill.getName())) {
        // skill.registerSkill(vhSkill);
        // }
        // }
    }

}
