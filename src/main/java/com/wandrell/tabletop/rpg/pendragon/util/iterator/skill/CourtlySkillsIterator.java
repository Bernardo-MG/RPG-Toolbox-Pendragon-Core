package com.wandrell.tabletop.rpg.pendragon.util.iterator.skill;

import java.util.Iterator;

import com.wandrell.tabletop.rpg.pendragon.valuehandler.DefaultPendragonSkill;
import com.wandrell.util.iterator.AbstractFilteredIterator;

public class CourtlySkillsIterator extends
	AbstractFilteredIterator<DefaultPendragonSkill> {

    public CourtlySkillsIterator(final Iterator<DefaultPendragonSkill> iterator) {
	super(iterator);
    }

    @Override
    protected final Boolean isValid(final DefaultPendragonSkill value) {
	return value.isCourtlySkill();
    }

}
