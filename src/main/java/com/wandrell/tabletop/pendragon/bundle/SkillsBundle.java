package com.wandrell.tabletop.pendragon.bundle;

import java.util.ListResourceBundle;

import com.wandrell.tabletop.pendragon.conf.PendragonLabels;

public class SkillsBundle extends ListResourceBundle {
    static final Object[][] contents = {
	    // LOCALIZE THIS
	    { PendragonLabels.SKILL_AWARENESS, "Awareness" },
	    { PendragonLabels.SKILL_BOATING, "Boating" },
	    { PendragonLabels.SKILL_CHIRURGERY, "Chirurgery" },
	    { PendragonLabels.SKILL_COMPOSE, "Compose" },
	    { PendragonLabels.SKILL_COURTESY, "Courtesy" },
	    { PendragonLabels.SKILL_DANCING, "Dancing" },
	    { PendragonLabels.ADVANCED_SKILL_DISTAFF, "Distaff" },
	    { PendragonLabels.SKILL_FAERIE_LORE, "Faerie Lore" },
	    { PendragonLabels.SKILL_FALCONRY, "Falconry" },
	    { PendragonLabels.SKILL_FASHION, "Fashion" },
	    { PendragonLabels.SKILL_FIRST_AID, "First Aid" },
	    { PendragonLabels.SKILL_FLIRTING, "Flirting" },
	    { PendragonLabels.SKILL_FOLKLORE, "Folklore" },
	    { PendragonLabels.SKILL_GAMING, "Gaming" },
	    { PendragonLabels.SKILL_HERALDRY, "Heraldry" },
	    { PendragonLabels.SKILL_HUNTING, "Hunting" },
	    { PendragonLabels.SKILL_INDUSTRY, "Industry" },
	    { PendragonLabels.SKILL_INTRIGUE, "Intrigue" },
	    { PendragonLabels.SKILL_ITALIAN_SKILL, "Italian skill" },
	    { PendragonLabels.ADVANCED_SKILL_LAW, "Law" },
	    { PendragonLabels.ADVANCED_SKILL_MANIPULATE, "Manipulate" },
	    { PendragonLabels.ADVANCED_SKILL_MEDICINE, "Medicine" },
	    { PendragonLabels.ADVANCED_SKILL_MUSIC, "Music" },
	    { PendragonLabels.ADVANCED_SKILL_NORDIC_CHARM, "Nordic Charm" },
	    { PendragonLabels.SKILL_ORATE, "Orate" },
	    { PendragonLabels.SKILL_PLAY, "Play" },
	    { PendragonLabels.ADVANCED_SKILL_PONY_DEFENSE, "Pony Defense" },
	    { PendragonLabels.SKILL_READ, "Read" },
	    { PendragonLabels.SKILL_RECOGNIZE, "Recognize" },
	    { PendragonLabels.SKILL_RELIGION, "Religion" },
	    { PendragonLabels.SKILL_ROMANCE, "Romance" },
	    { PendragonLabels.ADVANCED_SKILL_SEAMANSHIP, "Seamanship" },
	    { PendragonLabels.SKILL_SINGING, "Singing" },
	    { PendragonLabels.ADVANCED_SKILL_SPEAR_EXPERTISE, "Spear expertise" },
	    { PendragonLabels.ADVANCED_SKILL_STALK, "Stalk" },
	    { PendragonLabels.SKILL_STEWARDSHIP, "Stewardship" },
	    { PendragonLabels.SKILL_SWIMMING, "Swimming" },
	    { PendragonLabels.ADVANCED_SKILL_TACTICS, "Tactics" },
	    { PendragonLabels.SKILL_TOURNEY, "Tourney" },
	    { PendragonLabels.ADVANCED_SKILL_TWO_HANDED_WEAPONS,
		    "Two-Handed weapons" },
	    { PendragonLabels.ADVANCED_SKILL_VENERY, "Venery" },
	    { PendragonLabels.COMBAT_SKILL_AXE, "Axe" },
	    { PendragonLabels.COMBAT_SKILL_BATTLE, "Battle" },
	    { PendragonLabels.COMBAT_SKILL_BOW, "Bow" },
	    { PendragonLabels.COMBAT_SKILL_CHARIOTEER, "Charioteer" },
	    { PendragonLabels.COMBAT_SKILL_CROSSBOW, "Crossbow" },
	    { PendragonLabels.COMBAT_SKILL_COMPOUND_BOW, "Compound bow" },
	    { PendragonLabels.COMBAT_SKILL_DAGGER, "Dagger" },
	    { PendragonLabels.COMBAT_SKILL_FLAIL, "Flail" },
	    { PendragonLabels.COMBAT_SKILL_GRAPPLE, "Grapple" },
	    { PendragonLabels.COMBAT_SKILL_GREAT_AXE, "Great axe" },
	    { PendragonLabels.COMBAT_SKILL_GREAT_LANCE, "Great lance" },
	    { PendragonLabels.COMBAT_SKILL_GREAT_MACE, "Great mace" },
	    { PendragonLabels.COMBAT_SKILL_GREAT_SPEAR, "Great spear" },
	    { PendragonLabels.COMBAT_SKILL_GREAT_SWORD, "Great sword" },
	    { PendragonLabels.COMBAT_SKILL_HALBERD, "Halberd" },
	    { PendragonLabels.COMBAT_SKILL_HAMMER, "Hammer" },
	    { PendragonLabels.COMBAT_SKILL_HORSEMANSHIP, "Horsemanship" },
	    { PendragonLabels.COMBAT_SKILL_JAVELIN, "Javelin" },
	    { PendragonLabels.COMBAT_SKILL_LANCE, "Lance" },
	    { PendragonLabels.COMBAT_SKILL_MACE, "Mace" },
	    { PendragonLabels.COMBAT_SKILL_MORNING_STAR, "Morning star" },
	    { PendragonLabels.COMBAT_SKILL_SIEGE, "Siege" },
	    { PendragonLabels.COMBAT_SKILL_SPEAR, "Spear" },
	    { PendragonLabels.COMBAT_SKILL_SWORD, "Sword" },
	    { PendragonLabels.COMBAT_SKILL_WARFLAIL, "Warflail" },
    // END OF MATERIAL TO LOCALIZE
    };

    public SkillsBundle() {
	super();
    }

    @Override
    public Object[][] getContents() {
	return contents;
    }
}
