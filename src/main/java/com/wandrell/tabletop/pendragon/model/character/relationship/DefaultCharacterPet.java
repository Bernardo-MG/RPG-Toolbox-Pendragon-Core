package com.wandrell.tabletop.pendragon.model.character.relationship;

import com.wandrell.tabletop.pendragon.model.character.PendragonHumanCharacter;
import com.wandrell.tabletop.pendragon.model.manor.Pet;

public final class DefaultCharacterPet implements CharacterPet {

    private final PendragonHumanCharacter character;
    private final Pet                     pet;

    public DefaultCharacterPet(final PendragonHumanCharacter character,
            final Pet pet) {
        super();

        this.character = character;
        this.pet = pet;
    }

    @Override
    public final PendragonHumanCharacter getCharacter() {
        return character;
    }

    @Override
    public final Pet getPet() {
        return pet;
    }

}
