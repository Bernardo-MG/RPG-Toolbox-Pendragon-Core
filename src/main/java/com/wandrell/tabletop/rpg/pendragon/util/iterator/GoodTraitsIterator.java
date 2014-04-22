package com.wandrell.tabletop.rpg.pendragon.util.iterator;

import java.util.Iterator;

import com.wandrell.tabletop.rpg.pendragon.valuehandler.DefaultPendragonTrait;
import com.wandrell.util.iterator.AbstractFilteredIterator;

public class GoodTraitsIterator extends
	AbstractFilteredIterator<DefaultPendragonTrait> {

    public GoodTraitsIterator(final Iterator<DefaultPendragonTrait> iterator) {
	super(iterator);
    }

    @Override
    protected boolean isValid(final DefaultPendragonTrait value) {
	return value.isGoodTrait();
    }

}
