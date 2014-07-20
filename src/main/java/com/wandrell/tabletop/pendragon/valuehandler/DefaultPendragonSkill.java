package com.wandrell.tabletop.pendragon.valuehandler;

import com.wandrell.tabletop.valuehandler.DefaultValueHandler;
import com.wandrell.tabletop.valuehandler.DelegateValueHandler;
import com.wandrell.tabletop.valuehandler.ValueHandler;
import com.wandrell.tabletop.valuehandler.module.GeneratorModule;
import com.wandrell.tabletop.valuehandler.module.IntervalModule;
import com.wandrell.tabletop.valuehandler.module.StoreModule;
import com.wandrell.tabletop.valuehandler.module.ValidatorModule;

public class DefaultPendragonSkill implements PendragonSkill {

    private final boolean combatSkill;
    private final DelegateValueHandler<Integer> composite;
    private final boolean courtlySkill;
    private String descriptor;
    private final boolean knightlySkill;
    private final boolean knowledgeSkill;
    private final boolean repeteable;

    public DefaultPendragonSkill(final DefaultPendragonSkill skill) {
	super();

	composite = skill.composite.createNewInstance();

	descriptor = skill.descriptor;

	combatSkill = skill.combatSkill;
	knightlySkill = skill.knightlySkill;
	knowledgeSkill = skill.knowledgeSkill;
	courtlySkill = skill.courtlySkill;

	repeteable = skill.repeteable;
    }

    public DefaultPendragonSkill(final String name,
	    final GeneratorModule<Integer> generator,
	    final IntervalModule<Integer> interval,
	    final StoreModule<Integer> store,
	    final ValidatorModule<Integer> validator,
	    final Boolean combatSkill, final Boolean knightlySkill,
	    final Boolean knowledgeSkill, final Boolean courtlySkill,
	    final Boolean repeteable) {
	super();
	// TODO: This is dependant of DefaultValueHandler
	composite = new DefaultValueHandler<Integer>(name, generator, interval,
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
    public final DefaultPendragonSkill createNewInstance() {
	return new DefaultPendragonSkill(this);
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
    public final Integer getStoredValue() {
	return getValueHandler().getStoredValue();
    }

    @Override
    public final Integer getUpperLimit() {
	return getValueHandler().getUpperLimit();
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
    public final Boolean isRepeteable() {
	return repeteable;
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

    protected final ValueHandler<Integer> getValueHandler() {
	return composite;
    }

}
