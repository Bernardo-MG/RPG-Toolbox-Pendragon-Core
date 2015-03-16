package com.wandrell.tabletop.pendragon.model.inventory.armor;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public final class DefaultEquippedArmor implements EquippedArmor {

    private final Collection<ArmorPiece> armors = new LinkedHashSet<>();

    public DefaultEquippedArmor() {
        super();
    }

    public DefaultEquippedArmor(final DefaultEquippedArmor armor) {
        super();

        checkNotNull(armor, "Received a null pointer as armor");

        // TODO: Copy this correctly
        armors.addAll(armor.armors);
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
    public final DefaultEquippedArmor createNewInstance() {
        return new DefaultEquippedArmor(this);
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
