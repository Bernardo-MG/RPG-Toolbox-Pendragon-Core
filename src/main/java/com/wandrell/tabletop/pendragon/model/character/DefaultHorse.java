package com.wandrell.tabletop.pendragon.model.character;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonCharacterListener;
import com.wandrell.tabletop.pendragon.model.character.stats.AttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.DerivedAttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.PendragonSkillBox;

public final class DefaultHorse implements Horse {

    private Boolean                      armored;
    private final PendragonBaseCharacter baseCharacter;
    private Boolean                      combat;
    private final Integer                damage;
    private Boolean                      hunting;
    private final Integer                movement;
    private final Integer                naturalArmor;
    private Boolean                      ruined;
    private final String                 type;

    public DefaultHorse(final DefaultHorse horse) {
        super();

        checkNotNull(horse, "Received a null pointer as horse");

        baseCharacter = horse.baseCharacter.createNewInstance();

        type = horse.type;

        naturalArmor = horse.naturalArmor;
        damage = horse.damage;
        movement = horse.movement;

        combat = horse.combat;
        hunting = horse.hunting;
        armored = horse.armored;
    }

    public DefaultHorse(final String name,
            final DerivedAttributeBuilder derivedAttributeBuilder,
            final String type, final Integer naturalArmor,
            final Integer damage, final Integer movement, final Boolean combat,
            final Boolean hunting, final Boolean armored) {
        super();

        checkNotNull(type, "Received a null pointer as type");
        checkNotNull(naturalArmor, "Received a null pointer as natural armor");
        checkNotNull(damage, "Received a null pointer as damage");
        checkNotNull(movement, "Received a null pointer as movement");
        checkNotNull(combat, "Received a null pointer as combat flag");
        checkNotNull(hunting, "Received a null pointer as hunting flag");
        checkNotNull(armored, "Received a null pointer as armored flag");

        baseCharacter = new DefaultPendragonBaseCharacter(name,
                derivedAttributeBuilder);

        this.type = type;

        // TODO: These should be editable. Also inject them with the builder
        this.naturalArmor = naturalArmor;
        this.damage = damage;
        this.movement = movement;

        this.combat = combat;
        this.hunting = hunting;
        this.armored = armored;
    }

    @Override
    public final void addPendragonCharacterListener(
            final PendragonCharacterListener listener) {
        getBaseCharacter().addPendragonCharacterListener(listener);
    }

    @Override
    public final void addSkill(final PendragonSkillBox skill) {
        getBaseCharacter().addSkill(skill);
    }

    @Override
    public final void clearSkills() {
        getBaseCharacter().clearSkills();
    }

    @Override
    public final DefaultHorse createNewInstance() {
        return new DefaultHorse(this);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultHorse other = (DefaultHorse) obj;
        return Objects.equals(getName(), other.getName())
                && Objects.equals(type, other.type);
    }

    @Override
    public final AttributesHolder getAttributes() {
        return getBaseCharacter().getAttributes();
    }

    @Override
    public final DerivedAttributesHolder getDerivedAttributes() {
        return getBaseCharacter().getDerivedAttributes();
    }

    @Override
    public final String getHorseType() {
        return type;
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
    public final Collection<PendragonSkillBox> getSkills() {
        return getBaseCharacter().getSkills();
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getName(), type);
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
    public final void removePendragonCharacterListener(
            final PendragonCharacterListener listener) {
        getBaseCharacter().removePendragonCharacterListener(listener);
    }

    @Override
    public final void removeSkill(final PendragonSkillBox skill) {
        getBaseCharacter().removeSkill(skill);
    }

    @Override
    public final void setArmoredHorse(final Boolean armored) {
        this.armored = armored;
    }

    @Override
    public final void setCombatHorse(final Boolean combat) {
        this.combat = combat;
    }

    @Override
    public final void setHuntingHorse(final Boolean hunting) {
        this.hunting = hunting;
    }

    @Override
    public final void setRuined(final Boolean ruined) {
        this.ruined = ruined;
    }

    @Override
    public final void setSkills(Collection<PendragonSkillBox> skills) {
        getBaseCharacter().setSkills(skills);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("type", type)
                .add("name", getName()).toString();
    }

    private final PendragonBaseCharacter getBaseCharacter() {
        return baseCharacter;
    }

}
