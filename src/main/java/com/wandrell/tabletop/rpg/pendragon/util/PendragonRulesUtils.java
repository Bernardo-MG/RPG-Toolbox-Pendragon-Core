package com.wandrell.tabletop.rpg.pendragon.util;

import com.wandrell.tabletop.rpg.dice.DefaultRollTable;
import com.wandrell.tabletop.rpg.dice.RollTable;

public class PendragonRulesUtils {

    private static PendragonRulesUtils instance;
    private static final RollTable<Integer> mapFeaturesCount;

    static {
	mapFeaturesCount = new DefaultRollTable<>(Integer.MIN_VALUE, 6, 3);
	mapFeaturesCount.addInterval(9, 2);
	mapFeaturesCount.addInterval(12, 1);
	mapFeaturesCount.addInterval(16, 2);
	mapFeaturesCount.addInterval(Integer.MAX_VALUE, 3);
    }

    public static final Integer getFeaturesCount(final Integer appearance) {
	final Integer result;

	getInstance();

	result = mapFeaturesCount.getValue(appearance);
	return result;
    }

    public static final Boolean isRepeatableSkill(final String name) {
	// TODO: Implement
	return false;
    }

    public final static int weightCalculator(final int size) {
	getInstance();

	return recursiveWeightCalculator(size);
    }

    private static synchronized PendragonRulesUtils getInstance() {
	if (instance == null) {
	    instance = new PendragonRulesUtils();
	}

	return instance;
    }

    private final static int recursiveWeightCalculator(final int size) {
	final int sizeValue;
	int result;

	if (size < 1000) {
	    sizeValue = size;
	} else {
	    sizeValue = 1000;
	}

	if (sizeValue <= 10) {
	    result = sizeValue * 10;
	} else {
	    // Calculates previous weight value
	    result = recursiveWeightCalculator(sizeValue - 1);
	    // This size weight is the 110% of the previous size's weight
	    result = Math.round(result + (float) (result * 0.1));

	    if (sizeValue == 11) {
		result++;
	    }

	}

	return result;
    }

    private PendragonRulesUtils() {
	super();
    }

}
