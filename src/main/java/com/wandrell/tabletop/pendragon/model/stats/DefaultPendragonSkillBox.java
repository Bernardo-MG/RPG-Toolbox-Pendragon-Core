package com.wandrell.tabletop.pendragon.model.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.event.ValueChangeListener;
import com.wandrell.tabletop.valuebox.DefaultSkillBox;
import com.wandrell.tabletop.valuebox.SkillBox;

public final class DefaultPendragonSkillBox implements PendragonSkillBox {

    private final Boolean  combatSkill;
    private final SkillBox composite;
    private final Boolean  courtlySkill;
    private final Boolean  knightlySkill;
    private final Boolean  knowledgeSkill;

    public DefaultPendragonSkillBox(final DefaultPendragonSkillBox skill) {
        super();

        checkNotNull(skill, "Received a null pointer as skill");

        composite = skill.composite.createNewInstance();

        combatSkill = skill.combatSkill;
        knightlySkill = skill.knightlySkill;
        knowledgeSkill = skill.knowledgeSkill;
        courtlySkill = skill.courtlySkill;
    }

    public DefaultPendragonSkillBox(final String name, final Integer value,
            final Integer lowerLimit, final Integer upperLimit,
            final Boolean combatSkill, final Boolean knightlySkill,
            final Boolean knowledgeSkill, final Boolean courtlySkill) {
        super();

        checkNotNull(combatSkill, "Received a null pointer as combat flag");
        checkNotNull(knightlySkill, "Received a null pointer as knightly flag");
        checkNotNull(knowledgeSkill,
                "Received a null pointer as knowledge flag");
        checkNotNull(courtlySkill, "Received a null pointer as courtly flag");

        composite = new DefaultSkillBox(name, value, lowerLimit, upperLimit);

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
    public final DefaultPendragonSkillBox createNewInstance() {
        return new DefaultPendragonSkillBox(this);
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
    public final Integer getLowerLimit() {
        return getBaseSkill().getLowerLimit();
    }

    @Override
    public final String getName() {
        return getBaseSkill().getName();
    }

    @Override
    public final Integer getUpperLimit() {
        return getBaseSkill().getUpperLimit();
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
    public final Boolean isDescribed() {
        return getBaseSkill().isDescribed();
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
    public final void setDescribed(final Boolean described) {
        // TODO Auto-generated method stub

    }

    @Override
    public final void setDescriptor(final String descriptor) {
        getBaseSkill().setDescriptor(descriptor);
    }

    @Override
    public final void setLowerLimit(final Integer lowerLimit) {
        getBaseSkill().setLowerLimit(lowerLimit);
    }

    @Override
    public final void setUpperLimit(final Integer upperLimit) {
        getBaseSkill().setUpperLimit(upperLimit);
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
