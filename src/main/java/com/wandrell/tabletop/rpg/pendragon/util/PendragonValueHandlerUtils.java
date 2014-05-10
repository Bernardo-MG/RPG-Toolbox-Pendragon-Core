package com.wandrell.tabletop.rpg.pendragon.util;

public class PendragonValueHandlerUtils {

    private static final String TEMPLATE_NAME_ANNOTATION_KEY = "%s : %s";

    public static String getNameAnnotationKey(final String name,
	    final String annotation) {
	return String.format(TEMPLATE_NAME_ANNOTATION_KEY, name, annotation);
    }

    /**
     * Private constructor to avoid instantiation.
     */
    private PendragonValueHandlerUtils() {
	super();
    }

}
