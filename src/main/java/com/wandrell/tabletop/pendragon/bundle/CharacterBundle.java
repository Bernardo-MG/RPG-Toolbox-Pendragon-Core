package com.wandrell.tabletop.pendragon.bundle;

import java.util.ListResourceBundle;

public class CharacterBundle extends ListResourceBundle {

    static final Object[][] contents = {
	    // LOCALIZE THIS
	    { CharacterBundleKeys.ATTRIBUTES, "Attributes" },
	    { CharacterBundleKeys.DERIVED_ATTRIBUTES, "Derived attributes" },
	    { CharacterBundleKeys.PASSIONS, "Passions" },
	    { CharacterBundleKeys.TRAITS, "Traits" },
	    { CharacterBundleKeys.GENDER, "Gender" },
	    { CharacterBundleKeys.SKILL, "Skill" },
	    { CharacterBundleKeys.SKILLS, "Skills" },
	    { CharacterBundleKeys.ATTRIBUTES_BONUS, "Attributes bonus" },
	    { CharacterBundleKeys.COMBAT_SKILLS, "Combat skills" },
	    { CharacterBundleKeys.DEX_MODIFIER, "Dexterity modifier" },
	    { CharacterBundleKeys.DERIVED_ATTRIBUTES_BONUS,
		    "Derived attributes bonus" },
	    { CharacterBundleKeys.DIRECTED_TRAITS, "Directed traits" },
	    { CharacterBundleKeys.DIRECTED_TRAITS_BONUS,
		    "Directed traits bonus" },
	    { CharacterBundleKeys.EXCLUSIVE_SKILLS, "Exclusive skills" },
	    { CharacterBundleKeys.FEMALE, "Female" },
	    { CharacterBundleKeys.MALE, "Male" },
	    { CharacterBundleKeys.SKILLS_BONUS, "Skills bonus" },
	    { CharacterBundleKeys.TRAITS_BONUS, "Traits bonus" },
	    { CharacterBundleKeys.ADVANCED_SKILLS, "Specialization skills" },
    // END OF MATERIAL TO LOCALIZE
    };

    @Override
    public Object[][] getContents() {
	return contents;
    }

}
