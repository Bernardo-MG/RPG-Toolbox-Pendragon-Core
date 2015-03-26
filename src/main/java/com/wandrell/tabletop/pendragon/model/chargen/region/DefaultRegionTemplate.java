package com.wandrell.tabletop.pendragon.model.chargen.region;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.wandrell.tabletop.pendragon.model.character.stats.TraitsHolder;

public final class DefaultRegionTemplate implements RegionTemplate {

    private final String       regionName;
    private final TraitsHolder regionTraits;

    public DefaultRegionTemplate(final DefaultRegionTemplate region) {
        super();

        checkNotNull(region, "Received a null pointer as region");

        regionName = region.regionName;
        regionTraits = region.regionTraits;
    }

    public DefaultRegionTemplate(final String name, final TraitsHolder traits) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(traits, "Received a null pointer as traits");

        regionName = name;
        regionTraits = traits;
    }

    @Override
    public final DefaultRegionTemplate createNewInstance() {
        return new DefaultRegionTemplate(this);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultRegionTemplate other = (DefaultRegionTemplate) obj;
        return Objects.equal(regionName, other.regionName);
    }

    @Override
    public final String getName() {
        return regionName;
    }

    @Override
    public final TraitsHolder getTraits() {
        return regionTraits;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(regionName);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", regionName)
                .toString();
    }

}
