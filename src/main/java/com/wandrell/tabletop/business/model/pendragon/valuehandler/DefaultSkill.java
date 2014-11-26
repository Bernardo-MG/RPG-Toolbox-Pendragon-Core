package com.wandrell.tabletop.business.model.pendragon.valuehandler;

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
        // TODO: This is dependant of DefaultValueHandler
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
    public final void addValue(final Integer value) {
        getValueHandler().acceptsValue(value);
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
        if (descriptor == null) {
            throw new NullPointerException();
        }

        this.descriptor = descriptor;
    }

    @Override
    public final void setValue(final Integer value) {
        getValueHandler().setValue(value);
    }

    @Override
    public final String toString() {
        final String template;
        final String result;

        if (isRepeatable()) {
            template = "%s (%s)";
            result = String.format(template, getName(), getDescriptor());
        } else {
            result = getName();
        }

        return result;
    }

    protected final EditableValueHandler getValueHandler() {
        return composite;
    }

}
