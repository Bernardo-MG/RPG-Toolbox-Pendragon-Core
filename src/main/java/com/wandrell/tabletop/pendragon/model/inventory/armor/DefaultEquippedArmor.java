package com.wandrell.tabletop.pendragon.model.inventory.armor;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public final class DefaultEquippedArmor implements EquippedArmor {

    private final Collection<ArmorPiece> armors = new LinkedHashSet<>();

    public DefaultEquippedArmor() {
        super();
    }

    @Override
    public final void addArmorPiece(final ArmorPiece armor) {
        getArmorPiecesModifiable().add(armor);
    }

    @Override
    public final void clearArmorPieces() {
        getArmorPiecesModifiable().clear();
    }

    @Override
    public final Collection<ArmorPiece> getArmorPieces() {
        return Collections.unmodifiableCollection(getArmorPiecesModifiable());
    }

    @Override
    public final Integer getTotalArmor() {
        Integer armor;

        armor = 0;

        for (final ArmorPiece piece : getArmorPiecesModifiable()) {
            armor += piece.getArmorValue();
        }

        return armor;
    }

    @Override
    public final void removeArmorPiece(final ArmorPiece armor) {
        getArmorPiecesModifiable().remove(armor);
    }

    private final Collection<ArmorPiece> getArmorPiecesModifiable() {
        return armors;
    }

}
