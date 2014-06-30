package com.wandrell.tabletop.pendragon.bundle;

import java.util.ListResourceBundle;

public class AttributesBundle extends ListResourceBundle {

    static final Object[][] contents = {
	    // LOCALIZE THIS
	    { AttributesBundleKeys.APPEARANCE, "Appearance" },
	    { AttributesBundleKeys.CONSTITUTION, "Constitution" },
	    { AttributesBundleKeys.DEXTERITY, "Dexterity" },
	    { AttributesBundleKeys.STRENGTH, "Strength" },
	    { AttributesBundleKeys.SIZE, "Size" },
    // END OF MATERIAL TO LOCALIZE
    };

    @Override
    public Object[][] getContents() {
	return contents;
    }
}
