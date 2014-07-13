package com.wandrell.tabletop.pendragon.bundle;

import java.util.ListResourceBundle;

public class AnimalsBundle extends ListResourceBundle {
    static final Object[][] contents = {
	    // LOCALIZE THIS
	    { "horse_biter_dog", "Horse Biter (dog)" },
	    { "keen_lead_dog", "Keen lead dog" },
	    { "loyal_mastiff_a_fighting_dog", "Loyal mastiff, a fighting dog" },
	    { "lucky_hunting_dog", "Lucky hunting dog" },
	    { "marvelous_goose", "Marvelous goose" },
	    { "mother_of_all_bitches", "Mother of all bitches" },
	    { "prestige_hound", "Prestige Hound" },
	    { "sprint_hound", "Sprint Hound" },
	    { "trained_hunting_cheetah", "Trained hunting cheetah" },
	    { "trained_wolf", "Trained wolf" }, { "war_hawk", "War hawk" },
	    { "war_hound", "War Hound" }, { "wonderful_cat", "Wonderful cat" },
    // END OF MATERIAL TO LOCALIZE
    };

    @Override
    public Object[][] getContents() {
	return contents;
    }
}
