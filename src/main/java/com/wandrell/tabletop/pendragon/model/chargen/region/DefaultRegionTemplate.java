package com.wandrell.tabletop.pendragon.model.chargen.region;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.LinkedHashMap;
import java.util.Map;

public final class DefaultRegionTemplate implements RegionTemplate {

    private final String               regionName;
    private final Map<String, Integer> regionTraits = new LinkedHashMap<String, Integer>();

    public DefaultRegionTemplate(final String name,
            final Map<String, Integer> traits) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(traits, "Received a null pointer as traits");

        regionName = name;
        regionTraits.putAll(traits);
    }

    @Override
    public final String getName() {
        return regionName;
    }

    @Override
    public final Map<String, Integer> getTraits() {
        return regionTraits;
    }

}
