package com.wandrell.tabletop.rpg.pendragon.util.iterator;

import java.util.Iterator;

import com.wandrell.tabletop.rpg.pendragon.valuehandler.DefaultPendragonSkill;
import com.wandrell.util.iterator.AbstractFilteredIterator;

public class KnightlySkillsIterator extends
	AbstractFilteredIterator<DefaultPendragonSkill> {

    public KnightlySkillsIterator(final Iterator<DefaultPendragonSkill> iterator) {
	super(iterator);
    }

    @Override
    protected boolean isValid(final DefaultPendragonSkill value) {
	return value.isKnightlySkill();
    }

}
