package com.wandrell.tabletop.business.model.pendragon.valuehandler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.valuehandler.EditableValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.ModularEditableValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.event.ValueHandlerListener;
import com.wandrell.tabletop.business.model.valuehandler.module.generator.GeneratorModule;
import com.wandrell.tabletop.business.model.valuehandler.module.interval.IntervalModule;
import com.wandrell.tabletop.business.model.valuehandler.module.store.AbstractEditableStoreModule;
import com.wandrell.tabletop.business.model.valuehandler.module.validator.ValidatorModule;

public final class DefaultSkill implements Skill {

    private final boolean                     combatSkill;
    private final ModularEditableValueHandler composite;
    private final boolean                     courtlySkill;
    private String                            descriptor = "";
    private final boolean                     knightlySkill;
    private final boolean                     knowledgeSkill;
    private final boolean                     repeteable;

    public DefaultSkill(final DefaultSkill skill) {
        super();

        checkNotNull(skill, "Received a null pointer as skill");

        composite = skill.composite.createNewInstance();

        descriptor = skill.descriptor;

        combatSkill = skill.combatSkill;
        knightlySkill = skill.knightlySkill;
        knowledgeSkill = skill.knowledgeSkill;
        courtlySkill = skill.courtlySkill;

        repeteable = skill.repeteable;
    }

    public DefaultSkill(final String name, final GeneratorModule generator,
            final IntervalModule interval,
            final AbstractEditableStoreModule store,
            final ValidatorModule validator, final Boolean combatSkill,
            final Boolean knightlySkill, final Boolean knowledgeSkill,
            final Boolean courtlySkill, final Boolean repeteable) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(generator, "Received a null pointer as generator");
        checkNotNull(interval, "Received a null pointer as interval");
        checkNotNull(store, "Received a null pointer as store");
        checkNotNull(validator, "Received a null pointer as validator");
        checkNotNull(combatSkill, "Received a null pointer as combat flag");
        checkNotNull(knightlySkill, "Received a null pointer as knightly flag");
        checkNotNull(knowledgeSkill,
                "Received a null pointer as knowledge flag");
        checkNotNull(courtlySkill, "Received a null pointer as courtly flag");
        checkNotNull(repeteable, "Received a null pointer as repeteable flag");

        composite = new ModularEditableValueHandler(name, generator, interval,
                store, validator);

        this.combatSkill = combatSkill;
        this.knightlySkill = knightlySkill;
        this.knowledgeSkill = knowledgeSkill;
        this.courtlySkill = courtlySkill;

        this.repeteable = repeteable;
    }

    @Override
    public final Boolean acceptsValue(final Integer value) {
        return getValueHandler().acceptsValue(value);
    }

    @Override
    public final void
            addValueEventListener(final ValueHandlerListener listener) {
        getValueHandler().addValueEventListener(listener);
    }

    @Override
    public final DefaultSkill createNewInstance() {
        return new DefaultSkill(this);
    }

    @Override
    public final void decreaseValue() {
        getValueHandler().decreaseValue();
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
    public final String getName() {
        return getValueHandler().getName();
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
    public final void increaseValue() {
        getValueHandler().increaseValue();
    }

    @Override
    public final Boolean isAbleToDecrease() {
        return getValueHandler().isAbleToDecrease();
    }

    @Override
    public final Boolean isAbleToIncrease() {
        return getValueHandler().isAbleToIncrease();
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
    public final Boolean isRepeatable() {
        return repeteable;
    }

    @Override
    public final void removeValueEventListener(
            final ValueHandlerListener listener) {
        getValueHandler().removeValueEventListener(listener);
    }

    public final void setDescriptor(final String descriptor) {
        checkNotNull(descriptor, "Received a null pointer as descriptor");

        this.descriptor = descriptor;
    }

    @Override
    public final void setValue(final Integer value) {
        getValueHandler().setValue(value);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", getName())
                .add("descriptor", getDescriptor()).add("value", getValue())
                .toString();
    }

    private final EditableValueHandler getValueHandler() {
        return composite;
    }

}
