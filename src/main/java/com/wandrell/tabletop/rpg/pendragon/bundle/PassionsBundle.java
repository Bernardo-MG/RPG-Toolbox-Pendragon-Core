package com.wandrell.tabletop.rpg.pendragon.bundle;

import java.util.ListResourceBundle;

public class PassionsBundle extends ListResourceBundle {

    static final Object[][] contents = {
	    // LOCALIZE THIS
	    { PassionsBundleKeys.AMOR, "Amor" },
	    { PassionsBundleKeys.AMOR_TEXT, "Person" },
	    { PassionsBundleKeys.CONCERN, "Concern" },
	    { PassionsBundleKeys.CONCERN_TEXT, "Group" },
	    { PassionsBundleKeys.FEAR, "Fear" },
	    { PassionsBundleKeys.FEAR_TEXT, "Creature or event" },
	    { PassionsBundleKeys.HATE, "Hate" },
	    { PassionsBundleKeys.HATE_TEXT, "Nation, group or person" },
	    { PassionsBundleKeys.HONOR, "Honor" },
	    { PassionsBundleKeys.HOSPITALITY, "Hospitality" },
	    { PassionsBundleKeys.LOVE, "Love" },
	    { PassionsBundleKeys.LOVE_TEXT, "Person, group or god" },
	    { PassionsBundleKeys.LOYALTY, "Loyalty" },
	    { PassionsBundleKeys.LOYALTY_TEXT, "Person or group" },
	    { PassionsBundleKeys.RECHTSCHAFFENHEIT, "Rechtschaffenheit" },
    // END OF MATERIAL TO LOCALIZE
    };

    @Override
    public Object[][] getContents() {
	return contents;
    }

}
