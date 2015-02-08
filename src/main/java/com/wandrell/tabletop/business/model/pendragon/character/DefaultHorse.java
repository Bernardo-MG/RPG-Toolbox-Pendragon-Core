package com.wandrell.tabletop.business.model.pendragon.character;

import static com.google.common.base.Preconditions.checkNotNull;

import com.wandrell.tabletop.business.model.pendragon.character.DefaultPendragonBaseCharacter.DerivedAttributeBuilder;

public final class DefaultHorse implements Horse {

    private final Boolean                armored;
    private final PendragonBaseCharacter baseCharacter;
    private final Boolean                combat;
    private final Boolean                hunting;
    private final Integer                naturalArmor;
    private Boolean                      ruined;
    private final String                 type;

    public DefaultHorse(final DefaultHorse horse) {
        super();

        checkNotNull(horse, "Received a null pointer as horse");

        baseCharacter = horse.baseCharacter.createNewInstance();

        type = horse.type;

        naturalArmor = horse.naturalArmor;

        combat = horse.combat;
        hunting = horse.hunting;
        armored = horse.armored;
    }

    public DefaultHorse(final String name,
            final DerivedAttributeBuilder derivedAttributeBuilder,
            final String type, final Integer naturalArmor,
            final Boolean combat, final Boolean hunting, final Boolean armored) {
        super();

        checkNotNull(type, "Received a null pointer as type");
        checkNotNull(naturalArmor, "Received a null pointer as natural armor");
        checkNotNull(combat, "Received a null pointer as combat flag");
        checkNotNull(hunting, "Received a null pointer as hunting flag");
        checkNotNull(armored, "Received a null pointer as armored flag");

        baseCharacter = new DefaultPendragonBaseCharacter(name,
                derivedAttributeBuilder);

        this.type = type;

        this.naturalArmor = naturalArmor;

        this.combat = combat;
        this.hunting = hunting;
        this.armored = armored;
    }

    @Override
    public final DefaultHorse createNewInstance() {
        return new DefaultHorse(this);
    }

    @Override
    public final Integer getConstitution() {
        return getBaseCharacter().getConstitution();
    }

    @Override
    public final Integer getDamage() {
        return getBaseCharacter().getDamage();
    }

    @Override
    public final Integer getDexterity() {
        return getBaseCharacter().getConstitution();
    }

    @Override
    public final Integer getDexterityRoll() {
        return getBaseCharacter().getDexterityRoll();
    }

    @Override
    public final Integer getHealingRate() {
        return getBaseCharacter().getHealingRate();
    }

    @Override
    public final Integer getHitPoints() {
        return getBaseCharacter().getHitPoints();
    }

    @Override
    public final String getHorseType() {
        return type;
    }

    @Override
    public final Integer getMajorWoundTreshold() {
        return getBaseCharacter().getMajorWoundTreshold();
    }

    @Override
    public final Integer getMovementRate() {
        return getBaseCharacter().getMovementRate();
    }

    @Override
    public final String getName() {
        return getBaseCharacter().getName();
    }

    @Override
    public final Integer getNaturalArmor() {
        return naturalArmor;
    }

    @Override
    public final Integer getSize() {
        return getBaseCharacter().getSize();
    }

    @Override
    public final Integer getStrength() {
        return getBaseCharacter().getStrength();
    }

    @Override
    public final Integer getUnconsciousTreshold() {
        return getBaseCharacter().getUnconsciousTreshold();
    }

    @Override
    public final Integer getWeight() {
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
    public final void setConstitution(final Integer constitution) {
        getBaseCharacter().setConstitution(constitution);
    }

    @Override
    public final void setDexterity(final Integer dexterity) {
        getBaseCharacter().setDexterity(dexterity);
    }

    @Override
    public final void setRuined(final Boolean ruined) {
        this.ruined = ruined;
    }

    @Override
    public final void setSize(final Integer size) {
        getBaseCharacter().setSize(size);
    }

    @Override
    public final void setStrength(final Integer strength) {
        getBaseCharacter().setStrength(strength);
    }

    private final PendragonBaseCharacter getBaseCharacter() {
        return baseCharacter;
    }

}
