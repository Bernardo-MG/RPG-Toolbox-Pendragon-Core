package com.wandrell.tabletop.pendragon.model.character.stats;

import com.wandrell.tabletop.pendragon.model.character.PendragonBaseCharacter;
import com.wandrell.tabletop.pendragon.model.character.stats.event.DerivedAttributesListener;

public final class HorseDerivedAttributesHolder implements
        DerivedAttributesHolder {

    private final PendragonBaseCharacter baseCharacter;
    private final Integer                damage;
    private final Integer                moveRate;

    public HorseDerivedAttributesHolder(
            final PendragonBaseCharacter baseCharacter, final Integer damage,
            final Integer moveRate) {
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

    private final PendragonBaseCharacter getPendragonBaseCharacter() {
        return baseCharacter;
    }

}
