package com.wandrell.tabletop.rpg.pendragon.bundle;

import java.util.ListResourceBundle;

public class DerivedAttributesBundle extends ListResourceBundle {
    static final Object[][] contents = {
	    // LOCALIZE THIS
	    { DerivedAttributesBundleKeys.DAMAGE_D6, "Damage (d6)" },
	    { DerivedAttributesBundleKeys.DAMAGE_BONUS, "Damage (bonus)" },
	    { DerivedAttributesBundleKeys.DEXTERITY_ROLL, "Dexterity roll" },
	    { DerivedAttributesBundleKeys.DISTINCTIVE_FEATURES,
		    "Distinctive Features" },
	    { DerivedAttributesBundleKeys.HEAL_RATE, "Heal Rate" },
	    { DerivedAttributesBundleKeys.HIT_POINTS, "Hit Points" },
	    { DerivedAttributesBundleKeys.KNOCKDOWN, "Knockdown" },
	    { DerivedAttributesBundleKeys.MAJOR_WOUND, "Major Wound" },
	    { DerivedAttributesBundleKeys.NATURAL_ARMOR, "Natural Armor" },
	    { DerivedAttributesBundleKeys.MOVEMENT_RATE, "Movement Rate" },
	    { DerivedAttributesBundleKeys.UNCONSCIOUS, "Unconscious" },
	    { DerivedAttributesBundleKeys.WEIGHT, "Weight" },
	    { DerivedAttributesBundleKeys.WORTH, "Worth" },
    // END OF MATERIAL TO LOCALIZE
    };

    @Override
    public Object[][] getContents() {
	return contents;
    }
}
