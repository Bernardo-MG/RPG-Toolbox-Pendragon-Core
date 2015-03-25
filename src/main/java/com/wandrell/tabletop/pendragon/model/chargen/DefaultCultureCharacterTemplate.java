package com.wandrell.tabletop.pendragon.model.chargen;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.valuebox.SkillBox;

public final class DefaultCultureCharacterTemplate implements
        CultureCharacterTemplate {

    private final Collection<SkillBox> attributes;
    private final Map<String, Dice>    attributesRandom;
    private final Collection<SkillBox> directedTraits;
    private final Collection<SkillBox> passions;
    private final Map<SkillBox, Dice>  passionsRandom;
    private final Collection<SkillBox> skills;
    private final Collection<SkillBox> specialtySkills;
    private final Collection<SkillBox> traits;

    public DefaultCultureCharacterTemplate(
            final Collection<SkillBox> attributes,
            final Map<String, Dice> attributesRandom,
            final Collection<SkillBox> skills,
            final Collection<SkillBox> specialtySkills,
            final Collection<SkillBox> traits,
            final Collection<SkillBox> directedTraits,
            final Collection<SkillBox> passions,
            Map<SkillBox, Dice> passionsRandom) {
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
    public final Collection<SkillBox> getAttributes() {
        return Collections.unmodifiableCollection(getAttributesModifiable());
    }

    @Override
    public final Map<String, Dice> getAttributesRandom() {
        return Collections.unmodifiableMap(getAttributesRandomModifiable());
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
    public final Map<SkillBox, Dice> getPassionsRandom() {
        return Collections.unmodifiableMap(getPassionsRandomModifiable());
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
    public final Collection<SkillBox> getTraits() {
        return Collections.unmodifiableCollection(getTraitsModifiable());
    }

    private final Collection<SkillBox> getAttributesModifiable() {
        return attributes;
    }

    private final Map<String, Dice> getAttributesRandomModifiable() {
        return attributesRandom;
    }

    private final Collection<SkillBox> getDirectedTraitsModifiable() {
        return directedTraits;
    }

    private final Collection<SkillBox> getPassionsModifiable() {
        return passions;
    }

    private final Map<SkillBox, Dice> getPassionsRandomModifiable() {
        return passionsRandom;
    }

    private final Collection<SkillBox> getSkillsModifiable() {
        return skills;
    }

    private final Collection<SkillBox> getSpecialtySkillsModifiable() {
        return specialtySkills;
    }

    private final Collection<SkillBox> getTraitsModifiable() {
        return traits;
    }

}
