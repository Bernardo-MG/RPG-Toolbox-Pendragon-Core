package com.wandrell.tabletop.business.model.pendragon.chargen;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collections;
import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public final class DefaultFamilyCharacteristicTemplate implements
        FamilyCharacteristicTemplate {

    private final Map<String, Integer> attributes;
    private final String               name;
    private final Map<String, Integer> skills;

    public DefaultFamilyCharacteristicTemplate(final String name,
            final Map<String, Integer> attributes,
            final Map<String, Integer> skills) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(attributes, "Received a null pointer as attributes");
        checkNotNull(skills, "Received a null pointer as skills");

        this.name = name;

        this.attributes = attributes;
        this.skills = skills;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultFamilyCharacteristicTemplate other = (DefaultFamilyCharacteristicTemplate) obj;
        return Objects.equal(name, other.name);
    }

    @Override
    public final Map<String, Integer> getAttributes() {
        return Collections.unmodifiableMap(getAttributesModifiable());
    }

    @Override
    public final String getFamilyCharacteristic() {
        return name;
    }

    @Override
    public final Map<String, Integer> getSkills() {
        return Collections.unmodifiableMap(getSkillsModifiable());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

    private final Map<String, Integer> getAttributesModifiable() {
        return attributes;
    }

    private final Map<String, Integer> getSkillsModifiable() {
        return skills;
    }

}
