package com.wandrell.tabletop.business.model.pendragon.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.valuebox.DefaultEditableValueBox;
import com.wandrell.tabletop.business.model.valuebox.EditableValueBox;
import com.wandrell.tabletop.business.model.valuebox.event.ValueBoxListener;

public final class DefaultSkill implements Skill {

    private final Boolean                 combatSkill;
    private final DefaultEditableValueBox composite;
    private final Boolean                 courtlySkill;
    private String                        descriptor = "";
    private final Boolean                 knightlySkill;
    private final Boolean                 knowledgeSkill;
    private final String                  name;
    private final Boolean                 repeteable;

    public DefaultSkill(final DefaultSkill skill) {
        super();

        checkNotNull(skill, "Received a null pointer as skill");

        name = skill.name;

        composite = skill.composite.createNewInstance();

        descriptor = skill.descriptor;

        combatSkill = skill.combatSkill;
        knightlySkill = skill.knightlySkill;
        knowledgeSkill = skill.knowledgeSkill;
        courtlySkill = skill.courtlySkill;

        repeteable = skill.repeteable;
    }

    public DefaultSkill(final String name, final Integer value,
            final Integer lowerLimit, final Integer upperLimit,
            final Boolean combatSkill, final Boolean knightlySkill,
            final Boolean knowledgeSkill, final Boolean courtlySkill,
            final Boolean repeteable) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(combatSkill, "Received a null pointer as combat flag");
        checkNotNull(knightlySkill, "Received a null pointer as knightly flag");
        checkNotNull(knowledgeSkill,
                "Received a null pointer as knowledge flag");
        checkNotNull(courtlySkill, "Received a null pointer as courtly flag");
        checkNotNull(repeteable, "Received a null pointer as repeteable flag");

        this.name = name;

        composite = new DefaultEditableValueBox(value, lowerLimit, upperLimit);

        this.combatSkill = combatSkill;
        this.knightlySkill = knightlySkill;
        this.knowledgeSkill = knowledgeSkill;
        this.courtlySkill = courtlySkill;

        this.repeteable = repeteable;
    }

    @Override
    public final void addValueEventListener(final ValueBoxListener listener) {
        getValueHandler().addValueEventListener(listener);
    }

    @Override
    public final DefaultSkill createNewInstance() {
        return new DefaultSkill(this);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultSkill other = (DefaultSkill) obj;
        return Objects.equals(composite, other.composite)
                && Objects.equals(descriptor, other.descriptor);
    }

    @Override
    public final String getDescriptor() {
        return descriptor;
    }

    @Override
    public final Integer getLowerLimit() {
        return getValueHandler().getLowerLimit();
    }

    @Override
    public final String getNameToken() {
        return name;
    }

    @Override
    public final Integer getUpperLimit() {
        return getValueHandler().getUpperLimit();
    }

    @Override
    public final Integer getValue() {
        return getValueHandler().getValue();
    }

    @Override
    public final int hashCode() {
        return Objects.hash(composite, descriptor);
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
        return isRepeatable();
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
    public final Boolean isRepeatable() {
        return repeteable;
    }

    @Override
    public final void removeValueEventListener(final ValueBoxListener listener) {
        getValueHandler().removeValueEventListener(listener);
    }

    @Override
    public final void setDescriptor(final String descriptor) {
        checkNotNull(descriptor, "Received a null pointer as descriptor");

        this.descriptor = descriptor;
    }

    @Override
    public final void setLowerLimit(final Integer lowerLimit) {
        getValueHandler().setLowerLimit(lowerLimit);
    }

    @Override
    public final void setUpperLimit(final Integer upperLimit) {
        getValueHandler().setUpperLimit(upperLimit);
    }

    @Override
    public final void setValue(final Integer value) {
        getValueHandler().setValue(value);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name)
                .add("descriptor", getDescriptor()).add("value", getValue())
                .toString();
    }

    private final EditableValueBox getValueHandler() {
        return composite;
    }

}
