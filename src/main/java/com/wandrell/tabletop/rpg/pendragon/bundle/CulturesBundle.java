package com.wandrell.tabletop.rpg.pendragon.bundle;

import java.util.ListResourceBundle;

public class CulturesBundle extends ListResourceBundle {
    static final Object[][] contents = {
	    // LOCALIZE THIS
	    { "aquitanian_early", "Aquitanian (early)" },
	    { "aquitanian_late", "Aquitanian (late)" },
	    { "byzantine", "Byzantine" }, { "cymric", "Cymric" },
	    { "cymric_early", "Cymric (early)" },
	    { "cymric_later", "Cymric (later)" }, { "danes", "Danes" },
	    { "french", "French" }, { "german", "German" }, { "hun", "Hun" },
	    { "irish_early", "Irish (early)" },
	    { "irish_late", "Irish (late)" }, { "italian", "Italian" },
	    { "occitanian", "Occitanian" }, { "pict_early", "Pict (early)" },
	    { "pict_late", "Pict (late)" }, { "roman_early", "Roman (early)" },
	    { "roman_late", "Roman (late)" },
	    { "saxon_early", "Saxon (early)" },
	    { "saxon_late", "Saxon (late)" }, { "spanish", "Spanish" },
	    { "zazamanc", "Zazamanc" },
    // END OF MATERIAL TO LOCALIZE
    };

    @Override
    public Object[][] getContents() {
	return contents;
    }
}