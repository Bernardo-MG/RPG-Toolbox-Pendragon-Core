package com.wandrell.tabletop.business.model.pendragon.chargen;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collections;
import java.util.Map;

import com.wandrell.tabletop.business.model.dice.Dice;
import com.wandrell.tabletop.business.model.skill.NameAndDescriptor;

public final class DefaultCultureCharacterRandomTemplate implements
        CultureCharacterRandomTemplate {

    private final Map<String, Dice>            attributes;
    private final Map<NameAndDescriptor, Dice> directedTraits;
    private final Map<NameAndDescriptor, Dice> passions;
    private final Map<NameAndDescriptor, Dice> skills;
    private final Map<String, Dice>            specialtySkills;
    private final Map<String, Dice>            traits;

    public DefaultCultureCharacterRandomTemplate(
            final Map<String, Dice> attributes,
            final Map<NameAndDescriptor, Dice> skills,
            final Map<String, Dice> specialtySkills,
            final Map<String, Dice> traits,
            final Map<NameAndDescriptor, Dice> directedTraits,
            final Map<NameAndDescriptor, Dice> passions) {
        super();

        checkNotNull(attributes, "Received a null pointer as attributes");
        checkNotNull(skills, "Received a null pointer as skills");
        checkNotNull(specialtySkills,
                "Received a null pointer as specialty skills");
        checkNotNull(traits, "Received a null pointer as traits");
        checkNotNull(directedTraits,
                "Received a null pointer as directed traits");
        checkNotNull(passions, "Received a null pointer as passions");

        this.attributes = attributes;
        this.skills = skills;
        this.specialtySkills = specialtySkills;
        this.traits = traits;
        this.directedTraits = directedTraits;
        this.passions = passions;
    }

    @Override
    public final Map<String, Dice> getAttributes() {
        return Collections.unmodifiableMap(getAttributesModifiable());
    }

    @Override
    public final Map<NameAndDescriptor, Dice> getDirectedTraits() {
        return Collections.unmodifiableMap(getDirectedTraitsModifiable());
    }

    @Override
    public final Map<NameAndDescriptor, Dice> getPassions() {
        return Collections.unmodifiableMap(getPassionsModifiable());
    }

    @Override
    public final Map<NameAndDescriptor, Dice> getSkills() {
        return Collections.unmodifiableMap(getSkillsModifiable());
    }

    @Override
    public final Map<String, Dice> getSpecialtySkills() {
        return Collections.unmodifiableMap(getSpecialtySkillsModifiable());
    }

    @Override
    public final Map<String, Dice> getTraits() {
        return Collections.unmodifiableMap(getTraitsModifiable());
    }

    private final Map<String, Dice> getAttributesModifiable() {
        return attributes;
    }

    private final Map<NameAndDescriptor, Dice> getDirectedTraitsModifiable() {
        return directedTraits;
    }

    private final Map<NameAndDescriptor, Dice> getPassionsModifiable() {
        return passions;
    }

    private final Map<NameAndDescriptor, Dice> getSkillsModifiable() {
        return skills;
    }

    private final Map<String, Dice> getSpecialtySkillsModifiable() {
        return specialtySkills;
    }

    private final Map<String, Dice> getTraitsModifiable() {
        return traits;
    }

}
