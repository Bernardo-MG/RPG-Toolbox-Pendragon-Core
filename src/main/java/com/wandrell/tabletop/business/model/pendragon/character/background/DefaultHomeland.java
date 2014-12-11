package com.wandrell.tabletop.business.model.pendragon.character.background;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public final class DefaultHomeland implements Homeland {

    private final String name;

    public DefaultHomeland(final String name) {
        super();

        checkNotNull(name, "Received a null pointer as name");

        this.name = name;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultHomeland other = (DefaultHomeland) obj;
        return Objects.equal(name, other.name);
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

}
