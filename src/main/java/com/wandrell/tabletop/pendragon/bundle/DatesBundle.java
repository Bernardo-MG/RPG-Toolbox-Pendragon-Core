package com.wandrell.tabletop.pendragon.bundle;

import java.util.ListResourceBundle;

public class DatesBundle extends ListResourceBundle {
    static final Object[][] contents = {
	    // LOCALIZE THIS
	    { DatesBundleKeys.YEAR_BORN, "Year born" },
	    { DatesBundleKeys.YEAR_DEATH, "Year death" },
	    { DatesBundleKeys.YEAR_KNIGHTED, "Year knighted" },
	    { DatesBundleKeys.YEAR_LANDED, "Year landed" },
	    { DatesBundleKeys.YEAR_ROUND_TABLE, "Year joined round table" },
	    { DatesBundleKeys.YEAR_SQUIRED, "Year squired" },
	    { DatesBundleKeys.YEAR_TITLED, "Year titled" },
	    { DatesBundleKeys.YEAR_WED, "Year wed" },
    // END OF MATERIAL TO LOCALIZE
    };

    @Override
    public Object[][] getContents() {
	return contents;
    }

}
