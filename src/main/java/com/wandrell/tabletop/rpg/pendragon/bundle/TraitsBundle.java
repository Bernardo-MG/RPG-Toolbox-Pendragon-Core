package com.wandrell.tabletop.rpg.pendragon.bundle;

import java.util.ListResourceBundle;

public class TraitsBundle extends ListResourceBundle {
    static final Object[][] contents = {
	    // LOCALIZE THIS
	    { TraitsBundleKeys.ARBITRARY, "Arbitrary" },
	    { TraitsBundleKeys.CHASTE, "Chaste" },
	    { TraitsBundleKeys.COWARDLY, "Cowardly" },
	    { TraitsBundleKeys.CRUEL, "Cruel" },
	    { TraitsBundleKeys.DECEITFUL, "Deceitful" },
	    { TraitsBundleKeys.ENERGETIC, "Energetic" },
	    { TraitsBundleKeys.FORGIVING, "Forgiving" },
	    { TraitsBundleKeys.GENEROUS, "Generous" },
	    { TraitsBundleKeys.HONEST, "Honest" },
	    { TraitsBundleKeys.INDULGENT, "Indulgent" },
	    { TraitsBundleKeys.JUST, "Just" },
	    { TraitsBundleKeys.LAZY, "Lazy" },
	    { TraitsBundleKeys.LUSTFUL, "Lustful" },
	    { TraitsBundleKeys.MERCIFUL, "Merciful" },
	    { TraitsBundleKeys.MODEST, "Modest" },
	    { TraitsBundleKeys.PROUD, "Proud" },
	    { TraitsBundleKeys.PRUDENT, "Prudent" },
	    { TraitsBundleKeys.PIOUS, "Pious" },
	    { TraitsBundleKeys.RECKLESS, "Reckless" },
	    { TraitsBundleKeys.SELFISH, "Selfish" },
	    { TraitsBundleKeys.SUSPICIOUS, "Suspicious" },
	    { TraitsBundleKeys.TEMPERATE, "Temperate" },
	    { TraitsBundleKeys.TRUSTING, "Trusting" },
	    { TraitsBundleKeys.VALOROUS, "Valorous" },
	    { TraitsBundleKeys.VENGEFUL, "Vengeful" },
	    { TraitsBundleKeys.WORLDLY, "Worldly" },
    // END OF MATERIAL TO LOCALIZE
    };

    @Override
    public Object[][] getContents() {
	return contents;
    }

}
