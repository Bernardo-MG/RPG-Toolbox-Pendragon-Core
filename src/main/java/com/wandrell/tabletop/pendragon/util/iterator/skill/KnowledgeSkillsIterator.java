package com.wandrell.tabletop.pendragon.util.iterator.skill;

import java.util.Iterator;

import com.wandrell.tabletop.pendragon.valuehandler.DefaultPendragonSkill;
import com.wandrell.util.iterator.AbstractFilteredIterator;

public class KnowledgeSkillsIterator extends
	AbstractFilteredIterator<DefaultPendragonSkill> {

    public KnowledgeSkillsIterator(
	    final Iterator<DefaultPendragonSkill> iterator) {
	super(iterator);
    }

    @Override
    protected final Boolean isValid(final DefaultPendragonSkill value) {
	return value.isKnowledgeSkill();
    }

}