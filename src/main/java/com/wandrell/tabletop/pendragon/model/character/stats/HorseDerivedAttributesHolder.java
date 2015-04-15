package com.wandrell.tabletop.pendragon.model.character.stats;

import java.util.Objects;

import com.wandrell.tabletop.pendragon.model.character.PendragonCharacter;
import com.wandrell.tabletop.pendragon.model.character.stats.event.DerivedAttributesListener;

public final class HorseDerivedAttributesHolder implements
        DerivedAttributesHolder {

    private final PendragonCharacter baseCharacter;
    private final Integer            damage;
    private final Integer            moveRate;

    public HorseDerivedAttributesHolder(final PendragonCharacter baseCharacter,
            final Integer damage, final Integer moveRate) {
        super();

        this.baseCharacter = baseCharacter;

        this.damage = damage;
        this.moveRate = moveRate;
    }

    @Override
    public final void addDerivedAttributesListener(
            final DerivedAttributesListener listener) {
        getPendragonBaseCharacter().getDerivedAttributes()
                .addDerivedAttributesListener(listener);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HorseDerivedAttributesHolder other = (HorseDerivedAttributesHolder) obj;
        return Objects.equals(baseCharacter.getDerivedAttributes(),
                other.baseCharacter.getDerivedAttributes())
                && Objects.equals(damage, other.damage)
                && Objects.equals(moveRate, other.moveRate);
    }

    @Override
    public final Integer getDamage() {
        return damage;
    }

    @Override
    public final Integer getDexterityRoll() {
        return getPendragonBaseCharacter().getDerivedAttributes()
                .getDexterityRoll();
    }

    @Override
    public final Integer getHealingRate() {
        return getPendragonBaseCharacter().getDerivedAttributes()
                .getHealingRate();
    }

    @Override
    public final Integer getHitPoints() {
        return getPendragonBaseCharacter().getDerivedAttributes()
                .getHitPoints();
    }

    @Override
    public final Integer getKnockdown() {
        return getPendragonBaseCharacter().getDerivedAttributes()
                .getKnockdown();
    }

    @Override
    public final Integer getMajorWoundTreshold() {
        return getPendragonBaseCharacter().getDerivedAttributes()
                .getMajorWoundTreshold();
    }

    @Override
    public final Integer getMoveRate() {
        return moveRate;
    }

    @Override
    public final Integer getUnconciousTreshold() {
        return getPendragonBaseCharacter().getDerivedAttributes()
                .getUnconciousTreshold();
    }

    @Override
    public final Integer getWeight() {
        return getPendragonBaseCharacter().getDerivedAttributes().getWeight();
    }

    @Override
    public final void removeDerivedAttributesListener(
            final DerivedAttributesListener listener) {
        getPendragonBaseCharacter().getDerivedAttributes()
                .removeDerivedAttributesListener(listener);
    }

    @Override
    public final void setAttributesHolder(final AttributesHolder attributes) {
        getPendragonBaseCharacter().getDerivedAttributes().setAttributesHolder(
                attributes);
    }

    private final PendragonCharacter getPendragonBaseCharacter() {
        return baseCharacter;
    }

}
