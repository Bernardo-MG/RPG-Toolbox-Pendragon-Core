package com.wandrell.tabletop.rpg.pendragon.bundle;

import java.util.ListResourceBundle;

public class AppearanceFeaturesBundle extends ListResourceBundle {
    static final Object[][] contents = {
	    // LOCALIZE THIS
	    { AppearanceFeaturesBundleKeys.BODY, "Body" },
	    {
		    AppearanceFeaturesBundleKeys.BODY_TEXT,
		    "slouched, barrel-chested, hunchback, finehaired, tall, thin, broad-shouldered, high-shouldered, very muscular, burly, squat, smooth skin, etc." },
	    { AppearanceFeaturesBundleKeys.EXPRESSION, "Facial Expression" },
	    {
		    AppearanceFeaturesBundleKeys.EXPRESSION_TEXT,
		    "bright-eyed, proud, sneering, haughty, nice smile, hidden by beard, straight teeth, dour, cheerful, squint, piercing glance, etc." },
	    { AppearanceFeaturesBundleKeys.FACIAL, "Facial Feature" },
	    {
		    AppearanceFeaturesBundleKeys.FACIAL_TEXT,
		    "patrician nose, scarred, darkly tanned, black eyes, bushy eyebrows, deep-set eyes, high cheekbones, red and weather-beaten skin, braided beard, big ears, long mustache, small nose, facial lemishes, birthmark, etc." },
	    { AppearanceFeaturesBundleKeys.HAIR, "Hair" },
	    {
		    AppearanceFeaturesBundleKeys.HAIR_TEXT,
		    "very long, curly, red, crew cut, blond, excessively hairy, huge beard, prematurely gray, glossy, balding, a particular cut, etc." },
	    { AppearanceFeaturesBundleKeys.LIMBS, "Limbs" },
	    {
		    AppearanceFeaturesBundleKeys.LIMBS_TEXT,
		    "short legs, bulging biceps, one arm longer than the other, rough hands, long nails, hairy arms and hands, bow-legged, flabby, big feet, long fingers, etc." },
	    { AppearanceFeaturesBundleKeys.SPEECH, "Speech" },
	    {
		    AppearanceFeaturesBundleKeys.SPEECH_TEXT,
		    "lisp, stutter, charming accent, basso, sharp, nasal, shrill, squeaky, musical, loud, soft, strong, thick accent, etc." },
    // END OF MATERIAL TO LOCALIZE
    };

    @Override
    public Object[][] getContents() {
	return contents;
    }
}
