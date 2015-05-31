package com.wandrell.tabletop.pendragon.model.character.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.stats.event.ValueChangeListener;
import com.wandrell.tabletop.stats.valuebox.DefaultSkillBox;
import com.wandrell.tabletop.stats.valuebox.SkillBox;

public final class DefaultPendragonSkillBox implements PendragonSkillBox {

    private final Boolean  combatSkill;
    private final SkillBox composite;
    private final Boolean  courtlySkill;
    private final Boolean  knightlySkill;
    private final Boolean  knowledgeSkill;

    public DefaultPendragonSkillBox(final DefaultPendragonSkillBox skill) {
        super();

        checkNotNull(skill, "Received a null pointer as skill");

        composite = new DefaultSkillBox(skill.composite.getName(),
                skill.composite.getValue());

        combatSkill = skill.combatSkill;
        knightlySkill = skill.knightlySkill;
        knowledgeSkill = skill.knowledgeSkill;
        courtlySkill = skill.courtlySkill;
    }

    public DefaultPendragonSkillBox(final PendragonSkillBox skill) {
        super();

        checkNotNull(skill, "Received a null pointer as skill");

        composite = new DefaultSkillBox(skill.getName(), skill.getValue());

        combatSkill = skill.isCombatSkill();
        knightlySkill = skill.isKnightlySkill();
        knowledgeSkill = skill.isKnowledgeSkill();
        courtlySkill = skill.isCourtlySkill();
    }

    public DefaultPendragonSkillBox(final String name, final Integer value,
            final Boolean combatSkill, final Boolean knightlySkill,
            final Boolean knowledgeSkill, final Boolean courtlySkill) {
        this(name, "", value, combatSkill, knightlySkill, knowledgeSkill,
                courtlySkill);
    }

    public DefaultPendragonSkillBox(final String name, final String descriptor,
            final Integer value, final Boolean combatSkill,
            final Boolean knightlySkill, final Boolean knowledgeSkill,
            final Boolean courtlySkill) {
        super();

        checkNotNull(combatSkill, "Received a null pointer as combat flag");
        checkNotNull(knightlySkill, "Received a null pointer as knightly flag");
        checkNotNull(knowledgeSkill,
                "Received a null pointer as knowledge flag");
        checkNotNull(courtlySkill, "Received a null pointer as courtly flag");

        composite = new DefaultSkillBox(name, descriptor, value);

        this.combatSkill = combatSkill;
        this.knightlySkill = knightlySkill;
        this.knowledgeSkill = knowledgeSkill;
        this.courtlySkill = courtlySkill;
    }

    @Override
    public final void
            addValueChangeListener(final ValueChangeListener listener) {
        getBaseSkill().addValueChangeListener(listener);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultPendragonSkillBox other = (DefaultPendragonSkillBox) obj;
        return Objects.equals(composite, other.composite);
    }

    @Override
    public final String getDescriptor() {
        return getBaseSkill().getDescriptor();
    }

    @Override
    public final String getName() {
        return getBaseSkill().getName();
    }

    @Override
    public final Integer getValue() {
        return getBaseSkill().getValue();
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(composite);
    }

    @Override
    public final Boolean isCombatSkill() {
        return combatSkill;
    }

    @Override
    public final Boolean isCourtlySkill() {
        return courtlySkill;
    }

    @Override
    public final Boolean isKnightlySkill() {
        return knightlySkill;
    }

    @Override
    public final Boolean isKnowledgeSkill() {
        return knowledgeSkill;
    }

    @Override
    public final void removeValueChangeListener(
            final ValueChangeListener listener) {
        getBaseSkill().removeValueChangeListener(listener);
    }

    @Override
    public final void setValue(final Integer value) {
        getBaseSkill().setValue(value);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", getName())
                .add("descriptor", getDescriptor()).add("value", getValue())
                .toString();
    }

    private final SkillBox getBaseSkill() {
        return composite;
    }

}
