package com.wandrell.tabletop.business.model.pendragon.character.background;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collections;
import java.util.Map;

public final class DefaultCultureCharacterTemplate implements
        CultureCharacterTemplate {

    private final Map<String, Integer> attributes;
    private final Map<String, Integer> derivedAttributes;
    private final Map<String, Integer> directedTraits;
    private final Map<String, Integer> exclusiveSkills;
    private final Map<String, Integer> passions;
    private final Map<String, Integer> skills;
    private final Map<String, Integer> specialtySkills;
    private final Map<String, Integer> traits;

    public DefaultCultureCharacterTemplate(
            final Map<String, Integer> attributes,
            final Map<String, Integer> derivedAttributes,
            final Map<String, Integer> skills,
            final Map<String, Integer> exclusiveSkills,
            final Map<String, Integer> specialtySkills,
            final Map<String, Integer> traits,
            final Map<String, Integer> directedTraits,
            final Map<String, Integer> passions) {
        super();

        checkNotNull(attributes, "Received a null pointer as attributes");
        checkNotNull(derivedAttributes,
                "Received a null pointer as derived attributes");
        checkNotNull(skills, "Received a null pointer as skills");
        checkNotNull(exclusiveSkills,
                "Received a null pointer as exclusive skills");
        checkNotNull(specialtySkills,
                "Received a null pointer as specialty skills");
        checkNotNull(traits, "Received a null pointer as traits");
        checkNotNull(directedTraits,
                "Received a null pointer as directed traits");
        checkNotNull(passions, "Received a null pointer as passions");

        this.attributes = attributes;
        this.derivedAttributes = derivedAttributes;
        this.skills = skills;
        this.exclusiveSkills = exclusiveSkills;
        this.specialtySkills = specialtySkills;
        this.traits = traits;
        this.directedTraits = directedTraits;
        this.passions = passions;
    }

    @Override
    public final Map<String, Integer> getAttributes() {
        return Collections.unmodifiableMap(getAttributesModifiable());
    }

    @Override
    public final Map<String, Integer> getDerivedAttributes() {
        return Collections.unmodifiableMap(getDerivedAttributesModifiable());
    }

    @Override
    public final Map<String, Integer> getDirectedTraits() {
        return Collections.unmodifiableMap(getDirectedTraitsModifiable());
    }

    @Override
    public final Map<String, Integer> getExclusiveSkills() {
        return Collections.unmodifiableMap(getExclusiveSkillsModifiable());
    }

    @Override
    public final Map<String, Integer> getPassions() {
        return Collections.unmodifiableMap(getPassionsModifiable());
    }

    @Override
    public final Map<String, Integer> getSkills() {
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

    private final Map<String, Integer> getAttributesModifiable() {
        return attributes;
    }

    private final Map<String, Integer> getDerivedAttributesModifiable() {
        return derivedAttributes;
    }

    private final Map<String, Integer> getDirectedTraitsModifiable() {
        return directedTraits;
    }

    private final Map<String, Integer> getExclusiveSkillsModifiable() {
        return exclusiveSkills;
    }

    private final Map<String, Integer> getPassionsModifiable() {
        return passions;
    }

    private final Map<String, Integer> getSkillsModifiable() {
        return skills;
    }

    private final Map<String, Integer> getSpecialtySkillsModifiable() {
        return specialtySkills;
    }

    private final Map<String, Integer> getTraitsModifiable() {
        return traits;
    }

}
