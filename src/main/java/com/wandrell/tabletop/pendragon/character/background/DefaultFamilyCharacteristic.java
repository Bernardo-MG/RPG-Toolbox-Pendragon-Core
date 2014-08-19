package com.wandrell.tabletop.pendragon.character.background;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import com.wandrell.tabletop.pendragon.valuehandler.Attribute;
import com.wandrell.tabletop.pendragon.valuehandler.Skill;
import com.wandrell.tabletop.util.TokenUtils;

public final class DefaultFamilyCharacteristic implements FamilyCharacteristic {

    private final Map<String, Attribute> attributes;
    private final String                 name;
    private final Map<String, Skill>     skills;

    public DefaultFamilyCharacteristic(
            final DefaultFamilyCharacteristic familyChar) {
        super();
        name = familyChar.name;

        attributes = familyChar.attributes;
        skills = familyChar.skills;
    }

    public DefaultFamilyCharacteristic(final String name,
            final Map<String, Attribute> attributes,
            final Map<String, Skill> skills) {
        super();

        if (name == null) {
            throw new NullPointerException();
        }

        if (attributes == null) {
            throw new NullPointerException();
        }

        if (skills == null) {
            throw new NullPointerException();
        }

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
        DefaultFamilyCharacteristic other = (DefaultFamilyCharacteristic) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public final Attribute getAttribute(final String name) {
        return _getAttributes().get(name);
    }

    @Override
    public final Collection<Attribute> getAttributes() {
        return Collections.unmodifiableCollection(_getAttributes().values());
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Skill getSkill(final String name, final String annotation) {
        return _getSkills().get(
                TokenUtils.getNameAndDescriptorToken(name, annotation));
    }

    @Override
    public final Collection<Skill> getSkills() {
        return Collections.unmodifiableCollection(_getSkills().values());
    }

    @Override
    public final Boolean hasAttribute(final String name) {
        return _getAttributes().containsKey(name);
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public final Boolean hasSkill(final String name, final String annotation) {
        return _getSkills().containsKey(
                TokenUtils.getNameAndDescriptorToken(name, annotation));
    }

    @Override
    public final String toString() {
        return getName();
    }

    protected final Map<String, Attribute> _getAttributes() {
        return attributes;
    }

    protected final Map<String, Skill> _getSkills() {
        return skills;
    }

}
