package com.wandrell.tabletop.pendragon.bundle;

import java.util.ListResourceBundle;

public class ReligionsBundle extends ListResourceBundle {
    static final Object[][] contents = {
	    // LOCALIZE THIS
	    { "arian_christian", "Arian Christian" },
	    { "british_christian", "British Christian" },
	    { "byzantine_orthodox", "Byzantine Orthodox" },
	    { "cathar", "Cathar" }, { "evil", "Evil" },
	    { "germanic_pagan", "Germanic Pagan" }, { "judaic", "Judaic" },
	    { "manicheist", "Manicheist" },
	    { "nomad_animist", "Nomad Animist" },
	    { "neoplatonist_christian", "Neoplatonist Christian" },
	    { "norse_pagan", "Norse Pagan" },
	    { "orthodox_christian", "Orthodox Christian" },
	    { "pagan", "Pagan" }, { "pict_heathen", "Pict Heathen" },
	    { "roman_christian", "Roman Christian" }, { "saracen", "Saracen" },
	    { "wotanic", "Wotanic" }
    // END OF MATERIAL TO LOCALIZE
    };

    @Override
    public Object[][] getContents() {
	return contents;
    }
}
