package com.wandrell.tabletop.rpg.pendragon.valuehandler;

import com.wandrell.tabletop.rpg.valuehandler.DefaultValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.DelegateValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.module.GeneratorModule;
import com.wandrell.tabletop.rpg.valuehandler.module.IntervalModule;
import com.wandrell.tabletop.rpg.valuehandler.module.StoreModule;
import com.wandrell.tabletop.rpg.valuehandler.module.ValidatorModule;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultPendragonSkill implements PendragonSkill, NewInstantiable {

    private boolean flagCombatSkill = false;
    private boolean flagCourtlySkill = false;
    private boolean flagKnightlySkill = false;
    private boolean flagKnowledgeSkill = false;
    private boolean flagRepeteable = false;
    private final DelegateValueHandler<Integer> vhComposite;

    public DefaultPendragonSkill(final DefaultPendragonSkill skill) {
	super();

	vhComposite = skill.vhComposite.createNewInstance();

	flagCombatSkill = skill.flagCombatSkill;
	flagKnightlySkill = skill.flagKnightlySkill;
	flagKnowledgeSkill = skill.flagKnowledgeSkill;
	flagCourtlySkill = skill.flagCourtlySkill;
    }

    public DefaultPendragonSkill(final String name, final String annotation,
	    final GeneratorModule<Integer> generator,
	    final IntervalModule<Integer> interval,
	    final StoreModule<Integer> store,
	    final ValidatorModule<Integer> validator) {
	super();
	vhComposite = new DefaultValueHandler<Integer>(name, generator,
		interval, store, validator);
	vhComposite.setAnnotation(annotation);
    }

    @Override
    public Boolean acceptsValue(final Integer value) {
	return getValueHandler().acceptsValue(value);
    }

    @Override
    public void addValue(final Integer value) {
	getValueHandler().acceptsValue(value);
    }

    @Override
    public DefaultPendragonSkill createNewInstance() {
	return new DefaultPendragonSkill(this);
    }

    @Override
    public void decreaseValue() {
	getValueHandler().decreaseValue();
    }

    @Override
    public String getAnnotation() {
	return getValueHandler().getAnnotation();
    }

    @Override
    public Integer getLowerLimit() {
	return getValueHandler().getLowerLimit();
    }

    @Override
    public String getName() {
	return getValueHandler().getName();
    }

    @Override
    public Integer getStoredValue() {
	return getValueHandler().getStoredValue();
    }

    @Override
    public Integer getUpperLimit() {
	return getValueHandler().getUpperLimit();
    }

    @Override
    public void increaseValue() {
	getValueHandler().increaseValue();
    }

    @Override
    public Boolean isAbleToDecrease() {
	return getValueHandler().isAbleToDecrease();
    }

    @Override
    public Boolean isAbleToIncrease() {
	return getValueHandler().isAbleToIncrease();
    }

    @Override
    public Boolean isAnnotated() {
	return isRepeteable() && getValueHandler().isAnnotated();
    }

    @Override
    public boolean isCombatSkill() {
	return flagCombatSkill;
    }

    @Override
    public boolean isCourtlySkill() {
	return flagCourtlySkill;
    }

    @Override
    public boolean isKnightlySkill() {
	return flagKnightlySkill;
    }

    @Override
    public boolean isKnowledgeSkill() {
	return flagKnowledgeSkill;
    }

    @Override
    public boolean isRepeteable() {
	return flagRepeteable;
    }

    public void setCombatSkill(final boolean combatSkill) {
	flagCombatSkill = combatSkill;
    }

    public void setCourtlySkill(final boolean courtlySkill) {
	flagCourtlySkill = courtlySkill;
    }

    public void setKnightlySkill(final boolean knightlySkill) {
	flagKnightlySkill = knightlySkill;
    }

    public void setKnowledgeSkill(final boolean knowledgeSkill) {
	flagKnowledgeSkill = knowledgeSkill;
    }

    public void setRepeteable(final boolean repeteable) {
	flagRepeteable = repeteable;
    }

    @Override
    public void setValue(final Integer value) {
	getValueHandler().setValue(value);
    }

    protected ValueHandler<Integer> getValueHandler() {
	return vhComposite;
    }

}
