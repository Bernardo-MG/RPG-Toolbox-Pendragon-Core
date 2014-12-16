package com.wandrell.tabletop.business.model.pendragon.character;

import static com.google.common.base.Preconditions.checkNotNull;

import com.wandrell.tabletop.business.model.pendragon.stats.Attribute;
import com.wandrell.tabletop.business.model.pendragon.stats.DerivedAttribute;
import com.wandrell.tabletop.business.model.valuehandler.ValueHandler;

public final class DefaultHorseCharacter implements HorseCharacter {

    private final Boolean                armored;
    private final PendragonBaseCharacter baseCharacter;
    private final Boolean                combat;
    private final Boolean                hunting;
    private final ValueHandler           naturalArmor;
    private Boolean                      ruined;
    private final String                 type;

    public DefaultHorseCharacter(final DefaultHorseCharacter horse) {
        super();

        checkNotNull(horse, "Received a null pointer as horse");

        baseCharacter = horse.baseCharacter.createNewInstance();

        type = horse.type;

        naturalArmor = horse.naturalArmor.createNewInstance();

        combat = horse.combat;
        hunting = horse.hunting;
        armored = horse.armored;
    }

    public DefaultHorseCharacter(final PendragonBaseCharacter character,
            final String type, final ValueHandler naturalArmor,
            final Boolean combat, final Boolean hunting, final Boolean armored) {
        super();

        checkNotNull(character, "Received a null pointer as base character");
        checkNotNull(type, "Received a null pointer as type");
        checkNotNull(naturalArmor, "Received a null pointer as natural armor");
        checkNotNull(combat, "Received a null pointer as combat flag");
        checkNotNull(hunting, "Received a null pointer as hunting flag");
        checkNotNull(armored, "Received a null pointer as armored flag");

        baseCharacter = character;

        this.type = type;

        this.naturalArmor = naturalArmor;

        this.combat = combat;
        this.hunting = hunting;
        this.armored = armored;
    }

    @Override
    public final DefaultHorseCharacter createNewInstance() {
        return new DefaultHorseCharacter(this);
    }

    @Override
    public final Attribute getConstitution() {
        return getBaseCharacter().getConstitution();
    }

    @Override
    public final DerivedAttribute getDamage() {
        return getBaseCharacter().getDamage();
    }

    @Override
    public final Attribute getDexterity() {
        return getBaseCharacter().getConstitution();
    }

    @Override
    public final DerivedAttribute getDexterityRoll() {
        return getBaseCharacter().getDexterityRoll();
    }

    @Override
    public final DerivedAttribute getHealingRate() {
        return getBaseCharacter().getHealingRate();
    }

    @Override
    public final DerivedAttribute getHitPoints() {
        return getBaseCharacter().getHitPoints();
    }

    @Override
    public final String getHorseType() {
        return type;
    }

    @Override
    public final DerivedAttribute getMajorWoundTreshold() {
        return getBaseCharacter().getMajorWoundTreshold();
    }

    @Override
    public final DerivedAttribute getMovementRate() {
        return getBaseCharacter().getMovementRate();
    }

    @Override
    public final String getName() {
        return getBaseCharacter().getName();
    }

    @Override
    public final ValueHandler getNaturalArmor() {
        return naturalArmor;
    }

    @Override
    public final Attribute getSize() {
        return getBaseCharacter().getSize();
    }

    @Override
    public final Attribute getStrength() {
        return getBaseCharacter().getStrength();
    }

    @Override
    public final DerivedAttribute getUnconsciousTreshold() {
        return getBaseCharacter().getUnconsciousTreshold();
    }

    @Override
    public final DerivedAttribute getWeight() {
        return getBaseCharacter().getWeight();
    }

    @Override
    public final Boolean isArmored() {
        return armored;
    }

    @Override
    public final Boolean isCombatHorse() {
        return combat;
    }

    @Override
    public final Boolean isHuntingHorse() {
        return hunting;
    }

    @Override
    public final Boolean isRuined() {
        return ruined;
    }

    @Override
    public final void setRuined(final Boolean ruined) {
        this.ruined = ruined;
    }

    private final PendragonBaseCharacter getBaseCharacter() {
        return baseCharacter;
    }

}
