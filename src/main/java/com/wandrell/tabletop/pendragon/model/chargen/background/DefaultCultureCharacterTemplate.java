package com.wandrell.tabletop.pendragon.model.chargen.background;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;

import com.wandrell.tabletop.pendragon.model.character.stats.AttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.AttributesRandom;
import com.wandrell.tabletop.pendragon.model.character.stats.RandomSkill;
import com.wandrell.tabletop.pendragon.model.character.stats.TraitsHolder;
import com.wandrell.tabletop.stats.valuebox.SkillBox;

public final class DefaultCultureCharacterTemplate implements
        CultureCharacterTemplate {

    private final AttributesHolder        attributes;
    private final AttributesRandom        attributesRandom;
    private final Collection<SkillBox>    directedTraits;
    private final Collection<SkillBox>    passions;
    private final Collection<RandomSkill> passionsRandom;
    private final Collection<SkillBox>    skills;
    private final Collection<SkillBox>    specialtySkills;
    private final TraitsHolder            traits;

    public DefaultCultureCharacterTemplate(final AttributesHolder attributes,
            final AttributesRandom attributesRandom,
            final Collection<SkillBox> skills,
            final Collection<SkillBox> specialtySkills,
            final TraitsHolder traits,
            final Collection<SkillBox> directedTraits,
            final Collection<SkillBox> passions,
            final Collection<RandomSkill> passionsRandom) {
        super();

        checkNotNull(attributes, "Received a null pointer as attributes");
        checkNotNull(attributesRandom,
                "Received a null pointer as random attributes");
        checkNotNull(skills, "Received a null pointer as skills");
        checkNotNull(specialtySkills,
                "Received a null pointer as specialty skills");
        checkNotNull(traits, "Received a null pointer as traits");
        checkNotNull(directedTraits,
                "Received a null pointer as directed traits");
        checkNotNull(passions, "Received a null pointer as passions");
        checkNotNull(passionsRandom,
                "Received a null pointer as random passions");

        this.attributes = attributes;
        this.attributesRandom = attributesRandom;
        this.skills = skills;
        this.specialtySkills = specialtySkills;
        this.traits = traits;
        this.directedTraits = directedTraits;
        this.passions = passions;
        this.passionsRandom = passionsRandom;
    }

    @Override
    public final AttributesHolder getAttributes() {
        return attributes;
    }

    @Override
    public final AttributesRandom getAttributesRandom() {
        return attributesRandom;
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
    public final Collection<RandomSkill> getPassionsRandom() {
        return Collections
                .unmodifiableCollection(getPassionsRandomModifiable());
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
    public final TraitsHolder getTraits() {
        return traits;
    }

    private final Collection<SkillBox> getDirectedTraitsModifiable() {
        return directedTraits;
    }

    private final Collection<SkillBox> getPassionsModifiable() {
        return passions;
    }

    private final Collection<RandomSkill> getPassionsRandomModifiable() {
        return passionsRandom;
    }

    private final Collection<SkillBox> getSkillsModifiable() {
        return skills;
    }

    private final Collection<SkillBox> getSpecialtySkillsModifiable() {
        return specialtySkills;
    }

}
