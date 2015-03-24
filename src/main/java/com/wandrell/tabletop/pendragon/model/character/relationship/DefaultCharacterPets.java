package com.wandrell.tabletop.pendragon.model.character.relationship;

import java.util.Collection;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.pendragon.model.character.PendragonHumanCharacter;
import com.wandrell.tabletop.pendragon.model.manor.Pet;

public final class DefaultCharacterPets implements CharacterPets {

    private final PendragonHumanCharacter character;
    private final Collection<Pet>         pets;

    public DefaultCharacterPets(final PendragonHumanCharacter character,
            final Collection<Pet> pets) {
        super();

        this.character = character;
        this.pets = pets;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultCharacterPets other = (DefaultCharacterPets) obj;
        return Objects.equals(character, other.character);
    }

    @Override
    public final PendragonHumanCharacter getCharacter() {
        return character;
    }

    @Override
    public final Collection<Pet> getPets() {
        return pets;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(character);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("character", character.getName()).add("pets", pets)
                .toString();
    }

}
